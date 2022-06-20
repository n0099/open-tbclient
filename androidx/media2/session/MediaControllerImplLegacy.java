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
import androidx.core.view.InputDeviceCompat;
import androidx.media2.common.MediaItem;
import androidx.media2.common.MediaMetadata;
import androidx.media2.common.Rating;
import androidx.media2.common.SessionPlayer;
import androidx.media2.common.VideoSize;
import androidx.media2.session.MediaController;
import androidx.media2.session.MediaSession;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class MediaControllerImplLegacy implements MediaController.MediaControllerImpl {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final int ITEM_NONE = -1;
    public static final long POSITION_DIFF_TOLERANCE = 100;
    public static final String SESSION_COMMAND_ON_CAPTIONING_ENABLED_CHANGED = "android.media.session.command.ON_CAPTIONING_ENALBED_CHANGED";
    public static final String SESSION_COMMAND_ON_EXTRAS_CHANGED = "android.media.session.command.ON_EXTRAS_CHANGED";
    public static final String TAG = "MC2ImplLegacy";
    public transient /* synthetic */ FieldHolder $fh;
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
    public final Object mLock;
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
    @GuardedBy("mLock")
    public int mSkipToPlaylistIndex;
    public final SessionToken mToken;

    /* loaded from: classes.dex */
    public class ConnectionCallback extends MediaBrowserCompat.ConnectionCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MediaControllerImplLegacy this$0;

        public ConnectionCallback(MediaControllerImplLegacy mediaControllerImplLegacy) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaControllerImplLegacy};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = mediaControllerImplLegacy;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnected() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MediaBrowserCompat browserCompat = this.this$0.getBrowserCompat();
                if (browserCompat != null) {
                    this.this$0.connectToSession(browserCompat.getSessionToken());
                } else if (MediaControllerImplLegacy.DEBUG) {
                    Log.d(MediaControllerImplLegacy.TAG, "Controller is closed prematually", new IllegalStateException());
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnectionFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.this$0.close();
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnectionSuspended() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.this$0.close();
            }
        }
    }

    /* loaded from: classes.dex */
    public final class ControllerCompatCallback extends MediaControllerCompat.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MediaControllerImplLegacy this$0;

        public ControllerCompatCallback(MediaControllerImplLegacy mediaControllerImplLegacy) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaControllerImplLegacy};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = mediaControllerImplLegacy;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onAudioInfoChanged(MediaControllerCompat.PlaybackInfo playbackInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, playbackInfo) == null) {
                MediaController.PlaybackInfo playbackInfo2 = MediaUtils.toPlaybackInfo2(playbackInfo);
                synchronized (this.this$0.mLock) {
                    if (!this.this$0.mClosed && this.this$0.mConnected) {
                        this.this$0.mPlaybackInfo = playbackInfo2;
                        this.this$0.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable(this, playbackInfo2) { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.14
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ ControllerCompatCallback this$1;
                            public final /* synthetic */ MediaController.PlaybackInfo val$info;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, playbackInfo2};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                                this.val$info = playbackInfo2;
                            }

                            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, controllerCallback) == null) {
                                    controllerCallback.onPlaybackInfoChanged(this.this$1.this$0.mInstance, this.val$info);
                                }
                            }
                        });
                    }
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onCaptioningEnabledChanged(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                synchronized (this.this$0.mLock) {
                    if (!this.this$0.mClosed && this.this$0.mConnected) {
                        this.this$0.mInstance.notifyPrimaryControllerCallback(new MediaController.ControllerCallbackRunnable(this, z) { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.15
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ ControllerCompatCallback this$1;
                            public final /* synthetic */ boolean val$enabled;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, Boolean.valueOf(z)};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                                this.val$enabled = z;
                            }

                            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, controllerCallback) == null) {
                                    Bundle bundle = new Bundle();
                                    bundle.putBoolean(MediaConstants.ARGUMENT_CAPTIONING_ENABLED, this.val$enabled);
                                    controllerCallback.onCustomCommand(this.this$1.this$0.mInstance, new SessionCommand(MediaControllerImplLegacy.SESSION_COMMAND_ON_CAPTIONING_ENABLED_CHANGED, null), bundle);
                                }
                            }
                        });
                    }
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onExtrasChanged(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
                synchronized (this.this$0.mLock) {
                    if (!this.this$0.mClosed && this.this$0.mConnected) {
                        this.this$0.mInstance.notifyPrimaryControllerCallback(new MediaController.ControllerCallbackRunnable(this, bundle) { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.13
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ ControllerCompatCallback this$1;
                            public final /* synthetic */ Bundle val$extras;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, bundle};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                                this.val$extras = bundle;
                            }

                            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, controllerCallback) == null) {
                                    controllerCallback.onCustomCommand(this.this$1.this$0.mInstance, new SessionCommand(MediaControllerImplLegacy.SESSION_COMMAND_ON_EXTRAS_CHANGED, null), this.val$extras);
                                }
                            }
                        });
                    }
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, mediaMetadataCompat) == null) {
                synchronized (this.this$0.mLock) {
                    if (!this.this$0.mClosed && this.this$0.mConnected) {
                        MediaItem mediaItem = this.this$0.mCurrentMediaItem;
                        this.this$0.setCurrentMediaItemLocked(mediaMetadataCompat);
                        MediaItem mediaItem2 = this.this$0.mCurrentMediaItem;
                        if (mediaItem != mediaItem2) {
                            this.this$0.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable(this, mediaItem2) { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.10
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ ControllerCompatCallback this$1;
                                public final /* synthetic */ MediaItem val$currentItem;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, mediaItem2};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i = newInitContext.flag;
                                        if ((i & 1) != 0) {
                                            int i2 = i & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                    this.val$currentItem = mediaItem2;
                                }

                                @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                                public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, controllerCallback) == null) {
                                        controllerCallback.onCurrentMediaItemChanged(this.this$1.this$0.mInstance, this.val$currentItem);
                                    }
                                }
                            });
                        }
                    }
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, playbackStateCompat) == null) {
                synchronized (this.this$0.mLock) {
                    if (!this.this$0.mClosed && this.this$0.mConnected) {
                        MediaItem mediaItem = this.this$0.mCurrentMediaItem;
                        PlaybackStateCompat playbackStateCompat2 = this.this$0.mPlaybackStateCompat;
                        this.this$0.mPlaybackStateCompat = playbackStateCompat;
                        this.this$0.mPlayerState = MediaUtils.convertToPlayerState(playbackStateCompat);
                        this.this$0.mBufferedPosition = playbackStateCompat == null ? Long.MIN_VALUE : playbackStateCompat.getBufferedPosition();
                        if (this.this$0.mQueue != null && playbackStateCompat != null) {
                            for (int i = 0; i < this.this$0.mQueue.size(); i++) {
                                if (this.this$0.mQueue.get(i).getQueueId() == playbackStateCompat.getActiveQueueItemId()) {
                                    this.this$0.mCurrentMediaItemIndex = i;
                                    this.this$0.mCurrentMediaItem = this.this$0.mPlaylist.get(i);
                                }
                            }
                        }
                        MediaItem mediaItem2 = this.this$0.mCurrentMediaItem;
                        List<MediaSession.CommandButton> list = this.this$0.mCustomLayout;
                        this.this$0.mCustomLayout = MediaUtils.convertToCustomLayout(playbackStateCompat);
                        List<MediaSession.CommandButton> list2 = this.this$0.mCustomLayout;
                        SessionCommandGroup sessionCommandGroup = this.this$0.mAllowedCommands;
                        this.this$0.mAllowedCommands = MediaUtils.convertToSessionCommandGroup(this.this$0.mControllerCompat.getFlags(), this.this$0.mPlaybackStateCompat);
                        SessionCommandGroup sessionCommandGroup2 = this.this$0.mAllowedCommands;
                        if (mediaItem != mediaItem2) {
                            this.this$0.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable(this, mediaItem2) { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ ControllerCompatCallback this$1;
                                public final /* synthetic */ MediaItem val$currentItem;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, mediaItem2};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                    this.val$currentItem = mediaItem2;
                                }

                                @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                                public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, controllerCallback) == null) {
                                        controllerCallback.onCurrentMediaItemChanged(this.this$1.this$0.mInstance, this.val$currentItem);
                                    }
                                }
                            });
                        }
                        if (playbackStateCompat == null) {
                            if (playbackStateCompat2 != null) {
                                this.this$0.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable(this) { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.3
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ ControllerCompatCallback this$1;

                                    {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this};
                                            interceptable2.invokeUnInit(65536, newInitContext);
                                            int i2 = newInitContext.flag;
                                            if ((i2 & 1) != 0) {
                                                int i3 = i2 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable2.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$1 = this;
                                    }

                                    @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                                    public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, controllerCallback) == null) {
                                            controllerCallback.onPlayerStateChanged(this.this$1.this$0.mInstance, 0);
                                        }
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        if (playbackStateCompat2 == null || playbackStateCompat2.getState() != playbackStateCompat.getState()) {
                            this.this$0.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable(this, playbackStateCompat) { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.4
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ ControllerCompatCallback this$1;
                                public final /* synthetic */ PlaybackStateCompat val$state;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, playbackStateCompat};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                    this.val$state = playbackStateCompat;
                                }

                                @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                                public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, controllerCallback) == null) {
                                        controllerCallback.onPlayerStateChanged(this.this$1.this$0.mInstance, MediaUtils.convertToPlayerState(this.val$state));
                                    }
                                }
                            });
                        }
                        if (playbackStateCompat2 == null || playbackStateCompat2.getPlaybackSpeed() != playbackStateCompat.getPlaybackSpeed()) {
                            this.this$0.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable(this, playbackStateCompat) { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.5
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ ControllerCompatCallback this$1;
                                public final /* synthetic */ PlaybackStateCompat val$state;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, playbackStateCompat};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                    this.val$state = playbackStateCompat;
                                }

                                @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                                public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, controllerCallback) == null) {
                                        controllerCallback.onPlaybackSpeedChanged(this.this$1.this$0.mInstance, this.val$state.getPlaybackSpeed());
                                    }
                                }
                            });
                        }
                        if (playbackStateCompat2 != null) {
                            long currentPosition = playbackStateCompat.getCurrentPosition(this.this$0.mInstance.mTimeDiff);
                            if (Math.abs(currentPosition - playbackStateCompat2.getCurrentPosition(this.this$0.mInstance.mTimeDiff)) > 100) {
                                this.this$0.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable(this, currentPosition) { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.6
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ ControllerCompatCallback this$1;
                                    public final /* synthetic */ long val$currentPosition;

                                    {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, Long.valueOf(currentPosition)};
                                            interceptable2.invokeUnInit(65536, newInitContext);
                                            int i2 = newInitContext.flag;
                                            if ((i2 & 1) != 0) {
                                                int i3 = i2 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable2.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$1 = this;
                                        this.val$currentPosition = currentPosition;
                                    }

                                    @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                                    public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, controllerCallback) == null) {
                                            controllerCallback.onSeekCompleted(this.this$1.this$0.mInstance, this.val$currentPosition);
                                        }
                                    }
                                });
                            }
                        }
                        if (!sessionCommandGroup.equals(sessionCommandGroup2)) {
                            this.this$0.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable(this, sessionCommandGroup2) { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.7
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ ControllerCompatCallback this$1;
                                public final /* synthetic */ SessionCommandGroup val$currentAllowedCommands;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, sessionCommandGroup2};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                    this.val$currentAllowedCommands = sessionCommandGroup2;
                                }

                                @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                                public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, controllerCallback) == null) {
                                        controllerCallback.onAllowedCommandsChanged(this.this$1.this$0.mInstance, this.val$currentAllowedCommands);
                                    }
                                }
                            });
                        }
                        boolean z = true;
                        if (list.size() == list2.size()) {
                            int i2 = 0;
                            while (true) {
                                if (i2 >= list2.size()) {
                                    z = false;
                                    break;
                                } else if (!ObjectsCompat.equals(list.get(i2).getCommand(), list2.get(i2).getCommand())) {
                                    break;
                                } else {
                                    i2++;
                                }
                            }
                        }
                        if (z) {
                            this.this$0.mInstance.notifyPrimaryControllerCallback(new MediaController.ControllerCallbackRunnable(this, list2) { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.8
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ ControllerCompatCallback this$1;
                                public final /* synthetic */ List val$currentLayout;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, list2};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i3 = newInitContext.flag;
                                        if ((i3 & 1) != 0) {
                                            int i4 = i3 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                    this.val$currentLayout = list2;
                                }

                                @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                                public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, controllerCallback) == null) {
                                        controllerCallback.onSetCustomLayout(this.this$1.this$0.mInstance, this.val$currentLayout);
                                    }
                                }
                            });
                        }
                        if (mediaItem2 == null) {
                            return;
                        }
                        int bufferingState = MediaUtils.toBufferingState(playbackStateCompat.getState());
                        if (bufferingState != (playbackStateCompat2 != null ? MediaUtils.toBufferingState(playbackStateCompat2.getState()) : 0)) {
                            this.this$0.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable(this, mediaItem2, bufferingState) { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.9
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ ControllerCompatCallback this$1;
                                public final /* synthetic */ int val$bufferingState;
                                public final /* synthetic */ MediaItem val$currentItem;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, mediaItem2, Integer.valueOf(bufferingState)};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i3 = newInitContext.flag;
                                        if ((i3 & 1) != 0) {
                                            int i4 = i3 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                    this.val$currentItem = mediaItem2;
                                    this.val$bufferingState = bufferingState;
                                }

                                @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                                public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, controllerCallback) == null) {
                                        controllerCallback.onBufferingStateChanged(this.this$1.this$0.mInstance, this.val$currentItem, this.val$bufferingState);
                                    }
                                }
                            });
                        }
                    }
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onQueueChanged(List<MediaSessionCompat.QueueItem> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
                synchronized (this.this$0.mLock) {
                    if (!this.this$0.mClosed && this.this$0.mConnected) {
                        this.this$0.mQueue = MediaUtils.removeNullElements(list);
                        if (this.this$0.mQueue != null && this.this$0.mQueue.size() != 0) {
                            this.this$0.mPlaylist = MediaUtils.convertQueueItemListToMediaItemList(this.this$0.mQueue);
                            this.this$0.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable(this, this.this$0.mPlaylist, this.this$0.mPlaylistMetadata) { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.11
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ ControllerCompatCallback this$1;
                                public final /* synthetic */ List val$playlist;
                                public final /* synthetic */ MediaMetadata val$playlistMetadata;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, r7, r8};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i = newInitContext.flag;
                                        if ((i & 1) != 0) {
                                            int i2 = i & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                    this.val$playlist = r7;
                                    this.val$playlistMetadata = r8;
                                }

                                @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                                public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, controllerCallback) == null) {
                                        controllerCallback.onPlaylistChanged(this.this$1.this$0.mInstance, this.val$playlist, this.val$playlistMetadata);
                                    }
                                }
                            });
                        }
                        this.this$0.mQueue = null;
                        this.this$0.mPlaylist = null;
                        this.this$0.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable(this, this.this$0.mPlaylist, this.this$0.mPlaylistMetadata) { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.11
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ ControllerCompatCallback this$1;
                            public final /* synthetic */ List val$playlist;
                            public final /* synthetic */ MediaMetadata val$playlistMetadata;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = objArr;
                                    Object[] objArr = {this, r7, r8};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                                this.val$playlist = r7;
                                this.val$playlistMetadata = r8;
                            }

                            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, controllerCallback) == null) {
                                    controllerCallback.onPlaylistChanged(this.this$1.this$0.mInstance, this.val$playlist, this.val$playlistMetadata);
                                }
                            }
                        });
                    }
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onQueueTitleChanged(CharSequence charSequence) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, charSequence) == null) {
                synchronized (this.this$0.mLock) {
                    if (!this.this$0.mClosed && this.this$0.mConnected) {
                        this.this$0.mPlaylistMetadata = MediaUtils.convertToMediaMetadata(charSequence);
                        this.this$0.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable(this, this.this$0.mPlaylistMetadata) { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.12
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ ControllerCompatCallback this$1;
                            public final /* synthetic */ MediaMetadata val$playlistMetadata;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, r7};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                                this.val$playlistMetadata = r7;
                            }

                            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, controllerCallback) == null) {
                                    controllerCallback.onPlaylistMetadataChanged(this.this$1.this$0.mInstance, this.val$playlistMetadata);
                                }
                            }
                        });
                    }
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onRepeatModeChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
                synchronized (this.this$0.mLock) {
                    if (!this.this$0.mClosed && this.this$0.mConnected) {
                        this.this$0.mRepeatMode = i;
                        this.this$0.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable(this, i) { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.16
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ ControllerCompatCallback this$1;
                            public final /* synthetic */ int val$repeatMode;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, Integer.valueOf(i)};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                                this.val$repeatMode = i;
                            }

                            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, controllerCallback) == null) {
                                    controllerCallback.onRepeatModeChanged(this.this$1.this$0.mInstance, this.val$repeatMode);
                                }
                            }
                        });
                    }
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onSessionDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                this.this$0.close();
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onSessionEvent(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, str, bundle) == null) {
                synchronized (this.this$0.mLock) {
                    if (!this.this$0.mClosed && this.this$0.mConnected) {
                        this.this$0.mInstance.notifyPrimaryControllerCallback(new MediaController.ControllerCallbackRunnable(this, str, bundle) { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ ControllerCompatCallback this$1;
                            public final /* synthetic */ String val$event;
                            public final /* synthetic */ Bundle val$extras;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, str, bundle};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                                this.val$event = str;
                                this.val$extras = bundle;
                            }

                            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, controllerCallback) == null) {
                                    controllerCallback.onCustomCommand(this.this$1.this$0.mInstance, new SessionCommand(this.val$event, null), this.val$extras);
                                }
                            }
                        });
                    }
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
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                synchronized (this.this$0.mLock) {
                    z = this.this$0.mConnected;
                }
                if (!z) {
                    this.this$0.onConnectedNotLocked();
                    return;
                }
                synchronized (this.this$0.mLock) {
                    playbackState = this.this$0.mControllerCompat.getPlaybackState();
                    shuffleMode = this.this$0.mControllerCompat.getShuffleMode();
                    repeatMode = this.this$0.mControllerCompat.getRepeatMode();
                    isCaptioningEnabled = this.this$0.mControllerCompat.isCaptioningEnabled();
                }
                onPlaybackStateChanged(playbackState);
                onShuffleModeChanged(shuffleMode);
                onRepeatModeChanged(repeatMode);
                onCaptioningEnabledChanged(isCaptioningEnabled);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onShuffleModeChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
                synchronized (this.this$0.mLock) {
                    if (!this.this$0.mClosed && this.this$0.mConnected) {
                        this.this$0.mShuffleMode = i;
                        this.this$0.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable(this, i) { // from class: androidx.media2.session.MediaControllerImplLegacy.ControllerCompatCallback.17
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ ControllerCompatCallback this$1;
                            public final /* synthetic */ int val$shuffleMode;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, Integer.valueOf(i)};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                                this.val$shuffleMode = i;
                            }

                            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, controllerCallback) == null) {
                                    controllerCallback.onShuffleModeChanged(this.this$1.this$0.mInstance, this.val$shuffleMode);
                                }
                            }
                        });
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1841805138, "Landroidx/media2/session/MediaControllerImplLegacy;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1841805138, "Landroidx/media2/session/MediaControllerImplLegacy;");
                return;
            }
        }
        DEBUG = Log.isLoggable(TAG, 3);
    }

    public MediaControllerImplLegacy(@NonNull Context context, @NonNull MediaController mediaController, @NonNull SessionToken sessionToken) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mediaController, sessionToken};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mLock = new Object();
        this.mSkipToPlaylistIndex = -1;
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

    private void connectToService() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.mHandler.post(new Runnable(this) { // from class: androidx.media2.session.MediaControllerImplLegacy.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaControllerImplLegacy this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.this$0.mLock) {
                            this.this$0.mBrowserCompat = new MediaBrowserCompat(this.this$0.mContext, this.this$0.mToken.getComponentName(), new ConnectionCallback(this.this$0), null);
                            this.this$0.mBrowserCompat.connect();
                        }
                    }
                }
            });
        }
    }

    private ListenableFuture<SessionResult> createFutureWithResult(int i) {
        InterceptResult invokeI;
        MediaItem mediaItem;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, this, i)) == null) {
            synchronized (this.mLock) {
                mediaItem = this.mCurrentMediaItem;
            }
            ResolvableFuture create = ResolvableFuture.create();
            create.set(new SessionResult(i, null, mediaItem));
            return create;
        }
        return (ListenableFuture) invokeI.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> addPlaylistItem(int i, @NonNull String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, str)) == null) {
            synchronized (this.mLock) {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return createFutureWithResult(-100);
                }
                this.mControllerCompat.addQueueItem(MediaUtils.createMediaDescriptionCompat(str), i);
                return createFutureWithResult(0);
            }
        }
        return (ListenableFuture) invokeIL.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> adjustVolume(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2)) == null) {
            synchronized (this.mLock) {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return createFutureWithResult(-100);
                }
                this.mControllerCompat.adjustVolume(i, i2);
                return createFutureWithResult(0);
            }
        }
        return (ListenableFuture) invokeII.objValue;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
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
                this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable(this) { // from class: androidx.media2.session.MediaControllerImplLegacy.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MediaControllerImplLegacy this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                    public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, controllerCallback) == null) {
                            controllerCallback.onDisconnected(this.this$0.mInstance);
                        }
                    }
                });
            }
        }
    }

    public void connectToSession(MediaSessionCompat.Token token) {
        boolean isSessionReady;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, token) == null) {
            MediaControllerCompat mediaControllerCompat = new MediaControllerCompat(this.mContext, token);
            synchronized (this.mLock) {
                this.mControllerCompat = mediaControllerCompat;
                this.mControllerCompatCallback = new ControllerCompatCallback(this);
                isSessionReady = this.mControllerCompat.isSessionReady();
                this.mControllerCompat.registerCallback(this.mControllerCompatCallback, this.mHandler);
            }
            if (isSessionReady) {
                return;
            }
            onConnectedNotLocked();
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @NonNull
    public ListenableFuture<SessionResult> deselectTrack(@NonNull SessionPlayer.TrackInfo trackInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, trackInfo)) == null) {
            Log.w(TAG, "Session doesn't support deselecting track");
            return createFutureWithResult(-6);
        }
        return (ListenableFuture) invokeL.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> fastForward() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this.mLock) {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return createFutureWithResult(-100);
                }
                this.mControllerCompat.getTransportControls().fastForward();
                return createFutureWithResult(0);
            }
        }
        return (ListenableFuture) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public SessionCommandGroup getAllowedCommands() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this.mLock) {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return null;
                }
                return this.mAllowedCommands;
            }
        }
        return (SessionCommandGroup) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @Nullable
    public MediaBrowserCompat getBrowserCompat() {
        InterceptResult invokeV;
        MediaBrowserCompat mediaBrowserCompat;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this.mLock) {
                mediaBrowserCompat = this.mBrowserCompat;
            }
            return mediaBrowserCompat;
        }
        return (MediaBrowserCompat) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public long getBufferedPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
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
        return invokeV.longValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public int getBufferingState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
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
        return invokeV.intValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @Nullable
    public SessionToken getConnectedToken() {
        InterceptResult invokeV;
        SessionToken sessionToken;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            synchronized (this.mLock) {
                sessionToken = this.mConnected ? this.mToken : null;
            }
            return sessionToken;
        }
        return (SessionToken) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @NonNull
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mContext : (Context) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public MediaItem getCurrentMediaItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            synchronized (this.mLock) {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return null;
                }
                return this.mCurrentMediaItem;
            }
        }
        return (MediaItem) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public int getCurrentMediaItemIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mCurrentMediaItemIndex : invokeV.intValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public long getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            synchronized (this.mLock) {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return Long.MIN_VALUE;
                } else if (this.mPlaybackStateCompat != null) {
                    return this.mPlaybackStateCompat.getCurrentPosition(this.mInstance.mTimeDiff);
                } else {
                    return Long.MIN_VALUE;
                }
            }
        }
        return invokeV.longValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public long getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
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
        return invokeV.longValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public int getNextMediaItemIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @Nullable
    public MediaController.PlaybackInfo getPlaybackInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            synchronized (this.mLock) {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return null;
                }
                return this.mPlaybackInfo;
            }
        }
        return (MediaController.PlaybackInfo) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public float getPlaybackSpeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
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
        return invokeV.floatValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public int getPlayerState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            synchronized (this.mLock) {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return 3;
                }
                return this.mPlayerState;
            }
        }
        return invokeV.intValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @Nullable
    public List<MediaItem> getPlaylist() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
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
        return (List) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @Nullable
    public MediaMetadata getPlaylistMetadata() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            synchronized (this.mLock) {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return null;
                }
                return this.mPlaylistMetadata;
            }
        }
        return (MediaMetadata) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public int getPreviousMediaItemIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public int getRepeatMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            synchronized (this.mLock) {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return 0;
                }
                return this.mRepeatMode;
            }
        }
        return invokeV.intValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @Nullable
    public SessionPlayer.TrackInfo getSelectedTrack(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i)) == null) {
            Log.w(TAG, "Session doesn't support getting selected track");
            return null;
        }
        return (SessionPlayer.TrackInfo) invokeI.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @Nullable
    public PendingIntent getSessionActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            synchronized (this.mLock) {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return null;
                }
                return this.mControllerCompat.getSessionActivity();
            }
        }
        return (PendingIntent) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public int getShuffleMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            synchronized (this.mLock) {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return 0;
                }
                return this.mShuffleMode;
            }
        }
        return invokeV.intValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @NonNull
    public List<SessionPlayer.TrackInfo> getTracks() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            Log.w(TAG, "Session doesn't support getting TrackInfo");
            return Collections.emptyList();
        }
        return (List) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @NonNull
    public VideoSize getVideoSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            Log.w(TAG, "Session doesn't support getting VideoSize");
            return new VideoSize(0, 0);
        }
        return (VideoSize) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public boolean isConnected() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            synchronized (this.mLock) {
                z = this.mConnected;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> movePlaylistItem(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048606, this, i, i2)) == null) ? createFutureWithResult(-6) : (ListenableFuture) invokeII.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onConnectedNotLocked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            if (DEBUG) {
                Log.d(TAG, "onConnectedNotLocked token=" + this.mToken);
            }
            synchronized (this.mLock) {
                if (!this.mClosed && !this.mConnected) {
                    this.mPlaybackStateCompat = this.mControllerCompat.getPlaybackState();
                    this.mAllowedCommands = MediaUtils.convertToSessionCommandGroup(this.mControllerCompat.getFlags(), this.mPlaybackStateCompat);
                    this.mPlayerState = MediaUtils.convertToPlayerState(this.mPlaybackStateCompat);
                    this.mBufferedPosition = this.mPlaybackStateCompat == null ? Long.MIN_VALUE : this.mPlaybackStateCompat.getBufferedPosition();
                    List<MediaSession.CommandButton> convertToCustomLayout = MediaUtils.convertToCustomLayout(this.mPlaybackStateCompat);
                    this.mCustomLayout = convertToCustomLayout;
                    SessionCommandGroup sessionCommandGroup = this.mAllowedCommands;
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
                        this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable(this, sessionCommandGroup) { // from class: androidx.media2.session.MediaControllerImplLegacy.3
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ MediaControllerImplLegacy this$0;
                            public final /* synthetic */ SessionCommandGroup val$allowedCommands;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, sessionCommandGroup};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                                this.val$allowedCommands = sessionCommandGroup;
                            }

                            @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                            public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, controllerCallback) == null) {
                                    controllerCallback.onConnected(this.this$0.mInstance, this.val$allowedCommands);
                                }
                            }
                        });
                        if (convertToCustomLayout.isEmpty()) {
                            this.mInstance.notifyPrimaryControllerCallback(new MediaController.ControllerCallbackRunnable(this, convertToCustomLayout) { // from class: androidx.media2.session.MediaControllerImplLegacy.4
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ MediaControllerImplLegacy this$0;
                                public final /* synthetic */ List val$customLayout;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, convertToCustomLayout};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i = newInitContext.flag;
                                        if ((i & 1) != 0) {
                                            int i2 = i & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$0 = this;
                                    this.val$customLayout = convertToCustomLayout;
                                }

                                @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                                public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, controllerCallback) == null) {
                                        controllerCallback.onSetCustomLayout(this.this$0.mInstance, this.val$customLayout);
                                    }
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
                    this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable(this, sessionCommandGroup) { // from class: androidx.media2.session.MediaControllerImplLegacy.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ MediaControllerImplLegacy this$0;
                        public final /* synthetic */ SessionCommandGroup val$allowedCommands;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = objArr;
                                Object[] objArr = {this, sessionCommandGroup};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$allowedCommands = sessionCommandGroup;
                        }

                        @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                        public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, controllerCallback) == null) {
                                controllerCallback.onConnected(this.this$0.mInstance, this.val$allowedCommands);
                            }
                        }
                    });
                    if (convertToCustomLayout.isEmpty()) {
                    }
                }
            }
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> pause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            synchronized (this.mLock) {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return createFutureWithResult(-100);
                }
                this.mControllerCompat.getTransportControls().pause();
                return createFutureWithResult(0);
            }
        }
        return (ListenableFuture) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> play() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            synchronized (this.mLock) {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return createFutureWithResult(-100);
                }
                this.mControllerCompat.getTransportControls().play();
                return createFutureWithResult(0);
            }
        }
        return (ListenableFuture) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> prepare() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            synchronized (this.mLock) {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return createFutureWithResult(-100);
                }
                this.mControllerCompat.getTransportControls().prepare();
                return createFutureWithResult(0);
            }
        }
        return (ListenableFuture) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> removePlaylistItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i)) == null) {
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
        return (ListenableFuture) invokeI.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> replacePlaylistItem(int i, @NonNull String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048612, this, i, str)) == null) {
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
        return (ListenableFuture) invokeIL.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> rewind() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            synchronized (this.mLock) {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return createFutureWithResult(-100);
                }
                this.mControllerCompat.getTransportControls().rewind();
                return createFutureWithResult(0);
            }
        }
        return (ListenableFuture) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> seekTo(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048614, this, j)) == null) {
            synchronized (this.mLock) {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return createFutureWithResult(-100);
                }
                this.mControllerCompat.getTransportControls().seekTo(j);
                return createFutureWithResult(0);
            }
        }
        return (ListenableFuture) invokeJ.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @NonNull
    public ListenableFuture<SessionResult> selectTrack(@NonNull SessionPlayer.TrackInfo trackInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, trackInfo)) == null) {
            Log.w(TAG, "Session doesn't support selecting track");
            return createFutureWithResult(-6);
        }
        return (ListenableFuture) invokeL.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> sendCustomCommand(@NonNull SessionCommand sessionCommand, @Nullable Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048616, this, sessionCommand, bundle)) == null) {
            synchronized (this.mLock) {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return createFutureWithResult(-100);
                } else if (this.mAllowedCommands.hasCommand(sessionCommand)) {
                    this.mControllerCompat.getTransportControls().sendCustomAction(sessionCommand.getCustomAction(), bundle);
                    return createFutureWithResult(0);
                } else {
                    ResolvableFuture create = ResolvableFuture.create();
                    this.mControllerCompat.sendCommand(sessionCommand.getCustomAction(), bundle, new ResultReceiver(this, this.mHandler, create) { // from class: androidx.media2.session.MediaControllerImplLegacy.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ MediaControllerImplLegacy this$0;
                        public final /* synthetic */ ResolvableFuture val$result;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(r8);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, r8, create};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    super((Handler) newInitContext.callArgs[0]);
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$result = create;
                        }

                        @Override // android.os.ResultReceiver
                        public void onReceiveResult(int i, Bundle bundle2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i, bundle2) == null) {
                                this.val$result.set(new SessionResult(i, bundle2));
                            }
                        }
                    });
                    return create;
                }
            }
        }
        return (ListenableFuture) invokeLL.objValue;
    }

    public void setCurrentMediaItemLocked(MediaMetadataCompat mediaMetadataCompat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, mediaMetadataCompat) == null) {
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
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> setMediaItem(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, str)) == null) ? createFutureWithResult(-6) : (ListenableFuture) invokeL.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> setMediaUri(@NonNull Uri uri, @Nullable Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048619, this, uri, bundle)) == null) ? createFutureWithResult(-6) : (ListenableFuture) invokeLL.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> setPlaybackSpeed(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048620, this, f)) == null) {
            synchronized (this.mLock) {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return createFutureWithResult(-100);
                }
                this.mControllerCompat.getTransportControls().setPlaybackSpeed(f);
                return createFutureWithResult(0);
            }
        }
        return (ListenableFuture) invokeF.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> setPlaylist(@NonNull List<String> list, @Nullable MediaMetadata mediaMetadata) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048621, this, list, mediaMetadata)) == null) ? createFutureWithResult(-6) : (ListenableFuture) invokeLL.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> setRating(@NonNull String str, @NonNull Rating rating) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048622, this, str, rating)) == null) {
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
        return (ListenableFuture) invokeLL.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> setRepeatMode(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048623, this, i)) == null) {
            synchronized (this.mLock) {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return createFutureWithResult(-100);
                }
                this.mControllerCompat.getTransportControls().setRepeatMode(i);
                return createFutureWithResult(0);
            }
        }
        return (ListenableFuture) invokeI.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> setShuffleMode(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048624, this, i)) == null) {
            synchronized (this.mLock) {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return createFutureWithResult(-100);
                }
                this.mControllerCompat.getTransportControls().setShuffleMode(i);
                return createFutureWithResult(0);
            }
        }
        return (ListenableFuture) invokeI.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> setSurface(@Nullable Surface surface) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, surface)) == null) {
            Log.w(TAG, "Session doesn't support setting Surface");
            return createFutureWithResult(-6);
        }
        return (ListenableFuture) invokeL.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> setVolumeTo(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048626, this, i, i2)) == null) {
            synchronized (this.mLock) {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return createFutureWithResult(-100);
                }
                this.mControllerCompat.setVolumeTo(i, i2);
                return createFutureWithResult(0);
            }
        }
        return (ListenableFuture) invokeII.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> skipBackward() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? createFutureWithResult(-6) : (ListenableFuture) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> skipForward() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? createFutureWithResult(-6) : (ListenableFuture) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> skipToNextItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            synchronized (this.mLock) {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return createFutureWithResult(-100);
                }
                this.mControllerCompat.getTransportControls().skipToNext();
                return createFutureWithResult(0);
            }
        }
        return (ListenableFuture) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> skipToPlaylistItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048630, this, i)) == null) {
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
        return (ListenableFuture) invokeI.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> skipToPreviousItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            synchronized (this.mLock) {
                if (!this.mConnected) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return createFutureWithResult(-100);
                }
                this.mControllerCompat.getTransportControls().skipToPrevious();
                return createFutureWithResult(0);
            }
        }
        return (ListenableFuture) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> updatePlaylistMetadata(@Nullable MediaMetadata mediaMetadata) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048632, this, mediaMetadata)) == null) ? createFutureWithResult(-6) : (ListenableFuture) invokeL.objValue;
    }
}
