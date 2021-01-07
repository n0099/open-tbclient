package com.baidu.android.pushservice.message;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    protected short f1462a;

    /* renamed from: b  reason: collision with root package name */
    protected byte[] f1463b;
    protected boolean c;
    protected boolean d = false;
    protected boolean e;
    private k f;

    public e(short s) {
        this.f1462a = s;
    }

    public short a() {
        return this.f1462a;
    }

    public void a(k kVar) {
        this.f = kVar;
    }

    public void a(boolean z) {
        this.e = z;
    }

    public byte[] b() {
        return this.f1463b;
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
        stringBuffer.append((int) this.f1462a);
        stringBuffer.append(", needReply: ");
        stringBuffer.append(this.c);
        return stringBuffer.toString();
    }
}
