package com.baidu.searchbox.network.outback.callback;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.core.Response;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public abstract class CookieResponseCallback<T> extends ResponseCallback<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CookieResponseCallback() {
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

    public abstract void handleCookies(List<String> list) throws Exception;

    @Override // com.baidu.searchbox.network.outback.callback.ResponseCallback
    public T parseResponse(Response response, int i) throws Exception {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i)) == null) {
            handleCookies(response.headers("Set-Cookie"));
            return parseResponseAfterHandleCookie(response, i);
        }
        return (T) invokeLI.objValue;
    }

    public abstract T parseResponseAfterHandleCookie(Response response, int i) throws Exception;
}
