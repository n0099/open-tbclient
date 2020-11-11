package com.baidu.swan.apps.network.c.c;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
/* loaded from: classes10.dex */
public class c implements com.baidu.swan.apps.ap.e.b<HybridUbcFlow> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public c() {
        b.aCW().reset();
        if (DEBUG) {
            Log.d("MaUpdateReporter", "MaUpdateReporter init - " + System.currentTimeMillis());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.ap.e.b
    /* renamed from: a */
    public void M(HybridUbcFlow hybridUbcFlow) {
        if (DEBUG) {
            Log.i("MaUpdateReporter", "report: flow=" + hybridUbcFlow);
        }
        if (hybridUbcFlow != null) {
            final UbcFlowEvent qQ = hybridUbcFlow.qQ("naStart");
            final UbcFlowEvent qQ2 = hybridUbcFlow.qQ("na_first_meaningful_paint");
            if (qQ == null || qQ2 == null) {
                if (DEBUG) {
                    if (qQ == null) {
                        Log.w("MaUpdateReporter", "MaUpdateReporter: na_start = null !!!");
                    } else {
                        Log.w("MaUpdateReporter", "MaUpdateReporter: na_first_meaningful_paint = null !!!");
                    }
                }
                b.aCW().done();
                return;
            }
            b.aCW().a(new a() { // from class: com.baidu.swan.apps.network.c.c.c.1
                @Override // com.baidu.swan.apps.network.c.c.a
                public boolean a(d dVar) {
                    if (dVar != null) {
                        return c.this.a(dVar, qQ, qQ2);
                    }
                    return false;
                }
            });
            b.aCW().b(hybridUbcFlow);
            if (DEBUG) {
                Log.d("MaUpdateReporter", "na_start ts - " + qQ.aDK());
                Log.d("MaUpdateReporter", "fmp_end ts - " + qQ2.aDK());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(@NonNull d dVar, @NonNull UbcFlowEvent ubcFlowEvent, @NonNull UbcFlowEvent ubcFlowEvent2) {
        long aCY = dVar.aCY();
        return aCY >= ubcFlowEvent.aDK() && aCY <= ubcFlowEvent2.aDK();
    }
}
