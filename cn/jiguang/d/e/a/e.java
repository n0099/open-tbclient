package cn.jiguang.d.e.a;

import cn.jiguang.api.h;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public final class e extends h {
    int a;
    int b;
    String c;
    int d;
    int e;
    String f;

    public e(cn.jiguang.d.e.a.a.c cVar, ByteBuffer byteBuffer) {
        super(cVar, byteBuffer);
    }

    public final int a() {
        return this.d;
    }

    @Override // cn.jiguang.api.f
    public final String getName() {
        return "LoginResponse";
    }

    @Override // cn.jiguang.api.f
    public final int getSid() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.api.f
    public final boolean isNeedParseeErrorMsg() {
        return true;
    }

    @Override // cn.jiguang.api.h, cn.jiguang.api.f
    public final void parseBody() {
        super.parseBody();
        ByteBuffer byteBuffer = this.body;
        this.e = -1;
        if (this.code == 0) {
            this.a = cn.jiguang.api.a.a.a(byteBuffer, this);
            this.b = cn.jiguang.api.a.a.b(byteBuffer, this);
            this.c = cn.jiguang.api.a.c.e(byteBuffer, this);
            this.d = cn.jiguang.api.a.a.a(byteBuffer, this);
            try {
                this.e = byteBuffer.get();
            } catch (Throwable th) {
            }
        } else if (this.code == 1012) {
            this.f = cn.jiguang.api.a.c.e(byteBuffer, this);
            cn.jiguang.c.a.a(this.f);
        }
        cn.jiguang.d.a.a.a(this.e);
    }

    @Override // cn.jiguang.api.h, cn.jiguang.api.f
    public final String toString() {
        return "[LoginResponse] - sid:" + this.a + ", serverVersion:" + this.b + ", sessionKey:" + this.c + ", serverTime:" + this.d + ", idc:" + this.e + ", connectInfo:" + this.f + " - " + super.toString();
    }

    @Override // cn.jiguang.api.h, cn.jiguang.api.f
    public final void writeBody() {
        super.writeBody();
        writeInt4(this.a);
        writeInt2(this.b);
        writeTlv2(this.c);
        writeInt4(this.d);
    }
}
