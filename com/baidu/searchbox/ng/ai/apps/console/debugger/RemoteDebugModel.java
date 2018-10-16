package com.baidu.searchbox.ng.ai.apps.console.debugger;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class RemoteDebugModel {
    private static final boolean DEBUG = false;
    private static final String KEY_APP_ID = "appId";
    private static final String KEY_APP_KEY = "appKey";
    private static final String KEY_HOST = "host";
    private static final String KEY_PORT = "port";
    private static final String SCHEME = "http://";
    private static final String TAG = "RemoteDebugModel";
    String appId;
    String appKey;
    JSONArray hostArray;
    String port;

    private RemoteDebugModel() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getRemoteUrl(int i) {
        if (this.hostArray == null) {
            return "";
        }
        String optString = this.hostArray.optString(i);
        if (!TextUtils.isEmpty(optString)) {
            return SCHEME + optString + ":" + this.port;
        }
        return "";
    }

    public static RemoteDebugModel obtainDebugModel(JSONObject jSONObject) {
        RemoteDebugModel remoteDebugModel = new RemoteDebugModel();
        try {
            remoteDebugModel.hostArray = jSONObject.getJSONArray(KEY_HOST);
            remoteDebugModel.appKey = jSONObject.getString("appKey");
            remoteDebugModel.appId = jSONObject.getString("appId");
            remoteDebugModel.port = jSONObject.getString("port");
            return remoteDebugModel;
        } catch (JSONException e) {
            return null;
        }
    }
}
