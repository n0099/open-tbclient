package com.baidu.android.pushservice.message;
/* loaded from: classes7.dex */
public class e {
    protected short a;
    protected byte[] b;
    protected boolean c;
    protected boolean d = false;
    protected boolean e;
    private k f;

    public e(short s) {
        this.a = s;
    }

    public short a() {
        return this.a;
    }

    public void a(k kVar) {
        this.f = kVar;
    }

    public void a(boolean z) {
        this.e = z;
    }

    public byte[] b() {
        return this.b;
    }

    public boolean c() {
        return this.c;
    }

    public boolean d() {
        return this.e;
    }

    public k e() {
        return this.f;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("type : ");
        stringBuffer.append((int) this.a);
        stringBuffer.append(", needReply: ");
        stringBuffer.append(this.c);
        return stringBuffer.toString();
    }
}
