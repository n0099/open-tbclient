package com.baidu.d.b;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public class a {
    private static a amC;
    private String mAppName;

    private a() {
    }

    public static a uJ() {
        if (amC == null) {
            synchronized (a.class) {
                if (amC == null) {
                    amC = new a();
                }
            }
        }
        return amC;
    }

    public void setAppName(String str) {
        this.mAppName = str;
    }

    public String getAppName() {
        return !TextUtils.isEmpty(this.mAppName) ? this.mAppName : b.uK().getAppName();
    }
}
