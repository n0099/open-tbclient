package com.baidu.swan.games.network;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    public static boolean U(String str, int i) throws JSONException {
        return 200 == i && !TextUtils.isEmpty(str) && new JSONObject(str).optInt("errorno") == 0;
    }
}
