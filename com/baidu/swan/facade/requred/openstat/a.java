package com.baidu.swan.facade.requred.openstat;

import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.ubc.l;
import com.baidu.swan.ubc.s;
import java.util.HashMap;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class a implements l {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @Override // com.baidu.swan.ubc.l
    public boolean D(JSONArray jSONArray) {
        if (DEBUG) {
            Log.d("OpenBehaviorUploader", "upload stat data -> " + jSONArray.toString());
        }
        com.baidu.swan.facade.requred.openstat.imupload.c cVar = new com.baidu.swan.facade.requred.openstat.imupload.c();
        HashMap hashMap = new HashMap(2);
        hashMap.put("cuid", s.atk().getDeviceId(AppRuntime.getApplication()));
        hashMap.put("uuid", s.atk().cl(AppRuntime.getApplication()));
        com.baidu.swan.facade.requred.openstat.imupload.b.agS().a(hashMap, jSONArray.toString().getBytes(), (String) null, cVar);
        if (DEBUG) {
            Log.d("OpenBehaviorUploader", "errorCode : " + cVar.errorCode);
            Log.d("OpenBehaviorUploader", "errorMsg : " + cVar.errMsg);
        }
        switch (cVar.errorCode) {
            case 1:
            case 2:
            case 4:
                com.baidu.swan.c.c.atv();
                return false;
            case 3:
            default:
                return true;
        }
    }
}
