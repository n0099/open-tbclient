package com.baidu.sapi2.utils.enums;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public enum LoginShareStrategy {
    DISABLED("disabled"),
    CHOICE("choice");
    
    public String mStrValue;

    public static LoginShareStrategy getDefault() {
        return CHOICE;
    }

    public String getStrValue() {
        return this.mStrValue;
    }

    LoginShareStrategy(String str) {
        this.mStrValue = str;
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
}
