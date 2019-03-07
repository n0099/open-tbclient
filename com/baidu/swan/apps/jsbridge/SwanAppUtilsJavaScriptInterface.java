package com.baidu.swan.apps.jsbridge;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Keep;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.an.n;
import com.baidu.swan.apps.c;
import com.baidu.swan.apps.u.b.u;
import com.baidu.swan.ubc.r;
import com.baidu.ubc.UBC;
import org.json.JSONException;
import org.json.JSONObject;
@Keep
/* loaded from: classes2.dex */
public class SwanAppUtilsJavaScriptInterface {
    private static final boolean DEBUG = c.DEBUG;
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
        realCallShare(this.mActivity, this.mSource, str, str2, z, z2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyCallback(String str, String str2) {
        loadJavaScript("javascript:" + str + "(" + str2 + ");");
    }

    protected void loadJavaScript(final String str) {
        if (this.mWebView != null) {
            aa.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.jsbridge.SwanAppUtilsJavaScriptInterface.1
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
        JSONObject dk = n.dk(str2);
        try {
            dk.put(KEY_SHARE_SNAPSHOT, z);
            dk.put(KEY_SHARE_FORCE_LIGHT_THEME, z2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        com.baidu.swan.apps.u.a.Cz().a(context, dk, new u.a() { // from class: com.baidu.swan.apps.jsbridge.SwanAppUtilsJavaScriptInterface.2
            @Override // com.baidu.swan.apps.u.b.u.a
            public void Du() {
                SwanAppUtilsJavaScriptInterface.this.notifyCallback(str3, String.valueOf(true));
            }

            @Override // com.baidu.swan.apps.u.b.u.a
            public void Dv() {
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
    public void ubcEvent(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                Long l = 0L;
                try {
                    String optString = jSONObject.optString("min_v");
                    if (!TextUtils.isEmpty(optString)) {
                        l = Long.valueOf(optString);
                    }
                    if (l.longValue() >= UBC_MIN_VERSION) {
                        r.onEvent(jSONObject.optString("actionId"), jSONObject.optString(UBC.CONTENT_KEY_VALUE));
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }
}
