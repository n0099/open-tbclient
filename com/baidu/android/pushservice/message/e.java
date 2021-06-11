package com.baidu.android.pushservice.message;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public short f3550a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f3551b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f3552c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3553d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3554e;

    /* renamed from: f  reason: collision with root package name */
    public k f3555f;

    public e(short s) {
        this.f3550a = s;
    }

    public short a() {
        return this.f3550a;
    }

    public void a(k kVar) {
        this.f3555f = kVar;
    }

    public void a(boolean z) {
        this.f3554e = z;
    }

    public byte[] b() {
        return this.f3551b;
    }

    public boolean c() {
        return this.f3552c;
    }

    public boolean d() {
        return this.f3554e;
    }

    public k e() {
        return this.f3555f;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("type : ");
        stringBuffer.append((int) this.f3550a);
        stringBuffer.append(", needReply: ");
        stringBuffer.append(this.f3552c);
        return stringBuffer.toString();
    }
}
