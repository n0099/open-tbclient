package com.baidu.a.a;

import android.text.TextUtils;
/* loaded from: classes12.dex */
public class a {
    private static a ajG;
    private String mAppName;

    private a() {
    }

    public static a sq() {
        if (ajG == null) {
            synchronized (a.class) {
                if (ajG == null) {
                    ajG = new a();
                }
            }
        }
        return ajG;
    }

    public void setAppName(String str) {
        this.mAppName = str;
    }

    public String getAppName() {
        return !TextUtils.isEmpty(this.mAppName) ? this.mAppName : b.sr().getAppName();
    }
}
