package com.baidu.searchbox.network.support.okhttp.converters;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import okhttp3.HttpUrl;
import okhttp3.Request;
/* loaded from: classes4.dex */
public class RequestConverter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public RequestConverter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static Request toOks(com.baidu.searchbox.network.outback.core.Request request) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, request)) == null) {
            ConverterUtils.requireNonNull(request, "request should not be null");
            request.getNetworkStatRecord().netEngine = 6;
            Request.Builder builder = new Request.Builder();
            HttpUrl oks = HttpUrlConverter.toOks(request.url());
            String method = request.method();
            if (request.headers() != null) {
                builder.headers(HeadersConverter.toOks(request.headers()));
            }
            Map<Class<?>, Object> tags = request.getTags();
            builder.method(method, request.body() != null ? RequestBodyConverter.toOks(request.body()) : null);
            builder.url(oks);
            if (tags != null) {
                for (Map.Entry<Class<?>, Object> entry : tags.entrySet()) {
                    builder.tag(entry.getKey(), entry.getValue());
                }
            }
            builder.tag(com.baidu.searchbox.network.outback.core.Request.class, request);
            return builder.build();
        }
        return (Request) invokeL.objValue;
    }
}
