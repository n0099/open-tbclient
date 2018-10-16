package com.baidu.searchbox.ng.ai.apps.jsbridge;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.baidu.browser.BrowserType;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppsSocialShareIoc;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.ubc.o;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AiAppUtilsJavaScriptInterface implements NoProGuard {
    private static final boolean DEBUG = false;
    public static final String JAVASCRIPT_INTERFACE_NAME = "Bdbox_android_utils";
    private static final String TAG = "UtilsJS";
    private static final long UBC_MIN_VERSION = 16789504;
    private Context mActivity;
    private Context mContext;
    private BdSailorWebView mWebView;
    private BrowserType mBrowserType = BrowserType.MAIN;
    private boolean mIsForceLight = false;
    private String mSource = "";

    public AiAppUtilsJavaScriptInterface(Context context, BdSailorWebView bdSailorWebView) {
        this.mActivity = context;
        this.mContext = context.getApplicationContext();
        this.mWebView = bdSailorWebView;
    }

    public void setBrowserType(BrowserType browserType) {
        this.mBrowserType = browserType;
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
        if (!ProcessUtils.isMainProcess()) {
            realCallShare(this.mActivity, this.mContext, this.mSource, this.mBrowserType, str, str2, z, z2, str3, new IAiAppsSocialShareIoc.OnShareResultListener() { // from class: com.baidu.searchbox.ng.ai.apps.jsbridge.AiAppUtilsJavaScriptInterface.1
                @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppsSocialShareIoc.OnShareResultListener
                public void notify(String str4, String str5) {
                    AiAppUtilsJavaScriptInterface.this.notifyCallback(str4, str5);
                }

                @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppsSocialShareIoc.OnShareResultListener
                public void onSharePanelCancel() {
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyCallback(String str, String str2) {
        loadJavaScript("javascript:" + str + "(" + str2 + ");");
    }

    protected void loadJavaScript(final String str) {
        if (this.mWebView != null) {
            AiAppsUtils.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.jsbridge.AiAppUtilsJavaScriptInterface.2
                @Override // java.lang.Runnable
                public void run() {
                    String str2 = str;
                    if (!str2.startsWith("javascript:")) {
                        str2 = "javascript:" + str2;
                    }
                    AiAppUtilsJavaScriptInterface.this.mWebView.loadUrl(str2);
                }
            });
        }
    }

    @JavascriptInterface
    public static void realCallShare(Context context, Context context2, String str, BrowserType browserType, String str2, String str3, boolean z, boolean z2, String str4, IAiAppsSocialShareIoc.OnShareResultListener onShareResultListener) {
        AiAppsRuntime.getSocialShareRuntime().share(context, str, browserType, str2, str3, z, z2, str4, onShareResultListener);
    }

    @JavascriptInterface
    public void consoleLog(String str) {
        if (TextUtils.isEmpty(str)) {
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
                        o.onEvent(jSONObject.optString("actionId"), jSONObject.optString("value"));
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
