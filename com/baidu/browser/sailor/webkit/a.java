package com.baidu.browser.sailor.webkit;

import android.content.Context;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes2.dex */
public final class a {
    private static a WN;
    public static final String a = com.baidu.browser.sailor.a.class.getName();
    public WebView WO;
    public Context b;
    private boolean e;

    private a() {
    }

    private void f() {
        Log.w(a, "BdWebViewSingleton, old instance has been destroyed");
        if (this.WO != null) {
            this.WO.destroy();
            this.WO = null;
        }
    }

    public static a qY() {
        if (WN == null) {
            WN = new a();
        } else if (WN.WO != null && (WN.e ^ com.baidu.browser.sailor.util.a.qV())) {
            Log.d(a, "BdWebViewSingleton, re-new instance need because of the kernel changed");
            WN.f();
            WN.e();
        }
        return WN;
    }

    public final boolean c() {
        Log.d(a, "BdWebViewSingleton pauseTimer");
        try {
            e();
            this.WO.pauseTimers();
            return true;
        } catch (Exception e) {
            Log.printStackTrace(e);
            return false;
        }
    }

    public final void e() {
        if (this.WO != null || this.b == null) {
            return;
        }
        if (com.baidu.browser.sailor.util.a.qV()) {
            this.e = true;
        } else {
            this.e = false;
            Log.d(a, "BdWebViewSingleton init system webview,zeus was not load complete");
        }
        this.WO = new WebView(this.b);
    }
}
