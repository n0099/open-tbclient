package com.baidu.android.pushservice.message;
/* loaded from: classes2.dex */
public class e {
    protected short a;
    protected short b;
    protected byte[] c;
    protected boolean d;
    protected boolean e = false;
    protected boolean f;
    private k g;

    public e(short s) {
        this.a = s;
    }

    public void a(k kVar) {
        this.g = kVar;
    }

    public void a(boolean z) {
        this.f = z;
    }

    public byte[] a() {
        return this.c;
    }

    public boolean b() {
        return this.d;
    }

    public boolean c() {
        return this.f;
    }

    public k d() {
        return this.g;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("type : ");
        stringBuffer.append((int) this.a);
        stringBuffer.append(", version: ");
        stringBuffer.append((int) this.b);
        stringBuffer.append(", needReply: ");
        stringBuffer.append(this.d);
        return stringBuffer.toString();
    }
}
