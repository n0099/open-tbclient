package com.baidu.android.pushservice.message;
/* loaded from: classes3.dex */
public class CrossPushMessage extends PublicMsg {

    /* renamed from: a  reason: collision with root package name */
    public String f1441a;

    /* renamed from: b  reason: collision with root package name */
    public String f1442b;

    @Override // com.baidu.android.pushservice.message.PublicMsg
    public String toString() {
        return super.toString() + " mDestPkg = " + this.f1441a + "\r\n mDestIcon = " + this.f1442b;
    }
}
