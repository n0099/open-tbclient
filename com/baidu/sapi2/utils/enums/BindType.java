package com.baidu.sapi2.utils.enums;
/* loaded from: classes2.dex */
public enum BindType {
    EXPLICIT("explicit", "afterauth", "finishbind"),
    SMS("sms", "afterauth", "finishbind"),
    BIND_MOBILE("bind_mobile", "afterauth", "afterauth");
    

    /* renamed from: a  reason: collision with root package name */
    public String f11048a;

    /* renamed from: b  reason: collision with root package name */
    public String f11049b;

    /* renamed from: c  reason: collision with root package name */
    public String f11050c;

    BindType(String str, String str2, String str3) {
        this.f11048a = "";
        this.f11048a = str;
        this.f11049b = str2;
        this.f11050c = str3;
    }

    public String getCallbackPage() {
        return this.f11049b;
    }

    public String getFinishBindPage() {
        return this.f11050c;
    }

    public String getName() {
        return this.f11048a;
    }
}
