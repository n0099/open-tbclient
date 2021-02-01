package com.baidu.swan.games.network;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c {
    public static boolean af(String str, int i) throws JSONException {
        return 200 == i && !TextUtils.isEmpty(str) && new JSONObject(str).optInt("errorno") == 0;
    }
}
