package android.support.v4.media.session;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.app.BundleCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.media.AudioAttributesCompat;
import androidx.versionedparcelable.ParcelUtils;
import androidx.versionedparcelable.VersionedParcelable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public final class MediaControllerCompat {
    public static /* synthetic */ Interceptable $ic = null;
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String COMMAND_ADD_QUEUE_ITEM = "android.support.v4.media.session.command.ADD_QUEUE_ITEM";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String COMMAND_ADD_QUEUE_ITEM_AT = "android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String COMMAND_ARGUMENT_INDEX = "android.support.v4.media.session.command.ARGUMENT_INDEX";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String COMMAND_ARGUMENT_MEDIA_DESCRIPTION = "android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String COMMAND_GET_EXTRA_BINDER = "android.support.v4.media.session.command.GET_EXTRA_BINDER";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String COMMAND_REMOVE_QUEUE_ITEM = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String COMMAND_REMOVE_QUEUE_ITEM_AT = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT";
    public static final String TAG = "MediaControllerCompat";
    public transient /* synthetic */ FieldHolder $fh;
    public final MediaControllerImpl mImpl;
    public final ConcurrentHashMap<Callback, Boolean> mRegisteredCallbacks;
    public final MediaSessionCompat.Token mToken;

    /* loaded from: classes.dex */
    public interface MediaControllerImpl {
        void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat);

        void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i);

        void adjustVolume(int i, int i2);

        boolean dispatchMediaButtonEvent(KeyEvent keyEvent);

        Bundle getExtras();

        long getFlags();

        Object getMediaController();

        MediaMetadataCompat getMetadata();

        String getPackageName();

        PlaybackInfo getPlaybackInfo();

        PlaybackStateCompat getPlaybackState();

        List<MediaSessionCompat.QueueItem> getQueue();

        CharSequence getQueueTitle();

        int getRatingType();

        int getRepeatMode();

        PendingIntent getSessionActivity();

        Bundle getSessionInfo();

        int getShuffleMode();

        TransportControls getTransportControls();

        boolean isCaptioningEnabled();

        boolean isSessionReady();

        void registerCallback(Callback callback, Handler handler);

        void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat);

        void sendCommand(String str, Bundle bundle, ResultReceiver resultReceiver);

        void setVolumeTo(int i, int i2);

        void unregisterCallback(Callback callback);
    }

    /* loaded from: classes.dex */
    public static abstract class Callback implements IBinder.DeathRecipient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final MediaController.Callback mCallbackFwk;
        public MessageHandler mHandler;
        public IMediaControllerCallback mIControllerCallback;

        public void onAudioInfoChanged(PlaybackInfo playbackInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, playbackInfo) == null) {
            }
        }

        public void onCaptioningEnabledChanged(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            }
        }

        public void onExtrasChanged(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            }
        }

        public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, mediaMetadataCompat) == null) {
            }
        }

        public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, playbackStateCompat) == null) {
            }
        }

        public void onQueueChanged(List<MediaSessionCompat.QueueItem> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            }
        }

        public void onQueueTitleChanged(CharSequence charSequence) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, charSequence) == null) {
            }
        }

        public void onRepeatModeChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            }
        }

        public void onSessionDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            }
        }

        public void onSessionEvent(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, str, bundle) == null) {
            }
        }

        public void onSessionReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            }
        }

        public void onShuffleModeChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            }
        }

        @RequiresApi(21)
        /* loaded from: classes.dex */
        public static class MediaControllerCallbackApi21 extends MediaController.Callback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final WeakReference<Callback> mCallback;

            public MediaControllerCallbackApi21(Callback callback) {
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
                this.mCallback = new WeakReference<>(callback);
            }

            @Override // android.media.session.MediaController.Callback
            public void onAudioInfoChanged(MediaController.PlaybackInfo playbackInfo) {
                Callback callback;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, playbackInfo) == null) && (callback = this.mCallback.get()) != null) {
                    callback.onAudioInfoChanged(new PlaybackInfo(playbackInfo.getPlaybackType(), AudioAttributesCompat.wrap(playbackInfo.getAudioAttributes()), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume()));
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onExtrasChanged(Bundle bundle) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
                    MediaSessionCompat.ensureClassLoader(bundle);
                    Callback callback = this.mCallback.get();
                    if (callback != null) {
                        callback.onExtrasChanged(bundle);
                    }
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onMetadataChanged(MediaMetadata mediaMetadata) {
                Callback callback;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mediaMetadata) == null) && (callback = this.mCallback.get()) != null) {
                    callback.onMetadataChanged(MediaMetadataCompat.fromMediaMetadata(mediaMetadata));
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onPlaybackStateChanged(PlaybackState playbackState) {
                Callback callback;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048579, this, playbackState) == null) && (callback = this.mCallback.get()) != null && callback.mIControllerCallback == null) {
                    callback.onPlaybackStateChanged(PlaybackStateCompat.fromPlaybackState(playbackState));
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onQueueChanged(List<MediaSession.QueueItem> list) {
                Callback callback;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048580, this, list) == null) && (callback = this.mCallback.get()) != null) {
                    callback.onQueueChanged(MediaSessionCompat.QueueItem.fromQueueItemList(list));
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onQueueTitleChanged(CharSequence charSequence) {
                Callback callback;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048581, this, charSequence) == null) && (callback = this.mCallback.get()) != null) {
                    callback.onQueueTitleChanged(charSequence);
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onSessionDestroyed() {
                Callback callback;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (callback = this.mCallback.get()) != null) {
                    callback.onSessionDestroyed();
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onSessionEvent(String str, Bundle bundle) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048583, this, str, bundle) == null) {
                    MediaSessionCompat.ensureClassLoader(bundle);
                    Callback callback = this.mCallback.get();
                    if (callback != null) {
                        if (callback.mIControllerCallback == null || Build.VERSION.SDK_INT >= 23) {
                            callback.onSessionEvent(str, bundle);
                        }
                    }
                }
            }
        }

        /* loaded from: classes.dex */
        public class MessageHandler extends Handler {
            public static /* synthetic */ Interceptable $ic = null;
            public static final int MSG_DESTROYED = 8;
            public static final int MSG_EVENT = 1;
            public static final int MSG_SESSION_READY = 13;
            public static final int MSG_UPDATE_CAPTIONING_ENABLED = 11;
            public static final int MSG_UPDATE_EXTRAS = 7;
            public static final int MSG_UPDATE_METADATA = 3;
            public static final int MSG_UPDATE_PLAYBACK_STATE = 2;
            public static final int MSG_UPDATE_QUEUE = 5;
            public static final int MSG_UPDATE_QUEUE_TITLE = 6;
            public static final int MSG_UPDATE_REPEAT_MODE = 9;
            public static final int MSG_UPDATE_SHUFFLE_MODE = 12;
            public static final int MSG_UPDATE_VOLUME = 4;
            public transient /* synthetic */ FieldHolder $fh;
            public boolean mRegistered;
            public final /* synthetic */ Callback this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public MessageHandler(Callback callback, Looper looper) {
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
                this.mRegistered = false;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeL(1048576, this, message) != null) || !this.mRegistered) {
                    return;
                }
                switch (message.what) {
                    case 1:
                        Bundle data = message.getData();
                        MediaSessionCompat.ensureClassLoader(data);
                        this.this$0.onSessionEvent((String) message.obj, data);
                        return;
                    case 2:
                        this.this$0.onPlaybackStateChanged((PlaybackStateCompat) message.obj);
                        return;
                    case 3:
                        this.this$0.onMetadataChanged((MediaMetadataCompat) message.obj);
                        return;
                    case 4:
                        this.this$0.onAudioInfoChanged((PlaybackInfo) message.obj);
                        return;
                    case 5:
                        this.this$0.onQueueChanged((List) message.obj);
                        return;
                    case 6:
                        this.this$0.onQueueTitleChanged((CharSequence) message.obj);
                        return;
                    case 7:
                        Bundle bundle = (Bundle) message.obj;
                        MediaSessionCompat.ensureClassLoader(bundle);
                        this.this$0.onExtrasChanged(bundle);
                        return;
                    case 8:
                        this.this$0.onSessionDestroyed();
                        return;
                    case 9:
                        this.this$0.onRepeatModeChanged(((Integer) message.obj).intValue());
                        return;
                    case 10:
                    default:
                        return;
                    case 11:
                        this.this$0.onCaptioningEnabledChanged(((Boolean) message.obj).booleanValue());
                        return;
                    case 12:
                        this.this$0.onShuffleModeChanged(((Integer) message.obj).intValue());
                        return;
                    case 13:
                        this.this$0.onSessionReady();
                        return;
                }
            }
        }

        /* loaded from: classes.dex */
        public static class StubCompat extends IMediaControllerCallback.Stub {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final WeakReference<Callback> mCallback;

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onShuffleModeChangedRemoved(boolean z) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
                }
            }

            public StubCompat(Callback callback) {
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
                this.mCallback = new WeakReference<>(callback);
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                Callback callback;
                PlaybackInfo playbackInfo;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048588, this, parcelableVolumeInfo) == null) && (callback = this.mCallback.get()) != null) {
                    if (parcelableVolumeInfo != null) {
                        playbackInfo = new PlaybackInfo(parcelableVolumeInfo.volumeType, parcelableVolumeInfo.audioStream, parcelableVolumeInfo.controlType, parcelableVolumeInfo.maxVolume, parcelableVolumeInfo.currentVolume);
                    } else {
                        playbackInfo = null;
                    }
                    callback.postToHandler(4, playbackInfo, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onCaptioningEnabledChanged(boolean z) throws RemoteException {
                Callback callback;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && (callback = this.mCallback.get()) != null) {
                    callback.postToHandler(11, Boolean.valueOf(z), null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onExtrasChanged(Bundle bundle) throws RemoteException {
                Callback callback;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) && (callback = this.mCallback.get()) != null) {
                    callback.postToHandler(7, bundle, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                Callback callback;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048579, this, mediaMetadataCompat) == null) && (callback = this.mCallback.get()) != null) {
                    callback.postToHandler(3, mediaMetadataCompat, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) throws RemoteException {
                Callback callback;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048580, this, playbackStateCompat) == null) && (callback = this.mCallback.get()) != null) {
                    callback.postToHandler(2, playbackStateCompat, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onQueueChanged(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
                Callback callback;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048581, this, list) == null) && (callback = this.mCallback.get()) != null) {
                    callback.postToHandler(5, list, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onQueueTitleChanged(CharSequence charSequence) throws RemoteException {
                Callback callback;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048582, this, charSequence) == null) && (callback = this.mCallback.get()) != null) {
                    callback.postToHandler(6, charSequence, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onRepeatModeChanged(int i) throws RemoteException {
                Callback callback;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeI(1048583, this, i) == null) && (callback = this.mCallback.get()) != null) {
                    callback.postToHandler(9, Integer.valueOf(i), null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onShuffleModeChanged(int i) throws RemoteException {
                Callback callback;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeI(1048586, this, i) == null) && (callback = this.mCallback.get()) != null) {
                    callback.postToHandler(12, Integer.valueOf(i), null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onEvent(String str, Bundle bundle) throws RemoteException {
                Callback callback;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bundle) == null) && (callback = this.mCallback.get()) != null) {
                    callback.postToHandler(1, str, bundle);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onSessionDestroyed() throws RemoteException {
                Callback callback;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (callback = this.mCallback.get()) != null) {
                    callback.postToHandler(8, null, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onSessionReady() throws RemoteException {
                Callback callback;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (callback = this.mCallback.get()) != null) {
                    callback.postToHandler(13, null, null);
                }
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
            if (Build.VERSION.SDK_INT >= 21) {
                this.mCallbackFwk = new MediaControllerCallbackApi21(this);
                return;
            }
            this.mCallbackFwk = null;
            this.mIControllerCallback = new StubCompat(this);
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                postToHandler(8, null, null);
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public IMediaControllerCallback getIControllerCallback() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.mIControllerCallback;
            }
            return (IMediaControllerCallback) invokeV.objValue;
        }

        public void postToHandler(int i, Object obj, Bundle bundle) {
            MessageHandler messageHandler;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(1048590, this, i, obj, bundle) == null) && (messageHandler = this.mHandler) != null) {
                Message obtainMessage = messageHandler.obtainMessage(i, obj);
                obtainMessage.setData(bundle);
                obtainMessage.sendToTarget();
            }
        }

        public void setHandler(Handler handler) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, handler) == null) {
                if (handler == null) {
                    MessageHandler messageHandler = this.mHandler;
                    if (messageHandler != null) {
                        messageHandler.mRegistered = false;
                        messageHandler.removeCallbacksAndMessages(null);
                        this.mHandler = null;
                        return;
                    }
                    return;
                }
                MessageHandler messageHandler2 = new MessageHandler(this, handler.getLooper());
                this.mHandler = messageHandler2;
                messageHandler2.mRegistered = true;
            }
        }
    }

    @RequiresApi(21)
    /* loaded from: classes.dex */
    public static class MediaControllerImplApi21 implements MediaControllerImpl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HashMap<Callback, ExtraCallback> mCallbackMap;
        public final MediaController mControllerFwk;
        public final Object mLock;
        @GuardedBy("mLock")
        public final List<Callback> mPendingCallbacks;
        public Bundle mSessionInfo;
        public final MediaSessionCompat.Token mSessionToken;

        /* loaded from: classes.dex */
        public static class ExtraBinderRequestResultReceiver extends ResultReceiver {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public WeakReference<MediaControllerImplApi21> mMediaControllerImpl;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ExtraBinderRequestResultReceiver(MediaControllerImplApi21 mediaControllerImplApi21) {
                super(null);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mediaControllerImplApi21};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((Handler) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.mMediaControllerImpl = new WeakReference<>(mediaControllerImplApi21);
            }

            @Override // android.os.ResultReceiver
            public void onReceiveResult(int i, Bundle bundle) {
                MediaControllerImplApi21 mediaControllerImplApi21;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeIL(1048576, this, i, bundle) == null) && (mediaControllerImplApi21 = this.mMediaControllerImpl.get()) != null && bundle != null) {
                    synchronized (mediaControllerImplApi21.mLock) {
                        mediaControllerImplApi21.mSessionToken.setExtraBinder(IMediaSession.Stub.asInterface(BundleCompat.getBinder(bundle, MediaSessionCompat.KEY_EXTRA_BINDER)));
                        mediaControllerImplApi21.mSessionToken.setSession2Token(ParcelUtils.getVersionedParcelable(bundle, MediaSessionCompat.KEY_SESSION2_TOKEN));
                        mediaControllerImplApi21.processPendingCallbacksLocked();
                    }
                }
            }
        }

        /* loaded from: classes.dex */
        public static class ExtraCallback extends Callback.StubCompat {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ExtraCallback(Callback callback) {
                super(callback);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {callback};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((Callback) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onExtrasChanged(Bundle bundle) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaMetadataCompat) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onQueueChanged(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onQueueTitleChanged(CharSequence charSequence) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, charSequence) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048581, this, parcelableVolumeInfo) == null) {
                    throw new AssertionError();
                }
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onSessionDestroyed() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                    throw new AssertionError();
                }
            }
        }

        public MediaControllerImplApi21(Context context, MediaSessionCompat.Token token) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, token};
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
            this.mPendingCallbacks = new ArrayList();
            this.mCallbackMap = new HashMap<>();
            this.mSessionToken = token;
            this.mControllerFwk = new MediaController(context, (MediaSession.Token) this.mSessionToken.getToken());
            if (this.mSessionToken.getExtraBinder() == null) {
                requestExtraBinder();
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public final void registerCallback(Callback callback, Handler handler) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048598, this, callback, handler) == null) {
                this.mControllerFwk.registerCallback(callback.mCallbackFwk, handler);
                synchronized (this.mLock) {
                    if (this.mSessionToken.getExtraBinder() != null) {
                        ExtraCallback extraCallback = new ExtraCallback(callback);
                        this.mCallbackMap.put(callback, extraCallback);
                        callback.mIControllerCallback = extraCallback;
                        try {
                            this.mSessionToken.getExtraBinder().registerCallbackListener(extraCallback);
                            callback.postToHandler(13, null, null);
                        } catch (RemoteException e) {
                            Log.e(MediaControllerCompat.TAG, "Dead object in registerCallback.", e);
                        }
                    } else {
                        callback.mIControllerCallback = null;
                        this.mPendingCallbacks.add(callback);
                    }
                }
            }
        }

        private void requestExtraBinder() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                sendCommand(MediaControllerCompat.COMMAND_GET_EXTRA_BINDER, null, new ExtraBinderRequestResultReceiver(this));
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public Bundle getExtras() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.mControllerFwk.getExtras();
            }
            return (Bundle) invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public long getFlags() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.mControllerFwk.getFlags();
            }
            return invokeV.longValue;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public Object getMediaController() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.mControllerFwk;
            }
            return invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public MediaMetadataCompat getMetadata() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                MediaMetadata metadata = this.mControllerFwk.getMetadata();
                if (metadata != null) {
                    return MediaMetadataCompat.fromMediaMetadata(metadata);
                }
                return null;
            }
            return (MediaMetadataCompat) invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public String getPackageName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.mControllerFwk.getPackageName();
            }
            return (String) invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public List<MediaSessionCompat.QueueItem> getQueue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                List<MediaSession.QueueItem> queue = this.mControllerFwk.getQueue();
                if (queue != null) {
                    return MediaSessionCompat.QueueItem.fromQueueItemList(queue);
                }
                return null;
            }
            return (List) invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public CharSequence getQueueTitle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                return this.mControllerFwk.getQueueTitle();
            }
            return (CharSequence) invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public int getRepeatMode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                if (this.mSessionToken.getExtraBinder() != null) {
                    try {
                        return this.mSessionToken.getExtraBinder().getRepeatMode();
                    } catch (RemoteException e) {
                        Log.e(MediaControllerCompat.TAG, "Dead object in getRepeatMode.", e);
                        return -1;
                    }
                }
                return -1;
            }
            return invokeV.intValue;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public PendingIntent getSessionActivity() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return this.mControllerFwk.getSessionActivity();
            }
            return (PendingIntent) invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public int getShuffleMode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                if (this.mSessionToken.getExtraBinder() != null) {
                    try {
                        return this.mSessionToken.getExtraBinder().getShuffleMode();
                    } catch (RemoteException e) {
                        Log.e(MediaControllerCompat.TAG, "Dead object in getShuffleMode.", e);
                        return -1;
                    }
                }
                return -1;
            }
            return invokeV.intValue;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public TransportControls getTransportControls() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                return new TransportControlsApi21(this.mControllerFwk.getTransportControls());
            }
            return (TransportControls) invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public boolean isCaptioningEnabled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                if (this.mSessionToken.getExtraBinder() != null) {
                    try {
                        return this.mSessionToken.getExtraBinder().isCaptioningEnabled();
                    } catch (RemoteException e) {
                        Log.e(MediaControllerCompat.TAG, "Dead object in isCaptioningEnabled.", e);
                        return false;
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public boolean isSessionReady() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                if (this.mSessionToken.getExtraBinder() != null) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaDescriptionCompat) == null) {
                if ((getFlags() & 4) != 0) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION, mediaDescriptionCompat);
                    sendCommand(MediaControllerCompat.COMMAND_ADD_QUEUE_ITEM, bundle, null);
                    return;
                }
                throw new UnsupportedOperationException("This session doesn't support queue management operations");
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048599, this, mediaDescriptionCompat) == null) {
                if ((getFlags() & 4) != 0) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION, mediaDescriptionCompat);
                    sendCommand(MediaControllerCompat.COMMAND_REMOVE_QUEUE_ITEM, bundle, null);
                    return;
                }
                throw new UnsupportedOperationException("This session doesn't support queue management operations");
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaDescriptionCompat, i) == null) {
                if ((getFlags() & 4) != 0) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION, mediaDescriptionCompat);
                    bundle.putInt(MediaControllerCompat.COMMAND_ARGUMENT_INDEX, i);
                    sendCommand(MediaControllerCompat.COMMAND_ADD_QUEUE_ITEM_AT, bundle, null);
                    return;
                }
                throw new UnsupportedOperationException("This session doesn't support queue management operations");
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void adjustVolume(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
                this.mControllerFwk.adjustVolume(i, i2);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void setVolumeTo(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048601, this, i, i2) == null) {
                this.mControllerFwk.setVolumeTo(i, i2);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public boolean dispatchMediaButtonEvent(KeyEvent keyEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, keyEvent)) == null) {
                return this.mControllerFwk.dispatchMediaButtonEvent(keyEvent);
            }
            return invokeL.booleanValue;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public PlaybackInfo getPlaybackInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                MediaController.PlaybackInfo playbackInfo = this.mControllerFwk.getPlaybackInfo();
                if (playbackInfo != null) {
                    return new PlaybackInfo(playbackInfo.getPlaybackType(), AudioAttributesCompat.wrap(playbackInfo.getAudioAttributes()), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume());
                }
                return null;
            }
            return (PlaybackInfo) invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public PlaybackStateCompat getPlaybackState() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                if (this.mSessionToken.getExtraBinder() != null) {
                    try {
                        return this.mSessionToken.getExtraBinder().getPlaybackState();
                    } catch (RemoteException e) {
                        Log.e(MediaControllerCompat.TAG, "Dead object in getPlaybackState.", e);
                    }
                }
                PlaybackState playbackState = this.mControllerFwk.getPlaybackState();
                if (playbackState != null) {
                    return PlaybackStateCompat.fromPlaybackState(playbackState);
                }
                return null;
            }
            return (PlaybackStateCompat) invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public int getRatingType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                if (Build.VERSION.SDK_INT < 22 && this.mSessionToken.getExtraBinder() != null) {
                    try {
                        return this.mSessionToken.getExtraBinder().getRatingType();
                    } catch (RemoteException e) {
                        Log.e(MediaControllerCompat.TAG, "Dead object in getRatingType.", e);
                    }
                }
                return this.mControllerFwk.getRatingType();
            }
            return invokeV.intValue;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public Bundle getSessionInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                if (this.mSessionInfo != null) {
                    return new Bundle(this.mSessionInfo);
                }
                if (Build.VERSION.SDK_INT >= 29) {
                    this.mSessionInfo = this.mControllerFwk.getSessionInfo();
                } else if (this.mSessionToken.getExtraBinder() != null) {
                    try {
                        this.mSessionInfo = this.mSessionToken.getExtraBinder().getSessionInfo();
                    } catch (RemoteException e) {
                        Log.e(MediaControllerCompat.TAG, "Dead object in getSessionInfo.", e);
                        this.mSessionInfo = Bundle.EMPTY;
                    }
                }
                Bundle unparcelWithClassLoader = MediaSessionCompat.unparcelWithClassLoader(this.mSessionInfo);
                this.mSessionInfo = unparcelWithClassLoader;
                if (unparcelWithClassLoader == null) {
                    return Bundle.EMPTY;
                }
                return new Bundle(this.mSessionInfo);
            }
            return (Bundle) invokeV.objValue;
        }

        @GuardedBy("mLock")
        public void processPendingCallbacksLocked() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048597, this) != null) || this.mSessionToken.getExtraBinder() == null) {
                return;
            }
            for (Callback callback : this.mPendingCallbacks) {
                ExtraCallback extraCallback = new ExtraCallback(callback);
                this.mCallbackMap.put(callback, extraCallback);
                callback.mIControllerCallback = extraCallback;
                try {
                    this.mSessionToken.getExtraBinder().registerCallbackListener(extraCallback);
                    callback.postToHandler(13, null, null);
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in registerCallback.", e);
                }
            }
            this.mPendingCallbacks.clear();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void sendCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048600, this, str, bundle, resultReceiver) == null) {
                this.mControllerFwk.sendCommand(str, bundle, resultReceiver);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public final void unregisterCallback(Callback callback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048602, this, callback) == null) {
                this.mControllerFwk.unregisterCallback(callback.mCallbackFwk);
                synchronized (this.mLock) {
                    if (this.mSessionToken.getExtraBinder() != null) {
                        try {
                            ExtraCallback remove = this.mCallbackMap.remove(callback);
                            if (remove != null) {
                                callback.mIControllerCallback = null;
                                this.mSessionToken.getExtraBinder().unregisterCallbackListener(remove);
                            }
                        } catch (RemoteException e) {
                            Log.e(MediaControllerCompat.TAG, "Dead object in unregisterCallback.", e);
                        }
                    } else {
                        this.mPendingCallbacks.remove(callback);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class MediaControllerImplBase implements MediaControllerImpl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public IMediaSession mBinder;
        public Bundle mSessionInfo;
        public TransportControls mTransportControls;

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public Object getMediaController() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return null;
            }
            return invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public boolean isSessionReady() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public MediaControllerImplBase(MediaSessionCompat.Token token) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {token};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mBinder = IMediaSession.Stub.asInterface((IBinder) token.getToken());
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaDescriptionCompat) == null) {
                try {
                    if ((this.mBinder.getFlags() & 4) != 0) {
                        this.mBinder.addQueueItem(mediaDescriptionCompat);
                        return;
                    }
                    throw new UnsupportedOperationException("This session doesn't support queue management operations");
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in addQueueItem.", e);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048598, this, mediaDescriptionCompat) == null) {
                try {
                    if ((this.mBinder.getFlags() & 4) != 0) {
                        this.mBinder.removeQueueItem(mediaDescriptionCompat);
                        return;
                    }
                    throw new UnsupportedOperationException("This session doesn't support queue management operations");
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in removeQueueItem.", e);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void unregisterCallback(Callback callback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048601, this, callback) == null) {
                if (callback != null) {
                    try {
                        this.mBinder.unregisterCallbackListener(callback.mIControllerCallback);
                        this.mBinder.asBinder().unlinkToDeath(callback, 0);
                        return;
                    } catch (RemoteException e) {
                        Log.e(MediaControllerCompat.TAG, "Dead object in unregisterCallback.", e);
                        return;
                    }
                }
                throw new IllegalArgumentException("callback may not be null.");
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaDescriptionCompat, i) == null) {
                try {
                    if ((this.mBinder.getFlags() & 4) != 0) {
                        this.mBinder.addQueueItemAt(mediaDescriptionCompat, i);
                        return;
                    }
                    throw new UnsupportedOperationException("This session doesn't support queue management operations");
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in addQueueItemAt.", e);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void registerCallback(Callback callback, Handler handler) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048597, this, callback, handler) == null) {
                if (callback != null) {
                    try {
                        this.mBinder.asBinder().linkToDeath(callback, 0);
                        this.mBinder.registerCallbackListener(callback.mIControllerCallback);
                        callback.postToHandler(13, null, null);
                        return;
                    } catch (RemoteException e) {
                        Log.e(MediaControllerCompat.TAG, "Dead object in registerCallback.", e);
                        callback.postToHandler(8, null, null);
                        return;
                    }
                }
                throw new IllegalArgumentException("callback may not be null.");
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void adjustVolume(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
                try {
                    this.mBinder.adjustVolume(i, i2, null);
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in adjustVolume.", e);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void setVolumeTo(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048600, this, i, i2) == null) {
                try {
                    this.mBinder.setVolumeTo(i, i2, null);
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in setVolumeTo.", e);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public boolean dispatchMediaButtonEvent(KeyEvent keyEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, keyEvent)) == null) {
                if (keyEvent != null) {
                    try {
                        this.mBinder.sendMediaButton(keyEvent);
                        return false;
                    } catch (RemoteException e) {
                        Log.e(MediaControllerCompat.TAG, "Dead object in dispatchMediaButtonEvent.", e);
                        return false;
                    }
                }
                throw new IllegalArgumentException("event may not be null.");
            }
            return invokeL.booleanValue;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public Bundle getExtras() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                try {
                    return this.mBinder.getExtras();
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in getExtras.", e);
                    return null;
                }
            }
            return (Bundle) invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public long getFlags() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                try {
                    return this.mBinder.getFlags();
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in getFlags.", e);
                    return 0L;
                }
            }
            return invokeV.longValue;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public MediaMetadataCompat getMetadata() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                try {
                    return this.mBinder.getMetadata();
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in getMetadata.", e);
                    return null;
                }
            }
            return (MediaMetadataCompat) invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public String getPackageName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                try {
                    return this.mBinder.getPackageName();
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in getPackageName.", e);
                    return null;
                }
            }
            return (String) invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public PlaybackStateCompat getPlaybackState() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                try {
                    return this.mBinder.getPlaybackState();
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in getPlaybackState.", e);
                    return null;
                }
            }
            return (PlaybackStateCompat) invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public List<MediaSessionCompat.QueueItem> getQueue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                try {
                    return this.mBinder.getQueue();
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in getQueue.", e);
                    return null;
                }
            }
            return (List) invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public CharSequence getQueueTitle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                try {
                    return this.mBinder.getQueueTitle();
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in getQueueTitle.", e);
                    return null;
                }
            }
            return (CharSequence) invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public int getRatingType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                try {
                    return this.mBinder.getRatingType();
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in getRatingType.", e);
                    return 0;
                }
            }
            return invokeV.intValue;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public int getRepeatMode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                try {
                    return this.mBinder.getRepeatMode();
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in getRepeatMode.", e);
                    return -1;
                }
            }
            return invokeV.intValue;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public PendingIntent getSessionActivity() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                try {
                    return this.mBinder.getLaunchPendingIntent();
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in getSessionActivity.", e);
                    return null;
                }
            }
            return (PendingIntent) invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public int getShuffleMode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                try {
                    return this.mBinder.getShuffleMode();
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in getShuffleMode.", e);
                    return -1;
                }
            }
            return invokeV.intValue;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public TransportControls getTransportControls() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                if (this.mTransportControls == null) {
                    this.mTransportControls = new TransportControlsBase(this.mBinder);
                }
                return this.mTransportControls;
            }
            return (TransportControls) invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public boolean isCaptioningEnabled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                try {
                    return this.mBinder.isCaptioningEnabled();
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in isCaptioningEnabled.", e);
                    return false;
                }
            }
            return invokeV.booleanValue;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public PlaybackInfo getPlaybackInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                try {
                    ParcelableVolumeInfo volumeAttributes = this.mBinder.getVolumeAttributes();
                    return new PlaybackInfo(volumeAttributes.volumeType, volumeAttributes.audioStream, volumeAttributes.controlType, volumeAttributes.maxVolume, volumeAttributes.currentVolume);
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in getPlaybackInfo.", e);
                    return null;
                }
            }
            return (PlaybackInfo) invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public Bundle getSessionInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                try {
                    this.mSessionInfo = this.mBinder.getSessionInfo();
                } catch (RemoteException e) {
                    Log.d(MediaControllerCompat.TAG, "Dead object in getSessionInfo.", e);
                }
                Bundle unparcelWithClassLoader = MediaSessionCompat.unparcelWithClassLoader(this.mSessionInfo);
                this.mSessionInfo = unparcelWithClassLoader;
                if (unparcelWithClassLoader == null) {
                    return Bundle.EMPTY;
                }
                return new Bundle(this.mSessionInfo);
            }
            return (Bundle) invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void sendCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
            MediaSessionCompat.ResultReceiverWrapper resultReceiverWrapper;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048599, this, str, bundle, resultReceiver) == null) {
                try {
                    IMediaSession iMediaSession = this.mBinder;
                    if (resultReceiver == null) {
                        resultReceiverWrapper = null;
                    } else {
                        resultReceiverWrapper = new MediaSessionCompat.ResultReceiverWrapper(resultReceiver);
                    }
                    iMediaSession.sendCommand(str, bundle, resultReceiverWrapper);
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in sendCommand.", e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class PlaybackInfo {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int PLAYBACK_TYPE_LOCAL = 1;
        public static final int PLAYBACK_TYPE_REMOTE = 2;
        public transient /* synthetic */ FieldHolder $fh;
        public final AudioAttributesCompat mAudioAttrsCompat;
        public final int mCurrentVolume;
        public final int mMaxVolume;
        public final int mPlaybackType;
        public final int mVolumeControl;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public PlaybackInfo(int i, int i2, int i3, int i4, int i5) {
            this(i, new AudioAttributesCompat.Builder().setLegacyStreamType(i2).build(), i3, i4, i5);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i6 = newInitContext.flag;
                if ((i6 & 1) != 0) {
                    int i7 = i6 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this(((Integer) objArr2[0]).intValue(), (AudioAttributesCompat) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public PlaybackInfo(int i, @NonNull AudioAttributesCompat audioAttributesCompat, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), audioAttributesCompat, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mPlaybackType = i;
            this.mAudioAttrsCompat = audioAttributesCompat;
            this.mVolumeControl = i2;
            this.mMaxVolume = i3;
            this.mCurrentVolume = i4;
        }

        @NonNull
        public AudioAttributesCompat getAudioAttributes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.mAudioAttrsCompat;
            }
            return (AudioAttributesCompat) invokeV.objValue;
        }

        @Deprecated
        public int getAudioStream() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.mAudioAttrsCompat.getLegacyStreamType();
            }
            return invokeV.intValue;
        }

        public int getCurrentVolume() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.mCurrentVolume;
            }
            return invokeV.intValue;
        }

        public int getMaxVolume() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.mMaxVolume;
            }
            return invokeV.intValue;
        }

        public int getPlaybackType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.mPlaybackType;
            }
            return invokeV.intValue;
        }

        public int getVolumeControl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.mVolumeControl;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class TransportControls {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String EXTRA_LEGACY_STREAM_TYPE = "android.media.session.extra.LEGACY_STREAM_TYPE";
        public transient /* synthetic */ FieldHolder $fh;

        public abstract void fastForward();

        public abstract void pause();

        public abstract void play();

        public abstract void playFromMediaId(String str, Bundle bundle);

        public abstract void playFromSearch(String str, Bundle bundle);

        public abstract void playFromUri(Uri uri, Bundle bundle);

        public abstract void prepare();

        public abstract void prepareFromMediaId(String str, Bundle bundle);

        public abstract void prepareFromSearch(String str, Bundle bundle);

        public abstract void prepareFromUri(Uri uri, Bundle bundle);

        public abstract void rewind();

        public abstract void seekTo(long j);

        public abstract void sendCustomAction(PlaybackStateCompat.CustomAction customAction, Bundle bundle);

        public abstract void sendCustomAction(String str, Bundle bundle);

        public abstract void setCaptioningEnabled(boolean z);

        public void setPlaybackSpeed(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048591, this, f) == null) {
            }
        }

        public abstract void setRating(RatingCompat ratingCompat);

        public abstract void setRating(RatingCompat ratingCompat, Bundle bundle);

        public abstract void setRepeatMode(int i);

        public abstract void setShuffleMode(int i);

        public abstract void skipToNext();

        public abstract void skipToPrevious();

        public abstract void skipToQueueItem(long j);

        public abstract void stop();

        public TransportControls() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    @RequiresApi(21)
    /* loaded from: classes.dex */
    public static class TransportControlsApi21 extends TransportControls {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final MediaController.TransportControls mControlsFwk;

        public TransportControlsApi21(MediaController.TransportControls transportControls) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transportControls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mControlsFwk = transportControls;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void seekTo(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048587, this, j) == null) {
                this.mControlsFwk.seekTo(j);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setCaptioningEnabled(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
                Bundle bundle = new Bundle();
                bundle.putBoolean(MediaSessionCompat.ACTION_ARGUMENT_CAPTIONING_ENABLED, z);
                sendCustomAction(MediaSessionCompat.ACTION_SET_CAPTIONING_ENABLED, bundle);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRating(RatingCompat ratingCompat) {
            Rating rating;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, ratingCompat) == null) {
                MediaController.TransportControls transportControls = this.mControlsFwk;
                if (ratingCompat != null) {
                    rating = (Rating) ratingCompat.getRating();
                } else {
                    rating = null;
                }
                transportControls.setRating(rating);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRepeatMode(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
                Bundle bundle = new Bundle();
                bundle.putInt(MediaSessionCompat.ACTION_ARGUMENT_REPEAT_MODE, i);
                sendCustomAction(MediaSessionCompat.ACTION_SET_REPEAT_MODE, bundle);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setShuffleMode(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
                Bundle bundle = new Bundle();
                bundle.putInt(MediaSessionCompat.ACTION_ARGUMENT_SHUFFLE_MODE, i);
                sendCustomAction(MediaSessionCompat.ACTION_SET_SHUFFLE_MODE, bundle);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToQueueItem(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048598, this, j) == null) {
                this.mControlsFwk.skipToQueueItem(j);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void fastForward() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.mControlsFwk.fastForward();
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void pause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.mControlsFwk.pause();
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void play() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.mControlsFwk.play();
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepare() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    this.mControlsFwk.prepare();
                } else {
                    sendCustomAction(MediaSessionCompat.ACTION_PREPARE, (Bundle) null);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void rewind() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                this.mControlsFwk.rewind();
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToNext() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
                this.mControlsFwk.skipToNext();
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToPrevious() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
                this.mControlsFwk.skipToPrevious();
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void stop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
                this.mControlsFwk.stop();
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromMediaId(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, str, bundle) == null) {
                this.mControlsFwk.playFromMediaId(str, bundle);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromSearch(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, str, bundle) == null) {
                this.mControlsFwk.playFromSearch(str, bundle);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromMediaId(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, str, bundle) == null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    this.mControlsFwk.prepareFromMediaId(str, bundle);
                    return;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putString(MediaSessionCompat.ACTION_ARGUMENT_MEDIA_ID, str);
                bundle2.putBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, bundle);
                sendCustomAction(MediaSessionCompat.ACTION_PREPARE_FROM_MEDIA_ID, bundle2);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromSearch(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, bundle) == null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    this.mControlsFwk.prepareFromSearch(str, bundle);
                    return;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putString(MediaSessionCompat.ACTION_ARGUMENT_QUERY, str);
                bundle2.putBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, bundle);
                sendCustomAction(MediaSessionCompat.ACTION_PREPARE_FROM_SEARCH, bundle2);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromUri(Uri uri, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, uri, bundle) == null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    this.mControlsFwk.prepareFromUri(uri, bundle);
                    return;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable(MediaSessionCompat.ACTION_ARGUMENT_URI, uri);
                bundle2.putBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, bundle);
                sendCustomAction(MediaSessionCompat.ACTION_PREPARE_FROM_URI, bundle2);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void sendCustomAction(PlaybackStateCompat.CustomAction customAction, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048588, this, customAction, bundle) == null) {
                MediaControllerCompat.validateCustomAction(customAction.getAction(), bundle);
                this.mControlsFwk.sendCustomAction(customAction.getAction(), bundle);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRating(RatingCompat ratingCompat, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048593, this, ratingCompat, bundle) == null) {
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable(MediaSessionCompat.ACTION_ARGUMENT_RATING, ratingCompat);
                bundle2.putBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, bundle);
                sendCustomAction(MediaSessionCompat.ACTION_SET_RATING, bundle2);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromUri(Uri uri, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, uri, bundle) == null) {
                if (Build.VERSION.SDK_INT >= 23) {
                    this.mControlsFwk.playFromUri(uri, bundle);
                } else if (uri != null && !Uri.EMPTY.equals(uri)) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putParcelable(MediaSessionCompat.ACTION_ARGUMENT_URI, uri);
                    bundle2.putBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, bundle);
                    sendCustomAction(MediaSessionCompat.ACTION_PLAY_FROM_URI, bundle2);
                } else {
                    throw new IllegalArgumentException("You must specify a non-empty Uri for playFromUri.");
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void sendCustomAction(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048589, this, str, bundle) == null) {
                MediaControllerCompat.validateCustomAction(str, bundle);
                this.mControlsFwk.sendCustomAction(str, bundle);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setPlaybackSpeed(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048591, this, f) == null) {
                if (f != 0.0f) {
                    if (Build.VERSION.SDK_INT >= 29) {
                        this.mControlsFwk.setPlaybackSpeed(f);
                        return;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putFloat(MediaSessionCompat.ACTION_ARGUMENT_PLAYBACK_SPEED, f);
                    sendCustomAction(MediaSessionCompat.ACTION_SET_PLAYBACK_SPEED, bundle);
                    return;
                }
                throw new IllegalArgumentException("speed must not be zero");
            }
        }
    }

    /* loaded from: classes.dex */
    public static class TransportControlsBase extends TransportControls {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public IMediaSession mBinder;

        public TransportControlsBase(IMediaSession iMediaSession) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iMediaSession};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mBinder = iMediaSession;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void seekTo(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048587, this, j) == null) {
                try {
                    this.mBinder.seekTo(j);
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in seekTo.", e);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setCaptioningEnabled(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
                try {
                    this.mBinder.setCaptioningEnabled(z);
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in setCaptioningEnabled.", e);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setPlaybackSpeed(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048591, this, f) == null) {
                if (f != 0.0f) {
                    try {
                        this.mBinder.setPlaybackSpeed(f);
                        return;
                    } catch (RemoteException e) {
                        Log.e(MediaControllerCompat.TAG, "Dead object in setPlaybackSpeed.", e);
                        return;
                    }
                }
                throw new IllegalArgumentException("speed must not be zero");
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRating(RatingCompat ratingCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, ratingCompat) == null) {
                try {
                    this.mBinder.rate(ratingCompat);
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in setRating.", e);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRepeatMode(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
                try {
                    this.mBinder.setRepeatMode(i);
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in setRepeatMode.", e);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setShuffleMode(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
                try {
                    this.mBinder.setShuffleMode(i);
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in setShuffleMode.", e);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToQueueItem(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048598, this, j) == null) {
                try {
                    this.mBinder.skipToQueueItem(j);
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in skipToQueueItem.", e);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void fastForward() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.mBinder.fastForward();
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in fastForward.", e);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void pause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                try {
                    this.mBinder.pause();
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in pause.", e);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void play() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                try {
                    this.mBinder.play();
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in play.", e);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepare() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                try {
                    this.mBinder.prepare();
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in prepare.", e);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void rewind() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                try {
                    this.mBinder.rewind();
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in rewind.", e);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToNext() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
                try {
                    this.mBinder.next();
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in skipToNext.", e);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToPrevious() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
                try {
                    this.mBinder.previous();
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in skipToPrevious.", e);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void stop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
                try {
                    this.mBinder.stop();
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in stop.", e);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromMediaId(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, str, bundle) == null) {
                try {
                    this.mBinder.playFromMediaId(str, bundle);
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in playFromMediaId.", e);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromSearch(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, str, bundle) == null) {
                try {
                    this.mBinder.playFromSearch(str, bundle);
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in playFromSearch.", e);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromUri(Uri uri, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, uri, bundle) == null) {
                try {
                    this.mBinder.playFromUri(uri, bundle);
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in playFromUri.", e);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromMediaId(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, str, bundle) == null) {
                try {
                    this.mBinder.prepareFromMediaId(str, bundle);
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in prepareFromMediaId.", e);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromSearch(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, bundle) == null) {
                try {
                    this.mBinder.prepareFromSearch(str, bundle);
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in prepareFromSearch.", e);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromUri(Uri uri, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, uri, bundle) == null) {
                try {
                    this.mBinder.prepareFromUri(uri, bundle);
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in prepareFromUri.", e);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void sendCustomAction(PlaybackStateCompat.CustomAction customAction, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048588, this, customAction, bundle) == null) {
                sendCustomAction(customAction.getAction(), bundle);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRating(RatingCompat ratingCompat, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048593, this, ratingCompat, bundle) == null) {
                try {
                    this.mBinder.rateWithExtras(ratingCompat, bundle);
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in setRating.", e);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void sendCustomAction(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048589, this, str, bundle) == null) {
                MediaControllerCompat.validateCustomAction(str, bundle);
                try {
                    this.mBinder.sendCustomAction(str, bundle);
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in sendCustomAction.", e);
                }
            }
        }
    }

    public MediaControllerCompat(Context context, @NonNull MediaSessionCompat.Token token) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, token};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mRegisteredCallbacks = new ConcurrentHashMap<>();
        if (token != null) {
            this.mToken = token;
            if (Build.VERSION.SDK_INT >= 21) {
                this.mImpl = new MediaControllerImplApi21(context, token);
                return;
            } else {
                this.mImpl = new MediaControllerImplBase(token);
                return;
            }
        }
        throw new IllegalArgumentException("sessionToken must not be null");
    }

    public static void validateCustomAction(String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, bundle) != null) || str == null) {
            return;
        }
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1348483723) {
            if (hashCode == 503011406 && str.equals(MediaSessionCompat.ACTION_UNFOLLOW)) {
                c = 1;
            }
        } else if (str.equals(MediaSessionCompat.ACTION_FOLLOW)) {
            c = 0;
        }
        if (c == 0 || c == 1) {
            if (bundle != null && bundle.containsKey(MediaSessionCompat.ARGUMENT_MEDIA_ATTRIBUTE)) {
                return;
            }
            throw new IllegalArgumentException("An extra field android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE is required for this action " + str + ".");
        }
    }

    public MediaControllerCompat(Context context, @NonNull MediaSessionCompat mediaSessionCompat) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mediaSessionCompat};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mRegisteredCallbacks = new ConcurrentHashMap<>();
        if (mediaSessionCompat != null) {
            MediaSessionCompat.Token sessionToken = mediaSessionCompat.getSessionToken();
            this.mToken = sessionToken;
            if (Build.VERSION.SDK_INT >= 21) {
                this.mImpl = new MediaControllerImplApi21(context, sessionToken);
                return;
            } else {
                this.mImpl = new MediaControllerImplBase(sessionToken);
                return;
            }
        }
        throw new IllegalArgumentException("session must not be null");
    }

    public static MediaControllerCompat getMediaController(@NonNull Activity activity) {
        InterceptResult invokeL;
        MediaController mediaController;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, activity)) == null) {
            Object tag = activity.getWindow().getDecorView().getTag(R.id.obfuscated_res_0x7f09150f);
            if (tag instanceof MediaControllerCompat) {
                return (MediaControllerCompat) tag;
            }
            if (Build.VERSION.SDK_INT < 21 || (mediaController = activity.getMediaController()) == null) {
                return null;
            }
            return new MediaControllerCompat(activity, MediaSessionCompat.Token.fromToken(mediaController.getSessionToken()));
        }
        return (MediaControllerCompat) invokeL.objValue;
    }

    public static void setMediaController(@NonNull Activity activity, MediaControllerCompat mediaControllerCompat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, activity, mediaControllerCompat) == null) {
            activity.getWindow().getDecorView().setTag(R.id.obfuscated_res_0x7f09150f, mediaControllerCompat);
            if (Build.VERSION.SDK_INT >= 21) {
                MediaController mediaController = null;
                if (mediaControllerCompat != null) {
                    mediaController = new MediaController(activity, (MediaSession.Token) mediaControllerCompat.getSessionToken().getToken());
                }
                activity.setMediaController(mediaController);
            }
        }
    }

    public void registerCallback(@NonNull Callback callback, Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, callback, handler) == null) {
            if (callback != null) {
                if (this.mRegisteredCallbacks.putIfAbsent(callback, Boolean.TRUE) != null) {
                    Log.w(TAG, "the callback has already been registered");
                    return;
                }
                if (handler == null) {
                    handler = new Handler();
                }
                callback.setHandler(handler);
                this.mImpl.registerCallback(callback, handler);
                return;
            }
            throw new IllegalArgumentException("callback must not be null");
        }
    }

    public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, mediaDescriptionCompat) == null) {
            this.mImpl.addQueueItem(mediaDescriptionCompat);
        }
    }

    public boolean dispatchMediaButtonEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, keyEvent)) == null) {
            if (keyEvent != null) {
                return this.mImpl.dispatchMediaButtonEvent(keyEvent);
            }
            throw new IllegalArgumentException("KeyEvent may not be null");
        }
        return invokeL.booleanValue;
    }

    public void registerCallback(@NonNull Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, callback) == null) {
            registerCallback(callback, null);
        }
    }

    public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, mediaDescriptionCompat) == null) {
            this.mImpl.removeQueueItem(mediaDescriptionCompat);
        }
    }

    @Deprecated
    public void removeQueueItemAt(int i) {
        List<MediaSessionCompat.QueueItem> queue;
        MediaSessionCompat.QueueItem queueItem;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048602, this, i) == null) && (queue = getQueue()) != null && i >= 0 && i < queue.size() && (queueItem = queue.get(i)) != null) {
            removeQueueItem(queueItem.getDescription());
        }
    }

    public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaDescriptionCompat, i) == null) {
            this.mImpl.addQueueItem(mediaDescriptionCompat, i);
        }
    }

    public void adjustVolume(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            this.mImpl.adjustVolume(i, i2);
        }
    }

    public void setVolumeTo(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048604, this, i, i2) == null) {
            this.mImpl.setVolumeTo(i, i2);
        }
    }

    public Bundle getExtras() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mImpl.getExtras();
        }
        return (Bundle) invokeV.objValue;
    }

    public long getFlags() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mImpl.getFlags();
        }
        return invokeV.longValue;
    }

    public Object getMediaController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mImpl.getMediaController();
        }
        return invokeV.objValue;
    }

    public MediaMetadataCompat getMetadata() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mImpl.getMetadata();
        }
        return (MediaMetadataCompat) invokeV.objValue;
    }

    public String getPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mImpl.getPackageName();
        }
        return (String) invokeV.objValue;
    }

    public PlaybackInfo getPlaybackInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mImpl.getPlaybackInfo();
        }
        return (PlaybackInfo) invokeV.objValue;
    }

    public PlaybackStateCompat getPlaybackState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mImpl.getPlaybackState();
        }
        return (PlaybackStateCompat) invokeV.objValue;
    }

    public List<MediaSessionCompat.QueueItem> getQueue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mImpl.getQueue();
        }
        return (List) invokeV.objValue;
    }

    public CharSequence getQueueTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mImpl.getQueueTitle();
        }
        return (CharSequence) invokeV.objValue;
    }

    public int getRatingType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mImpl.getRatingType();
        }
        return invokeV.intValue;
    }

    public int getRepeatMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.mImpl.getRepeatMode();
        }
        return invokeV.intValue;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public VersionedParcelable getSession2Token() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.mToken.getSession2Token();
        }
        return (VersionedParcelable) invokeV.objValue;
    }

    public PendingIntent getSessionActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.mImpl.getSessionActivity();
        }
        return (PendingIntent) invokeV.objValue;
    }

    @NonNull
    public Bundle getSessionInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.mImpl.getSessionInfo();
        }
        return (Bundle) invokeV.objValue;
    }

    public MediaSessionCompat.Token getSessionToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.mToken;
        }
        return (MediaSessionCompat.Token) invokeV.objValue;
    }

    public int getShuffleMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.mImpl.getShuffleMode();
        }
        return invokeV.intValue;
    }

    public TransportControls getTransportControls() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.mImpl.getTransportControls();
        }
        return (TransportControls) invokeV.objValue;
    }

    public boolean isCaptioningEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.mImpl.isCaptioningEnabled();
        }
        return invokeV.booleanValue;
    }

    public boolean isSessionReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.mImpl.isSessionReady();
        }
        return invokeV.booleanValue;
    }

    public void sendCommand(@NonNull String str, @Nullable Bundle bundle, @Nullable ResultReceiver resultReceiver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048603, this, str, bundle, resultReceiver) == null) {
            if (!TextUtils.isEmpty(str)) {
                this.mImpl.sendCommand(str, bundle, resultReceiver);
                return;
            }
            throw new IllegalArgumentException("command must neither be null nor empty");
        }
    }

    public void unregisterCallback(@NonNull Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, callback) == null) {
            if (callback != null) {
                if (this.mRegisteredCallbacks.remove(callback) == null) {
                    Log.w(TAG, "the callback has never been registered");
                    return;
                }
                try {
                    this.mImpl.unregisterCallback(callback);
                    return;
                } finally {
                    callback.setHandler(null);
                }
            }
            throw new IllegalArgumentException("callback must not be null");
        }
    }
}
