package cn.jiguang.d.e.a;

import cn.jiguang.api.h;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public final class b extends h {
    public b(cn.jiguang.d.e.a.a.c cVar, ByteBuffer byteBuffer) {
        super(cVar, byteBuffer);
    }

    @Override // cn.jiguang.api.f
    public final String getName() {
        return "CommonResponse";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.api.f
    public final boolean isNeedParseeErrorMsg() {
        return true;
    }

    @Override // cn.jiguang.api.h, cn.jiguang.api.f
    public final void parseBody() {
        super.parseBody();
    }

    @Override // cn.jiguang.api.h, cn.jiguang.api.f
    public final String toString() {
        return "[CommonResponse] - " + super.toString();
    }

    @Override // cn.jiguang.api.h, cn.jiguang.api.f
    public final void writeBody() {
        super.writeBody();
    }
}
