package com.baidu.swan.apps.api.d;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @NonNull
    public static Pair<com.baidu.swan.apps.api.c.b, JSONObject> aS(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = "Api-Utils";
        }
        if (TextUtils.isEmpty(str2)) {
            if (DEBUG) {
                Log.e(str, "parseJson: json str is empty");
            }
            return new Pair<>(new com.baidu.swan.apps.api.c.b(202, "parseJson: json str is empty"), new JSONObject());
        }
        try {
            return new Pair<>(new com.baidu.swan.apps.api.c.b(0), new JSONObject(str2));
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
                Log.e(str, "parseJson: with exception ", e);
            }
            return new Pair<>(new com.baidu.swan.apps.api.c.b(202, "parseJson: with exception "), new JSONObject());
        }
    }
}
