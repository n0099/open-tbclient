package com.baidu.searchbox.http.request;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import okhttp3.RequestBody;
/* loaded from: classes2.dex */
public abstract class HttpCommonRequestBuilder extends HttpRequestBuilder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RequestBody requestBody;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpCommonRequestBuilder(AbstractHttpManager abstractHttpManager) {
        super(abstractHttpManager);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {abstractHttpManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((AbstractHttpManager) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpCommonRequestBuilder(HttpCommonRequest httpCommonRequest, AbstractHttpManager abstractHttpManager) {
        super(httpCommonRequest, abstractHttpManager);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {httpCommonRequest, abstractHttpManager};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((HttpRequest) objArr2[0], (AbstractHttpManager) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.requestBody = httpCommonRequest.requestBody;
    }

    public HttpCommonRequestBuilder requestBody(RequestBody requestBody) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, requestBody)) == null) {
            this.requestBody = requestBody;
            return this;
        }
        return (HttpCommonRequestBuilder) invokeL.objValue;
    }
}
