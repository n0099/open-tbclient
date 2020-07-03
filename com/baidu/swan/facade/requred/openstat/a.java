package com.baidu.swan.facade.requred.openstat;

import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.ubc.e;
import com.baidu.swan.ubc.m;
import java.util.HashMap;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class a implements m {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @Override // com.baidu.swan.ubc.m
    public boolean E(JSONArray jSONArray) {
        if (DEBUG) {
            Log.d("OpenBehaviorUploader", "upload stat data -> " + jSONArray.toString());
        }
        com.baidu.swan.facade.requred.openstat.imupload.c cVar = new com.baidu.swan.facade.requred.openstat.imupload.c();
        HashMap hashMap = new HashMap(2);
        hashMap.put("cuid", e.aJn().getDeviceId(AppRuntime.getApplication()));
        hashMap.put("uuid", e.aJn().cc(AppRuntime.getApplication()));
        com.baidu.swan.facade.requred.openstat.imupload.b.awA().a(hashMap, jSONArray.toString().getBytes(), (String) null, cVar);
        if (DEBUG) {
            Log.d("OpenBehaviorUploader", "errorCode : " + cVar.errorCode);
            Log.d("OpenBehaviorUploader", "errorMsg : " + cVar.errMsg);
        }
        switch (cVar.errorCode) {
            case 1:
            case 2:
            case 4:
                com.baidu.swan.d.c.aKg();
                return false;
            case 3:
            default:
                return true;
        }
    }
}
