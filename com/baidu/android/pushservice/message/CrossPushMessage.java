package com.baidu.android.pushservice.message;
/* loaded from: classes.dex */
public class CrossPushMessage extends PublicMsg {

    /* renamed from: a  reason: collision with root package name */
    public String f3421a;

    /* renamed from: b  reason: collision with root package name */
    public String f3422b;

    @Override // com.baidu.android.pushservice.message.PublicMsg
    public String toString() {
        return super.toString() + " mDestPkg = " + this.f3421a + "\r\n mDestIcon = " + this.f3422b;
    }
}
