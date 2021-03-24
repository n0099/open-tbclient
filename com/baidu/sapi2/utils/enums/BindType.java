package com.baidu.sapi2.utils.enums;
/* loaded from: classes2.dex */
public enum BindType {
    EXPLICIT("explicit", "afterauth", "finishbind"),
    SMS("sms", "afterauth", "finishbind"),
    BIND_MOBILE("bind_mobile", "afterauth", "afterauth");
    

    /* renamed from: a  reason: collision with root package name */
    public String f11463a;

    /* renamed from: b  reason: collision with root package name */
    public String f11464b;

    /* renamed from: c  reason: collision with root package name */
    public String f11465c;

    BindType(String str, String str2, String str3) {
        this.f11463a = "";
        this.f11463a = str;
        this.f11464b = str2;
        this.f11465c = str3;
    }

    public String getCallbackPage() {
        return this.f11464b;
    }

    public String getFinishBindPage() {
        return this.f11465c;
    }

    public String getName() {
        return this.f11463a;
    }
}
