package com.baidu.swan.apps.network.c.c;

import android.support.annotation.NonNull;
import android.support.media.ExifInterface;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final String dgu;
    private long dgv;
    private long dgw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.dgu = str;
        if (DEBUG) {
            Log.d(ExifInterface.TAG_MODEL, "new model, scope id - " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bW(long j) {
        this.dgv = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bX(long j) {
        this.dgw = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long aCq() {
        return this.dgv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("scope_id", this.dgu);
            jSONObject.put("begin_ts", this.dgv);
            jSONObject.put("end_ts", this.dgw);
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
