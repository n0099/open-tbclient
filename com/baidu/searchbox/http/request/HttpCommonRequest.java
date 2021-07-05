package com.baidu.searchbox.http.request;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.request.HttpCommonRequestBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import okhttp3.MediaType;
import okhttp3.RequestBody;
/* loaded from: classes3.dex */
public abstract class HttpCommonRequest<T extends HttpCommonRequestBuilder> extends HttpRequest<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RequestBody requestBody;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpCommonRequest(T t) {
        super(t);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((HttpRequestBuilder) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.searchbox.http.request.HttpRequest
    public RequestBody buildOkRequestBody() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            RequestBody requestBody = this.requestBody;
            return requestBody != null ? requestBody : RequestBody.create((MediaType) null, new byte[0]);
        }
        return (RequestBody) invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.searchbox.http.request.HttpCommonRequest<T extends com.baidu.searchbox.http.request.HttpCommonRequestBuilder> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    public /* bridge */ /* synthetic */ void initExtraHttpRequest(HttpRequestBuilder httpRequestBuilder) {
        initExtraHttpRequest((HttpCommonRequest<T>) ((HttpCommonRequestBuilder) httpRequestBuilder));
    }

    public void initExtraHttpRequest(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
            this.requestBody = t.requestBody;
        }
    }
}
