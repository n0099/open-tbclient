package com.baidu.d.b;

import android.text.TextUtils;
/* loaded from: classes4.dex */
public class a {
    private static a apt;
    private String mAppName;

    private a() {
    }

    public static a uc() {
        if (apt == null) {
            synchronized (a.class) {
                if (apt == null) {
                    apt = new a();
                }
            }
        }
        return apt;
    }

    public void setAppName(String str) {
        this.mAppName = str;
    }

    public String getAppName() {
        return !TextUtils.isEmpty(this.mAppName) ? this.mAppName : b.ud().getAppName();
    }
}
