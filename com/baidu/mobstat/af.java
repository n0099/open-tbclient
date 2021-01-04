package com.baidu.mobstat;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import com.baidu.mobstat.ActivityLifeObserver;
import com.baidu.mobstat.BaiduStatJSInterface;
import org.json.JSONArray;
/* loaded from: classes15.dex */
public class af {

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f3684a = true;

    /* renamed from: b  reason: collision with root package name */
    private static volatile boolean f3685b = false;

    public static boolean a() {
        return f3685b;
    }

    public static void a(String str) {
        f3685b = true;
        am.a().a(str);
    }

    public static void a(boolean z) {
        am.a().a(z);
    }

    public static boolean b() {
        return f3684a;
    }

    public static JSONArray c() {
        return am.a().e();
    }

    /* loaded from: classes15.dex */
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

    /* loaded from: classes15.dex */
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
