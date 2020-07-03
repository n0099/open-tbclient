package com.baidu.a.a;

import android.text.TextUtils;
/* loaded from: classes12.dex */
public class a {
    private static a alc;
    private String mAppName;

    private a() {
    }

    public static a sL() {
        if (alc == null) {
            synchronized (a.class) {
                if (alc == null) {
                    alc = new a();
                }
            }
        }
        return alc;
    }

    public void setAppName(String str) {
        this.mAppName = str;
    }

    public String getAppName() {
        return !TextUtils.isEmpty(this.mAppName) ? this.mAppName : b.sM().getAppName();
    }
}
