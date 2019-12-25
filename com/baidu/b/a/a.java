package com.baidu.b.a;

import android.text.TextUtils;
/* loaded from: classes9.dex */
public class a {
    private static a OH;
    private String mAppName;

    private a() {
    }

    public static a ng() {
        if (OH == null) {
            synchronized (a.class) {
                if (OH == null) {
                    OH = new a();
                }
            }
        }
        return OH;
    }

    public void setAppName(String str) {
        this.mAppName = str;
    }

    public String getAppName() {
        return !TextUtils.isEmpty(this.mAppName) ? this.mAppName : b.nh().getAppName();
    }
}
