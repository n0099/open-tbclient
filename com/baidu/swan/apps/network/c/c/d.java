package com.baidu.swan.apps.network.c.c;

import android.support.annotation.NonNull;
import android.support.media.ExifInterface;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final String cxH;
    private long cxI;
    private long cxJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.cxH = str;
        if (DEBUG) {
            Log.d(ExifInterface.TAG_MODEL, "new model, scope id - " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bk(long j) {
        this.cxI = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bl(long j) {
        this.cxJ = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long anp() {
        return this.cxI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("scope_id", this.cxH);
            jSONObject.put("begin_ts", this.cxI);
            jSONObject.put("end_ts", this.cxJ);
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
