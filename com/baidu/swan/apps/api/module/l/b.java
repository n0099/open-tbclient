package com.baidu.swan.apps.api.module.l;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.ao.ak;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b extends com.baidu.swan.apps.api.a.d {
    public b(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b mn(String str) {
        if (DEBUG) {
            Log.d("Api-HandleException", "params = " + str);
        }
        if (anl()) {
            com.baidu.swan.apps.console.c.e("Api-HandleException", "Api-HandleException does not supported when app is invisible.");
            return new com.baidu.swan.apps.api.c.b(1001, "Api-HandleException does not supported when app is invisible.");
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bo = com.baidu.swan.apps.api.d.b.bo("Api-HandleException", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bo.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-HandleException", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) bo.second;
        String optString = jSONObject.optString("code");
        if (TextUtils.isEmpty(optString)) {
            return new com.baidu.swan.apps.api.c.b(202, "code is required");
        }
        if (DEBUG) {
            Log.d("Api-HandleException", "code: " + optString + "msg: " + jSONObject.optString("msg"));
        }
        char c = 65535;
        switch (optString.hashCode()) {
            case 48:
                if (optString.equals("0")) {
                    c = 0;
                    break;
                }
                break;
            case 49:
                if (optString.equals("1")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return aZ(jSONObject);
            case 1:
                return aY(jSONObject);
            default:
                return new com.baidu.swan.apps.api.c.b(202, "unsupported code");
        }
    }

    private com.baidu.swan.apps.api.c.b aY(JSONObject jSONObject) {
        com.baidu.swan.apps.core.f.bu("data_init", "业务数据初始化异常");
        return new com.baidu.swan.apps.api.c.b(0);
    }

    private com.baidu.swan.apps.api.c.b aZ(JSONObject jSONObject) {
        String optString = jSONObject.optString("data");
        if (TextUtils.isEmpty(optString)) {
            return new com.baidu.swan.apps.api.c.b(202, "data is required");
        }
        try {
            String optString2 = new JSONObject(optString).optString("path");
            if (TextUtils.isEmpty(optString2)) {
                return new com.baidu.swan.apps.api.c.b(202, "path is required");
            }
            if (ak.uY(optString2) && ak.aRK()) {
                com.baidu.swan.apps.core.f.bu("skeleton", "5秒内未触发骨架屏移除");
            } else if (DEBUG) {
                Log.d("Api-HandleException", "path is not first page: " + optString2);
            }
            return new com.baidu.swan.apps.api.c.b(0);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return new com.baidu.swan.apps.api.c.b(202, "invalid json data: " + optString);
        }
    }
}
