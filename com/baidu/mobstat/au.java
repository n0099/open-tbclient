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
public class au {
    public static void a(Context context) {
        if (!ad.a() || aw.a().b()) {
            return;
        }
        av.a().a(context);
    }

    public static void b(String str) {
        if (!ad.a()) {
            return;
        }
        ay.a().a(str);
    }

    /* loaded from: classes3.dex */
    public static class a implements ActivityLifeObserver.IActivityLifeCallback {
        @Override // com.baidu.mobstat.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

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
        public void onActivityPaused(Activity activity) {
            if (!ad.a() || aw.a().b()) {
                return;
            }
            if (bg.c().b()) {
                bg.c().a("onActivityPaused");
            }
            ay.a().b(activity);
        }

        @Override // com.baidu.mobstat.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityResumed(Activity activity) {
            if (!ad.a() || aw.a().b()) {
                return;
            }
            if (bg.c().b()) {
                bg.c().a("onActivityResumed");
            }
            ay.a().a(activity);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements BaiduStatJSInterface.IWebviewPageLoadCallback {
        @Override // com.baidu.mobstat.BaiduStatJSInterface.IWebviewPageLoadCallback
        public void onPageFinished(WebView webView, String str, bk bkVar) {
            if (!ad.a() || aw.a().b()) {
                return;
            }
            if (bg.c().b()) {
                bg.c().a("WebView onPageFinished");
            }
            webView.addJavascriptInterface(bkVar, "WebViewInterface");
            ay.a().a(webView, str, bkVar);
        }

        @Override // com.baidu.mobstat.BaiduStatJSInterface.IWebviewPageLoadCallback
        public void onPageStarted(WebView webView, String str, bk bkVar) {
            if (!ad.a() || aw.a().b()) {
                return;
            }
            if (bg.c().b()) {
                bg.c().a("WebView onPageStarted");
            }
            webView.addJavascriptInterface(bkVar, "WebViewInterface");
        }
    }

    public static void a(Context context, boolean z) {
        if (!ad.a() || aw.a().b()) {
            return;
        }
        av.a().a(context, z);
    }

    public static void a(MtjConfig.FeedTrackStrategy feedTrackStrategy) {
        if (aw.a().b()) {
            return;
        }
        aq.a(feedTrackStrategy);
    }

    public static void a(String str) {
        if (!ad.a() || aw.a().b()) {
            return;
        }
        ay.a().b(str);
    }

    public static void a(JSONObject jSONObject) {
        if (!ad.a() || aw.a().b()) {
            return;
        }
        av.a().a(jSONObject);
    }
}
