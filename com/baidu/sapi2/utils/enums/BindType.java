package com.baidu.sapi2.utils.enums;
/* loaded from: classes2.dex */
public enum BindType {
    EXPLICIT("explicit", "afterauth", "finishbind"),
    SMS("sms", "afterauth", "finishbind"),
    BIND_MOBILE("bind_mobile", "afterauth", "afterauth");
    

    /* renamed from: a  reason: collision with root package name */
    public String f11464a;

    /* renamed from: b  reason: collision with root package name */
    public String f11465b;

    /* renamed from: c  reason: collision with root package name */
    public String f11466c;

    BindType(String str, String str2, String str3) {
        this.f11464a = "";
        this.f11464a = str;
        this.f11465b = str2;
        this.f11466c = str3;
    }

    public String getCallbackPage() {
        return this.f11465b;
    }

    public String getFinishBindPage() {
        return this.f11466c;
    }

    public String getName() {
        return this.f11464a;
    }
}
