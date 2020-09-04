package com.baidu.d.a;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public class a {
    private static a ama;
    private String mAppName;

    private a() {
    }

    public static a uv() {
        if (ama == null) {
            synchronized (a.class) {
                if (ama == null) {
                    ama = new a();
                }
            }
        }
        return ama;
    }

    public void setAppName(String str) {
        this.mAppName = str;
    }

    public String getAppName() {
        return !TextUtils.isEmpty(this.mAppName) ? this.mAppName : b.uw().getAppName();
    }
}
