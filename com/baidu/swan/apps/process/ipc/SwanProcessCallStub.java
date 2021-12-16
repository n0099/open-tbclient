package com.baidu.swan.apps.process.ipc;

import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import c.a.q0.a.y1.b.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.IAsyncProcessCallback;
import com.baidu.swan.apps.IProcessBridge;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class SwanProcessCallStub extends IProcessBridge.Stub {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Handler mHandler;

    public SwanProcessCallStub(Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {handler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mHandler = handler;
    }

    @Override // com.baidu.swan.apps.IProcessBridge
    public void callMainProcessAsync(String str, int i2, IAsyncProcessCallback iAsyncProcessCallback) throws RemoteException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i2, iAsyncProcessCallback) == null) {
        }
    }

    @Override // com.baidu.swan.apps.IProcessBridge
    @WorkerThread
    public Bundle callMainProcessSync(String str, Bundle bundle) throws RemoteException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bundle)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return e.e(str, bundle);
        }
        return (Bundle) invokeLL.objValue;
    }

    @Override // com.baidu.swan.apps.IProcessBridge
    @WorkerThread
    public void send(Message message) throws RemoteException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) || message == null || this.mHandler == null) {
            return;
        }
        message.sendingUid = Binder.getCallingUid();
        this.mHandler.sendMessage(message);
    }
}
