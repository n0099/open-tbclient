package com.baidu.d.b;

import android.text.TextUtils;
/* loaded from: classes9.dex */
public class a {
    private static a anm;
    private String mAppName;

    private a() {
    }

    public static a uS() {
        if (anm == null) {
            synchronized (a.class) {
                if (anm == null) {
                    anm = new a();
                }
            }
        }
        return anm;
    }

    public void setAppName(String str) {
        this.mAppName = str;
    }

    public String getAppName() {
        return !TextUtils.isEmpty(this.mAppName) ? this.mAppName : b.uT().getAppName();
    }
}
