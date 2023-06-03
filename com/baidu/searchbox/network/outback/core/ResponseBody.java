package com.baidu.searchbox.network.outback.core;

import androidx.annotation.Nullable;
import com.baidu.searchbox.network.outback.core.internal.Util;
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
/* loaded from: classes4.dex */
public abstract class ResponseBody implements Closeable {
    public static final int DEFAULT_BUFFER_SIZE = 8192;
    @Nullable
    public Reader reader;

    public abstract long contentLength();

    @Nullable
    public abstract MediaType contentType();

    public abstract InputStream inputStream();

    /* loaded from: classes4.dex */
    public static final class BomAwareReader extends Reader {
        public final BufferedInputStream bis;
        public final Charset charset;
        public boolean closed;
        @Nullable
        public Reader delegate;

        public BomAwareReader(InputStream inputStream, Charset charset) {
            this.bis = new BufferedInputStream(inputStream);
            this.charset = charset;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.closed = true;
            Reader reader = this.delegate;
            if (reader != null) {
                reader.close();
            } else {
                this.bis.close();
            }
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
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
    }

    private Charset charset() {
        MediaType contentType = contentType();
        if (contentType != null) {
            return contentType.charset(Util.UTF_8);
        }
        return Util.UTF_8;
    }

    public final InputStream byteStream() {
        return inputStream();
    }

    public final Reader charStream() {
        Reader reader = this.reader;
        if (reader == null) {
            BomAwareReader bomAwareReader = new BomAwareReader(inputStream(), charset());
            this.reader = bomAwareReader;
            return bomAwareReader;
        }
        return reader;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Util.closeQuietly(inputStream());
    }

    public final String string() throws IOException {
        ByteBuffer wrap = ByteBuffer.wrap(bytes());
        return Util.bomAwareCharset(wrap.duplicate(), charset()).decode(wrap).toString();
    }

    public static ResponseBody create(@Nullable final MediaType mediaType, final long j, final InputStream inputStream) {
        if (inputStream != null) {
            return new ResponseBody() { // from class: com.baidu.searchbox.network.outback.core.ResponseBody.1
                @Override // com.baidu.searchbox.network.outback.core.ResponseBody
                public long contentLength() {
                    return j;
                }

                @Override // com.baidu.searchbox.network.outback.core.ResponseBody
                @Nullable
                public MediaType contentType() {
                    return MediaType.this;
                }

                @Override // com.baidu.searchbox.network.outback.core.ResponseBody
                public InputStream inputStream() {
                    return inputStream;
                }
            };
        }
        throw new NullPointerException("source == null");
    }

    public static ResponseBody create(@Nullable MediaType mediaType, String str) {
        Charset charset = Util.UTF_8;
        if (mediaType != null && (charset = mediaType.charset()) == null) {
            charset = Util.UTF_8;
            mediaType = MediaType.parse(mediaType + "; charset=utf-8");
        }
        return create(mediaType, str.getBytes(charset));
    }

    public static ResponseBody create(@Nullable MediaType mediaType, byte[] bArr) {
        return create(mediaType, bArr.length, new ByteArrayInputStream(bArr));
    }

    public final byte[] bytes() throws IOException {
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
    }
}
