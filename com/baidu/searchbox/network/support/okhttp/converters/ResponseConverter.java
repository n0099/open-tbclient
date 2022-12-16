package com.baidu.searchbox.network.support.okhttp.converters;

import androidx.annotation.NonNull;
import com.baidu.searchbox.network.outback.core.Request;
import com.baidu.searchbox.network.outback.core.Response;
import com.baidu.searchbox.network.outback.statistics.NetworkStatRecord;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import okhttp3.Protocol;
/* loaded from: classes3.dex */
public class ResponseConverter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ResponseConverter() {
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

    public static Response fromOks(@NonNull Request request, @NonNull okhttp3.Response response) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, request, response)) == null) {
            Response.Builder builder = new Response.Builder();
            builder.protocol(ProtocolConverter.fromOks(response.protocol()));
            builder.code(response.code());
            builder.message(response.message());
            builder.headers(HeadersConverter.fromOks(response.headers()));
            if (response.body() != null) {
                builder.body(ResponseBodyConverter.fromOks(response.body()));
            }
            builder.sentRequestAtMillis(response.sentRequestAtMillis());
            builder.receivedResponseAtMillis(response.receivedResponseAtMillis());
            if (response.request() != null && response.request().tag(Request.class) != null) {
                builder.request((Request) response.request().tag(Request.class));
                builder.statRecord(((Request) response.request().tag(Request.class)).getNetworkStatRecord());
            } else {
                builder.request(request);
                builder.statRecord(request.getNetworkStatRecord());
            }
            Response build = builder.build();
            updateResponseToNetworkRecord(build, response);
            if (response.cacheResponse() != null) {
                builder.cacheResponse(fromOks(request, response.cacheResponse()));
            }
            if (response.networkResponse() != null) {
                builder.networkResponse(fromOks(request, response.networkResponse()));
            }
            if (response.priorResponse() != null) {
                builder.priorResponse(fromOks(request, response.priorResponse()));
            }
            return build;
        }
        return (Response) invokeLL.objValue;
    }

    public static void updateResponseToNetworkRecord(Response response, okhttp3.Response response2) {
        String protocol;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, response, response2) == null) {
            response.getStatRecord().statusCode = response2.code();
            Protocol protocol2 = response2.protocol();
            NetworkStatRecord statRecord = response.getStatRecord();
            if (protocol2 == null) {
                protocol = "unknown";
            } else {
                protocol = protocol2.toString();
            }
            statRecord.protocol = protocol;
        }
    }
}
