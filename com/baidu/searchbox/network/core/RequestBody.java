package com.baidu.searchbox.network.core;

import android.support.annotation.Nullable;
import com.baidu.searchbox.network.core.internal.Util;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import okio.BufferedSink;
import okio.ByteString;
import okio.Okio;
import okio.Source;
/* loaded from: classes5.dex */
public abstract class RequestBody {
    @Nullable
    public abstract MediaType contentType();

    public abstract void writeTo(BufferedSink bufferedSink) throws IOException;

    public long contentLength() throws IOException {
        return -1L;
    }

    public static RequestBody create(@Nullable MediaType mediaType, String str) {
        Charset charset = Util.UTF_8;
        if (mediaType != null && (charset = mediaType.charset()) == null) {
            charset = Util.UTF_8;
            mediaType = MediaType.parse(mediaType + "; charset=utf-8");
        }
        return create(mediaType, str.getBytes(charset));
    }

    public static RequestBody create(@Nullable final MediaType mediaType, final ByteString byteString) {
        return new RequestBody() { // from class: com.baidu.searchbox.network.core.RequestBody.1
            @Override // com.baidu.searchbox.network.core.RequestBody
            @Nullable
            public MediaType contentType() {
                return MediaType.this;
            }

            @Override // com.baidu.searchbox.network.core.RequestBody
            public long contentLength() throws IOException {
                return byteString.size();
            }

            @Override // com.baidu.searchbox.network.core.RequestBody
            public void writeTo(BufferedSink bufferedSink) throws IOException {
                bufferedSink.write(byteString);
            }
        };
    }

    public static RequestBody create(@Nullable MediaType mediaType, byte[] bArr) {
        return create(mediaType, bArr, 0, bArr.length);
    }

    public static RequestBody create(@Nullable final MediaType mediaType, final byte[] bArr, final int i, final int i2) {
        if (bArr == null) {
            throw new NullPointerException("content == null");
        }
        Util.checkOffsetAndCount(bArr.length, i, i2);
        return new RequestBody() { // from class: com.baidu.searchbox.network.core.RequestBody.2
            @Override // com.baidu.searchbox.network.core.RequestBody
            @Nullable
            public MediaType contentType() {
                return MediaType.this;
            }

            @Override // com.baidu.searchbox.network.core.RequestBody
            public long contentLength() {
                return i2;
            }

            @Override // com.baidu.searchbox.network.core.RequestBody
            public void writeTo(BufferedSink bufferedSink) throws IOException {
                bufferedSink.write(bArr, i, i2);
            }
        };
    }

    public static RequestBody create(@Nullable final MediaType mediaType, final File file) {
        if (file == null) {
            throw new NullPointerException("file == null");
        }
        return new RequestBody() { // from class: com.baidu.searchbox.network.core.RequestBody.3
            @Override // com.baidu.searchbox.network.core.RequestBody
            @Nullable
            public MediaType contentType() {
                return MediaType.this;
            }

            @Override // com.baidu.searchbox.network.core.RequestBody
            public long contentLength() {
                return file.length();
            }

            @Override // com.baidu.searchbox.network.core.RequestBody
            public void writeTo(BufferedSink bufferedSink) throws IOException {
                Source source = null;
                try {
                    source = Okio.source(file);
                    bufferedSink.writeAll(source);
                } finally {
                    Util.closeQuietly(source);
                }
            }
        };
    }
}
