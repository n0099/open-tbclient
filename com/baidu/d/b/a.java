package com.baidu.d.b;

import android.text.TextUtils;
/* loaded from: classes6.dex */
public class a {
    private static a aod;
    private String mAppName;

    private a() {
    }

    public static a uf() {
        if (aod == null) {
            synchronized (a.class) {
                if (aod == null) {
                    aod = new a();
                }
            }
        }
        return aod;
    }

    public void setAppName(String str) {
        this.mAppName = str;
    }

    public String getAppName() {
        return !TextUtils.isEmpty(this.mAppName) ? this.mAppName : b.ug().getAppName();
    }
}
