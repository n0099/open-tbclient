package com.baidu.searchbox.network.outback.support.request.body;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.android.internal.http.multipart.FilePart;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.core.Headers;
import com.baidu.searchbox.network.outback.core.MediaType;
import com.baidu.searchbox.network.outback.core.RequestBody;
import com.baidu.searchbox.network.outback.core.internal.Util;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.disklrucache.StrictLineReader;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.text.Typography;
/* loaded from: classes2.dex */
public final class MultipartBody extends RequestBody {
    public static /* synthetic */ Interceptable $ic;
    public static final MediaType ALTERNATIVE;
    public static final byte[] COLONSPACE;
    public static final byte[] CRLF;
    public static final byte[] DASHDASH;
    public static final MediaType DIGEST;
    public static final MediaType FORM;
    public static final MediaType MIXED;
    public static final MediaType PARALLEL;
    public transient /* synthetic */ FieldHolder $fh;
    public final String boundary;
    public long contentLength;
    public final MediaType contentType;
    public final MediaType originalType;
    public final List<Part> parts;

    /* loaded from: classes2.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String boundary;
        public final List<Part> parts;
        public MediaType type;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder() {
            this(UUID.randomUUID().toString());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    this((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public Builder addFormDataPart(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) ? addPart(Part.createFormData(str, str2)) : (Builder) invokeLL.objValue;
        }

        public Builder addPart(@Nullable Headers headers, RequestBody requestBody) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, headers, requestBody)) == null) ? addPart(Part.create(headers, requestBody)) : (Builder) invokeLL.objValue;
        }

        public MultipartBody build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                if (!this.parts.isEmpty()) {
                    return new MultipartBody(this.boundary, this.type, this.parts);
                }
                throw new IllegalStateException("Multipart body must have at least one part.");
            }
            return (MultipartBody) invokeV.objValue;
        }

        public Builder setType(MediaType mediaType) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, mediaType)) == null) {
                if (mediaType != null) {
                    if (mediaType.type().equals("multipart")) {
                        this.type = mediaType;
                        return this;
                    }
                    throw new IllegalArgumentException("multipart != " + mediaType);
                }
                throw new NullPointerException("type == null");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.type = MultipartBody.MIXED;
            this.parts = new ArrayList();
            this.boundary = str;
        }

        public Builder addFormDataPart(String str, @Nullable String str2, RequestBody requestBody) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, requestBody)) == null) ? addPart(Part.createFormData(str, str2, requestBody)) : (Builder) invokeLLL.objValue;
        }

        public Builder addPart(RequestBody requestBody) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, requestBody)) == null) ? addPart(Part.create(requestBody)) : (Builder) invokeL.objValue;
        }

        public Builder addPart(Part part) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, part)) == null) {
                if (part != null) {
                    this.parts.add(part);
                    return this;
                }
                throw new NullPointerException("part == null");
            }
            return (Builder) invokeL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class Part {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final RequestBody body;
        @Nullable
        public final Headers headers;

        public Part(@Nullable Headers headers, RequestBody requestBody) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {headers, requestBody};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.headers = headers;
            this.body = requestBody;
        }

        public static Part create(RequestBody requestBody) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, requestBody)) == null) ? create(null, requestBody) : (Part) invokeL.objValue;
        }

        public static Part createFormData(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) ? createFormData(str, null, RequestBody.create((MediaType) null, str2)) : (Part) invokeLL.objValue;
        }

        public RequestBody body() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.body : (RequestBody) invokeV.objValue;
        }

        @Nullable
        public Headers headers() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.headers : (Headers) invokeV.objValue;
        }

        public static Part create(@Nullable Headers headers, RequestBody requestBody) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, headers, requestBody)) == null) {
                if (requestBody != null) {
                    if (headers != null && headers.get("Content-Type") != null) {
                        throw new IllegalArgumentException("Unexpected header: Content-Type");
                    }
                    if (headers != null && headers.get("Content-Length") != null) {
                        throw new IllegalArgumentException("Unexpected header: Content-Length");
                    }
                    return new Part(headers, requestBody);
                }
                throw new NullPointerException("body == null");
            }
            return (Part) invokeLL.objValue;
        }

        public static Part createFormData(String str, @Nullable String str2, RequestBody requestBody) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, requestBody)) == null) {
                if (str != null) {
                    StringBuilder sb = new StringBuilder("form-data; name=");
                    MultipartBody.appendQuotedString(sb, str);
                    if (str2 != null) {
                        sb.append(FilePart.FILE_NAME);
                        MultipartBody.appendQuotedString(sb, str2);
                    }
                    return create(Headers.of("Content-Disposition", sb.toString()), requestBody);
                }
                throw new NullPointerException("name == null");
            }
            return (Part) invokeLLL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-914940795, "Lcom/baidu/searchbox/network/outback/support/request/body/MultipartBody;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-914940795, "Lcom/baidu/searchbox/network/outback/support/request/body/MultipartBody;");
                return;
            }
        }
        MIXED = MediaType.get("multipart/mixed");
        ALTERNATIVE = MediaType.get("multipart/alternative");
        DIGEST = MediaType.get("multipart/digest");
        PARALLEL = MediaType.get("multipart/parallel");
        FORM = MediaType.get(IMAudioTransRequest.CONTENT_TYPE);
        COLONSPACE = new byte[]{58, 32};
        CRLF = new byte[]{StrictLineReader.CR, 10};
        DASHDASH = new byte[]{45, 45};
    }

    public MultipartBody(String str, MediaType mediaType, List<Part> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, mediaType, list};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.contentLength = -1L;
        this.boundary = str;
        this.originalType = mediaType;
        this.contentType = MediaType.get(mediaType + "; boundary=" + str);
        this.parts = Util.immutableList(list);
    }

    public static StringBuilder appendQuotedString(StringBuilder sb, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, sb, str)) == null) {
            sb.append(Typography.quote);
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (charAt == '\n') {
                    sb.append("%0A");
                } else if (charAt == '\r') {
                    sb.append("%0D");
                } else if (charAt != '\"') {
                    sb.append(charAt);
                } else {
                    sb.append("%22");
                }
            }
            sb.append(Typography.quote);
            return sb;
        }
        return (StringBuilder) invokeLL.objValue;
    }

    private long writeOrCountBytes(@Nullable OutputStream outputStream, boolean z) throws IOException {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, this, outputStream, z)) == null) {
            if (z) {
                outputStream = new ByteArrayOutputStream();
            }
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            int size = this.parts.size();
            long j = 0;
            for (int i = 0; i < size; i++) {
                Part part = this.parts.get(i);
                Headers headers = part.headers;
                RequestBody requestBody = part.body;
                bufferedOutputStream.write(DASHDASH);
                Util.writeUtf8(bufferedOutputStream, this.boundary);
                bufferedOutputStream.write(CRLF);
                if (headers != null) {
                    int size2 = headers.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        Util.writeUtf8(bufferedOutputStream, headers.name(i2));
                        bufferedOutputStream.write(COLONSPACE);
                        Util.writeUtf8(bufferedOutputStream, headers.value(i2));
                        bufferedOutputStream.write(CRLF);
                    }
                }
                MediaType contentType = requestBody.contentType();
                if (contentType != null) {
                    Util.writeUtf8(bufferedOutputStream, com.android.internal.http.multipart.Part.CONTENT_TYPE);
                    Util.writeUtf8(bufferedOutputStream, contentType.toString());
                    bufferedOutputStream.write(CRLF);
                }
                long contentLength = requestBody.contentLength();
                if (contentLength != -1) {
                    Util.writeUtf8(bufferedOutputStream, "Content-Length: ");
                    Util.writeDecimalLong(bufferedOutputStream, contentLength);
                    bufferedOutputStream.write(CRLF);
                } else if (z) {
                    Util.closeQuietly(outputStream);
                    return -1L;
                }
                bufferedOutputStream.write(CRLF);
                if (z) {
                    j += contentLength;
                } else {
                    requestBody.writeTo(bufferedOutputStream);
                }
                bufferedOutputStream.write(CRLF);
            }
            bufferedOutputStream.write(DASHDASH);
            Util.writeUtf8(bufferedOutputStream, this.boundary);
            bufferedOutputStream.write(DASHDASH);
            bufferedOutputStream.write(CRLF);
            bufferedOutputStream.flush();
            if (z) {
                long size3 = j + ((ByteArrayOutputStream) outputStream).size();
                Util.closeQuietly(outputStream);
                return size3;
            }
            return j;
        }
        return invokeLZ.longValue;
    }

    public String boundary() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.boundary : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.network.outback.core.RequestBody
    public long contentLength() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            long j = this.contentLength;
            if (j != -1) {
                return j;
            }
            long writeOrCountBytes = writeOrCountBytes(null, true);
            this.contentLength = writeOrCountBytes;
            return writeOrCountBytes;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.searchbox.network.outback.core.RequestBody
    public MediaType contentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.contentType : (MediaType) invokeV.objValue;
    }

    public Part part(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? this.parts.get(i) : (Part) invokeI.objValue;
    }

    public List<Part> parts() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.parts : (List) invokeV.objValue;
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.parts.size() : invokeV.intValue;
    }

    public MediaType type() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.originalType : (MediaType) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.network.outback.core.RequestBody
    public void writeTo(OutputStream outputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, outputStream) == null) {
            writeOrCountBytes(outputStream, false);
        }
    }
}
