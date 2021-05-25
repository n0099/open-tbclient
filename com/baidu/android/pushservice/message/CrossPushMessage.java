package com.baidu.android.pushservice.message;
/* loaded from: classes.dex */
public class CrossPushMessage extends PublicMsg {

    /* renamed from: a  reason: collision with root package name */
    public String f3495a;

    /* renamed from: b  reason: collision with root package name */
    public String f3496b;

    @Override // com.baidu.android.pushservice.message.PublicMsg
    public String toString() {
        return super.toString() + " mDestPkg = " + this.f3495a + "\r\n mDestIcon = " + this.f3496b;
    }
}
