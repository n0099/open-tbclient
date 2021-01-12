package com.baidu.swan.apps.network.c.c;

import android.util.Log;
import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final String dnD;
    private long dnE;
    private long dnF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.dnD = str;
        if (DEBUG) {
            Log.d("Model", "new model, scope id - " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cw(long j) {
        this.dnE = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cx(long j) {
        this.dnF = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long aDa() {
        return this.dnE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("scope_id", this.dnD);
            jSONObject.put("begin_ts", this.dnE);
            jSONObject.put("end_ts", this.dnF);
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
