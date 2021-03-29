package com.baidu.sapi2.enums;
/* loaded from: classes2.dex */
public enum LoginTypes {
    ONE_KEY_LOGIN(1, "one_key_login"),
    SHARE(2, "share");
    

    /* renamed from: a  reason: collision with root package name */
    public int f11217a;

    /* renamed from: b  reason: collision with root package name */
    public String f11218b;

    LoginTypes(int i, String str) {
        this.f11217a = i;
        this.f11218b = str;
    }

    public String getName() {
        return this.f11218b;
    }

    public int getType() {
        return this.f11217a;
    }
}
