package com.baidu.searchbox.network.outback.support.request.body;

import androidx.annotation.Nullable;
import com.android.internal.http.multipart.FilePart;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.searchbox.network.outback.core.Headers;
import com.baidu.searchbox.network.outback.core.MediaType;
import com.baidu.searchbox.network.outback.core.RequestBody;
import com.baidu.searchbox.network.outback.core.internal.Util;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.text.Typography;
/* loaded from: classes4.dex */
public final class MultipartBody extends RequestBody {
    public final String boundary;
    public long contentLength = -1;
    public final MediaType contentType;
    public final MediaType originalType;
    public final List<Part> parts;
    public static final MediaType MIXED = MediaType.get("multipart/mixed");
    public static final MediaType ALTERNATIVE = MediaType.get("multipart/alternative");
    public static final MediaType DIGEST = MediaType.get("multipart/digest");
    public static final MediaType PARALLEL = MediaType.get("multipart/parallel");
    public static final MediaType FORM = MediaType.get(IMAudioTransRequest.CONTENT_TYPE);
    public static final byte[] COLONSPACE = {58, 32};
    public static final byte[] CRLF = {13, 10};
    public static final byte[] DASHDASH = {45, 45};

    /* loaded from: classes4.dex */
    public static final class Builder {
        public final String boundary;
        public final List<Part> parts;
        public MediaType type;

        public Builder() {
            this(UUID.randomUUID().toString());
        }

        public MultipartBody build() {
            if (!this.parts.isEmpty()) {
                return new MultipartBody(this.boundary, this.type, this.parts);
            }
            throw new IllegalStateException("Multipart body must have at least one part.");
        }

        public Builder(String str) {
            this.type = MultipartBody.MIXED;
            this.parts = new ArrayList();
            this.boundary = str;
        }

        public Builder addPart(RequestBody requestBody) {
            return addPart(Part.create(requestBody));
        }

        public Builder setType(MediaType mediaType) {
            if (mediaType != null) {
                if (mediaType.type().equals("multipart")) {
                    this.type = mediaType;
                    return this;
                }
                throw new IllegalArgumentException("multipart != " + mediaType);
            }
            throw new NullPointerException("type == null");
        }

        public Builder addFormDataPart(String str, String str2) {
            return addPart(Part.createFormData(str, str2));
        }

        public Builder addPart(@Nullable Headers headers, RequestBody requestBody) {
            return addPart(Part.create(headers, requestBody));
        }

        public Builder addFormDataPart(String str, @Nullable String str2, RequestBody requestBody) {
            return addPart(Part.createFormData(str, str2, requestBody));
        }

        public Builder addPart(Part part) {
            if (part != null) {
                this.parts.add(part);
                return this;
            }
            throw new NullPointerException("part == null");
        }
    }

    /* loaded from: classes4.dex */
    public static final class Part {
        public final RequestBody body;
        @Nullable
        public final Headers headers;

        public Part(@Nullable Headers headers, RequestBody requestBody) {
            this.headers = headers;
            this.body = requestBody;
        }

        public static Part createFormData(String str, String str2) {
            return createFormData(str, null, RequestBody.create((MediaType) null, str2));
        }

        public static Part create(@Nullable Headers headers, RequestBody requestBody) {
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

        public static Part create(RequestBody requestBody) {
            return create(null, requestBody);
        }

        public static Part createFormData(String str, @Nullable String str2, RequestBody requestBody) {
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

        public RequestBody body() {
            return this.body;
        }

        @Nullable
        public Headers headers() {
            return this.headers;
        }
    }

    public MultipartBody(String str, MediaType mediaType, List<Part> list) {
        this.boundary = str;
        this.originalType = mediaType;
        this.contentType = MediaType.get(mediaType + "; boundary=" + str);
        this.parts = Util.immutableList(list);
    }

    public static StringBuilder appendQuotedString(StringBuilder sb, String str) {
        sb.append(Typography.quote);
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt != '\n') {
                if (charAt != '\r') {
                    if (charAt != '\"') {
                        sb.append(charAt);
                    } else {
                        sb.append("%22");
                    }
                } else {
                    sb.append("%0D");
                }
            } else {
                sb.append("%0A");
            }
        }
        sb.append(Typography.quote);
        return sb;
    }

    private long writeOrCountBytes(@Nullable OutputStream outputStream, boolean z) throws IOException {
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

    public String boundary() {
        return this.boundary;
    }

    @Override // com.baidu.searchbox.network.outback.core.RequestBody
    public long contentLength() throws IOException {
        long j = this.contentLength;
        if (j != -1) {
            return j;
        }
        long writeOrCountBytes = writeOrCountBytes(null, true);
        this.contentLength = writeOrCountBytes;
        return writeOrCountBytes;
    }

    @Override // com.baidu.searchbox.network.outback.core.RequestBody
    public MediaType contentType() {
        return this.contentType;
    }

    public List<Part> parts() {
        return this.parts;
    }

    public int size() {
        return this.parts.size();
    }

    public MediaType type() {
        return this.originalType;
    }

    public Part part(int i) {
        return this.parts.get(i);
    }

    @Override // com.baidu.searchbox.network.outback.core.RequestBody
    public void writeTo(OutputStream outputStream) throws IOException {
        writeOrCountBytes(outputStream, false);
    }
}
