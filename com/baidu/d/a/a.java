package com.baidu.d.a;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public class a {
    private static a alY;
    private String mAppName;

    private a() {
    }

    public static a uv() {
        if (alY == null) {
            synchronized (a.class) {
                if (alY == null) {
                    alY = new a();
                }
            }
        }
        return alY;
    }

    public void setAppName(String str) {
        this.mAppName = str;
    }

    public String getAppName() {
        return !TextUtils.isEmpty(this.mAppName) ? this.mAppName : b.uw().getAppName();
    }
}
