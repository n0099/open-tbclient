package com.baidu.searchbox.network.outback.core;

import androidx.annotation.Nullable;
import com.baidu.searchbox.network.outback.core.internal.Util;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
/* loaded from: classes2.dex */
public abstract class RequestBody {
    public long contentLength() throws IOException {
        return -1L;
    }

    @Nullable
    public abstract MediaType contentType();

    public abstract void writeTo(OutputStream outputStream) throws IOException;

    public static RequestBody create(@Nullable final MediaType mediaType, final File file) {
        if (file != null) {
            return new RequestBody() { // from class: com.baidu.searchbox.network.outback.core.RequestBody.2
                @Override // com.baidu.searchbox.network.outback.core.RequestBody
                public long contentLength() {
                    return file.length();
                }

                @Override // com.baidu.searchbox.network.outback.core.RequestBody
                @Nullable
                public MediaType contentType() {
                    return MediaType.this;
                }

                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: java.io.FileInputStream */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.searchbox.network.outback.core.RequestBody
                public void writeTo(OutputStream outputStream) throws IOException {
                    FileChannel fileChannel;
                    FileChannel fileChannel2 = null;
                    try {
                        FileInputStream fileInputStream = new FileInputStream(file);
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
            };
        }
        throw new NullPointerException("file == null");
    }

    public static RequestBody create(@Nullable MediaType mediaType, String str) {
        Charset charset = Util.UTF_8;
        if (mediaType != null && (charset = mediaType.charset()) == null) {
            charset = Util.UTF_8;
            mediaType = MediaType.parse(mediaType + "; charset=utf-8");
        }
        return create(mediaType, str.getBytes(charset));
    }

    public static RequestBody create(@Nullable MediaType mediaType, byte[] bArr) {
        return create(mediaType, bArr, 0, bArr.length);
    }

    public static RequestBody create(@Nullable final MediaType mediaType, final byte[] bArr, final int i, final int i2) {
        if (bArr != null) {
            Util.checkOffsetAndCount(bArr.length, i, i2);
            return new RequestBody() { // from class: com.baidu.searchbox.network.outback.core.RequestBody.1
                @Override // com.baidu.searchbox.network.outback.core.RequestBody
                public long contentLength() {
                    return i2;
                }

                @Override // com.baidu.searchbox.network.outback.core.RequestBody
                @Nullable
                public MediaType contentType() {
                    return MediaType.this;
                }

                @Override // com.baidu.searchbox.network.outback.core.RequestBody
                public void writeTo(OutputStream outputStream) throws IOException {
                    outputStream.write(bArr, i, i2);
                }
            };
        }
        throw new NullPointerException("content == null");
    }
}
