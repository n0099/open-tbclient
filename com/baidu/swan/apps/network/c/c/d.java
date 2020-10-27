package com.baidu.swan.apps.network.c.c;

import android.support.annotation.NonNull;
import android.support.media.ExifInterface;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final String dcg;
    private long dch;
    private long dci;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.dcg = str;
        if (DEBUG) {
            Log.d(ExifInterface.TAG_MODEL, "new model, scope id - " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bA(long j) {
        this.dch = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bB(long j) {
        this.dci = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long aAy() {
        return this.dch;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("scope_id", this.dcg);
            jSONObject.put("begin_ts", this.dch);
            jSONObject.put("end_ts", this.dci);
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
