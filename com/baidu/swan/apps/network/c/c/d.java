package com.baidu.swan.apps.network.c.c;

import android.util.Log;
import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final String dsu;
    private long dsv;
    private long dsw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.dsu = str;
        if (DEBUG) {
            Log.d("Model", "new model, scope id - " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cw(long j) {
        this.dsv = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cx(long j) {
        this.dsw = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long aGT() {
        return this.dsv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("scope_id", this.dsu);
            jSONObject.put("begin_ts", this.dsv);
            jSONObject.put("end_ts", this.dsw);
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
