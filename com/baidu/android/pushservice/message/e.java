package com.baidu.android.pushservice.message;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public short f3491a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f3492b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f3493c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3494d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3495e;

    /* renamed from: f  reason: collision with root package name */
    public k f3496f;

    public e(short s) {
        this.f3491a = s;
    }

    public short a() {
        return this.f3491a;
    }

    public void a(k kVar) {
        this.f3496f = kVar;
    }

    public void a(boolean z) {
        this.f3495e = z;
    }

    public byte[] b() {
        return this.f3492b;
    }

    public boolean c() {
        return this.f3493c;
    }

    public boolean d() {
        return this.f3495e;
    }

    public k e() {
        return this.f3496f;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("type : ");
        stringBuffer.append((int) this.f3491a);
        stringBuffer.append(", needReply: ");
        stringBuffer.append(this.f3493c);
        return stringBuffer.toString();
    }
}
