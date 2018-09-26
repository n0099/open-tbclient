package cn.jiguang.d.e.a;

import cn.jiguang.api.h;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public final class c extends h {
    long a;
    String b;

    public c(cn.jiguang.d.e.a.a.c cVar, ByteBuffer byteBuffer) {
        super(cVar, byteBuffer);
    }

    public final long a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    @Override // cn.jiguang.api.f
    public final String getName() {
        return "CtrlResponse";
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
        this.a = cn.jiguang.api.a.a.d(byteBuffer, this);
        this.b = cn.jiguang.api.a.c.e(byteBuffer, this);
    }

    @Override // cn.jiguang.api.h, cn.jiguang.api.f
    public final String toString() {
        return "[CtrlResponse] - senderId:" + this.a + ", msgContent:" + this.b + " - " + super.toString();
    }

    @Override // cn.jiguang.api.h, cn.jiguang.api.f
    public final void writeBody() {
        super.writeBody();
        writeLong8(this.a);
        writeTlv2(this.b);
    }
}
