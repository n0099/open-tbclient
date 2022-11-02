package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaDescription;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.RemoteControlClient;
import android.media.VolumeProvider;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.app.BundleCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.media.MediaSessionManager;
import androidx.media.VolumeProviderCompat;
import androidx.media.session.MediaButtonReceiver;
import androidx.versionedparcelable.ParcelUtils;
import androidx.versionedparcelable.VersionedParcelable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class MediaSessionCompat {
    public static /* synthetic */ Interceptable $ic = null;
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_ARGUMENT_CAPTIONING_ENABLED = "android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_ARGUMENT_EXTRAS = "android.support.v4.media.session.action.ARGUMENT_EXTRAS";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_ARGUMENT_MEDIA_ID = "android.support.v4.media.session.action.ARGUMENT_MEDIA_ID";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_ARGUMENT_PLAYBACK_SPEED = "android.support.v4.media.session.action.ARGUMENT_PLAYBACK_SPEED";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_ARGUMENT_QUERY = "android.support.v4.media.session.action.ARGUMENT_QUERY";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_ARGUMENT_RATING = "android.support.v4.media.session.action.ARGUMENT_RATING";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_ARGUMENT_REPEAT_MODE = "android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_ARGUMENT_SHUFFLE_MODE = "android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_ARGUMENT_URI = "android.support.v4.media.session.action.ARGUMENT_URI";
    public static final String ACTION_FLAG_AS_INAPPROPRIATE = "android.support.v4.media.session.action.FLAG_AS_INAPPROPRIATE";
    public static final String ACTION_FOLLOW = "android.support.v4.media.session.action.FOLLOW";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_PLAY_FROM_URI = "android.support.v4.media.session.action.PLAY_FROM_URI";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_PREPARE = "android.support.v4.media.session.action.PREPARE";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_PREPARE_FROM_MEDIA_ID = "android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_PREPARE_FROM_SEARCH = "android.support.v4.media.session.action.PREPARE_FROM_SEARCH";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_PREPARE_FROM_URI = "android.support.v4.media.session.action.PREPARE_FROM_URI";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_SET_CAPTIONING_ENABLED = "android.support.v4.media.session.action.SET_CAPTIONING_ENABLED";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_SET_PLAYBACK_SPEED = "android.support.v4.media.session.action.SET_PLAYBACK_SPEED";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_SET_RATING = "android.support.v4.media.session.action.SET_RATING";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_SET_REPEAT_MODE = "android.support.v4.media.session.action.SET_REPEAT_MODE";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_SET_SHUFFLE_MODE = "android.support.v4.media.session.action.SET_SHUFFLE_MODE";
    public static final String ACTION_SKIP_AD = "android.support.v4.media.session.action.SKIP_AD";
    public static final String ACTION_UNFOLLOW = "android.support.v4.media.session.action.UNFOLLOW";
    public static final String ARGUMENT_MEDIA_ATTRIBUTE = "android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE";
    public static final String ARGUMENT_MEDIA_ATTRIBUTE_VALUE = "android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE_VALUE";
    public static final String DATA_CALLING_PACKAGE = "data_calling_pkg";
    public static final String DATA_CALLING_PID = "data_calling_pid";
    public static final String DATA_CALLING_UID = "data_calling_uid";
    public static final String DATA_EXTRAS = "data_extras";
    @Deprecated
    public static final int FLAG_HANDLES_MEDIA_BUTTONS = 1;
    public static final int FLAG_HANDLES_QUEUE_COMMANDS = 4;
    @Deprecated
    public static final int FLAG_HANDLES_TRANSPORT_CONTROLS = 2;
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String KEY_EXTRA_BINDER = "android.support.v4.media.session.EXTRA_BINDER";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String KEY_SESSION2_TOKEN = "android.support.v4.media.session.SESSION_TOKEN2";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String KEY_TOKEN = "android.support.v4.media.session.TOKEN";
    public static final int MAX_BITMAP_SIZE_IN_DP = 320;
    public static final int MEDIA_ATTRIBUTE_ALBUM = 1;
    public static final int MEDIA_ATTRIBUTE_ARTIST = 0;
    public static final int MEDIA_ATTRIBUTE_PLAYLIST = 2;
    public static final String TAG = "MediaSessionCompat";
    public static int sMaxBitmapSize;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<OnActiveChangeListener> mActiveListeners;
    public final MediaControllerCompat mController;
    public final MediaSessionImpl mImpl;

    /* loaded from: classes.dex */
    public interface MediaSessionImpl {
        Callback getCallback();

        String getCallingPackage();

        MediaSessionManager.RemoteUserInfo getCurrentControllerInfo();

        Object getMediaSession();

        PlaybackStateCompat getPlaybackState();

        Object getRemoteControlClient();

        Token getSessionToken();

        boolean isActive();

        void release();

        void sendSessionEvent(String str, Bundle bundle);

        void setActive(boolean z);

        void setCallback(Callback callback, Handler handler);

        void setCaptioningEnabled(boolean z);

        void setCurrentControllerInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo);

        void setExtras(Bundle bundle);

        void setFlags(int i);

        void setMediaButtonReceiver(PendingIntent pendingIntent);

        void setMetadata(MediaMetadataCompat mediaMetadataCompat);

        void setPlaybackState(PlaybackStateCompat playbackStateCompat);

        void setPlaybackToLocal(int i);

        void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat);

        void setQueue(List<QueueItem> list);

        void setQueueTitle(CharSequence charSequence);

        void setRatingType(int i);

        void setRepeatMode(int i);

        void setSessionActivity(PendingIntent pendingIntent);

        void setShuffleMode(int i);
    }

    /* loaded from: classes.dex */
    public interface OnActiveChangeListener {
        void onActiveChanged();
    }

    /* loaded from: classes.dex */
    public static abstract class Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final MediaSession.Callback mCallbackFwk;
        @GuardedBy("mLock")
        public CallbackHandler mCallbackHandler;
        public final Object mLock;
        public boolean mMediaPlayPausePendingOnHandler;
        @GuardedBy("mLock")
        public WeakReference<MediaSessionImpl> mSessionImpl;

        public void onAddQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaDescriptionCompat) == null) {
            }
        }

        public void onAddQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, mediaDescriptionCompat, i) == null) {
            }
        }

        public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, bundle, resultReceiver) == null) {
            }
        }

        public void onCustomAction(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, str, bundle) == null) {
            }
        }

        public void onFastForward() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            }
        }

        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            }
        }

        public void onPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            }
        }

        public void onPlayFromMediaId(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, str, bundle) == null) {
            }
        }

        public void onPlayFromSearch(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048586, this, str, bundle) == null) {
            }
        }

        public void onPlayFromUri(Uri uri, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, uri, bundle) == null) {
            }
        }

        public void onPrepare() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            }
        }

        public void onPrepareFromMediaId(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048589, this, str, bundle) == null) {
            }
        }

        public void onPrepareFromSearch(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048590, this, str, bundle) == null) {
            }
        }

        public void onPrepareFromUri(Uri uri, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048591, this, uri, bundle) == null) {
            }
        }

        public void onRemoveQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, mediaDescriptionCompat) == null) {
            }
        }

        @Deprecated
        public void onRemoveQueueItemAt(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            }
        }

        public void onRewind() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            }
        }

        public void onSeekTo(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048595, this, j) == null) {
            }
        }

        public void onSetCaptioningEnabled(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            }
        }

        public void onSetPlaybackSpeed(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048597, this, f) == null) {
            }
        }

        public void onSetRating(RatingCompat ratingCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048598, this, ratingCompat) == null) {
            }
        }

        public void onSetRating(RatingCompat ratingCompat, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048599, this, ratingCompat, bundle) == null) {
            }
        }

        public void onSetRepeatMode(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            }
        }

        public void onSetShuffleMode(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            }
        }

        public void onSkipToNext() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            }
        }

        public void onSkipToPrevious() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            }
        }

        public void onSkipToQueueItem(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048604, this, j) == null) {
            }
        }

        public void onStop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            }
        }

        /* loaded from: classes.dex */
        public class CallbackHandler extends Handler {
            public static /* synthetic */ Interceptable $ic = null;
            public static final int MSG_MEDIA_PLAY_PAUSE_KEY_DOUBLE_TAP_TIMEOUT = 1;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Callback this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CallbackHandler(Callback callback, Looper looper) {
                super(looper);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {callback, looper};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((Looper) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = callback;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                MediaSessionImpl mediaSessionImpl;
                CallbackHandler callbackHandler;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 1) {
                    synchronized (this.this$0.mLock) {
                        mediaSessionImpl = this.this$0.mSessionImpl.get();
                        callbackHandler = this.this$0.mCallbackHandler;
                    }
                    if (mediaSessionImpl != null && this.this$0 == mediaSessionImpl.getCallback() && callbackHandler != null) {
                        mediaSessionImpl.setCurrentControllerInfo((MediaSessionManager.RemoteUserInfo) message.obj);
                        this.this$0.handleMediaPlayPauseIfPendingOnHandler(mediaSessionImpl, callbackHandler);
                        mediaSessionImpl.setCurrentControllerInfo(null);
                    }
                }
            }
        }

        @RequiresApi(21)
        /* loaded from: classes.dex */
        public class MediaSessionCallbackApi21 extends MediaSession.Callback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Callback this$0;

            public void onSetRating(Rating rating, Bundle bundle) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048593, this, rating, bundle) == null) {
                }
            }

            public MediaSessionCallbackApi21(Callback callback) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {callback};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = callback;
            }

            private void clearCurrentControllerInfo(MediaSessionImpl mediaSessionImpl) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(65537, this, mediaSessionImpl) == null) {
                    mediaSessionImpl.setCurrentControllerInfo(null);
                }
            }

            private void setCurrentControllerInfo(MediaSessionImpl mediaSessionImpl) {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeL(65539, this, mediaSessionImpl) != null) || Build.VERSION.SDK_INT >= 28) {
                    return;
                }
                String callingPackage = mediaSessionImpl.getCallingPackage();
                if (TextUtils.isEmpty(callingPackage)) {
                    callingPackage = MediaSessionManager.RemoteUserInfo.LEGACY_CONTROLLER;
                }
                mediaSessionImpl.setCurrentControllerInfo(new MediaSessionManager.RemoteUserInfo(callingPackage, -1, -1));
            }

            @Override // android.media.session.MediaSession.Callback
            public boolean onMediaButtonEvent(Intent intent) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, intent)) == null) {
                    MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                    if (sessionImplIfCallbackIsSet == null) {
                        return false;
                    }
                    setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                    boolean onMediaButtonEvent = this.this$0.onMediaButtonEvent(intent);
                    clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
                    if (!onMediaButtonEvent && !super.onMediaButtonEvent(intent)) {
                        return false;
                    }
                    return true;
                }
                return invokeL.booleanValue;
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSeekTo(long j) {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet;
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeJ(1048590, this, j) != null) || (sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet()) == null) {
                    return;
                }
                setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                this.this$0.onSeekTo(j);
                clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
            }

            @Override // android.media.session.MediaSession.Callback
            @RequiresApi(29)
            public void onSetPlaybackSpeed(float f) {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet;
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeF(1048591, this, f) != null) || (sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet()) == null) {
                    return;
                }
                setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                this.this$0.onSetPlaybackSpeed(f);
                clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSetRating(Rating rating) {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet;
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeL(1048592, this, rating) != null) || (sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet()) == null) {
                    return;
                }
                setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                this.this$0.onSetRating(RatingCompat.fromRating(rating));
                clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSkipToQueueItem(long j) {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet;
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeJ(1048596, this, j) != null) || (sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet()) == null) {
                    return;
                }
                setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                this.this$0.onSkipToQueueItem(j);
                clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
            }

            private MediaSessionImplApi21 getSessionImplIfCallbackIsSet() {
                InterceptResult invokeV;
                MediaSessionImplApi21 mediaSessionImplApi21;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
                    synchronized (this.this$0.mLock) {
                        mediaSessionImplApi21 = (MediaSessionImplApi21) this.this$0.mSessionImpl.get();
                    }
                    if (this.this$0 != mediaSessionImplApi21.getCallback()) {
                        return null;
                    }
                    return mediaSessionImplApi21;
                }
                return (MediaSessionImplApi21) invokeV.objValue;
            }

            @Override // android.media.session.MediaSession.Callback
            public void onFastForward() {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet;
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || (sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet()) == null) {
                    return;
                }
                setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                this.this$0.onFastForward();
                clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPause() {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet;
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || (sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet()) == null) {
                    return;
                }
                setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                this.this$0.onPause();
                clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPlay() {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet;
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || (sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet()) == null) {
                    return;
                }
                setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                this.this$0.onPlay();
                clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
            }

            @Override // android.media.session.MediaSession.Callback
            @RequiresApi(24)
            public void onPrepare() {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet;
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || (sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet()) == null) {
                    return;
                }
                setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                this.this$0.onPrepare();
                clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onRewind() {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet;
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048589, this) != null) || (sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet()) == null) {
                    return;
                }
                setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                this.this$0.onRewind();
                clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSkipToNext() {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet;
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048594, this) != null) || (sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet()) == null) {
                    return;
                }
                setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                this.this$0.onSkipToNext();
                clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSkipToPrevious() {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet;
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048595, this) != null) || (sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet()) == null) {
                    return;
                }
                setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                this.this$0.onSkipToPrevious();
                clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onStop() {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet;
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048597, this) != null) || (sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet()) == null) {
                    return;
                }
                setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                this.this$0.onStop();
                clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet;
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeLLL(1048576, this, str, bundle, resultReceiver) != null) || (sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet()) == null) {
                    return;
                }
                MediaSessionCompat.ensureClassLoader(bundle);
                setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                try {
                    QueueItem queueItem = null;
                    IBinder asBinder = null;
                    queueItem = null;
                    if (str.equals(MediaControllerCompat.COMMAND_GET_EXTRA_BINDER)) {
                        Bundle bundle2 = new Bundle();
                        Token sessionToken = sessionImplIfCallbackIsSet.getSessionToken();
                        IMediaSession extraBinder = sessionToken.getExtraBinder();
                        if (extraBinder != null) {
                            asBinder = extraBinder.asBinder();
                        }
                        BundleCompat.putBinder(bundle2, MediaSessionCompat.KEY_EXTRA_BINDER, asBinder);
                        ParcelUtils.putVersionedParcelable(bundle2, MediaSessionCompat.KEY_SESSION2_TOKEN, sessionToken.getSession2Token());
                        resultReceiver.send(0, bundle2);
                    } else if (str.equals(MediaControllerCompat.COMMAND_ADD_QUEUE_ITEM)) {
                        this.this$0.onAddQueueItem((MediaDescriptionCompat) bundle.getParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION));
                    } else if (str.equals(MediaControllerCompat.COMMAND_ADD_QUEUE_ITEM_AT)) {
                        this.this$0.onAddQueueItem((MediaDescriptionCompat) bundle.getParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION), bundle.getInt(MediaControllerCompat.COMMAND_ARGUMENT_INDEX));
                    } else if (str.equals(MediaControllerCompat.COMMAND_REMOVE_QUEUE_ITEM)) {
                        this.this$0.onRemoveQueueItem((MediaDescriptionCompat) bundle.getParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION));
                    } else if (str.equals(MediaControllerCompat.COMMAND_REMOVE_QUEUE_ITEM_AT)) {
                        if (sessionImplIfCallbackIsSet.mQueue != null) {
                            int i = bundle.getInt(MediaControllerCompat.COMMAND_ARGUMENT_INDEX, -1);
                            if (i >= 0 && i < sessionImplIfCallbackIsSet.mQueue.size()) {
                                queueItem = sessionImplIfCallbackIsSet.mQueue.get(i);
                            }
                            if (queueItem != null) {
                                this.this$0.onRemoveQueueItem(queueItem.getDescription());
                            }
                        }
                    } else {
                        this.this$0.onCommand(str, bundle, resultReceiver);
                    }
                } catch (BadParcelableException unused) {
                    Log.e(MediaSessionCompat.TAG, "Could not unparcel the extra data.");
                }
                clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onCustomAction(String str, Bundle bundle) {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet;
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bundle) != null) || (sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet()) == null) {
                    return;
                }
                MediaSessionCompat.ensureClassLoader(bundle);
                setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                try {
                    if (str.equals(MediaSessionCompat.ACTION_PLAY_FROM_URI)) {
                        Bundle bundle2 = bundle.getBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS);
                        MediaSessionCompat.ensureClassLoader(bundle2);
                        this.this$0.onPlayFromUri((Uri) bundle.getParcelable(MediaSessionCompat.ACTION_ARGUMENT_URI), bundle2);
                    } else if (str.equals(MediaSessionCompat.ACTION_PREPARE)) {
                        this.this$0.onPrepare();
                    } else if (str.equals(MediaSessionCompat.ACTION_PREPARE_FROM_MEDIA_ID)) {
                        String string = bundle.getString(MediaSessionCompat.ACTION_ARGUMENT_MEDIA_ID);
                        Bundle bundle3 = bundle.getBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS);
                        MediaSessionCompat.ensureClassLoader(bundle3);
                        this.this$0.onPrepareFromMediaId(string, bundle3);
                    } else if (str.equals(MediaSessionCompat.ACTION_PREPARE_FROM_SEARCH)) {
                        String string2 = bundle.getString(MediaSessionCompat.ACTION_ARGUMENT_QUERY);
                        Bundle bundle4 = bundle.getBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS);
                        MediaSessionCompat.ensureClassLoader(bundle4);
                        this.this$0.onPrepareFromSearch(string2, bundle4);
                    } else if (str.equals(MediaSessionCompat.ACTION_PREPARE_FROM_URI)) {
                        Bundle bundle5 = bundle.getBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS);
                        MediaSessionCompat.ensureClassLoader(bundle5);
                        this.this$0.onPrepareFromUri((Uri) bundle.getParcelable(MediaSessionCompat.ACTION_ARGUMENT_URI), bundle5);
                    } else if (str.equals(MediaSessionCompat.ACTION_SET_CAPTIONING_ENABLED)) {
                        this.this$0.onSetCaptioningEnabled(bundle.getBoolean(MediaSessionCompat.ACTION_ARGUMENT_CAPTIONING_ENABLED));
                    } else if (str.equals(MediaSessionCompat.ACTION_SET_REPEAT_MODE)) {
                        this.this$0.onSetRepeatMode(bundle.getInt(MediaSessionCompat.ACTION_ARGUMENT_REPEAT_MODE));
                    } else if (str.equals(MediaSessionCompat.ACTION_SET_SHUFFLE_MODE)) {
                        this.this$0.onSetShuffleMode(bundle.getInt(MediaSessionCompat.ACTION_ARGUMENT_SHUFFLE_MODE));
                    } else if (str.equals(MediaSessionCompat.ACTION_SET_RATING)) {
                        Bundle bundle6 = bundle.getBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS);
                        MediaSessionCompat.ensureClassLoader(bundle6);
                        this.this$0.onSetRating((RatingCompat) bundle.getParcelable(MediaSessionCompat.ACTION_ARGUMENT_RATING), bundle6);
                    } else if (str.equals(MediaSessionCompat.ACTION_SET_PLAYBACK_SPEED)) {
                        this.this$0.onSetPlaybackSpeed(bundle.getFloat(MediaSessionCompat.ACTION_ARGUMENT_PLAYBACK_SPEED, 1.0f));
                    } else {
                        this.this$0.onCustomAction(str, bundle);
                    }
                } catch (BadParcelableException unused) {
                    Log.e(MediaSessionCompat.TAG, "Could not unparcel the data.");
                }
                clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPlayFromMediaId(String str, Bundle bundle) {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet;
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeLL(1048582, this, str, bundle) != null) || (sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet()) == null) {
                    return;
                }
                MediaSessionCompat.ensureClassLoader(bundle);
                setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                this.this$0.onPlayFromMediaId(str, bundle);
                clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPlayFromSearch(String str, Bundle bundle) {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet;
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeLL(1048583, this, str, bundle) != null) || (sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet()) == null) {
                    return;
                }
                MediaSessionCompat.ensureClassLoader(bundle);
                setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                this.this$0.onPlayFromSearch(str, bundle);
                clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
            }

            @Override // android.media.session.MediaSession.Callback
            @RequiresApi(23)
            public void onPlayFromUri(Uri uri, Bundle bundle) {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet;
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, uri, bundle) != null) || (sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet()) == null) {
                    return;
                }
                MediaSessionCompat.ensureClassLoader(bundle);
                setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                this.this$0.onPlayFromUri(uri, bundle);
                clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
            }

            @Override // android.media.session.MediaSession.Callback
            @RequiresApi(24)
            public void onPrepareFromMediaId(String str, Bundle bundle) {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet;
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeLL(1048586, this, str, bundle) != null) || (sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet()) == null) {
                    return;
                }
                MediaSessionCompat.ensureClassLoader(bundle);
                setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                this.this$0.onPrepareFromMediaId(str, bundle);
                clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
            }

            @Override // android.media.session.MediaSession.Callback
            @RequiresApi(24)
            public void onPrepareFromSearch(String str, Bundle bundle) {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet;
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeLL(1048587, this, str, bundle) != null) || (sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet()) == null) {
                    return;
                }
                MediaSessionCompat.ensureClassLoader(bundle);
                setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                this.this$0.onPrepareFromSearch(str, bundle);
                clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
            }

            @Override // android.media.session.MediaSession.Callback
            @RequiresApi(24)
            public void onPrepareFromUri(Uri uri, Bundle bundle) {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet;
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeLL(1048588, this, uri, bundle) != null) || (sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet()) == null) {
                    return;
                }
                MediaSessionCompat.ensureClassLoader(bundle);
                setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                this.this$0.onPrepareFromUri(uri, bundle);
                clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
            }
        }

        public Callback() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mLock = new Object();
            if (Build.VERSION.SDK_INT >= 21) {
                this.mCallbackFwk = new MediaSessionCallbackApi21(this);
            } else {
                this.mCallbackFwk = null;
            }
            this.mSessionImpl = new WeakReference<>(null);
        }

        public void handleMediaPlayPauseIfPendingOnHandler(MediaSessionImpl mediaSessionImpl, Handler handler) {
            long actions;
            boolean z;
            boolean z2;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048576, this, mediaSessionImpl, handler) != null) || !this.mMediaPlayPausePendingOnHandler) {
                return;
            }
            boolean z3 = false;
            this.mMediaPlayPausePendingOnHandler = false;
            handler.removeMessages(1);
            PlaybackStateCompat playbackState = mediaSessionImpl.getPlaybackState();
            if (playbackState == null) {
                actions = 0;
            } else {
                actions = playbackState.getActions();
            }
            if (playbackState != null && playbackState.getState() == 3) {
                z = true;
            } else {
                z = false;
            }
            if ((516 & actions) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if ((actions & 514) != 0) {
                z3 = true;
            }
            if (z && z3) {
                onPause();
            } else if (!z && z2) {
                onPlay();
            }
        }

        public boolean onMediaButtonEvent(Intent intent) {
            InterceptResult invokeL;
            MediaSessionImpl mediaSessionImpl;
            CallbackHandler callbackHandler;
            KeyEvent keyEvent;
            long actions;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, intent)) == null) {
                if (Build.VERSION.SDK_INT >= 27) {
                    return false;
                }
                synchronized (this.mLock) {
                    mediaSessionImpl = this.mSessionImpl.get();
                    callbackHandler = this.mCallbackHandler;
                }
                if (mediaSessionImpl == null || callbackHandler == null || (keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT")) == null || keyEvent.getAction() != 0) {
                    return false;
                }
                MediaSessionManager.RemoteUserInfo currentControllerInfo = mediaSessionImpl.getCurrentControllerInfo();
                int keyCode = keyEvent.getKeyCode();
                if (keyCode != 79 && keyCode != 85) {
                    handleMediaPlayPauseIfPendingOnHandler(mediaSessionImpl, callbackHandler);
                    return false;
                }
                if (keyEvent.getRepeatCount() == 0) {
                    if (this.mMediaPlayPausePendingOnHandler) {
                        callbackHandler.removeMessages(1);
                        this.mMediaPlayPausePendingOnHandler = false;
                        PlaybackStateCompat playbackState = mediaSessionImpl.getPlaybackState();
                        if (playbackState == null) {
                            actions = 0;
                        } else {
                            actions = playbackState.getActions();
                        }
                        if ((actions & 32) != 0) {
                            onSkipToNext();
                        }
                    } else {
                        this.mMediaPlayPausePendingOnHandler = true;
                        callbackHandler.sendMessageDelayed(callbackHandler.obtainMessage(1, currentControllerInfo), ViewConfiguration.getDoubleTapTimeout());
                    }
                } else {
                    handleMediaPlayPauseIfPendingOnHandler(mediaSessionImpl, callbackHandler);
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        public void setSessionImpl(MediaSessionImpl mediaSessionImpl, Handler handler) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048606, this, mediaSessionImpl, handler) == null) {
                synchronized (this.mLock) {
                    this.mSessionImpl = new WeakReference<>(mediaSessionImpl);
                    CallbackHandler callbackHandler = null;
                    if (this.mCallbackHandler != null) {
                        this.mCallbackHandler.removeCallbacksAndMessages(null);
                    }
                    if (mediaSessionImpl != null && handler != null) {
                        callbackHandler = new CallbackHandler(this, handler.getLooper());
                    }
                    this.mCallbackHandler = callbackHandler;
                }
            }
        }
    }

    @RequiresApi(21)
    /* loaded from: classes.dex */
    public static class MediaSessionImplApi21 implements MediaSessionImpl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @GuardedBy("mLock")
        public Callback mCallback;
        public boolean mCaptioningEnabled;
        public boolean mDestroyed;
        public final RemoteCallbackList<IMediaControllerCallback> mExtraControllerCallbacks;
        public final Object mLock;
        public MediaMetadataCompat mMetadata;
        public PlaybackStateCompat mPlaybackState;
        public List<QueueItem> mQueue;
        public int mRatingType;
        @GuardedBy("mLock")
        public MediaSessionManager.RemoteUserInfo mRemoteUserInfo;
        public int mRepeatMode;
        public final MediaSession mSessionFwk;
        public Bundle mSessionInfo;
        public int mShuffleMode;
        public final Token mToken;

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public Object getRemoteControlClient() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return null;
            }
            return invokeV.objValue;
        }

        /* loaded from: classes.dex */
        public class ExtraSession extends IMediaSession.Stub {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaSessionImplApi21 this$0;

            @Override // android.support.v4.media.session.IMediaSession
            public List<QueueItem> getQueue() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                    return null;
                }
                return (List) invokeV.objValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isShuffleModeEnabledRemoved() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleModeEnabledRemoved(boolean z) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
                }
            }

            public ExtraSession(MediaSessionImplApi21 mediaSessionImplApi21) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mediaSessionImplApi21};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = mediaSessionImplApi21;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, mediaDescriptionCompat) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rate(RatingCompat ratingCompat) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048608, this, ratingCompat) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void registerCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048610, this, iMediaControllerCallback) == null) && !this.this$0.mDestroyed) {
                    this.this$0.mExtraControllerCallbacks.register(iMediaControllerCallback, new MediaSessionManager.RemoteUserInfo(MediaSessionManager.RemoteUserInfo.LEGACY_CONTROLLER, Binder.getCallingPid(), Binder.getCallingUid()));
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048611, this, mediaDescriptionCompat) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItemAt(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048612, this, i) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void seekTo(long j) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeJ(1048614, this, j) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean sendMediaButton(KeyEvent keyEvent) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, keyEvent)) == null) {
                    throw new AssertionError();
                }
                return invokeL.booleanValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setCaptioningEnabled(boolean z) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setPlaybackSpeed(float f) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeF(1048619, this, f) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setRepeatMode(int i) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048620, this, i) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleMode(int i) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048621, this, i) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void skipToQueueItem(long j) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeJ(1048624, this, j) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void unregisterCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048626, this, iMediaControllerCallback) == null) {
                    this.this$0.mExtraControllerCallbacks.unregister(iMediaControllerCallback);
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItemAt(MediaDescriptionCompat mediaDescriptionCompat, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaDescriptionCompat, i) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromMediaId(String str, Bundle bundle) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048600, this, str, bundle) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromSearch(String str, Bundle bundle) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048601, this, str, bundle) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromUri(Uri uri, Bundle bundle) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048602, this, uri, bundle) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromMediaId(String str, Bundle bundle) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048604, this, str, bundle) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromSearch(String str, Bundle bundle) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048605, this, str, bundle) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromUri(Uri uri, Bundle bundle) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048606, this, uri, bundle) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rateWithExtras(RatingCompat ratingCompat, Bundle bundle) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048609, this, ratingCompat, bundle) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCustomAction(String str, Bundle bundle) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048616, this, str, bundle) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void adjustVolume(int i, int i2, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, str) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCommand(String str, Bundle bundle, ResultReceiverWrapper resultReceiverWrapper) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLL(1048615, this, str, bundle, resultReceiverWrapper) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setVolumeTo(int i, int i2, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIIL(1048623, this, i, i2, str) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void fastForward() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public Bundle getExtras() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                    throw new AssertionError();
                }
                return (Bundle) invokeV.objValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public long getFlags() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                    throw new AssertionError();
                }
                return invokeV.longValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public PendingIntent getLaunchPendingIntent() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                    throw new AssertionError();
                }
                return (PendingIntent) invokeV.objValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public MediaMetadataCompat getMetadata() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                    throw new AssertionError();
                }
                return (MediaMetadataCompat) invokeV.objValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public String getPackageName() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                    throw new AssertionError();
                }
                return (String) invokeV.objValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public PlaybackStateCompat getPlaybackState() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                    MediaSessionImplApi21 mediaSessionImplApi21 = this.this$0;
                    return MediaSessionCompat.getStateWithUpdatedPosition(mediaSessionImplApi21.mPlaybackState, mediaSessionImplApi21.mMetadata);
                }
                return (PlaybackStateCompat) invokeV.objValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public CharSequence getQueueTitle() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                    throw new AssertionError();
                }
                return (CharSequence) invokeV.objValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getRatingType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                    return this.this$0.mRatingType;
                }
                return invokeV.intValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getRepeatMode() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                    return this.this$0.mRepeatMode;
                }
                return invokeV.intValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public Bundle getSessionInfo() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                    if (this.this$0.mSessionInfo == null) {
                        return null;
                    }
                    return new Bundle(this.this$0.mSessionInfo);
                }
                return (Bundle) invokeV.objValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getShuffleMode() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                    return this.this$0.mShuffleMode;
                }
                return invokeV.intValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public String getTag() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                    throw new AssertionError();
                }
                return (String) invokeV.objValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public ParcelableVolumeInfo getVolumeAttributes() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                    throw new AssertionError();
                }
                return (ParcelableVolumeInfo) invokeV.objValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isCaptioningEnabled() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                    return this.this$0.mCaptioningEnabled;
                }
                return invokeV.booleanValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isTransportControlEnabled() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                    throw new AssertionError();
                }
                return invokeV.booleanValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void next() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void pause() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void play() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepare() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void previous() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rewind() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void stop() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
                    throw new AssertionError();
                }
            }
        }

        public MediaSessionImplApi21(MediaSession mediaSession, VersionedParcelable versionedParcelable, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaSession, versionedParcelable, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mLock = new Object();
            this.mDestroyed = false;
            this.mExtraControllerCallbacks = new RemoteCallbackList<>();
            this.mSessionFwk = mediaSession;
            this.mToken = new Token(this.mSessionFwk.getSessionToken(), new ExtraSession(this), versionedParcelable);
            this.mSessionInfo = bundle;
            setFlags(3);
        }

        public MediaSessionImplApi21(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj};
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
            this.mDestroyed = false;
            this.mExtraControllerCallbacks = new RemoteCallbackList<>();
            if (obj instanceof MediaSession) {
                this.mSessionFwk = (MediaSession) obj;
                this.mToken = new Token(this.mSessionFwk.getSessionToken(), new ExtraSession(this));
                this.mSessionInfo = null;
                setFlags(3);
                return;
            }
            throw new IllegalArgumentException("mediaSession is not a valid MediaSession object");
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public Callback getCallback() {
            InterceptResult invokeV;
            Callback callback;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                synchronized (this.mLock) {
                    callback = this.mCallback;
                }
                return callback;
            }
            return (Callback) invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public MediaSessionManager.RemoteUserInfo getCurrentControllerInfo() {
            InterceptResult invokeV;
            MediaSessionManager.RemoteUserInfo remoteUserInfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                synchronized (this.mLock) {
                    remoteUserInfo = this.mRemoteUserInfo;
                }
                return remoteUserInfo;
            }
            return (MediaSessionManager.RemoteUserInfo) invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public Object getMediaSession() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.mSessionFwk;
            }
            return invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public PlaybackStateCompat getPlaybackState() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.mPlaybackState;
            }
            return (PlaybackStateCompat) invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public Token getSessionToken() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.mToken;
            }
            return (Token) invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public boolean isActive() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.mSessionFwk.isActive();
            }
            return invokeV.booleanValue;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void release() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                this.mDestroyed = true;
                this.mExtraControllerCallbacks.kill();
                this.mSessionFwk.setCallback(null);
                this.mSessionFwk.release();
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public String getCallingPackage() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (Build.VERSION.SDK_INT < 24) {
                    return null;
                }
                try {
                    return (String) this.mSessionFwk.getClass().getMethod("getCallingPackage", new Class[0]).invoke(this.mSessionFwk, new Object[0]);
                } catch (Exception e) {
                    Log.e(MediaSessionCompat.TAG, "Cannot execute MediaSession.getCallingPackage()", e);
                    return null;
                }
            }
            return (String) invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void sendSessionEvent(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, str, bundle) == null) {
                if (Build.VERSION.SDK_INT < 23) {
                    for (int beginBroadcast = this.mExtraControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                        try {
                            this.mExtraControllerCallbacks.getBroadcastItem(beginBroadcast).onEvent(str, bundle);
                        } catch (RemoteException unused) {
                        }
                    }
                    this.mExtraControllerCallbacks.finishBroadcast();
                }
                this.mSessionFwk.sendSessionEvent(str, bundle);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setActive(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
                this.mSessionFwk.setActive(z);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCurrentControllerInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, remoteUserInfo) == null) {
                synchronized (this.mLock) {
                    this.mRemoteUserInfo = remoteUserInfo;
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setExtras(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
                this.mSessionFwk.setExtras(bundle);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        @SuppressLint({"WrongConstant"})
        public void setFlags(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
                this.mSessionFwk.setFlags(i | 1 | 2);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setMediaButtonReceiver(PendingIntent pendingIntent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, pendingIntent) == null) {
                this.mSessionFwk.setMediaButtonReceiver(pendingIntent);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setMetadata(MediaMetadataCompat mediaMetadataCompat) {
            MediaMetadata mediaMetadata;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, mediaMetadataCompat) == null) {
                this.mMetadata = mediaMetadataCompat;
                MediaSession mediaSession = this.mSessionFwk;
                if (mediaMetadataCompat == null) {
                    mediaMetadata = null;
                } else {
                    mediaMetadata = (MediaMetadata) mediaMetadataCompat.getMediaMetadata();
                }
                mediaSession.setMetadata(mediaMetadata);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackToLocal(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
                AudioAttributes.Builder builder = new AudioAttributes.Builder();
                builder.setLegacyStreamType(i);
                this.mSessionFwk.setPlaybackToLocal(builder.build());
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048596, this, volumeProviderCompat) == null) {
                this.mSessionFwk.setPlaybackToRemote((VolumeProvider) volumeProviderCompat.getVolumeProvider());
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setQueueTitle(CharSequence charSequence) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048598, this, charSequence) == null) {
                this.mSessionFwk.setQueueTitle(charSequence);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setRatingType(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
                if (Build.VERSION.SDK_INT < 22) {
                    this.mRatingType = i;
                } else {
                    this.mSessionFwk.setRatingType(i);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setSessionActivity(PendingIntent pendingIntent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048601, this, pendingIntent) == null) {
                this.mSessionFwk.setSessionActivity(pendingIntent);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCallback(Callback callback, Handler handler) {
            MediaSession.Callback callback2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, callback, handler) == null) {
                synchronized (this.mLock) {
                    this.mCallback = callback;
                    MediaSession mediaSession = this.mSessionFwk;
                    if (callback == null) {
                        callback2 = null;
                    } else {
                        callback2 = callback.mCallbackFwk;
                    }
                    mediaSession.setCallback(callback2, handler);
                    if (callback != null) {
                        callback.setSessionImpl(this, handler);
                    }
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCaptioningEnabled(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048588, this, z) == null) && this.mCaptioningEnabled != z) {
                this.mCaptioningEnabled = z;
                for (int beginBroadcast = this.mExtraControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.mExtraControllerCallbacks.getBroadcastItem(beginBroadcast).onCaptioningEnabledChanged(z);
                    } catch (RemoteException unused) {
                    }
                }
                this.mExtraControllerCallbacks.finishBroadcast();
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackState(PlaybackStateCompat playbackStateCompat) {
            PlaybackState playbackState;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, playbackStateCompat) == null) {
                this.mPlaybackState = playbackStateCompat;
                for (int beginBroadcast = this.mExtraControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.mExtraControllerCallbacks.getBroadcastItem(beginBroadcast).onPlaybackStateChanged(playbackStateCompat);
                    } catch (RemoteException unused) {
                    }
                }
                this.mExtraControllerCallbacks.finishBroadcast();
                MediaSession mediaSession = this.mSessionFwk;
                if (playbackStateCompat == null) {
                    playbackState = null;
                } else {
                    playbackState = (PlaybackState) playbackStateCompat.getPlaybackState();
                }
                mediaSession.setPlaybackState(playbackState);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setQueue(List<QueueItem> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048597, this, list) == null) {
                this.mQueue = list;
                if (list == null) {
                    this.mSessionFwk.setQueue(null);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (QueueItem queueItem : list) {
                    arrayList.add((MediaSession.QueueItem) queueItem.getQueueItem());
                }
                this.mSessionFwk.setQueue(arrayList);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setRepeatMode(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048600, this, i) == null) && this.mRepeatMode != i) {
                this.mRepeatMode = i;
                for (int beginBroadcast = this.mExtraControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.mExtraControllerCallbacks.getBroadcastItem(beginBroadcast).onRepeatModeChanged(i);
                    } catch (RemoteException unused) {
                    }
                }
                this.mExtraControllerCallbacks.finishBroadcast();
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setShuffleMode(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048602, this, i) == null) && this.mShuffleMode != i) {
                this.mShuffleMode = i;
                for (int beginBroadcast = this.mExtraControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.mExtraControllerCallbacks.getBroadcastItem(beginBroadcast).onShuffleModeChanged(i);
                    } catch (RemoteException unused) {
                    }
                }
                this.mExtraControllerCallbacks.finishBroadcast();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class MediaSessionImplBase implements MediaSessionImpl {
        public static /* synthetic */ Interceptable $ic;
        public static final int RCC_PLAYSTATE_NONE = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final AudioManager mAudioManager;
        public volatile Callback mCallback;
        public boolean mCaptioningEnabled;
        public final Context mContext;
        public final RemoteCallbackList<IMediaControllerCallback> mControllerCallbacks;
        public boolean mDestroyed;
        public Bundle mExtras;
        public int mFlags;
        public MessageHandler mHandler;
        public boolean mIsActive;
        public int mLocalStream;
        public final Object mLock;
        public final ComponentName mMediaButtonReceiverComponentName;
        public final PendingIntent mMediaButtonReceiverIntent;
        public MediaMetadataCompat mMetadata;
        public final String mPackageName;
        public List<QueueItem> mQueue;
        public CharSequence mQueueTitle;
        public int mRatingType;
        public final RemoteControlClient mRcc;
        public MediaSessionManager.RemoteUserInfo mRemoteUserInfo;
        public int mRepeatMode;
        public PendingIntent mSessionActivity;
        public final Bundle mSessionInfo;
        public int mShuffleMode;
        public PlaybackStateCompat mState;
        public final MediaSessionStub mStub;
        public final String mTag;
        public final Token mToken;
        public VolumeProviderCompat.Callback mVolumeCallback;
        public VolumeProviderCompat mVolumeProvider;
        public int mVolumeType;

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public String getCallingPackage() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public Object getMediaSession() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return null;
            }
            return invokeV.objValue;
        }

        public int getRccStateFromState(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
                switch (i) {
                    case 0:
                        return 0;
                    case 1:
                        return 1;
                    case 2:
                        return 2;
                    case 3:
                        return 3;
                    case 4:
                        return 4;
                    case 5:
                        return 5;
                    case 6:
                    case 8:
                        return 8;
                    case 7:
                        return 9;
                    case 9:
                        return 7;
                    case 10:
                    case 11:
                        return 6;
                    default:
                        return -1;
                }
            }
            return invokeI.intValue;
        }

        public int getRccTransportControlFlagsFromActions(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j)) == null) {
                int i = (1 & j) != 0 ? 32 : 0;
                if ((2 & j) != 0) {
                    i |= 16;
                }
                if ((4 & j) != 0) {
                    i |= 4;
                }
                if ((8 & j) != 0) {
                    i |= 2;
                }
                if ((16 & j) != 0) {
                    i |= 1;
                }
                if ((32 & j) != 0) {
                    i |= 128;
                }
                if ((64 & j) != 0) {
                    i |= 64;
                }
                return (j & 512) != 0 ? i | 8 : i;
            }
            return invokeJ.intValue;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public Object getRemoteControlClient() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                return null;
            }
            return invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setMediaButtonReceiver(PendingIntent pendingIntent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048600, this, pendingIntent) == null) {
            }
        }

        /* loaded from: classes.dex */
        public static final class Command {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final String command;
            public final Bundle extras;
            public final ResultReceiver stub;

            public Command(String str, Bundle bundle, ResultReceiver resultReceiver) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, bundle, resultReceiver};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.command = str;
                this.extras = bundle;
                this.stub = resultReceiver;
            }
        }

        /* loaded from: classes.dex */
        public class MediaSessionStub extends IMediaSession.Stub {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaSessionImplBase this$0;

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isShuffleModeEnabledRemoved() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isTransportControlEnabled() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                    return true;
                }
                return invokeV.booleanValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleModeEnabledRemoved(boolean z) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048627, this, z) == null) {
                }
            }

            public MediaSessionStub(MediaSessionImplBase mediaSessionImplBase) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mediaSessionImplBase};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = mediaSessionImplBase;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, mediaDescriptionCompat) == null) {
                    postToHandler(25, mediaDescriptionCompat);
                }
            }

            public void postToHandler(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
                    this.this$0.postToHandler(i, 0, 0, null, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rate(RatingCompat ratingCompat) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048613, this, ratingCompat) == null) {
                    postToHandler(19, ratingCompat);
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048616, this, mediaDescriptionCompat) == null) {
                    postToHandler(27, mediaDescriptionCompat);
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItemAt(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048617, this, i) == null) {
                    postToHandler(28, i);
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void seekTo(long j) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeJ(1048619, this, j) == null) {
                    postToHandler(18, Long.valueOf(j));
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean sendMediaButton(KeyEvent keyEvent) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, keyEvent)) == null) {
                    postToHandler(21, keyEvent);
                    return true;
                }
                return invokeL.booleanValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setCaptioningEnabled(boolean z) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
                    postToHandler(29, Boolean.valueOf(z));
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setPlaybackSpeed(float f) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeF(1048624, this, f) == null) {
                    postToHandler(32, Float.valueOf(f));
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setRepeatMode(int i) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048625, this, i) == null) {
                    postToHandler(23, i);
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleMode(int i) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048626, this, i) == null) {
                    postToHandler(30, i);
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void skipToQueueItem(long j) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeJ(1048629, this, j) == null) {
                    postToHandler(11, Long.valueOf(j));
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void unregisterCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048631, this, iMediaControllerCallback) == null) {
                    this.this$0.mControllerCallbacks.unregister(iMediaControllerCallback);
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItemAt(MediaDescriptionCompat mediaDescriptionCompat, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaDescriptionCompat, i) == null) {
                    postToHandler(26, mediaDescriptionCompat, i);
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromMediaId(String str, Bundle bundle) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048600, this, str, bundle) == null) {
                    postToHandler(8, str, bundle);
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromSearch(String str, Bundle bundle) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048601, this, str, bundle) == null) {
                    postToHandler(9, str, bundle);
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromUri(Uri uri, Bundle bundle) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048602, this, uri, bundle) == null) {
                    postToHandler(10, uri, bundle);
                }
            }

            public void postToHandler(int i, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeII(1048604, this, i, i2) == null) {
                    this.this$0.postToHandler(i, i2, 0, null, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromMediaId(String str, Bundle bundle) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048609, this, str, bundle) == null) {
                    postToHandler(4, str, bundle);
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromSearch(String str, Bundle bundle) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048610, this, str, bundle) == null) {
                    postToHandler(5, str, bundle);
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromUri(Uri uri, Bundle bundle) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048611, this, uri, bundle) == null) {
                    postToHandler(6, uri, bundle);
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rateWithExtras(RatingCompat ratingCompat, Bundle bundle) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048614, this, ratingCompat, bundle) == null) {
                    postToHandler(31, ratingCompat, bundle);
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCustomAction(String str, Bundle bundle) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048621, this, str, bundle) == null) {
                    postToHandler(20, str, bundle);
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void adjustVolume(int i, int i2, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, str) == null) {
                    this.this$0.adjustVolume(i, i2);
                }
            }

            public void postToHandler(int i, Object obj, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Integer.valueOf(i), obj, Integer.valueOf(i2)}) == null) {
                    this.this$0.postToHandler(i, i2, 0, obj, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCommand(String str, Bundle bundle, ResultReceiverWrapper resultReceiverWrapper) {
                ResultReceiver resultReceiver;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLL(1048620, this, str, bundle, resultReceiverWrapper) == null) {
                    if (resultReceiverWrapper == null) {
                        resultReceiver = null;
                    } else {
                        resultReceiver = resultReceiverWrapper.mResultReceiver;
                    }
                    postToHandler(1, new Command(str, bundle, resultReceiver));
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setVolumeTo(int i, int i2, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIIL(1048628, this, i, i2, str) == null) {
                    this.this$0.setVolumeTo(i, i2);
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void fastForward() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                    postToHandler(16);
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public Bundle getExtras() {
                InterceptResult invokeV;
                Bundle bundle;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                    synchronized (this.this$0.mLock) {
                        bundle = this.this$0.mExtras;
                    }
                    return bundle;
                }
                return (Bundle) invokeV.objValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public long getFlags() {
                InterceptResult invokeV;
                long j;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                    synchronized (this.this$0.mLock) {
                        j = this.this$0.mFlags;
                    }
                    return j;
                }
                return invokeV.longValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public PendingIntent getLaunchPendingIntent() {
                InterceptResult invokeV;
                PendingIntent pendingIntent;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                    synchronized (this.this$0.mLock) {
                        pendingIntent = this.this$0.mSessionActivity;
                    }
                    return pendingIntent;
                }
                return (PendingIntent) invokeV.objValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public MediaMetadataCompat getMetadata() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                    return this.this$0.mMetadata;
                }
                return (MediaMetadataCompat) invokeV.objValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public String getPackageName() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                    return this.this$0.mPackageName;
                }
                return (String) invokeV.objValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public PlaybackStateCompat getPlaybackState() {
                InterceptResult invokeV;
                PlaybackStateCompat playbackStateCompat;
                MediaMetadataCompat mediaMetadataCompat;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                    synchronized (this.this$0.mLock) {
                        playbackStateCompat = this.this$0.mState;
                        mediaMetadataCompat = this.this$0.mMetadata;
                    }
                    return MediaSessionCompat.getStateWithUpdatedPosition(playbackStateCompat, mediaMetadataCompat);
                }
                return (PlaybackStateCompat) invokeV.objValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public List<QueueItem> getQueue() {
                InterceptResult invokeV;
                List<QueueItem> list;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                    synchronized (this.this$0.mLock) {
                        list = this.this$0.mQueue;
                    }
                    return list;
                }
                return (List) invokeV.objValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public CharSequence getQueueTitle() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                    return this.this$0.mQueueTitle;
                }
                return (CharSequence) invokeV.objValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getRatingType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                    return this.this$0.mRatingType;
                }
                return invokeV.intValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getRepeatMode() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                    return this.this$0.mRepeatMode;
                }
                return invokeV.intValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public Bundle getSessionInfo() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                    if (this.this$0.mSessionInfo == null) {
                        return null;
                    }
                    return new Bundle(this.this$0.mSessionInfo);
                }
                return (Bundle) invokeV.objValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getShuffleMode() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                    return this.this$0.mShuffleMode;
                }
                return invokeV.intValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public String getTag() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                    return this.this$0.mTag;
                }
                return (String) invokeV.objValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isCaptioningEnabled() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                    return this.this$0.mCaptioningEnabled;
                }
                return invokeV.booleanValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void next() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
                    postToHandler(14);
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void pause() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
                    postToHandler(12);
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void play() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
                    postToHandler(7);
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepare() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
                    postToHandler(3);
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void previous() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
                    postToHandler(15);
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rewind() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
                    postToHandler(17);
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void stop() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
                    postToHandler(13);
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public ParcelableVolumeInfo getVolumeAttributes() {
                InterceptResult invokeV;
                int i;
                int i2;
                int streamMaxVolume;
                int streamVolume;
                int i3;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                    synchronized (this.this$0.mLock) {
                        i = this.this$0.mVolumeType;
                        i2 = this.this$0.mLocalStream;
                        VolumeProviderCompat volumeProviderCompat = this.this$0.mVolumeProvider;
                        if (i == 2) {
                            int volumeControl = volumeProviderCompat.getVolumeControl();
                            int maxVolume = volumeProviderCompat.getMaxVolume();
                            streamVolume = volumeProviderCompat.getCurrentVolume();
                            streamMaxVolume = maxVolume;
                            i3 = volumeControl;
                        } else {
                            streamMaxVolume = this.this$0.mAudioManager.getStreamMaxVolume(i2);
                            streamVolume = this.this$0.mAudioManager.getStreamVolume(i2);
                            i3 = 2;
                        }
                    }
                    return new ParcelableVolumeInfo(i, i2, i3, streamMaxVolume, streamVolume);
                }
                return (ParcelableVolumeInfo) invokeV.objValue;
            }

            public void postToHandler(int i, Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048605, this, i, obj) == null) {
                    this.this$0.postToHandler(i, 0, 0, obj, null);
                }
            }

            public void postToHandler(int i, Object obj, Bundle bundle) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeILL(1048607, this, i, obj, bundle) == null) {
                    this.this$0.postToHandler(i, 0, 0, obj, bundle);
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void registerCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048615, this, iMediaControllerCallback) == null) {
                    if (this.this$0.mDestroyed) {
                        try {
                            iMediaControllerCallback.onSessionDestroyed();
                            return;
                        } catch (Exception unused) {
                            return;
                        }
                    }
                    this.this$0.mControllerCallbacks.register(iMediaControllerCallback, new MediaSessionManager.RemoteUserInfo(this.this$0.getPackageNameForUid(Binder.getCallingUid()), Binder.getCallingPid(), Binder.getCallingUid()));
                }
            }
        }

        /* loaded from: classes.dex */
        public class MessageHandler extends Handler {
            public static /* synthetic */ Interceptable $ic = null;
            public static final int KEYCODE_MEDIA_PAUSE = 127;
            public static final int KEYCODE_MEDIA_PLAY = 126;
            public static final int MSG_ADD_QUEUE_ITEM = 25;
            public static final int MSG_ADD_QUEUE_ITEM_AT = 26;
            public static final int MSG_ADJUST_VOLUME = 2;
            public static final int MSG_COMMAND = 1;
            public static final int MSG_CUSTOM_ACTION = 20;
            public static final int MSG_FAST_FORWARD = 16;
            public static final int MSG_MEDIA_BUTTON = 21;
            public static final int MSG_NEXT = 14;
            public static final int MSG_PAUSE = 12;
            public static final int MSG_PLAY = 7;
            public static final int MSG_PLAY_MEDIA_ID = 8;
            public static final int MSG_PLAY_SEARCH = 9;
            public static final int MSG_PLAY_URI = 10;
            public static final int MSG_PREPARE = 3;
            public static final int MSG_PREPARE_MEDIA_ID = 4;
            public static final int MSG_PREPARE_SEARCH = 5;
            public static final int MSG_PREPARE_URI = 6;
            public static final int MSG_PREVIOUS = 15;
            public static final int MSG_RATE = 19;
            public static final int MSG_RATE_EXTRA = 31;
            public static final int MSG_REMOVE_QUEUE_ITEM = 27;
            public static final int MSG_REMOVE_QUEUE_ITEM_AT = 28;
            public static final int MSG_REWIND = 17;
            public static final int MSG_SEEK_TO = 18;
            public static final int MSG_SET_CAPTIONING_ENABLED = 29;
            public static final int MSG_SET_PLAYBACK_SPEED = 32;
            public static final int MSG_SET_REPEAT_MODE = 23;
            public static final int MSG_SET_SHUFFLE_MODE = 30;
            public static final int MSG_SET_VOLUME = 22;
            public static final int MSG_SKIP_TO_ITEM = 11;
            public static final int MSG_STOP = 13;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaSessionImplBase this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public MessageHandler(MediaSessionImplBase mediaSessionImplBase, Looper looper) {
                super(looper);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mediaSessionImplBase, looper};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((Looper) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = mediaSessionImplBase;
            }

            private void onMediaButtonEvent(KeyEvent keyEvent, Callback callback) {
                long actions;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(65537, this, keyEvent, callback) == null) && keyEvent != null && keyEvent.getAction() == 0) {
                    PlaybackStateCompat playbackStateCompat = this.this$0.mState;
                    if (playbackStateCompat == null) {
                        actions = 0;
                    } else {
                        actions = playbackStateCompat.getActions();
                    }
                    int keyCode = keyEvent.getKeyCode();
                    if (keyCode != 79) {
                        if (keyCode != 126) {
                            if (keyCode != 127) {
                                switch (keyCode) {
                                    case 85:
                                        break;
                                    case 86:
                                        if ((actions & 1) != 0) {
                                            callback.onStop();
                                            return;
                                        }
                                        return;
                                    case 87:
                                        if ((actions & 32) != 0) {
                                            callback.onSkipToNext();
                                            return;
                                        }
                                        return;
                                    case 88:
                                        if ((actions & 16) != 0) {
                                            callback.onSkipToPrevious();
                                            return;
                                        }
                                        return;
                                    case 89:
                                        if ((actions & 8) != 0) {
                                            callback.onRewind();
                                            return;
                                        }
                                        return;
                                    case 90:
                                        if ((actions & 64) != 0) {
                                            callback.onFastForward();
                                            return;
                                        }
                                        return;
                                    default:
                                        return;
                                }
                            } else if ((actions & 2) != 0) {
                                callback.onPause();
                                return;
                            } else {
                                return;
                            }
                        } else if ((actions & 4) != 0) {
                            callback.onPlay();
                            return;
                        } else {
                            return;
                        }
                    }
                    Log.w(MediaSessionCompat.TAG, "KEYCODE_MEDIA_PLAY_PAUSE and KEYCODE_HEADSETHOOK are handled already");
                }
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Callback callback;
                QueueItem queueItem;
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeL(1048576, this, message) != null) || (callback = this.this$0.mCallback) == null) {
                    return;
                }
                Bundle data = message.getData();
                MediaSessionCompat.ensureClassLoader(data);
                this.this$0.setCurrentControllerInfo(new MediaSessionManager.RemoteUserInfo(data.getString(MediaSessionCompat.DATA_CALLING_PACKAGE), data.getInt("data_calling_pid"), data.getInt("data_calling_uid")));
                Bundle bundle = data.getBundle(MediaSessionCompat.DATA_EXTRAS);
                MediaSessionCompat.ensureClassLoader(bundle);
                try {
                    switch (message.what) {
                        case 1:
                            Command command = (Command) message.obj;
                            callback.onCommand(command.command, command.extras, command.stub);
                            break;
                        case 2:
                            this.this$0.adjustVolume(message.arg1, 0);
                            break;
                        case 3:
                            callback.onPrepare();
                            break;
                        case 4:
                            callback.onPrepareFromMediaId((String) message.obj, bundle);
                            break;
                        case 5:
                            callback.onPrepareFromSearch((String) message.obj, bundle);
                            break;
                        case 6:
                            callback.onPrepareFromUri((Uri) message.obj, bundle);
                            break;
                        case 7:
                            callback.onPlay();
                            break;
                        case 8:
                            callback.onPlayFromMediaId((String) message.obj, bundle);
                            break;
                        case 9:
                            callback.onPlayFromSearch((String) message.obj, bundle);
                            break;
                        case 10:
                            callback.onPlayFromUri((Uri) message.obj, bundle);
                            break;
                        case 11:
                            callback.onSkipToQueueItem(((Long) message.obj).longValue());
                            break;
                        case 12:
                            callback.onPause();
                            break;
                        case 13:
                            callback.onStop();
                            break;
                        case 14:
                            callback.onSkipToNext();
                            break;
                        case 15:
                            callback.onSkipToPrevious();
                            break;
                        case 16:
                            callback.onFastForward();
                            break;
                        case 17:
                            callback.onRewind();
                            break;
                        case 18:
                            callback.onSeekTo(((Long) message.obj).longValue());
                            break;
                        case 19:
                            callback.onSetRating((RatingCompat) message.obj);
                            break;
                        case 20:
                            callback.onCustomAction((String) message.obj, bundle);
                            break;
                        case 21:
                            KeyEvent keyEvent = (KeyEvent) message.obj;
                            Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
                            intent.putExtra("android.intent.extra.KEY_EVENT", keyEvent);
                            if (!callback.onMediaButtonEvent(intent)) {
                                onMediaButtonEvent(keyEvent, callback);
                                break;
                            }
                            break;
                        case 22:
                            this.this$0.setVolumeTo(message.arg1, 0);
                            break;
                        case 23:
                            callback.onSetRepeatMode(message.arg1);
                            break;
                        case 25:
                            callback.onAddQueueItem((MediaDescriptionCompat) message.obj);
                            break;
                        case 26:
                            callback.onAddQueueItem((MediaDescriptionCompat) message.obj, message.arg1);
                            break;
                        case 27:
                            callback.onRemoveQueueItem((MediaDescriptionCompat) message.obj);
                            break;
                        case 28:
                            if (this.this$0.mQueue != null) {
                                if (message.arg1 >= 0 && message.arg1 < this.this$0.mQueue.size()) {
                                    queueItem = this.this$0.mQueue.get(message.arg1);
                                } else {
                                    queueItem = null;
                                }
                                if (queueItem != null) {
                                    callback.onRemoveQueueItem(queueItem.getDescription());
                                    break;
                                }
                            }
                            break;
                        case 29:
                            callback.onSetCaptioningEnabled(((Boolean) message.obj).booleanValue());
                            break;
                        case 30:
                            callback.onSetShuffleMode(message.arg1);
                            break;
                        case 31:
                            callback.onSetRating((RatingCompat) message.obj, bundle);
                            break;
                        case 32:
                            callback.onSetPlaybackSpeed(((Float) message.obj).floatValue());
                            break;
                    }
                } finally {
                    this.this$0.setCurrentControllerInfo(null);
                }
            }
        }

        public MediaSessionImplBase(Context context, String str, ComponentName componentName, PendingIntent pendingIntent, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str, componentName, pendingIntent, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mLock = new Object();
            this.mControllerCallbacks = new RemoteCallbackList<>();
            this.mDestroyed = false;
            this.mIsActive = false;
            this.mFlags = 3;
            this.mVolumeCallback = new VolumeProviderCompat.Callback(this) { // from class: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionImplBase this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {this};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i3 = newInitContext2.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // androidx.media.VolumeProviderCompat.Callback
                public void onVolumeChanged(VolumeProviderCompat volumeProviderCompat) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 != null && interceptable2.invokeL(1048576, this, volumeProviderCompat) != null) || this.this$0.mVolumeProvider != volumeProviderCompat) {
                        return;
                    }
                    MediaSessionImplBase mediaSessionImplBase = this.this$0;
                    this.this$0.sendVolumeInfoChanged(new ParcelableVolumeInfo(mediaSessionImplBase.mVolumeType, mediaSessionImplBase.mLocalStream, volumeProviderCompat.getVolumeControl(), volumeProviderCompat.getMaxVolume(), volumeProviderCompat.getCurrentVolume()));
                }
            };
            if (componentName != null) {
                this.mContext = context;
                this.mPackageName = context.getPackageName();
                this.mSessionInfo = bundle;
                this.mAudioManager = (AudioManager) context.getSystemService("audio");
                this.mTag = str;
                this.mMediaButtonReceiverComponentName = componentName;
                this.mMediaButtonReceiverIntent = pendingIntent;
                this.mStub = new MediaSessionStub(this);
                this.mToken = new Token(this.mStub);
                this.mRatingType = 0;
                this.mVolumeType = 1;
                this.mLocalStream = 3;
                this.mRcc = new RemoteControlClient(pendingIntent);
                return;
            }
            throw new IllegalArgumentException("MediaButtonReceiver component may not be null");
        }

        private void sendCaptioningEnabled(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(65537, this, z) == null) {
                for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onCaptioningEnabledChanged(z);
                    } catch (RemoteException unused) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
            }
        }

        private void sendExtras(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65539, this, bundle) == null) {
                for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onExtrasChanged(bundle);
                    } catch (RemoteException unused) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
            }
        }

        private void sendMetadata(MediaMetadataCompat mediaMetadataCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, mediaMetadataCompat) == null) {
                for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onMetadataChanged(mediaMetadataCompat);
                    } catch (RemoteException unused) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
            }
        }

        private void sendQueue(List<QueueItem> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65541, this, list) == null) {
                for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onQueueChanged(list);
                    } catch (RemoteException unused) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
            }
        }

        private void sendQueueTitle(CharSequence charSequence) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65542, this, charSequence) == null) {
                for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onQueueTitleChanged(charSequence);
                    } catch (RemoteException unused) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
            }
        }

        private void sendRepeatMode(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(65543, this, i) == null) {
                for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onRepeatModeChanged(i);
                    } catch (RemoteException unused) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
            }
        }

        private void sendShuffleMode(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(65545, this, i) == null) {
                for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onShuffleModeChanged(i);
                    } catch (RemoteException unused) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
            }
        }

        private void sendState(PlaybackStateCompat playbackStateCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65546, this, playbackStateCompat) == null) {
                for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onPlaybackStateChanged(playbackStateCompat);
                    } catch (RemoteException unused) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
            }
        }

        public String getPackageNameForUid(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
                String nameForUid = this.mContext.getPackageManager().getNameForUid(i);
                if (TextUtils.isEmpty(nameForUid)) {
                    return MediaSessionManager.RemoteUserInfo.LEGACY_CONTROLLER;
                }
                return nameForUid;
            }
            return (String) invokeI.objValue;
        }

        public void sendVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, parcelableVolumeInfo) == null) {
                for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onVolumeInfoChanged(parcelableVolumeInfo);
                    } catch (RemoteException unused) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setActive(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeZ(1048594, this, z) != null) || z == this.mIsActive) {
                return;
            }
            this.mIsActive = z;
            updateMbrAndRcc();
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCaptioningEnabled(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048596, this, z) == null) && this.mCaptioningEnabled != z) {
                this.mCaptioningEnabled = z;
                sendCaptioningEnabled(z);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCurrentControllerInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048597, this, remoteUserInfo) == null) {
                synchronized (this.mLock) {
                    this.mRemoteUserInfo = remoteUserInfo;
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setExtras(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048598, this, bundle) == null) {
                this.mExtras = bundle;
                sendExtras(bundle);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setFlags(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
                synchronized (this.mLock) {
                    this.mFlags = i | 1 | 2;
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setQueue(List<QueueItem> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048605, this, list) == null) {
                this.mQueue = list;
                sendQueue(list);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setQueueTitle(CharSequence charSequence) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048606, this, charSequence) == null) {
                this.mQueueTitle = charSequence;
                sendQueueTitle(charSequence);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setRatingType(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
                this.mRatingType = i;
            }
        }

        public void setRccState(PlaybackStateCompat playbackStateCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048608, this, playbackStateCompat) == null) {
                this.mRcc.setPlaybackState(getRccStateFromState(playbackStateCompat.getState()));
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setRepeatMode(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048609, this, i) == null) && this.mRepeatMode != i) {
                this.mRepeatMode = i;
                sendRepeatMode(i);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setSessionActivity(PendingIntent pendingIntent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048610, this, pendingIntent) == null) {
                synchronized (this.mLock) {
                    this.mSessionActivity = pendingIntent;
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setShuffleMode(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048611, this, i) == null) && this.mShuffleMode != i) {
                this.mShuffleMode = i;
                sendShuffleMode(i);
            }
        }

        private void sendEvent(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, this, str, bundle) == null) {
                for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onEvent(str, bundle);
                    } catch (RemoteException unused) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
            }
        }

        public void adjustVolume(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                if (this.mVolumeType == 2) {
                    VolumeProviderCompat volumeProviderCompat = this.mVolumeProvider;
                    if (volumeProviderCompat != null) {
                        volumeProviderCompat.onAdjustVolume(i);
                        return;
                    }
                    return;
                }
                this.mAudioManager.adjustStreamVolume(this.mLocalStream, i, i2);
            }
        }

        public void registerMediaButtonEventReceiver(PendingIntent pendingIntent, ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048590, this, pendingIntent, componentName) == null) {
                this.mAudioManager.registerMediaButtonEventReceiver(componentName);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void sendSessionEvent(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048592, this, str, bundle) == null) {
                sendEvent(str, bundle);
            }
        }

        public void setVolumeTo(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048612, this, i, i2) == null) {
                if (this.mVolumeType == 2) {
                    VolumeProviderCompat volumeProviderCompat = this.mVolumeProvider;
                    if (volumeProviderCompat != null) {
                        volumeProviderCompat.onSetVolumeTo(i);
                        return;
                    }
                    return;
                }
                this.mAudioManager.setStreamVolume(this.mLocalStream, i, i2);
            }
        }

        public void unregisterMediaButtonEventReceiver(PendingIntent pendingIntent, ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048613, this, pendingIntent, componentName) == null) {
                this.mAudioManager.unregisterMediaButtonEventReceiver(componentName);
            }
        }

        private void sendSessionDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65544, this) == null) {
                for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onSessionDestroyed();
                    } catch (RemoteException unused) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
                this.mControllerCallbacks.kill();
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public Callback getCallback() {
            InterceptResult invokeV;
            Callback callback;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                synchronized (this.mLock) {
                    callback = this.mCallback;
                }
                return callback;
            }
            return (Callback) invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public MediaSessionManager.RemoteUserInfo getCurrentControllerInfo() {
            InterceptResult invokeV;
            MediaSessionManager.RemoteUserInfo remoteUserInfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                synchronized (this.mLock) {
                    remoteUserInfo = this.mRemoteUserInfo;
                }
                return remoteUserInfo;
            }
            return (MediaSessionManager.RemoteUserInfo) invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public PlaybackStateCompat getPlaybackState() {
            InterceptResult invokeV;
            PlaybackStateCompat playbackStateCompat;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                synchronized (this.mLock) {
                    playbackStateCompat = this.mState;
                }
                return playbackStateCompat;
            }
            return (PlaybackStateCompat) invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public Token getSessionToken() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return this.mToken;
            }
            return (Token) invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public boolean isActive() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                return this.mIsActive;
            }
            return invokeV.booleanValue;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void release() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
                this.mIsActive = false;
                this.mDestroyed = true;
                updateMbrAndRcc();
                sendSessionDestroyed();
                setCallback(null, null);
            }
        }

        public RemoteControlClient.MetadataEditor buildRccMetadata(Bundle bundle) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle)) == null) {
                RemoteControlClient.MetadataEditor editMetadata = this.mRcc.editMetadata(true);
                if (bundle == null) {
                    return editMetadata;
                }
                if (bundle.containsKey("android.media.metadata.ART")) {
                    Bitmap bitmap = (Bitmap) bundle.getParcelable("android.media.metadata.ART");
                    if (bitmap != null) {
                        bitmap = bitmap.copy(bitmap.getConfig(), false);
                    }
                    editMetadata.putBitmap(100, bitmap);
                } else if (bundle.containsKey("android.media.metadata.ALBUM_ART")) {
                    Bitmap bitmap2 = (Bitmap) bundle.getParcelable("android.media.metadata.ALBUM_ART");
                    if (bitmap2 != null) {
                        bitmap2 = bitmap2.copy(bitmap2.getConfig(), false);
                    }
                    editMetadata.putBitmap(100, bitmap2);
                }
                if (bundle.containsKey("android.media.metadata.ALBUM")) {
                    editMetadata.putString(1, bundle.getString("android.media.metadata.ALBUM"));
                }
                if (bundle.containsKey("android.media.metadata.ALBUM_ARTIST")) {
                    editMetadata.putString(13, bundle.getString("android.media.metadata.ALBUM_ARTIST"));
                }
                if (bundle.containsKey("android.media.metadata.ARTIST")) {
                    editMetadata.putString(2, bundle.getString("android.media.metadata.ARTIST"));
                }
                if (bundle.containsKey("android.media.metadata.AUTHOR")) {
                    editMetadata.putString(3, bundle.getString("android.media.metadata.AUTHOR"));
                }
                if (bundle.containsKey("android.media.metadata.COMPILATION")) {
                    editMetadata.putString(15, bundle.getString("android.media.metadata.COMPILATION"));
                }
                if (bundle.containsKey("android.media.metadata.COMPOSER")) {
                    editMetadata.putString(4, bundle.getString("android.media.metadata.COMPOSER"));
                }
                if (bundle.containsKey("android.media.metadata.DATE")) {
                    editMetadata.putString(5, bundle.getString("android.media.metadata.DATE"));
                }
                if (bundle.containsKey("android.media.metadata.DISC_NUMBER")) {
                    editMetadata.putLong(14, bundle.getLong("android.media.metadata.DISC_NUMBER"));
                }
                if (bundle.containsKey("android.media.metadata.DURATION")) {
                    editMetadata.putLong(9, bundle.getLong("android.media.metadata.DURATION"));
                }
                if (bundle.containsKey("android.media.metadata.GENRE")) {
                    editMetadata.putString(6, bundle.getString("android.media.metadata.GENRE"));
                }
                if (bundle.containsKey("android.media.metadata.TITLE")) {
                    editMetadata.putString(7, bundle.getString("android.media.metadata.TITLE"));
                }
                if (bundle.containsKey("android.media.metadata.TRACK_NUMBER")) {
                    editMetadata.putLong(0, bundle.getLong("android.media.metadata.TRACK_NUMBER"));
                }
                if (bundle.containsKey("android.media.metadata.WRITER")) {
                    editMetadata.putString(11, bundle.getString("android.media.metadata.WRITER"));
                }
                return editMetadata;
            }
            return (RemoteControlClient.MetadataEditor) invokeL.objValue;
        }

        public void postToHandler(int i, int i2, int i3, Object obj, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), obj, bundle}) == null) {
                synchronized (this.mLock) {
                    if (this.mHandler != null) {
                        Message obtainMessage = this.mHandler.obtainMessage(i, i2, i3, obj);
                        Bundle bundle2 = new Bundle();
                        int callingUid = Binder.getCallingUid();
                        bundle2.putInt("data_calling_uid", callingUid);
                        bundle2.putString(MediaSessionCompat.DATA_CALLING_PACKAGE, getPackageNameForUid(callingUid));
                        int callingPid = Binder.getCallingPid();
                        if (callingPid > 0) {
                            bundle2.putInt("data_calling_pid", callingPid);
                        } else {
                            bundle2.putInt("data_calling_pid", -1);
                        }
                        if (bundle != null) {
                            bundle2.putBundle(MediaSessionCompat.DATA_EXTRAS, bundle);
                        }
                        obtainMessage.setData(bundle2);
                        obtainMessage.sendToTarget();
                    }
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0036 A[Catch: all -> 0x003d, TryCatch #0 {, blocks: (B:6:0x0007, B:8:0x000c, B:12:0x0016, B:14:0x0021, B:16:0x0027, B:18:0x002b, B:19:0x0030, B:21:0x0036, B:22:0x003b), top: B:30:0x0007 }] */
        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void setCallback(Callback callback, Handler handler) {
            MessageHandler messageHandler;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048595, this, callback, handler) == null) {
                synchronized (this.mLock) {
                    if (this.mHandler != null) {
                        this.mHandler.removeCallbacksAndMessages(null);
                    }
                    if (callback != null && handler != null) {
                        messageHandler = new MessageHandler(this, handler.getLooper());
                        this.mHandler = messageHandler;
                        if (this.mCallback != callback && this.mCallback != null) {
                            this.mCallback.setSessionImpl(null, null);
                        }
                        this.mCallback = callback;
                        if (this.mCallback != null) {
                            this.mCallback.setSessionImpl(this, handler);
                        }
                    }
                    messageHandler = null;
                    this.mHandler = messageHandler;
                    if (this.mCallback != callback) {
                        this.mCallback.setSessionImpl(null, null);
                    }
                    this.mCallback = callback;
                    if (this.mCallback != null) {
                    }
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setMetadata(MediaMetadataCompat mediaMetadataCompat) {
            Bundle bundle;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048601, this, mediaMetadataCompat) == null) {
                if (mediaMetadataCompat != null) {
                    mediaMetadataCompat = new MediaMetadataCompat.Builder(mediaMetadataCompat, MediaSessionCompat.sMaxBitmapSize).build();
                }
                synchronized (this.mLock) {
                    this.mMetadata = mediaMetadataCompat;
                }
                sendMetadata(mediaMetadataCompat);
                if (!this.mIsActive) {
                    return;
                }
                if (mediaMetadataCompat == null) {
                    bundle = null;
                } else {
                    bundle = mediaMetadataCompat.getBundle();
                }
                buildRccMetadata(bundle).apply();
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackState(PlaybackStateCompat playbackStateCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048602, this, playbackStateCompat) == null) {
                synchronized (this.mLock) {
                    this.mState = playbackStateCompat;
                }
                sendState(playbackStateCompat);
                if (!this.mIsActive) {
                    return;
                }
                if (playbackStateCompat == null) {
                    this.mRcc.setPlaybackState(0);
                    this.mRcc.setTransportControlFlags(0);
                    return;
                }
                setRccState(playbackStateCompat);
                this.mRcc.setTransportControlFlags(getRccTransportControlFlagsFromActions(playbackStateCompat.getActions()));
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackToLocal(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
                VolumeProviderCompat volumeProviderCompat = this.mVolumeProvider;
                if (volumeProviderCompat != null) {
                    volumeProviderCompat.setCallback(null);
                }
                this.mLocalStream = i;
                this.mVolumeType = 1;
                int i2 = this.mVolumeType;
                int i3 = this.mLocalStream;
                sendVolumeInfoChanged(new ParcelableVolumeInfo(i2, i3, 2, this.mAudioManager.getStreamMaxVolume(i3), this.mAudioManager.getStreamVolume(this.mLocalStream)));
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048604, this, volumeProviderCompat) == null) {
                if (volumeProviderCompat != null) {
                    VolumeProviderCompat volumeProviderCompat2 = this.mVolumeProvider;
                    if (volumeProviderCompat2 != null) {
                        volumeProviderCompat2.setCallback(null);
                    }
                    this.mVolumeType = 2;
                    this.mVolumeProvider = volumeProviderCompat;
                    sendVolumeInfoChanged(new ParcelableVolumeInfo(this.mVolumeType, this.mLocalStream, this.mVolumeProvider.getVolumeControl(), this.mVolumeProvider.getMaxVolume(), this.mVolumeProvider.getCurrentVolume()));
                    volumeProviderCompat.setCallback(this.mVolumeCallback);
                    return;
                }
                throw new IllegalArgumentException("volumeProvider may not be null");
            }
        }

        public void updateMbrAndRcc() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
                if (this.mIsActive) {
                    registerMediaButtonEventReceiver(this.mMediaButtonReceiverIntent, this.mMediaButtonReceiverComponentName);
                    this.mAudioManager.registerRemoteControlClient(this.mRcc);
                    setMetadata(this.mMetadata);
                    setPlaybackState(this.mState);
                    return;
                }
                unregisterMediaButtonEventReceiver(this.mMediaButtonReceiverIntent, this.mMediaButtonReceiverComponentName);
                this.mRcc.setPlaybackState(0);
                this.mAudioManager.unregisterRemoteControlClient(this.mRcc);
            }
        }
    }

    @RequiresApi(18)
    /* loaded from: classes.dex */
    public static class MediaSessionImplApi18 extends MediaSessionImplBase {
        public static /* synthetic */ Interceptable $ic = null;
        public static boolean sIsMbrPendingIntentSupported = true;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1731240947, "Landroid/support/v4/media/session/MediaSessionCompat$MediaSessionImplApi18;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1731240947, "Landroid/support/v4/media/session/MediaSessionCompat$MediaSessionImplApi18;");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MediaSessionImplApi18(Context context, String str, ComponentName componentName, PendingIntent pendingIntent, Bundle bundle) {
            super(context, str, componentName, pendingIntent, bundle);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str, componentName, pendingIntent, bundle};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (String) objArr2[1], (ComponentName) objArr2[2], (PendingIntent) objArr2[3], (Bundle) objArr2[4]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        public int getRccTransportControlFlagsFromActions(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
                int rccTransportControlFlagsFromActions = super.getRccTransportControlFlagsFromActions(j);
                if ((j & 256) != 0) {
                    return rccTransportControlFlagsFromActions | 256;
                }
                return rccTransportControlFlagsFromActions;
            }
            return invokeJ.intValue;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        public void registerMediaButtonEventReceiver(PendingIntent pendingIntent, ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pendingIntent, componentName) == null) {
                if (sIsMbrPendingIntentSupported) {
                    try {
                        this.mAudioManager.registerMediaButtonEventReceiver(pendingIntent);
                    } catch (NullPointerException unused) {
                        Log.w(MediaSessionCompat.TAG, "Unable to register media button event receiver with PendingIntent, falling back to ComponentName.");
                        sIsMbrPendingIntentSupported = false;
                    }
                }
                if (!sIsMbrPendingIntentSupported) {
                    super.registerMediaButtonEventReceiver(pendingIntent, componentName);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase, android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCallback(Callback callback, Handler handler) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, callback, handler) == null) {
                super.setCallback(callback, handler);
                if (callback == null) {
                    this.mRcc.setPlaybackPositionUpdateListener(null);
                    return;
                }
                this.mRcc.setPlaybackPositionUpdateListener(new RemoteControlClient.OnPlaybackPositionUpdateListener(this) { // from class: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi18.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MediaSessionImplApi18 this$0;

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

                    @Override // android.media.RemoteControlClient.OnPlaybackPositionUpdateListener
                    public void onPlaybackPositionUpdate(long j) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeJ(1048576, this, j) == null) {
                            this.this$0.postToHandler(18, -1, -1, Long.valueOf(j), null);
                        }
                    }
                });
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        public void unregisterMediaButtonEventReceiver(PendingIntent pendingIntent, ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, pendingIntent, componentName) == null) {
                if (sIsMbrPendingIntentSupported) {
                    this.mAudioManager.unregisterMediaButtonEventReceiver(pendingIntent);
                } else {
                    super.unregisterMediaButtonEventReceiver(pendingIntent, componentName);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        public void setRccState(PlaybackStateCompat playbackStateCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, playbackStateCompat) == null) {
                long position = playbackStateCompat.getPosition();
                float playbackSpeed = playbackStateCompat.getPlaybackSpeed();
                long lastPositionUpdateTime = playbackStateCompat.getLastPositionUpdateTime();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (playbackStateCompat.getState() == 3) {
                    long j = 0;
                    if (position > 0) {
                        if (lastPositionUpdateTime > 0) {
                            j = elapsedRealtime - lastPositionUpdateTime;
                            if (playbackSpeed > 0.0f && playbackSpeed != 1.0f) {
                                j = ((float) j) * playbackSpeed;
                            }
                        }
                        position += j;
                    }
                }
                this.mRcc.setPlaybackState(getRccStateFromState(playbackStateCompat.getState()), position, playbackSpeed);
            }
        }
    }

    @RequiresApi(19)
    /* loaded from: classes.dex */
    public static class MediaSessionImplApi19 extends MediaSessionImplApi18 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MediaSessionImplApi19(Context context, String str, ComponentName componentName, PendingIntent pendingIntent, Bundle bundle) {
            super(context, str, componentName, pendingIntent, bundle);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str, componentName, pendingIntent, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (String) objArr2[1], (ComponentName) objArr2[2], (PendingIntent) objArr2[3], (Bundle) objArr2[4]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        public RemoteControlClient.MetadataEditor buildRccMetadata(Bundle bundle) {
            InterceptResult invokeL;
            long actions;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
                RemoteControlClient.MetadataEditor buildRccMetadata = super.buildRccMetadata(bundle);
                PlaybackStateCompat playbackStateCompat = this.mState;
                if (playbackStateCompat == null) {
                    actions = 0;
                } else {
                    actions = playbackStateCompat.getActions();
                }
                if ((actions & 128) != 0) {
                    buildRccMetadata.addEditableKey(268435457);
                }
                if (bundle == null) {
                    return buildRccMetadata;
                }
                if (bundle.containsKey("android.media.metadata.YEAR")) {
                    buildRccMetadata.putLong(8, bundle.getLong("android.media.metadata.YEAR"));
                }
                if (bundle.containsKey("android.media.metadata.RATING")) {
                    buildRccMetadata.putObject(101, (Object) bundle.getParcelable("android.media.metadata.RATING"));
                }
                if (bundle.containsKey("android.media.metadata.USER_RATING")) {
                    buildRccMetadata.putObject(268435457, (Object) bundle.getParcelable("android.media.metadata.USER_RATING"));
                }
                return buildRccMetadata;
            }
            return (RemoteControlClient.MetadataEditor) invokeL.objValue;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi18, android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        public int getRccTransportControlFlagsFromActions(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
                int rccTransportControlFlagsFromActions = super.getRccTransportControlFlagsFromActions(j);
                if ((j & 128) != 0) {
                    return rccTransportControlFlagsFromActions | 512;
                }
                return rccTransportControlFlagsFromActions;
            }
            return invokeJ.intValue;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi18, android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase, android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCallback(Callback callback, Handler handler) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, callback, handler) == null) {
                super.setCallback(callback, handler);
                if (callback == null) {
                    this.mRcc.setMetadataUpdateListener(null);
                    return;
                }
                this.mRcc.setMetadataUpdateListener(new RemoteControlClient.OnMetadataUpdateListener(this) { // from class: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi19.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MediaSessionImplApi19 this$0;

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

                    @Override // android.media.RemoteControlClient.OnMetadataUpdateListener
                    public void onMetadataUpdate(int i, Object obj) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i, obj) == null) && i == 268435457 && (obj instanceof Rating)) {
                            this.this$0.postToHandler(19, -1, -1, RatingCompat.fromRating(obj), null);
                        }
                    }
                });
            }
        }
    }

    @RequiresApi(28)
    /* loaded from: classes.dex */
    public static class MediaSessionImplApi28 extends MediaSessionImplApi21 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21, android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCurrentControllerInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, remoteUserInfo) == null) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MediaSessionImplApi28(MediaSession mediaSession, VersionedParcelable versionedParcelable, Bundle bundle) {
            super(mediaSession, versionedParcelable, bundle);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaSession, versionedParcelable, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((MediaSession) objArr2[0], (VersionedParcelable) objArr2[1], (Bundle) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MediaSessionImplApi28(Object obj) {
            super(obj);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21, android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        @NonNull
        public final MediaSessionManager.RemoteUserInfo getCurrentControllerInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new MediaSessionManager.RemoteUserInfo(this.mSessionFwk.getCurrentControllerInfo());
            }
            return (MediaSessionManager.RemoteUserInfo) invokeV.objValue;
        }
    }

    @RequiresApi(29)
    /* loaded from: classes.dex */
    public static class MediaSessionImplApi29 extends MediaSessionImplApi28 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MediaSessionImplApi29(MediaSession mediaSession, VersionedParcelable versionedParcelable, Bundle bundle) {
            super(mediaSession, versionedParcelable, bundle);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaSession, versionedParcelable, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((MediaSession) objArr2[0], (VersionedParcelable) objArr2[1], (Bundle) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MediaSessionImplApi29(Object obj) {
            super(obj);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mSessionInfo = ((MediaSession) obj).getController().getSessionInfo();
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static final class QueueItem implements Parcelable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final Parcelable.Creator<QueueItem> CREATOR;
        public static final int UNKNOWN_ID = -1;
        public transient /* synthetic */ FieldHolder $fh;
        public final MediaDescriptionCompat mDescription;
        public final long mId;
        public MediaSession.QueueItem mItemFwk;

        @Override // android.os.Parcelable
        public int describeContents() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1254976222, "Landroid/support/v4/media/session/MediaSessionCompat$QueueItem;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1254976222, "Landroid/support/v4/media/session/MediaSessionCompat$QueueItem;");
                    return;
                }
            }
            CREATOR = new Parcelable.Creator<QueueItem>() { // from class: android.support.v4.media.session.MediaSessionCompat.QueueItem.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public QueueItem createFromParcel(Parcel parcel) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                        return new QueueItem(parcel);
                    }
                    return (QueueItem) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public QueueItem[] newArray(int i) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                        return new QueueItem[i];
                    }
                    return (QueueItem[]) invokeI.objValue;
                }
            };
        }

        public MediaDescriptionCompat getDescription() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.mDescription;
            }
            return (MediaDescriptionCompat) invokeV.objValue;
        }

        public long getQueueId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.mId;
            }
            return invokeV.longValue;
        }

        public Object getQueueItem() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.mItemFwk == null && Build.VERSION.SDK_INT >= 21) {
                    MediaSession.QueueItem queueItem = new MediaSession.QueueItem((MediaDescription) this.mDescription.getMediaDescription(), this.mId);
                    this.mItemFwk = queueItem;
                    return queueItem;
                }
                return this.mItemFwk;
            }
            return invokeV.objValue;
        }

        public QueueItem(MediaSession.QueueItem queueItem, MediaDescriptionCompat mediaDescriptionCompat, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {queueItem, mediaDescriptionCompat, Long.valueOf(j)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            if (mediaDescriptionCompat != null) {
                if (j != -1) {
                    this.mDescription = mediaDescriptionCompat;
                    this.mId = j;
                    this.mItemFwk = queueItem;
                    return;
                }
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            }
            throw new IllegalArgumentException("Description cannot be null");
        }

        public QueueItem(Parcel parcel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.mDescription = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.mId = parcel.readLong();
        }

        public static QueueItem fromQueueItem(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj)) == null) {
                if (obj != null && Build.VERSION.SDK_INT >= 21) {
                    MediaSession.QueueItem queueItem = (MediaSession.QueueItem) obj;
                    return new QueueItem(queueItem, MediaDescriptionCompat.fromMediaDescription(queueItem.getDescription()), queueItem.getQueueId());
                }
                return null;
            }
            return (QueueItem) invokeL.objValue;
        }

        public static List<QueueItem> fromQueueItemList(List<?> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
                if (list != null && Build.VERSION.SDK_INT >= 21) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<?> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(fromQueueItem(it.next()));
                    }
                    return arrayList;
                }
                return null;
            }
            return (List) invokeL.objValue;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public QueueItem(MediaDescriptionCompat mediaDescriptionCompat, long j) {
            this(null, mediaDescriptionCompat, j);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaDescriptionCompat, Long.valueOf(j)};
                interceptable.invokeUnInit(65539, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((MediaSession.QueueItem) objArr2[0], (MediaDescriptionCompat) objArr2[1], ((Long) objArr2[2]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return "MediaSession.QueueItem {Description=" + this.mDescription + ", Id=" + this.mId + " }";
            }
            return (String) invokeV.objValue;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048581, this, parcel, i) == null) {
                this.mDescription.writeToParcel(parcel, i);
                parcel.writeLong(this.mId);
            }
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static final class ResultReceiverWrapper implements Parcelable {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public ResultReceiver mResultReceiver;

        @Override // android.os.Parcelable
        public int describeContents() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-65726789, "Landroid/support/v4/media/session/MediaSessionCompat$ResultReceiverWrapper;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-65726789, "Landroid/support/v4/media/session/MediaSessionCompat$ResultReceiverWrapper;");
                    return;
                }
            }
            CREATOR = new Parcelable.Creator<ResultReceiverWrapper>() { // from class: android.support.v4.media.session.MediaSessionCompat.ResultReceiverWrapper.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public ResultReceiverWrapper createFromParcel(Parcel parcel) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                        return new ResultReceiverWrapper(parcel);
                    }
                    return (ResultReceiverWrapper) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public ResultReceiverWrapper[] newArray(int i) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                        return new ResultReceiverWrapper[i];
                    }
                    return (ResultReceiverWrapper[]) invokeI.objValue;
                }
            };
        }

        public ResultReceiverWrapper(Parcel parcel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mResultReceiver = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        public ResultReceiverWrapper(@NonNull ResultReceiver resultReceiver) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {resultReceiver};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.mResultReceiver = resultReceiver;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, i) == null) {
                this.mResultReceiver.writeToParcel(parcel, i);
            }
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static final class Token implements Parcelable {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<Token> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        @GuardedBy("mLock")
        public IMediaSession mExtraBinder;
        public final Object mInner;
        public final Object mLock;
        @GuardedBy("mLock")
        public VersionedParcelable mSession2Token;

        @Override // android.os.Parcelable
        public int describeContents() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(727653065, "Landroid/support/v4/media/session/MediaSessionCompat$Token;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(727653065, "Landroid/support/v4/media/session/MediaSessionCompat$Token;");
                    return;
                }
            }
            CREATOR = new Parcelable.Creator<Token>() { // from class: android.support.v4.media.session.MediaSessionCompat.Token.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public Token createFromParcel(Parcel parcel) {
                    InterceptResult invokeL;
                    Object readStrongBinder;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                        if (Build.VERSION.SDK_INT >= 21) {
                            readStrongBinder = parcel.readParcelable(null);
                        } else {
                            readStrongBinder = parcel.readStrongBinder();
                        }
                        return new Token(readStrongBinder);
                    }
                    return (Token) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public Token[] newArray(int i) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                        return new Token[i];
                    }
                    return (Token[]) invokeI.objValue;
                }
            };
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public IMediaSession getExtraBinder() {
            InterceptResult invokeV;
            IMediaSession iMediaSession;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                synchronized (this.mLock) {
                    iMediaSession = this.mExtraBinder;
                }
                return iMediaSession;
            }
            return (IMediaSession) invokeV.objValue;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public VersionedParcelable getSession2Token() {
            InterceptResult invokeV;
            VersionedParcelable versionedParcelable;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                synchronized (this.mLock) {
                    versionedParcelable = this.mSession2Token;
                }
                return versionedParcelable;
            }
            return (VersionedParcelable) invokeV.objValue;
        }

        public Object getToken() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.mInner;
            }
            return invokeV.objValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                Object obj = this.mInner;
                if (obj == null) {
                    return 0;
                }
                return obj.hashCode();
            }
            return invokeV.intValue;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Token(Object obj) {
            this(obj, null, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this(objArr2[0], (IMediaSession) objArr2[1], (VersionedParcelable) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public static Token fromBundle(Bundle bundle) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bundle)) == null) {
                if (bundle == null) {
                    return null;
                }
                IMediaSession asInterface = IMediaSession.Stub.asInterface(BundleCompat.getBinder(bundle, MediaSessionCompat.KEY_EXTRA_BINDER));
                VersionedParcelable versionedParcelable = ParcelUtils.getVersionedParcelable(bundle, MediaSessionCompat.KEY_SESSION2_TOKEN);
                Token token = (Token) bundle.getParcelable(MediaSessionCompat.KEY_TOKEN);
                if (token == null) {
                    return null;
                }
                return new Token(token.mInner, asInterface, versionedParcelable);
            }
            return (Token) invokeL.objValue;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Token(Object obj, IMediaSession iMediaSession) {
            this(obj, iMediaSession, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj, iMediaSession};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this(objArr2[0], (IMediaSession) objArr2[1], (VersionedParcelable) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
        }

        public Token(Object obj, IMediaSession iMediaSession, VersionedParcelable versionedParcelable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj, iMediaSession, versionedParcelable};
                interceptable.invokeUnInit(65539, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.mLock = new Object();
            this.mInner = obj;
            this.mExtraBinder = iMediaSession;
            this.mSession2Token = versionedParcelable;
        }

        public static Token fromToken(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, obj)) == null) {
                return fromToken(obj, null);
            }
            return (Token) invokeL.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Token)) {
                    return false;
                }
                Token token = (Token) obj;
                Object obj2 = this.mInner;
                if (obj2 == null) {
                    if (token.mInner == null) {
                        return true;
                    }
                    return false;
                }
                Object obj3 = token.mInner;
                if (obj3 == null) {
                    return false;
                }
                return obj2.equals(obj3);
            }
            return invokeL.booleanValue;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public void setExtraBinder(IMediaSession iMediaSession) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, iMediaSession) == null) {
                synchronized (this.mLock) {
                    this.mExtraBinder = iMediaSession;
                }
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void setSession2Token(VersionedParcelable versionedParcelable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, versionedParcelable) == null) {
                synchronized (this.mLock) {
                    this.mSession2Token = versionedParcelable;
                }
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public static Token fromToken(Object obj, IMediaSession iMediaSession) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, obj, iMediaSession)) == null) {
                if (obj != null && Build.VERSION.SDK_INT >= 21) {
                    if (obj instanceof MediaSession.Token) {
                        return new Token(obj, iMediaSession);
                    }
                    throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
                }
                return null;
            }
            return (Token) invokeLL.objValue;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048585, this, parcel, i) == null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    parcel.writeParcelable((Parcelable) this.mInner, i);
                } else {
                    parcel.writeStrongBinder((IBinder) this.mInner);
                }
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Bundle toBundle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(MediaSessionCompat.KEY_TOKEN, this);
                synchronized (this.mLock) {
                    if (this.mExtraBinder != null) {
                        BundleCompat.putBinder(bundle, MediaSessionCompat.KEY_EXTRA_BINDER, this.mExtraBinder.asBinder());
                    }
                    if (this.mSession2Token != null) {
                        ParcelUtils.putVersionedParcelable(bundle, MediaSessionCompat.KEY_SESSION2_TOKEN, this.mSession2Token);
                    }
                }
                return bundle;
            }
            return (Bundle) invokeV.objValue;
        }
    }

    public MediaSessionCompat(Context context, MediaSessionImpl mediaSessionImpl) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mediaSessionImpl};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mActiveListeners = new ArrayList<>();
        this.mImpl = mediaSessionImpl;
        this.mController = new MediaControllerCompat(context, this);
    }

    public static MediaSessionCompat fromMediaSession(Context context, Object obj) {
        InterceptResult invokeLL;
        MediaSessionImpl mediaSessionImplApi21;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, obj)) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 21 && context != null && obj != null) {
                if (i >= 29) {
                    mediaSessionImplApi21 = new MediaSessionImplApi29(obj);
                } else if (i >= 28) {
                    mediaSessionImplApi21 = new MediaSessionImplApi28(obj);
                } else {
                    mediaSessionImplApi21 = new MediaSessionImplApi21(obj);
                }
                return new MediaSessionCompat(context, mediaSessionImplApi21);
            }
            return null;
        }
        return (MediaSessionCompat) invokeLL.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MediaSessionCompat(@NonNull Context context, @NonNull String str) {
        this(context, str, null, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1], (ComponentName) objArr2[2], (PendingIntent) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MediaSessionCompat(@NonNull Context context, @NonNull String str, @Nullable ComponentName componentName, @Nullable PendingIntent pendingIntent) {
        this(context, str, componentName, pendingIntent, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, componentName, pendingIntent};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1], (ComponentName) objArr2[2], (PendingIntent) objArr2[3], (Bundle) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MediaSessionCompat(@NonNull Context context, @NonNull String str, @Nullable ComponentName componentName, @Nullable PendingIntent pendingIntent, @Nullable Bundle bundle) {
        this(context, str, componentName, pendingIntent, bundle, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, componentName, pendingIntent, bundle};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1], (ComponentName) objArr2[2], (PendingIntent) objArr2[3], (Bundle) objArr2[4], (VersionedParcelable) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public MediaSessionCompat(@NonNull Context context, @NonNull String str, @Nullable ComponentName componentName, @Nullable PendingIntent pendingIntent, @Nullable Bundle bundle, @Nullable VersionedParcelable versionedParcelable) {
        Looper mainLooper;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, componentName, pendingIntent, bundle, versionedParcelable};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.mActiveListeners = new ArrayList<>();
        if (context != null) {
            if (!TextUtils.isEmpty(str)) {
                if (componentName == null && (componentName = MediaButtonReceiver.getMediaButtonReceiverComponent(context)) == null) {
                    Log.w(TAG, "Couldn't find a unique registered media button receiver in the given context.");
                }
                ComponentName componentName2 = componentName;
                if (componentName2 != null && pendingIntent == null) {
                    Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
                    intent.setComponent(componentName2);
                    pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
                }
                PendingIntent pendingIntent2 = pendingIntent;
                int i3 = Build.VERSION.SDK_INT;
                if (i3 >= 21) {
                    MediaSession createFwkMediaSession = createFwkMediaSession(context, str, bundle);
                    int i4 = Build.VERSION.SDK_INT;
                    if (i4 >= 29) {
                        this.mImpl = new MediaSessionImplApi29(createFwkMediaSession, versionedParcelable, bundle);
                    } else if (i4 >= 28) {
                        this.mImpl = new MediaSessionImplApi28(createFwkMediaSession, versionedParcelable, bundle);
                    } else {
                        this.mImpl = new MediaSessionImplApi21(createFwkMediaSession, versionedParcelable, bundle);
                    }
                    if (Looper.myLooper() != null) {
                        mainLooper = Looper.myLooper();
                    } else {
                        mainLooper = Looper.getMainLooper();
                    }
                    setCallback(new Callback(this) { // from class: android.support.v4.media.session.MediaSessionCompat.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ MediaSessionCompat this$0;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext2 = TitanRuntime.newInitContext();
                                newInitContext2.initArgs = r2;
                                Object[] objArr2 = {this};
                                interceptable2.invokeUnInit(65536, newInitContext2);
                                int i5 = newInitContext2.flag;
                                if ((i5 & 1) != 0) {
                                    int i6 = i5 & 2;
                                    newInitContext2.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext2);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }
                    }, new Handler(mainLooper));
                    this.mImpl.setMediaButtonReceiver(pendingIntent2);
                } else if (i3 >= 19) {
                    this.mImpl = new MediaSessionImplApi19(context, str, componentName2, pendingIntent2, bundle);
                } else if (i3 >= 18) {
                    this.mImpl = new MediaSessionImplApi18(context, str, componentName2, pendingIntent2, bundle);
                } else {
                    this.mImpl = new MediaSessionImplBase(context, str, componentName2, pendingIntent2, bundle);
                }
                this.mController = new MediaControllerCompat(context, this);
                if (sMaxBitmapSize == 0) {
                    sMaxBitmapSize = (int) (TypedValue.applyDimension(1, 320.0f, context.getResources().getDisplayMetrics()) + 0.5f);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("tag must not be null or empty");
        }
        throw new IllegalArgumentException("context must not be null");
    }

    @RequiresApi(21)
    private MediaSession createFwkMediaSession(Context context, String str, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, this, context, str, bundle)) == null) {
            if (Build.VERSION.SDK_INT >= 29) {
                return new MediaSession(context, str, bundle);
            }
            return new MediaSession(context, str);
        }
        return (MediaSession) invokeLLL.objValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static void ensureClassLoader(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, bundle) == null) && bundle != null) {
            bundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
        }
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Bundle unparcelWithClassLoader(@Nullable Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, bundle)) == null) {
            if (bundle == null) {
                return null;
            }
            ensureClassLoader(bundle);
            try {
                bundle.isEmpty();
                return bundle;
            } catch (BadParcelableException unused) {
                Log.e(TAG, "Could not unparcel the data.");
                return null;
            }
        }
        return (Bundle) invokeL.objValue;
    }

    public void addOnActiveChangeListener(OnActiveChangeListener onActiveChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onActiveChangeListener) == null) {
            if (onActiveChangeListener != null) {
                this.mActiveListeners.add(onActiveChangeListener);
                return;
            }
            throw new IllegalArgumentException("Listener may not be null");
        }
    }

    public void removeOnActiveChangeListener(OnActiveChangeListener onActiveChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, onActiveChangeListener) == null) {
            if (onActiveChangeListener != null) {
                this.mActiveListeners.remove(onActiveChangeListener);
                return;
            }
            throw new IllegalArgumentException("Listener may not be null");
        }
    }

    public void setActive(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.mImpl.setActive(z);
            Iterator<OnActiveChangeListener> it = this.mActiveListeners.iterator();
            while (it.hasNext()) {
                it.next().onActiveChanged();
            }
        }
    }

    public void setCallback(Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, callback) == null) {
            setCallback(callback, null);
        }
    }

    public void setCaptioningEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.mImpl.setCaptioningEnabled(z);
        }
    }

    public void setExtras(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bundle) == null) {
            this.mImpl.setExtras(bundle);
        }
    }

    public void setFlags(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.mImpl.setFlags(i);
        }
    }

    public void setMediaButtonReceiver(PendingIntent pendingIntent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, pendingIntent) == null) {
            this.mImpl.setMediaButtonReceiver(pendingIntent);
        }
    }

    public void setMetadata(MediaMetadataCompat mediaMetadataCompat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, mediaMetadataCompat) == null) {
            this.mImpl.setMetadata(mediaMetadataCompat);
        }
    }

    public void setPlaybackState(PlaybackStateCompat playbackStateCompat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, playbackStateCompat) == null) {
            this.mImpl.setPlaybackState(playbackStateCompat);
        }
    }

    public void setPlaybackToLocal(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.mImpl.setPlaybackToLocal(i);
        }
    }

    public void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, volumeProviderCompat) == null) {
            if (volumeProviderCompat != null) {
                this.mImpl.setPlaybackToRemote(volumeProviderCompat);
                return;
            }
            throw new IllegalArgumentException("volumeProvider may not be null!");
        }
    }

    public void setQueue(List<QueueItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, list) == null) {
            this.mImpl.setQueue(list);
        }
    }

    public void setQueueTitle(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, charSequence) == null) {
            this.mImpl.setQueueTitle(charSequence);
        }
    }

    public void setRatingType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.mImpl.setRatingType(i);
        }
    }

    public void setRepeatMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.mImpl.setRepeatMode(i);
        }
    }

    public void setSessionActivity(PendingIntent pendingIntent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, pendingIntent) == null) {
            this.mImpl.setSessionActivity(pendingIntent);
        }
    }

    public void setShuffleMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.mImpl.setShuffleMode(i);
        }
    }

    public static PlaybackStateCompat getStateWithUpdatedPosition(PlaybackStateCompat playbackStateCompat, MediaMetadataCompat mediaMetadataCompat) {
        InterceptResult invokeLL;
        long lastPositionUpdateTime;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, playbackStateCompat, mediaMetadataCompat)) == null) {
            if (playbackStateCompat != null) {
                long j2 = -1;
                if (playbackStateCompat.getPosition() != -1) {
                    if (playbackStateCompat.getState() == 3 || playbackStateCompat.getState() == 4 || playbackStateCompat.getState() == 5) {
                        if (playbackStateCompat.getLastPositionUpdateTime() > 0) {
                            long elapsedRealtime = SystemClock.elapsedRealtime();
                            long playbackSpeed = (playbackStateCompat.getPlaybackSpeed() * ((float) (elapsedRealtime - lastPositionUpdateTime))) + playbackStateCompat.getPosition();
                            if (mediaMetadataCompat != null && mediaMetadataCompat.containsKey("android.media.metadata.DURATION")) {
                                j2 = mediaMetadataCompat.getLong("android.media.metadata.DURATION");
                            }
                            if (j2 >= 0 && playbackSpeed > j2) {
                                j = j2;
                            } else if (playbackSpeed < 0) {
                                j = 0;
                            } else {
                                j = playbackSpeed;
                            }
                            return new PlaybackStateCompat.Builder(playbackStateCompat).setState(playbackStateCompat.getState(), j, playbackStateCompat.getPlaybackSpeed(), elapsedRealtime).build();
                        }
                        return playbackStateCompat;
                    }
                    return playbackStateCompat;
                }
                return playbackStateCompat;
            }
            return playbackStateCompat;
        }
        return (PlaybackStateCompat) invokeLL.objValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public String getCallingPackage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mImpl.getCallingPackage();
        }
        return (String) invokeV.objValue;
    }

    public MediaControllerCompat getController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mController;
        }
        return (MediaControllerCompat) invokeV.objValue;
    }

    @NonNull
    public final MediaSessionManager.RemoteUserInfo getCurrentControllerInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mImpl.getCurrentControllerInfo();
        }
        return (MediaSessionManager.RemoteUserInfo) invokeV.objValue;
    }

    public Object getMediaSession() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mImpl.getMediaSession();
        }
        return invokeV.objValue;
    }

    public Object getRemoteControlClient() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mImpl.getRemoteControlClient();
        }
        return invokeV.objValue;
    }

    public Token getSessionToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mImpl.getSessionToken();
        }
        return (Token) invokeV.objValue;
    }

    public boolean isActive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mImpl.isActive();
        }
        return invokeV.booleanValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.mImpl.release();
        }
    }

    public void sendSessionEvent(String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, bundle) == null) {
            if (!TextUtils.isEmpty(str)) {
                this.mImpl.sendSessionEvent(str, bundle);
                return;
            }
            throw new IllegalArgumentException("event cannot be null or empty");
        }
    }

    public void setCallback(Callback callback, Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, callback, handler) == null) {
            if (callback == null) {
                this.mImpl.setCallback(null, null);
                return;
            }
            MediaSessionImpl mediaSessionImpl = this.mImpl;
            if (handler == null) {
                handler = new Handler();
            }
            mediaSessionImpl.setCallback(callback, handler);
        }
    }
}
