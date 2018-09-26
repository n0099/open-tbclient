package cn.jpush.a;

import cn.jiguang.api.h;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public final class a extends h {
    public a(Object obj, ByteBuffer byteBuffer) {
        super(obj, byteBuffer);
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
