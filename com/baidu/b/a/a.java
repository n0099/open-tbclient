package com.baidu.b.a;

import android.text.TextUtils;
/* loaded from: classes10.dex */
public class a {
    private static a OM;
    private String mAppName;

    private a() {
    }

    public static a nh() {
        if (OM == null) {
            synchronized (a.class) {
                if (OM == null) {
                    OM = new a();
                }
            }
        }
        return OM;
    }

    public void setAppName(String str) {
        this.mAppName = str;
    }

    public String getAppName() {
        return !TextUtils.isEmpty(this.mAppName) ? this.mAppName : b.ni().getAppName();
    }
}
