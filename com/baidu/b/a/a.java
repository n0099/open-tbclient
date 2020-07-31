package com.baidu.b.a;

import android.text.TextUtils;
/* loaded from: classes8.dex */
public class a {
    private static a akX;
    private String mAppName;

    private a() {
    }

    public static a sN() {
        if (akX == null) {
            synchronized (a.class) {
                if (akX == null) {
                    akX = new a();
                }
            }
        }
        return akX;
    }

    public void setAppName(String str) {
        this.mAppName = str;
    }

    public String getAppName() {
        return !TextUtils.isEmpty(this.mAppName) ? this.mAppName : b.sO().getAppName();
    }
}
