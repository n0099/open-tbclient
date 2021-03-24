package com.baidu.android.pushservice.message;
/* loaded from: classes2.dex */
public class CrossPushMessage extends PublicMsg {

    /* renamed from: a  reason: collision with root package name */
    public String f3420a;

    /* renamed from: b  reason: collision with root package name */
    public String f3421b;

    @Override // com.baidu.android.pushservice.message.PublicMsg
    public String toString() {
        return super.toString() + " mDestPkg = " + this.f3420a + "\r\n mDestIcon = " + this.f3421b;
    }
}
