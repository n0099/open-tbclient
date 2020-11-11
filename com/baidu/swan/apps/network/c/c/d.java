package com.baidu.swan.apps.network.c.c;

import android.support.annotation.NonNull;
import android.support.media.ExifInterface;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final String dib;
    private long dic;
    private long die;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.dib = str;
        if (DEBUG) {
            Log.d(ExifInterface.TAG_MODEL, "new model, scope id - " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bW(long j) {
        this.dic = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bX(long j) {
        this.die = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long aCY() {
        return this.dic;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("scope_id", this.dib);
            jSONObject.put("begin_ts", this.dic);
            jSONObject.put("end_ts", this.die);
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
