package com.baidu.mobstat;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class bl {

    /* renamed from: a  reason: collision with root package name */
    public static String f9114a;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<WebView> f9115b;

    /* renamed from: c  reason: collision with root package name */
    public WeakReference<Activity> f9116c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f9117d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f9118e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f9119f;

    public static void b(Activity activity, final WebView webView, Rect rect) {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        if (rect != null) {
            i4 = ah.a(activity, rect.left);
            i2 = ah.a(activity, rect.top);
            i3 = ah.a(activity, rect.width());
            i = ah.a(activity, rect.height());
        } else {
            i = 0;
            i2 = 0;
            i3 = 0;
        }
        final String str = "javascript:window._automtj.getViewportTree('android', '" + ("{\"x\": " + i4 + ", \"y\": " + i2 + ", \"w\": " + i3 + ", \"h\": " + i + ", \"sw\": " + ah.a(activity, bj.c(activity)) + ", \"sh\": " + ah.a(activity, bj.d(activity)) + "}") + "', 'window.WebViewInterface.setViewportTreeToNative')";
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.mobstat.bl.1
            @Override // java.lang.Runnable
            public void run() {
                webView.loadUrl(str);
            }
        });
    }

    public void a(WebView webView, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        webView.loadUrl("javascript:" + str);
    }

    @JavascriptInterface
    public void setEventToNative(String str) {
        Activity activity;
        WeakReference<WebView> weakReference;
        WebView webView;
        if (bd.c().b() && this.f9119f) {
            bd c2 = bd.c();
            c2.a("setEventToNative: " + str);
        }
        if (bh.c().b()) {
            bh c3 = bh.c();
            c3.a("setEventToNative: " + str);
        }
        WeakReference<Activity> weakReference2 = this.f9116c;
        if (weakReference2 == null || (activity = weakReference2.get()) == null || (weakReference = this.f9115b) == null || (webView = weakReference.get()) == null) {
            return;
        }
        a(str, activity, webView);
    }

    @JavascriptInterface
    public void setViewportTreeToNative(String str) {
        if (bd.c().b()) {
            bd c2 = bd.c();
            c2.a("setViewportTreeToNative " + str);
        }
        f9114a = str;
    }

    public static String a(Activity activity, WebView webView, Rect rect) {
        f9114a = "";
        b(activity, webView, rect);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i >= 15) {
                return "";
            }
            try {
                Thread.sleep(20L);
            } catch (Exception unused) {
            }
            if (!TextUtils.isEmpty(f9114a)) {
                return f9114a;
            }
            i = i2;
        }
    }

    public void a(Activity activity, WebView webView, String str, JSONObject jSONObject, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (z) {
            this.f9119f = z;
            this.f9117d = jSONObject;
        }
        if (z) {
            bd.c().a("injectTrackJs circleConfig: " + jSONObject);
        }
        if (a(webView, z)) {
            if (z) {
                bd.c().a("injectTrackJs, no need to entry");
                return;
            } else {
                bh.c().a("injectTrackJs, no need to entry");
                return;
            }
        }
        if (activity != null) {
            this.f9116c = new WeakReference<>(activity);
        }
        if (webView != null) {
            this.f9115b = new WeakReference<>(webView);
        }
        this.f9118e = z;
        String a2 = a();
        if (TextUtils.isEmpty(a2)) {
            a2 = new JSONObject().toString();
        }
        if (bd.c().b() && this.f9119f) {
            bd.c().a("injectTrackJs h5Config: " + a2);
        }
        if (bh.c().b()) {
            bh.c().a("injectTrackJs h5Config: " + a2);
        }
        String str2 = "(function(){var h5conf = {\"sdkAPI\": \"window.WebViewInterface.setEventToNative\", \"sdkType\": \"android\", \"events\": " + a2 + "};" + str + "})()";
        if (webView != null) {
            webView.loadUrl("javascript:" + str2);
        }
    }

    private boolean a(WebView webView, boolean z) {
        WeakReference<WebView> weakReference = this.f9115b;
        return (weakReference == null || weakReference.get() != webView || this.f9118e == z) ? false : true;
    }

    private String a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("matchAll", 1);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("meta", jSONObject);
            return jSONObject2.toString();
        } catch (Exception unused) {
            return new JSONObject().toString();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(String str, Activity activity, WebView webView) {
        JSONArray jSONArray;
        String str2;
        String str3;
        boolean z;
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        try {
            jSONObject = new JSONObject(str);
            jSONArray = jSONObject.optJSONArray(Config.EVENT_H5_VIEW_HIERARCHY);
        } catch (Exception unused) {
            jSONArray = null;
            str2 = null;
        }
        try {
            str2 = jSONObject.optString("p2");
            try {
                str3 = jSONObject.optString("l");
                try {
                    jSONObject2 = jSONObject.optJSONObject(Config.EVENT_HEAT_POINT);
                    z = true;
                } catch (Exception unused2) {
                    z = false;
                    JSONObject jSONObject3 = jSONObject2;
                    JSONArray jSONArray2 = jSONArray;
                    String str4 = str3;
                    if (z) {
                    }
                }
            } catch (Exception unused3) {
                str3 = null;
            }
        } catch (Exception unused4) {
            str2 = null;
            str3 = str2;
            z = false;
            JSONObject jSONObject32 = jSONObject2;
            JSONArray jSONArray22 = jSONArray;
            String str42 = str3;
            if (z) {
            }
        }
        JSONObject jSONObject322 = jSONObject2;
        JSONArray jSONArray222 = jSONArray;
        String str422 = str3;
        if (z) {
            String str5 = TextUtils.isEmpty(str2) ? "/" : str2;
            JSONArray a2 = bj.a(activity, webView);
            String name = activity.getClass().getName();
            String a3 = bj.a(a2);
            String b2 = bj.b(jSONArray222);
            String f2 = bj.f(webView);
            Map<String, String> g2 = bj.g(webView);
            Context applicationContext = activity.getApplicationContext();
            long currentTimeMillis = System.currentTimeMillis();
            if (a(this.f9117d, activity.getClass().getName(), str5, a3, b2)) {
                BDStatCore.instance().onEvent(applicationContext, "", str422, 1, System.currentTimeMillis(), a2, jSONArray222, name, str5, f2, g2, true);
            } else if (bd.c().b() && this.f9119f) {
                bd.c().a("setEventToNative: not circle event, will not take effect");
            }
            aw.a().a(applicationContext, "", str422, 1, currentTimeMillis, name, a2, str5, jSONArray222, f2, g2, true, jSONObject322, "");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    private boolean a(JSONObject jSONObject, String str, String str2, String str3, String str4) {
        int i = 0;
        if (jSONObject == null || jSONObject.toString().equals(new JSONObject().toString()) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            return false;
        }
        try {
            if (((JSONObject) jSONObject.get("meta")).getInt("matchAll") != 0) {
                return true;
            }
        } catch (Exception unused) {
        }
        try {
            JSONArray jSONArray = (JSONArray) jSONObject.get("data");
            boolean z = false;
            while (i < jSONArray.length()) {
                try {
                    JSONObject jSONObject2 = (JSONObject) jSONArray.get(i);
                    String optString = jSONObject2.optString("page");
                    String optString2 = jSONObject2.optString("layout");
                    String str5 = (String) jSONObject2.opt("url");
                    String str6 = (String) jSONObject2.opt("webLayout");
                    if (str.equals(optString) && str2.equals(str5) && str3.equals(optString2) && str4.equals(str6)) {
                        z = true;
                    }
                    i++;
                } catch (Exception unused2) {
                    i = z ? 1 : 0;
                    return i;
                }
            }
            return z;
        } catch (Exception unused3) {
        }
    }
}
