package com.baidu.sapi2.enums;
/* loaded from: classes2.dex */
public enum LoginTypes {
    ONE_KEY_LOGIN(1, "one_key_login"),
    SHARE(2, "share");
    
    public String name;
    public int type;

    LoginTypes(int i2, String str) {
        this.type = i2;
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    public int getType() {
        return this.type;
    }
}
