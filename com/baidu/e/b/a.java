package com.baidu.e.b;

import android.text.TextUtils;
/* loaded from: classes6.dex */
public class a {
    private static a aoQ;
    private String mAppName;

    private a() {
    }

    public static a um() {
        if (aoQ == null) {
            synchronized (a.class) {
                if (aoQ == null) {
                    aoQ = new a();
                }
            }
        }
        return aoQ;
    }

    public void setAppName(String str) {
        this.mAppName = str;
    }

    public String getAppName() {
        return !TextUtils.isEmpty(this.mAppName) ? this.mAppName : b.un().getAppName();
    }
}
