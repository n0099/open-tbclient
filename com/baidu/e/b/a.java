package com.baidu.e.b;

import android.text.TextUtils;
/* loaded from: classes17.dex */
public class a {
    private static a aop;
    private String mAppName;

    private a() {
    }

    public static a uN() {
        if (aop == null) {
            synchronized (a.class) {
                if (aop == null) {
                    aop = new a();
                }
            }
        }
        return aop;
    }

    public void setAppName(String str) {
        this.mAppName = str;
    }

    public String getAppName() {
        return !TextUtils.isEmpty(this.mAppName) ? this.mAppName : b.uO().getAppName();
    }
}
