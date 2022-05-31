package com.baidu.lcp.sdk.connect;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.u60;
import com.repackage.v60;
import com.repackage.w60;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class QuicMessageHandler extends v60 implements QuicEventCallbackListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-179316196, "Lcom/baidu/lcp/sdk/connect/QuicMessageHandler;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-179316196, "Lcom/baidu/lcp/sdk/connect/QuicMessageHandler;");
                return;
            }
        }
        System.loadLibrary("native-lib");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuicMessageHandler(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        initGlobalRef(this);
    }

    @Override // com.repackage.v60
    public InputStream b() throws EOFException, IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (InputStream) invokeV.objValue;
    }

    @Override // com.repackage.v60
    public void c(w60 w60Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, w60Var) == null) {
        }
    }

    public native void closeStream(int i);

    @Override // com.repackage.v60
    public boolean d() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.v60
    public w60 e(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, str, i)) == null) {
            return null;
        }
        return (w60) invokeLI.objValue;
    }

    public native void enableQuicCache(boolean z, String str);

    @Override // com.repackage.v60
    public void f(u60 u60Var) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, u60Var) == null) {
        }
    }

    public native void initGlobalRef(QuicEventCallbackListener quicEventCallbackListener);

    public native int sendMsg(byte[] bArr);

    public native int startConnect(String str, String str2);

    public native int stopConnect();
}
