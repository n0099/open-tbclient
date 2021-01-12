package com.baidu.android.pushservice.message;
/* loaded from: classes14.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    protected short f1468a;

    /* renamed from: b  reason: collision with root package name */
    protected byte[] f1469b;
    protected boolean c;
    protected boolean d = false;
    protected boolean e;
    private k f;

    public e(short s) {
        this.f1468a = s;
    }

    public short a() {
        return this.f1468a;
    }

    public void a(k kVar) {
        this.f = kVar;
    }

    public void a(boolean z) {
        this.e = z;
    }

    public byte[] b() {
        return this.f1469b;
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
        stringBuffer.append((int) this.f1468a);
        stringBuffer.append(", needReply: ");
        stringBuffer.append(this.c);
        return stringBuffer.toString();
    }
}
