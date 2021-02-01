package com.baidu.swan.apps.network.c.c;

import android.util.Log;
import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final String dpQ;
    private long dpR;
    private long dpS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.dpQ = str;
        if (DEBUG) {
            Log.d("Model", "new model, scope id - " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cC(long j) {
        this.dpR = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cD(long j) {
        this.dpS = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long aDw() {
        return this.dpR;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("scope_id", this.dpQ);
            jSONObject.put("begin_ts", this.dpR);
            jSONObject.put("end_ts", this.dpS);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        if (DEBUG) {
            Log.d("Model", jSONObject.toString());
        }
        return jSONObject;
    }

    @NonNull
    public String toString() {
        return toJson().toString();
    }
}
