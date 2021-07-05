package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.Rating;
import android.media.RemoteControlClient;
import android.media.session.MediaSession;
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
import android.support.v4.media.session.MediaSessionCompatApi21;
import android.support.v4.media.session.MediaSessionCompatApi23;
import android.support.v4.media.session.MediaSessionCompatApi24;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.app.BundleCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.media.MediaSessionManager;
import androidx.media.VolumeProviderCompat;
import androidx.media.session.MediaButtonReceiver;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.router.RouterCallback;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
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
    public static final int FLAG_HANDLES_MEDIA_BUTTONS = 1;
    public static final int FLAG_HANDLES_QUEUE_COMMANDS = 4;
    public static final int FLAG_HANDLES_TRANSPORT_CONTROLS = 2;
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String KEY_EXTRA_BINDER = "android.support.v4.media.session.EXTRA_BINDER";
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String KEY_SESSION_TOKEN2_BUNDLE = "android.support.v4.media.session.SESSION_TOKEN2_BUNDLE";
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
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
    public static abstract class Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public CallbackHandler mCallbackHandler;
        public final Object mCallbackObj;
        public boolean mMediaPlayPauseKeyPending;
        public WeakReference<MediaSessionImpl> mSessionImpl;

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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
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
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 1) {
                    this.this$0.handleMediaPlayPauseKeySingleTapIfPending((MediaSessionManager.RemoteUserInfo) message.obj);
                }
            }
        }

        @RequiresApi(21)
        /* loaded from: classes.dex */
        public class StubApi21 implements MediaSessionCompatApi21.Callback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Callback this$0;

            public StubApi21(Callback callback) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {callback};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = callback;
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLL(1048576, this, str, bundle, resultReceiver) == null) {
                    try {
                        QueueItem queueItem = null;
                        IBinder asBinder = null;
                        queueItem = null;
                        if (str.equals(MediaControllerCompat.COMMAND_GET_EXTRA_BINDER)) {
                            MediaSessionImplApi21 mediaSessionImplApi21 = (MediaSessionImplApi21) this.this$0.mSessionImpl.get();
                            if (mediaSessionImplApi21 != null) {
                                Bundle bundle2 = new Bundle();
                                Token sessionToken = mediaSessionImplApi21.getSessionToken();
                                IMediaSession extraBinder = sessionToken.getExtraBinder();
                                if (extraBinder != null) {
                                    asBinder = extraBinder.asBinder();
                                }
                                BundleCompat.putBinder(bundle2, MediaSessionCompat.KEY_EXTRA_BINDER, asBinder);
                                bundle2.putBundle(MediaSessionCompat.KEY_SESSION_TOKEN2_BUNDLE, sessionToken.getSessionToken2Bundle());
                                resultReceiver.send(0, bundle2);
                            }
                        } else if (str.equals(MediaControllerCompat.COMMAND_ADD_QUEUE_ITEM)) {
                            this.this$0.onAddQueueItem((MediaDescriptionCompat) bundle.getParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION));
                        } else if (str.equals(MediaControllerCompat.COMMAND_ADD_QUEUE_ITEM_AT)) {
                            this.this$0.onAddQueueItem((MediaDescriptionCompat) bundle.getParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION), bundle.getInt(MediaControllerCompat.COMMAND_ARGUMENT_INDEX));
                        } else if (str.equals(MediaControllerCompat.COMMAND_REMOVE_QUEUE_ITEM)) {
                            this.this$0.onRemoveQueueItem((MediaDescriptionCompat) bundle.getParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION));
                        } else if (str.equals(MediaControllerCompat.COMMAND_REMOVE_QUEUE_ITEM_AT)) {
                            MediaSessionImplApi21 mediaSessionImplApi212 = (MediaSessionImplApi21) this.this$0.mSessionImpl.get();
                            if (mediaSessionImplApi212 == null || mediaSessionImplApi212.mQueue == null) {
                                return;
                            }
                            int i2 = bundle.getInt(MediaControllerCompat.COMMAND_ARGUMENT_INDEX, -1);
                            if (i2 >= 0 && i2 < mediaSessionImplApi212.mQueue.size()) {
                                queueItem = mediaSessionImplApi212.mQueue.get(i2);
                            }
                            if (queueItem != null) {
                                this.this$0.onRemoveQueueItem(queueItem.getDescription());
                            }
                        } else {
                            this.this$0.onCommand(str, bundle, resultReceiver);
                        }
                    } catch (BadParcelableException unused) {
                        Log.e(MediaSessionCompat.TAG, "Could not unparcel the extra data.");
                    }
                }
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onCustomAction(String str, Bundle bundle) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bundle) == null) {
                    Bundle bundle2 = bundle.getBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS);
                    MediaSessionCompat.ensureClassLoader(bundle2);
                    if (str.equals(MediaSessionCompat.ACTION_PLAY_FROM_URI)) {
                        this.this$0.onPlayFromUri((Uri) bundle.getParcelable(MediaSessionCompat.ACTION_ARGUMENT_URI), bundle2);
                    } else if (str.equals(MediaSessionCompat.ACTION_PREPARE)) {
                        this.this$0.onPrepare();
                    } else if (str.equals(MediaSessionCompat.ACTION_PREPARE_FROM_MEDIA_ID)) {
                        this.this$0.onPrepareFromMediaId(bundle.getString(MediaSessionCompat.ACTION_ARGUMENT_MEDIA_ID), bundle2);
                    } else if (str.equals(MediaSessionCompat.ACTION_PREPARE_FROM_SEARCH)) {
                        this.this$0.onPrepareFromSearch(bundle.getString(MediaSessionCompat.ACTION_ARGUMENT_QUERY), bundle2);
                    } else if (str.equals(MediaSessionCompat.ACTION_PREPARE_FROM_URI)) {
                        this.this$0.onPrepareFromUri((Uri) bundle.getParcelable(MediaSessionCompat.ACTION_ARGUMENT_URI), bundle2);
                    } else if (str.equals(MediaSessionCompat.ACTION_SET_CAPTIONING_ENABLED)) {
                        this.this$0.onSetCaptioningEnabled(bundle.getBoolean(MediaSessionCompat.ACTION_ARGUMENT_CAPTIONING_ENABLED));
                    } else if (str.equals(MediaSessionCompat.ACTION_SET_REPEAT_MODE)) {
                        this.this$0.onSetRepeatMode(bundle.getInt(MediaSessionCompat.ACTION_ARGUMENT_REPEAT_MODE));
                    } else if (str.equals(MediaSessionCompat.ACTION_SET_SHUFFLE_MODE)) {
                        this.this$0.onSetShuffleMode(bundle.getInt(MediaSessionCompat.ACTION_ARGUMENT_SHUFFLE_MODE));
                    } else if (str.equals(MediaSessionCompat.ACTION_SET_RATING)) {
                        this.this$0.onSetRating((RatingCompat) bundle.getParcelable(MediaSessionCompat.ACTION_ARGUMENT_RATING), bundle2);
                    } else {
                        this.this$0.onCustomAction(str, bundle);
                    }
                }
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onFastForward() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.this$0.onFastForward();
                }
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public boolean onMediaButtonEvent(Intent intent) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, intent)) == null) ? this.this$0.onMediaButtonEvent(intent) : invokeL.booleanValue;
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onPause() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                    this.this$0.onPause();
                }
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onPlay() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                    this.this$0.onPlay();
                }
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onPlayFromMediaId(String str, Bundle bundle) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048582, this, str, bundle) == null) {
                    this.this$0.onPlayFromMediaId(str, bundle);
                }
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onPlayFromSearch(String str, Bundle bundle) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048583, this, str, bundle) == null) {
                    this.this$0.onPlayFromSearch(str, bundle);
                }
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onRewind() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                    this.this$0.onRewind();
                }
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onSeekTo(long j) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
                    this.this$0.onSeekTo(j);
                }
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onSetRating(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048586, this, obj) == null) {
                    this.this$0.onSetRating(RatingCompat.fromRating(obj));
                }
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onSetRating(Object obj, Bundle bundle) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048587, this, obj, bundle) == null) {
                }
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onSkipToNext() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
                    this.this$0.onSkipToNext();
                }
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onSkipToPrevious() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
                    this.this$0.onSkipToPrevious();
                }
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onSkipToQueueItem(long j) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeJ(1048590, this, j) == null) {
                    this.this$0.onSkipToQueueItem(j);
                }
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onStop() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
                    this.this$0.onStop();
                }
            }
        }

        @RequiresApi(23)
        /* loaded from: classes.dex */
        public class StubApi23 extends StubApi21 implements MediaSessionCompatApi23.Callback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Callback this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public StubApi23(Callback callback) {
                super(callback);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {callback};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((Callback) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = callback;
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi23.Callback
            public void onPlayFromUri(Uri uri, Bundle bundle) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048576, this, uri, bundle) == null) {
                    this.this$0.onPlayFromUri(uri, bundle);
                }
            }
        }

        @RequiresApi(24)
        /* loaded from: classes.dex */
        public class StubApi24 extends StubApi23 implements MediaSessionCompatApi24.Callback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Callback this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public StubApi24(Callback callback) {
                super(callback);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {callback};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((Callback) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = callback;
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi24.Callback
            public void onPrepare() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.this$0.onPrepare();
                }
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi24.Callback
            public void onPrepareFromMediaId(String str, Bundle bundle) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bundle) == null) {
                    this.this$0.onPrepareFromMediaId(str, bundle);
                }
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi24.Callback
            public void onPrepareFromSearch(String str, Bundle bundle) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bundle) == null) {
                    this.this$0.onPrepareFromSearch(str, bundle);
                }
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi24.Callback
            public void onPrepareFromUri(Uri uri, Bundle bundle) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048579, this, uri, bundle) == null) {
                    this.this$0.onPrepareFromUri(uri, bundle);
                }
            }
        }

        public Callback() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mCallbackHandler = null;
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 24) {
                this.mCallbackObj = MediaSessionCompatApi24.createCallback(new StubApi24(this));
            } else if (i4 >= 23) {
                this.mCallbackObj = MediaSessionCompatApi23.createCallback(new StubApi23(this));
            } else if (i4 >= 21) {
                this.mCallbackObj = MediaSessionCompatApi21.createCallback(new StubApi21(this));
            } else {
                this.mCallbackObj = null;
            }
        }

        public void handleMediaPlayPauseKeySingleTapIfPending(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, remoteUserInfo) == null) && this.mMediaPlayPauseKeyPending) {
                this.mMediaPlayPauseKeyPending = false;
                this.mCallbackHandler.removeMessages(1);
                MediaSessionImpl mediaSessionImpl = this.mSessionImpl.get();
                if (mediaSessionImpl == null) {
                    return;
                }
                PlaybackStateCompat playbackState = mediaSessionImpl.getPlaybackState();
                long actions = playbackState == null ? 0L : playbackState.getActions();
                boolean z = playbackState != null && playbackState.getState() == 3;
                boolean z2 = (516 & actions) != 0;
                boolean z3 = (actions & 514) != 0;
                mediaSessionImpl.setCurrentControllerInfo(remoteUserInfo);
                if (z && z3) {
                    onPause();
                } else if (!z && z2) {
                    onPlay();
                }
                mediaSessionImpl.setCurrentControllerInfo(null);
            }
        }

        public void onAddQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaDescriptionCompat) == null) {
            }
        }

        public void onAddQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, mediaDescriptionCompat, i2) == null) {
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

        public boolean onMediaButtonEvent(Intent intent) {
            InterceptResult invokeL;
            MediaSessionImpl mediaSessionImpl;
            KeyEvent keyEvent;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, intent)) == null) {
                if (Build.VERSION.SDK_INT >= 27 || (mediaSessionImpl = this.mSessionImpl.get()) == null || this.mCallbackHandler == null || (keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT")) == null || keyEvent.getAction() != 0) {
                    return false;
                }
                MediaSessionManager.RemoteUserInfo currentControllerInfo = mediaSessionImpl.getCurrentControllerInfo();
                int keyCode = keyEvent.getKeyCode();
                if (keyCode != 79 && keyCode != 85) {
                    handleMediaPlayPauseKeySingleTapIfPending(currentControllerInfo);
                    return false;
                }
                if (keyEvent.getRepeatCount() > 0) {
                    handleMediaPlayPauseKeySingleTapIfPending(currentControllerInfo);
                } else if (this.mMediaPlayPauseKeyPending) {
                    this.mCallbackHandler.removeMessages(1);
                    this.mMediaPlayPauseKeyPending = false;
                    PlaybackStateCompat playbackState = mediaSessionImpl.getPlaybackState();
                    if (((playbackState == null ? 0L : playbackState.getActions()) & 32) != 0) {
                        onSkipToNext();
                    }
                } else {
                    this.mMediaPlayPauseKeyPending = true;
                    CallbackHandler callbackHandler = this.mCallbackHandler;
                    callbackHandler.sendMessageDelayed(callbackHandler.obtainMessage(1, currentControllerInfo), ViewConfiguration.getDoubleTapTimeout());
                }
                return true;
            }
            return invokeL.booleanValue;
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
        public void onRemoveQueueItemAt(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
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

        public void onSetRating(RatingCompat ratingCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048597, this, ratingCompat) == null) {
            }
        }

        public void onSetRating(RatingCompat ratingCompat, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048598, this, ratingCompat, bundle) == null) {
            }
        }

        public void onSetRepeatMode(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            }
        }

        public void onSetShuffleMode(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            }
        }

        public void onSkipToNext() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            }
        }

        public void onSkipToPrevious() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            }
        }

        public void onSkipToQueueItem(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048603, this, j) == null) {
            }
        }

        public void onStop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            }
        }

        public void setSessionImpl(MediaSessionImpl mediaSessionImpl, Handler handler) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048605, this, mediaSessionImpl, handler) == null) {
                this.mSessionImpl = new WeakReference<>(mediaSessionImpl);
                CallbackHandler callbackHandler = this.mCallbackHandler;
                if (callbackHandler != null) {
                    callbackHandler.removeCallbacksAndMessages(null);
                }
                this.mCallbackHandler = new CallbackHandler(this, handler.getLooper());
            }
        }
    }

    /* loaded from: classes.dex */
    public interface MediaSessionImpl {
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

        void setFlags(int i2);

        void setMediaButtonReceiver(PendingIntent pendingIntent);

        void setMetadata(MediaMetadataCompat mediaMetadataCompat);

        void setPlaybackState(PlaybackStateCompat playbackStateCompat);

        void setPlaybackToLocal(int i2);

        void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat);

        void setQueue(List<QueueItem> list);

        void setQueueTitle(CharSequence charSequence);

        void setRatingType(int i2);

        void setRepeatMode(int i2);

        void setSessionActivity(PendingIntent pendingIntent);

        void setShuffleMode(int i2);
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
        public MediaSessionImplApi18(Context context, String str, ComponentName componentName, PendingIntent pendingIntent) {
            super(context, str, componentName, pendingIntent);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str, componentName, pendingIntent};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (String) objArr2[1], (ComponentName) objArr2[2], (PendingIntent) objArr2[3]);
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
                return (j & 256) != 0 ? rccTransportControlFlagsFromActions | 256 : rccTransportControlFlagsFromActions;
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
                if (sIsMbrPendingIntentSupported) {
                    return;
                }
                super.registerMediaButtonEventReceiver(pendingIntent, componentName);
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
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
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
    }

    @RequiresApi(19)
    /* loaded from: classes.dex */
    public static class MediaSessionImplApi19 extends MediaSessionImplApi18 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MediaSessionImplApi19(Context context, String str, ComponentName componentName, PendingIntent pendingIntent) {
            super(context, str, componentName, pendingIntent);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str, componentName, pendingIntent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (String) objArr2[1], (ComponentName) objArr2[2], (PendingIntent) objArr2[3]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        public RemoteControlClient.MetadataEditor buildRccMetadata(Bundle bundle) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
                RemoteControlClient.MetadataEditor buildRccMetadata = super.buildRccMetadata(bundle);
                PlaybackStateCompat playbackStateCompat = this.mState;
                if (((playbackStateCompat == null ? 0L : playbackStateCompat.getActions()) & 128) != 0) {
                    buildRccMetadata.addEditableKey(RouterCallback.CODE_ERROR);
                }
                if (bundle == null) {
                    return buildRccMetadata;
                }
                if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_YEAR)) {
                    buildRccMetadata.putLong(8, bundle.getLong(MediaMetadataCompat.METADATA_KEY_YEAR));
                }
                if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_RATING)) {
                    buildRccMetadata.putObject(101, (Object) bundle.getParcelable(MediaMetadataCompat.METADATA_KEY_RATING));
                }
                if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_USER_RATING)) {
                    buildRccMetadata.putObject(RouterCallback.CODE_ERROR, (Object) bundle.getParcelable(MediaMetadataCompat.METADATA_KEY_USER_RATING));
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
                return (j & 128) != 0 ? rccTransportControlFlagsFromActions | 512 : rccTransportControlFlagsFromActions;
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
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // android.media.RemoteControlClient.OnMetadataUpdateListener
                    public void onMetadataUpdate(int i2, Object obj) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, obj) == null) && i2 == 268435457 && (obj instanceof Rating)) {
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MediaSessionImplApi28(Context context, String str, Bundle bundle) {
            super(context, str, bundle);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (String) objArr2[1], (Bundle) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21, android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        @NonNull
        public final MediaSessionManager.RemoteUserInfo getCurrentControllerInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new MediaSessionManager.RemoteUserInfo(((MediaSession) this.mSessionObj).getCurrentControllerInfo()) : (MediaSessionManager.RemoteUserInfo) invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21, android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCurrentControllerInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, remoteUserInfo) == null) {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
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
        public boolean mIsMbrRegistered;
        public boolean mIsRccRegistered;
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
        public int mShuffleMode;
        public PlaybackStateCompat mState;
        public final MediaSessionStub mStub;
        public final String mTag;
        public final Token mToken;
        public VolumeProviderCompat.Callback mVolumeCallback;
        public VolumeProviderCompat mVolumeProvider;
        public int mVolumeType;

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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
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

            public MediaSessionStub(MediaSessionImplBase mediaSessionImplBase) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mediaSessionImplBase};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
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

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItemAt(MediaDescriptionCompat mediaDescriptionCompat, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaDescriptionCompat, i2) == null) {
                    postToHandler(26, mediaDescriptionCompat, i2);
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void adjustVolume(int i2, int i3, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, str) == null) {
                    this.this$0.adjustVolume(i2, i3);
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
                return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.this$0.mMetadata : (MediaMetadataCompat) invokeV.objValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public String getPackageName() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.this$0.mPackageName : (String) invokeV.objValue;
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
                return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.this$0.mQueueTitle : (CharSequence) invokeV.objValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getRatingType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.this$0.mRatingType : invokeV.intValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getRepeatMode() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.this$0.mRepeatMode : invokeV.intValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getShuffleMode() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.this$0.mShuffleMode : invokeV.intValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public String getTag() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.this$0.mTag : (String) invokeV.objValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public ParcelableVolumeInfo getVolumeAttributes() {
                InterceptResult invokeV;
                int i2;
                int i3;
                int streamMaxVolume;
                int streamVolume;
                int i4;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                    synchronized (this.this$0.mLock) {
                        i2 = this.this$0.mVolumeType;
                        i3 = this.this$0.mLocalStream;
                        VolumeProviderCompat volumeProviderCompat = this.this$0.mVolumeProvider;
                        if (i2 == 2) {
                            int volumeControl = volumeProviderCompat.getVolumeControl();
                            int maxVolume = volumeProviderCompat.getMaxVolume();
                            streamVolume = volumeProviderCompat.getCurrentVolume();
                            streamMaxVolume = maxVolume;
                            i4 = volumeControl;
                        } else {
                            streamMaxVolume = this.this$0.mAudioManager.getStreamMaxVolume(i3);
                            streamVolume = this.this$0.mAudioManager.getStreamVolume(i3);
                            i4 = 2;
                        }
                    }
                    return new ParcelableVolumeInfo(i2, i3, i4, streamMaxVolume, streamVolume);
                }
                return (ParcelableVolumeInfo) invokeV.objValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isCaptioningEnabled() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.this$0.mCaptioningEnabled : invokeV.booleanValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isShuffleModeEnabledRemoved() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isTransportControlEnabled() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? (this.this$0.mFlags & 2) != 0 : invokeV.booleanValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void next() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
                    postToHandler(14);
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void pause() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
                    postToHandler(12);
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void play() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
                    postToHandler(7);
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromMediaId(String str, Bundle bundle) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048599, this, str, bundle) == null) {
                    postToHandler(8, str, bundle);
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromSearch(String str, Bundle bundle) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048600, this, str, bundle) == null) {
                    postToHandler(9, str, bundle);
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromUri(Uri uri, Bundle bundle) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048601, this, uri, bundle) == null) {
                    postToHandler(10, uri, bundle);
                }
            }

            public void postToHandler(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
                    this.this$0.postToHandler(i2, 0, 0, null, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepare() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
                    postToHandler(3);
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromMediaId(String str, Bundle bundle) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048608, this, str, bundle) == null) {
                    postToHandler(4, str, bundle);
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromSearch(String str, Bundle bundle) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048609, this, str, bundle) == null) {
                    postToHandler(5, str, bundle);
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromUri(Uri uri, Bundle bundle) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048610, this, uri, bundle) == null) {
                    postToHandler(6, uri, bundle);
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void previous() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
                    postToHandler(15);
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rate(RatingCompat ratingCompat) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048612, this, ratingCompat) == null) {
                    postToHandler(19, ratingCompat);
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rateWithExtras(RatingCompat ratingCompat, Bundle bundle) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048613, this, ratingCompat, bundle) == null) {
                    postToHandler(31, ratingCompat, bundle);
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void registerCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048614, this, iMediaControllerCallback) == null) {
                    if (this.this$0.mDestroyed) {
                        try {
                            iMediaControllerCallback.onSessionDestroyed();
                            return;
                        } catch (Exception unused) {
                            return;
                        }
                    }
                    this.this$0.mControllerCallbacks.register(iMediaControllerCallback, new MediaSessionManager.RemoteUserInfo(MediaSessionManager.RemoteUserInfo.LEGACY_CONTROLLER, Binder.getCallingPid(), Binder.getCallingUid()));
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048615, this, mediaDescriptionCompat) == null) {
                    postToHandler(27, mediaDescriptionCompat);
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItemAt(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
                    postToHandler(28, i2);
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rewind() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
                    postToHandler(17);
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void seekTo(long j) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeJ(1048618, this, j) == null) {
                    postToHandler(18, Long.valueOf(j));
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCommand(String str, Bundle bundle, ResultReceiverWrapper resultReceiverWrapper) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLL(1048619, this, str, bundle, resultReceiverWrapper) == null) {
                    postToHandler(1, new Command(str, bundle, resultReceiverWrapper.mResultReceiver));
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCustomAction(String str, Bundle bundle) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048620, this, str, bundle) == null) {
                    postToHandler(20, str, bundle);
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean sendMediaButton(KeyEvent keyEvent) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, keyEvent)) == null) {
                    boolean z = (this.this$0.mFlags & 1) != 0;
                    if (z) {
                        postToHandler(21, keyEvent);
                    }
                    return z;
                }
                return invokeL.booleanValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setCaptioningEnabled(boolean z) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
                    postToHandler(29, Boolean.valueOf(z));
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setRepeatMode(int i2) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048623, this, i2) == null) {
                    postToHandler(23, i2);
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleMode(int i2) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048624, this, i2) == null) {
                    postToHandler(30, i2);
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleModeEnabledRemoved(boolean z) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setVolumeTo(int i2, int i3, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIIL(1048626, this, i2, i3, str) == null) {
                    this.this$0.setVolumeTo(i2, i3);
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void skipToQueueItem(long j) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeJ(1048627, this, j) == null) {
                    postToHandler(11, Long.valueOf(j));
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void stop() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
                    postToHandler(13);
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void unregisterCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048629, this, iMediaControllerCallback) == null) {
                    this.this$0.mControllerCallbacks.unregister(iMediaControllerCallback);
                }
            }

            public void postToHandler(int i2, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeII(1048603, this, i2, i3) == null) {
                    this.this$0.postToHandler(i2, i3, 0, null, null);
                }
            }

            public void postToHandler(int i2, Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048604, this, i2, obj) == null) {
                    this.this$0.postToHandler(i2, 0, 0, obj, null);
                }
            }

            public void postToHandler(int i2, Object obj, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{Integer.valueOf(i2), obj, Integer.valueOf(i3)}) == null) {
                    this.this$0.postToHandler(i2, i3, 0, obj, null);
                }
            }

            public void postToHandler(int i2, Object obj, Bundle bundle) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeILL(1048606, this, i2, obj, bundle) == null) {
                    this.this$0.postToHandler(i2, 0, 0, obj, bundle);
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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((Looper) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = mediaSessionImplBase;
            }

            private void onMediaButtonEvent(KeyEvent keyEvent, Callback callback) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(65537, this, keyEvent, callback) == null) && keyEvent != null && keyEvent.getAction() == 0) {
                    PlaybackStateCompat playbackStateCompat = this.this$0.mState;
                    long actions = playbackStateCompat == null ? 0L : playbackStateCompat.getActions();
                    int keyCode = keyEvent.getKeyCode();
                    if (keyCode != 79) {
                        if (keyCode == 126) {
                            if ((actions & 4) != 0) {
                                callback.onPlay();
                                return;
                            }
                            return;
                        } else if (keyCode == 127) {
                            if ((actions & 2) != 0) {
                                callback.onPause();
                                return;
                            }
                            return;
                        } else {
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
                        }
                    }
                    Log.w(MediaSessionCompat.TAG, "KEYCODE_MEDIA_PLAY_PAUSE and KEYCODE_HEADSETHOOK are handled already");
                }
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Callback callback;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || (callback = this.this$0.mCallback) == null) {
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
                                QueueItem queueItem = (message.arg1 < 0 || message.arg1 >= this.this$0.mQueue.size()) ? null : this.this$0.mQueue.get(message.arg1);
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
                    }
                } finally {
                    this.this$0.setCurrentControllerInfo(null);
                }
            }
        }

        public MediaSessionImplBase(Context context, String str, ComponentName componentName, PendingIntent pendingIntent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str, componentName, pendingIntent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mLock = new Object();
            this.mControllerCallbacks = new RemoteCallbackList<>();
            this.mDestroyed = false;
            this.mIsActive = false;
            this.mIsMbrRegistered = false;
            this.mIsRccRegistered = false;
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
                        int i4 = newInitContext2.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
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
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, volumeProviderCompat) == null) && this.this$0.mVolumeProvider == volumeProviderCompat) {
                        MediaSessionImplBase mediaSessionImplBase = this.this$0;
                        this.this$0.sendVolumeInfoChanged(new ParcelableVolumeInfo(mediaSessionImplBase.mVolumeType, mediaSessionImplBase.mLocalStream, volumeProviderCompat.getVolumeControl(), volumeProviderCompat.getMaxVolume(), volumeProviderCompat.getCurrentVolume()));
                    }
                }
            };
            if (componentName != null) {
                this.mContext = context;
                this.mPackageName = context.getPackageName();
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
            throw new IllegalArgumentException("MediaButtonReceiver component may not be null.");
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
            if (interceptable == null || interceptable.invokeL(65540, this, mediaMetadataCompat) == null) {
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
            if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, list) == null) {
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
            if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, charSequence) == null) {
                for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onQueueTitleChanged(charSequence);
                    } catch (RemoteException unused) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
            }
        }

        private void sendRepeatMode(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(65543, this, i2) == null) {
                for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onRepeatModeChanged(i2);
                    } catch (RemoteException unused) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
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

        private void sendShuffleMode(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(65545, this, i2) == null) {
                for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onShuffleModeChanged(i2);
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

        public void adjustVolume(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                if (this.mVolumeType == 2) {
                    VolumeProviderCompat volumeProviderCompat = this.mVolumeProvider;
                    if (volumeProviderCompat != null) {
                        volumeProviderCompat.onAdjustVolume(i2);
                        return;
                    }
                    return;
                }
                this.mAudioManager.adjustStreamVolume(this.mLocalStream, i2, i3);
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
                if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_ART)) {
                    Bitmap bitmap = (Bitmap) bundle.getParcelable(MediaMetadataCompat.METADATA_KEY_ART);
                    if (bitmap != null) {
                        bitmap = bitmap.copy(bitmap.getConfig(), false);
                    }
                    editMetadata.putBitmap(100, bitmap);
                } else if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_ALBUM_ART)) {
                    Bitmap bitmap2 = (Bitmap) bundle.getParcelable(MediaMetadataCompat.METADATA_KEY_ALBUM_ART);
                    if (bitmap2 != null) {
                        bitmap2 = bitmap2.copy(bitmap2.getConfig(), false);
                    }
                    editMetadata.putBitmap(100, bitmap2);
                }
                if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_ALBUM)) {
                    editMetadata.putString(1, bundle.getString(MediaMetadataCompat.METADATA_KEY_ALBUM));
                }
                if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_ALBUM_ARTIST)) {
                    editMetadata.putString(13, bundle.getString(MediaMetadataCompat.METADATA_KEY_ALBUM_ARTIST));
                }
                if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_ARTIST)) {
                    editMetadata.putString(2, bundle.getString(MediaMetadataCompat.METADATA_KEY_ARTIST));
                }
                if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_AUTHOR)) {
                    editMetadata.putString(3, bundle.getString(MediaMetadataCompat.METADATA_KEY_AUTHOR));
                }
                if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_COMPILATION)) {
                    editMetadata.putString(15, bundle.getString(MediaMetadataCompat.METADATA_KEY_COMPILATION));
                }
                if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_COMPOSER)) {
                    editMetadata.putString(4, bundle.getString(MediaMetadataCompat.METADATA_KEY_COMPOSER));
                }
                if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_DATE)) {
                    editMetadata.putString(5, bundle.getString(MediaMetadataCompat.METADATA_KEY_DATE));
                }
                if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_DISC_NUMBER)) {
                    editMetadata.putLong(14, bundle.getLong(MediaMetadataCompat.METADATA_KEY_DISC_NUMBER));
                }
                if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_DURATION)) {
                    editMetadata.putLong(9, bundle.getLong(MediaMetadataCompat.METADATA_KEY_DURATION));
                }
                if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_GENRE)) {
                    editMetadata.putString(6, bundle.getString(MediaMetadataCompat.METADATA_KEY_GENRE));
                }
                if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_TITLE)) {
                    editMetadata.putString(7, bundle.getString(MediaMetadataCompat.METADATA_KEY_TITLE));
                }
                if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_TRACK_NUMBER)) {
                    editMetadata.putLong(0, bundle.getLong(MediaMetadataCompat.METADATA_KEY_TRACK_NUMBER));
                }
                if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_WRITER)) {
                    editMetadata.putString(11, bundle.getString(MediaMetadataCompat.METADATA_KEY_WRITER));
                }
                return editMetadata;
            }
            return (RemoteControlClient.MetadataEditor) invokeL.objValue;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public String getCallingPackage() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public MediaSessionManager.RemoteUserInfo getCurrentControllerInfo() {
            InterceptResult invokeV;
            MediaSessionManager.RemoteUserInfo remoteUserInfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
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
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return null;
            }
            return invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public PlaybackStateCompat getPlaybackState() {
            InterceptResult invokeV;
            PlaybackStateCompat playbackStateCompat;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                synchronized (this.mLock) {
                    playbackStateCompat = this.mState;
                }
                return playbackStateCompat;
            }
            return (PlaybackStateCompat) invokeV.objValue;
        }

        public int getRccStateFromState(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
                switch (i2) {
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
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j)) == null) {
                int i2 = (1 & j) != 0 ? 32 : 0;
                if ((2 & j) != 0) {
                    i2 |= 16;
                }
                if ((4 & j) != 0) {
                    i2 |= 4;
                }
                if ((8 & j) != 0) {
                    i2 |= 2;
                }
                if ((16 & j) != 0) {
                    i2 |= 1;
                }
                if ((32 & j) != 0) {
                    i2 |= 128;
                }
                if ((64 & j) != 0) {
                    i2 |= 64;
                }
                return (j & 512) != 0 ? i2 | 8 : i2;
            }
            return invokeJ.intValue;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public Object getRemoteControlClient() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return null;
            }
            return invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public Token getSessionToken() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mToken : (Token) invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public boolean isActive() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mIsActive : invokeV.booleanValue;
        }

        public void postToHandler(int i2, int i3, int i4, Object obj, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), obj, bundle}) == null) {
                synchronized (this.mLock) {
                    if (this.mHandler != null) {
                        Message obtainMessage = this.mHandler.obtainMessage(i2, i3, i4, obj);
                        Bundle bundle2 = new Bundle();
                        bundle2.putString(MediaSessionCompat.DATA_CALLING_PACKAGE, MediaSessionManager.RemoteUserInfo.LEGACY_CONTROLLER);
                        bundle2.putInt("data_calling_pid", Binder.getCallingPid());
                        bundle2.putInt("data_calling_uid", Binder.getCallingUid());
                        if (bundle != null) {
                            bundle2.putBundle(MediaSessionCompat.DATA_EXTRAS, bundle);
                        }
                        obtainMessage.setData(bundle2);
                        obtainMessage.sendToTarget();
                    }
                }
            }
        }

        public void registerMediaButtonEventReceiver(PendingIntent pendingIntent, ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048588, this, pendingIntent, componentName) == null) {
                this.mAudioManager.registerMediaButtonEventReceiver(componentName);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void release() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
                this.mIsActive = false;
                this.mDestroyed = true;
                update();
                sendSessionDestroyed();
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void sendSessionEvent(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048590, this, str, bundle) == null) {
                sendEvent(str, bundle);
            }
        }

        public void sendVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, parcelableVolumeInfo) == null) {
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
            if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || z == this.mIsActive) {
                return;
            }
            this.mIsActive = z;
            if (update()) {
                setMetadata(this.mMetadata);
                setPlaybackState(this.mState);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCallback(Callback callback, Handler handler) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048593, this, callback, handler) == null) {
                this.mCallback = callback;
                if (callback != null) {
                    if (handler == null) {
                        handler = new Handler();
                    }
                    synchronized (this.mLock) {
                        if (this.mHandler != null) {
                            this.mHandler.removeCallbacksAndMessages(null);
                        }
                        this.mHandler = new MessageHandler(this, handler.getLooper());
                        this.mCallback.setSessionImpl(this, handler);
                    }
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCaptioningEnabled(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048594, this, z) == null) || this.mCaptioningEnabled == z) {
                return;
            }
            this.mCaptioningEnabled = z;
            sendCaptioningEnabled(z);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCurrentControllerInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048595, this, remoteUserInfo) == null) {
                synchronized (this.mLock) {
                    this.mRemoteUserInfo = remoteUserInfo;
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setExtras(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048596, this, bundle) == null) {
                this.mExtras = bundle;
                sendExtras(bundle);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setFlags(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
                synchronized (this.mLock) {
                    this.mFlags = i2;
                }
                update();
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setMediaButtonReceiver(PendingIntent pendingIntent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048598, this, pendingIntent) == null) {
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setMetadata(MediaMetadataCompat mediaMetadataCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048599, this, mediaMetadataCompat) == null) {
                if (mediaMetadataCompat != null) {
                    mediaMetadataCompat = new MediaMetadataCompat.Builder(mediaMetadataCompat, MediaSessionCompat.sMaxBitmapSize).build();
                }
                synchronized (this.mLock) {
                    this.mMetadata = mediaMetadataCompat;
                }
                sendMetadata(mediaMetadataCompat);
                if (this.mIsActive) {
                    buildRccMetadata(mediaMetadataCompat == null ? null : mediaMetadataCompat.getBundle()).apply();
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackState(PlaybackStateCompat playbackStateCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048600, this, playbackStateCompat) == null) {
                synchronized (this.mLock) {
                    this.mState = playbackStateCompat;
                }
                sendState(playbackStateCompat);
                if (this.mIsActive) {
                    if (playbackStateCompat == null) {
                        this.mRcc.setPlaybackState(0);
                        this.mRcc.setTransportControlFlags(0);
                        return;
                    }
                    setRccState(playbackStateCompat);
                    this.mRcc.setTransportControlFlags(getRccTransportControlFlagsFromActions(playbackStateCompat.getActions()));
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackToLocal(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
                VolumeProviderCompat volumeProviderCompat = this.mVolumeProvider;
                if (volumeProviderCompat != null) {
                    volumeProviderCompat.setCallback(null);
                }
                this.mLocalStream = i2;
                this.mVolumeType = 1;
                int i3 = this.mVolumeType;
                int i4 = this.mLocalStream;
                sendVolumeInfoChanged(new ParcelableVolumeInfo(i3, i4, 2, this.mAudioManager.getStreamMaxVolume(i4), this.mAudioManager.getStreamVolume(this.mLocalStream)));
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048602, this, volumeProviderCompat) == null) {
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

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setQueue(List<QueueItem> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048603, this, list) == null) {
                this.mQueue = list;
                sendQueue(list);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setQueueTitle(CharSequence charSequence) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048604, this, charSequence) == null) {
                this.mQueueTitle = charSequence;
                sendQueueTitle(charSequence);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setRatingType(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
                this.mRatingType = i2;
            }
        }

        public void setRccState(PlaybackStateCompat playbackStateCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048606, this, playbackStateCompat) == null) {
                this.mRcc.setPlaybackState(getRccStateFromState(playbackStateCompat.getState()));
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setRepeatMode(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048607, this, i2) == null) || this.mRepeatMode == i2) {
                return;
            }
            this.mRepeatMode = i2;
            sendRepeatMode(i2);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setSessionActivity(PendingIntent pendingIntent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048608, this, pendingIntent) == null) {
                synchronized (this.mLock) {
                    this.mSessionActivity = pendingIntent;
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setShuffleMode(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048609, this, i2) == null) || this.mShuffleMode == i2) {
                return;
            }
            this.mShuffleMode = i2;
            sendShuffleMode(i2);
        }

        public void setVolumeTo(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048610, this, i2, i3) == null) {
                if (this.mVolumeType == 2) {
                    VolumeProviderCompat volumeProviderCompat = this.mVolumeProvider;
                    if (volumeProviderCompat != null) {
                        volumeProviderCompat.onSetVolumeTo(i2);
                        return;
                    }
                    return;
                }
                this.mAudioManager.setStreamVolume(this.mLocalStream, i2, i3);
            }
        }

        public void unregisterMediaButtonEventReceiver(PendingIntent pendingIntent, ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048611, this, pendingIntent, componentName) == null) {
                this.mAudioManager.unregisterMediaButtonEventReceiver(componentName);
            }
        }

        public boolean update() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
                if (this.mIsActive) {
                    if (!this.mIsMbrRegistered && (this.mFlags & 1) != 0) {
                        registerMediaButtonEventReceiver(this.mMediaButtonReceiverIntent, this.mMediaButtonReceiverComponentName);
                        this.mIsMbrRegistered = true;
                    } else if (this.mIsMbrRegistered && (this.mFlags & 1) == 0) {
                        unregisterMediaButtonEventReceiver(this.mMediaButtonReceiverIntent, this.mMediaButtonReceiverComponentName);
                        this.mIsMbrRegistered = false;
                    }
                    if (!this.mIsRccRegistered && (this.mFlags & 2) != 0) {
                        this.mAudioManager.registerRemoteControlClient(this.mRcc);
                        this.mIsRccRegistered = true;
                        return true;
                    } else if (this.mIsRccRegistered && (this.mFlags & 2) == 0) {
                        this.mRcc.setPlaybackState(0);
                        this.mAudioManager.unregisterRemoteControlClient(this.mRcc);
                        this.mIsRccRegistered = false;
                    }
                } else {
                    if (this.mIsMbrRegistered) {
                        unregisterMediaButtonEventReceiver(this.mMediaButtonReceiverIntent, this.mMediaButtonReceiverComponentName);
                        this.mIsMbrRegistered = false;
                    }
                    if (this.mIsRccRegistered) {
                        this.mRcc.setPlaybackState(0);
                        this.mAudioManager.unregisterRemoteControlClient(this.mRcc);
                        this.mIsRccRegistered = false;
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public interface OnActiveChangeListener {
        void onActiveChanged();
    }

    /* loaded from: classes.dex */
    public static final class QueueItem implements Parcelable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final Parcelable.Creator<QueueItem> CREATOR;
        public static final int UNKNOWN_ID = -1;
        public transient /* synthetic */ FieldHolder $fh;
        public final MediaDescriptionCompat mDescription;
        public final long mId;
        public Object mItem;

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
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
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
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new QueueItem(parcel) : (QueueItem) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public QueueItem[] newArray(int i2) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new QueueItem[i2] : (QueueItem[]) invokeI.objValue;
                }
            };
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public QueueItem(MediaDescriptionCompat mediaDescriptionCompat, long j) {
            this(null, mediaDescriptionCompat, j);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaDescriptionCompat, Long.valueOf(j)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this(objArr2[0], (MediaDescriptionCompat) objArr2[1], ((Long) objArr2[2]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
        }

        public static QueueItem fromQueueItem(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, obj)) == null) {
                if (obj == null || Build.VERSION.SDK_INT < 21) {
                    return null;
                }
                return new QueueItem(obj, MediaDescriptionCompat.fromMediaDescription(MediaSessionCompatApi21.QueueItem.getDescription(obj)), MediaSessionCompatApi21.QueueItem.getQueueId(obj));
            }
            return (QueueItem) invokeL.objValue;
        }

        public static List<QueueItem> fromQueueItemList(List<?> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, list)) == null) {
                if (list == null || Build.VERSION.SDK_INT < 21) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<?> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(fromQueueItem(it.next()));
                }
                return arrayList;
            }
            return (List) invokeL.objValue;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        public MediaDescriptionCompat getDescription() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mDescription : (MediaDescriptionCompat) invokeV.objValue;
        }

        public long getQueueId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mId : invokeV.longValue;
        }

        public Object getQueueItem() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.mItem == null && Build.VERSION.SDK_INT >= 21) {
                    Object createItem = MediaSessionCompatApi21.QueueItem.createItem(this.mDescription.getMediaDescription(), this.mId);
                    this.mItem = createItem;
                    return createItem;
                }
                return this.mItem;
            }
            return invokeV.objValue;
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
        public void writeToParcel(Parcel parcel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048581, this, parcel, i2) == null) {
                this.mDescription.writeToParcel(parcel, i2);
                parcel.writeLong(this.mId);
            }
        }

        public QueueItem(Object obj, MediaDescriptionCompat mediaDescriptionCompat, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj, mediaDescriptionCompat, Long.valueOf(j)};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("Description cannot be null.");
            }
            if (j != -1) {
                this.mDescription = mediaDescriptionCompat;
                this.mId = j;
                this.mItem = obj;
                return;
            }
            throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
        }

        public QueueItem(Parcel parcel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mDescription = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.mId = parcel.readLong();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes.dex */
    public @interface SessionFlags {
    }

    /* loaded from: classes.dex */
    public static final class Token implements Parcelable {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<Token> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public IMediaSession mExtraBinder;
        public final Object mInner;
        public Bundle mSessionToken2Bundle;

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
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
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
                public Token[] newArray(int i2) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new Token[i2] : (Token[]) invokeI.objValue;
                }
            };
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this(objArr2[0], (IMediaSession) objArr2[1], (Bundle) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static Token fromBundle(Bundle bundle) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, bundle)) == null) {
                if (bundle == null) {
                    return null;
                }
                IMediaSession asInterface = IMediaSession.Stub.asInterface(BundleCompat.getBinder(bundle, MediaSessionCompat.KEY_EXTRA_BINDER));
                Bundle bundle2 = bundle.getBundle(MediaSessionCompat.KEY_SESSION_TOKEN2_BUNDLE);
                Token token = (Token) bundle.getParcelable(MediaSessionCompat.KEY_TOKEN);
                if (token == null) {
                    return null;
                }
                return new Token(token.mInner, asInterface, bundle2);
            }
            return (Token) invokeL.objValue;
        }

        public static Token fromToken(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, obj)) == null) ? fromToken(obj, null) : (Token) invokeL.objValue;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Token) {
                    Token token = (Token) obj;
                    Object obj2 = this.mInner;
                    if (obj2 == null) {
                        return token.mInner == null;
                    }
                    Object obj3 = token.mInner;
                    if (obj3 == null) {
                        return false;
                    }
                    return obj2.equals(obj3);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public IMediaSession getExtraBinder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mExtraBinder : (IMediaSession) invokeV.objValue;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Bundle getSessionToken2Bundle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mSessionToken2Bundle : (Bundle) invokeV.objValue;
        }

        public Object getToken() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mInner : invokeV.objValue;
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

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public void setExtraBinder(IMediaSession iMediaSession) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, iMediaSession) == null) {
                this.mExtraBinder = iMediaSession;
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public void setSessionToken2Bundle(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
                this.mSessionToken2Bundle = bundle;
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Bundle toBundle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(MediaSessionCompat.KEY_TOKEN, this);
                IMediaSession iMediaSession = this.mExtraBinder;
                if (iMediaSession != null) {
                    BundleCompat.putBinder(bundle, MediaSessionCompat.KEY_EXTRA_BINDER, iMediaSession.asBinder());
                }
                Bundle bundle2 = this.mSessionToken2Bundle;
                if (bundle2 != null) {
                    bundle.putBundle(MediaSessionCompat.KEY_SESSION_TOKEN2_BUNDLE, bundle2);
                }
                return bundle;
            }
            return (Bundle) invokeV.objValue;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048585, this, parcel, i2) == null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    parcel.writeParcelable((Parcelable) this.mInner, i2);
                } else {
                    parcel.writeStrongBinder((IBinder) this.mInner);
                }
            }
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this(objArr2[0], (IMediaSession) objArr2[1], (Bundle) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static Token fromToken(Object obj, IMediaSession iMediaSession) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, obj, iMediaSession)) == null) {
                if (obj == null || Build.VERSION.SDK_INT < 21) {
                    return null;
                }
                return new Token(MediaSessionCompatApi21.verifyToken(obj), iMediaSession);
            }
            return (Token) invokeLL.objValue;
        }

        public Token(Object obj, IMediaSession iMediaSession, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj, iMediaSession, bundle};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.mInner = obj;
            this.mExtraBinder = iMediaSession;
            this.mSessionToken2Bundle = bundle;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MediaSessionCompat(Context context, String str) {
        this(context, str, null, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1], (ComponentName) objArr2[2], (PendingIntent) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void ensureClassLoader(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, bundle) == null) || bundle == null) {
            return;
        }
        bundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
    }

    public static MediaSessionCompat fromMediaSession(Context context, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, context, obj)) == null) {
            if (context == null || obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            return new MediaSessionCompat(context, new MediaSessionImplApi21(obj));
        }
        return (MediaSessionCompat) invokeLL.objValue;
    }

    public static PlaybackStateCompat getStateWithUpdatedPosition(PlaybackStateCompat playbackStateCompat, MediaMetadataCompat mediaMetadataCompat) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, playbackStateCompat, mediaMetadataCompat)) == null) {
            if (playbackStateCompat != null) {
                long j = -1;
                if (playbackStateCompat.getPosition() == -1) {
                    return playbackStateCompat;
                }
                if (playbackStateCompat.getState() == 3 || playbackStateCompat.getState() == 4 || playbackStateCompat.getState() == 5) {
                    long lastPositionUpdateTime = playbackStateCompat.getLastPositionUpdateTime();
                    if (lastPositionUpdateTime > 0) {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        long playbackSpeed = (playbackStateCompat.getPlaybackSpeed() * ((float) (elapsedRealtime - lastPositionUpdateTime))) + playbackStateCompat.getPosition();
                        if (mediaMetadataCompat != null && mediaMetadataCompat.containsKey(MediaMetadataCompat.METADATA_KEY_DURATION)) {
                            j = mediaMetadataCompat.getLong(MediaMetadataCompat.METADATA_KEY_DURATION);
                        }
                        return new PlaybackStateCompat.Builder(playbackStateCompat).setState(playbackStateCompat.getState(), (j < 0 || playbackSpeed <= j) ? playbackSpeed < 0 ? 0L : playbackSpeed : j, playbackStateCompat.getPlaybackSpeed(), elapsedRealtime).build();
                    }
                    return playbackStateCompat;
                }
                return playbackStateCompat;
            }
            return playbackStateCompat;
        }
        return (PlaybackStateCompat) invokeLL.objValue;
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

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public String getCallingPackage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mImpl.getCallingPackage() : (String) invokeV.objValue;
    }

    public MediaControllerCompat getController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mController : (MediaControllerCompat) invokeV.objValue;
    }

    @NonNull
    public final MediaSessionManager.RemoteUserInfo getCurrentControllerInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mImpl.getCurrentControllerInfo() : (MediaSessionManager.RemoteUserInfo) invokeV.objValue;
    }

    public Object getMediaSession() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mImpl.getMediaSession() : invokeV.objValue;
    }

    public Object getRemoteControlClient() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mImpl.getRemoteControlClient() : invokeV.objValue;
    }

    public Token getSessionToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mImpl.getSessionToken() : (Token) invokeV.objValue;
    }

    public boolean isActive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mImpl.isActive() : invokeV.booleanValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.mImpl.release();
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

    public void setFlags(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.mImpl.setFlags(i2);
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

    public void setPlaybackToLocal(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.mImpl.setPlaybackToLocal(i2);
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

    public void setRatingType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.mImpl.setRatingType(i2);
        }
    }

    public void setRepeatMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.mImpl.setRepeatMode(i2);
        }
    }

    public void setSessionActivity(PendingIntent pendingIntent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, pendingIntent) == null) {
            this.mImpl.setSessionActivity(pendingIntent);
        }
    }

    public void setShuffleMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            this.mImpl.setShuffleMode(i2);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public static final class ResultReceiverWrapper implements Parcelable {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public ResultReceiver mResultReceiver;

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
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
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
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new ResultReceiverWrapper(parcel) : (ResultReceiverWrapper) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public ResultReceiverWrapper[] newArray(int i2) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new ResultReceiverWrapper[i2] : (ResultReceiverWrapper[]) invokeI.objValue;
                }
            };
        }

        public ResultReceiverWrapper(ResultReceiver resultReceiver) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {resultReceiver};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.mResultReceiver = resultReceiver;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, i2) == null) {
                this.mResultReceiver.writeToParcel(parcel, i2);
            }
        }

        public ResultReceiverWrapper(Parcel parcel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mResultReceiver = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MediaSessionCompat(Context context, String str, ComponentName componentName, PendingIntent pendingIntent) {
        this(context, str, componentName, pendingIntent, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, componentName, pendingIntent};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1], (ComponentName) objArr2[2], (PendingIntent) objArr2[3], (Bundle) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public MediaSessionCompat(Context context, String str, Bundle bundle) {
        this(context, str, null, null, bundle);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, bundle};
            interceptable.invokeUnInit(65540, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1], (ComponentName) objArr2[2], (PendingIntent) objArr2[3], (Bundle) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65540, newInitContext);
                return;
            }
        }
    }

    public MediaSessionCompat(Context context, String str, ComponentName componentName, PendingIntent pendingIntent, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, componentName, pendingIntent, bundle};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mActiveListeners = new ArrayList<>();
        if (context != null) {
            if (!TextUtils.isEmpty(str)) {
                if (componentName == null && (componentName = MediaButtonReceiver.getMediaButtonReceiverComponent(context)) == null) {
                    Log.w(TAG, "Couldn't find a unique registered media button receiver in the given context.");
                }
                if (componentName != null && pendingIntent == null) {
                    Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
                    intent.setComponent(componentName);
                    pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
                }
                int i4 = Build.VERSION.SDK_INT;
                if (i4 >= 28) {
                    this.mImpl = new MediaSessionImplApi28(context, str, bundle);
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
                    });
                    this.mImpl.setMediaButtonReceiver(pendingIntent);
                } else if (i4 >= 21) {
                    this.mImpl = new MediaSessionImplApi21(context, str, bundle);
                    setCallback(new Callback(this) { // from class: android.support.v4.media.session.MediaSessionCompat.2
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
                    });
                    this.mImpl.setMediaButtonReceiver(pendingIntent);
                } else if (i4 >= 19) {
                    this.mImpl = new MediaSessionImplApi19(context, str, componentName, pendingIntent);
                } else if (i4 >= 18) {
                    this.mImpl = new MediaSessionImplApi18(context, str, componentName, pendingIntent);
                } else {
                    this.mImpl = new MediaSessionImplBase(context, str, componentName, pendingIntent);
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
    /* loaded from: classes.dex */
    public static class MediaSessionImplApi21 implements MediaSessionImpl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mCaptioningEnabled;
        public boolean mDestroyed;
        public final RemoteCallbackList<IMediaControllerCallback> mExtraControllerCallbacks;
        public MediaMetadataCompat mMetadata;
        public PlaybackStateCompat mPlaybackState;
        public List<QueueItem> mQueue;
        public int mRatingType;
        public int mRepeatMode;
        public final Object mSessionObj;
        public int mShuffleMode;
        public final Token mToken;

        /* loaded from: classes.dex */
        public class ExtraSession extends IMediaSession.Stub {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaSessionImplApi21 this$0;

            public ExtraSession(MediaSessionImplApi21 mediaSessionImplApi21) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mediaSessionImplApi21};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
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
            public void addQueueItemAt(MediaDescriptionCompat mediaDescriptionCompat, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaDescriptionCompat, i2) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void adjustVolume(int i2, int i3, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, str) == null) {
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
            public List<QueueItem> getQueue() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                    return null;
                }
                return (List) invokeV.objValue;
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
                return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.this$0.mRatingType : invokeV.intValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getRepeatMode() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.this$0.mRepeatMode : invokeV.intValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getShuffleMode() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.this$0.mShuffleMode : invokeV.intValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public String getTag() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                    throw new AssertionError();
                }
                return (String) invokeV.objValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public ParcelableVolumeInfo getVolumeAttributes() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                    throw new AssertionError();
                }
                return (ParcelableVolumeInfo) invokeV.objValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isCaptioningEnabled() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.this$0.mCaptioningEnabled : invokeV.booleanValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isShuffleModeEnabledRemoved() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isTransportControlEnabled() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                    throw new AssertionError();
                }
                return invokeV.booleanValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void next() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void pause() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void play() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromMediaId(String str, Bundle bundle) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048599, this, str, bundle) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromSearch(String str, Bundle bundle) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048600, this, str, bundle) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromUri(Uri uri, Bundle bundle) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048601, this, uri, bundle) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepare() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromMediaId(String str, Bundle bundle) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048603, this, str, bundle) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromSearch(String str, Bundle bundle) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048604, this, str, bundle) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromUri(Uri uri, Bundle bundle) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048605, this, uri, bundle) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void previous() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rate(RatingCompat ratingCompat) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048607, this, ratingCompat) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rateWithExtras(RatingCompat ratingCompat, Bundle bundle) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048608, this, ratingCompat, bundle) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void registerCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048609, this, iMediaControllerCallback) == null) {
                    MediaSessionImplApi21 mediaSessionImplApi21 = this.this$0;
                    if (mediaSessionImplApi21.mDestroyed) {
                        return;
                    }
                    String callingPackage = mediaSessionImplApi21.getCallingPackage();
                    if (callingPackage == null) {
                        callingPackage = MediaSessionManager.RemoteUserInfo.LEGACY_CONTROLLER;
                    }
                    this.this$0.mExtraControllerCallbacks.register(iMediaControllerCallback, new MediaSessionManager.RemoteUserInfo(callingPackage, Binder.getCallingPid(), Binder.getCallingUid()));
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048610, this, mediaDescriptionCompat) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItemAt(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rewind() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void seekTo(long j) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeJ(1048613, this, j) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCommand(String str, Bundle bundle, ResultReceiverWrapper resultReceiverWrapper) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLL(1048614, this, str, bundle, resultReceiverWrapper) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCustomAction(String str, Bundle bundle) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048615, this, str, bundle) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean sendMediaButton(KeyEvent keyEvent) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, keyEvent)) == null) {
                    throw new AssertionError();
                }
                return invokeL.booleanValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setCaptioningEnabled(boolean z) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setRepeatMode(int i2) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleMode(int i2) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048619, this, i2) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleModeEnabledRemoved(boolean z) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setVolumeTo(int i2, int i3, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIIL(1048621, this, i2, i3, str) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void skipToQueueItem(long j) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeJ(1048622, this, j) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void stop() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void unregisterCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048624, this, iMediaControllerCallback) == null) {
                    this.this$0.mExtraControllerCallbacks.unregister(iMediaControllerCallback);
                }
            }
        }

        public MediaSessionImplApi21(Context context, String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mDestroyed = false;
            this.mExtraControllerCallbacks = new RemoteCallbackList<>();
            this.mSessionObj = MediaSessionCompatApi21.createSession(context, str);
            this.mToken = new Token(MediaSessionCompatApi21.getSessionToken(this.mSessionObj), new ExtraSession(this), bundle);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public String getCallingPackage() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (Build.VERSION.SDK_INT < 24) {
                    return null;
                }
                return MediaSessionCompatApi24.getCallingPackage(this.mSessionObj);
            }
            return (String) invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public MediaSessionManager.RemoteUserInfo getCurrentControllerInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return null;
            }
            return (MediaSessionManager.RemoteUserInfo) invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public Object getMediaSession() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mSessionObj : invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public PlaybackStateCompat getPlaybackState() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mPlaybackState : (PlaybackStateCompat) invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public Object getRemoteControlClient() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return null;
            }
            return invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public Token getSessionToken() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mToken : (Token) invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public boolean isActive() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? MediaSessionCompatApi21.isActive(this.mSessionObj) : invokeV.booleanValue;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void release() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.mDestroyed = true;
                MediaSessionCompatApi21.release(this.mSessionObj);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void sendSessionEvent(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, bundle) == null) {
                if (Build.VERSION.SDK_INT < 23) {
                    for (int beginBroadcast = this.mExtraControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                        try {
                            this.mExtraControllerCallbacks.getBroadcastItem(beginBroadcast).onEvent(str, bundle);
                        } catch (RemoteException unused) {
                        }
                    }
                    this.mExtraControllerCallbacks.finishBroadcast();
                }
                MediaSessionCompatApi21.sendSessionEvent(this.mSessionObj, str, bundle);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setActive(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
                MediaSessionCompatApi21.setActive(this.mSessionObj, z);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCallback(Callback callback, Handler handler) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048586, this, callback, handler) == null) {
                MediaSessionCompatApi21.setCallback(this.mSessionObj, callback == null ? null : callback.mCallbackObj, handler);
                if (callback != null) {
                    callback.setSessionImpl(this, handler);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCaptioningEnabled(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || this.mCaptioningEnabled == z) {
                return;
            }
            this.mCaptioningEnabled = z;
            for (int beginBroadcast = this.mExtraControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.mExtraControllerCallbacks.getBroadcastItem(beginBroadcast).onCaptioningEnabledChanged(z);
                } catch (RemoteException unused) {
                }
            }
            this.mExtraControllerCallbacks.finishBroadcast();
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCurrentControllerInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, remoteUserInfo) == null) {
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setExtras(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
                MediaSessionCompatApi21.setExtras(this.mSessionObj, bundle);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setFlags(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
                MediaSessionCompatApi21.setFlags(this.mSessionObj, i2);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setMediaButtonReceiver(PendingIntent pendingIntent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, pendingIntent) == null) {
                MediaSessionCompatApi21.setMediaButtonReceiver(this.mSessionObj, pendingIntent);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setMetadata(MediaMetadataCompat mediaMetadataCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, mediaMetadataCompat) == null) {
                this.mMetadata = mediaMetadataCompat;
                MediaSessionCompatApi21.setMetadata(this.mSessionObj, mediaMetadataCompat == null ? null : mediaMetadataCompat.getMediaMetadata());
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackState(PlaybackStateCompat playbackStateCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, playbackStateCompat) == null) {
                this.mPlaybackState = playbackStateCompat;
                for (int beginBroadcast = this.mExtraControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.mExtraControllerCallbacks.getBroadcastItem(beginBroadcast).onPlaybackStateChanged(playbackStateCompat);
                    } catch (RemoteException unused) {
                    }
                }
                this.mExtraControllerCallbacks.finishBroadcast();
                MediaSessionCompatApi21.setPlaybackState(this.mSessionObj, playbackStateCompat == null ? null : playbackStateCompat.getPlaybackState());
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackToLocal(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
                MediaSessionCompatApi21.setPlaybackToLocal(this.mSessionObj, i2);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048595, this, volumeProviderCompat) == null) {
                MediaSessionCompatApi21.setPlaybackToRemote(this.mSessionObj, volumeProviderCompat.getVolumeProvider());
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setQueue(List<QueueItem> list) {
            ArrayList arrayList;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048596, this, list) == null) {
                this.mQueue = list;
                if (list != null) {
                    arrayList = new ArrayList();
                    for (QueueItem queueItem : list) {
                        arrayList.add(queueItem.getQueueItem());
                    }
                } else {
                    arrayList = null;
                }
                MediaSessionCompatApi21.setQueue(this.mSessionObj, arrayList);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setQueueTitle(CharSequence charSequence) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048597, this, charSequence) == null) {
                MediaSessionCompatApi21.setQueueTitle(this.mSessionObj, charSequence);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setRatingType(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
                if (Build.VERSION.SDK_INT < 22) {
                    this.mRatingType = i2;
                } else {
                    MediaSessionCompatApi22.setRatingType(this.mSessionObj, i2);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setRepeatMode(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048599, this, i2) == null) || this.mRepeatMode == i2) {
                return;
            }
            this.mRepeatMode = i2;
            for (int beginBroadcast = this.mExtraControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.mExtraControllerCallbacks.getBroadcastItem(beginBroadcast).onRepeatModeChanged(i2);
                } catch (RemoteException unused) {
                }
            }
            this.mExtraControllerCallbacks.finishBroadcast();
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setSessionActivity(PendingIntent pendingIntent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048600, this, pendingIntent) == null) {
                MediaSessionCompatApi21.setSessionActivity(this.mSessionObj, pendingIntent);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setShuffleMode(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048601, this, i2) == null) || this.mShuffleMode == i2) {
                return;
            }
            this.mShuffleMode = i2;
            for (int beginBroadcast = this.mExtraControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.mExtraControllerCallbacks.getBroadcastItem(beginBroadcast).onShuffleModeChanged(i2);
                } catch (RemoteException unused) {
                }
            }
            this.mExtraControllerCallbacks.finishBroadcast();
        }

        public MediaSessionImplApi21(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mDestroyed = false;
            this.mExtraControllerCallbacks = new RemoteCallbackList<>();
            this.mSessionObj = MediaSessionCompatApi21.verifySession(obj);
            this.mToken = new Token(MediaSessionCompatApi21.getSessionToken(this.mSessionObj), new ExtraSession(this));
        }
    }

    public MediaSessionCompat(Context context, MediaSessionImpl mediaSessionImpl) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mediaSessionImpl};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mActiveListeners = new ArrayList<>();
        this.mImpl = mediaSessionImpl;
        if (Build.VERSION.SDK_INT >= 21 && !MediaSessionCompatApi21.hasCallback(mediaSessionImpl.getMediaSession())) {
            setCallback(new Callback(this) { // from class: android.support.v4.media.session.MediaSessionCompat.3
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
                        int i4 = newInitContext2.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.this$0 = this;
                }
            });
        }
        this.mController = new MediaControllerCompat(context, this);
    }
}
