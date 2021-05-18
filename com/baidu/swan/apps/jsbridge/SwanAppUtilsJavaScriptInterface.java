package com.baidu.swan.apps.jsbridge;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.wallet.lightapp.base.LightappJsNativeClient;
import d.a.i0.a.a2.e;
import d.a.i0.a.c1.d.i;
import d.a.i0.a.e0.d;
import d.a.i0.a.f1.e.b;
import d.a.i0.a.j2.c;
import d.a.i0.a.k;
import d.a.i0.a.r1.k.f;
import d.a.i0.a.v2.q0;
import d.a.i0.a.v2.w;
import org.json.JSONException;
import org.json.JSONObject;
@Keep
/* loaded from: classes3.dex */
public class SwanAppUtilsJavaScriptInterface {
    public static final int DEFAULT_SWAN_UBC_LOG_SIZE = 150;
    public static final String JAVASCRIPT_INTERFACE_NAME = "Bdbox_android_utils";
    public static final String KEY_EXT_PARAMS = "params";
    public static final String KEY_EXT_SCHEME = "scheme";
    public static final String KEY_EXT_SWAN_JS = "swanjs";
    public static final String KEY_SHARE_FORCE_LIGHT_THEME = "forceLightTheme";
    public static final String KEY_SHARE_SNAPSHOT = "snapshot";
    public static final String TAG = "UtilsJS";
    public static final long UBC_MIN_VERSION = 16789504;
    public static final int UNIT_KB = 1024;
    public Context mActivity;
    public Context mContext;
    public boolean mIsForceLight = false;
    public String mSource = "";
    public d.a.i0.a.h0.f.a mWebView;
    public static final boolean DEBUG = k.f43025a;
    public static final int SWAN_UBC_LOG_MAX_SIZE_BYTES = d.a.i0.a.c1.a.Z().x() * 1024;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f10902e;

        public a(String str) {
            this.f10902e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = this.f10902e;
            if (!str.startsWith("javascript:")) {
                str = "javascript:" + str;
            }
            if (SwanAppUtilsJavaScriptInterface.DEBUG) {
                Log.d(SwanAppUtilsJavaScriptInterface.TAG, "share result:" + str);
            }
            SwanAppUtilsJavaScriptInterface.this.mWebView.evaluateJavascript(str, null);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements i.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f10904a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f10905b;

        public b(String str, String str2) {
            this.f10904a = str;
            this.f10905b = str2;
        }

        @Override // d.a.i0.a.c1.d.i.a
        public void a() {
            SwanAppUtilsJavaScriptInterface.this.notifyCallback(this.f10905b, String.valueOf(false));
        }

        @Override // d.a.i0.a.c1.d.i.a
        public void b() {
            SwanAppUtilsJavaScriptInterface.this.notifyCallback(this.f10904a, String.valueOf(true));
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f10907e;

        public c(String str) {
            this.f10907e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SwanAppUtilsJavaScriptInterface.DEBUG) {
                Log.d(SwanAppUtilsJavaScriptInterface.TAG, "ubcEvent in thread pool");
            }
            SwanAppUtilsJavaScriptInterface.this.doUbcEvent(this.f10907e);
        }
    }

    public SwanAppUtilsJavaScriptInterface(Context context, d.a.i0.a.h0.f.a aVar) {
        this.mActivity = context;
        this.mContext = context.getApplicationContext();
        this.mWebView = aVar;
    }

    private boolean checkParamsInvalid(@NonNull String str) {
        return TextUtils.isEmpty(str) || str.getBytes().length > SWAN_UBC_LOG_MAX_SIZE_BYTES;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doUbcEvent(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("min_v");
            if ((TextUtils.isEmpty(optString) ? 0L : Long.valueOf(optString).longValue()) < UBC_MIN_VERSION) {
                return;
            }
            d.a.i0.a.j2.b.l(jSONObject.optString("actionId"), jSONObject.optString("value"));
            f.j().i().d(jSONObject);
        } catch (NumberFormatException | JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    private boolean hasHitsAbTest() {
        return SWAN_UBC_LOG_MAX_SIZE_BYTES > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyCallback(String str, String str2) {
        loadJavaScript("javascript:" + str + "(" + str2 + ");");
    }

    private void reportUbcBusinessEvent(@NonNull String str) {
        e Q = e.Q();
        if (Q == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            b.a L = Q.L();
            SwanCoreVersion N = d.a.i0.a.g1.f.V().N();
            int l = Q.l();
            jSONObject.putOpt("scheme", L.W());
            jSONObject.putOpt(KEY_EXT_SWAN_JS, d.a.i0.a.m2.b.i(N, l));
            if (str != null && str.length() > 1024) {
                jSONObject.putOpt("params", str.substring(0, 1024));
            }
            c.b bVar = new c.b(10020);
            bVar.j(q0.n().f());
            bVar.i(jSONObject.toString());
            bVar.h(Q.getAppId());
            bVar.m();
            d.h(TAG, "10020, params: " + str);
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    @JavascriptInterface
    public void callShare(String str, String str2, String str3) {
        callShare(str, str2, true, str3);
    }

    @JavascriptInterface
    public void consoleLog(String str) {
        if (!TextUtils.isEmpty(str) && DEBUG) {
            Log.e(TAG, "consoleLog : " + str + "->" + System.currentTimeMillis());
        }
    }

    public void loadJavaScript(String str) {
        if (this.mWebView != null) {
            q0.b0(new a(str));
        }
    }

    public void realCallShare(Context context, String str, String str2, String str3, boolean z, boolean z2, String str4) {
        if (DEBUG) {
            Log.i(TAG, LightappJsNativeClient.METHOD_CALL_SHARE);
        }
        JSONObject d2 = w.d(str2);
        try {
            d2.put(KEY_SHARE_SNAPSHOT, z);
            d2.put(KEY_SHARE_FORCE_LIGHT_THEME, z2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        d.a.i0.a.c1.a.Y().a(context, d2, new b(str3, str4));
    }

    public void setActivity(Activity activity) {
        this.mActivity = activity;
    }

    public void setForceShareLight(boolean z) {
        this.mIsForceLight = z;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    @JavascriptInterface
    public void ubcEvent(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (hasHitsAbTest() && checkParamsInvalid(str)) {
            reportUbcBusinessEvent(str);
            return;
        }
        d.a.i0.a.h0.f.a aVar = this.mWebView;
        if (d.a.i0.a.h0.l.g.f.a(aVar, "ubcEvent - " + str)) {
            return;
        }
        ExecutorUtilsExt.postOnElastic(new c(str), "ubcEvent", 3);
    }

    @JavascriptInterface
    public void callShare(String str, String str2, boolean z, String str3) {
        if (this.mIsForceLight) {
            callShare(str, str2, z, true, str3);
        } else {
            callShare(str, str2, z, false, str3);
        }
    }

    @JavascriptInterface
    public void callShare(String str, String str2, boolean z, boolean z2, String str3) {
        realCallShare(this.mActivity, this.mSource, str, str2, z, z2, str3);
    }
}
