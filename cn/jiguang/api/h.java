package cn.jiguang.api;

import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public abstract class h extends f {
    public int code;

    public h(int i, int i2, long j, long j2, int i3, String str) {
        super(false, i, i2, j, -1, j2);
        this.code = i3;
    }

    public h(Object obj, ByteBuffer byteBuffer) {
        super(false, obj, byteBuffer);
    }

    public h(ByteBuffer byteBuffer, byte[] bArr) {
        super(false, byteBuffer, bArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.api.f
    public void parseBody() {
        if (isNeedParseeErrorMsg()) {
            this.code = cn.jiguang.api.a.a.b(this.body, this);
        }
    }

    @Override // cn.jiguang.api.f
    public String toString() {
        return "JResponse{code=" + this.code + '}';
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.api.f
    public void writeBody() {
        if (this.code >= 0) {
            writeInt2(this.code);
        }
    }
}
