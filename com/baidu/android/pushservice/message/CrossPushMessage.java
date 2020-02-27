package com.baidu.android.pushservice.message;
/* loaded from: classes8.dex */
public class CrossPushMessage extends PublicMsg {
    public String a;
    public String b;

    @Override // com.baidu.android.pushservice.message.PublicMsg
    public String toString() {
        return super.toString() + " mDestPkg = " + this.a + "\r\n mDestIcon = " + this.b;
    }
}
