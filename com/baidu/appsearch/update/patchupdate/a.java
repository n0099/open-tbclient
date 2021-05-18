package com.baidu.appsearch.update.patchupdate;

import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a implements d {

    /* renamed from: a  reason: collision with root package name */
    public ByteBuffer f4175a;

    public a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            throw new NullPointerException("input parameter bb is null");
        }
        this.f4175a = byteBuffer;
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
        if (this.f4175a.hasRemaining()) {
            int i2 = 0;
            while (this.f4175a.hasRemaining() && byteBuffer.hasRemaining()) {
                byteBuffer.put(this.f4175a.get());
                i2++;
            }
            return i2;
        }
        return -1;
    }

    @Override // com.baidu.appsearch.update.patchupdate.d
    public void a(long j) {
        if (j <= this.f4175a.limit()) {
            this.f4175a.position((int) j);
            return;
        }
        throw new IOException("pos " + j + " cannot seek " + this.f4175a.limit());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f4175a = null;
    }

    public String toString() {
        return "BBSeekable bb=" + this.f4175a.position() + "-" + this.f4175a.limit();
    }
}
