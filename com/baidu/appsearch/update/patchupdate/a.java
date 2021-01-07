package com.baidu.appsearch.update.patchupdate;

import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class a implements d {

    /* renamed from: a  reason: collision with root package name */
    private ByteBuffer f1477a;

    public a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            throw new NullPointerException("input parameter bb is null");
        }
        this.f1477a = byteBuffer;
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
        if (this.f1477a.hasRemaining()) {
            int i = 0;
            while (this.f1477a.hasRemaining() && byteBuffer.hasRemaining()) {
                byteBuffer.put(this.f1477a.get());
                i++;
            }
            return i;
        }
        return -1;
    }

    @Override // com.baidu.appsearch.update.patchupdate.d
    public void a(long j) {
        if (j > this.f1477a.limit()) {
            throw new IOException("pos " + j + " cannot seek " + this.f1477a.limit());
        }
        this.f1477a.position((int) j);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f1477a = null;
    }

    public String toString() {
        return "BBSeekable bb=" + this.f1477a.position() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.f1477a.limit();
    }
}
