package androidx.media2.session;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.ResultReceiver;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.util.ObjectsCompat;
import androidx.media2.common.MediaItem;
import androidx.media2.common.MediaMetadata;
import androidx.media2.common.Rating;
import androidx.media2.common.SessionPlayer;
import androidx.media2.common.VideoSize;
import androidx.media2.session.MediaController;
import androidx.media2.session.MediaSession;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class MediaControllerImplLegacy implements MediaController.MediaControllerImpl {
    public static final int ITEM_NONE = -1;
    public static final long POSITION_DIFF_TOLERANCE = 100;
    public static final String SESSION_COMMAND_ON_CAPTIONING_ENABLED_CHANGED = "android.media.session.command.ON_CAPTIONING_ENALBED_CHANGED";
    public static final String SESSION_COMMAND_ON_EXTRAS_CHANGED = "android.media.session.command.ON_EXTRAS_CHANGED";
    @GuardedBy("mLock")
    public SessionCommandGroup mAllowedCommands;
    @GuardedBy("mLock")
    public MediaBrowserCompat mBrowserCompat;
    @GuardedBy("mLock")
    public long mBufferedPosition;
    @GuardedBy("mLock")
    public int mBufferingState;
    @GuardedBy("mLock")
    public boolean mClosed;
    @GuardedBy("mLock")
    public boolean mConnected;
    public final Context mContext;
    @GuardedBy("mLock")
    public MediaControllerCompat mControllerCompat;
    @GuardedBy("mLock")
    public ControllerCompatCallback mControllerCompatCallback;
    @GuardedBy("mLock")
    public MediaItem mCurrentMediaItem;
    public int mCurrentMediaItemIndex;
    @GuardedBy("mLock")
    public List<MediaSession.CommandButton> mCustomLayout;
    public final Handler mHandler;
    public final HandlerThread mHandlerThread;
    public MediaController mInstance;
    @GuardedBy("mLock")
    public MediaMetadataCompat mMediaMetadataCompat;
    @GuardedBy("mLock")
    public MediaController.PlaybackInfo mPlaybackInfo;
    @GuardedBy("mLock")
    public PlaybackStateCompat mPlaybackStateCompat;
    @GuardedBy("mLock")
    public int mPlayerState;
    @GuardedBy("mLock")
    public List<MediaItem> mPlaylist;
    @GuardedBy("mLock")
    public MediaMetadata mPlaylistMetadata;
    public List<MediaSessionCompat.QueueItem> mQueue;
    @GuardedBy("mLock")
    public int mRepeatMode;
    @GuardedBy("mLock")
    public int mShuffleMode;
    public final SessionToken mToken;
    public static final String TAG = "MC2ImplLegacy";
    public static final boolean DEBUG = Log.isLoggable(TAG, 3);
    public final Object mLock = new Object();
    @GuardedBy("mLock")
    public int mSkipToPlaylistIndex = -1;

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public int getNextMediaItemIndex() {
        return -1;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public int getPreviousMediaItemIndex() {
        return -1;
    }

    /* loaded from: classes.dex */
    public class ConnectionCallback extends MediaBrowserCompat.ConnectionCallback {
        public ConnectionCallback() {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnected() {
            MediaBrowserCompat browserCompat = MediaControllerImplLegacy.this.getBrowserCompat();
            if (browserCompat != null) {
                MediaControllerImplLegacy.this.connectToSession(browserCompat.getSessionToken());
            } else if (MediaControllerImplLegacy.DEBUG) {
                Log.d(MediaControllerImplLegacy.TAG, "Controller is closed prematually", new IllegalStateException());
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnectionFailed() {
            MediaControllerImplLegacy.this.close();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnectionSuspended() {
            MediaControllerImplLegacy.this.close();
        }
    }

    /* loaded from: classes.dex */
    public final class ControllerCompatCallback extends MediaControllerCompat.Callback {
        public ControllerCompatCallback() {
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onAudioInfoChanged(MediaControllerCompat.PlaybackInfo playbackInfo) {
            final MediaController.PlaybackInfo playbackInfo2 = MediaUtils.toPlaybackInfo2(playbackInfo);
            synchronized (MediaControllerImplLegacy.this.mLock) {
                if (!MediaControllerImplLegacy.this.mClosed && MediaControllerImplLegacy.this.mConnected) {
                    MediaControllerImplLegacy.this.mPlaybackInfo = playbackInfo2;
                    MediaControllerImplLegacy.this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.14
                        @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                        public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                            controllerCallback.onPlaybackInfoChanged(MediaControllerImplLegacy.this.mInstance, playbackInfo2);
                        }
                    });
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onCaptioningEnabledChanged(final boolean z) {
            synchronized (MediaControllerImplLegacy.this.mLock) {
                if (!MediaControllerImplLegacy.this.mClosed && MediaControllerImplLegacy.this.mConnected) {
                    MediaControllerImplLegacy.this.mInstance.notifyPrimaryControllerCallback(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.15
                        @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                        public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                            Bundle bundle = new Bundle();
                            bundle.putBoolean(MediaConstants.ARGUMENT_CAPTIONING_ENABLED, z);
                            controllerCallback.onCustomCommand(MediaControllerImplLegacy.this.mInstance, new SessionCommand(MediaControllerImplLegacy.SESSION_COMMAND_ON_CAPTIONING_ENABLED_CHANGED, null), bundle);
                        }
                    });
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onExtrasChanged(final Bundle bundle) {
            synchronized (MediaControllerImplLegacy.this.mLock) {
                if (!MediaControllerImplLegacy.this.mClosed && MediaControllerImplLegacy.this.mConnected) {
                    MediaControllerImplLegacy.this.mInstance.notifyPrimaryControllerCallback(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.13
                        @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                        public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                            controllerCallback.onCustomCommand(MediaControllerImplLegacy.this.mInstance, new SessionCommand(MediaControllerImplLegacy.SESSION_COMMAND_ON_EXTRAS_CHANGED, null), bundle);
                        }
                    });
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onQueueTitleChanged(CharSequence charSequence) {
            synchronized (MediaControllerImplLegacy.this.mLock) {
                if (!MediaControllerImplLegacy.this.mClosed && MediaControllerImplLegacy.this.mConnected) {
                    MediaControllerImplLegacy.this.mPlaylistMetadata = MediaUtils.convertToMediaMetadata(charSequence);
                    final MediaMetadata mediaMetadata = MediaControllerImplLegacy.this.mPlaylistMetadata;
                    MediaControllerImplLegacy.this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.12
                        @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                        public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                            controllerCallback.onPlaylistMetadataChanged(MediaControllerImplLegacy.this.mInstance, mediaMetadata);
                        }
                    });
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onRepeatModeChanged(final int i) {
            synchronized (MediaControllerImplLegacy.this.mLock) {
                if (!MediaControllerImplLegacy.this.mClosed && MediaControllerImplLegacy.this.mConnected) {
                    MediaControllerImplLegacy.this.mRepeatMode = i;
                    MediaControllerImplLegacy.this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.16
                        @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                        public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                            controllerCallback.onRepeatModeChanged(MediaControllerImplLegacy.this.mInstance, i);
                        }
                    });
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onShuffleModeChanged(final int i) {
            synchronized (MediaControllerImplLegacy.this.mLock) {
                if (!MediaControllerImplLegacy.this.mClosed && MediaControllerImplLegacy.this.mConnected) {
                    MediaControllerImplLegacy.this.mShuffleMode = i;
                    MediaControllerImplLegacy.this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.17
                        @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                        public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                            controllerCallback.onShuffleModeChanged(MediaControllerImplLegacy.this.mInstance, i);
                        }
                    });
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) {
            synchronized (MediaControllerImplLegacy.this.mLock) {
                if (!MediaControllerImplLegacy.this.mClosed && MediaControllerImplLegacy.this.mConnected) {
                    MediaItem mediaItem = MediaControllerImplLegacy.this.mCurrentMediaItem;
                    MediaControllerImplLegacy.this.setCurrentMediaItemLocked(mediaMetadataCompat);
                    final MediaItem mediaItem2 = MediaControllerImplLegacy.this.mCurrentMediaItem;
                    if (mediaItem != mediaItem2) {
                        MediaControllerImplLegacy.this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.10
                            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                controllerCallback.onCurrentMediaItemChanged(MediaControllerImplLegacy.this.mInstance, mediaItem2);
                            }
                        });
                    }
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onPlaybackStateChanged(final PlaybackStateCompat playbackStateCompat) {
            long bufferedPosition;
            synchronized (MediaControllerImplLegacy.this.mLock) {
                if (!MediaControllerImplLegacy.this.mClosed && MediaControllerImplLegacy.this.mConnected) {
                    MediaItem mediaItem = MediaControllerImplLegacy.this.mCurrentMediaItem;
                    PlaybackStateCompat playbackStateCompat2 = MediaControllerImplLegacy.this.mPlaybackStateCompat;
                    MediaControllerImplLegacy.this.mPlaybackStateCompat = playbackStateCompat;
                    MediaControllerImplLegacy.this.mPlayerState = MediaUtils.convertToPlayerState(playbackStateCompat);
                    MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
                    if (playbackStateCompat == null) {
                        bufferedPosition = Long.MIN_VALUE;
                    } else {
                        bufferedPosition = playbackStateCompat.getBufferedPosition();
                    }
                    mediaControllerImplLegacy.mBufferedPosition = bufferedPosition;
                    int i = 0;
                    if (MediaControllerImplLegacy.this.mQueue != null && playbackStateCompat != null) {
                        for (int i2 = 0; i2 < MediaControllerImplLegacy.this.mQueue.size(); i2++) {
                            if (MediaControllerImplLegacy.this.mQueue.get(i2).getQueueId() == playbackStateCompat.getActiveQueueItemId()) {
                                MediaControllerImplLegacy.this.mCurrentMediaItemIndex = i2;
                                MediaControllerImplLegacy.this.mCurrentMediaItem = MediaControllerImplLegacy.this.mPlaylist.get(i2);
                            }
                        }
                    }
                    final MediaItem mediaItem2 = MediaControllerImplLegacy.this.mCurrentMediaItem;
                    List<MediaSession.CommandButton> list = MediaControllerImplLegacy.this.mCustomLayout;
                    MediaControllerImplLegacy.this.mCustomLayout = MediaUtils.convertToCustomLayout(playbackStateCompat);
                    final List<MediaSession.CommandButton> list2 = MediaControllerImplLegacy.this.mCustomLayout;
                    SessionCommandGroup sessionCommandGroup = MediaControllerImplLegacy.this.mAllowedCommands;
                    MediaControllerImplLegacy.this.mAllowedCommands = MediaUtils.convertToSessionCommandGroup(MediaControllerImplLegacy.this.mControllerCompat.getFlags(), MediaControllerImplLegacy.this.mPlaybackStateCompat);
                    final SessionCommandGroup sessionCommandGroup2 = MediaControllerImplLegacy.this.mAllowedCommands;
                    if (mediaItem != mediaItem2) {
                        MediaControllerImplLegacy.this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.2
                            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                controllerCallback.onCurrentMediaItemChanged(MediaControllerImplLegacy.this.mInstance, mediaItem2);
                            }
                        });
                    }
                    if (playbackStateCompat == null) {
                        if (playbackStateCompat2 != null) {
                            MediaControllerImplLegacy.this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.3
                                @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                                public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                    controllerCallback.onPlayerStateChanged(MediaControllerImplLegacy.this.mInstance, 0);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if (playbackStateCompat2 == null || playbackStateCompat2.getState() != playbackStateCompat.getState()) {
                        MediaControllerImplLegacy.this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.4
                            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                controllerCallback.onPlayerStateChanged(MediaControllerImplLegacy.this.mInstance, MediaUtils.convertToPlayerState(playbackStateCompat));
                            }
                        });
                    }
                    if (playbackStateCompat2 == null || playbackStateCompat2.getPlaybackSpeed() != playbackStateCompat.getPlaybackSpeed()) {
                        MediaControllerImplLegacy.this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.5
                            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                controllerCallback.onPlaybackSpeedChanged(MediaControllerImplLegacy.this.mInstance, playbackStateCompat.getPlaybackSpeed());
                            }
                        });
                    }
                    if (playbackStateCompat2 != null) {
                        final long currentPosition = playbackStateCompat.getCurrentPosition(MediaControllerImplLegacy.this.mInstance.mTimeDiff);
                        if (Math.abs(currentPosition - playbackStateCompat2.getCurrentPosition(MediaControllerImplLegacy.this.mInstance.mTimeDiff)) > 100) {
                            MediaControllerImplLegacy.this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.6
                                @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                                public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                    controllerCallback.onSeekCompleted(MediaControllerImplLegacy.this.mInstance, currentPosition);
                                }
                            });
                        }
                    }
                    if (!sessionCommandGroup.equals(sessionCommandGroup2)) {
                        MediaControllerImplLegacy.this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.7
                            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                controllerCallback.onAllowedCommandsChanged(MediaControllerImplLegacy.this.mInstance, sessionCommandGroup2);
                            }
                        });
                    }
                    boolean z = true;
                    if (list.size() == list2.size()) {
                        int i3 = 0;
                        while (true) {
                            if (i3 < list2.size()) {
                                if (!ObjectsCompat.equals(list.get(i3).getCommand(), list2.get(i3).getCommand())) {
                                    break;
                                }
                                i3++;
                            } else {
                                z = false;
                                break;
                            }
                        }
                    }
                    if (z) {
                        MediaControllerImplLegacy.this.mInstance.notifyPrimaryControllerCallback(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.8
                            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                controllerCallback.onSetCustomLayout(MediaControllerImplLegacy.this.mInstance, list2);
                            }
                        });
                    }
                    if (mediaItem2 == null) {
                        return;
                    }
                    final int bufferingState = MediaUtils.toBufferingState(playbackStateCompat.getState());
                    if (playbackStateCompat2 != null) {
                        i = MediaUtils.toBufferingState(playbackStateCompat2.getState());
                    }
                    if (bufferingState != i) {
                        MediaControllerImplLegacy.this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.9
                            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                controllerCallback.onBufferingStateChanged(MediaControllerImplLegacy.this.mInstance, mediaItem2, bufferingState);
                            }
                        });
                    }
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onQueueChanged(List<MediaSessionCompat.QueueItem> list) {
            synchronized (MediaControllerImplLegacy.this.mLock) {
                if (!MediaControllerImplLegacy.this.mClosed && MediaControllerImplLegacy.this.mConnected) {
                    MediaControllerImplLegacy.this.mQueue = MediaUtils.removeNullElements(list);
                    if (MediaControllerImplLegacy.this.mQueue != null && MediaControllerImplLegacy.this.mQueue.size() != 0) {
                        MediaControllerImplLegacy.this.mPlaylist = MediaUtils.convertQueueItemListToMediaItemList(MediaControllerImplLegacy.this.mQueue);
                        final List<MediaItem> list2 = MediaControllerImplLegacy.this.mPlaylist;
                        final MediaMetadata mediaMetadata = MediaControllerImplLegacy.this.mPlaylistMetadata;
                        MediaControllerImplLegacy.this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.11
                            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                controllerCallback.onPlaylistChanged(MediaControllerImplLegacy.this.mInstance, list2, mediaMetadata);
                            }
                        });
                    }
                    MediaControllerImplLegacy.this.mQueue = null;
                    MediaControllerImplLegacy.this.mPlaylist = null;
                    final List list22 = MediaControllerImplLegacy.this.mPlaylist;
                    final MediaMetadata mediaMetadata2 = MediaControllerImplLegacy.this.mPlaylistMetadata;
                    MediaControllerImplLegacy.this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.11
                        @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                        public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                            controllerCallback.onPlaylistChanged(MediaControllerImplLegacy.this.mInstance, list22, mediaMetadata2);
                        }
                    });
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onSessionDestroyed() {
            MediaControllerImplLegacy.this.close();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onSessionEvent(final String str, final Bundle bundle) {
            synchronized (MediaControllerImplLegacy.this.mLock) {
                if (!MediaControllerImplLegacy.this.mClosed && MediaControllerImplLegacy.this.mConnected) {
                    MediaControllerImplLegacy.this.mInstance.notifyPrimaryControllerCallback(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.1
                        @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                        public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                            controllerCallback.onCustomCommand(MediaControllerImplLegacy.this.mInstance, new SessionCommand(str, null), bundle);
                        }
                    });
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onSessionReady() {
            boolean z;
            PlaybackStateCompat playbackState;
            int shuffleMode;
            int repeatMode;
            boolean isCaptioningEnabled;
            synchronized (MediaControllerImplLegacy.this.mLock) {
                z = MediaControllerImplLegacy.this.mConnected;
            }
            if (!z) {
                MediaControllerImplLegacy.this.onConnectedNotLocked();
                return;
            }
            synchronized (MediaControllerImplLegacy.this.mLock) {
                playbackState = MediaControllerImplLegacy.this.mControllerCompat.getPlaybackState();
                shuffleMode = MediaControllerImplLegacy.this.mControllerCompat.getShuffleMode();
                repeatMode = MediaControllerImplLegacy.this.mControllerCompat.getRepeatMode();
                isCaptioningEnabled = MediaControllerImplLegacy.this.mControllerCompat.isCaptioningEnabled();
            }
            onPlaybackStateChanged(playbackState);
            onShuffleModeChanged(shuffleMode);
            onRepeatModeChanged(repeatMode);
            onCaptioningEnabledChanged(isCaptioningEnabled);
        }
    }

    private void connectToService() {
        this.mHandler.post(new Runnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (MediaControllerImplLegacy.this.mLock) {
                    MediaControllerImplLegacy.this.mBrowserCompat = new MediaBrowserCompat(MediaControllerImplLegacy.this.mContext, MediaControllerImplLegacy.this.mToken.getComponentName(), new ConnectionCallback(), null);
                    MediaControllerImplLegacy.this.mBrowserCompat.connect();
                }
            }
        });
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> fastForward() {
        synchronized (this.mLock) {
            if (!this.mConnected) {
                Log.w(TAG, "Session isn't active", new IllegalStateException());
                return createFutureWithResult(-100);
            }
            this.mControllerCompat.getTransportControls().fastForward();
            return createFutureWithResult(0);
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public SessionCommandGroup getAllowedCommands() {
        synchronized (this.mLock) {
            if (!this.mConnected) {
                Log.w(TAG, "Session isn't active", new IllegalStateException());
                return null;
            }
            return this.mAllowedCommands;
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @Nullable
    public MediaBrowserCompat getBrowserCompat() {
        MediaBrowserCompat mediaBrowserCompat;
        synchronized (this.mLock) {
            mediaBrowserCompat = this.mBrowserCompat;
        }
        return mediaBrowserCompat;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public long getBufferedPosition() {
        synchronized (this.mLock) {
            long j = Long.MIN_VALUE;
            if (!this.mConnected) {
                Log.w(TAG, "Session isn't active", new IllegalStateException());
                return Long.MIN_VALUE;
            }
            if (this.mPlaybackStateCompat != null) {
                j = this.mPlaybackStateCompat.getBufferedPosition();
            }
            return j;
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public int getBufferingState() {
        synchronized (this.mLock) {
            int i = 0;
            if (!this.mConnected) {
                Log.w(TAG, "Session isn't active", new IllegalStateException());
                return 0;
            }
            if (this.mPlaybackStateCompat != null) {
                i = MediaUtils.toBufferingState(this.mPlaybackStateCompat.getState());
            }
            return i;
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @Nullable
    public SessionToken getConnectedToken() {
        SessionToken sessionToken;
        synchronized (this.mLock) {
            if (this.mConnected) {
                sessionToken = this.mToken;
            } else {
                sessionToken = null;
            }
        }
        return sessionToken;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @NonNull
    public Context getContext() {
        return this.mContext;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public MediaItem getCurrentMediaItem() {
        synchronized (this.mLock) {
            if (!this.mConnected) {
                Log.w(TAG, "Session isn't active", new IllegalStateException());
                return null;
            }
            return this.mCurrentMediaItem;
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public int getCurrentMediaItemIndex() {
        return this.mCurrentMediaItemIndex;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public long getCurrentPosition() {
        synchronized (this.mLock) {
            if (!this.mConnected) {
                Log.w(TAG, "Session isn't active", new IllegalStateException());
                return Long.MIN_VALUE;
            } else if (this.mPlaybackStateCompat == null) {
                return Long.MIN_VALUE;
            } else {
                return this.mPlaybackStateCompat.getCurrentPosition(this.mInstance.mTimeDiff);
            }
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @Nullable
    public MediaController.PlaybackInfo getPlaybackInfo() {
        synchronized (this.mLock) {
            if (!this.mConnected) {
                Log.w(TAG, "Session isn't active", new IllegalStateException());
                return null;
            }
            return this.mPlaybackInfo;
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public float getPlaybackSpeed() {
        synchronized (this.mLock) {
            float f = 0.0f;
            if (!this.mConnected) {
                Log.w(TAG, "Session isn't active", new IllegalStateException());
                return 0.0f;
            }
            if (this.mPlaybackStateCompat != null) {
                f = this.mPlaybackStateCompat.getPlaybackSpeed();
            }
            return f;
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public int getPlayerState() {
        synchronized (this.mLock) {
            if (!this.mConnected) {
                Log.w(TAG, "Session isn't active", new IllegalStateException());
                return 3;
            }
            return this.mPlayerState;
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @Nullable
    public List<MediaItem> getPlaylist() {
        synchronized (this.mLock) {
            ArrayList arrayList = null;
            if (!this.mConnected) {
                Log.w(TAG, "Session isn't active", new IllegalStateException());
                return null;
            }
            if (this.mPlaylist != null && this.mPlaylist.size() != 0) {
                arrayList = new ArrayList(this.mPlaylist);
            }
            return arrayList;
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @Nullable
    public MediaMetadata getPlaylistMetadata() {
        synchronized (this.mLock) {
            if (!this.mConnected) {
                Log.w(TAG, "Session isn't active", new IllegalStateException());
                return null;
            }
            return this.mPlaylistMetadata;
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public int getRepeatMode() {
        synchronized (this.mLock) {
            if (!this.mConnected) {
                Log.w(TAG, "Session isn't active", new IllegalStateException());
                return 0;
            }
            return this.mRepeatMode;
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @Nullable
    public PendingIntent getSessionActivity() {
        synchronized (this.mLock) {
            if (!this.mConnected) {
                Log.w(TAG, "Session isn't active", new IllegalStateException());
                return null;
            }
            return this.mControllerCompat.getSessionActivity();
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public int getShuffleMode() {
        synchronized (this.mLock) {
            if (!this.mConnected) {
                Log.w(TAG, "Session isn't active", new IllegalStateException());
                return 0;
            }
            return this.mShuffleMode;
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @NonNull
    public List<SessionPlayer.TrackInfo> getTracks() {
        Log.w(TAG, "Session doesn't support getting TrackInfo");
        return Collections.emptyList();
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @NonNull
    public VideoSize getVideoSize() {
        Log.w(TAG, "Session doesn't support getting VideoSize");
        return new VideoSize(0, 0);
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public boolean isConnected() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mConnected;
        }
        return z;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> pause() {
        synchronized (this.mLock) {
            if (!this.mConnected) {
                Log.w(TAG, "Session isn't active", new IllegalStateException());
                return createFutureWithResult(-100);
            }
            this.mControllerCompat.getTransportControls().pause();
            return createFutureWithResult(0);
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> play() {
        synchronized (this.mLock) {
            if (!this.mConnected) {
                Log.w(TAG, "Session isn't active", new IllegalStateException());
                return createFutureWithResult(-100);
            }
            this.mControllerCompat.getTransportControls().play();
            return createFutureWithResult(0);
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> prepare() {
        synchronized (this.mLock) {
            if (!this.mConnected) {
                Log.w(TAG, "Session isn't active", new IllegalStateException());
                return createFutureWithResult(-100);
            }
            this.mControllerCompat.getTransportControls().prepare();
            return createFutureWithResult(0);
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> rewind() {
        synchronized (this.mLock) {
            if (!this.mConnected) {
                Log.w(TAG, "Session isn't active", new IllegalStateException());
                return createFutureWithResult(-100);
            }
            this.mControllerCompat.getTransportControls().rewind();
            return createFutureWithResult(0);
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> skipBackward() {
        return createFutureWithResult(-6);
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> skipForward() {
        return createFutureWithResult(-6);
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> skipToNextItem() {
        synchronized (this.mLock) {
            if (!this.mConnected) {
                Log.w(TAG, "Session isn't active", new IllegalStateException());
                return createFutureWithResult(-100);
            }
            this.mControllerCompat.getTransportControls().skipToNext();
            return createFutureWithResult(0);
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> skipToPreviousItem() {
        synchronized (this.mLock) {
            if (!this.mConnected) {
                Log.w(TAG, "Session isn't active", new IllegalStateException());
                return createFutureWithResult(-100);
            }
            this.mControllerCompat.getTransportControls().skipToPrevious();
            return createFutureWithResult(0);
        }
    }

    public MediaControllerImplLegacy(@NonNull Context context, @NonNull MediaController mediaController, @NonNull SessionToken sessionToken) {
        this.mContext = context;
        this.mInstance = mediaController;
        HandlerThread handlerThread = new HandlerThread("MediaController_Thread");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
        this.mToken = sessionToken;
        if (sessionToken.getType() == 0) {
            synchronized (this.mLock) {
                this.mBrowserCompat = null;
            }
            connectToSession((MediaSessionCompat.Token) this.mToken.getBinder());
            return;
        }
        connectToService();
    }

    private ListenableFuture<SessionResult> createFutureWithResult(int i) {
        MediaItem mediaItem;
        synchronized (this.mLock) {
            mediaItem = this.mCurrentMediaItem;
        }
        ResolvableFuture create = ResolvableFuture.create();
        create.set(new SessionResult(i, null, mediaItem));
        return create;
    }

    public void connectToSession(MediaSessionCompat.Token token) {
        boolean isSessionReady;
        MediaControllerCompat mediaControllerCompat = new MediaControllerCompat(this.mContext, token);
        synchronized (this.mLock) {
            this.mControllerCompat = mediaControllerCompat;
            this.mControllerCompatCallback = new ControllerCompatCallback();
            isSessionReady = this.mControllerCompat.isSessionReady();
            this.mControllerCompat.registerCallback(this.mControllerCompatCallback, this.mHandler);
        }
        if (!isSessionReady) {
            onConnectedNotLocked();
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @NonNull
    public ListenableFuture<SessionResult> deselectTrack(@NonNull SessionPlayer.TrackInfo trackInfo) {
        Log.w(TAG, "Session doesn't support deselecting track");
        return createFutureWithResult(-6);
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @Nullable
    public SessionPlayer.TrackInfo getSelectedTrack(int i) {
        Log.w(TAG, "Session doesn't support getting selected track");
        return null;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> seekTo(long j) {
        synchronized (this.mLock) {
            if (!this.mConnected) {
                Log.w(TAG, "Session isn't active", new IllegalStateException());
                return createFutureWithResult(-100);
            }
            this.mControllerCompat.getTransportControls().seekTo(j);
            return createFutureWithResult(0);
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @NonNull
    public ListenableFuture<SessionResult> selectTrack(@NonNull SessionPlayer.TrackInfo trackInfo) {
        Log.w(TAG, "Session doesn't support selecting track");
        return createFutureWithResult(-6);
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> setMediaItem(@NonNull String str) {
        return createFutureWithResult(-6);
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> setPlaybackSpeed(float f) {
        synchronized (this.mLock) {
            if (!this.mConnected) {
                Log.w(TAG, "Session isn't active", new IllegalStateException());
                return createFutureWithResult(-100);
            }
            this.mControllerCompat.getTransportControls().setPlaybackSpeed(f);
            return createFutureWithResult(0);
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> setRepeatMode(int i) {
        synchronized (this.mLock) {
            if (!this.mConnected) {
                Log.w(TAG, "Session isn't active", new IllegalStateException());
                return createFutureWithResult(-100);
            }
            this.mControllerCompat.getTransportControls().setRepeatMode(i);
            return createFutureWithResult(0);
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> setShuffleMode(int i) {
        synchronized (this.mLock) {
            if (!this.mConnected) {
                Log.w(TAG, "Session isn't active", new IllegalStateException());
                return createFutureWithResult(-100);
            }
            this.mControllerCompat.getTransportControls().setShuffleMode(i);
            return createFutureWithResult(0);
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> setSurface(@Nullable Surface surface) {
        Log.w(TAG, "Session doesn't support setting Surface");
        return createFutureWithResult(-6);
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> updatePlaylistMetadata(@Nullable MediaMetadata mediaMetadata) {
        return createFutureWithResult(-6);
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> addPlaylistItem(int i, @NonNull String str) {
        synchronized (this.mLock) {
            if (!this.mConnected) {
                Log.w(TAG, "Session isn't active", new IllegalStateException());
                return createFutureWithResult(-100);
            }
            this.mControllerCompat.addQueueItem(MediaUtils.createMediaDescriptionCompat(str), i);
            return createFutureWithResult(0);
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> adjustVolume(int i, int i2) {
        synchronized (this.mLock) {
            if (!this.mConnected) {
                Log.w(TAG, "Session isn't active", new IllegalStateException());
                return createFutureWithResult(-100);
            }
            this.mControllerCompat.adjustVolume(i, i2);
            return createFutureWithResult(0);
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> movePlaylistItem(int i, int i2) {
        return createFutureWithResult(-6);
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> setMediaUri(@NonNull Uri uri, @Nullable Bundle bundle) {
        return createFutureWithResult(-6);
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> setPlaylist(@NonNull List<String> list, @Nullable MediaMetadata mediaMetadata) {
        return createFutureWithResult(-6);
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> setVolumeTo(int i, int i2) {
        synchronized (this.mLock) {
            if (!this.mConnected) {
                Log.w(TAG, "Session isn't active", new IllegalStateException());
                return createFutureWithResult(-100);
            }
            this.mControllerCompat.setVolumeTo(i, i2);
            return createFutureWithResult(0);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (DEBUG) {
            Log.d(TAG, "close from " + this.mToken);
        }
        synchronized (this.mLock) {
            if (this.mClosed) {
                return;
            }
            this.mHandler.removeCallbacksAndMessages(null);
            if (Build.VERSION.SDK_INT >= 18) {
                this.mHandlerThread.quitSafely();
            } else {
                this.mHandlerThread.quit();
            }
            this.mClosed = true;
            if (this.mBrowserCompat != null) {
                this.mBrowserCompat.disconnect();
                this.mBrowserCompat = null;
            }
            if (this.mControllerCompat != null) {
                this.mControllerCompat.unregisterCallback(this.mControllerCompatCallback);
                this.mControllerCompat = null;
            }
            this.mConnected = false;
            this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.1
                @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                    controllerCallback.onDisconnected(MediaControllerImplLegacy.this.mInstance);
                }
            });
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public long getDuration() {
        synchronized (this.mLock) {
            if (!this.mConnected) {
                Log.w(TAG, "Session isn't active", new IllegalStateException());
                return Long.MIN_VALUE;
            } else if (this.mMediaMetadataCompat == null || !this.mMediaMetadataCompat.containsKey("android.media.metadata.DURATION")) {
                return Long.MIN_VALUE;
            } else {
                return this.mMediaMetadataCompat.getLong("android.media.metadata.DURATION");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onConnectedNotLocked() {
        long bufferedPosition;
        if (DEBUG) {
            Log.d(TAG, "onConnectedNotLocked token=" + this.mToken);
        }
        synchronized (this.mLock) {
            if (!this.mClosed && !this.mConnected) {
                this.mPlaybackStateCompat = this.mControllerCompat.getPlaybackState();
                this.mAllowedCommands = MediaUtils.convertToSessionCommandGroup(this.mControllerCompat.getFlags(), this.mPlaybackStateCompat);
                this.mPlayerState = MediaUtils.convertToPlayerState(this.mPlaybackStateCompat);
                if (this.mPlaybackStateCompat == null) {
                    bufferedPosition = Long.MIN_VALUE;
                } else {
                    bufferedPosition = this.mPlaybackStateCompat.getBufferedPosition();
                }
                this.mBufferedPosition = bufferedPosition;
                final List<MediaSession.CommandButton> convertToCustomLayout = MediaUtils.convertToCustomLayout(this.mPlaybackStateCompat);
                this.mCustomLayout = convertToCustomLayout;
                final SessionCommandGroup sessionCommandGroup = this.mAllowedCommands;
                this.mPlaybackInfo = MediaUtils.toPlaybackInfo2(this.mControllerCompat.getPlaybackInfo());
                this.mRepeatMode = this.mControllerCompat.getRepeatMode();
                this.mShuffleMode = this.mControllerCompat.getShuffleMode();
                List<MediaSessionCompat.QueueItem> removeNullElements = MediaUtils.removeNullElements(this.mControllerCompat.getQueue());
                this.mQueue = removeNullElements;
                if (removeNullElements != null && removeNullElements.size() != 0) {
                    this.mPlaylist = MediaUtils.convertQueueItemListToMediaItemList(this.mQueue);
                    this.mPlaylistMetadata = MediaUtils.convertToMediaMetadata(this.mControllerCompat.getQueueTitle());
                    setCurrentMediaItemLocked(this.mControllerCompat.getMetadata());
                    this.mConnected = true;
                    this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.3
                        @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                        public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                            controllerCallback.onConnected(MediaControllerImplLegacy.this.mInstance, sessionCommandGroup);
                        }
                    });
                    if (convertToCustomLayout.isEmpty()) {
                        this.mInstance.notifyPrimaryControllerCallback(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.4
                            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                controllerCallback.onSetCustomLayout(MediaControllerImplLegacy.this.mInstance, convertToCustomLayout);
                            }
                        });
                        return;
                    }
                    return;
                }
                this.mQueue = null;
                this.mPlaylist = null;
                this.mPlaylistMetadata = MediaUtils.convertToMediaMetadata(this.mControllerCompat.getQueueTitle());
                setCurrentMediaItemLocked(this.mControllerCompat.getMetadata());
                this.mConnected = true;
                this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable() { // from class: androidx.media2.session.MediaControllerImplLegacy.3
                    @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                    public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                        controllerCallback.onConnected(MediaControllerImplLegacy.this.mInstance, sessionCommandGroup);
                    }
                });
                if (convertToCustomLayout.isEmpty()) {
                }
            }
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> removePlaylistItem(int i) {
        synchronized (this.mLock) {
            if (!this.mConnected) {
                Log.w(TAG, "Session isn't active", new IllegalStateException());
                return createFutureWithResult(-100);
            }
            if (this.mQueue != null && i >= 0 && i < this.mQueue.size()) {
                this.mControllerCompat.removeQueueItem(this.mQueue.get(i).getDescription());
                return createFutureWithResult(0);
            }
            return createFutureWithResult(-3);
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> replacePlaylistItem(int i, @NonNull String str) {
        synchronized (this.mLock) {
            if (!this.mConnected) {
                Log.w(TAG, "Session isn't active", new IllegalStateException());
                return createFutureWithResult(-100);
            }
            if (this.mQueue != null && i >= 0 && i < this.mQueue.size()) {
                this.mControllerCompat.removeQueueItem(this.mQueue.get(i).getDescription());
                this.mControllerCompat.addQueueItem(MediaUtils.createMediaDescriptionCompat(str), i);
                return createFutureWithResult(0);
            }
            return createFutureWithResult(-3);
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> sendCustomCommand(@NonNull SessionCommand sessionCommand, @Nullable Bundle bundle) {
        synchronized (this.mLock) {
            if (!this.mConnected) {
                Log.w(TAG, "Session isn't active", new IllegalStateException());
                return createFutureWithResult(-100);
            } else if (this.mAllowedCommands.hasCommand(sessionCommand)) {
                this.mControllerCompat.getTransportControls().sendCustomAction(sessionCommand.getCustomAction(), bundle);
                return createFutureWithResult(0);
            } else {
                final ResolvableFuture create = ResolvableFuture.create();
                this.mControllerCompat.sendCommand(sessionCommand.getCustomAction(), bundle, new ResultReceiver(this.mHandler) { // from class: androidx.media2.session.MediaControllerImplLegacy.2
                    @Override // android.os.ResultReceiver
                    public void onReceiveResult(int i, Bundle bundle2) {
                        create.set(new SessionResult(i, bundle2));
                    }
                });
                return create;
            }
        }
    }

    public void setCurrentMediaItemLocked(MediaMetadataCompat mediaMetadataCompat) {
        this.mMediaMetadataCompat = mediaMetadataCompat;
        if (mediaMetadataCompat == null) {
            this.mCurrentMediaItemIndex = -1;
            this.mCurrentMediaItem = null;
        } else if (this.mQueue == null) {
            this.mCurrentMediaItemIndex = -1;
            this.mCurrentMediaItem = MediaUtils.convertToMediaItem(mediaMetadataCompat);
        } else {
            PlaybackStateCompat playbackStateCompat = this.mPlaybackStateCompat;
            if (playbackStateCompat != null) {
                long activeQueueItemId = playbackStateCompat.getActiveQueueItemId();
                for (int i = 0; i < this.mQueue.size(); i++) {
                    if (this.mQueue.get(i).getQueueId() == activeQueueItemId) {
                        this.mCurrentMediaItem = MediaUtils.convertToMediaItem(mediaMetadataCompat);
                        this.mCurrentMediaItemIndex = i;
                        return;
                    }
                }
            }
            String string = mediaMetadataCompat.getString("android.media.metadata.MEDIA_ID");
            if (string == null) {
                this.mCurrentMediaItemIndex = -1;
                this.mCurrentMediaItem = MediaUtils.convertToMediaItem(mediaMetadataCompat);
                return;
            }
            int i2 = this.mSkipToPlaylistIndex;
            if (i2 >= 0 && i2 < this.mQueue.size() && TextUtils.equals(string, this.mQueue.get(this.mSkipToPlaylistIndex).getDescription().getMediaId())) {
                this.mCurrentMediaItem = MediaUtils.convertToMediaItem(mediaMetadataCompat);
                this.mCurrentMediaItemIndex = this.mSkipToPlaylistIndex;
                this.mSkipToPlaylistIndex = -1;
                return;
            }
            for (int i3 = 0; i3 < this.mQueue.size(); i3++) {
                if (TextUtils.equals(string, this.mQueue.get(i3).getDescription().getMediaId())) {
                    this.mCurrentMediaItemIndex = i3;
                    this.mCurrentMediaItem = MediaUtils.convertToMediaItem(mediaMetadataCompat);
                    return;
                }
            }
            this.mCurrentMediaItemIndex = -1;
            this.mCurrentMediaItem = MediaUtils.convertToMediaItem(this.mMediaMetadataCompat);
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> setRating(@NonNull String str, @NonNull Rating rating) {
        synchronized (this.mLock) {
            if (!this.mConnected) {
                Log.w(TAG, "Session isn't active", new IllegalStateException());
                return createFutureWithResult(-100);
            }
            if (this.mCurrentMediaItem != null && str.equals(this.mCurrentMediaItem.getMediaId())) {
                this.mControllerCompat.getTransportControls().setRating(MediaUtils.convertToRatingCompat(rating));
            }
            return createFutureWithResult(0);
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> skipToPlaylistItem(int i) {
        synchronized (this.mLock) {
            if (!this.mConnected) {
                Log.w(TAG, "Session isn't active", new IllegalStateException());
                return createFutureWithResult(-100);
            }
            this.mSkipToPlaylistIndex = i;
            this.mControllerCompat.getTransportControls().skipToQueueItem(this.mQueue.get(i).getQueueId());
            return createFutureWithResult(0);
        }
    }
}
