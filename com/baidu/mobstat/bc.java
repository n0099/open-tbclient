package com.baidu.mobstat;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.webkit.WebView;
import com.baidu.mobstat.ActivityLifeObserver;
import com.baidu.mobstat.BaiduStatJSInterface;
import com.baidu.mobstat.MtjConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bc {
    public static void a(String str) {
        if (am.a() && !be.a().b()) {
            bg.a().b(str);
        }
    }

    public static void a(MtjConfig.FeedTrackStrategy feedTrackStrategy) {
        if (!be.a().b()) {
            ay.a(feedTrackStrategy);
        }
    }

    public static void a(JSONObject jSONObject) {
        if (am.a() && !be.a().b()) {
            bd.a().a(jSONObject);
        }
    }

    public static void a(Context context) {
        if (am.a() && !be.a().b()) {
            bd.a().a(context);
        }
    }

    public static void b(Context context) {
        if (am.a() && !be.a().b()) {
            bd.a().b(context);
        }
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
            if (am.a() && !be.a().b()) {
                if (bo.c().b()) {
                    bo.c().a("onActivityResumed");
                }
                bg.a().a(activity);
            }
        }

        @Override // com.baidu.mobstat.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityPaused(Activity activity) {
            if (am.a() && !be.a().b()) {
                if (bo.c().b()) {
                    bo.c().a("onActivityPaused");
                }
                bg.a().b(activity);
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

    /* loaded from: classes3.dex */
    public static class b implements BaiduStatJSInterface.IWebviewPageLoadCallback {
        @Override // com.baidu.mobstat.BaiduStatJSInterface.IWebviewPageLoadCallback
        public void onPageStarted(WebView webView, String str, bs bsVar) {
            if (am.a() && !be.a().b()) {
                if (bo.c().b()) {
                    bo.c().a("WebView onPageStarted");
                }
                webView.addJavascriptInterface(bsVar, "WebViewInterface");
            }
        }

        @Override // com.baidu.mobstat.BaiduStatJSInterface.IWebviewPageLoadCallback
        public void onPageFinished(WebView webView, String str, bs bsVar) {
            if (am.a() && !be.a().b()) {
                if (bo.c().b()) {
                    bo.c().a("WebView onPageFinished");
                }
                webView.addJavascriptInterface(bsVar, "WebViewInterface");
                bg.a().a(webView, str, bsVar);
            }
        }
    }

    public static void b(String str) {
        if (am.a()) {
            bg.a().a(str);
        }
    }
}
