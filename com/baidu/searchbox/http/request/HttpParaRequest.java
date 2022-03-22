package com.baidu.searchbox.http.request;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.request.HttpRequestParasBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
/* loaded from: classes4.dex */
public abstract class HttpParaRequest<T extends HttpRequestParasBuilder> extends HttpRequest<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinkedHashMap<String, String> params;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpParaRequest(T t) {
        super(t);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((HttpRequestBuilder) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.searchbox.http.request.HttpParaRequest<T extends com.baidu.searchbox.http.request.HttpRequestParasBuilder> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    public /* bridge */ /* synthetic */ void initExtraHttpRequest(HttpRequestBuilder httpRequestBuilder) {
        initExtraHttpRequest((HttpParaRequest<T>) ((HttpRequestParasBuilder) httpRequestBuilder));
    }

    public void initExtraHttpRequest(T t) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) || t.params == null) {
            return;
        }
        this.params = new LinkedHashMap<>(t.params);
    }
}
