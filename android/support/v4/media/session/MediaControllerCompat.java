package android.support.v4.media.session;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
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
import android.support.v4.media.session.MediaControllerCompatApi21;
import android.support.v4.media.session.MediaControllerCompatApi23;
import android.support.v4.media.session.MediaControllerCompatApi24;
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
import androidx.core.app.ComponentActivity;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
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
    public final HashSet<Callback> mRegisteredCallbacks;
    public final MediaSessionCompat.Token mToken;

    /* loaded from: classes.dex */
    public static abstract class Callback implements IBinder.DeathRecipient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Object mCallbackObj;
        public MessageHandler mHandler;
        public IMediaControllerCallback mIControllerCallback;

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
                this.mRegistered = false;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && this.mRegistered) {
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
        }

        /* loaded from: classes.dex */
        public static class StubApi21 implements MediaControllerCompatApi21.Callback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final WeakReference<Callback> mCallback;

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
                this.mCallback = new WeakReference<>(callback);
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onAudioInfoChanged(int i2, int i3, int i4, int i5, int i6) {
                Callback callback;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) || (callback = this.mCallback.get()) == null) {
                    return;
                }
                callback.onAudioInfoChanged(new PlaybackInfo(i2, i3, i4, i5, i6));
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onExtrasChanged(Bundle bundle) {
                Callback callback;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) || (callback = this.mCallback.get()) == null) {
                    return;
                }
                callback.onExtrasChanged(bundle);
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onMetadataChanged(Object obj) {
                Callback callback;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) || (callback = this.mCallback.get()) == null) {
                    return;
                }
                callback.onMetadataChanged(MediaMetadataCompat.fromMediaMetadata(obj));
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onPlaybackStateChanged(Object obj) {
                Callback callback;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048579, this, obj) == null) && (callback = this.mCallback.get()) != null && callback.mIControllerCallback == null) {
                    callback.onPlaybackStateChanged(PlaybackStateCompat.fromPlaybackState(obj));
                }
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onQueueChanged(List<?> list) {
                Callback callback;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || (callback = this.mCallback.get()) == null) {
                    return;
                }
                callback.onQueueChanged(MediaSessionCompat.QueueItem.fromQueueItemList(list));
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onQueueTitleChanged(CharSequence charSequence) {
                Callback callback;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048581, this, charSequence) == null) || (callback = this.mCallback.get()) == null) {
                    return;
                }
                callback.onQueueTitleChanged(charSequence);
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onSessionDestroyed() {
                Callback callback;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (callback = this.mCallback.get()) == null) {
                    return;
                }
                callback.onSessionDestroyed();
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onSessionEvent(String str, Bundle bundle) {
                Callback callback;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLL(1048583, this, str, bundle) == null) || (callback = this.mCallback.get()) == null) {
                    return;
                }
                if (callback.mIControllerCallback == null || Build.VERSION.SDK_INT >= 23) {
                    callback.onSessionEvent(str, bundle);
                }
            }
        }

        /* loaded from: classes.dex */
        public static class StubCompat extends IMediaControllerCallback.Stub {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final WeakReference<Callback> mCallback;

            public StubCompat(Callback callback) {
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
                this.mCallback = new WeakReference<>(callback);
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onCaptioningEnabledChanged(boolean z) throws RemoteException {
                Callback callback;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (callback = this.mCallback.get()) == null) {
                    return;
                }
                callback.postToHandler(11, Boolean.valueOf(z), null);
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onEvent(String str, Bundle bundle) throws RemoteException {
                Callback callback;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bundle) == null) || (callback = this.mCallback.get()) == null) {
                    return;
                }
                callback.postToHandler(1, str, bundle);
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onExtrasChanged(Bundle bundle) throws RemoteException {
                Callback callback;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) || (callback = this.mCallback.get()) == null) {
                    return;
                }
                callback.postToHandler(7, bundle, null);
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                Callback callback;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048579, this, mediaMetadataCompat) == null) || (callback = this.mCallback.get()) == null) {
                    return;
                }
                callback.postToHandler(3, mediaMetadataCompat, null);
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) throws RemoteException {
                Callback callback;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048580, this, playbackStateCompat) == null) || (callback = this.mCallback.get()) == null) {
                    return;
                }
                callback.postToHandler(2, playbackStateCompat, null);
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onQueueChanged(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
                Callback callback;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || (callback = this.mCallback.get()) == null) {
                    return;
                }
                callback.postToHandler(5, list, null);
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onQueueTitleChanged(CharSequence charSequence) throws RemoteException {
                Callback callback;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048582, this, charSequence) == null) || (callback = this.mCallback.get()) == null) {
                    return;
                }
                callback.postToHandler(6, charSequence, null);
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onRepeatModeChanged(int i2) throws RemoteException {
                Callback callback;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || (callback = this.mCallback.get()) == null) {
                    return;
                }
                callback.postToHandler(9, Integer.valueOf(i2), null);
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onSessionDestroyed() throws RemoteException {
                Callback callback;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (callback = this.mCallback.get()) == null) {
                    return;
                }
                callback.postToHandler(8, null, null);
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onSessionReady() throws RemoteException {
                Callback callback;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (callback = this.mCallback.get()) == null) {
                    return;
                }
                callback.postToHandler(13, null, null);
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onShuffleModeChanged(int i2) throws RemoteException {
                Callback callback;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || (callback = this.mCallback.get()) == null) {
                    return;
                }
                callback.postToHandler(12, Integer.valueOf(i2), null);
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onShuffleModeChangedRemoved(boolean z) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                Callback callback;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048588, this, parcelableVolumeInfo) == null) || (callback = this.mCallback.get()) == null) {
                    return;
                }
                callback.postToHandler(4, parcelableVolumeInfo != null ? new PlaybackInfo(parcelableVolumeInfo.volumeType, parcelableVolumeInfo.audioStream, parcelableVolumeInfo.controlType, parcelableVolumeInfo.maxVolume, parcelableVolumeInfo.currentVolume) : null, null);
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
            if (Build.VERSION.SDK_INT >= 21) {
                this.mCallbackObj = MediaControllerCompatApi21.createCallback(new StubApi21(this));
                return;
            }
            StubCompat stubCompat = new StubCompat(this);
            this.mIControllerCallback = stubCompat;
            this.mCallbackObj = stubCompat;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                postToHandler(8, null, null);
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public IMediaControllerCallback getIControllerCallback() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mIControllerCallback : (IMediaControllerCallback) invokeV.objValue;
        }

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

        public void onRepeatModeChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
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

        public void onShuffleModeChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            }
        }

        public void postToHandler(int i2, Object obj, Bundle bundle) {
            MessageHandler messageHandler;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeILL(1048590, this, i2, obj, bundle) == null) || (messageHandler = this.mHandler) == null) {
                return;
            }
            Message obtainMessage = messageHandler.obtainMessage(i2, obj);
            obtainMessage.setData(bundle);
            obtainMessage.sendToTarget();
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

    /* loaded from: classes.dex */
    public static class MediaControllerExtraData extends ComponentActivity.ExtraData {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final MediaControllerCompat mMediaController;

        public MediaControllerExtraData(MediaControllerCompat mediaControllerCompat) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaControllerCompat};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mMediaController = mediaControllerCompat;
        }

        public MediaControllerCompat getMediaController() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mMediaController : (MediaControllerCompat) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public interface MediaControllerImpl {
        void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat);

        void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i2);

        void adjustVolume(int i2, int i3);

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

        int getShuffleMode();

        TransportControls getTransportControls();

        boolean isCaptioningEnabled();

        boolean isSessionReady();

        void registerCallback(Callback callback, Handler handler);

        void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat);

        void sendCommand(String str, Bundle bundle, ResultReceiver resultReceiver);

        void setVolumeTo(int i2, int i3);

        void unregisterCallback(Callback callback);
    }

    @RequiresApi(23)
    /* loaded from: classes.dex */
    public static class MediaControllerImplApi23 extends MediaControllerImplApi21 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MediaControllerImplApi23(Context context, MediaSessionCompat.Token token) throws RemoteException {
            super(context, token);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, token};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (MediaSessionCompat.Token) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi21, android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public TransportControls getTransportControls() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Object transportControls = MediaControllerCompatApi21.getTransportControls(this.mControllerObj);
                if (transportControls != null) {
                    return new TransportControlsApi23(transportControls);
                }
                return null;
            }
            return (TransportControls) invokeV.objValue;
        }
    }

    @RequiresApi(24)
    /* loaded from: classes.dex */
    public static class MediaControllerImplApi24 extends MediaControllerImplApi23 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MediaControllerImplApi24(Context context, MediaSessionCompat.Token token) throws RemoteException {
            super(context, token);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, token};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (MediaSessionCompat.Token) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi23, android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi21, android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public TransportControls getTransportControls() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Object transportControls = MediaControllerCompatApi21.getTransportControls(this.mControllerObj);
                if (transportControls != null) {
                    return new TransportControlsApi24(transportControls);
                }
                return null;
            }
            return (TransportControls) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static final class PlaybackInfo {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int PLAYBACK_TYPE_LOCAL = 1;
        public static final int PLAYBACK_TYPE_REMOTE = 2;
        public transient /* synthetic */ FieldHolder $fh;
        public final int mAudioStream;
        public final int mCurrentVolume;
        public final int mMaxVolume;
        public final int mPlaybackType;
        public final int mVolumeControl;

        public PlaybackInfo(int i2, int i3, int i4, int i5, int i6) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i7 = newInitContext.flag;
                if ((i7 & 1) != 0) {
                    int i8 = i7 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mPlaybackType = i2;
            this.mAudioStream = i3;
            this.mVolumeControl = i4;
            this.mMaxVolume = i5;
            this.mCurrentVolume = i6;
        }

        public int getAudioStream() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mAudioStream : invokeV.intValue;
        }

        public int getCurrentVolume() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mCurrentVolume : invokeV.intValue;
        }

        public int getMaxVolume() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mMaxVolume : invokeV.intValue;
        }

        public int getPlaybackType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mPlaybackType : invokeV.intValue;
        }

        public int getVolumeControl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mVolumeControl : invokeV.intValue;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class TransportControls {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String EXTRA_LEGACY_STREAM_TYPE = "android.media.session.extra.LEGACY_STREAM_TYPE";
        public transient /* synthetic */ FieldHolder $fh;

        public TransportControls() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

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

        public abstract void setRating(RatingCompat ratingCompat);

        public abstract void setRating(RatingCompat ratingCompat, Bundle bundle);

        public abstract void setRepeatMode(int i2);

        public abstract void setShuffleMode(int i2);

        public abstract void skipToNext();

        public abstract void skipToPrevious();

        public abstract void skipToQueueItem(long j);

        public abstract void stop();
    }

    @RequiresApi(23)
    /* loaded from: classes.dex */
    public static class TransportControlsApi23 extends TransportControlsApi21 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TransportControlsApi23(Object obj) {
            super(obj);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControlsApi21, android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromUri(Uri uri, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, uri, bundle) == null) {
                MediaControllerCompatApi23.TransportControls.playFromUri(this.mControlsObj, uri, bundle);
            }
        }
    }

    @RequiresApi(24)
    /* loaded from: classes.dex */
    public static class TransportControlsApi24 extends TransportControlsApi23 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TransportControlsApi24(Object obj) {
            super(obj);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControlsApi21, android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepare() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MediaControllerCompatApi24.TransportControls.prepare(this.mControlsObj);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControlsApi21, android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromMediaId(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bundle) == null) {
                MediaControllerCompatApi24.TransportControls.prepareFromMediaId(this.mControlsObj, str, bundle);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControlsApi21, android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromSearch(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bundle) == null) {
                MediaControllerCompatApi24.TransportControls.prepareFromSearch(this.mControlsObj, str, bundle);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControlsApi21, android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromUri(Uri uri, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, uri, bundle) == null) {
                MediaControllerCompatApi24.TransportControls.prepareFromUri(this.mControlsObj, uri, bundle);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mBinder = iMediaSession;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void fastForward() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.mBinder.fastForward();
                } catch (RemoteException e2) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in fastForward.", e2);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void pause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                try {
                    this.mBinder.pause();
                } catch (RemoteException e2) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in pause.", e2);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void play() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                try {
                    this.mBinder.play();
                } catch (RemoteException e2) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in play.", e2);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromMediaId(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, str, bundle) == null) {
                try {
                    this.mBinder.playFromMediaId(str, bundle);
                } catch (RemoteException e2) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in playFromMediaId.", e2);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromSearch(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, str, bundle) == null) {
                try {
                    this.mBinder.playFromSearch(str, bundle);
                } catch (RemoteException e2) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in playFromSearch.", e2);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromUri(Uri uri, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, uri, bundle) == null) {
                try {
                    this.mBinder.playFromUri(uri, bundle);
                } catch (RemoteException e2) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in playFromUri.", e2);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepare() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                try {
                    this.mBinder.prepare();
                } catch (RemoteException e2) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in prepare.", e2);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromMediaId(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, str, bundle) == null) {
                try {
                    this.mBinder.prepareFromMediaId(str, bundle);
                } catch (RemoteException e2) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in prepareFromMediaId.", e2);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromSearch(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, bundle) == null) {
                try {
                    this.mBinder.prepareFromSearch(str, bundle);
                } catch (RemoteException e2) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in prepareFromSearch.", e2);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromUri(Uri uri, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, uri, bundle) == null) {
                try {
                    this.mBinder.prepareFromUri(uri, bundle);
                } catch (RemoteException e2) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in prepareFromUri.", e2);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void rewind() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                try {
                    this.mBinder.rewind();
                } catch (RemoteException e2) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in rewind.", e2);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void seekTo(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048587, this, j) == null) {
                try {
                    this.mBinder.seekTo(j);
                } catch (RemoteException e2) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in seekTo.", e2);
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
        public void setCaptioningEnabled(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
                try {
                    this.mBinder.setCaptioningEnabled(z);
                } catch (RemoteException e2) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in setCaptioningEnabled.", e2);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRating(RatingCompat ratingCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, ratingCompat) == null) {
                try {
                    this.mBinder.rate(ratingCompat);
                } catch (RemoteException e2) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in setRating.", e2);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRepeatMode(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
                try {
                    this.mBinder.setRepeatMode(i2);
                } catch (RemoteException e2) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in setRepeatMode.", e2);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setShuffleMode(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
                try {
                    this.mBinder.setShuffleMode(i2);
                } catch (RemoteException e2) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in setShuffleMode.", e2);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToNext() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
                try {
                    this.mBinder.next();
                } catch (RemoteException e2) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in skipToNext.", e2);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToPrevious() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
                try {
                    this.mBinder.previous();
                } catch (RemoteException e2) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in skipToPrevious.", e2);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToQueueItem(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048597, this, j) == null) {
                try {
                    this.mBinder.skipToQueueItem(j);
                } catch (RemoteException e2) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in skipToQueueItem.", e2);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void stop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
                try {
                    this.mBinder.stop();
                } catch (RemoteException e2) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in stop.", e2);
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
                } catch (RemoteException e2) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in sendCustomAction.", e2);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRating(RatingCompat ratingCompat, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048592, this, ratingCompat, bundle) == null) {
                try {
                    this.mBinder.rateWithExtras(ratingCompat, bundle);
                } catch (RemoteException e2) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in setRating.", e2);
                }
            }
        }
    }

    public MediaControllerCompat(Context context, @NonNull MediaSessionCompat mediaSessionCompat) {
        MediaControllerImpl mediaControllerImplApi21;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mediaSessionCompat};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mRegisteredCallbacks = new HashSet<>();
        if (mediaSessionCompat != null) {
            MediaSessionCompat.Token sessionToken = mediaSessionCompat.getSessionToken();
            this.mToken = sessionToken;
            MediaControllerImplBase mediaControllerImplBase = null;
            try {
            } catch (RemoteException e2) {
                Log.w(TAG, "Failed to create MediaControllerImpl.", e2);
            }
            if (Build.VERSION.SDK_INT >= 24) {
                mediaControllerImplApi21 = new MediaControllerImplApi24(context, sessionToken);
            } else if (Build.VERSION.SDK_INT >= 23) {
                mediaControllerImplApi21 = new MediaControllerImplApi23(context, sessionToken);
            } else if (Build.VERSION.SDK_INT >= 21) {
                mediaControllerImplApi21 = new MediaControllerImplApi21(context, sessionToken);
            } else {
                mediaControllerImplBase = new MediaControllerImplBase(sessionToken);
                this.mImpl = mediaControllerImplBase;
                return;
            }
            mediaControllerImplBase = mediaControllerImplApi21;
            this.mImpl = mediaControllerImplBase;
            return;
        }
        throw new IllegalArgumentException("session must not be null");
    }

    public static MediaControllerCompat getMediaController(@NonNull Activity activity) {
        InterceptResult invokeL;
        Object mediaController;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, activity)) == null) {
            if (activity instanceof ComponentActivity) {
                MediaControllerExtraData mediaControllerExtraData = (MediaControllerExtraData) ((ComponentActivity) activity).getExtraData(MediaControllerExtraData.class);
                if (mediaControllerExtraData != null) {
                    return mediaControllerExtraData.getMediaController();
                }
                return null;
            } else if (Build.VERSION.SDK_INT < 21 || (mediaController = MediaControllerCompatApi21.getMediaController(activity)) == null) {
                return null;
            } else {
                try {
                    return new MediaControllerCompat(activity, MediaSessionCompat.Token.fromToken(MediaControllerCompatApi21.getSessionToken(mediaController)));
                } catch (RemoteException e2) {
                    Log.e(TAG, "Dead object in getMediaController.", e2);
                    return null;
                }
            }
        }
        return (MediaControllerCompat) invokeL.objValue;
    }

    public static void setMediaController(@NonNull Activity activity, MediaControllerCompat mediaControllerCompat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, activity, mediaControllerCompat) == null) {
            if (activity instanceof ComponentActivity) {
                ((ComponentActivity) activity).putExtraData(new MediaControllerExtraData(mediaControllerCompat));
            }
            if (Build.VERSION.SDK_INT >= 21) {
                MediaControllerCompatApi21.setMediaController(activity, mediaControllerCompat != null ? MediaControllerCompatApi21.fromToken(activity, mediaControllerCompat.getSessionToken().getToken()) : null);
            }
        }
    }

    public static void validateCustomAction(String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65540, null, str, bundle) == null) || str == null) {
            return;
        }
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1348483723) {
            if (hashCode == 503011406 && str.equals(MediaSessionCompat.ACTION_UNFOLLOW)) {
                c2 = 1;
            }
        } else if (str.equals(MediaSessionCompat.ACTION_FOLLOW)) {
            c2 = 0;
        }
        if (c2 == 0 || c2 == 1) {
            if (bundle == null || !bundle.containsKey(MediaSessionCompat.ARGUMENT_MEDIA_ATTRIBUTE)) {
                throw new IllegalArgumentException("An extra field android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE is required for this action " + str + ".");
            }
        }
    }

    public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, mediaDescriptionCompat) == null) {
            this.mImpl.addQueueItem(mediaDescriptionCompat);
        }
    }

    public void adjustVolume(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            this.mImpl.adjustVolume(i2, i3);
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

    public Bundle getExtras() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mImpl.getExtras() : (Bundle) invokeV.objValue;
    }

    public long getFlags() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mImpl.getFlags() : invokeV.longValue;
    }

    public MediaMetadataCompat getMetadata() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mImpl.getMetadata() : (MediaMetadataCompat) invokeV.objValue;
    }

    public String getPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mImpl.getPackageName() : (String) invokeV.objValue;
    }

    public PlaybackInfo getPlaybackInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mImpl.getPlaybackInfo() : (PlaybackInfo) invokeV.objValue;
    }

    public PlaybackStateCompat getPlaybackState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mImpl.getPlaybackState() : (PlaybackStateCompat) invokeV.objValue;
    }

    public List<MediaSessionCompat.QueueItem> getQueue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mImpl.getQueue() : (List) invokeV.objValue;
    }

    public CharSequence getQueueTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mImpl.getQueueTitle() : (CharSequence) invokeV.objValue;
    }

    public int getRatingType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mImpl.getRatingType() : invokeV.intValue;
    }

    public int getRepeatMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mImpl.getRepeatMode() : invokeV.intValue;
    }

    public PendingIntent getSessionActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mImpl.getSessionActivity() : (PendingIntent) invokeV.objValue;
    }

    public MediaSessionCompat.Token getSessionToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mToken : (MediaSessionCompat.Token) invokeV.objValue;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Bundle getSessionToken2Bundle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mToken.getSessionToken2Bundle() : (Bundle) invokeV.objValue;
    }

    public int getShuffleMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mImpl.getShuffleMode() : invokeV.intValue;
    }

    public TransportControls getTransportControls() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mImpl.getTransportControls() : (TransportControls) invokeV.objValue;
    }

    public boolean isCaptioningEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mImpl.isCaptioningEnabled() : invokeV.booleanValue;
    }

    public boolean isSessionReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mImpl.isSessionReady() : invokeV.booleanValue;
    }

    public void registerCallback(@NonNull Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, callback) == null) {
            registerCallback(callback, null);
        }
    }

    public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, mediaDescriptionCompat) == null) {
            this.mImpl.removeQueueItem(mediaDescriptionCompat);
        }
    }

    @Deprecated
    public void removeQueueItemAt(int i2) {
        List<MediaSessionCompat.QueueItem> queue;
        MediaSessionCompat.QueueItem queueItem;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048601, this, i2) == null) || (queue = getQueue()) == null || i2 < 0 || i2 >= queue.size() || (queueItem = queue.get(i2)) == null) {
            return;
        }
        removeQueueItem(queueItem.getDescription());
    }

    public void sendCommand(@NonNull String str, Bundle bundle, ResultReceiver resultReceiver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048602, this, str, bundle, resultReceiver) == null) {
            if (!TextUtils.isEmpty(str)) {
                this.mImpl.sendCommand(str, bundle, resultReceiver);
                return;
            }
            throw new IllegalArgumentException("command must neither be null nor empty");
        }
    }

    public void setVolumeTo(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048603, this, i2, i3) == null) {
            this.mImpl.setVolumeTo(i2, i3);
        }
    }

    public void unregisterCallback(@NonNull Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, callback) == null) {
            if (callback != null) {
                try {
                    this.mRegisteredCallbacks.remove(callback);
                    this.mImpl.unregisterCallback(callback);
                    return;
                } finally {
                    callback.setHandler(null);
                }
            }
            throw new IllegalArgumentException("callback must not be null");
        }
    }

    public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaDescriptionCompat, i2) == null) {
            this.mImpl.addQueueItem(mediaDescriptionCompat, i2);
        }
    }

    public void registerCallback(@NonNull Callback callback, Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, callback, handler) == null) {
            if (callback != null) {
                if (handler == null) {
                    handler = new Handler();
                }
                callback.setHandler(handler);
                this.mImpl.registerCallback(callback, handler);
                this.mRegisteredCallbacks.add(callback);
                return;
            }
            throw new IllegalArgumentException("callback must not be null");
        }
    }

    /* loaded from: classes.dex */
    public static class TransportControlsApi21 extends TransportControls {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Object mControlsObj;

        public TransportControlsApi21(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mControlsObj = obj;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void fastForward() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MediaControllerCompatApi21.TransportControls.fastForward(this.mControlsObj);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void pause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                MediaControllerCompatApi21.TransportControls.pause(this.mControlsObj);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void play() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                MediaControllerCompatApi21.TransportControls.play(this.mControlsObj);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromMediaId(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, str, bundle) == null) {
                MediaControllerCompatApi21.TransportControls.playFromMediaId(this.mControlsObj, str, bundle);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromSearch(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, str, bundle) == null) {
                MediaControllerCompatApi21.TransportControls.playFromSearch(this.mControlsObj, str, bundle);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromUri(Uri uri, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, uri, bundle) == null) {
                if (uri != null && !Uri.EMPTY.equals(uri)) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putParcelable(MediaSessionCompat.ACTION_ARGUMENT_URI, uri);
                    bundle2.putBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, bundle);
                    sendCustomAction(MediaSessionCompat.ACTION_PLAY_FROM_URI, bundle2);
                    return;
                }
                throw new IllegalArgumentException("You must specify a non-empty Uri for playFromUri.");
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepare() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                sendCustomAction(MediaSessionCompat.ACTION_PREPARE, (Bundle) null);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromMediaId(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, str, bundle) == null) {
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
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable(MediaSessionCompat.ACTION_ARGUMENT_URI, uri);
                bundle2.putBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, bundle);
                sendCustomAction(MediaSessionCompat.ACTION_PREPARE_FROM_URI, bundle2);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void rewind() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                MediaControllerCompatApi21.TransportControls.rewind(this.mControlsObj);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void seekTo(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048587, this, j) == null) {
                MediaControllerCompatApi21.TransportControls.seekTo(this.mControlsObj, j);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void sendCustomAction(PlaybackStateCompat.CustomAction customAction, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048588, this, customAction, bundle) == null) {
                MediaControllerCompat.validateCustomAction(customAction.getAction(), bundle);
                MediaControllerCompatApi21.TransportControls.sendCustomAction(this.mControlsObj, customAction.getAction(), bundle);
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
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, ratingCompat) == null) {
                MediaControllerCompatApi21.TransportControls.setRating(this.mControlsObj, ratingCompat != null ? ratingCompat.getRating() : null);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRepeatMode(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
                Bundle bundle = new Bundle();
                bundle.putInt(MediaSessionCompat.ACTION_ARGUMENT_REPEAT_MODE, i2);
                sendCustomAction(MediaSessionCompat.ACTION_SET_REPEAT_MODE, bundle);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setShuffleMode(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
                Bundle bundle = new Bundle();
                bundle.putInt(MediaSessionCompat.ACTION_ARGUMENT_SHUFFLE_MODE, i2);
                sendCustomAction(MediaSessionCompat.ACTION_SET_SHUFFLE_MODE, bundle);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToNext() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
                MediaControllerCompatApi21.TransportControls.skipToNext(this.mControlsObj);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToPrevious() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
                MediaControllerCompatApi21.TransportControls.skipToPrevious(this.mControlsObj);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToQueueItem(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048597, this, j) == null) {
                MediaControllerCompatApi21.TransportControls.skipToQueueItem(this.mControlsObj, j);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void stop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
                MediaControllerCompatApi21.TransportControls.stop(this.mControlsObj);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRating(RatingCompat ratingCompat, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048592, this, ratingCompat, bundle) == null) {
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable(MediaSessionCompat.ACTION_ARGUMENT_RATING, ratingCompat);
                bundle2.putBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, bundle);
                sendCustomAction(MediaSessionCompat.ACTION_SET_RATING, bundle2);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void sendCustomAction(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048589, this, str, bundle) == null) {
                MediaControllerCompat.validateCustomAction(str, bundle);
                MediaControllerCompatApi21.TransportControls.sendCustomAction(this.mControlsObj, str, bundle);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class MediaControllerImplBase implements MediaControllerImpl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public IMediaSession mBinder;
        public TransportControls mTransportControls;

        public MediaControllerImplBase(MediaSessionCompat.Token token) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {token};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                } catch (RemoteException e2) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in addQueueItem.", e2);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void adjustVolume(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
                try {
                    this.mBinder.adjustVolume(i2, i3, null);
                } catch (RemoteException e2) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in adjustVolume.", e2);
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
                    } catch (RemoteException e2) {
                        Log.e(MediaControllerCompat.TAG, "Dead object in dispatchMediaButtonEvent.", e2);
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
                } catch (RemoteException e2) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in getExtras.", e2);
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
                } catch (RemoteException e2) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in getFlags.", e2);
                    return 0L;
                }
            }
            return invokeV.longValue;
        }

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
        public MediaMetadataCompat getMetadata() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                try {
                    return this.mBinder.getMetadata();
                } catch (RemoteException e2) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in getMetadata.", e2);
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
                } catch (RemoteException e2) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in getPackageName.", e2);
                    return null;
                }
            }
            return (String) invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public PlaybackInfo getPlaybackInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                try {
                    ParcelableVolumeInfo volumeAttributes = this.mBinder.getVolumeAttributes();
                    return new PlaybackInfo(volumeAttributes.volumeType, volumeAttributes.audioStream, volumeAttributes.controlType, volumeAttributes.maxVolume, volumeAttributes.currentVolume);
                } catch (RemoteException e2) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in getPlaybackInfo.", e2);
                    return null;
                }
            }
            return (PlaybackInfo) invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public PlaybackStateCompat getPlaybackState() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                try {
                    return this.mBinder.getPlaybackState();
                } catch (RemoteException e2) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in getPlaybackState.", e2);
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
                } catch (RemoteException e2) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in getQueue.", e2);
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
                } catch (RemoteException e2) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in getQueueTitle.", e2);
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
                } catch (RemoteException e2) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in getRatingType.", e2);
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
                } catch (RemoteException e2) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in getRepeatMode.", e2);
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
                } catch (RemoteException e2) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in getSessionActivity.", e2);
                    return null;
                }
            }
            return (PendingIntent) invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public int getShuffleMode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                try {
                    return this.mBinder.getShuffleMode();
                } catch (RemoteException e2) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in getShuffleMode.", e2);
                    return -1;
                }
            }
            return invokeV.intValue;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public TransportControls getTransportControls() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
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
            if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                try {
                    return this.mBinder.isCaptioningEnabled();
                } catch (RemoteException e2) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in isCaptioningEnabled.", e2);
                    return false;
                }
            }
            return invokeV.booleanValue;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public boolean isSessionReady() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void registerCallback(Callback callback, Handler handler) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048596, this, callback, handler) == null) {
                if (callback != null) {
                    try {
                        this.mBinder.asBinder().linkToDeath(callback, 0);
                        this.mBinder.registerCallbackListener((IMediaControllerCallback) callback.mCallbackObj);
                        callback.postToHandler(13, null, null);
                        return;
                    } catch (RemoteException e2) {
                        Log.e(MediaControllerCompat.TAG, "Dead object in registerCallback.", e2);
                        callback.postToHandler(8, null, null);
                        return;
                    }
                }
                throw new IllegalArgumentException("callback may not be null.");
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048597, this, mediaDescriptionCompat) == null) {
                try {
                    if ((this.mBinder.getFlags() & 4) != 0) {
                        this.mBinder.removeQueueItem(mediaDescriptionCompat);
                        return;
                    }
                    throw new UnsupportedOperationException("This session doesn't support queue management operations");
                } catch (RemoteException e2) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in removeQueueItem.", e2);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void sendCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048598, this, str, bundle, resultReceiver) == null) {
                try {
                    this.mBinder.sendCommand(str, bundle, new MediaSessionCompat.ResultReceiverWrapper(resultReceiver));
                } catch (RemoteException e2) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in sendCommand.", e2);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void setVolumeTo(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048599, this, i2, i3) == null) {
                try {
                    this.mBinder.setVolumeTo(i2, i3, null);
                } catch (RemoteException e2) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in setVolumeTo.", e2);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void unregisterCallback(Callback callback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048600, this, callback) == null) {
                if (callback != null) {
                    try {
                        this.mBinder.unregisterCallbackListener((IMediaControllerCallback) callback.mCallbackObj);
                        this.mBinder.asBinder().unlinkToDeath(callback, 0);
                        return;
                    } catch (RemoteException e2) {
                        Log.e(MediaControllerCompat.TAG, "Dead object in unregisterCallback.", e2);
                        return;
                    }
                }
                throw new IllegalArgumentException("callback may not be null.");
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaDescriptionCompat, i2) == null) {
                try {
                    if ((this.mBinder.getFlags() & 4) != 0) {
                        this.mBinder.addQueueItemAt(mediaDescriptionCompat, i2);
                        return;
                    }
                    throw new UnsupportedOperationException("This session doesn't support queue management operations");
                } catch (RemoteException e2) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in addQueueItemAt.", e2);
                }
            }
        }
    }

    @RequiresApi(21)
    /* loaded from: classes.dex */
    public static class MediaControllerImplApi21 implements MediaControllerImpl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HashMap<Callback, ExtraCallback> mCallbackMap;
        public final Object mControllerObj;
        public final Object mLock;
        @GuardedBy("mLock")
        public final List<Callback> mPendingCallbacks;
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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((Handler) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.mMediaControllerImpl = new WeakReference<>(mediaControllerImplApi21);
            }

            @Override // android.os.ResultReceiver
            public void onReceiveResult(int i2, Bundle bundle) {
                MediaControllerImplApi21 mediaControllerImplApi21;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, bundle) == null) || (mediaControllerImplApi21 = this.mMediaControllerImpl.get()) == null || bundle == null) {
                    return;
                }
                synchronized (mediaControllerImplApi21.mLock) {
                    mediaControllerImplApi21.mSessionToken.setExtraBinder(IMediaSession.Stub.asInterface(BundleCompat.getBinder(bundle, MediaSessionCompat.KEY_EXTRA_BINDER)));
                    mediaControllerImplApi21.mSessionToken.setSessionToken2Bundle(bundle.getBundle(MediaSessionCompat.KEY_SESSION_TOKEN2_BUNDLE));
                    mediaControllerImplApi21.processPendingCallbacksLocked();
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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
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
            public void onSessionDestroyed() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
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
        }

        public MediaControllerImplApi21(Context context, MediaSessionCompat.Token token) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, token};
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
            this.mPendingCallbacks = new ArrayList();
            this.mCallbackMap = new HashMap<>();
            this.mSessionToken = token;
            Object fromToken = MediaControllerCompatApi21.fromToken(context, token.getToken());
            this.mControllerObj = fromToken;
            if (fromToken != null) {
                if (this.mSessionToken.getExtraBinder() == null) {
                    requestExtraBinder();
                    return;
                }
                return;
            }
            throw new RemoteException();
        }

        private void requestExtraBinder() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                sendCommand(MediaControllerCompat.COMMAND_GET_EXTRA_BINDER, null, new ExtraBinderRequestResultReceiver(this));
            }
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
        public void adjustVolume(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
                MediaControllerCompatApi21.adjustVolume(this.mControllerObj, i2, i3);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public boolean dispatchMediaButtonEvent(KeyEvent keyEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, keyEvent)) == null) ? MediaControllerCompatApi21.dispatchMediaButtonEvent(this.mControllerObj, keyEvent) : invokeL.booleanValue;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public Bundle getExtras() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? MediaControllerCompatApi21.getExtras(this.mControllerObj) : (Bundle) invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public long getFlags() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? MediaControllerCompatApi21.getFlags(this.mControllerObj) : invokeV.longValue;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public Object getMediaController() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mControllerObj : invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public MediaMetadataCompat getMetadata() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                Object metadata = MediaControllerCompatApi21.getMetadata(this.mControllerObj);
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
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? MediaControllerCompatApi21.getPackageName(this.mControllerObj) : (String) invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public PlaybackInfo getPlaybackInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                Object playbackInfo = MediaControllerCompatApi21.getPlaybackInfo(this.mControllerObj);
                if (playbackInfo != null) {
                    return new PlaybackInfo(MediaControllerCompatApi21.PlaybackInfo.getPlaybackType(playbackInfo), MediaControllerCompatApi21.PlaybackInfo.getLegacyAudioStream(playbackInfo), MediaControllerCompatApi21.PlaybackInfo.getVolumeControl(playbackInfo), MediaControllerCompatApi21.PlaybackInfo.getMaxVolume(playbackInfo), MediaControllerCompatApi21.PlaybackInfo.getCurrentVolume(playbackInfo));
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
                    } catch (RemoteException e2) {
                        Log.e(MediaControllerCompat.TAG, "Dead object in getPlaybackState.", e2);
                    }
                }
                Object playbackState = MediaControllerCompatApi21.getPlaybackState(this.mControllerObj);
                if (playbackState != null) {
                    return PlaybackStateCompat.fromPlaybackState(playbackState);
                }
                return null;
            }
            return (PlaybackStateCompat) invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public List<MediaSessionCompat.QueueItem> getQueue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                List<Object> queue = MediaControllerCompatApi21.getQueue(this.mControllerObj);
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? MediaControllerCompatApi21.getQueueTitle(this.mControllerObj) : (CharSequence) invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public int getRatingType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                if (Build.VERSION.SDK_INT < 22 && this.mSessionToken.getExtraBinder() != null) {
                    try {
                        return this.mSessionToken.getExtraBinder().getRatingType();
                    } catch (RemoteException e2) {
                        Log.e(MediaControllerCompat.TAG, "Dead object in getRatingType.", e2);
                    }
                }
                return MediaControllerCompatApi21.getRatingType(this.mControllerObj);
            }
            return invokeV.intValue;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public int getRepeatMode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                if (this.mSessionToken.getExtraBinder() != null) {
                    try {
                        return this.mSessionToken.getExtraBinder().getRepeatMode();
                    } catch (RemoteException e2) {
                        Log.e(MediaControllerCompat.TAG, "Dead object in getRepeatMode.", e2);
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? MediaControllerCompatApi21.getSessionActivity(this.mControllerObj) : (PendingIntent) invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public int getShuffleMode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                if (this.mSessionToken.getExtraBinder() != null) {
                    try {
                        return this.mSessionToken.getExtraBinder().getShuffleMode();
                    } catch (RemoteException e2) {
                        Log.e(MediaControllerCompat.TAG, "Dead object in getShuffleMode.", e2);
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
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                Object transportControls = MediaControllerCompatApi21.getTransportControls(this.mControllerObj);
                if (transportControls != null) {
                    return new TransportControlsApi21(transportControls);
                }
                return null;
            }
            return (TransportControls) invokeV.objValue;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public boolean isCaptioningEnabled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                if (this.mSessionToken.getExtraBinder() != null) {
                    try {
                        return this.mSessionToken.getExtraBinder().isCaptioningEnabled();
                    } catch (RemoteException e2) {
                        Log.e(MediaControllerCompat.TAG, "Dead object in isCaptioningEnabled.", e2);
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mSessionToken.getExtraBinder() != null : invokeV.booleanValue;
        }

        @GuardedBy("mLock")
        public void processPendingCallbacksLocked() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || this.mSessionToken.getExtraBinder() == null) {
                return;
            }
            for (Callback callback : this.mPendingCallbacks) {
                ExtraCallback extraCallback = new ExtraCallback(callback);
                this.mCallbackMap.put(callback, extraCallback);
                callback.mIControllerCallback = extraCallback;
                try {
                    this.mSessionToken.getExtraBinder().registerCallbackListener(extraCallback);
                    callback.postToHandler(13, null, null);
                } catch (RemoteException e2) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in registerCallback.", e2);
                }
            }
            this.mPendingCallbacks.clear();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public final void registerCallback(Callback callback, Handler handler) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048597, this, callback, handler) == null) {
                MediaControllerCompatApi21.registerCallback(this.mControllerObj, callback.mCallbackObj, handler);
                synchronized (this.mLock) {
                    if (this.mSessionToken.getExtraBinder() != null) {
                        ExtraCallback extraCallback = new ExtraCallback(callback);
                        this.mCallbackMap.put(callback, extraCallback);
                        callback.mIControllerCallback = extraCallback;
                        try {
                            this.mSessionToken.getExtraBinder().registerCallbackListener(extraCallback);
                            callback.postToHandler(13, null, null);
                        } catch (RemoteException e2) {
                            Log.e(MediaControllerCompat.TAG, "Dead object in registerCallback.", e2);
                        }
                    } else {
                        callback.mIControllerCallback = null;
                        this.mPendingCallbacks.add(callback);
                    }
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048598, this, mediaDescriptionCompat) == null) {
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
        public void sendCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048599, this, str, bundle, resultReceiver) == null) {
                MediaControllerCompatApi21.sendCommand(this.mControllerObj, str, bundle, resultReceiver);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void setVolumeTo(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048600, this, i2, i3) == null) {
                MediaControllerCompatApi21.setVolumeTo(this.mControllerObj, i2, i3);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public final void unregisterCallback(Callback callback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048601, this, callback) == null) {
                MediaControllerCompatApi21.unregisterCallback(this.mControllerObj, callback.mCallbackObj);
                synchronized (this.mLock) {
                    if (this.mSessionToken.getExtraBinder() != null) {
                        try {
                            ExtraCallback remove = this.mCallbackMap.remove(callback);
                            if (remove != null) {
                                callback.mIControllerCallback = null;
                                this.mSessionToken.getExtraBinder().unregisterCallbackListener(remove);
                            }
                        } catch (RemoteException e2) {
                            Log.e(MediaControllerCompat.TAG, "Dead object in unregisterCallback.", e2);
                        }
                    } else {
                        this.mPendingCallbacks.remove(callback);
                    }
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaDescriptionCompat, i2) == null) {
                if ((getFlags() & 4) != 0) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION, mediaDescriptionCompat);
                    bundle.putInt(MediaControllerCompat.COMMAND_ARGUMENT_INDEX, i2);
                    sendCommand(MediaControllerCompat.COMMAND_ADD_QUEUE_ITEM_AT, bundle, null);
                    return;
                }
                throw new UnsupportedOperationException("This session doesn't support queue management operations");
            }
        }
    }

    public Object getMediaController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mImpl.getMediaController() : invokeV.objValue;
    }

    public MediaControllerCompat(Context context, @NonNull MediaSessionCompat.Token token) throws RemoteException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, token};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mRegisteredCallbacks = new HashSet<>();
        if (token != null) {
            this.mToken = token;
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 24) {
                this.mImpl = new MediaControllerImplApi24(context, token);
                return;
            } else if (i4 >= 23) {
                this.mImpl = new MediaControllerImplApi23(context, token);
                return;
            } else if (i4 >= 21) {
                this.mImpl = new MediaControllerImplApi21(context, token);
                return;
            } else {
                this.mImpl = new MediaControllerImplBase(token);
                return;
            }
        }
        throw new IllegalArgumentException("sessionToken must not be null");
    }
}
