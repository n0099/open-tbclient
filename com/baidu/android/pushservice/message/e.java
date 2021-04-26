package com.baidu.android.pushservice.message;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public short f3527a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f3528b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f3529c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3530d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3531e;

    /* renamed from: f  reason: collision with root package name */
    public k f3532f;

    public e(short s) {
        this.f3527a = s;
    }

    public short a() {
        return this.f3527a;
    }

    public void a(k kVar) {
        this.f3532f = kVar;
    }

    public void a(boolean z) {
        this.f3531e = z;
    }

    public byte[] b() {
        return this.f3528b;
    }

    public boolean c() {
        return this.f3529c;
    }

    public boolean d() {
        return this.f3531e;
    }

    public k e() {
        return this.f3532f;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("type : ");
        stringBuffer.append((int) this.f3527a);
        stringBuffer.append(", needReply: ");
        stringBuffer.append(this.f3529c);
        return stringBuffer.toString();
    }
}
