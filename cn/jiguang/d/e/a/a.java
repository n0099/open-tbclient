package cn.jiguang.d.e.a;

import cn.jiguang.api.h;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public final class a extends h {
    int a;
    int b;
    int c;
    long d;

    public a(cn.jiguang.d.e.a.a.c cVar, ByteBuffer byteBuffer) {
        super(cVar, byteBuffer);
    }

    public final int a() {
        return this.a;
    }

    @Override // cn.jiguang.api.f
    public final String getName() {
        return "ACK Response";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.api.f
    public final boolean isNeedParseeErrorMsg() {
        return false;
    }

    @Override // cn.jiguang.api.h, cn.jiguang.api.f
    public final void parseBody() {
        super.parseBody();
        ByteBuffer byteBuffer = this.body;
        this.a = cn.jiguang.api.a.a.c(byteBuffer, this).byteValue();
        this.b = cn.jiguang.api.a.a.c(byteBuffer, this).byteValue();
        this.c = cn.jiguang.api.a.a.c(byteBuffer, this).byteValue();
        this.d = cn.jiguang.api.a.a.d(byteBuffer, this);
    }

    @Override // cn.jiguang.api.h, cn.jiguang.api.f
    public final String toString() {
        return "[AckNormal] - requestCommand:" + this.a + ", step:" + this.b + ", status:" + this.c + ", stime:" + this.d + " - " + super.toString();
    }

    @Override // cn.jiguang.api.h, cn.jiguang.api.f
    public final void writeBody() {
        super.writeBody();
        writeInt1(this.a);
        writeInt1(this.b);
        writeInt1(this.c);
        writeLong8(this.d);
    }
}
