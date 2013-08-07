package com.baidu.android.pushservice.message;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f590a;
    public int b;
    public byte[] c;
    public boolean d;
    private boolean e;

    public void a(boolean z) {
        this.e = z;
    }

    public boolean a() {
        return this.e;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("id : ");
        stringBuffer.append(this.f590a);
        stringBuffer.append(", version: ");
        stringBuffer.append(this.b);
        stringBuffer.append(", needReply: ");
        stringBuffer.append(this.d);
        return stringBuffer.toString();
    }
}
