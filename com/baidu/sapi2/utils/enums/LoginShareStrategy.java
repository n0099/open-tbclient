package com.baidu.sapi2.utils.enums;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public enum LoginShareStrategy {
    DISABLED("disabled"),
    CHOICE("choice");
    

    /* renamed from: a  reason: collision with root package name */
    public String f11491a;

    LoginShareStrategy(String str) {
        this.f11491a = str;
    }

    public static LoginShareStrategy getDefault() {
        return CHOICE;
    }

    public static LoginShareStrategy mapStrToValue(String str) {
        LoginShareStrategy[] values;
        if (TextUtils.isEmpty(str)) {
            return getDefault();
        }
        for (LoginShareStrategy loginShareStrategy : values()) {
            if (str.equals(loginShareStrategy.getStrValue())) {
                return loginShareStrategy;
            }
        }
        return getDefault();
    }

    public String getStrValue() {
        return this.f11491a;
    }
}
