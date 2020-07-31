package com.baidu.browser.sailor.webkit;

import android.content.Context;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes8.dex */
public final class a {
    public static final String a = BdSailor.class.getName();
    private static a adD;
    public WebView adE;
    public Context b;
    private boolean e;

    private a() {
    }

    public static void b() {
        a rH = rH();
        rH.f();
        rH.b = null;
        adD = null;
    }

    private void f() {
        Log.w(a, "BdWebViewSingleton, old instance has been destroyed");
        if (this.adE != null) {
            this.adE.destroy();
            this.adE = null;
        }
    }

    public static a rH() {
        if (adD == null) {
            adD = new a();
        } else if (adD.adE != null && (adD.e ^ BdZeusUtil.isWebkitLoaded())) {
            Log.d(a, "BdWebViewSingleton, re-new instance need because of the kernel changed");
            adD.f();
            adD.e();
        }
        return adD;
    }

    public final boolean c() {
        Log.d(a, "BdWebViewSingleton pauseTimer");
        try {
            e();
            this.adE.pauseTimers();
            return true;
        } catch (Exception e) {
            Log.printStackTrace(e);
            return false;
        }
    }

    public final boolean d() {
        Log.d(a, "BdWebViewSingleton resumeTimer");
        try {
            e();
            this.adE.resumeTimers();
            return true;
        } catch (Exception e) {
            Log.printStackTrace(e);
            return false;
        }
    }

    public final void e() {
        if (this.adE != null || this.b == null) {
            return;
        }
        if (BdZeusUtil.isWebkitLoaded()) {
            this.e = true;
        } else {
            this.e = false;
            Log.d(a, "BdWebViewSingleton init system webview,zeus was not load complete");
        }
        this.adE = new WebView(this.b);
    }
}
