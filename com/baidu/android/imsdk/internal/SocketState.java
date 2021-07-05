package com.baidu.android.imsdk.internal;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
/* loaded from: classes.dex */
public class SocketState {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public InputStream mInputStream;
    public OutputStream mOutputStream;
    public Socket mSocket;
    public Boolean mSocketCreateOk;
    public Boolean mSocketEnvOk;
    public Integer mSocketId;

    public SocketState() {
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
        this.mSocketId = null;
        Boolean bool = Boolean.FALSE;
        this.mSocketCreateOk = bool;
        this.mSocketEnvOk = bool;
        this.mSocket = null;
        this.mInputStream = null;
        this.mOutputStream = null;
    }
}
