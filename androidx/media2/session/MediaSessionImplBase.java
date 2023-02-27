package androidx.media2.session;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.concurrent.futures.AbstractResolvableFuture;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.util.ObjectsCompat;
import androidx.media.AudioAttributesCompat;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.VolumeProviderCompat;
import androidx.media2.common.BaseResult;
import androidx.media2.common.MediaItem;
import androidx.media2.common.MediaMetadata;
import androidx.media2.common.SessionPlayer;
import androidx.media2.common.SubtitleData;
import androidx.media2.common.VideoSize;
import androidx.media2.session.MediaController;
import androidx.media2.session.MediaSession;
import androidx.media2.session.RemoteSessionPlayer;
import androidx.media2.session.SequencedFutureManager;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class MediaSessionImplBase implements MediaSession.MediaSessionImpl {
    public static final String DEFAULT_MEDIA_SESSION_TAG_DELIM = ".";
    public static final String DEFAULT_MEDIA_SESSION_TAG_PREFIX = "androidx.media2.session.id";
    public static final int ITEM_NONE = -1;
    @GuardedBy("STATIC_LOCK")
    public static boolean sComponentNamesInitialized;
    @GuardedBy("STATIC_LOCK")
    public static ComponentName sServiceComponentName;
    public final AudioManager mAudioManager;
    public final BroadcastReceiver mBroadcastReceiver;
    @GuardedBy("mLock")
    public MediaBrowserServiceCompat mBrowserServiceLegacyStub;
    public final MediaSession.SessionCallback mCallback;
    public final Executor mCallbackExecutor;
    public final Context mContext;
    public final Handler mHandler;
    public final HandlerThread mHandlerThread;
    public final MediaSession mInstance;
    public final Object mLock = new Object();
    public final PendingIntent mMediaButtonIntent;
    @GuardedBy("mLock")
    public MediaController.PlaybackInfo mPlaybackInfo;
    @GuardedBy("mLock")
    public SessionPlayer mPlayer;
    public final SessionPlayerCallback mPlayerCallback;
    public final PendingIntent mSessionActivity;
    public final MediaSessionCompat mSessionCompat;
    public final String mSessionId;
    public final MediaSessionLegacyStub mSessionLegacyStub;
    public final MediaSessionStub mSessionStub;
    public final SessionToken mSessionToken;
    public final Uri mSessionUri;
    @Nullable
    @GuardedBy("mLock")
    public VolumeProviderCompat mVolumeProviderCompat;
    public static final Object STATIC_LOCK = new Object();
    public static final String TAG = "MSImplBase";
    public static final boolean DEBUG = Log.isLoggable(TAG, 3);
    public static final SessionResult RESULT_WHEN_CLOSED = new SessionResult(1);

    @FunctionalInterface
    /* loaded from: classes.dex */
    public interface PlayerTask<T> {
        T run(@NonNull SessionPlayer sessionPlayer) throws Exception;
    }

    @FunctionalInterface
    /* loaded from: classes.dex */
    public interface RemoteControllerTask {
        void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException;
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public void updatePlayer(@NonNull SessionPlayer sessionPlayer, @Nullable SessionPlayer sessionPlayer2) {
    }

    /* loaded from: classes.dex */
    public static final class CombinedCommandResultFuture<T extends BaseResult> extends AbstractResolvableFuture<T> {
        public final ListenableFuture<T>[] mFutures;
        public AtomicInteger mSuccessCount = new AtomicInteger(0);

        public CombinedCommandResultFuture(Executor executor, ListenableFuture<T>[] listenableFutureArr) {
            final int i = 0;
            this.mFutures = listenableFutureArr;
            while (true) {
                ListenableFuture<T>[] listenableFutureArr2 = this.mFutures;
                if (i < listenableFutureArr2.length) {
                    listenableFutureArr2[i].addListener(new Runnable() { // from class: androidx.media2.session.MediaSessionImplBase.CombinedCommandResultFuture.1
                        @Override // java.lang.Runnable
                        public void run() {
                            int i2 = 0;
                            try {
                                T t = CombinedCommandResultFuture.this.mFutures[i].get();
                                int resultCode = t.getResultCode();
                                if (resultCode != 0 && resultCode != 1) {
                                    for (int i3 = 0; i3 < CombinedCommandResultFuture.this.mFutures.length; i3++) {
                                        if (!CombinedCommandResultFuture.this.mFutures[i3].isCancelled() && !CombinedCommandResultFuture.this.mFutures[i3].isDone() && i != i3) {
                                            CombinedCommandResultFuture.this.mFutures[i3].cancel(true);
                                        }
                                    }
                                    CombinedCommandResultFuture.this.set(t);
                                } else if (CombinedCommandResultFuture.this.mSuccessCount.incrementAndGet() == CombinedCommandResultFuture.this.mFutures.length) {
                                    CombinedCommandResultFuture.this.set(t);
                                }
                            } catch (Exception e) {
                                while (true) {
                                    CombinedCommandResultFuture combinedCommandResultFuture = CombinedCommandResultFuture.this;
                                    ListenableFuture<T>[] listenableFutureArr3 = combinedCommandResultFuture.mFutures;
                                    if (i2 >= listenableFutureArr3.length) {
                                        combinedCommandResultFuture.setException(e);
                                        return;
                                    }
                                    if (!listenableFutureArr3[i2].isCancelled() && !CombinedCommandResultFuture.this.mFutures[i2].isDone() && i != i2) {
                                        CombinedCommandResultFuture.this.mFutures[i2].cancel(true);
                                    }
                                    i2++;
                                }
                            }
                        }
                    }, executor);
                    i++;
                } else {
                    return;
                }
            }
        }

        @SafeVarargs
        public static <U extends BaseResult> CombinedCommandResultFuture<U> create(Executor executor, ListenableFuture<U>... listenableFutureArr) {
            return new CombinedCommandResultFuture<>(executor, listenableFutureArr);
        }
    }

    /* loaded from: classes.dex */
    public final class MediaButtonReceiver extends BroadcastReceiver {
        public MediaButtonReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            KeyEvent keyEvent;
            if (!"android.intent.action.MEDIA_BUTTON".equals(intent.getAction()) || !ObjectsCompat.equals(intent.getData(), MediaSessionImplBase.this.mSessionUri) || (keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT")) == null) {
                return;
            }
            MediaSessionImplBase.this.getSessionCompat().getController().dispatchMediaButtonEvent(keyEvent);
        }
    }

    /* loaded from: classes.dex */
    public static class PlaylistItemListener implements MediaItem.OnMetadataChangedListener {
        public final WeakReference<MediaSessionImplBase> mSession;

        public PlaylistItemListener(MediaSessionImplBase mediaSessionImplBase) {
            this.mSession = new WeakReference<>(mediaSessionImplBase);
        }

        @Override // androidx.media2.common.MediaItem.OnMetadataChangedListener
        public void onMetadataChanged(@NonNull MediaItem mediaItem, MediaMetadata mediaMetadata) {
            final List<MediaItem> playlist;
            final MediaSessionImplBase mediaSessionImplBase = this.mSession.get();
            if (mediaSessionImplBase == null || mediaItem == null || (playlist = mediaSessionImplBase.getPlaylist()) == null) {
                return;
            }
            for (int i = 0; i < playlist.size(); i++) {
                if (mediaItem.equals(playlist.get(i))) {
                    mediaSessionImplBase.dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.PlaylistItemListener.1
                        @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                        public void run(MediaSession.ControllerCb controllerCb, int i2) throws RemoteException {
                            controllerCb.onPlaylistChanged(i2, playlist, mediaSessionImplBase.getPlaylistMetadata(), mediaSessionImplBase.getCurrentMediaItemIndex(), mediaSessionImplBase.getPreviousMediaItemIndex(), mediaSessionImplBase.getNextMediaItemIndex());
                        }
                    });
                    return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class SessionPlayerCallback extends RemoteSessionPlayer.Callback implements MediaItem.OnMetadataChangedListener {
        public List<MediaItem> mList;
        public MediaItem mMediaItem;
        public final PlaylistItemListener mPlaylistItemChangedListener;
        public final WeakReference<MediaSessionImplBase> mSession;

        public SessionPlayerCallback(MediaSessionImplBase mediaSessionImplBase) {
            this.mSession = new WeakReference<>(mediaSessionImplBase);
            this.mPlaylistItemChangedListener = new PlaylistItemListener(mediaSessionImplBase);
        }

        private void notifyCurrentMediaItemChanged(@Nullable final MediaItem mediaItem) {
            final MediaSessionImplBase session = getSession();
            if (session == null) {
                return;
            }
            dispatchRemoteControllerTask(session.getPlayer(), new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.15
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onCurrentMediaItemChanged(i, mediaItem, session.getCurrentMediaItemIndex(), session.getPreviousMediaItemIndex(), session.getNextMediaItemIndex());
                }
            });
        }

        private boolean updateCurrentMediaItemMetadataWithDuration(@NonNull SessionPlayer sessionPlayer) {
            MediaItem currentMediaItem = sessionPlayer.getCurrentMediaItem();
            if (currentMediaItem == null) {
                return false;
            }
            return updateCurrentMediaItemMetadataWithDuration(sessionPlayer, currentMediaItem, currentMediaItem.getMetadata());
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onPlaybackCompleted(@NonNull SessionPlayer sessionPlayer) {
            dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.9
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onPlaybackCompleted(i);
                }
            });
        }

        private void dispatchRemoteControllerTask(@NonNull SessionPlayer sessionPlayer, @NonNull RemoteControllerTask remoteControllerTask) {
            MediaSessionImplBase session = getSession();
            if (session != null && sessionPlayer != null && session.getPlayer() == sessionPlayer) {
                session.dispatchRemoteControllerTaskWithoutReturn(remoteControllerTask);
            }
        }

        @Override // androidx.media2.common.MediaItem.OnMetadataChangedListener
        public void onMetadataChanged(@NonNull MediaItem mediaItem, @Nullable MediaMetadata mediaMetadata) {
            MediaSessionImplBase session = getSession();
            if (session != null && !updateCurrentMediaItemMetadataWithDuration(session.getPlayer(), mediaItem, mediaMetadata)) {
                notifyCurrentMediaItemChanged(mediaItem);
            }
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onPlaybackSpeedChanged(@NonNull final SessionPlayer sessionPlayer, final float f) {
            dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.3
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onPlaybackSpeedChanged(i, SystemClock.elapsedRealtime(), sessionPlayer.getCurrentPosition(), f);
                }
            });
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onPlayerStateChanged(@NonNull final SessionPlayer sessionPlayer, final int i) {
            MediaSessionImplBase session = getSession();
            if (session != null && sessionPlayer != null && session.getPlayer() == sessionPlayer) {
                session.getCallback().onPlayerStateChanged(session.getInstance(), i);
                updateCurrentMediaItemMetadataWithDuration(sessionPlayer);
                session.dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.1
                    @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                    public void run(MediaSession.ControllerCb controllerCb, int i2) throws RemoteException {
                        controllerCb.onPlayerStateChanged(i2, SystemClock.elapsedRealtime(), sessionPlayer.getCurrentPosition(), i);
                    }
                });
            }
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onPlaylistMetadataChanged(@NonNull SessionPlayer sessionPlayer, final MediaMetadata mediaMetadata) {
            dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.6
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onPlaylistMetadataChanged(i, mediaMetadata);
                }
            });
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onRepeatModeChanged(@NonNull SessionPlayer sessionPlayer, final int i) {
            final MediaSessionImplBase session = getSession();
            dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.7
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i2) throws RemoteException {
                    controllerCb.onRepeatModeChanged(i2, i, session.getCurrentMediaItemIndex(), session.getPreviousMediaItemIndex(), session.getNextMediaItemIndex());
                }
            });
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onSeekCompleted(@NonNull final SessionPlayer sessionPlayer, final long j) {
            dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.4
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onSeekCompleted(i, SystemClock.elapsedRealtime(), sessionPlayer.getCurrentPosition(), j);
                }
            });
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onShuffleModeChanged(@NonNull SessionPlayer sessionPlayer, final int i) {
            final MediaSessionImplBase session = getSession();
            dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.8
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i2) throws RemoteException {
                    controllerCb.onShuffleModeChanged(i2, i, session.getCurrentMediaItemIndex(), session.getPreviousMediaItemIndex(), session.getNextMediaItemIndex());
                }
            });
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onTrackDeselected(@NonNull SessionPlayer sessionPlayer, @NonNull final SessionPlayer.TrackInfo trackInfo) {
            dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.13
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onTrackDeselected(i, MediaUtils.upcastForPreparceling(trackInfo));
                }
            });
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onTrackSelected(@NonNull SessionPlayer sessionPlayer, @NonNull final SessionPlayer.TrackInfo trackInfo) {
            dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.12
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onTrackSelected(i, MediaUtils.upcastForPreparceling(trackInfo));
                }
            });
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onTracksChanged(@NonNull SessionPlayer sessionPlayer, @NonNull final List<SessionPlayer.TrackInfo> list) {
            final MediaSessionImplBase session = getSession();
            dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.11
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onTracksChanged(i, MediaUtils.upcastForPreparceling(list), MediaUtils.upcastForPreparceling(session.getSelectedTrack(1)), MediaUtils.upcastForPreparceling(session.getSelectedTrack(2)), MediaUtils.upcastForPreparceling(session.getSelectedTrack(4)), MediaUtils.upcastForPreparceling(session.getSelectedTrack(5)));
                }
            });
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onVideoSizeChanged(@NonNull SessionPlayer sessionPlayer, @NonNull final VideoSize videoSize) {
            dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.10
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onVideoSizeChanged(i, MediaUtils.upcastForPreparceling(videoSize));
                }
            });
        }

        @Override // androidx.media2.session.RemoteSessionPlayer.Callback
        public void onVolumeChanged(@NonNull RemoteSessionPlayer remoteSessionPlayer, int i) {
            MediaSessionImplBase session = getSession();
            if (session == null) {
                return;
            }
            MediaController.PlaybackInfo createPlaybackInfo = session.createPlaybackInfo(remoteSessionPlayer, null);
            synchronized (session.mLock) {
                if (session.mPlayer != remoteSessionPlayer) {
                    return;
                }
                MediaController.PlaybackInfo playbackInfo = session.mPlaybackInfo;
                session.mPlaybackInfo = createPlaybackInfo;
                VolumeProviderCompat volumeProviderCompat = session.mVolumeProviderCompat;
                if (!ObjectsCompat.equals(createPlaybackInfo, playbackInfo)) {
                    session.notifyPlaybackInfoChangedNotLocked(createPlaybackInfo);
                }
                if (volumeProviderCompat != null) {
                    volumeProviderCompat.setCurrentVolume(i);
                }
            }
        }

        private MediaSessionImplBase getSession() {
            MediaSessionImplBase mediaSessionImplBase = this.mSession.get();
            if (mediaSessionImplBase == null && MediaSessionImplBase.DEBUG) {
                Log.d(MediaSessionImplBase.TAG, "Session is closed", new IllegalStateException());
            }
            return mediaSessionImplBase;
        }

        private boolean updateCurrentMediaItemMetadataWithDuration(@NonNull SessionPlayer sessionPlayer, @NonNull MediaItem mediaItem, @Nullable MediaMetadata mediaMetadata) {
            long duration = sessionPlayer.getDuration();
            if (mediaItem == sessionPlayer.getCurrentMediaItem() && sessionPlayer.getPlayerState() != 0 && duration > 0 && duration != Long.MIN_VALUE) {
                MediaMetadata mediaMetadata2 = null;
                if (mediaMetadata != null) {
                    if (!mediaMetadata.containsKey("android.media.metadata.DURATION")) {
                        mediaMetadata2 = new MediaMetadata.Builder(mediaMetadata).putLong("android.media.metadata.DURATION", duration).putLong(MediaMetadata.METADATA_KEY_PLAYABLE, 1L).build();
                    } else {
                        long j = mediaMetadata.getLong("android.media.metadata.DURATION");
                        if (duration != j) {
                            Log.w(MediaSessionImplBase.TAG, "duration mismatch for an item. duration from player=" + duration + " duration from metadata=" + j + ". May be a timing issue?");
                        }
                    }
                } else {
                    mediaMetadata2 = new MediaMetadata.Builder().putLong("android.media.metadata.DURATION", duration).putString("android.media.metadata.MEDIA_ID", mediaItem.getMediaId()).putLong(MediaMetadata.METADATA_KEY_PLAYABLE, 1L).build();
                }
                if (mediaMetadata2 != null) {
                    mediaItem.setMetadata(mediaMetadata2);
                    return true;
                }
                return false;
            }
            return false;
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onAudioAttributesChanged(@NonNull SessionPlayer sessionPlayer, AudioAttributesCompat audioAttributesCompat) {
            MediaController.PlaybackInfo playbackInfo;
            AudioAttributesCompat audioAttributes;
            MediaSessionImplBase session = getSession();
            if (session != null && sessionPlayer != null && session.getPlayer() == sessionPlayer) {
                MediaController.PlaybackInfo createPlaybackInfo = session.createPlaybackInfo(sessionPlayer, audioAttributesCompat);
                synchronized (session.mLock) {
                    playbackInfo = session.mPlaybackInfo;
                    session.mPlaybackInfo = createPlaybackInfo;
                }
                if (!ObjectsCompat.equals(createPlaybackInfo, playbackInfo)) {
                    session.notifyPlaybackInfoChangedNotLocked(createPlaybackInfo);
                    if (!(sessionPlayer instanceof RemoteSessionPlayer)) {
                        if (playbackInfo == null) {
                            audioAttributes = null;
                        } else {
                            audioAttributes = playbackInfo.getAudioAttributes();
                        }
                        int legacyStreamType = MediaSessionImplBase.getLegacyStreamType(audioAttributes);
                        int legacyStreamType2 = MediaSessionImplBase.getLegacyStreamType(createPlaybackInfo.getAudioAttributes());
                        if (legacyStreamType != legacyStreamType2) {
                            session.getSessionCompat().setPlaybackToLocal(legacyStreamType2);
                        }
                    }
                }
            }
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onBufferingStateChanged(@NonNull final SessionPlayer sessionPlayer, final MediaItem mediaItem, final int i) {
            updateCurrentMediaItemMetadataWithDuration(sessionPlayer);
            dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.2
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i2) throws RemoteException {
                    controllerCb.onBufferingStateChanged(i2, mediaItem, i, sessionPlayer.getBufferedPosition(), SystemClock.elapsedRealtime(), sessionPlayer.getCurrentPosition());
                }
            });
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onCurrentMediaItemChanged(@NonNull SessionPlayer sessionPlayer, @NonNull MediaItem mediaItem) {
            MediaSessionImplBase session = getSession();
            if (session != null && sessionPlayer != null && session.getPlayer() == sessionPlayer) {
                synchronized (session.mLock) {
                    if (this.mMediaItem != null) {
                        this.mMediaItem.removeOnMetadataChangedListener(this);
                    }
                    if (mediaItem != null) {
                        mediaItem.addOnMetadataChangedListener(session.mCallbackExecutor, this);
                    }
                    this.mMediaItem = mediaItem;
                }
                boolean z = false;
                if (mediaItem != null) {
                    z = updateCurrentMediaItemMetadataWithDuration(sessionPlayer, mediaItem, mediaItem.getMetadata());
                }
                if (!z) {
                    notifyCurrentMediaItemChanged(mediaItem);
                }
            }
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onPlaylistChanged(@NonNull SessionPlayer sessionPlayer, final List<MediaItem> list, final MediaMetadata mediaMetadata) {
            final MediaSessionImplBase session = getSession();
            if (session != null && sessionPlayer != null && session.getPlayer() == sessionPlayer) {
                synchronized (session.mLock) {
                    if (this.mList != null) {
                        for (int i = 0; i < this.mList.size(); i++) {
                            this.mList.get(i).removeOnMetadataChangedListener(this.mPlaylistItemChangedListener);
                        }
                    }
                    if (list != null) {
                        for (int i2 = 0; i2 < list.size(); i2++) {
                            list.get(i2).addOnMetadataChangedListener(session.mCallbackExecutor, this.mPlaylistItemChangedListener);
                        }
                    }
                    this.mList = list;
                }
                dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.5
                    @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                    public void run(MediaSession.ControllerCb controllerCb, int i3) throws RemoteException {
                        controllerCb.onPlaylistChanged(i3, list, mediaMetadata, session.getCurrentMediaItemIndex(), session.getPreviousMediaItemIndex(), session.getNextMediaItemIndex());
                    }
                });
            }
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onSubtitleData(@NonNull SessionPlayer sessionPlayer, @NonNull final MediaItem mediaItem, @NonNull final SessionPlayer.TrackInfo trackInfo, @NonNull final SubtitleData subtitleData) {
            dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.14
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onSubtitleData(i, mediaItem, trackInfo, subtitleData);
                }
            });
        }
    }

    @Nullable
    private MediaItem getCurrentMediaItemOrNull() {
        SessionPlayer sessionPlayer;
        synchronized (this.mLock) {
            sessionPlayer = this.mPlayer;
        }
        if (sessionPlayer != null) {
            return sessionPlayer.getCurrentMediaItem();
        }
        return null;
    }

    @Nullable
    private List<MediaItem> getPlaylistOrNull() {
        SessionPlayer sessionPlayer;
        synchronized (this.mLock) {
            sessionPlayer = this.mPlayer;
        }
        if (sessionPlayer != null) {
            return sessionPlayer.getPlaylist();
        }
        return null;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaybackControl
    public long getBufferedPosition() {
        return ((Long) dispatchPlayerTask(new PlayerTask<Long>() { // from class: androidx.media2.session.MediaSessionImplBase.14
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public Long run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                if (MediaSessionImplBase.this.isInPlaybackState(sessionPlayer)) {
                    return Long.valueOf(sessionPlayer.getBufferedPosition());
                }
                return null;
            }
        }, Long.MIN_VALUE)).longValue();
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaybackControl
    public int getBufferingState() {
        return ((Integer) dispatchPlayerTask(new PlayerTask<Integer>() { // from class: androidx.media2.session.MediaSessionImplBase.15
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public Integer run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return Integer.valueOf(sessionPlayer.getBufferingState());
            }
        }, 0)).intValue();
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public MediaSession.SessionCallback getCallback() {
        return this.mCallback;
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public Executor getCallbackExecutor() {
        return this.mCallbackExecutor;
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    @NonNull
    public List<MediaSession.ControllerInfo> getConnectedControllers() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.mSessionStub.getConnectedControllersManager().getConnectedControllers());
        arrayList.addAll(this.mSessionLegacyStub.getConnectedControllersManager().getConnectedControllers());
        return arrayList;
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public Context getContext() {
        return this.mContext;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public MediaItem getCurrentMediaItem() {
        return (MediaItem) dispatchPlayerTask(new PlayerTask<MediaItem>() { // from class: androidx.media2.session.MediaSessionImplBase.29
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public MediaItem run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return sessionPlayer.getCurrentMediaItem();
            }
        }, null);
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public int getCurrentMediaItemIndex() {
        return ((Integer) dispatchPlayerTask(new PlayerTask<Integer>() { // from class: androidx.media2.session.MediaSessionImplBase.30
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public Integer run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return Integer.valueOf(sessionPlayer.getCurrentMediaItemIndex());
            }
        }, -1)).intValue();
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaybackControl
    public long getCurrentPosition() {
        return ((Long) dispatchPlayerTask(new PlayerTask<Long>() { // from class: androidx.media2.session.MediaSessionImplBase.12
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public Long run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                if (MediaSessionImplBase.this.isInPlaybackState(sessionPlayer)) {
                    return Long.valueOf(sessionPlayer.getCurrentPosition());
                }
                return null;
            }
        }, Long.MIN_VALUE)).longValue();
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaybackControl
    public long getDuration() {
        return ((Long) dispatchPlayerTask(new PlayerTask<Long>() { // from class: androidx.media2.session.MediaSessionImplBase.13
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public Long run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                if (MediaSessionImplBase.this.isInPlaybackState(sessionPlayer)) {
                    return Long.valueOf(sessionPlayer.getDuration());
                }
                return null;
            }
        }, Long.MIN_VALUE)).longValue();
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    @NonNull
    public String getId() {
        return this.mSessionId;
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    @NonNull
    public MediaSession getInstance() {
        return this.mInstance;
    }

    public MediaBrowserServiceCompat getLegacyBrowserService() {
        MediaBrowserServiceCompat mediaBrowserServiceCompat;
        synchronized (this.mLock) {
            mediaBrowserServiceCompat = this.mBrowserServiceLegacyStub;
        }
        return mediaBrowserServiceCompat;
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public IBinder getLegacyBrowserServiceBinder() {
        MediaBrowserServiceCompat mediaBrowserServiceCompat;
        synchronized (this.mLock) {
            if (this.mBrowserServiceLegacyStub == null) {
                this.mBrowserServiceLegacyStub = createLegacyBrowserService(this.mContext, this.mSessionToken, this.mSessionCompat.getSessionToken());
            }
            mediaBrowserServiceCompat = this.mBrowserServiceLegacyStub;
        }
        return mediaBrowserServiceCompat.onBind(new Intent(MediaBrowserServiceCompat.SERVICE_INTERFACE));
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public int getNextMediaItemIndex() {
        return ((Integer) dispatchPlayerTask(new PlayerTask<Integer>() { // from class: androidx.media2.session.MediaSessionImplBase.32
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public Integer run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return Integer.valueOf(sessionPlayer.getNextMediaItemIndex());
            }
        }, -1)).intValue();
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public MediaController.PlaybackInfo getPlaybackInfo() {
        MediaController.PlaybackInfo playbackInfo;
        synchronized (this.mLock) {
            playbackInfo = this.mPlaybackInfo;
        }
        return playbackInfo;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaybackControl
    public float getPlaybackSpeed() {
        return ((Float) dispatchPlayerTask(new PlayerTask<Float>() { // from class: androidx.media2.session.MediaSessionImplBase.16
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public Float run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                if (MediaSessionImplBase.this.isInPlaybackState(sessionPlayer)) {
                    return Float.valueOf(sessionPlayer.getPlaybackSpeed());
                }
                return null;
            }
        }, Float.valueOf(1.0f))).floatValue();
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    @NonNull
    public SessionPlayer getPlayer() {
        SessionPlayer sessionPlayer;
        synchronized (this.mLock) {
            sessionPlayer = this.mPlayer;
        }
        return sessionPlayer;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaybackControl
    public int getPlayerState() {
        return ((Integer) dispatchPlayerTask(new PlayerTask<Integer>() { // from class: androidx.media2.session.MediaSessionImplBase.11
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public Integer run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return Integer.valueOf(sessionPlayer.getPlayerState());
            }
        }, 3)).intValue();
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public List<MediaItem> getPlaylist() {
        return (List) dispatchPlayerTask(new PlayerTask<List<MediaItem>>() { // from class: androidx.media2.session.MediaSessionImplBase.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public List<MediaItem> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return sessionPlayer.getPlaylist();
            }
        }, null);
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public MediaMetadata getPlaylistMetadata() {
        return (MediaMetadata) dispatchPlayerTask(new PlayerTask<MediaMetadata>() { // from class: androidx.media2.session.MediaSessionImplBase.24
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public MediaMetadata run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return sessionPlayer.getPlaylistMetadata();
            }
        }, null);
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public int getPreviousMediaItemIndex() {
        return ((Integer) dispatchPlayerTask(new PlayerTask<Integer>() { // from class: androidx.media2.session.MediaSessionImplBase.31
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public Integer run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return Integer.valueOf(sessionPlayer.getPreviousMediaItemIndex());
            }
        }, -1)).intValue();
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public int getRepeatMode() {
        return ((Integer) dispatchPlayerTask(new PlayerTask<Integer>() { // from class: androidx.media2.session.MediaSessionImplBase.34
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public Integer run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return Integer.valueOf(sessionPlayer.getRepeatMode());
            }
        }, 0)).intValue();
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public PendingIntent getSessionActivity() {
        return this.mSessionActivity;
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public MediaSessionCompat getSessionCompat() {
        return this.mSessionCompat;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public int getShuffleMode() {
        return ((Integer) dispatchPlayerTask(new PlayerTask<Integer>() { // from class: androidx.media2.session.MediaSessionImplBase.36
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public Integer run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return Integer.valueOf(sessionPlayer.getShuffleMode());
            }
        }, 0)).intValue();
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    @NonNull
    public SessionToken getToken() {
        return this.mSessionToken;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlayer
    public List<SessionPlayer.TrackInfo> getTracks() {
        return (List) dispatchPlayerTask(new PlayerTask<List<SessionPlayer.TrackInfo>>() { // from class: androidx.media2.session.MediaSessionImplBase.40
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public List<SessionPlayer.TrackInfo> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return MediaUtils.upcastForPreparceling(sessionPlayer.getTracks());
            }
        }, null);
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    @NonNull
    public Uri getUri() {
        return this.mSessionUri;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlayer
    public VideoSize getVideoSize() {
        return (VideoSize) dispatchPlayerTask(new PlayerTask<VideoSize>() { // from class: androidx.media2.session.MediaSessionImplBase.38
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public VideoSize run(@NonNull SessionPlayer sessionPlayer) {
                return MediaUtils.upcastForPreparceling(sessionPlayer.getVideoSize());
            }
        }, new VideoSize(0, 0));
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public boolean isClosed() {
        return !this.mHandlerThread.isAlive();
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaybackControl
    public ListenableFuture<SessionPlayer.PlayerResult> pause() {
        return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.8
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return sessionPlayer.pause();
            }
        });
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaybackControl
    public ListenableFuture<SessionPlayer.PlayerResult> play() {
        return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.7
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                if (sessionPlayer.getPlayerState() != 0) {
                    return sessionPlayer.play();
                }
                ListenableFuture<SessionPlayer.PlayerResult> prepare = sessionPlayer.prepare();
                ListenableFuture<SessionPlayer.PlayerResult> play = sessionPlayer.play();
                if (prepare != null && play != null) {
                    return CombinedCommandResultFuture.create(MediaUtils.DIRECT_EXECUTOR, prepare, play);
                }
                return null;
            }
        });
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaybackControl
    public ListenableFuture<SessionPlayer.PlayerResult> prepare() {
        return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.9
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return sessionPlayer.prepare();
            }
        });
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public ListenableFuture<SessionPlayer.PlayerResult> skipToNextItem() {
        return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.23
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return sessionPlayer.skipToNextPlaylistItem();
            }
        });
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public ListenableFuture<SessionPlayer.PlayerResult> skipToPreviousItem() {
        return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.22
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return sessionPlayer.skipToPreviousPlaylistItem();
            }
        });
    }

    public MediaSessionImplBase(MediaSession mediaSession, Context context, String str, SessionPlayer sessionPlayer, PendingIntent pendingIntent, Executor executor, MediaSession.SessionCallback sessionCallback, Bundle bundle) {
        ComponentName componentName;
        ComponentName componentName2;
        this.mContext = context;
        this.mInstance = mediaSession;
        HandlerThread handlerThread = new HandlerThread("MediaSession_Thread");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
        this.mSessionStub = new MediaSessionStub(this);
        this.mSessionActivity = pendingIntent;
        this.mCallback = sessionCallback;
        this.mCallbackExecutor = executor;
        this.mAudioManager = (AudioManager) context.getSystemService("audio");
        this.mPlayerCallback = new SessionPlayerCallback(this);
        this.mSessionId = str;
        this.mSessionUri = new Uri.Builder().scheme(MediaSessionImplBase.class.getName()).appendPath(str).appendPath(String.valueOf(SystemClock.elapsedRealtime())).build();
        this.mSessionToken = new SessionToken(new SessionTokenImplBase(Process.myUid(), 0, context.getPackageName(), this.mSessionStub, bundle));
        String join = TextUtils.join(".", new String[]{DEFAULT_MEDIA_SESSION_TAG_PREFIX, str});
        synchronized (STATIC_LOCK) {
            if (!sComponentNamesInitialized) {
                ComponentName serviceComponentByAction = getServiceComponentByAction(MediaLibraryService.SERVICE_INTERFACE);
                sServiceComponentName = serviceComponentByAction;
                if (serviceComponentByAction == null) {
                    sServiceComponentName = getServiceComponentByAction(MediaSessionService.SERVICE_INTERFACE);
                }
                sComponentNamesInitialized = true;
            }
            componentName = sServiceComponentName;
        }
        if (componentName == null) {
            Intent intent = new Intent("android.intent.action.MEDIA_BUTTON", this.mSessionUri);
            intent.setPackage(context.getPackageName());
            this.mMediaButtonIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
            ComponentName componentName3 = new ComponentName(context, context.getClass());
            this.mBroadcastReceiver = new MediaButtonReceiver();
            IntentFilter intentFilter = new IntentFilter("android.intent.action.MEDIA_BUTTON");
            intentFilter.addDataScheme(this.mSessionUri.getScheme());
            context.registerReceiver(this.mBroadcastReceiver, intentFilter);
            componentName2 = componentName3;
        } else {
            Intent intent2 = new Intent("android.intent.action.MEDIA_BUTTON", this.mSessionUri);
            intent2.setComponent(componentName);
            if (Build.VERSION.SDK_INT >= 26) {
                this.mMediaButtonIntent = PendingIntent.getForegroundService(this.mContext, 0, intent2, 0);
            } else {
                this.mMediaButtonIntent = PendingIntent.getService(this.mContext, 0, intent2, 0);
            }
            this.mBroadcastReceiver = null;
            componentName2 = componentName;
        }
        this.mSessionCompat = new MediaSessionCompat(context, join, componentName2, this.mMediaButtonIntent, this.mSessionToken.getExtras(), this.mSessionToken);
        this.mSessionLegacyStub = new MediaSessionLegacyStub(this, this.mHandler);
        this.mSessionCompat.setSessionActivity(pendingIntent);
        this.mSessionCompat.setFlags(4);
        updatePlayer(sessionPlayer);
        this.mSessionCompat.setCallback(this.mSessionLegacyStub, this.mHandler);
        this.mSessionCompat.setActive(true);
    }

    public static VolumeProviderCompat createVolumeProviderCompat(@NonNull final RemoteSessionPlayer remoteSessionPlayer) {
        return new VolumeProviderCompat(remoteSessionPlayer.getVolumeControlType(), remoteSessionPlayer.getMaxVolume(), remoteSessionPlayer.getVolume()) { // from class: androidx.media2.session.MediaSessionImplBase.53
            @Override // androidx.media.VolumeProviderCompat
            public void onAdjustVolume(int i) {
                remoteSessionPlayer.adjustVolume(i);
            }

            @Override // androidx.media.VolumeProviderCompat
            public void onSetVolumeTo(int i) {
                remoteSessionPlayer.setVolume(i);
            }
        };
    }

    private ListenableFuture<SessionPlayer.PlayerResult> dispatchPlayerTask(@NonNull PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>> playerTask) {
        ResolvableFuture create = ResolvableFuture.create();
        create.set(new SessionPlayer.PlayerResult(-2, null));
        return (ListenableFuture) dispatchPlayerTask(playerTask, create);
    }

    public static int getLegacyStreamType(@Nullable AudioAttributesCompat audioAttributesCompat) {
        int legacyStreamType;
        if (audioAttributesCompat == null || (legacyStreamType = audioAttributesCompat.getLegacyStreamType()) == Integer.MIN_VALUE) {
            return 3;
        }
        return legacyStreamType;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlayer
    public ListenableFuture<SessionPlayer.PlayerResult> deselectTrack(final SessionPlayer.TrackInfo trackInfo) {
        return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.42
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return sessionPlayer.deselectTrack(trackInfo);
            }
        });
    }

    public void dispatchRemoteControllerTaskWithoutReturn(@NonNull RemoteControllerTask remoteControllerTask) {
        List<MediaSession.ControllerInfo> connectedControllers = this.mSessionStub.getConnectedControllersManager().getConnectedControllers();
        for (int i = 0; i < connectedControllers.size(); i++) {
            dispatchRemoteControllerTaskWithoutReturn(connectedControllers.get(i), remoteControllerTask);
        }
        try {
            remoteControllerTask.run(this.mSessionLegacyStub.getControllerLegacyCbForBroadcast(), 0);
        } catch (RemoteException e) {
            Log.e(TAG, "Exception in using media1 API", e);
        }
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlayer
    public SessionPlayer.TrackInfo getSelectedTrack(final int i) {
        return (SessionPlayer.TrackInfo) dispatchPlayerTask(new PlayerTask<SessionPlayer.TrackInfo>() { // from class: androidx.media2.session.MediaSessionImplBase.43
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public SessionPlayer.TrackInfo run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return MediaUtils.upcastForPreparceling(sessionPlayer.getSelectedTrack(i));
            }
        }, null);
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public boolean isConnected(@NonNull MediaSession.ControllerInfo controllerInfo) {
        if (controllerInfo == null) {
            return false;
        }
        if (!this.mSessionStub.getConnectedControllersManager().isConnected(controllerInfo) && !this.mSessionLegacyStub.getConnectedControllersManager().isConnected(controllerInfo)) {
            return false;
        }
        return true;
    }

    public boolean isInPlaybackState(@NonNull SessionPlayer sessionPlayer) {
        if (!isClosed() && sessionPlayer.getPlayerState() != 0 && sessionPlayer.getPlayerState() != 3) {
            return true;
        }
        return false;
    }

    public void notifyPlaybackInfoChangedNotLocked(final MediaController.PlaybackInfo playbackInfo) {
        dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.52
            @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
            public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                controllerCb.onPlaybackInfoChanged(i, playbackInfo);
            }
        });
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public ListenableFuture<SessionPlayer.PlayerResult> removePlaylistItem(final int i) {
        if (i >= 0) {
            return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.26
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                    if (i >= sessionPlayer.getPlaylist().size()) {
                        return SessionPlayer.PlayerResult.createFuture(-3);
                    }
                    return sessionPlayer.removePlaylistItem(i);
                }
            });
        }
        throw new IllegalArgumentException("index shouldn't be negative");
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaybackControl
    public ListenableFuture<SessionPlayer.PlayerResult> seekTo(final long j) {
        return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.10
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return sessionPlayer.seekTo(j);
            }
        });
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlayer
    public ListenableFuture<SessionPlayer.PlayerResult> selectTrack(final SessionPlayer.TrackInfo trackInfo) {
        return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.41
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return sessionPlayer.selectTrack(trackInfo);
            }
        });
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public void setLegacyControllerConnectionTimeoutMs(long j) {
        this.mSessionLegacyStub.setLegacyControllerDisconnectTimeoutMs(j);
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public ListenableFuture<SessionPlayer.PlayerResult> setMediaItem(@NonNull final MediaItem mediaItem) {
        if (mediaItem != null) {
            return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.20
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                    return sessionPlayer.setMediaItem(mediaItem);
                }
            });
        }
        throw new NullPointerException("item shouldn't be null");
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaybackControl
    public ListenableFuture<SessionPlayer.PlayerResult> setPlaybackSpeed(final float f) {
        return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.17
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return sessionPlayer.setPlaybackSpeed(f);
            }
        });
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public ListenableFuture<SessionPlayer.PlayerResult> setRepeatMode(final int i) {
        return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.35
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return sessionPlayer.setRepeatMode(i);
            }
        });
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public ListenableFuture<SessionPlayer.PlayerResult> setShuffleMode(final int i) {
        return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.37
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return sessionPlayer.setShuffleMode(i);
            }
        });
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlayer
    public ListenableFuture<SessionPlayer.PlayerResult> setSurface(final Surface surface) {
        return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.39
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) {
                return sessionPlayer.setSurface(surface);
            }
        });
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public ListenableFuture<SessionPlayer.PlayerResult> skipToPlaylistItem(final int i) {
        if (i >= 0) {
            return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.21
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                    if (i >= sessionPlayer.getPlaylist().size()) {
                        return SessionPlayer.PlayerResult.createFuture(-3);
                    }
                    return sessionPlayer.skipToPlaylistItem(i);
                }
            });
        }
        throw new IllegalArgumentException("index shouldn't be negative");
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public ListenableFuture<SessionPlayer.PlayerResult> updatePlaylistMetadata(@Nullable final MediaMetadata mediaMetadata) {
        return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.33
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
            public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                return sessionPlayer.updatePlaylistMetadata(mediaMetadata);
            }
        });
    }

    private <T> T dispatchPlayerTask(@NonNull PlayerTask<T> playerTask, T t) {
        SessionPlayer sessionPlayer;
        synchronized (this.mLock) {
            sessionPlayer = this.mPlayer;
        }
        try {
            if (!isClosed()) {
                T run = playerTask.run(sessionPlayer);
                if (run != null) {
                    return run;
                }
            } else if (DEBUG) {
                Log.d(TAG, "API calls after the close()", new IllegalStateException());
            }
        } catch (Exception unused) {
        }
        return t;
    }

    private void onDeadObjectException(MediaSession.ControllerInfo controllerInfo, DeadObjectException deadObjectException) {
        if (DEBUG) {
            Log.d(TAG, controllerInfo.toString() + " is gone", deadObjectException);
        }
        this.mSessionStub.getConnectedControllersManager().removeController(controllerInfo);
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public ListenableFuture<SessionPlayer.PlayerResult> addPlaylistItem(final int i, @NonNull final MediaItem mediaItem) {
        if (i >= 0) {
            if (mediaItem != null) {
                return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.25
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                    public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                        return sessionPlayer.addPlaylistItem(i, mediaItem);
                    }
                });
            }
            throw new NullPointerException("item shouldn't be null");
        }
        throw new IllegalArgumentException("index shouldn't be negative");
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public void broadcastCustomCommand(@NonNull final SessionCommand sessionCommand, @Nullable final Bundle bundle) {
        dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.5
            @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
            public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                controllerCb.sendCustomCommand(i, sessionCommand, bundle);
            }
        });
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public ListenableFuture<SessionPlayer.PlayerResult> movePlaylistItem(final int i, final int i2) {
        if (i >= 0 && i2 >= 0) {
            return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.28
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                    return sessionPlayer.movePlaylistItem(i, i2);
                }
            });
        }
        throw new IllegalArgumentException("indices shouldn't be negative");
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public ListenableFuture<SessionPlayer.PlayerResult> replacePlaylistItem(final int i, @NonNull final MediaItem mediaItem) {
        if (i >= 0) {
            if (mediaItem != null) {
                return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.27
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                    public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                        return sessionPlayer.replacePlaylistItem(i, mediaItem);
                    }
                });
            }
            throw new NullPointerException("item shouldn't be null");
        }
        throw new IllegalArgumentException("index shouldn't be negative");
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public void setAllowedCommands(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull final SessionCommandGroup sessionCommandGroup) {
        if (this.mSessionStub.getConnectedControllersManager().isConnected(controllerInfo)) {
            this.mSessionStub.getConnectedControllersManager().updateAllowedCommands(controllerInfo, sessionCommandGroup);
            dispatchRemoteControllerTaskWithoutReturn(controllerInfo, new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.4
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onAllowedCommandsChanged(i, sessionCommandGroup);
                }
            });
            return;
        }
        this.mSessionLegacyStub.getConnectedControllersManager().updateAllowedCommands(controllerInfo, sessionCommandGroup);
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public ListenableFuture<SessionResult> setCustomLayout(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull final List<MediaSession.CommandButton> list) {
        return dispatchRemoteControllerTask(controllerInfo, new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.3
            @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
            public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                controllerCb.setCustomLayout(i, list);
            }
        });
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public ListenableFuture<SessionPlayer.PlayerResult> setPlaylist(@NonNull final List<MediaItem> list, @Nullable final MediaMetadata mediaMetadata) {
        if (list != null) {
            return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>() { // from class: androidx.media2.session.MediaSessionImplBase.19
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                public ListenableFuture<SessionPlayer.PlayerResult> run(@NonNull SessionPlayer sessionPlayer) throws Exception {
                    return sessionPlayer.setPlaylist(list, mediaMetadata);
                }
            });
        }
        throw new NullPointerException("list shouldn't be null");
    }

    private ListenableFuture<SessionResult> dispatchRemoteControllerTask(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull RemoteControllerTask remoteControllerTask) {
        SequencedFutureManager.SequencedFuture sequencedFuture;
        try {
            SequencedFutureManager sequencedFutureManager = this.mSessionStub.getConnectedControllersManager().getSequencedFutureManager(controllerInfo);
            int i = 0;
            if (sequencedFutureManager != null) {
                SequencedFutureManager.SequencedFuture createSequencedFuture = sequencedFutureManager.createSequencedFuture(RESULT_WHEN_CLOSED);
                i = createSequencedFuture.getSequenceNumber();
                sequencedFuture = createSequencedFuture;
            } else if (!isConnected(controllerInfo)) {
                return SessionResult.createFutureWithResult(-100);
            } else {
                sequencedFuture = SessionResult.createFutureWithResult(0);
            }
            remoteControllerTask.run(controllerInfo.getControllerCb(), i);
            return sequencedFuture;
        } catch (DeadObjectException e) {
            onDeadObjectException(controllerInfo, e);
            return SessionResult.createFutureWithResult(-100);
        } catch (RemoteException e2) {
            Log.w(TAG, "Exception in " + controllerInfo.toString(), e2);
            return SessionResult.createFutureWithResult(-1);
        }
    }

    public void dispatchRemoteControllerTaskWithoutReturn(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull RemoteControllerTask remoteControllerTask) {
        int i;
        try {
            SequencedFutureManager sequencedFutureManager = this.mSessionStub.getConnectedControllersManager().getSequencedFutureManager(controllerInfo);
            if (sequencedFutureManager != null) {
                i = sequencedFutureManager.obtainNextSequenceNumber();
            } else if (!isConnected(controllerInfo)) {
                if (DEBUG) {
                    Log.d(TAG, "Skipping dispatching task to disconnected controller, controller=" + controllerInfo);
                    return;
                }
                return;
            } else {
                i = 0;
            }
            remoteControllerTask.run(controllerInfo.getControllerCb(), i);
        } catch (DeadObjectException e) {
            onDeadObjectException(controllerInfo, e);
        } catch (RemoteException e2) {
            Log.w(TAG, "Exception in " + controllerInfo.toString(), e2);
        }
    }

    @Nullable
    private ComponentName getServiceComponentByAction(@NonNull String str) {
        PackageManager packageManager = this.mContext.getPackageManager();
        Intent intent = new Intent(str);
        intent.setPackage(this.mContext.getPackageName());
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
            ServiceInfo serviceInfo = queryIntentServices.get(0).serviceInfo;
            return new ComponentName(serviceInfo.packageName, serviceInfo.name);
        }
        return null;
    }

    @SuppressLint({"WrongConstant"})
    private void notifyPlayerUpdatedNotLocked(SessionPlayer sessionPlayer) {
        List<MediaItem> playlist = sessionPlayer.getPlaylist();
        final List<MediaItem> playlistOrNull = getPlaylistOrNull();
        if (!ObjectsCompat.equals(playlist, playlistOrNull)) {
            dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.44
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onPlaylistChanged(i, playlistOrNull, MediaSessionImplBase.this.getPlaylistMetadata(), MediaSessionImplBase.this.getCurrentMediaItemIndex(), MediaSessionImplBase.this.getPreviousMediaItemIndex(), MediaSessionImplBase.this.getNextMediaItemIndex());
                }
            });
        } else {
            MediaMetadata playlistMetadata = sessionPlayer.getPlaylistMetadata();
            final MediaMetadata playlistMetadata2 = getPlaylistMetadata();
            if (!ObjectsCompat.equals(playlistMetadata, playlistMetadata2)) {
                dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.45
                    @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                    public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                        controllerCb.onPlaylistMetadataChanged(i, playlistMetadata2);
                    }
                });
            }
        }
        MediaItem currentMediaItem = sessionPlayer.getCurrentMediaItem();
        final MediaItem currentMediaItemOrNull = getCurrentMediaItemOrNull();
        if (!ObjectsCompat.equals(currentMediaItem, currentMediaItemOrNull)) {
            dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.46
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onCurrentMediaItemChanged(i, currentMediaItemOrNull, MediaSessionImplBase.this.getCurrentMediaItemIndex(), MediaSessionImplBase.this.getPreviousMediaItemIndex(), MediaSessionImplBase.this.getNextMediaItemIndex());
                }
            });
        }
        final int repeatMode = getRepeatMode();
        if (sessionPlayer.getRepeatMode() != repeatMode) {
            dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.47
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onRepeatModeChanged(i, repeatMode, MediaSessionImplBase.this.getCurrentMediaItemIndex(), MediaSessionImplBase.this.getPreviousMediaItemIndex(), MediaSessionImplBase.this.getNextMediaItemIndex());
                }
            });
        }
        final int shuffleMode = getShuffleMode();
        if (sessionPlayer.getShuffleMode() != shuffleMode) {
            dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.48
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onShuffleModeChanged(i, shuffleMode, MediaSessionImplBase.this.getCurrentMediaItemIndex(), MediaSessionImplBase.this.getPreviousMediaItemIndex(), MediaSessionImplBase.this.getNextMediaItemIndex());
                }
            });
        }
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        final long currentPosition = getCurrentPosition();
        final int playerState = getPlayerState();
        dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.49
            @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
            public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                controllerCb.onPlayerStateChanged(i, elapsedRealtime, currentPosition, playerState);
            }
        });
        final MediaItem currentMediaItemOrNull2 = getCurrentMediaItemOrNull();
        if (currentMediaItemOrNull2 != null) {
            final int bufferingState = getBufferingState();
            final long bufferedPosition = getBufferedPosition();
            dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.50
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onBufferingStateChanged(i, currentMediaItemOrNull2, bufferingState, bufferedPosition, SystemClock.elapsedRealtime(), MediaSessionImplBase.this.getCurrentPosition());
                }
            });
        }
        final float playbackSpeed = getPlaybackSpeed();
        if (playbackSpeed != sessionPlayer.getPlaybackSpeed()) {
            dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.51
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onPlaybackSpeedChanged(i, elapsedRealtime, currentPosition, playbackSpeed);
                }
            });
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.mLock) {
            if (isClosed()) {
                return;
            }
            if (DEBUG) {
                Log.d(TAG, "Closing session, id=" + getId() + ", token=" + getToken());
            }
            this.mPlayer.unregisterPlayerCallback(this.mPlayerCallback);
            this.mSessionCompat.release();
            this.mMediaButtonIntent.cancel();
            if (this.mBroadcastReceiver != null) {
                this.mContext.unregisterReceiver(this.mBroadcastReceiver);
            }
            this.mCallback.onSessionClosed(this.mInstance);
            dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.2
                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onDisconnected(i);
                }
            });
            this.mHandler.removeCallbacksAndMessages(null);
            if (this.mHandlerThread.isAlive()) {
                if (Build.VERSION.SDK_INT >= 18) {
                    this.mHandlerThread.quitSafely();
                } else {
                    this.mHandlerThread.quit();
                }
            }
        }
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public void connectFromService(IMediaController iMediaController, int i, String str, int i2, int i3, @Nullable Bundle bundle) {
        this.mSessionStub.connect(iMediaController, i, str, i2, i3, bundle);
    }

    public MediaBrowserServiceCompat createLegacyBrowserService(Context context, SessionToken sessionToken, MediaSessionCompat.Token token) {
        return new MediaSessionServiceLegacyStub(context, this, token);
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public ListenableFuture<SessionResult> sendCustomCommand(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull final SessionCommand sessionCommand, @Nullable final Bundle bundle) {
        return dispatchRemoteControllerTask(controllerInfo, new RemoteControllerTask() { // from class: androidx.media2.session.MediaSessionImplBase.6
            @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
            public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                controllerCb.sendCustomCommand(i, sessionCommand, bundle);
            }
        });
    }

    @NonNull
    public MediaController.PlaybackInfo createPlaybackInfo(@NonNull SessionPlayer sessionPlayer, AudioAttributesCompat audioAttributesCompat) {
        if (audioAttributesCompat == null) {
            audioAttributesCompat = sessionPlayer.getAudioAttributes();
        }
        int i = 2;
        if (!(sessionPlayer instanceof RemoteSessionPlayer)) {
            int legacyStreamType = getLegacyStreamType(audioAttributesCompat);
            if (Build.VERSION.SDK_INT >= 21 && this.mAudioManager.isVolumeFixed()) {
                i = 0;
            }
            return MediaController.PlaybackInfo.createPlaybackInfo(1, audioAttributesCompat, i, this.mAudioManager.getStreamMaxVolume(legacyStreamType), this.mAudioManager.getStreamVolume(legacyStreamType));
        }
        RemoteSessionPlayer remoteSessionPlayer = (RemoteSessionPlayer) sessionPlayer;
        return MediaController.PlaybackInfo.createPlaybackInfo(2, audioAttributesCompat, remoteSessionPlayer.getVolumeControlType(), remoteSessionPlayer.getMaxVolume(), remoteSessionPlayer.getVolume());
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public PlaybackStateCompat createPlaybackStateCompat() {
        PlaybackStateCompat build;
        synchronized (this.mLock) {
            build = new PlaybackStateCompat.Builder().setState(MediaUtils.convertToPlaybackStateCompatState(getPlayerState(), getBufferingState()), getCurrentPosition(), getPlaybackSpeed(), SystemClock.elapsedRealtime()).setActions(3670015L).setBufferedPosition(getBufferedPosition()).build();
        }
        return build;
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    @SuppressLint({"WrongConstant"})
    public void updatePlayer(@NonNull SessionPlayer sessionPlayer) {
        boolean z;
        SessionPlayer sessionPlayer2;
        VolumeProviderCompat volumeProviderCompat = null;
        MediaController.PlaybackInfo createPlaybackInfo = createPlaybackInfo(sessionPlayer, null);
        boolean z2 = sessionPlayer instanceof RemoteSessionPlayer;
        if (z2) {
            volumeProviderCompat = createVolumeProviderCompat((RemoteSessionPlayer) sessionPlayer);
        }
        synchronized (this.mLock) {
            if (!createPlaybackInfo.equals(this.mPlaybackInfo)) {
                z = true;
            } else {
                z = false;
            }
            sessionPlayer2 = this.mPlayer;
            this.mPlayer = sessionPlayer;
            this.mPlaybackInfo = createPlaybackInfo;
            this.mVolumeProviderCompat = volumeProviderCompat;
            if (sessionPlayer2 != sessionPlayer) {
                if (sessionPlayer2 != null) {
                    sessionPlayer2.unregisterPlayerCallback(this.mPlayerCallback);
                }
                this.mPlayer.registerPlayerCallback(this.mCallbackExecutor, this.mPlayerCallback);
            }
        }
        if (sessionPlayer2 == null) {
            this.mSessionCompat.setPlaybackState(createPlaybackStateCompat());
        } else {
            if (sessionPlayer != sessionPlayer2) {
                final int playerState = getPlayerState();
                this.mCallbackExecutor.execute(new Runnable() { // from class: androidx.media2.session.MediaSessionImplBase.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MediaSessionImplBase mediaSessionImplBase = MediaSessionImplBase.this;
                        mediaSessionImplBase.mCallback.onPlayerStateChanged(mediaSessionImplBase.getInstance(), playerState);
                    }
                });
                notifyPlayerUpdatedNotLocked(sessionPlayer2);
            }
            if (z) {
                notifyPlaybackInfoChangedNotLocked(createPlaybackInfo);
            }
        }
        if (z2) {
            this.mSessionCompat.setPlaybackToRemote(volumeProviderCompat);
            return;
        }
        this.mSessionCompat.setPlaybackToLocal(getLegacyStreamType(sessionPlayer.getAudioAttributes()));
    }
}
