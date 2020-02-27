package com.baidu.mobstat;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.webkit.WebView;
import com.baidu.mobstat.ActivityLifeObserver;
import com.baidu.mobstat.BaiduStatJSInterface;
import com.baidu.mobstat.MtjConfig;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class av {
    public static void a(String str) {
        if (af.a() && !ax.a().b()) {
            az.a().b(str);
        }
    }

    public static void a(MtjConfig.FeedTrackStrategy feedTrackStrategy) {
        if (!ax.a().b()) {
            ar.a(feedTrackStrategy);
        }
    }

    public static void a(JSONObject jSONObject) {
        if (af.a() && !ax.a().b()) {
            aw.a().a(jSONObject);
        }
    }

    public static void a(Context context) {
        if (af.a() && !ax.a().b()) {
            aw.a().a(context);
        }
    }

    public static void a(Context context, boolean z) {
        if (af.a() && !ax.a().b()) {
            aw.a().a(context, z);
        }
    }

    /* loaded from: classes11.dex */
    public static class a implements ActivityLifeObserver.IActivityLifeCallback {
        @Override // com.baidu.mobstat.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // com.baidu.mobstat.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityStarted(Activity activity) {
        }

        @Override // com.baidu.mobstat.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityResumed(Activity activity) {
            if (af.a() && !ax.a().b()) {
                if (bh.c().b()) {
                    bh.c().a("onActivityResumed");
                }
                az.a().a(activity);
            }
        }

        @Override // com.baidu.mobstat.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityPaused(Activity activity) {
            if (af.a() && !ax.a().b()) {
                if (bh.c().b()) {
                    bh.c().a("onActivityPaused");
                }
                az.a().b(activity);
            }
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
            if (af.a() && !ax.a().b()) {
                if (bh.c().b()) {
                    bh.c().a("WebView onPageStarted");
                }
                webView.addJavascriptInterface(blVar, "WebViewInterface");
            }
        }

        @Override // com.baidu.mobstat.BaiduStatJSInterface.IWebviewPageLoadCallback
        public void onPageFinished(WebView webView, String str, bl blVar) {
            if (af.a() && !ax.a().b()) {
                if (bh.c().b()) {
                    bh.c().a("WebView onPageFinished");
                }
                webView.addJavascriptInterface(blVar, "WebViewInterface");
                az.a().a(webView, str, blVar);
            }
        }
    }

    public static void b(String str) {
        if (af.a()) {
            az.a().a(str);
        }
    }
}
