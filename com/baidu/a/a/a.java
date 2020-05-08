package com.baidu.a.a;

import android.text.TextUtils;
/* loaded from: classes12.dex */
public class a {
    private static a ajc;
    private String mAppName;

    private a() {
    }

    public static a sg() {
        if (ajc == null) {
            synchronized (a.class) {
                if (ajc == null) {
                    ajc = new a();
                }
            }
        }
        return ajc;
    }

    public void setAppName(String str) {
        this.mAppName = str;
    }

    public String getAppName() {
        return !TextUtils.isEmpty(this.mAppName) ? this.mAppName : b.sh().getAppName();
    }
}
