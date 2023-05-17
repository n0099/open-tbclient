package com.baidu.searchbox.antivr;

import android.app.Application;
/* loaded from: classes3.dex */
public class AntiVirtualRuntime {
    public final Application a;
    public final String b;

    public AntiVirtualRuntime(Application application, String str) {
        this.a = application;
        this.b = str;
    }

    public void setDebug(boolean z) {
        a.a(z);
    }

    public RuntimeResult startVRChecker() {
        return new b(this.a, this.b).a();
    }
}
