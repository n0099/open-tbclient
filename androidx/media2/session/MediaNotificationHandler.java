package androidx.media2.session;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.media.session.MediaSession;
import android.os.Build;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.KeyEvent;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.media.app.NotificationCompat;
import androidx.media2.common.MediaMetadata;
import androidx.media2.session.MediaSession;
import androidx.media2.session.MediaSessionService;
import java.util.List;
/* loaded from: classes.dex */
public class MediaNotificationHandler extends MediaSession.SessionCallback.ForegroundServiceEventCallback {
    public static final String NOTIFICATION_CHANNEL_ID = "default_channel_id";
    public static final int NOTIFICATION_ID = 1001;
    public final String mNotificationChannelName;
    public final NotificationManager mNotificationManager;
    public final NotificationCompat.Action mPauseAction;
    public final NotificationCompat.Action mPlayAction;
    public final MediaSessionService mServiceInstance;
    public final NotificationCompat.Action mSkipToNextAction;
    public final NotificationCompat.Action mSkipToPrevAction;
    public final Intent mStartSelfIntent;

    public static boolean isPlaybackStopped(int i) {
        return i == 1 || i == 0 || i == 3;
    }

    public MediaNotificationHandler(MediaSessionService mediaSessionService) {
        this.mServiceInstance = mediaSessionService;
        MediaSessionService mediaSessionService2 = this.mServiceInstance;
        this.mStartSelfIntent = new Intent(mediaSessionService2, mediaSessionService2.getClass());
        this.mNotificationManager = (NotificationManager) this.mServiceInstance.getSystemService("notification");
        this.mNotificationChannelName = this.mServiceInstance.getResources().getString(com.baidu.tieba.R.string.default_notification_channel_name);
        this.mPlayAction = createNotificationAction(com.baidu.tieba.R.drawable.media_session_service_notification_ic_play, com.baidu.tieba.R.string.play_button_content_description, 4L);
        this.mPauseAction = createNotificationAction(com.baidu.tieba.R.drawable.media_session_service_notification_ic_pause, com.baidu.tieba.R.string.pause_button_content_description, 2L);
        this.mSkipToPrevAction = createNotificationAction(com.baidu.tieba.R.drawable.media_session_service_notification_ic_skip_to_previous, com.baidu.tieba.R.string.skip_to_previous_item_button_content_description, 16L);
        this.mSkipToNextAction = createNotificationAction(com.baidu.tieba.R.drawable.media_session_service_notification_ic_skip_to_next, com.baidu.tieba.R.string.skip_to_next_item_button_content_description, 32L);
    }

    private NotificationCompat.Action createNotificationAction(int i, int i2, long j) {
        return new NotificationCompat.Action(i, this.mServiceInstance.getResources().getText(i2), createPendingIntent(j));
    }

    private PendingIntent createPendingIntent(long j) {
        int keyCode = PlaybackStateCompat.toKeyCode(j);
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        MediaSessionService mediaSessionService = this.mServiceInstance;
        intent.setComponent(new ComponentName(mediaSessionService, mediaSessionService.getClass()));
        intent.putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(0, keyCode));
        if (Build.VERSION.SDK_INT >= 26 && j != 2) {
            return PendingIntent.getForegroundService(this.mServiceInstance, keyCode, intent, 0);
        }
        return PendingIntent.getService(this.mServiceInstance, keyCode, intent, 0);
    }

    private void ensureNotificationChannel() {
        if (Build.VERSION.SDK_INT >= 26 && this.mNotificationManager.getNotificationChannel(NOTIFICATION_CHANNEL_ID) == null) {
            this.mNotificationManager.createNotificationChannel(new NotificationChannel(NOTIFICATION_CHANNEL_ID, this.mNotificationChannelName, 2));
        }
    }

    private int getSmallIconResId() {
        int i = this.mServiceInstance.getApplicationInfo().icon;
        if (i != 0) {
            return i;
        }
        return com.baidu.tieba.R.drawable.media_session_service_notification_ic_music_note;
    }

    private void stopForegroundServiceIfNeeded() {
        List<MediaSession> sessions = this.mServiceInstance.getSessions();
        boolean z = false;
        for (int i = 0; i < sessions.size(); i++) {
            if (!isPlaybackStopped(sessions.get(i).getPlayer().getPlayerState())) {
                return;
            }
        }
        if (Build.VERSION.SDK_INT < 21) {
            z = true;
        }
        this.mServiceInstance.stopForeground(z);
    }

    @Override // androidx.media2.session.MediaSession.SessionCallback.ForegroundServiceEventCallback
    public void onPlayerStateChanged(MediaSession mediaSession, int i) {
        MediaSessionService.MediaNotification onUpdateNotification = this.mServiceInstance.onUpdateNotification(mediaSession);
        if (onUpdateNotification == null) {
            return;
        }
        int notificationId = onUpdateNotification.getNotificationId();
        Notification notification = onUpdateNotification.getNotification();
        if (Build.VERSION.SDK_INT >= 21) {
            notification.extras.putParcelable(NotificationCompat.EXTRA_MEDIA_SESSION, (MediaSession.Token) mediaSession.getSessionCompat().getSessionToken().getToken());
        }
        if (isPlaybackStopped(i)) {
            stopForegroundServiceIfNeeded();
            this.mNotificationManager.notify(notificationId, notification);
            return;
        }
        ContextCompat.startForegroundService(this.mServiceInstance, this.mStartSelfIntent);
        this.mServiceInstance.startForeground(notificationId, notification);
    }

    @Override // androidx.media2.session.MediaSession.SessionCallback.ForegroundServiceEventCallback
    public void onSessionClosed(MediaSession mediaSession) {
        this.mServiceInstance.removeSession(mediaSession);
        stopForegroundServiceIfNeeded();
    }

    public MediaSessionService.MediaNotification onUpdateNotification(MediaSession mediaSession) {
        MediaMetadata metadata;
        ensureNotificationChannel();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this.mServiceInstance, NOTIFICATION_CHANNEL_ID);
        builder.addAction(this.mSkipToPrevAction);
        if (mediaSession.getPlayer().getPlayerState() == 2) {
            builder.addAction(this.mPauseAction);
        } else {
            builder.addAction(this.mPlayAction);
        }
        builder.addAction(this.mSkipToNextAction);
        if (mediaSession.getPlayer().getCurrentMediaItem() != null && (metadata = mediaSession.getPlayer().getCurrentMediaItem().getMetadata()) != null) {
            CharSequence text = metadata.getText("android.media.metadata.DISPLAY_TITLE");
            if (text == null) {
                text = metadata.getText("android.media.metadata.TITLE");
            }
            builder.setContentTitle(text).setContentText(metadata.getText("android.media.metadata.ARTIST")).setLargeIcon(metadata.getBitmap("android.media.metadata.ALBUM_ART"));
        }
        return new MediaSessionService.MediaNotification(1001, builder.setContentIntent(mediaSession.getImpl().getSessionActivity()).setDeleteIntent(createPendingIntent(1L)).setOnlyAlertOnce(true).setSmallIcon(getSmallIconResId()).setStyle(new NotificationCompat.MediaStyle().setCancelButtonIntent(createPendingIntent(1L)).setMediaSession(mediaSession.getSessionCompat().getSessionToken()).setShowActionsInCompactView(1)).setVisibility(1).setOngoing(false).build());
    }
}
