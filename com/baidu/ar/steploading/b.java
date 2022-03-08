package com.baidu.ar.steploading;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.callback.ICallback;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.callback.IError;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b<T> extends com.baidu.ar.e.a<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ICallback xv;
    public IError xw;

    public b(ICallback iCallback, IError iError) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iCallback, iError};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.xv = iCallback;
        this.xw = iError;
    }

    @Override // com.baidu.ar.e.a
    public void a(int i2, String str, IError iError) {
        IError iError2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(1048576, this, i2, str, iError) == null) || (iError2 = this.xw) == null) {
            return;
        }
        iError2.onError(i2, str, null);
    }

    @Override // com.baidu.ar.e.a
    public void a(T t, ICallbackWith<T> iCallbackWith, IError iError) {
        ICallback iCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t, iCallbackWith, iError) == null) || (iCallback = this.xv) == null) {
            return;
        }
        iCallback.run();
    }

    @Override // com.baidu.ar.e.a
    public void fp() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }
}
