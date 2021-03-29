package com.baidu.appsearch.update.patchupdate;

import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a implements d {

    /* renamed from: a  reason: collision with root package name */
    public ByteBuffer f4076a;

    public a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            throw new NullPointerException("input parameter bb is null");
        }
        this.f4076a = byteBuffer;
        byteBuffer.rewind();
        try {
            a(0L);
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    public a(byte[] bArr) {
        this(ByteBuffer.wrap(bArr));
    }

    @Override // com.baidu.appsearch.update.patchupdate.d
    public int a(ByteBuffer byteBuffer) {
        if (this.f4076a.hasRemaining()) {
            int i = 0;
            while (this.f4076a.hasRemaining() && byteBuffer.hasRemaining()) {
                byteBuffer.put(this.f4076a.get());
                i++;
            }
            return i;
        }
        return -1;
    }

    @Override // com.baidu.appsearch.update.patchupdate.d
    public void a(long j) {
        if (j <= this.f4076a.limit()) {
            this.f4076a.position((int) j);
            return;
        }
        throw new IOException("pos " + j + " cannot seek " + this.f4076a.limit());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f4076a = null;
    }

    public String toString() {
        return "BBSeekable bb=" + this.f4076a.position() + "-" + this.f4076a.limit();
    }
}
