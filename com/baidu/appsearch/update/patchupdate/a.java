package com.baidu.appsearch.update.patchupdate;

import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes17.dex */
public class a implements d {

    /* renamed from: a  reason: collision with root package name */
    private ByteBuffer f1186a;

    public a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            throw new NullPointerException("input parameter bb is null");
        }
        this.f1186a = byteBuffer;
        byteBuffer.rewind();
        try {
            a(0L);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public a(byte[] bArr) {
        this(ByteBuffer.wrap(bArr));
    }

    @Override // com.baidu.appsearch.update.patchupdate.d
    public int a(ByteBuffer byteBuffer) {
        if (this.f1186a.hasRemaining()) {
            int i = 0;
            while (this.f1186a.hasRemaining() && byteBuffer.hasRemaining()) {
                byteBuffer.put(this.f1186a.get());
                i++;
            }
            return i;
        }
        return -1;
    }

    @Override // com.baidu.appsearch.update.patchupdate.d
    public void a(long j) {
        if (j > this.f1186a.limit()) {
            throw new IOException("pos " + j + " cannot seek " + this.f1186a.limit());
        }
        this.f1186a.position((int) j);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f1186a = null;
    }

    public String toString() {
        return "BBSeekable bb=" + this.f1186a.position() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.f1186a.limit();
    }
}
