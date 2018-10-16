package com.baidu.searchbox.ng.ai.apps.event.message;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class AiAppsNativeMessage {
    private static final String DATA_KEY = "message";
    private static final boolean DEBUG = false;
    private static final String TAG = "AiAppsNativeMessage";
    private static final String WEBVIEW_ID_KEY = "webviewid";
    public final String mData;
    public final String mWebViewId;

    public AiAppsNativeMessage(String str, String str2) {
        this.mWebViewId = str;
        this.mData = str2;
    }

    public static AiAppsNativeMessage createEvent(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new AiAppsNativeMessage(jSONObject.optString(WEBVIEW_ID_KEY), jSONObject.optString("message"));
        } catch (JSONException e) {
            return null;
        }
    }
}
