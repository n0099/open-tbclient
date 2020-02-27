package com.baidu.mobstat;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import com.baidu.mobstat.ActivityLifeObserver;
import com.baidu.mobstat.BaiduStatJSInterface;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class af {
    private static volatile boolean a = true;
    private static volatile boolean b = false;

    public static boolean a() {
        return b;
    }

    public static void a(String str) {
        b = true;
        am.a().a(str);
    }

    public static void a(boolean z) {
        am.a().a(z);
    }

    public static boolean b() {
        return a;
    }

    public static JSONArray c() {
        return am.a().e();
    }

    /* loaded from: classes11.dex */
    public static class a implements ActivityLifeObserver.IActivityLifeCallback {
        @Override // com.baidu.mobstat.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (bd.c().b()) {
                bd.c().a("onActivityCreated");
            }
            am.a().a(activity);
        }

        @Override // com.baidu.mobstat.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityStarted(Activity activity) {
        }

        @Override // com.baidu.mobstat.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityResumed(Activity activity) {
            if (bd.c().b()) {
                bd.c().a("onActivityResumed");
            }
            am.a().b(activity);
        }

        @Override // com.baidu.mobstat.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityPaused(Activity activity) {
            if (bd.c().b()) {
                bd.c().a("onActivityPaused");
            }
            am.a().c(activity);
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

    /* loaded from: classes11.dex */
    public static class b implements BaiduStatJSInterface.IWebviewPageLoadCallback {
        @Override // com.baidu.mobstat.BaiduStatJSInterface.IWebviewPageLoadCallback
        public void onPageStarted(WebView webView, String str, bl blVar) {
            if (bd.c().b()) {
                bd.c().a("WebView onPageStarted");
            }
            webView.addJavascriptInterface(blVar, "WebViewInterface");
        }

        @Override // com.baidu.mobstat.BaiduStatJSInterface.IWebviewPageLoadCallback
        public void onPageFinished(WebView webView, String str, bl blVar) {
            if (bd.c().b()) {
                bd.c().a("WebView onPageFinished");
            }
            webView.addJavascriptInterface(blVar, "WebViewInterface");
            am.a().a(webView, str, blVar);
        }
    }
}
