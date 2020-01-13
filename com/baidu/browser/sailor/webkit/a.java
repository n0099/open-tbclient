package com.baidu.browser.sailor.webkit;

import android.content.Context;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes10.dex */
public final class a {
    private static a Jo;
    public static final String a = BdSailor.class.getName();
    public WebView Jp;
    public Context b;
    private boolean e;

    private a() {
    }

    public static void b() {
        a mq = mq();
        mq.f();
        mq.b = null;
        Jo = null;
    }

    private void f() {
        Log.w(a, "BdWebViewSingleton, old instance has been destroyed");
        if (this.Jp != null) {
            this.Jp.destroy();
            this.Jp = null;
        }
    }

    public static a mq() {
        if (Jo == null) {
            Jo = new a();
        } else if (Jo.Jp != null && (Jo.e ^ BdZeusUtil.isWebkitLoaded())) {
            Log.d(a, "BdWebViewSingleton, re-new instance need because of the kernel changed");
            Jo.f();
            Jo.e();
        }
        return Jo;
    }

    public final boolean c() {
        Log.d(a, "BdWebViewSingleton pauseTimer");
        try {
            e();
            this.Jp.pauseTimers();
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
            this.Jp.resumeTimers();
            return true;
        } catch (Exception e) {
            Log.printStackTrace(e);
            return false;
        }
    }

    public final void e() {
        if (this.Jp != null || this.b == null) {
            return;
        }
        if (BdZeusUtil.isWebkitLoaded()) {
            this.e = true;
        } else {
            this.e = false;
            Log.d(a, "BdWebViewSingleton init system webview,zeus was not load complete");
        }
        this.Jp = new WebView(this.b);
    }
}
