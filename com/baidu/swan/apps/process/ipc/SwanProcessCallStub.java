package com.baidu.swan.apps.process.ipc;

import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.IAsyncProcessCallback;
import com.baidu.swan.apps.IProcessBridge;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ww2;
/* loaded from: classes2.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mHandler = handler;
    }

    @Override // com.baidu.swan.apps.IProcessBridge
    public void callMainProcessAsync(String str, int i, IAsyncProcessCallback iAsyncProcessCallback) throws RemoteException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i, iAsyncProcessCallback) == null) {
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
            return ww2.e(str, bundle);
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
