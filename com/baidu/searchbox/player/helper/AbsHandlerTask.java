package com.baidu.searchbox.player.helper;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public abstract class AbsHandlerTask implements ITimerTask {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int REFRESH_ACTION = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final PrivateHandler mHandler;
    public int mInterval;

    /* loaded from: classes2.dex */
    public class PrivateHandler extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsHandlerTask this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PrivateHandler(AbsHandlerTask absHandlerTask, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absHandlerTask, looper};
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
            this.this$0 = absHandlerTask;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 1) {
                this.this$0.doTask();
                sendMessageDelayed(obtainMessage(1), this.this$0.mInterval);
            }
        }
    }

    public AbsHandlerTask() {
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
        this.mHandler = new PrivateHandler(this, Looper.getMainLooper());
        this.mInterval = 500;
    }

    @Override // com.baidu.searchbox.player.helper.ITimerTask
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mHandler.removeMessages(1);
        }
    }

    @Override // com.baidu.searchbox.player.helper.ITimerTask
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            cancel();
            this.mHandler.obtainMessage(1).sendToTarget();
        }
    }

    @Override // com.baidu.searchbox.player.helper.ITimerTask
    public void setInterval(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && i > 0) {
            this.mInterval = i;
        }
    }
}
