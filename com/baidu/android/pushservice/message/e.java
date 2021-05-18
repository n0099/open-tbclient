package com.baidu.android.pushservice.message;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public short f3528a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f3529b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f3530c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3531d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3532e;

    /* renamed from: f  reason: collision with root package name */
    public k f3533f;

    public e(short s) {
        this.f3528a = s;
    }

    public short a() {
        return this.f3528a;
    }

    public void a(k kVar) {
        this.f3533f = kVar;
    }

    public void a(boolean z) {
        this.f3532e = z;
    }

    public byte[] b() {
        return this.f3529b;
    }

    public boolean c() {
        return this.f3530c;
    }

    public boolean d() {
        return this.f3532e;
    }

    public k e() {
        return this.f3533f;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("type : ");
        stringBuffer.append((int) this.f3528a);
        stringBuffer.append(", needReply: ");
        stringBuffer.append(this.f3530c);
        return stringBuffer.toString();
    }
}
