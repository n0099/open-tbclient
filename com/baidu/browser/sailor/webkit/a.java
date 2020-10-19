package com.baidu.browser.sailor.webkit;

import android.content.Context;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes11.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1286a = BdSailor.class.getName();
    private static a afv;
    public Context b;
    public WebView c;
    private boolean e;

    private a() {
    }

    public static void b() {
        a tx = tx();
        tx.f();
        tx.b = null;
        afv = null;
    }

    private void f() {
        Log.w(f1286a, "BdWebViewSingleton, old instance has been destroyed");
        if (this.c != null) {
            this.c.destroy();
            this.c = null;
        }
    }

    public static a tx() {
        if (afv == null) {
            afv = new a();
        } else if (afv.c != null && (afv.e ^ BdZeusUtil.isWebkitLoaded())) {
            Log.d(f1286a, "BdWebViewSingleton, re-new instance need because of the kernel changed");
            afv.f();
            afv.e();
        }
        return afv;
    }

    public final boolean c() {
        Log.d(f1286a, "BdWebViewSingleton pauseTimer");
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
        Log.d(f1286a, "BdWebViewSingleton resumeTimer");
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
            Log.d(f1286a, "BdWebViewSingleton init system webview,zeus was not load complete");
        }
        this.c = new WebView(this.b);
    }
}
