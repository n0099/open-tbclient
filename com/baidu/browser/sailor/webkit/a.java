package com.baidu.browser.sailor.webkit;

import android.content.Context;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1651a = BdSailor.class.getName();
    private static a agW;

    /* renamed from: b  reason: collision with root package name */
    public Context f1652b;
    public WebView c;
    private boolean e;

    private a() {
    }

    public static void b() {
        a sY = sY();
        sY.f();
        sY.f1652b = null;
        agW = null;
    }

    private void f() {
        Log.w(f1651a, "BdWebViewSingleton, old instance has been destroyed");
        if (this.c != null) {
            this.c.destroy();
            this.c = null;
        }
    }

    public static a sY() {
        if (agW == null) {
            agW = new a();
        } else if (agW.c != null && (agW.e ^ BdZeusUtil.isWebkitLoaded())) {
            Log.d(f1651a, "BdWebViewSingleton, re-new instance need because of the kernel changed");
            agW.f();
            agW.e();
        }
        return agW;
    }

    public final boolean c() {
        Log.d(f1651a, "BdWebViewSingleton pauseTimer");
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
        Log.d(f1651a, "BdWebViewSingleton resumeTimer");
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
        if (this.c != null || this.f1652b == null) {
            return;
        }
        if (BdZeusUtil.isWebkitLoaded()) {
            this.e = true;
        } else {
            this.e = false;
            Log.d(f1651a, "BdWebViewSingleton init system webview,zeus was not load complete");
        }
        this.c = new WebView(this.f1652b);
    }
}
