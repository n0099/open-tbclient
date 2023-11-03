package com.baidu.android.pushservice.p;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
/* loaded from: classes.dex */
public class f {
    public String a;
    public String b;

    public f(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String toString() {
        return "BindCache [mApiKey=" + this.a + ", mContent=" + this.b + PreferencesUtil.RIGHT_MOUNT;
    }
}
