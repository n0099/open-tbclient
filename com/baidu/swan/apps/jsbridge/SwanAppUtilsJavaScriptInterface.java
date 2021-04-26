package com.baidu.swan.apps.jsbridge;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.wallet.lightapp.base.LightappJsNativeClient;
import d.a.h0.a.i2.k0;
import d.a.h0.a.i2.v;
import d.a.h0.a.k;
import d.a.h0.a.w0.c.i;
import org.json.JSONException;
import org.json.JSONObject;
@Keep
/* loaded from: classes2.dex */
public class SwanAppUtilsJavaScriptInterface {
    public static final boolean DEBUG = k.f43101a;
    public static final String JAVASCRIPT_INTERFACE_NAME = "Bdbox_android_utils";
    public static final String KEY_SHARE_FORCE_LIGHT_THEME = "forceLightTheme";
    public static final String KEY_SHARE_SNAPSHOT = "snapshot";
    public static final String TAG = "UtilsJS";
    public static final long UBC_MIN_VERSION = 16789504;
    public Context mActivity;
    public Context mContext;
    public boolean mIsForceLight = false;
    public String mSource = "";
    public d.a.h0.a.e0.k.a mWebView;

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f11736e;

        public a(String str) {
            this.f11736e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = this.f11736e;
            if (!str.startsWith("javascript:")) {
                str = "javascript:" + str;
            }
            if (SwanAppUtilsJavaScriptInterface.DEBUG) {
                Log.d(SwanAppUtilsJavaScriptInterface.TAG, "share result:" + str);
            }
            SwanAppUtilsJavaScriptInterface.this.mWebView.evaluateJavascript(str, null);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements i.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f11738a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f11739b;

        public b(String str, String str2) {
            this.f11738a = str;
            this.f11739b = str2;
        }

        @Override // d.a.h0.a.w0.c.i.a
        public void a() {
            SwanAppUtilsJavaScriptInterface.this.notifyCallback(this.f11739b, String.valueOf(false));
        }

        @Override // d.a.h0.a.w0.c.i.a
        public void b() {
            SwanAppUtilsJavaScriptInterface.this.notifyCallback(this.f11738a, String.valueOf(true));
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f11741e;

        public c(String str) {
            this.f11741e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SwanAppUtilsJavaScriptInterface.DEBUG) {
                Log.d(SwanAppUtilsJavaScriptInterface.TAG, "ubcEvent in thread pool");
            }
            SwanAppUtilsJavaScriptInterface.this.doUbcEvent(this.f11741e);
        }
    }

    public SwanAppUtilsJavaScriptInterface(Context context, d.a.h0.a.e0.k.a aVar) {
        this.mActivity = context;
        this.mContext = context.getApplicationContext();
        this.mWebView = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doUbcEvent(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyCallback(String str, String str2) {
        loadJavaScript("javascript:" + str + "(" + str2 + ");");
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
            k0.X(new a(str));
        }
    }

    public void realCallShare(Context context, String str, String str2, String str3, boolean z, boolean z2, String str4) {
        if (DEBUG) {
            Log.i(TAG, LightappJsNativeClient.METHOD_CALL_SHARE);
        }
        JSONObject b2 = v.b(str2);
        try {
            b2.put(KEY_SHARE_SNAPSHOT, z);
            b2.put(KEY_SHARE_FORCE_LIGHT_THEME, z2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        d.a.h0.a.w0.a.M().a(context, b2, new b(str3, str4));
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
