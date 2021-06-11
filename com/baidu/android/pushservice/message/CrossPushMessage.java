package com.baidu.android.pushservice.message;
/* loaded from: classes.dex */
public class CrossPushMessage extends PublicMsg {

    /* renamed from: a  reason: collision with root package name */
    public String f3514a;

    /* renamed from: b  reason: collision with root package name */
    public String f3515b;

    @Override // com.baidu.android.pushservice.message.PublicMsg
    public String toString() {
        return super.toString() + " mDestPkg = " + this.f3514a + "\r\n mDestIcon = " + this.f3515b;
    }
}
