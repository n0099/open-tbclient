package com.baidu.mobads.container;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class XAdBasicHandler extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public OnMessageListener mOnMessageListener;

    /* loaded from: classes5.dex */
    public interface OnMessageListener {
        void onMessage(Message message);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XAdBasicHandler(Looper looper, OnMessageListener onMessageListener) {
        super(looper);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {looper, onMessageListener};
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
        this.mOnMessageListener = onMessageListener;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        OnMessageListener onMessageListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || (onMessageListener = this.mOnMessageListener) == null) {
            return;
        }
        onMessageListener.onMessage(message);
    }
}
