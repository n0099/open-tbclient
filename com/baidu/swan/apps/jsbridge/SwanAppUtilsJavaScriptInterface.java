package com.baidu.swan.apps.jsbridge;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Keep;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.aq.v;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.performance.a.f;
import com.baidu.swan.apps.t.b.i;
import org.json.JSONException;
import org.json.JSONObject;
@Keep
/* loaded from: classes7.dex */
public class SwanAppUtilsJavaScriptInterface {
    private static final boolean DEBUG = b.DEBUG;
    public static final String JAVASCRIPT_INTERFACE_NAME = "Bdbox_android_utils";
    public static final String KEY_SHARE_FORCE_LIGHT_THEME = "forceLightTheme";
    public static final String KEY_SHARE_SNAPSHOT = "snapshot";
    private static final String TAG = "UtilsJS";
    private static final long UBC_MIN_VERSION = 16789504;
    private Context mActivity;
    private Context mContext;
    private boolean mIsForceLight = false;
    private String mSource = "";
    private com.baidu.swan.apps.core.container.a mWebView;

    public SwanAppUtilsJavaScriptInterface(Context context, com.baidu.swan.apps.core.container.a aVar) {
        this.mActivity = context;
        this.mContext = context.getApplicationContext();
        this.mWebView = aVar;
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
        f.aoh().iI("callShare");
        realCallShare(this.mActivity, this.mSource, str, str2, z, z2, str3);
        f.aoh().iJ("callShare");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyCallback(String str, String str2) {
        loadJavaScript("javascript:" + str + "(" + str2 + ");");
    }

    protected void loadJavaScript(final String str) {
        if (this.mWebView != null) {
            al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.jsbridge.SwanAppUtilsJavaScriptInterface.1
                @Override // java.lang.Runnable
                public void run() {
                    String str2 = str;
                    if (!str2.startsWith("javascript:")) {
                        str2 = "javascript:" + str2;
                    }
                    if (SwanAppUtilsJavaScriptInterface.DEBUG) {
                        Log.d(SwanAppUtilsJavaScriptInterface.TAG, "share result:" + str2);
                    }
                    SwanAppUtilsJavaScriptInterface.this.mWebView.evaluateJavascript(str2, null);
                }
            });
        }
    }

    public void realCallShare(Context context, String str, String str2, final String str3, boolean z, boolean z2, final String str4) {
        if (DEBUG) {
            Log.i(TAG, "callShare");
        }
        JSONObject parseString = v.parseString(str2);
        try {
            parseString.put(KEY_SHARE_SNAPSHOT, z);
            parseString.put(KEY_SHARE_FORCE_LIGHT_THEME, z2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        com.baidu.swan.apps.t.a.ahk().a(context, parseString, new i.a() { // from class: com.baidu.swan.apps.jsbridge.SwanAppUtilsJavaScriptInterface.2
            @Override // com.baidu.swan.apps.t.b.i.a
            public void aiI() {
                SwanAppUtilsJavaScriptInterface.this.notifyCallback(str3, String.valueOf(true));
            }

            @Override // com.baidu.swan.apps.t.b.i.a
            public void aiJ() {
                SwanAppUtilsJavaScriptInterface.this.notifyCallback(str4, String.valueOf(false));
            }
        });
    }

    @JavascriptInterface
    public void consoleLog(String str) {
        if (!TextUtils.isEmpty(str) && DEBUG) {
            Log.e(TAG, "consoleLog : " + str + "->" + System.currentTimeMillis());
        }
    }

    @JavascriptInterface
    public void ubcEvent(final String str) {
        if (!TextUtils.isEmpty(str)) {
            f.aoh().iI("ubcEvent");
            if (com.baidu.swan.apps.performance.b.b.aon()) {
                ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.jsbridge.SwanAppUtilsJavaScriptInterface.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (SwanAppUtilsJavaScriptInterface.DEBUG) {
                            Log.d(SwanAppUtilsJavaScriptInterface.TAG, "ubcEvent in thread pool");
                        }
                        SwanAppUtilsJavaScriptInterface.this.doUbcEvent(str);
                    }
                }, "ubcEvent", 3);
            } else {
                doUbcEvent(str);
            }
            f.aoh().iJ("ubcEvent");
        }
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
            if (j >= UBC_MIN_VERSION) {
                jSONObject.optString("actionId");
                jSONObject.optString("value");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            f.aoh().iJ("ubcEvent");
        }
    }
}
