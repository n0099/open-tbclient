package com.baidu.swan.games.view.a;

import android.util.Log;
import com.baidu.swan.apps.statistic.a.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends e {
    public String mErrorCode = "";

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.cGu == null) {
            this.cGu = new JSONObject();
        }
        try {
            this.cGu.put("error_code", this.mErrorCode);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        if (DEBUG) {
            Log.d("SwanGameAdEvent", "SwanGameAdEvent: mExt=" + this.cGu + "\t " + Thread.currentThread().getId());
        }
        return super.toJSONObject();
    }
}
