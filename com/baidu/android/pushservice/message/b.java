package com.baidu.android.pushservice.message;
/* loaded from: classes.dex */
public class b {
    public int a;
    public int b;
    public byte[] c;
    public boolean d;

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("id : ");
        stringBuffer.append(this.a);
        stringBuffer.append(", version: ");
        stringBuffer.append(this.b);
        stringBuffer.append(", needReplay: ");
        stringBuffer.append(this.d);
        return stringBuffer.toString();
    }
}
