package com.baidu.searchbox.player.message;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.interfaces.INeuron;
import com.baidu.searchbox.player.interfaces.IVideoEventInterceptor;
import com.baidu.searchbox.player.session.VideoSession;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.searchbox.player.utils.MainThreadUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes9.dex */
public class HandlerMessenger implements IMessenger {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int KEY_MESSAGE_EVENT = 153;
    public static final String TAG = "HandlerMessenger";
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public PrivateHandler mHandler;
    public HandlerThread mHandlerThread;
    public IVideoEventInterceptor mInterceptor;
    public ConcurrentHashMap<Integer, CopyOnWriteArrayList<INeuron>> mSubscribers;
    public VideoSession mVideoSession;

    /* loaded from: classes9.dex */
    public class PrivateHandler extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<IVideoEventInterceptor> mWeakControl;
        public final /* synthetic */ HandlerMessenger this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PrivateHandler(HandlerMessenger handlerMessenger, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {handlerMessenger, looper};
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
            this.this$0 = handlerMessenger;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean handleInterceptorEvent(VideoEvent videoEvent) {
            InterceptResult invokeL;
            IVideoEventInterceptor iVideoEventInterceptor;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, videoEvent)) == null) {
                WeakReference<IVideoEventInterceptor> weakReference = this.mWeakControl;
                if (weakReference == null || (iVideoEventInterceptor = weakReference.get()) == null || iVideoEventInterceptor.getInterceptorLayer() == videoEvent.getSender() || !this.this$0.mInterceptor.onInterceptorEvent(videoEvent.getAction())) {
                    return false;
                }
                videoEvent.recycle();
                return true;
            }
            return invokeL.booleanValue;
        }

        public void clearWeakControl() {
            WeakReference<IVideoEventInterceptor> weakReference;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (weakReference = this.mWeakControl) == null) {
                return;
            }
            weakReference.clear();
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) {
                super.handleMessage(message);
                Object obj = message.obj;
                if (obj instanceof VideoEvent) {
                    MainThreadUtil.runOnUiThread(new Runnable(this, (VideoEvent) obj) { // from class: com.baidu.searchbox.player.message.HandlerMessenger.PrivateHandler.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ PrivateHandler this$1;
                        public final /* synthetic */ VideoEvent val$event;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, r7};
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
                            this.val$event = r7;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$1.handleInterceptorEvent(this.val$event)) {
                                return;
                            }
                            this.this$1.this$0.dispatchEvent(this.val$event);
                        }
                    });
                }
            }
        }

        public void setWeakControl(@Nullable IVideoEventInterceptor iVideoEventInterceptor) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iVideoEventInterceptor) == null) {
                this.mWeakControl = new WeakReference<>(iVideoEventInterceptor);
            }
        }
    }

    public HandlerMessenger(@NonNull VideoSession videoSession) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {videoSession};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mSubscribers = new ConcurrentHashMap<>();
        this.mVideoSession = videoSession;
        HandlerThread handlerThread = new HandlerThread(TAG);
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mHandler = new PrivateHandler(this, this.mHandlerThread.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchEvent(VideoEvent videoEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, videoEvent) == null) {
            BdVideoLog.d(this + " dispatch event :" + videoEvent);
            this.mVideoSession.getState().receivePlayerEvent(videoEvent);
            if (this.mVideoSession.getTargetPlayer() != null) {
                this.mVideoSession.getTargetPlayer().getPlayerCallbackManager().dispatchPlayerAction(videoEvent);
            }
            CopyOnWriteArrayList<INeuron> copyOnWriteArrayList = this.mSubscribers.get(Integer.valueOf(videoEvent.getType()));
            if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
                return;
            }
            Iterator<INeuron> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                INeuron next = it.next();
                if (!videoEvent.filter(next)) {
                    switch (videoEvent.getType()) {
                        case -1:
                        case 6:
                            next.onVideoEventNotify(videoEvent);
                            continue;
                        case 1:
                            next.onSystemEventNotify(videoEvent);
                            continue;
                        case 2:
                            next.onControlEventNotify(videoEvent);
                            continue;
                        case 3:
                            next.onLayerEventNotify(videoEvent);
                            continue;
                        case 4:
                            next.onPlayerEventNotify(videoEvent);
                            continue;
                        case 5:
                            next.onPlayerStatusChanged((PlayerStatus) videoEvent.getExtra(2), (PlayerStatus) videoEvent.getExtra(1));
                            continue;
                    }
                }
            }
        }
    }

    @Override // com.baidu.searchbox.player.message.IMessenger
    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? TAG : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.player.message.IMessenger
    public void notifyEvent(@NonNull VideoEvent videoEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoEvent) == null) {
            BdVideoLog.d(this + " notifyEvent " + videoEvent);
            if (videoEvent.getPriority() == 1) {
                dispatchEvent(videoEvent);
                videoEvent.recycle();
                return;
            }
            PrivateHandler privateHandler = this.mHandler;
            if (privateHandler != null) {
                privateHandler.obtainMessage(153, videoEvent).sendToTarget();
            }
        }
    }

    @Override // com.baidu.searchbox.player.message.IMessenger
    public void register(int i2, @NonNull INeuron iNeuron) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, iNeuron) == null) {
            CopyOnWriteArrayList<INeuron> copyOnWriteArrayList = this.mSubscribers.get(Integer.valueOf(i2));
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            }
            if (!copyOnWriteArrayList.contains(iNeuron)) {
                copyOnWriteArrayList.add(iNeuron);
            }
            this.mSubscribers.put(Integer.valueOf(i2), copyOnWriteArrayList);
        }
    }

    @Override // com.baidu.searchbox.player.message.IMessenger
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.mSubscribers.clear();
            this.mHandlerThread.quit();
            PrivateHandler privateHandler = this.mHandler;
            if (privateHandler != null) {
                privateHandler.clearWeakControl();
                this.mHandler.removeMessages(153);
            }
            this.mHandler = null;
            this.mInterceptor = null;
        }
    }

    @Override // com.baidu.searchbox.player.message.IMessenger
    public void setInterceptor(IVideoEventInterceptor iVideoEventInterceptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iVideoEventInterceptor) == null) {
            this.mInterceptor = iVideoEventInterceptor;
            PrivateHandler privateHandler = this.mHandler;
            if (privateHandler != null) {
                privateHandler.setWeakControl(iVideoEventInterceptor);
            }
        }
    }

    @Override // com.baidu.searchbox.player.message.IMessenger
    public void unregister(INeuron iNeuron) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, iNeuron) == null) {
            for (CopyOnWriteArrayList<INeuron> copyOnWriteArrayList : this.mSubscribers.values()) {
                copyOnWriteArrayList.remove(iNeuron);
            }
        }
    }
}
