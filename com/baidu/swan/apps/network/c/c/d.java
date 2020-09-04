package com.baidu.swan.apps.network.c.c;

import android.support.annotation.NonNull;
import android.support.media.ExifInterface;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final String cFF;
    private long cFG;
    private long cFH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.cFF = str;
        if (DEBUG) {
            Log.d(ExifInterface.TAG_MODEL, "new model, scope id - " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bp(long j) {
        this.cFG = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bq(long j) {
        this.cFH = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long avk() {
        return this.cFG;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("scope_id", this.cFF);
            jSONObject.put("begin_ts", this.cFG);
            jSONObject.put("end_ts", this.cFH);
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
