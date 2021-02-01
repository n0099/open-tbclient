package com.baidu.appsearch.update.patchupdate;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public class c implements d {

    /* renamed from: a  reason: collision with root package name */
    private RandomAccessFile f1484a;

    public c(RandomAccessFile randomAccessFile) {
        if (randomAccessFile == null) {
            throw new NullPointerException("input RandomAccessFile is null");
        }
        this.f1484a = randomAccessFile;
    }

    @Override // com.baidu.appsearch.update.patchupdate.d
    public int a(ByteBuffer byteBuffer) {
        int read = this.f1484a.read(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining());
        if (read == -1) {
            return -1;
        }
        byteBuffer.position(byteBuffer.position() + read);
        return read;
    }

    @Override // com.baidu.appsearch.update.patchupdate.d
    public void a(long j) {
        this.f1484a.seek(j);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f1484a.close();
    }
}
