package com.baidu.swan.apps.console.v8inspector;

import android.util.Log;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.swan.apps.ap.ak;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String mTitle = "background";
    private static String mType = "page";
    private static String mUrl = "runtime/index.js";
    private static String csg = "ws://localhost:4000";
    private String mId = String.valueOf(System.currentTimeMillis());
    private String csh = "http://chrome-devtools-frontend.appspot.com/serve_rev/@793eb32f50bafcb87fb5d1a0fd3f44e66470e580/inspector.html?ws=localhost:4000";
    private boolean mAttached = false;
    private boolean csi = true;
    private int csj = 0;
    private int csk = 0;
    private boolean mVisible = true;

    public String toString() {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.putOpt("title", mTitle);
            jSONObject.putOpt("type", mType);
            jSONObject.putOpt("url", mUrl);
            jSONObject.putOpt("webSocketDebuggerUrl", csg);
            jSONObject.putOpt("id", this.mId);
            jSONObject.putOpt("devtoolsFrontendUrl", this.csh);
            jSONObject.putOpt("swanJsVersion", com.baidu.swan.apps.swancore.b.kk(0));
            jSONObject.putOpt("appVersion", ak.getVersionName());
            jSONObject2.putOpt("attached", Boolean.valueOf(this.mAttached));
            jSONObject2.putOpt(SchemeCollecter.CLASSIFY_EMPTY, Boolean.valueOf(this.csi));
            jSONObject2.putOpt("screenX", Integer.valueOf(this.csj));
            jSONObject2.putOpt("screenY", Integer.valueOf(this.csk));
            jSONObject2.putOpt(MapBundleKey.MapObjKey.OBJ_SL_VISI, Boolean.valueOf(this.mVisible));
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
