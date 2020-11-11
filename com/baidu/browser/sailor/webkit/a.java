package com.baidu.browser.sailor.webkit;

import android.content.Context;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes11.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1285a = BdSailor.class.getName();
    private static a afw;
    public Context b;
    public WebView c;
    private boolean e;

    private a() {
    }

    public static void b() {
        a tx = tx();
        tx.f();
        tx.b = null;
        afw = null;
    }

    private void f() {
        Log.w(f1285a, "BdWebViewSingleton, old instance has been destroyed");
        if (this.c != null) {
            this.c.destroy();
            this.c = null;
        }
    }

    public static a tx() {
        if (afw == null) {
            afw = new a();
        } else if (afw.c != null && (afw.e ^ BdZeusUtil.isWebkitLoaded())) {
            Log.d(f1285a, "BdWebViewSingleton, re-new instance need because of the kernel changed");
            afw.f();
            afw.e();
        }
        return afw;
    }

    public final boolean c() {
        Log.d(f1285a, "BdWebViewSingleton pauseTimer");
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
        Log.d(f1285a, "BdWebViewSingleton resumeTimer");
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
            Log.d(f1285a, "BdWebViewSingleton init system webview,zeus was not load complete");
        }
        this.c = new WebView(this.b);
    }
}
