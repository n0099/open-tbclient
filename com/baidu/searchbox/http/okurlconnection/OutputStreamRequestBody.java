package com.baidu.searchbox.http.okurlconnection;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.Timeout;
/* loaded from: classes2.dex */
public abstract class OutputStreamRequestBody extends RequestBody {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean closed;
    public long expectedContentLength;
    public volatile boolean needFlush;
    public OutputStream outputStream;
    public Timeout timeout;

    @Override // okhttp3.RequestBody
    public final MediaType contentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (MediaType) invokeV.objValue;
    }

    public Request prepareToSendRequest(Request request) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, request)) == null) ? request : (Request) invokeL.objValue;
    }

    public OutputStreamRequestBody() {
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
        this.needFlush = false;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.expectedContentLength;
        }
        return invokeV.longValue;
    }

    public final boolean isClosed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.closed;
        }
        return invokeV.booleanValue;
    }

    public final OutputStream outputStream() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.outputStream;
        }
        return (OutputStream) invokeV.objValue;
    }

    public final Timeout timeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.timeout;
        }
        return (Timeout) invokeV.objValue;
    }

    public void initOutputStream(BufferedSink bufferedSink, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, bufferedSink, j) == null) {
            this.timeout = bufferedSink.timeout();
            this.expectedContentLength = j;
            this.outputStream = new OutputStream(this, j, bufferedSink) { // from class: com.baidu.searchbox.http.okurlconnection.OutputStreamRequestBody.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public long bytesReceived;
                public final /* synthetic */ OutputStreamRequestBody this$0;
                public final /* synthetic */ long val$expectedContentLength;
                public final /* synthetic */ BufferedSink val$sink;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(j), bufferedSink};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$expectedContentLength = j;
                    this.val$sink = bufferedSink;
                }

                @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.closed = true;
                        long j2 = this.val$expectedContentLength;
                        if (j2 != -1 && this.bytesReceived < j2) {
                            throw new ProtocolException("expected " + this.val$expectedContentLength + " bytes but received " + this.bytesReceived);
                        }
                        this.val$sink.close();
                    }
                }

                @Override // java.io.OutputStream, java.io.Flushable
                public void flush() throws IOException {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 != null && interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.this$0.closed) {
                        return;
                    }
                    this.val$sink.flush();
                    this.this$0.needFlush = true;
                }

                @Override // java.io.OutputStream
                public void write(int i) throws IOException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                        write(new byte[]{(byte) i}, 0, 1);
                    }
                }

                @Override // java.io.OutputStream
                public void write(byte[] bArr, int i, int i2) throws IOException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLII(1048579, this, bArr, i, i2) == null) {
                        if (!this.this$0.closed) {
                            long j2 = this.val$expectedContentLength;
                            if (j2 != -1 && this.bytesReceived + i2 > j2) {
                                throw new ProtocolException("expected " + this.val$expectedContentLength + " bytes but received " + this.bytesReceived + i2);
                            }
                            this.bytesReceived += i2;
                            try {
                                this.val$sink.write(bArr, i, i2);
                                return;
                            } catch (InterruptedIOException e) {
                                throw new SocketTimeoutException(e.getMessage());
                            }
                        }
                        throw new IOException("closed");
                    }
                }
            };
        }
    }
}
