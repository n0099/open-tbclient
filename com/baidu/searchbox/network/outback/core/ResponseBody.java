package com.baidu.searchbox.network.outback.core;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.core.internal.Util;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
/* loaded from: classes2.dex */
public abstract class ResponseBody implements Closeable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_BUFFER_SIZE = 8192;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public Reader reader;

    public abstract long contentLength();

    @Nullable
    public abstract MediaType contentType();

    public abstract InputStream inputStream();

    /* loaded from: classes2.dex */
    public static final class BomAwareReader extends Reader {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final BufferedInputStream bis;
        public final Charset charset;
        public boolean closed;
        @Nullable
        public Reader delegate;

        public BomAwareReader(InputStream inputStream, Charset charset) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inputStream, charset};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.bis = new BufferedInputStream(inputStream);
            this.charset = charset;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.closed = true;
                Reader reader = this.delegate;
                if (reader != null) {
                    reader.close();
                } else {
                    this.bis.close();
                }
            }
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cArr, i, i2)) == null) {
                if (!this.closed) {
                    Reader reader = this.delegate;
                    if (reader == null) {
                        byte[] bArr = new byte[4];
                        this.bis.mark(0);
                        this.bis.read(bArr);
                        this.bis.reset();
                        InputStreamReader inputStreamReader = new InputStreamReader(this.bis, Util.bomAwareCharset(ByteBuffer.wrap(bArr), this.charset));
                        this.delegate = inputStreamReader;
                        reader = inputStreamReader;
                    }
                    return reader.read(cArr, i, i2);
                }
                throw new IOException("Stream closed");
            }
            return invokeLII.intValue;
        }
    }

    public ResponseBody() {
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

    private Charset charset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            MediaType contentType = contentType();
            if (contentType != null) {
                return contentType.charset(Util.UTF_8);
            }
            return Util.UTF_8;
        }
        return (Charset) invokeV.objValue;
    }

    public final InputStream byteStream() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return inputStream();
        }
        return (InputStream) invokeV.objValue;
    }

    public final Reader charStream() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Reader reader = this.reader;
            if (reader == null) {
                BomAwareReader bomAwareReader = new BomAwareReader(inputStream(), charset());
                this.reader = bomAwareReader;
                return bomAwareReader;
            }
            return reader;
        }
        return (Reader) invokeV.objValue;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Util.closeQuietly(inputStream());
        }
    }

    public final String string() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ByteBuffer wrap = ByteBuffer.wrap(bytes());
            return Util.bomAwareCharset(wrap.duplicate(), charset()).decode(wrap).toString();
        }
        return (String) invokeV.objValue;
    }

    public static ResponseBody create(@Nullable MediaType mediaType, long j, InputStream inputStream) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{mediaType, Long.valueOf(j), inputStream})) == null) {
            if (inputStream != null) {
                return new ResponseBody(mediaType, j, inputStream) { // from class: com.baidu.searchbox.network.outback.core.ResponseBody.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ long val$contentLength;
                    public final /* synthetic */ MediaType val$contentType;
                    public final /* synthetic */ InputStream val$inputStream;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {mediaType, Long.valueOf(j), inputStream};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$contentType = mediaType;
                        this.val$contentLength = j;
                        this.val$inputStream = inputStream;
                    }

                    @Override // com.baidu.searchbox.network.outback.core.ResponseBody
                    public long contentLength() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            return this.val$contentLength;
                        }
                        return invokeV.longValue;
                    }

                    @Override // com.baidu.searchbox.network.outback.core.ResponseBody
                    @Nullable
                    public MediaType contentType() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                            return this.val$contentType;
                        }
                        return (MediaType) invokeV.objValue;
                    }

                    @Override // com.baidu.searchbox.network.outback.core.ResponseBody
                    public InputStream inputStream() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                            return this.val$inputStream;
                        }
                        return (InputStream) invokeV.objValue;
                    }
                };
            }
            throw new NullPointerException("source == null");
        }
        return (ResponseBody) invokeCommon.objValue;
    }

    public static ResponseBody create(@Nullable MediaType mediaType, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, mediaType, str)) == null) {
            Charset charset = Util.UTF_8;
            if (mediaType != null && (charset = mediaType.charset()) == null) {
                charset = Util.UTF_8;
                mediaType = MediaType.parse(mediaType + "; charset=utf-8");
            }
            return create(mediaType, str.getBytes(charset));
        }
        return (ResponseBody) invokeLL.objValue;
    }

    public static ResponseBody create(@Nullable MediaType mediaType, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, mediaType, bArr)) == null) {
            return create(mediaType, bArr.length, new ByteArrayInputStream(bArr));
        }
        return (ResponseBody) invokeLL.objValue;
    }

    public final byte[] bytes() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            long contentLength = contentLength();
            if (contentLength <= 2147483647L) {
                InputStream inputStream = inputStream();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read > 0) {
                            byteArrayOutputStream.write(bArr, 0, read);
                        } else {
                            return byteArrayOutputStream.toByteArray();
                        }
                    }
                } finally {
                    Util.closeQuietly(inputStream);
                    Util.closeQuietly(byteArrayOutputStream);
                }
            } else {
                throw new IOException("Cannot buffer entire body for content length: " + contentLength);
            }
        } else {
            return (byte[]) invokeV.objValue;
        }
    }
}
