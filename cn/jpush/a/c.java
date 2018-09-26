package cn.jpush.a;

import cn.jiguang.api.g;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public final class c extends g {
    String a;
    String b;

    public c(int i, int i2, long j, String str, String str2) {
        super(i, i2, j);
        this.a = str;
        this.b = str2;
    }

    public final String a() {
        return this.b;
    }

    @Override // cn.jiguang.api.f
    public final String getName() {
        return "TagaliasRequest";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.api.f
    public final boolean isNeedParseeErrorMsg() {
        return true;
    }

    @Override // cn.jiguang.api.f
    public final void parseBody() {
        ByteBuffer byteBuffer = this.body;
        this.a = cn.jiguang.api.a.c.i(byteBuffer);
        this.b = cn.jiguang.api.a.c.i(byteBuffer);
    }

    @Override // cn.jiguang.api.f
    public final String toString() {
        return "[TagaliasRequest] - appKey:" + this.a + ", action:" + this.b + " - " + super.toString();
    }

    @Override // cn.jiguang.api.f
    public final void writeBody() {
        writeTlv2(this.a);
        writeTlv2(this.b);
    }
}
