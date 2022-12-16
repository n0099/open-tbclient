package com.baidu.searchbox.http.okurlconnection;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import okhttp3.Request;
import okio.Buffer;
import okio.BufferedSink;
/* loaded from: classes2.dex */
public final class BufferedRequestBody extends OutputStreamRequestBody {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Buffer buffer;
    public long contentLength;

    public BufferedRequestBody(long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Buffer buffer = new Buffer();
        this.buffer = buffer;
        this.contentLength = -1L;
        initOutputStream(buffer, j);
    }

    @Override // com.baidu.searchbox.http.okurlconnection.OutputStreamRequestBody, okhttp3.RequestBody
    public long contentLength() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.contentLength;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.searchbox.http.okurlconnection.OutputStreamRequestBody
    public Request prepareToSendRequest(Request request) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, request)) == null) {
            if (request.header("Content-Length") != null) {
                return request;
            }
            outputStream().close();
            this.contentLength = this.buffer.size();
            return request.newBuilder().removeHeader("Transfer-Encoding").header("Content-Length", Long.toString(this.buffer.size())).build();
        }
        return (Request) invokeL.objValue;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bufferedSink) == null) {
            this.buffer.copyTo(bufferedSink.buffer(), 0L, this.buffer.size());
        }
    }
}
