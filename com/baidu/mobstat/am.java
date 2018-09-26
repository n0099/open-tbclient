package com.baidu.mobstat;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import com.baidu.mobstat.ActivityLifeObserver;
import com.baidu.mobstat.BaiduStatJSInterface;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class am {
    private static volatile boolean a = true;
    private static volatile boolean b = false;

    public static boolean a() {
        return b;
    }

    public static void a(String str) {
        b = true;
        at.a().a(str);
    }

    public static void a(boolean z) {
        at.a().a(z);
    }

    public static boolean b() {
        return a;
    }

    public static JSONArray c() {
        return at.a().e();
    }

    /* loaded from: classes3.dex */
    public static class a implements ActivityLifeObserver.IActivityLifeCallback {
        @Override // com.baidu.mobstat.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // com.baidu.mobstat.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityStarted(Activity activity) {
        }

        @Override // com.baidu.mobstat.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityResumed(Activity activity) {
            if (bk.c().b()) {
                bk.c().a("onActivityResumed");
            }
            at.a().a(activity);
        }

        @Override // com.baidu.mobstat.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityPaused(Activity activity) {
            if (bk.c().b()) {
                bk.c().a("onActivityPaused");
            }
            at.a().b(activity);
        }

        @Override // com.baidu.mobstat.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityStopped(Activity activity) {
        }

        @Override // com.baidu.mobstat.ActivityLifeObserver.IActivityLifeCallback
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // com.baidu.mobstat.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityDestroyed(Activity activity) {
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements BaiduStatJSInterface.IWebviewPageLoadCallback {
        @Override // com.baidu.mobstat.BaiduStatJSInterface.IWebviewPageLoadCallback
        public void onPageStarted(WebView webView, String str, bs bsVar) {
            if (bk.c().b()) {
                bk.c().a("WebView onPageStarted");
            }
            webView.addJavascriptInterface(bsVar, "WebViewInterface");
        }

        @Override // com.baidu.mobstat.BaiduStatJSInterface.IWebviewPageLoadCallback
        public void onPageFinished(WebView webView, String str, bs bsVar) {
            if (bk.c().b()) {
                bk.c().a("WebView onPageFinished");
            }
            webView.addJavascriptInterface(bsVar, "WebViewInterface");
            at.a().a(webView, str, bsVar);
        }
    }
}
