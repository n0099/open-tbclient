package com.baidu.mobstat.dxmpay.util;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;
/* loaded from: classes5.dex */
public class OkHttpRequestManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class GzipRequestInterceptor implements Interceptor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OkHttpRequestManager this$0;

        public GzipRequestInterceptor(OkHttpRequestManager okHttpRequestManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {okHttpRequestManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = okHttpRequestManager;
        }

        private RequestBody forceContentLength(RequestBody requestBody) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, requestBody)) == null) {
                Buffer buffer = new Buffer();
                requestBody.writeTo(buffer);
                return new RequestBody(this, requestBody, buffer) { // from class: com.baidu.mobstat.dxmpay.util.OkHttpRequestManager.GzipRequestInterceptor.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ GzipRequestInterceptor this$1;
                    public final /* synthetic */ Buffer val$buffer;
                    public final /* synthetic */ RequestBody val$requestBody;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, requestBody, buffer};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                        this.val$requestBody = requestBody;
                        this.val$buffer = buffer;
                    }

                    @Override // okhttp3.RequestBody
                    public long contentLength() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.val$buffer.size() : invokeV.longValue;
                    }

                    @Override // okhttp3.RequestBody
                    public MediaType contentType() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.val$requestBody.contentType() : (MediaType) invokeV.objValue;
                    }

                    @Override // okhttp3.RequestBody
                    public void writeTo(BufferedSink bufferedSink) throws IOException {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, bufferedSink) == null) {
                            bufferedSink.write(this.val$buffer.snapshot());
                        }
                    }
                };
            }
            return (RequestBody) invokeL.objValue;
        }

        private RequestBody gzip(RequestBody requestBody, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, requestBody, str)) == null) ? new RequestBody(this, requestBody, str) { // from class: com.baidu.mobstat.dxmpay.util.OkHttpRequestManager.GzipRequestInterceptor.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ GzipRequestInterceptor this$1;
                public final /* synthetic */ RequestBody val$body;
                public final /* synthetic */ String val$url;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, requestBody, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$1 = this;
                    this.val$body = requestBody;
                    this.val$url = str;
                }

                @Override // okhttp3.RequestBody
                public long contentLength() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        return -1L;
                    }
                    return invokeV.longValue;
                }

                @Override // okhttp3.RequestBody
                public MediaType contentType() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.val$body.contentType() : (MediaType) invokeV.objValue;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(BufferedSink bufferedSink) throws IOException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, bufferedSink) == null) {
                        BufferedSink buffer = Okio.buffer(new GzipSink(bufferedSink));
                        if (!TextUtils.isEmpty(this.val$url) && this.val$url.contains("bplus.gif")) {
                            buffer.write(new byte[]{72, 77, 48, 49});
                            buffer.write(new byte[]{0, 0, 0, 1});
                            buffer.write(new byte[]{0, 0, 3, -14});
                            buffer.write(new byte[]{0, 0, 0, 0, 0, 0, 0, 0});
                            buffer.write(new byte[]{0, 2});
                            buffer.write(new byte[]{0, 0});
                            buffer.write(new byte[]{72, 77, 48, 49});
                        }
                        this.val$body.writeTo(buffer);
                        buffer.close();
                    }
                }
            } : (RequestBody) invokeLL.objValue;
        }

        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, chain)) == null) {
                Request request = chain.request();
                if (request.body() == null) {
                    return chain.proceed(request.newBuilder().header("Content-Encoding", AsyncHttpClient.ENCODING_GZIP).build());
                }
                if (request.header("Content-Encoding") != null) {
                    return chain.proceed(request);
                }
                return chain.proceed(request.newBuilder().header("Content-Encoding", AsyncHttpClient.ENCODING_GZIP).method(request.method(), forceContentLength(gzip(request.body(), request.url().toString()))).build());
            }
            return (Response) invokeL.objValue;
        }
    }
}
