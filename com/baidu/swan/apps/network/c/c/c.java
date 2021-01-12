package com.baidu.swan.apps.network.c.c;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
/* loaded from: classes8.dex */
public class c implements com.baidu.swan.apps.ao.e.b<HybridUbcFlow> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public c() {
        b.aCY().reset();
        if (DEBUG) {
            Log.d("MaUpdateReporter", "MaUpdateReporter init - " + System.currentTimeMillis());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.ao.e.b
    /* renamed from: a */
    public void L(HybridUbcFlow hybridUbcFlow) {
        if (DEBUG) {
            Log.i("MaUpdateReporter", "report: flow=" + hybridUbcFlow);
        }
        if (hybridUbcFlow != null) {
            final UbcFlowEvent pZ = hybridUbcFlow.pZ("naStart");
            final UbcFlowEvent pZ2 = hybridUbcFlow.pZ("na_first_meaningful_paint");
            if (pZ == null || pZ2 == null) {
                if (DEBUG) {
                    if (pZ == null) {
                        Log.w("MaUpdateReporter", "MaUpdateReporter: na_start = null !!!");
                    } else {
                        Log.w("MaUpdateReporter", "MaUpdateReporter: na_first_meaningful_paint = null !!!");
                    }
                }
                b.aCY().done();
                return;
            }
            b.aCY().a(new a() { // from class: com.baidu.swan.apps.network.c.c.c.1
                @Override // com.baidu.swan.apps.network.c.c.a
                public boolean a(d dVar) {
                    if (dVar != null) {
                        return c.this.a(dVar, pZ, pZ2);
                    }
                    return false;
                }
            });
            b.aCY().b(hybridUbcFlow);
            if (DEBUG) {
                Log.d("MaUpdateReporter", "na_start ts - " + pZ.aDK());
                Log.d("MaUpdateReporter", "fmp_end ts - " + pZ2.aDK());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(@NonNull d dVar, @NonNull UbcFlowEvent ubcFlowEvent, @NonNull UbcFlowEvent ubcFlowEvent2) {
        long aDa = dVar.aDa();
        return aDa >= ubcFlowEvent.aDK() && aDa <= ubcFlowEvent2.aDK();
    }
}
