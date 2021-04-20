package com.baidu.sapi2.enums;
/* loaded from: classes2.dex */
public enum LoginTypes {
    ONE_KEY_LOGIN(1, "one_key_login"),
    SHARE(2, "share");
    

    /* renamed from: a  reason: collision with root package name */
    public int f10801a;

    /* renamed from: b  reason: collision with root package name */
    public String f10802b;

    LoginTypes(int i, String str) {
        this.f10801a = i;
        this.f10802b = str;
    }

    public String getName() {
        return this.f10802b;
    }

    public int getType() {
        return this.f10801a;
    }
}
