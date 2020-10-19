package com.baidu.d.b;

import android.text.TextUtils;
/* loaded from: classes9.dex */
public class a {
    private static a anl;
    private String mAppName;

    private a() {
    }

    public static a uS() {
        if (anl == null) {
            synchronized (a.class) {
                if (anl == null) {
                    anl = new a();
                }
            }
        }
        return anl;
    }

    public void setAppName(String str) {
        this.mAppName = str;
    }

    public String getAppName() {
        return !TextUtils.isEmpty(this.mAppName) ? this.mAppName : b.uT().getAppName();
    }
}
