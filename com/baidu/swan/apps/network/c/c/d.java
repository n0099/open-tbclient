package com.baidu.swan.apps.network.c.c;

import android.support.annotation.NonNull;
import android.support.media.ExifInterface;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final String cHF;
    private long cHG;
    private long cHH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.cHF = str;
        if (DEBUG) {
            Log.d(ExifInterface.TAG_MODEL, "new model, scope id - " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bq(long j) {
        this.cHG = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void br(long j) {
        this.cHH = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long avT() {
        return this.cHG;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("scope_id", this.cHF);
            jSONObject.put("begin_ts", this.cHG);
            jSONObject.put("end_ts", this.cHH);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        if (DEBUG) {
            Log.d(ExifInterface.TAG_MODEL, jSONObject.toString());
        }
        return jSONObject;
    }

    @NonNull
    public String toString() {
        return toJson().toString();
    }
}
