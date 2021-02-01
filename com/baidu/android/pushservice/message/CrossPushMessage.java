package com.baidu.android.pushservice.message;
/* loaded from: classes5.dex */
public class CrossPushMessage extends PublicMsg {

    /* renamed from: a  reason: collision with root package name */
    public String f1448a;

    /* renamed from: b  reason: collision with root package name */
    public String f1449b;

    @Override // com.baidu.android.pushservice.message.PublicMsg
    public String toString() {
        return super.toString() + " mDestPkg = " + this.f1448a + "\r\n mDestIcon = " + this.f1449b;
    }
}
