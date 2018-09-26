package cn.jpush.a;

import cn.jiguang.api.h;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public final class d extends h {
    String a;
    long b;

    public d(Object obj, ByteBuffer byteBuffer) {
        super(obj, byteBuffer);
        this.b = -1L;
    }

    public final String a() {
        return this.a;
    }

    @Override // cn.jiguang.api.f
    public final String getName() {
        return "TagaliasResponse";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.api.f
    public final boolean isNeedParseeErrorMsg() {
        return getCommand() == 10;
    }

    @Override // cn.jiguang.api.h, cn.jiguang.api.f
    public final void parseBody() {
        super.parseBody();
        if (this.code > 0) {
            return;
        }
        this.a = cn.jiguang.api.a.c.e(this.body, this);
    }

    @Override // cn.jiguang.api.h, cn.jiguang.api.f
    public final String toString() {
        return "[TagaliasResponse] - action:" + this.a + " - " + super.toString();
    }

    @Override // cn.jiguang.api.h, cn.jiguang.api.f
    public final void writeBody() {
        super.writeBody();
    }
}
