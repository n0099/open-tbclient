package com.baidu.sapi2.utils.enums;

import android.text.TextUtils;
/* loaded from: classes6.dex */
public enum LoginShareStrategy {
    DISABLED("disabled"),
    SILENT("silent"),
    CHOICE("choice");
    

    /* renamed from: a  reason: collision with root package name */
    private String f3553a;

    LoginShareStrategy(String str) {
        this.f3553a = str;
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
        return this.f3553a;
    }
}
