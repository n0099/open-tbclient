package com.baidu.b.a;

import android.text.TextUtils;
/* loaded from: classes12.dex */
public class a {
    private static a Qw;
    private String mAppName;

    private a() {
    }

    public static a nP() {
        if (Qw == null) {
            synchronized (a.class) {
                if (Qw == null) {
                    Qw = new a();
                }
            }
        }
        return Qw;
    }

    public void setAppName(String str) {
        this.mAppName = str;
    }

    public String getAppName() {
        return !TextUtils.isEmpty(this.mAppName) ? this.mAppName : b.nQ().getAppName();
    }
}
