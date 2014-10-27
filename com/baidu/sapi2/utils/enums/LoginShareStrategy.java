package com.baidu.sapi2.utils.enums;

import android.text.TextUtils;
/* loaded from: classes.dex */
public enum LoginShareStrategy {
    DISABLED("disabled"),
    SILENT("silent"),
    CHOICE("choice");
    
    private String a;

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

    public static LoginShareStrategy getDefault() {
        return SILENT;
    }

    LoginShareStrategy(String str) {
        this.a = str;
    }

    public String getStrValue() {
        return this.a;
    }
}
