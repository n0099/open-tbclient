package com.baidu.ar.http;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.ihttp.IHttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class HttpRequestFactory implements com.baidu.ar.ihttp.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile e ra;

    public HttpRequestFactory() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public e getExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.ra == null) {
                synchronized (this) {
                    if (this.ra == null) {
                        this.ra = new e(2, 5, 1000, 60L);
                    }
                }
            }
            return this.ra;
        }
        return (e) invokeV.objValue;
    }

    @Override // com.baidu.ar.ihttp.b
    public IHttpRequest newRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            f fVar = new f(this);
            fVar.setCharset(d.qO);
            fVar.setConnectionTimeout(2000);
            fVar.setReadTimeout(30000);
            fVar.setUseCache(false);
            fVar.addHeaders(d.qP);
            return fVar;
        }
        return (IHttpRequest) invokeV.objValue;
    }

    @Override // com.baidu.ar.ihttp.b
    public void release() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.ra == null) {
            return;
        }
        this.ra.shutdown();
        this.ra = null;
    }
}
