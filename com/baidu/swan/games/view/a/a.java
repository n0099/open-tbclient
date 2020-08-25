package com.baidu.swan.games.view.a;

import android.util.Log;
import com.baidu.swan.apps.statistic.a.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends e {
    public String mErrorCode = "";

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.cXz == null) {
            this.cXz = new JSONObject();
        }
        try {
            this.cXz.put("error_code", this.mErrorCode);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        if (DEBUG) {
            Log.d("SwanGameAdEvent", "SwanGameAdEvent: mExt=" + this.cXz + "\t " + Thread.currentThread().getId());
        }
        return super.toJSONObject();
    }
}
