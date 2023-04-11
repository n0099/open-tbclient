package com.baidu.swan.apps.jsbridge;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.tieba.ba2;
import com.baidu.tieba.be3;
import com.baidu.tieba.br2;
import com.baidu.tieba.eo1;
import com.baidu.tieba.ge3;
import com.baidu.tieba.h13;
import com.baidu.tieba.ol3;
import com.baidu.tieba.s62;
import com.baidu.tieba.uk3;
import com.baidu.tieba.zr2;
import org.json.JSONException;
import org.json.JSONObject;
@Keep
/* loaded from: classes3.dex */
public class SwanAppUtilsJavaScriptInterface {
    public static final boolean DEBUG = eo1.a;
    public static final String JAVASCRIPT_INTERFACE_NAME = "Bdbox_android_utils";
    public static final String KEY_SHARE_FORCE_LIGHT_THEME = "forceLightTheme";
    public static final String KEY_SHARE_SNAPSHOT = "snapshot";
    public static final String TAG = "UtilsJS";
    public static final long UBC_MIN_VERSION = 16789504;
    public Context mActivity;
    public boolean mIsForceLight = false;
    public String mSource = "";
    public s62 mWebView;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = this.a;
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
    public class b implements zr2.a {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public b(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // com.baidu.tieba.zr2.a
        public void a() {
            SwanAppUtilsJavaScriptInterface.this.notifyCallback(this.b, String.valueOf(false));
        }

        @Override // com.baidu.tieba.zr2.a
        public void b() {
            SwanAppUtilsJavaScriptInterface.this.notifyCallback(this.a, String.valueOf(true));
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public final /* synthetic */ String a;

        public c(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SwanAppUtilsJavaScriptInterface.DEBUG) {
                Log.d(SwanAppUtilsJavaScriptInterface.TAG, "ubcEvent in thread pool");
            }
            SwanAppUtilsJavaScriptInterface.this.doUbcEvent(this.a);
        }
    }

    public SwanAppUtilsJavaScriptInterface(Context context, s62 s62Var) {
        this.mActivity = context;
        this.mWebView = s62Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyCallback(String str, String str2) {
        loadJavaScript("javascript:" + str + "(" + str2 + ");");
    }

    @JavascriptInterface
    public void consoleLog(String str) {
        if (!TextUtils.isEmpty(str) && DEBUG) {
            Log.e(TAG, "consoleLog : " + str + "->" + System.currentTimeMillis());
        }
    }

    public void loadJavaScript(String str) {
        if (this.mWebView != null) {
            ol3.e0(new a(str));
        }
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
    public void callShare(String str, String str2, String str3) {
        callShare(str, str2, true, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doUbcEvent(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            long j = 0;
            String optString = jSONObject.optString("min_v");
            if (!TextUtils.isEmpty(optString)) {
                j = Long.valueOf(optString).longValue();
            }
            if (j < UBC_MIN_VERSION) {
                return;
            }
            be3.l(jSONObject.optString("actionId"), jSONObject.optString("value"));
            h13.h().g().b(jSONObject);
        } catch (NumberFormatException | JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
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

    public void realCallShare(Context context, String str, String str2, String str3, boolean z, boolean z2, String str4) {
        if (DEBUG) {
            Log.i(TAG, "callShare");
        }
        JSONObject d = uk3.d(str2);
        try {
            d.put(KEY_SHARE_SNAPSHOT, z);
            d.put(KEY_SHARE_FORCE_LIGHT_THEME, z2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        br2.f0().a(context, d, new b(str3, str4));
    }

    @JavascriptInterface
    public void ubcEvent(String str) {
        if (TextUtils.isEmpty(str) || ge3.b(str)) {
            return;
        }
        s62 s62Var = this.mWebView;
        if (ba2.a(s62Var, "ubcEvent - " + str)) {
            return;
        }
        ExecutorUtilsExt.postOnElastic(new c(str), "ubcEvent", 3);
    }
}
