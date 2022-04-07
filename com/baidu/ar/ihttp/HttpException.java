package com.baidu.ar.ihttp;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
/* loaded from: classes.dex */
public class HttpException extends Exception {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int HTTP_ERROR = 4;
    public static final int INVOKE_ERROR = 3;
    public static final int LIB_ERROR = 2;
    public static final int NET_ERROR = 1;
    public static final int UNKNOWN_ERROR = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public int rj;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpException(int i, Exception exc) {
        super(exc);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), exc};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Throwable) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.rj = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpException(int i, String str) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.rj = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpException(IOException iOException) {
        super(iOException);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iOException};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Throwable) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        a(iOException);
    }

    private void a(IOException iOException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, iOException) == null) {
            this.rj = ((iOException instanceof ConnectException) || (iOException instanceof SocketTimeoutException) || (iOException instanceof NoRouteToHostException) || (iOException instanceof UnknownHostException)) ? 1 : iOException instanceof IOException ? -1 : 2;
        }
    }

    public int getCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.rj : invokeV.intValue;
    }
}
