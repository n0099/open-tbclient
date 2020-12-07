package com.baidu.swan.apps.network.c.c;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
/* loaded from: classes25.dex */
public class c implements com.baidu.swan.apps.ap.e.b<HybridUbcFlow> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public c() {
        b.aFx().reset();
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
            final UbcFlowEvent rr = hybridUbcFlow.rr("naStart");
            final UbcFlowEvent rr2 = hybridUbcFlow.rr("na_first_meaningful_paint");
            if (rr == null || rr2 == null) {
                if (DEBUG) {
                    if (rr == null) {
                        Log.w("MaUpdateReporter", "MaUpdateReporter: na_start = null !!!");
                    } else {
                        Log.w("MaUpdateReporter", "MaUpdateReporter: na_first_meaningful_paint = null !!!");
                    }
                }
                b.aFx().done();
                return;
            }
            b.aFx().a(new a() { // from class: com.baidu.swan.apps.network.c.c.c.1
                @Override // com.baidu.swan.apps.network.c.c.a
                public boolean a(d dVar) {
                    if (dVar != null) {
                        return c.this.a(dVar, rr, rr2);
                    }
                    return false;
                }
            });
            b.aFx().b(hybridUbcFlow);
            if (DEBUG) {
                Log.d("MaUpdateReporter", "na_start ts - " + rr.aGk());
                Log.d("MaUpdateReporter", "fmp_end ts - " + rr2.aGk());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(@NonNull d dVar, @NonNull UbcFlowEvent ubcFlowEvent, @NonNull UbcFlowEvent ubcFlowEvent2) {
        long aFz = dVar.aFz();
        return aFz >= ubcFlowEvent.aGk() && aFz <= ubcFlowEvent2.aGk();
    }
}
