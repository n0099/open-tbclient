package cn.jiguang.api;

import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public abstract class g extends f {
    public g(int i, int i2, long j) {
        super(true, i, i2, j);
    }

    public g(Object obj, ByteBuffer byteBuffer) {
        super(true, obj, byteBuffer);
    }

    public void setJuid(long j) {
        this.head.a(j);
    }

    public void setSid(int i) {
        this.head.b(i);
    }
}
