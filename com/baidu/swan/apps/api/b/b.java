package com.baidu.swan.apps.api.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.i;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class b implements a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Map<String, com.baidu.swan.apps.performance.a.a> cak = new ConcurrentHashMap();

    @Override // com.baidu.swan.apps.api.b.a
    public void kC(String str) {
        if (!this.cak.containsKey(str)) {
            if (DEBUG) {
                Log.d("Api-FirstRecorder", "markStart: " + str);
            }
            com.baidu.swan.apps.performance.a.a aVar = new com.baidu.swan.apps.performance.a.a();
            this.cak.put(str, aVar);
            aVar.setStart(System.currentTimeMillis());
            aVar.pI(str);
        }
    }

    @Override // com.baidu.swan.apps.api.b.a
    public void kD(String str) {
        com.baidu.swan.apps.performance.a.a aVar = this.cak.get(str);
        if (aVar == null) {
            if (DEBUG) {
                throw new RuntimeException(str + " markEnd before markStart");
            }
        } else if (aVar.getEnd() <= 0) {
            aVar.setEnd(System.currentTimeMillis());
            if (DEBUG) {
                Log.d("Api-FirstRecorder", str + " first called cost " + aVar.aiT());
            }
            if (TextUtils.equals(str, "request")) {
                if (DEBUG) {
                    Log.d("Api-FirstRecorder", "record first request api called " + aVar.toString());
                }
                i.pq("startup").f(new UbcFlowEvent("first_request_api_call_start").bs(aVar.getStart())).f(new UbcFlowEvent("first_request_api_call_end").bs(aVar.getEnd()));
            }
        }
    }
}
