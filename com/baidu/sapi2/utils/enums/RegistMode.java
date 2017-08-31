package com.baidu.sapi2.utils.enums;

import android.text.TextUtils;
/* loaded from: classes.dex */
public enum RegistMode {
    NORMAL("normal"),
    FAST("fast"),
    QUICK_USER("quick_user");
    
    private String a;

    public static RegistMode mapStrToValue(String str) {
        RegistMode[] values;
        if (TextUtils.isEmpty(str)) {
            return getDefault();
        }
        for (RegistMode registMode : values()) {
            if (str.equals(registMode.getStrValue())) {
                return registMode;
            }
        }
        return getDefault();
    }

    public static RegistMode getDefault() {
        return NORMAL;
    }

    RegistMode(String str) {
        this.a = str;
    }

    public String getStrValue() {
        return this.a;
    }
}
