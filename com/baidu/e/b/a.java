package com.baidu.e.b;

import android.text.TextUtils;
/* loaded from: classes14.dex */
public class a {
    private static a ans;
    private String mAppName;

    private a() {
    }

    public static a uR() {
        if (ans == null) {
            synchronized (a.class) {
                if (ans == null) {
                    ans = new a();
                }
            }
        }
        return ans;
    }

    public void setAppName(String str) {
        this.mAppName = str;
    }

    public String getAppName() {
        return !TextUtils.isEmpty(this.mAppName) ? this.mAppName : b.uS().getAppName();
    }
}
