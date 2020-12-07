package com.baidu.swan.apps.network.c.c;

import android.support.annotation.NonNull;
import android.support.media.ExifInterface;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final String dnu;
    private long dnv;
    private long dnw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.dnu = str;
        if (DEBUG) {
            Log.d(ExifInterface.TAG_MODEL, "new model, scope id - " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cv(long j) {
        this.dnv = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cw(long j) {
        this.dnw = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long aFz() {
        return this.dnv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("scope_id", this.dnu);
            jSONObject.put("begin_ts", this.dnv);
            jSONObject.put("end_ts", this.dnw);
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
