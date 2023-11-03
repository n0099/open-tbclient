package com.baidu.android.pushservice.w;
/* loaded from: classes.dex */
public class e {
    public short a;
    public byte[] b;
    public boolean c;
    public boolean d = false;
    public boolean e;
    public k f;

    public e(short s) {
        this.a = s;
    }

    public void a(k kVar) {
        this.f = kVar;
    }

    public void a(boolean z) {
        this.e = z;
    }

    public byte[] a() {
        return this.b;
    }

    public k b() {
        return this.f;
    }

    public short c() {
        return this.a;
    }

    public boolean d() {
        return this.e;
    }

    public boolean e() {
        return this.c;
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
