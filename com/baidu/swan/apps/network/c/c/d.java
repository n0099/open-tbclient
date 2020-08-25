package com.baidu.swan.apps.network.c.c;

import android.support.annotation.NonNull;
import android.support.media.ExifInterface;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final String cFB;
    private long cFC;
    private long cFD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.cFB = str;
        if (DEBUG) {
            Log.d(ExifInterface.TAG_MODEL, "new model, scope id - " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bp(long j) {
        this.cFC = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bq(long j) {
        this.cFD = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long avk() {
        return this.cFC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("scope_id", this.cFB);
            jSONObject.put("begin_ts", this.cFC);
            jSONObject.put("end_ts", this.cFD);
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
