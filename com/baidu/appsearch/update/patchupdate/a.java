package com.baidu.appsearch.update.patchupdate;

import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public class a implements d {

    /* renamed from: a  reason: collision with root package name */
    private ByteBuffer f1254a;

    public a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            throw new NullPointerException("input parameter bb is null");
        }
        this.f1254a = byteBuffer;
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
        if (this.f1254a.hasRemaining()) {
            int i = 0;
            while (this.f1254a.hasRemaining() && byteBuffer.hasRemaining()) {
                byteBuffer.put(this.f1254a.get());
                i++;
            }
            return i;
        }
        return -1;
    }

    @Override // com.baidu.appsearch.update.patchupdate.d
    public void a(long j) {
        if (j > this.f1254a.limit()) {
            throw new IOException("pos " + j + " cannot seek " + this.f1254a.limit());
        }
        this.f1254a.position((int) j);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f1254a = null;
    }

    public String toString() {
        return "BBSeekable bb=" + this.f1254a.position() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.f1254a.limit();
    }
}
