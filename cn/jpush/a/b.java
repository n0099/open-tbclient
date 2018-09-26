package cn.jpush.a;

import cn.jiguang.api.h;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public final class b extends h {
    int a;
    long b;
    String c;

    public b(Object obj, ByteBuffer byteBuffer) {
        super(obj, byteBuffer);
    }

    public final int a() {
        return this.a;
    }

    public final long b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    @Override // cn.jiguang.api.f
    public final String getName() {
        return "MessagePush";
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
        this.b = cn.jiguang.api.a.a.d(byteBuffer, this);
        this.c = cn.jiguang.api.a.c.e(byteBuffer, this);
    }

    @Override // cn.jiguang.api.h, cn.jiguang.api.f
    public final String toString() {
        return "[MessagePush] - msgType:" + this.a + ", msgId:" + this.b + ", msgContent:" + this.c + " - " + super.toString();
    }

    @Override // cn.jiguang.api.h, cn.jiguang.api.f
    public final void writeBody() {
        super.writeBody();
        writeInt1(this.a);
        writeLong8(this.b);
        writeTlv2(this.c);
    }
}
