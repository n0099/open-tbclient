package com.baidu.android.pushservice.message;
/* loaded from: classes.dex */
public class CrossPushMessage extends PublicMsg {

    /* renamed from: a  reason: collision with root package name */
    public String f3492a;

    /* renamed from: b  reason: collision with root package name */
    public String f3493b;

    @Override // com.baidu.android.pushservice.message.PublicMsg
    public String toString() {
        return super.toString() + " mDestPkg = " + this.f3492a + "\r\n mDestIcon = " + this.f3493b;
    }
}
