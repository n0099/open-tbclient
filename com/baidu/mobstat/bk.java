package com.baidu.mobstat;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bk {
    public static String a;
    public WeakReference<WebView> b;
    public WeakReference<Activity> c;
    public JSONObject d;
    public boolean e;
    public boolean f;

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
            } catch (Exception unused) {
            }
            if (!TextUtils.isEmpty(a)) {
                return a;
            }
            i = i2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0036 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(String str, Activity activity, WebView webView) {
        JSONArray jSONArray;
        String str2;
        String str3;
        boolean z;
        String str4;
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
                    String str5 = str3;
                    if (!z) {
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
            String str52 = str3;
            if (!z) {
            }
        }
        JSONObject jSONObject322 = jSONObject2;
        JSONArray jSONArray222 = jSONArray;
        String str522 = str3;
        if (!z) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            str4 = "/";
        } else {
            str4 = str2;
        }
        JSONArray a2 = bi.a(activity, webView);
        String name = activity.getClass().getName();
        String a3 = bi.a(a2);
        String b = bi.b(jSONArray222);
        String f = bi.f(webView);
        Map<String, String> g = bi.g(webView);
        Context applicationContext = activity.getApplicationContext();
        long currentTimeMillis = System.currentTimeMillis();
        if (a(this.d, activity.getClass().getName(), str4, a3, b)) {
            BDStatCore.instance().onEvent(applicationContext, "", str522, 1, System.currentTimeMillis(), a2, jSONArray222, name, str4, f, g, true);
        } else if (bc.c().b() && this.f) {
            bc.c().a("setEventToNative: not circle event, will not take effect");
        }
        av.a().a(applicationContext, "", str522, "", 1, currentTimeMillis, name, a2, str4, jSONArray222, f, g, true, jSONObject322, "", null);
    }

    private boolean a(WebView webView, boolean z) {
        WeakReference<WebView> weakReference = this.b;
        if (weakReference != null && weakReference.get() == webView && this.e != z) {
            return true;
        }
        return false;
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
                    String optString2 = jSONObject2.optString(TtmlNode.TAG_LAYOUT);
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

    public static void b(Activity activity, final WebView webView, Rect rect) {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        if (rect != null) {
            i4 = ag.a(activity, rect.left);
            i2 = ag.a(activity, rect.top);
            i3 = ag.a(activity, rect.width());
            i = ag.a(activity, rect.height());
        } else {
            i = 0;
            i2 = 0;
            i3 = 0;
        }
        final String str = "javascript:window._automtj.getViewportTree('android', '" + ("{\"x\": " + i4 + ", \"y\": " + i2 + ", \"w\": " + i3 + ", \"h\": " + i + ", \"sw\": " + ag.a(activity, bi.c(activity)) + ", \"sh\": " + ag.a(activity, bi.d(activity)) + "}") + "', 'window.WebViewInterface.setViewportTreeToNative')";
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.mobstat.bk.1
            @Override // java.lang.Runnable
            public void run() {
                webView.loadUrl(str);
            }
        });
    }

    public void a(Activity activity, WebView webView, String str, JSONObject jSONObject, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (z) {
            this.f = z;
            this.d = jSONObject;
        }
        if (z) {
            bc.c().a("injectTrackJs circleConfig: " + jSONObject);
        }
        if (a(webView, z)) {
            if (z) {
                bc.c().a("injectTrackJs, no need to entry");
                return;
            } else {
                bg.c().a("injectTrackJs, no need to entry");
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
        if (bc.c().b() && this.f) {
            bc.c().a("injectTrackJs h5Config: " + a2);
        }
        if (bg.c().b()) {
            bg.c().a("injectTrackJs h5Config: " + a2);
        }
        String str2 = "(function(){var h5conf = {\"sdkAPI\": \"window.WebViewInterface.setEventToNative\", \"sdkType\": \"android\", \"events\": " + a2 + "};" + str + "})()";
        if (webView != null) {
            webView.loadUrl("javascript:" + str2);
        }
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
        if (bc.c().b() && this.f) {
            bc c = bc.c();
            c.a("setEventToNative: " + str);
        }
        if (bg.c().b()) {
            bg c2 = bg.c();
            c2.a("setEventToNative: " + str);
        }
        WeakReference<Activity> weakReference2 = this.c;
        if (weakReference2 == null || (activity = weakReference2.get()) == null || (weakReference = this.b) == null || (webView = weakReference.get()) == null) {
            return;
        }
        a(str, activity, webView);
    }

    @JavascriptInterface
    public void setViewportTreeToNative(String str) {
        if (bc.c().b()) {
            bc c = bc.c();
            c.a("setViewportTreeToNative " + str);
        }
        a = str;
    }
}
