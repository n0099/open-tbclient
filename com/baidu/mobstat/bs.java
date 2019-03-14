package com.baidu.mobstat;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.coremedia.iso.boxes.MetaBox;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class bs {
    private static String a;
    private WeakReference<WebView> b;
    private WeakReference<Activity> c;
    private JSONObject d;
    private boolean e;
    private boolean f;

    public void a(WebView webView, String str) {
        if (!TextUtils.isEmpty(str)) {
            webView.loadUrl("javascript:" + str);
        }
    }

    @JavascriptInterface
    public void setViewportTreeToNative(String str) {
        if (bk.c().b()) {
            bk.c().a("setViewportTreeToNative " + str);
        }
        a = str;
    }

    public static String a(Activity activity, WebView webView, Rect rect) {
        a = "";
        b(activity, webView, rect);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i >= 15) {
                return "";
            }
            try {
                Thread.sleep(20L);
            } catch (Exception e) {
            }
            if (!TextUtils.isEmpty(a)) {
                return a;
            }
            i = i2;
        }
    }

    private static void b(Activity activity, final WebView webView, Rect rect) {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        if (rect != null) {
            i3 = ao.a(activity, rect.left);
            i2 = ao.a(activity, rect.top);
            i = ao.a(activity, rect.width());
            i4 = ao.a(activity, rect.height());
        } else {
            i = 0;
            i2 = 0;
            i3 = 0;
        }
        int a2 = ao.a(activity, bq.c(activity));
        final String str = "javascript:window._automtj.getViewportTree('android', '" + ("{\"x\": " + i3 + ", \"y\": " + i2 + ", \"w\": " + i + ", \"h\": " + i4 + ", \"sw\": " + a2 + ", \"sh\": " + ao.a(activity, bq.d(activity)) + "}") + "', 'window.WebViewInterface.setViewportTreeToNative')";
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.mobstat.bs.1
            @Override // java.lang.Runnable
            public void run() {
                webView.loadUrl(str);
            }
        });
    }

    public void a(Activity activity, WebView webView, String str, JSONObject jSONObject, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                this.f = z;
                this.d = jSONObject;
            }
            if (z) {
                bk.c().a("injectTrackJs circleConfig: " + jSONObject);
            }
            if (a(webView, z)) {
                if (z) {
                    bk.c().a("injectTrackJs, no need to entry");
                    return;
                } else {
                    bo.c().a("injectTrackJs, no need to entry");
                    return;
                }
            }
            if (activity != null) {
                this.c = new WeakReference<>(activity);
            }
            if (webView != null) {
                this.b = new WeakReference<>(webView);
            }
            this.e = z;
            String a2 = a();
            if (TextUtils.isEmpty(a2)) {
                a2 = new JSONObject().toString();
            }
            if (bk.c().b() && this.f) {
                bk.c().a("injectTrackJs h5Config: " + a2);
            }
            if (bo.c().b()) {
                bo.c().a("injectTrackJs h5Config: " + a2);
            }
            webView.loadUrl("javascript:" + ("(function(){var h5conf = {\"sdkAPI\": \"window.WebViewInterface.setEventToNative\", \"sdkType\": \"android\", \"events\": " + a2 + "};" + str + "})()"));
        }
    }

    private boolean a(WebView webView, boolean z) {
        return (this.b == null || this.b.get() != webView || this.e == z) ? false : true;
    }

    private String a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("matchAll", 1);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(MetaBox.TYPE, jSONObject);
            return jSONObject2.toString();
        } catch (Exception e) {
            return new JSONObject().toString();
        }
    }

    @JavascriptInterface
    public void setEventToNative(String str) {
        Activity activity;
        WebView webView;
        if (bk.c().b() && this.f) {
            bk.c().a("setEventToNative: " + str);
        }
        if (bo.c().b()) {
            bo.c().a("setEventToNative: " + str);
        }
        if (this.c != null && (activity = this.c.get()) != null && this.b != null && (webView = this.b.get()) != null) {
            a(str, activity, webView);
        }
    }

    private void a(String str, Activity activity, WebView webView) {
        String str2;
        JSONArray jSONArray;
        boolean z;
        String str3;
        JSONArray jSONArray2 = null;
        String str4 = null;
        String str5 = null;
        JSONObject jSONObject = null;
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            jSONArray2 = jSONObject2.optJSONArray(Config.EVENT_H5_VIEW_HIERARCHY);
            str4 = jSONObject2.optString(Config.EVENT_H5_PAGE);
            str5 = jSONObject2.optString("l");
            jSONObject = jSONObject2.optJSONObject(Config.EVENT_HEAT_POINT);
            str2 = str5;
            jSONArray = jSONArray2;
            z = true;
            str3 = str4;
        } catch (Exception e) {
            str2 = str5;
            jSONArray = jSONArray2;
            z = false;
            str3 = str4;
        }
        if (z) {
            if (TextUtils.isEmpty(str3)) {
                str3 = "/";
            }
            JSONArray a2 = bq.a(activity, webView);
            String name = activity.getClass().getName();
            String a3 = bq.a(a2);
            String b = bq.b(jSONArray);
            String f = bq.f(webView);
            Map<String, String> g = bq.g(webView);
            Context applicationContext = activity.getApplicationContext();
            long currentTimeMillis = System.currentTimeMillis();
            if (a(this.d, activity.getClass().getName(), str3, a3, b)) {
                BDStatCore.instance().onEvent(applicationContext, "", str2, 1, System.currentTimeMillis(), a2, jSONArray, name, str3, f, g, true);
            } else if (bk.c().b() && this.f) {
                bk.c().a("setEventToNative: not circle event, will not take effect");
            }
            bd.a().a(applicationContext, "", str2, 1, currentTimeMillis, name, a2, str3, jSONArray, f, g, true, jSONObject, "");
        }
    }

    private boolean a(JSONObject jSONObject, String str, String str2, String str3, String str4) {
        boolean z = false;
        if (jSONObject == null || jSONObject.toString().equals(new JSONObject().toString())) {
            return false;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            return false;
        }
        try {
            if (((JSONObject) jSONObject.get(MetaBox.TYPE)).getInt("matchAll") != 0) {
                return true;
            }
        } catch (Exception e) {
        }
        try {
            JSONArray jSONArray = (JSONArray) jSONObject.get("data");
            int i = 0;
            while (i < jSONArray.length()) {
                JSONObject jSONObject2 = (JSONObject) jSONArray.get(i);
                i++;
                z = (str.equals(jSONObject2.optString("page")) && str2.equals((String) jSONObject2.opt("url")) && str3.equals(jSONObject2.optString("layout")) && str4.equals((String) jSONObject2.opt("webLayout"))) ? true : z;
            }
        } catch (Exception e2) {
        }
        return z;
    }
}
