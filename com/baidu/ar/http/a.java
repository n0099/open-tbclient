package com.baidu.ar.http;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.ihttp.HttpException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class a implements l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Object mLock;
    public com.baidu.ar.ihttp.a qF;
    public HttpException qG;
    public volatile boolean qH;

    public a(HttpException httpException, com.baidu.ar.ihttp.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {httpException, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLock = new Object();
        this.qH = false;
        this.qG = httpException;
        this.qF = aVar;
    }

    @Override // com.baidu.ar.http.l
    public void cancel() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.qH) {
            return;
        }
        synchronized (this.mLock) {
            this.qH = true;
        }
    }

    @Override // com.baidu.ar.http.l
    public i eH() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (i) invokeV.objValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this.mLock) {
                if (this.qH) {
                    return;
                }
                com.baidu.ar.ihttp.a aVar = this.qF;
                if (aVar != null) {
                    aVar.a(this.qG);
                }
            }
        }
    }
}
