package com.baidu.swan.apps.network.c.c;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final String drr;
    private long drt;
    private long dru;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.drr = str;
        if (DEBUG) {
            Log.d(ExifInterface.TAG_MODEL, "new model, scope id - " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cC(long j) {
        this.drt = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cD(long j) {
        this.dru = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long aDz() {
        return this.drt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("scope_id", this.drr);
            jSONObject.put("begin_ts", this.drt);
            jSONObject.put("end_ts", this.dru);
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
