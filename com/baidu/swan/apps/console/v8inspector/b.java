package com.baidu.swan.apps.console.v8inspector;

import android.util.Log;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.swan.apps.as.ai;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String mTitle = "background";
    private static String mType = "page";
    private static String mUrl = "runtime/index.js";
    private static String bJs = "ws://localhost:4000";
    private String mId = String.valueOf(System.currentTimeMillis());
    private String bJt = "http://chrome-devtools-frontend.appspot.com/serve_rev/@793eb32f50bafcb87fb5d1a0fd3f44e66470e580/inspector.html?ws=localhost:4000";
    private boolean mAttached = false;
    private boolean bJu = true;
    private int bJv = 0;
    private int bJw = 0;
    private boolean mVisible = true;

    public String toString() {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.putOpt("title", mTitle);
            jSONObject.putOpt("type", mType);
            jSONObject.putOpt("url", mUrl);
            jSONObject.putOpt("webSocketDebuggerUrl", bJs);
            jSONObject.putOpt("id", this.mId);
            jSONObject.putOpt("devtoolsFrontendUrl", this.bJt);
            jSONObject.putOpt("swanJsVersion", com.baidu.swan.apps.swancore.b.gF(0));
            jSONObject.putOpt("appVersion", ai.getVersionName());
            jSONObject2.putOpt("attached", Boolean.valueOf(this.mAttached));
            jSONObject2.putOpt(SchemeCollecter.CLASSIFY_EMPTY, Boolean.valueOf(this.bJu));
            jSONObject2.putOpt("screenX", Integer.valueOf(this.bJv));
            jSONObject2.putOpt("screenY", Integer.valueOf(this.bJw));
            jSONObject2.putOpt("visible", Boolean.valueOf(this.mVisible));
            jSONObject.putOpt("description", jSONObject2.toString());
            jSONArray.put(jSONObject);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("V8Module", "Build V8 module fail", e);
            }
        }
        return jSONArray.toString();
    }
}
