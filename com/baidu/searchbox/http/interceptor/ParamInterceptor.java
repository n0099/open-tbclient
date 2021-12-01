package com.baidu.searchbox.http.interceptor;

import com.baidu.searchbox.http.request.IAsyncRequestParamsHandler;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
/* loaded from: classes9.dex */
public class ParamInterceptor implements Interceptor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IAsyncRequestParamsHandler paramsHandler;

    public ParamInterceptor(IAsyncRequestParamsHandler iAsyncRequestParamsHandler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iAsyncRequestParamsHandler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.paramsHandler = iAsyncRequestParamsHandler;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, chain)) == null) {
            Request request = chain.request();
            if (this.paramsHandler != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                this.paramsHandler.onHandleParams(linkedHashMap);
                if (!linkedHashMap.isEmpty()) {
                    HttpUrl.Builder newBuilder = request.url().newBuilder();
                    for (Map.Entry entry : linkedHashMap.entrySet()) {
                        newBuilder.setQueryParameter((String) entry.getKey(), (String) entry.getValue());
                    }
                    request = request.newBuilder().url(newBuilder.build()).build();
                }
            }
            return chain.proceed(request);
        }
        return (Response) invokeL.objValue;
    }
}
