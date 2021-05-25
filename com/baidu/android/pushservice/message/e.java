package com.baidu.android.pushservice.message;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public short f3531a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f3532b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f3533c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3534d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3535e;

    /* renamed from: f  reason: collision with root package name */
    public k f3536f;

    public e(short s) {
        this.f3531a = s;
    }

    public short a() {
        return this.f3531a;
    }

    public void a(k kVar) {
        this.f3536f = kVar;
    }

    public void a(boolean z) {
        this.f3535e = z;
    }

    public byte[] b() {
        return this.f3532b;
    }

    public boolean c() {
        return this.f3533c;
    }

    public boolean d() {
        return this.f3535e;
    }

    public k e() {
        return this.f3536f;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("type : ");
        stringBuffer.append((int) this.f3531a);
        stringBuffer.append(", needReply: ");
        stringBuffer.append(this.f3533c);
        return stringBuffer.toString();
    }
}
