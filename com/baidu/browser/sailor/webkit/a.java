package com.baidu.browser.sailor.webkit;

import android.content.Context;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes2.dex */
public final class a {
    private static a WL;
    public static final String a = com.baidu.browser.sailor.a.class.getName();
    public WebView WM;
    public Context b;
    private boolean e;

    private a() {
    }

    private void f() {
        Log.w(a, "BdWebViewSingleton, old instance has been destroyed");
        if (this.WM != null) {
            this.WM.destroy();
            this.WM = null;
        }
    }

    public static a ra() {
        if (WL == null) {
            WL = new a();
        } else if (WL.WM != null && (WL.e ^ com.baidu.browser.sailor.util.a.qX())) {
            Log.d(a, "BdWebViewSingleton, re-new instance need because of the kernel changed");
            WL.f();
            WL.e();
        }
        return WL;
    }

    public final boolean c() {
        Log.d(a, "BdWebViewSingleton pauseTimer");
        try {
            e();
            this.WM.pauseTimers();
            return true;
        } catch (Exception e) {
            Log.printStackTrace(e);
            return false;
        }
    }

    public final void e() {
        if (this.WM != null || this.b == null) {
            return;
        }
        if (com.baidu.browser.sailor.util.a.qX()) {
            this.e = true;
        } else {
            this.e = false;
            Log.d(a, "BdWebViewSingleton init system webview,zeus was not load complete");
        }
        this.WM = new WebView(this.b);
    }
}
