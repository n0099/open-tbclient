package com.baidu.browser.sailor.webkit;

import android.content.Context;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes11.dex */
public final class a {
    public static final String a = BdSailor.class.getName();
    private static a adj;
    public WebView adk;
    public Context b;
    private boolean e;

    private a() {
    }

    public static void b() {
        a ro = ro();
        ro.f();
        ro.b = null;
        adj = null;
    }

    private void f() {
        Log.w(a, "BdWebViewSingleton, old instance has been destroyed");
        if (this.adk != null) {
            this.adk.destroy();
            this.adk = null;
        }
    }

    public static a ro() {
        if (adj == null) {
            adj = new a();
        } else if (adj.adk != null && (adj.e ^ BdZeusUtil.isWebkitLoaded())) {
            Log.d(a, "BdWebViewSingleton, re-new instance need because of the kernel changed");
            adj.f();
            adj.e();
        }
        return adj;
    }

    public final boolean c() {
        Log.d(a, "BdWebViewSingleton pauseTimer");
        try {
            e();
            this.adk.pauseTimers();
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
            this.adk.resumeTimers();
            return true;
        } catch (Exception e) {
            Log.printStackTrace(e);
            return false;
        }
    }

    public final void e() {
        if (this.adk != null || this.b == null) {
            return;
        }
        if (BdZeusUtil.isWebkitLoaded()) {
            this.e = true;
        } else {
            this.e = false;
            Log.d(a, "BdWebViewSingleton init system webview,zeus was not load complete");
        }
        this.adk = new WebView(this.b);
    }
}
