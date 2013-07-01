package com.baidu.android.pushservice.message;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f322a;
    public int b;
    public byte[] c;
    public boolean d;

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("id : ");
        stringBuffer.append(this.f322a);
        stringBuffer.append(", version: ");
        stringBuffer.append(this.b);
        stringBuffer.append(", needReply: ");
        stringBuffer.append(this.d);
        return stringBuffer.toString();
    }
}
