package com.baidu.searchbox.network.support.okhttp.converters;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
/* loaded from: classes2.dex */
public class RequestConverter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public RequestConverter() {
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
            Map tags = request.getTags();
            RequestBody requestBody = null;
            if (request.body() != null) {
                requestBody = RequestBodyConverter.toOks(request.body());
            }
            builder.method(method, requestBody);
            builder.url(oks);
            if (tags != null) {
                for (Map.Entry entry : tags.entrySet()) {
                    builder.tag((Class) entry.getKey(), entry.getValue());
                }
            }
            builder.tag(com.baidu.searchbox.network.outback.core.Request.class, request);
            return builder.build();
        }
        return (Request) invokeL.objValue;
    }
}
