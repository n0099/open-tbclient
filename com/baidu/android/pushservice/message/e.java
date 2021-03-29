package com.baidu.android.pushservice.message;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public short f3456a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f3457b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f3458c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3459d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3460e;

    /* renamed from: f  reason: collision with root package name */
    public k f3461f;

    public e(short s) {
        this.f3456a = s;
    }

    public short a() {
        return this.f3456a;
    }

    public void a(k kVar) {
        this.f3461f = kVar;
    }

    public void a(boolean z) {
        this.f3460e = z;
    }

    public byte[] b() {
        return this.f3457b;
    }

    public boolean c() {
        return this.f3458c;
    }

    public boolean d() {
        return this.f3460e;
    }

    public k e() {
        return this.f3461f;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("type : ");
        stringBuffer.append((int) this.f3456a);
        stringBuffer.append(", needReply: ");
        stringBuffer.append(this.f3458c);
        return stringBuffer.toString();
    }
}
