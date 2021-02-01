package com.baidu.d.b;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public class a {
    private static a anT;
    private String mAppName;

    private a() {
    }

    public static a uc() {
        if (anT == null) {
            synchronized (a.class) {
                if (anT == null) {
                    anT = new a();
                }
            }
        }
        return anT;
    }

    public void setAppName(String str) {
        this.mAppName = str;
    }

    public String getAppName() {
        return !TextUtils.isEmpty(this.mAppName) ? this.mAppName : b.ud().getAppName();
    }
}
