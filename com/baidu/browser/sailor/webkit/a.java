package com.baidu.browser.sailor.webkit;

import android.content.Context;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1599a = BdSailor.class.getName();
    private static a afW;

    /* renamed from: b  reason: collision with root package name */
    public Context f1600b;
    public WebView c;
    private boolean e;

    private a() {
    }

    public static void b() {
        a sK = sK();
        sK.f();
        sK.f1600b = null;
        afW = null;
    }

    private void f() {
        Log.w(f1599a, "BdWebViewSingleton, old instance has been destroyed");
        if (this.c != null) {
            this.c.destroy();
            this.c = null;
        }
    }

    public static a sK() {
        if (afW == null) {
            afW = new a();
        } else if (afW.c != null && (afW.e ^ BdZeusUtil.isWebkitLoaded())) {
            Log.d(f1599a, "BdWebViewSingleton, re-new instance need because of the kernel changed");
            afW.f();
            afW.e();
        }
        return afW;
    }

    public final boolean c() {
        Log.d(f1599a, "BdWebViewSingleton pauseTimer");
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
        Log.d(f1599a, "BdWebViewSingleton resumeTimer");
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
        if (this.c != null || this.f1600b == null) {
            return;
        }
        if (BdZeusUtil.isWebkitLoaded()) {
            this.e = true;
        } else {
            this.e = false;
            Log.d(f1599a, "BdWebViewSingleton init system webview,zeus was not load complete");
        }
        this.c = new WebView(this.f1600b);
    }
}
