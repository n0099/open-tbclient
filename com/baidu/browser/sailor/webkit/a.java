package com.baidu.browser.sailor.webkit;

import android.content.Context;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes8.dex */
public final class a {
    public static final String a = BdSailor.class.getName();
    private static a afe;
    public Context b;
    public WebView c;
    private boolean e;

    private a() {
    }

    public static void b() {
        a tx = tx();
        tx.f();
        tx.b = null;
        afe = null;
    }

    private void f() {
        Log.w(a, "BdWebViewSingleton, old instance has been destroyed");
        if (this.c != null) {
            this.c.destroy();
            this.c = null;
        }
    }

    public static a tx() {
        if (afe == null) {
            afe = new a();
        } else if (afe.c != null && (afe.e ^ BdZeusUtil.isWebkitLoaded())) {
            Log.d(a, "BdWebViewSingleton, re-new instance need because of the kernel changed");
            afe.f();
            afe.e();
        }
        return afe;
    }

    public final boolean c() {
        Log.d(a, "BdWebViewSingleton pauseTimer");
        try {
            e();
            this.c.pauseTimers();
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
            this.c.resumeTimers();
            return true;
        } catch (Exception e) {
            Log.printStackTrace(e);
            return false;
        }
    }

    public final void e() {
        if (this.c != null || this.b == null) {
            return;
        }
        if (BdZeusUtil.isWebkitLoaded()) {
            this.e = true;
        } else {
            this.e = false;
            Log.d(a, "BdWebViewSingleton init system webview,zeus was not load complete");
        }
        this.c = new WebView(this.b);
    }
}
