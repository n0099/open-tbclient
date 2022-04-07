package com.baidu.searchbox.network.outback.core;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.core.Headers;
import com.baidu.searchbox.network.outback.statistics.NetworkStatRecord;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
/* loaded from: classes2.dex */
public final class Response implements Closeable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public ResponseBody body;
    @Nullable
    public final Response cacheResponse;
    public final boolean cached;
    public final int code;
    public final long dnsTime;
    public final Headers headers;
    public final boolean isConnReused;
    public final String message;
    public final int netEngine;
    @Nullable
    public final Response networkResponse;
    @Nullable
    public final Response priorResponse;
    public final Protocol protocol;
    public final long receivedResponseAtMillis;
    public final Request request;
    public final long sendTime;
    public final long sentRequestAtMillis;
    public final long sslTime;
    @Nullable
    public final NetworkStatRecord statRecord;
    public final long tcpTime;

    public Response(Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.request = builder.request;
        this.protocol = builder.protocol;
        this.code = builder.code;
        this.message = builder.message;
        this.headers = builder.headers.build();
        this.body = builder.body;
        this.networkResponse = builder.networkResponse;
        this.cacheResponse = builder.cacheResponse;
        this.priorResponse = builder.priorResponse;
        this.sentRequestAtMillis = builder.sentRequestAtMillis;
        this.receivedResponseAtMillis = builder.receivedResponseAtMillis;
        this.netEngine = builder.netEngine;
        this.isConnReused = builder.isConnReused;
        this.dnsTime = builder.dnsTime;
        this.sslTime = builder.sslTime;
        this.tcpTime = builder.tcpTime;
        this.sendTime = builder.sendTime;
        this.cached = builder.cached;
        this.statRecord = builder.statRecord;
    }

    @Nullable
    public ResponseBody body() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.body : (ResponseBody) invokeV.objValue;
    }

    @Nullable
    public Response cacheResponse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.cacheResponse : (Response) invokeV.objValue;
    }

    public boolean cached() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.cached : invokeV.booleanValue;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ResponseBody responseBody = this.body;
            if (responseBody != null) {
                responseBody.close();
                return;
            }
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
    }

    public int code() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.code : invokeV.intValue;
    }

    public long dnsTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.dnsTime : invokeV.longValue;
    }

    @Nullable
    public NetworkStatRecord getStatRecord() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.statRecord : (NetworkStatRecord) invokeV.objValue;
    }

    @Nullable
    public String header(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? header(str, null) : (String) invokeL.objValue;
    }

    public List<String> headers(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) ? this.headers.values(str) : (List) invokeL.objValue;
    }

    public boolean isConnReused() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.isConnReused : invokeV.booleanValue;
    }

    public boolean isRedirect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            int i = this.code;
            if (i == 307 || i == 308) {
                return true;
            }
            switch (i) {
                case 300:
                case 301:
                case 302:
                case 303:
                    return true;
                default:
                    return false;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean isSuccessful() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            int i = this.code;
            return i >= 200 && i < 300;
        }
        return invokeV.booleanValue;
    }

    public String message() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.message : (String) invokeV.objValue;
    }

    public int netEngine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.netEngine : invokeV.intValue;
    }

    @Nullable
    public Response networkResponse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.networkResponse : (Response) invokeV.objValue;
    }

    public Builder newBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? new Builder(this) : (Builder) invokeV.objValue;
    }

    public ResponseBody peekBody(long j) throws IOException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048594, this, j)) == null) {
            int i = (int) j;
            BufferedInputStream bufferedInputStream = new BufferedInputStream(this.body.inputStream(), i);
            byte[] bArr = new byte[i];
            bufferedInputStream.mark(0);
            int read = bufferedInputStream.read(bArr);
            if (read < j) {
                byte[] bArr2 = new byte[read];
                System.arraycopy(bArr, 0, bArr2, 0, read);
                bArr = bArr2;
            }
            bufferedInputStream.reset();
            ResponseBody create = ResponseBody.create(this.body.contentType(), this.body.contentLength(), bufferedInputStream);
            this.body = create;
            return ResponseBody.create(create.contentType(), bArr);
        }
        return (ResponseBody) invokeJ.objValue;
    }

    @Nullable
    public Response priorResponse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.priorResponse : (Response) invokeV.objValue;
    }

    public Protocol protocol() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.protocol : (Protocol) invokeV.objValue;
    }

    public long receivedResponseAtMillis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.receivedResponseAtMillis : invokeV.longValue;
    }

    public Request request() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.request : (Request) invokeV.objValue;
    }

    public long sendTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.sendTime : invokeV.longValue;
    }

    public long sentRequestAtMillis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.sentRequestAtMillis : invokeV.longValue;
    }

    public long sslTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.sslTime : invokeV.longValue;
    }

    public long tcpTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.tcpTime : invokeV.longValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return "Response{protocol=" + this.protocol + ", code=" + this.code + ", message=" + this.message + ", url=" + this.request.url() + '}';
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public String header(String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) {
            String str3 = this.headers.get(str);
            return str3 != null ? str3 : str2;
        }
        return (String) invokeLL.objValue;
    }

    public Headers headers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.headers : (Headers) invokeV.objValue;
    }

    /* loaded from: classes2.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public ResponseBody body;
        @Nullable
        public Response cacheResponse;
        public boolean cached;
        public int code;
        public long dnsTime;
        public Headers.Builder headers;
        public boolean isConnReused;
        public String message;
        public int netEngine;
        @Nullable
        public Response networkResponse;
        @Nullable
        public Response priorResponse;
        @Nullable
        public Protocol protocol;
        public long receivedResponseAtMillis;
        @Nullable
        public Request request;
        public long sendTime;
        public long sentRequestAtMillis;
        public long sslTime;
        public NetworkStatRecord statRecord;
        public long tcpTime;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.code = -1;
            this.isConnReused = false;
            this.headers = new Headers.Builder();
        }

        private void checkPriorResponse(Response response) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65538, this, response) == null) && response.body != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        private void checkSupportResponse(String str, Response response) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65539, this, str, response) == null) {
                if (response.body == null) {
                    if (response.networkResponse == null) {
                        if (response.cacheResponse == null) {
                            if (response.priorResponse == null) {
                                return;
                            }
                            throw new IllegalArgumentException(str + ".priorResponse != null");
                        }
                        throw new IllegalArgumentException(str + ".cacheResponse != null");
                    }
                    throw new IllegalArgumentException(str + ".networkResponse != null");
                }
                throw new IllegalArgumentException(str + ".body != null");
            }
        }

        public Builder addHeader(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
                this.headers.add(str, str2);
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder body(@Nullable ResponseBody responseBody) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, responseBody)) == null) {
                this.body = responseBody;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Response build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.request != null) {
                    if (this.code >= 0) {
                        if (this.message != null) {
                            return new Response(this);
                        }
                        throw new IllegalStateException("message == null");
                    }
                    throw new IllegalStateException("code < 0: " + this.code);
                }
                throw new IllegalStateException("request == null");
            }
            return (Response) invokeV.objValue;
        }

        public Builder cacheResponse(@Nullable Response response) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, response)) == null) {
                if (response != null) {
                    checkSupportResponse("cacheResponse", response);
                }
                this.cacheResponse = response;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder cached(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.cached = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder code(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
                this.code = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder dnsTime(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
                this.dnsTime = j;
                return this;
            }
            return (Builder) invokeJ.objValue;
        }

        public Builder header(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, str2)) == null) {
                this.headers.set(str, str2);
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder headers(Headers headers) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, headers)) == null) {
                this.headers = headers.newBuilder();
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder isConnReused(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
                this.isConnReused = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder message(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
                this.message = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder netEngine(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
                this.netEngine = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder networkResponse(@Nullable Response response) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, response)) == null) {
                if (response != null) {
                    checkSupportResponse("networkResponse", response);
                }
                this.networkResponse = response;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder priorResponse(@Nullable Response response) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, response)) == null) {
                if (response != null) {
                    checkPriorResponse(response);
                }
                this.priorResponse = response;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder protocol(Protocol protocol) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, protocol)) == null) {
                this.protocol = protocol;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder receivedResponseAtMillis(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048591, this, j)) == null) {
                this.receivedResponseAtMillis = j;
                return this;
            }
            return (Builder) invokeJ.objValue;
        }

        public Builder removeHeader(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
                this.headers.removeAll(str);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder request(Request request) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, request)) == null) {
                this.request = request;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder sendTime(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048594, this, j)) == null) {
                this.sendTime = j;
                return this;
            }
            return (Builder) invokeJ.objValue;
        }

        public Builder sentRequestAtMillis(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048595, this, j)) == null) {
                this.sentRequestAtMillis = j;
                return this;
            }
            return (Builder) invokeJ.objValue;
        }

        public Builder sslTime(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048596, this, j)) == null) {
                this.sslTime = j;
                return this;
            }
            return (Builder) invokeJ.objValue;
        }

        public Builder statRecord(@Nullable NetworkStatRecord networkStatRecord) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, networkStatRecord)) == null) {
                this.statRecord = networkStatRecord;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder tcpTime(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048598, this, j)) == null) {
                this.tcpTime = j;
                return this;
            }
            return (Builder) invokeJ.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
                return "Builder{request=" + this.request + ", protocol=" + this.protocol + ", code=" + this.code + ", message='" + this.message + "', headers=" + this.headers + ", body=" + this.body + ", networkResponse=" + this.networkResponse + ", cacheResponse=" + this.cacheResponse + ", priorResponse=" + this.priorResponse + ", sentRequestAtMillis=" + this.sentRequestAtMillis + ", receivedResponseAtMillis=" + this.receivedResponseAtMillis + ", netEngine=" + this.netEngine + ", isConnReused=" + this.isConnReused + ", dnsTime=" + this.dnsTime + ", sslTime=" + this.sslTime + ", tcpTime=" + this.tcpTime + ", sendTime=" + this.sendTime + ", cached=" + this.cached + '}';
            }
            return (String) invokeV.objValue;
        }

        public Builder(Response response) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {response};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.code = -1;
            this.isConnReused = false;
            this.request = response.request;
            this.protocol = response.protocol;
            this.code = response.code;
            this.message = response.message;
            this.headers = response.headers.newBuilder();
            this.body = response.body;
            this.networkResponse = response.networkResponse;
            this.cacheResponse = response.cacheResponse;
            this.priorResponse = response.priorResponse;
            this.sentRequestAtMillis = response.sentRequestAtMillis;
            this.receivedResponseAtMillis = response.receivedResponseAtMillis;
            this.netEngine = response.netEngine;
            this.isConnReused = response.isConnReused;
            this.dnsTime = response.dnsTime;
            this.sslTime = response.sslTime;
            this.tcpTime = response.tcpTime;
            this.sendTime = response.sendTime;
            this.cached = response.cached;
            this.statRecord = response.statRecord;
        }
    }
}
