package com.baidu.android.pushservice.message;
/* loaded from: classes5.dex */
public class CrossPushMessage extends PublicMsg {

    /* renamed from: a  reason: collision with root package name */
    public String f1232a;
    public String b;

    @Override // com.baidu.android.pushservice.message.PublicMsg
    public String toString() {
        return super.toString() + " mDestPkg = " + this.f1232a + "\r\n mDestIcon = " + this.b;
    }
}
