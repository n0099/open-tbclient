package com.baidu.searchbox.player.message;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.utils.MainThreadUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class HandlerMessenger extends AbsMessenger {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int KEY_MESSAGE_EVENT = 153;
    public static final String TAG = "HandlerMessenger";
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public PrivateHandler mHandler;
    public final HandlerThread mHandlerThread;

    /* loaded from: classes4.dex */
    public class PrivateHandler extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = handlerMessenger;
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
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
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
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
                            if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$1.this$0.isNeedIntercept(this.val$event)) {
                                return;
                            }
                            this.this$1.this$0.dispatchEvent(this.val$event);
                        }
                    });
                }
            }
        }
    }

    public HandlerMessenger() {
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
        HandlerThread handlerThread = new HandlerThread(TAG);
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mHandler = new PrivateHandler(this, this.mHandlerThread.getLooper());
    }

    @Override // com.baidu.searchbox.player.message.IMessenger
    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? TAG : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.player.message.AbsMessenger
    public void publishEventToQueue(@NonNull VideoEvent videoEvent) {
        PrivateHandler privateHandler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoEvent) == null) || (privateHandler = this.mHandler) == null) {
            return;
        }
        privateHandler.obtainMessage(153, videoEvent).sendToTarget();
    }

    @Override // com.baidu.searchbox.player.message.AbsMessenger, com.baidu.searchbox.player.message.IMessenger
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.release();
            this.mHandlerThread.quit();
            PrivateHandler privateHandler = this.mHandler;
            if (privateHandler != null) {
                privateHandler.removeMessages(153);
            }
            this.mHandler = null;
        }
    }
}
