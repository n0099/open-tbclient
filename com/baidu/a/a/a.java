package com.baidu.a.a;

import android.text.TextUtils;
/* loaded from: classes12.dex */
public class a {
    private static a aiX;
    private String mAppName;

    private a() {
    }

    public static a sh() {
        if (aiX == null) {
            synchronized (a.class) {
                if (aiX == null) {
                    aiX = new a();
                }
            }
        }
        return aiX;
    }

    public void setAppName(String str) {
        this.mAppName = str;
    }

    public String getAppName() {
        return !TextUtils.isEmpty(this.mAppName) ? this.mAppName : b.si().getAppName();
    }
}
