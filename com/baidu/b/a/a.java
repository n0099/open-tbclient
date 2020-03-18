package com.baidu.b.a;

import android.text.TextUtils;
/* loaded from: classes12.dex */
public class a {
    private static a Qy;
    private String mAppName;

    private a() {
    }

    public static a nO() {
        if (Qy == null) {
            synchronized (a.class) {
                if (Qy == null) {
                    Qy = new a();
                }
            }
        }
        return Qy;
    }

    public void setAppName(String str) {
        this.mAppName = str;
    }

    public String getAppName() {
        return !TextUtils.isEmpty(this.mAppName) ? this.mAppName : b.nP().getAppName();
    }
}
