package com.baidu.sapi2.utils.enums;

import android.text.TextUtils;
/* loaded from: classes4.dex */
public enum LoginShareStrategy {
    DISABLED("disabled"),
    SILENT("silent"),
    CHOICE("choice");
    
    private String b;

    LoginShareStrategy(String str) {
        this.b = str;
    }

    public static LoginShareStrategy getDefault() {
        return SILENT;
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
        return this.b;
    }
}
