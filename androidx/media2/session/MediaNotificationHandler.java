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
import androidx.core.view.InputDeviceCompat;
import androidx.media.app.NotificationCompat;
import androidx.media2.common.MediaMetadata;
import androidx.media2.session.MediaSession;
import androidx.media2.session.MediaSessionService;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes.dex */
public class MediaNotificationHandler extends MediaSession.SessionCallback.ForegroundServiceEventCallback {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String NOTIFICATION_CHANNEL_ID = "default_channel_id";
    public static final int NOTIFICATION_ID = 1001;
    public transient /* synthetic */ FieldHolder $fh;
    public final String mNotificationChannelName;
    public final NotificationManager mNotificationManager;
    public final NotificationCompat.Action mPauseAction;
    public final NotificationCompat.Action mPlayAction;
    public final MediaSessionService mServiceInstance;
    public final NotificationCompat.Action mSkipToNextAction;
    public final NotificationCompat.Action mSkipToPrevAction;
    public final Intent mStartSelfIntent;

    public MediaNotificationHandler(MediaSessionService mediaSessionService) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mediaSessionService};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mServiceInstance = mediaSessionService;
        MediaSessionService mediaSessionService2 = this.mServiceInstance;
        this.mStartSelfIntent = new Intent(mediaSessionService2, mediaSessionService2.getClass());
        this.mNotificationManager = (NotificationManager) this.mServiceInstance.getSystemService(ActionJsonData.TAG_NOTIFICATION);
        this.mNotificationChannelName = this.mServiceInstance.getResources().getString(R.string.obfuscated_res_0x7f0f0495);
        this.mPlayAction = createNotificationAction(R.drawable.obfuscated_res_0x7f080d3e, R.string.obfuscated_res_0x7f0f0e87, 4L);
        this.mPauseAction = createNotificationAction(R.drawable.obfuscated_res_0x7f080d3d, R.string.obfuscated_res_0x7f0f0d67, 2L);
        this.mSkipToPrevAction = createNotificationAction(R.drawable.obfuscated_res_0x7f080d40, R.string.obfuscated_res_0x7f0f11a5, 16L);
        this.mSkipToNextAction = createNotificationAction(R.drawable.obfuscated_res_0x7f080d3f, R.string.obfuscated_res_0x7f0f11a4, 32L);
    }

    private NotificationCompat.Action createNotificationAction(int i, int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)})) == null) ? new NotificationCompat.Action(i, this.mServiceInstance.getResources().getText(i2), createPendingIntent(j)) : (NotificationCompat.Action) invokeCommon.objValue;
    }

    private PendingIntent createPendingIntent(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65538, this, j)) == null) {
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
        return (PendingIntent) invokeJ.objValue;
    }

    private void ensureNotificationChannel() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && Build.VERSION.SDK_INT >= 26 && this.mNotificationManager.getNotificationChannel(NOTIFICATION_CHANNEL_ID) == null) {
            this.mNotificationManager.createNotificationChannel(new NotificationChannel(NOTIFICATION_CHANNEL_ID, this.mNotificationChannelName, 2));
        }
    }

    private int getSmallIconResId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            int i = this.mServiceInstance.getApplicationInfo().icon;
            return i != 0 ? i : R.drawable.obfuscated_res_0x7f080d3c;
        }
        return invokeV.intValue;
    }

    public static boolean isPlaybackStopped(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i)) == null) ? i == 1 || i == 0 || i == 3 : invokeI.booleanValue;
    }

    private void stopForegroundServiceIfNeeded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            List<MediaSession> sessions = this.mServiceInstance.getSessions();
            for (int i = 0; i < sessions.size(); i++) {
                if (!isPlaybackStopped(sessions.get(i).getPlayer().getPlayerState())) {
                    return;
                }
            }
            this.mServiceInstance.stopForeground(Build.VERSION.SDK_INT < 21);
        }
    }

    @Override // androidx.media2.session.MediaSession.SessionCallback.ForegroundServiceEventCallback
    public void onPlayerStateChanged(MediaSession mediaSession, int i) {
        MediaSessionService.MediaNotification onUpdateNotification;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, mediaSession, i) == null) || (onUpdateNotification = this.mServiceInstance.onUpdateNotification(mediaSession)) == null) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaSession) == null) {
            this.mServiceInstance.removeSession(mediaSession);
            stopForegroundServiceIfNeeded();
        }
    }

    public MediaSessionService.MediaNotification onUpdateNotification(MediaSession mediaSession) {
        InterceptResult invokeL;
        MediaMetadata metadata;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mediaSession)) == null) {
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
        return (MediaSessionService.MediaNotification) invokeL.objValue;
    }
}
