package com.baidu.mobstat;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import com.baidu.mobstat.ActivityLifeObserver;
import com.baidu.mobstat.BaiduStatJSInterface;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class ad {
    public static volatile boolean a = true;
    public static volatile boolean b;

    public static void a(String str) {
        b = true;
        al.a().a(str);
    }

    /* loaded from: classes2.dex */
    public static class a implements ActivityLifeObserver.IActivityLifeCallback {
        @Override // com.baidu.mobstat.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // com.baidu.mobstat.ActivityLifeObserver.IActivityLifeCallback
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // com.baidu.mobstat.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityStarted(Activity activity) {
        }

        @Override // com.baidu.mobstat.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityStopped(Activity activity) {
        }

        @Override // com.baidu.mobstat.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (bc.c().b()) {
                bc.c().a("onActivityCreated");
            }
            al.a().a(activity);
        }

        @Override // com.baidu.mobstat.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityPaused(Activity activity) {
            if (bc.c().b()) {
                bc.c().a("onActivityPaused");
            }
            al.a().c(activity);
        }

        @Override // com.baidu.mobstat.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityResumed(Activity activity) {
            if (bc.c().b()) {
                bc.c().a("onActivityResumed");
            }
            al.a().b(activity);
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements BaiduStatJSInterface.IWebviewPageLoadCallback {
        @Override // com.baidu.mobstat.BaiduStatJSInterface.IWebviewPageLoadCallback
        public void onPageFinished(WebView webView, String str, bk bkVar) {
            if (bc.c().b()) {
                bc.c().a("WebView onPageFinished");
            }
            webView.addJavascriptInterface(bkVar, "WebViewInterface");
            al.a().a(webView, str, bkVar);
        }

        @Override // com.baidu.mobstat.BaiduStatJSInterface.IWebviewPageLoadCallback
        public void onPageStarted(WebView webView, String str, bk bkVar) {
            if (bc.c().b()) {
                bc.c().a("WebView onPageStarted");
            }
            webView.addJavascriptInterface(bkVar, "WebViewInterface");
        }
    }

    public static void a(boolean z) {
        al.a().a(z);
    }

    public static boolean a() {
        return b;
    }

    public static boolean b() {
        return a;
    }

    public static JSONArray c() {
        return al.a().e();
    }
}
