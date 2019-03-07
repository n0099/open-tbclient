package com.baidu.swan.ubc;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes2.dex */
public class s {
    public static void jT(String str) {
    }

    public static void d(u uVar) {
        if (uVar != null && !uVar.isEmpty()) {
            JSONArray TB = uVar.TB();
            int length = TB.length();
            boolean TC = uVar.TC();
            for (int i = 0; i < length; i++) {
                try {
                    if (TC != d.SW().jH(TB.getJSONObject(i).getString("bizId"))) {
                        Log.w("UBCDebug", " data is " + TC + "  content " + uVar.Tx().toString());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
