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
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
/* loaded from: classes2.dex */
public abstract class RequestBody {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public long contentLength() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return -1L;
        }
        return invokeV.longValue;
    }

    @Nullable
    public abstract MediaType contentType();

    public abstract void writeTo(OutputStream outputStream) throws IOException;

    public RequestBody() {
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

    public static RequestBody create(@Nullable MediaType mediaType, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, mediaType, file)) == null) {
            if (file != null) {
                return new RequestBody(mediaType, file) { // from class: com.baidu.searchbox.network.outback.core.RequestBody.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MediaType val$contentType;
                    public final /* synthetic */ File val$file;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {mediaType, file};
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
                        this.val$file = file;
                    }

                    @Override // com.baidu.searchbox.network.outback.core.RequestBody
                    public long contentLength() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            return this.val$file.length();
                        }
                        return invokeV.longValue;
                    }

                    @Override // com.baidu.searchbox.network.outback.core.RequestBody
                    @Nullable
                    public MediaType contentType() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                            return this.val$contentType;
                        }
                        return (MediaType) invokeV.objValue;
                    }

                    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: java.io.FileInputStream */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // com.baidu.searchbox.network.outback.core.RequestBody
                    public void writeTo(OutputStream outputStream) throws IOException {
                        FileChannel fileChannel;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, outputStream) == null) {
                            FileChannel fileChannel2 = null;
                            try {
                                FileInputStream fileInputStream = new FileInputStream(this.val$file);
                                try {
                                    fileChannel2 = fileInputStream.getChannel();
                                    fileChannel2.transferTo(0L, fileChannel2.size(), Channels.newChannel(outputStream));
                                    Util.closeQuietly(fileInputStream);
                                    Util.closeQuietly(fileChannel2);
                                } catch (Throwable th) {
                                    th = th;
                                    fileChannel = fileChannel2;
                                    fileChannel2 = fileInputStream;
                                    Util.closeQuietly(fileChannel2);
                                    Util.closeQuietly(fileChannel);
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                fileChannel = null;
                            }
                        }
                    }
                };
            }
            throw new NullPointerException("file == null");
        }
        return (RequestBody) invokeLL.objValue;
    }

    public static RequestBody create(@Nullable MediaType mediaType, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, mediaType, str)) == null) {
            Charset charset = Util.UTF_8;
            if (mediaType != null && (charset = mediaType.charset()) == null) {
                charset = Util.UTF_8;
                mediaType = MediaType.parse(mediaType + "; charset=utf-8");
            }
            return create(mediaType, str.getBytes(charset));
        }
        return (RequestBody) invokeLL.objValue;
    }

    public static RequestBody create(@Nullable MediaType mediaType, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, mediaType, bArr)) == null) {
            return create(mediaType, bArr, 0, bArr.length);
        }
        return (RequestBody) invokeLL.objValue;
    }

    public static RequestBody create(@Nullable MediaType mediaType, byte[] bArr, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(InputDeviceCompat.SOURCE_TRACKBALL, null, mediaType, bArr, i, i2)) == null) {
            if (bArr != null) {
                Util.checkOffsetAndCount(bArr.length, i, i2);
                return new RequestBody(mediaType, i2, bArr, i) { // from class: com.baidu.searchbox.network.outback.core.RequestBody.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ int val$byteCount;
                    public final /* synthetic */ byte[] val$content;
                    public final /* synthetic */ MediaType val$contentType;
                    public final /* synthetic */ int val$offset;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {mediaType, Integer.valueOf(i2), bArr, Integer.valueOf(i)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$contentType = mediaType;
                        this.val$byteCount = i2;
                        this.val$content = bArr;
                        this.val$offset = i;
                    }

                    @Override // com.baidu.searchbox.network.outback.core.RequestBody
                    public long contentLength() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            return this.val$byteCount;
                        }
                        return invokeV.longValue;
                    }

                    @Override // com.baidu.searchbox.network.outback.core.RequestBody
                    @Nullable
                    public MediaType contentType() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                            return this.val$contentType;
                        }
                        return (MediaType) invokeV.objValue;
                    }

                    @Override // com.baidu.searchbox.network.outback.core.RequestBody
                    public void writeTo(OutputStream outputStream) throws IOException {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, outputStream) == null) {
                            outputStream.write(this.val$content, this.val$offset, this.val$byteCount);
                        }
                    }
                };
            }
            throw new NullPointerException("content == null");
        }
        return (RequestBody) invokeLLII.objValue;
    }
}
