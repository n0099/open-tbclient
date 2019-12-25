package com.baidu.browser.sailor.webkit;

import android.content.Context;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes9.dex */
public final class a {
    private static a Ji;
    public static final String a = BdSailor.class.getName();
    public WebView Jj;
    public Context b;
    private boolean e;

    private a() {
    }

    public static void b() {
        a mq = mq();
        mq.f();
        mq.b = null;
        Ji = null;
    }

    private void f() {
        Log.w(a, "BdWebViewSingleton, old instance has been destroyed");
        if (this.Jj != null) {
            this.Jj.destroy();
            this.Jj = null;
        }
    }

    public static a mq() {
        if (Ji == null) {
            Ji = new a();
        } else if (Ji.Jj != null && (Ji.e ^ BdZeusUtil.isWebkitLoaded())) {
            Log.d(a, "BdWebViewSingleton, re-new instance need because of the kernel changed");
            Ji.f();
            Ji.e();
        }
        return Ji;
    }

    public final boolean c() {
        Log.d(a, "BdWebViewSingleton pauseTimer");
        try {
            e();
            this.Jj.pauseTimers();
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
            this.Jj.resumeTimers();
            return true;
        } catch (Exception e) {
            Log.printStackTrace(e);
            return false;
        }
    }

    public final void e() {
        if (this.Jj != null || this.b == null) {
            return;
        }
        if (BdZeusUtil.isWebkitLoaded()) {
            this.e = true;
        } else {
            this.e = false;
            Log.d(a, "BdWebViewSingleton init system webview,zeus was not load complete");
        }
        this.Jj = new WebView(this.b);
    }
}
