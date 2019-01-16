package com.baidu.browser.sailor.webkit;

import android.content.Context;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes2.dex */
public final class a {
    private static a WW;
    public static final String a = com.baidu.browser.sailor.a.class.getName();
    public WebView WX;
    public Context b;
    private boolean e;

    private a() {
    }

    private void f() {
        Log.w(a, "BdWebViewSingleton, old instance has been destroyed");
        if (this.WX != null) {
            this.WX.destroy();
            this.WX = null;
        }
    }

    public static a rb() {
        if (WW == null) {
            WW = new a();
        } else if (WW.WX != null && (WW.e ^ com.baidu.browser.sailor.util.a.qY())) {
            Log.d(a, "BdWebViewSingleton, re-new instance need because of the kernel changed");
            WW.f();
            WW.e();
        }
        return WW;
    }

    public final boolean c() {
        Log.d(a, "BdWebViewSingleton pauseTimer");
        try {
            e();
            this.WX.pauseTimers();
            return true;
        } catch (Exception e) {
            Log.printStackTrace(e);
            return false;
        }
    }

    public final void e() {
        if (this.WX != null || this.b == null) {
            return;
        }
        if (com.baidu.browser.sailor.util.a.qY()) {
            this.e = true;
        } else {
            this.e = false;
            Log.d(a, "BdWebViewSingleton init system webview,zeus was not load complete");
        }
        this.WX = new WebView(this.b);
    }
}
