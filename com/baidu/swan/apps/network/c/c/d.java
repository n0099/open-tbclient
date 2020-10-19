package com.baidu.swan.apps.network.c.c;

import android.support.annotation.NonNull;
import android.support.media.ExifInterface;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final String cTI;
    private long cTJ;
    private long cTK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.cTI = str;
        if (DEBUG) {
            Log.d(ExifInterface.TAG_MODEL, "new model, scope id - " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void by(long j) {
        this.cTJ = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bz(long j) {
        this.cTK = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long ayE() {
        return this.cTJ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("scope_id", this.cTI);
            jSONObject.put("begin_ts", this.cTJ);
            jSONObject.put("end_ts", this.cTK);
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
