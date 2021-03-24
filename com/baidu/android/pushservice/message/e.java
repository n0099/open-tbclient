package com.baidu.android.pushservice.message;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public short f3455a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f3456b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f3457c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3458d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3459e;

    /* renamed from: f  reason: collision with root package name */
    public k f3460f;

    public e(short s) {
        this.f3455a = s;
    }

    public short a() {
        return this.f3455a;
    }

    public void a(k kVar) {
        this.f3460f = kVar;
    }

    public void a(boolean z) {
        this.f3459e = z;
    }

    public byte[] b() {
        return this.f3456b;
    }

    public boolean c() {
        return this.f3457c;
    }

    public boolean d() {
        return this.f3459e;
    }

    public k e() {
        return this.f3460f;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("type : ");
        stringBuffer.append((int) this.f3455a);
        stringBuffer.append(", needReply: ");
        stringBuffer.append(this.f3457c);
        return stringBuffer.toString();
    }
}
