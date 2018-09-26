package cn.jiguang.d.e.a;

import cn.jiguang.api.h;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public final class f extends h {
    long a;
    String b;
    String c;
    String d;
    String e;
    String f;

    public f(cn.jiguang.d.e.a.a.c cVar, ByteBuffer byteBuffer) {
        super(cVar, byteBuffer);
    }

    public final String a() {
        return this.b;
    }

    public final String b() {
        return this.c;
    }

    public final String c() {
        return this.d;
    }

    @Override // cn.jiguang.api.f
    public final long getJuid() {
        return this.a;
    }

    @Override // cn.jiguang.api.f
    public final String getName() {
        return "RegisterResponse";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.api.f
    public final boolean isNeedParseeErrorMsg() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.api.h, cn.jiguang.api.f
    public final void parseBody() {
        super.parseBody();
        ByteBuffer byteBuffer = this.body;
        if (this.code == 0) {
            this.a = cn.jiguang.api.a.a.d(byteBuffer, this);
            this.b = cn.jiguang.api.a.c.e(byteBuffer, this);
            this.c = cn.jiguang.api.a.c.e(byteBuffer, this);
        } else if (this.code == 1007) {
            this.e = cn.jiguang.api.a.c.e(byteBuffer, this);
        } else if (this.code == 1012) {
            this.f = cn.jiguang.api.a.c.e(byteBuffer, this);
            cn.jiguang.c.a.a(this.f);
        }
    }

    @Override // cn.jiguang.api.h, cn.jiguang.api.f
    public final String toString() {
        return "[RegisterResponse] - juid:" + this.a + ", password:" + this.b + ", regId:" + this.c + ", deviceId:" + this.d + ", connectInfo:" + this.f + " - " + super.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.api.h, cn.jiguang.api.f
    public final void writeBody() {
        super.writeBody();
        writeLong8(this.a);
        writeTlv2(this.b);
        writeTlv2(this.c);
        writeTlv2(this.d);
    }
}
