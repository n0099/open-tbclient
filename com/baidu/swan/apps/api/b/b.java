package com.baidu.swan.apps.api.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.i;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes10.dex */
public class b implements a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Map<String, com.baidu.swan.apps.performance.a.a> cAX = new ConcurrentHashMap();

    @Override // com.baidu.swan.apps.api.b.a
    public void lW(String str) {
        if (!this.cAX.containsKey(str)) {
            if (DEBUG) {
                Log.d("Api-FirstRecorder", "markStart: " + str);
            }
            com.baidu.swan.apps.performance.a.a aVar = new com.baidu.swan.apps.performance.a.a();
            this.cAX.put(str, aVar);
            aVar.setStart(System.currentTimeMillis());
            aVar.rb(str);
        }
    }

    @Override // com.baidu.swan.apps.api.b.a
    public void lX(String str) {
        com.baidu.swan.apps.performance.a.a aVar = this.cAX.get(str);
        if (aVar == null) {
            if (DEBUG) {
                throw new RuntimeException(str + " markEnd before markStart");
            }
        } else if (aVar.getEnd() <= 0) {
            aVar.setEnd(System.currentTimeMillis());
            if (DEBUG) {
                Log.d("Api-FirstRecorder", str + " first called cost " + aVar.apZ());
            }
            if (TextUtils.equals(str, "request")) {
                if (DEBUG) {
                    Log.d("Api-FirstRecorder", "record first request api called " + aVar.toString());
                }
                i.qJ("startup").f(new UbcFlowEvent("first_request_api_call_start").bY(aVar.getStart())).f(new UbcFlowEvent("first_request_api_call_end").bY(aVar.getEnd()));
            }
        }
    }
}
