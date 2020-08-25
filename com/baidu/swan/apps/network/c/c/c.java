package com.baidu.swan.apps.network.c.c;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
/* loaded from: classes8.dex */
public class c implements com.baidu.swan.apps.ap.e.b<HybridUbcFlow> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public c() {
        b.avi().reset();
        if (DEBUG) {
            Log.d("MaUpdateReporter", "MaUpdateReporter init - " + System.currentTimeMillis());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.ap.e.b
    /* renamed from: a */
    public void I(HybridUbcFlow hybridUbcFlow) {
        if (DEBUG) {
            Log.i("MaUpdateReporter", "report: flow=" + hybridUbcFlow);
        }
        if (hybridUbcFlow != null) {
            final UbcFlowEvent pd = hybridUbcFlow.pd("naStart");
            final UbcFlowEvent pd2 = hybridUbcFlow.pd("na_first_meaningful_paint");
            if (pd == null || pd2 == null) {
                if (DEBUG) {
                    if (pd == null) {
                        Log.w("MaUpdateReporter", "MaUpdateReporter: na_start = null !!!");
                    } else {
                        Log.w("MaUpdateReporter", "MaUpdateReporter: na_first_meaningful_paint = null !!!");
                    }
                }
                b.avi().done();
                return;
            }
            b.avi().a(new a() { // from class: com.baidu.swan.apps.network.c.c.c.1
                @Override // com.baidu.swan.apps.network.c.c.a
                public boolean a(d dVar) {
                    if (dVar != null) {
                        return c.this.a(dVar, pd, pd2);
                    }
                    return false;
                }
            });
            b.avi().b(hybridUbcFlow);
            if (DEBUG) {
                Log.d("MaUpdateReporter", "na_start ts - " + pd.avW());
                Log.d("MaUpdateReporter", "fmp_end ts - " + pd2.avW());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(@NonNull d dVar, @NonNull UbcFlowEvent ubcFlowEvent, @NonNull UbcFlowEvent ubcFlowEvent2) {
        long avk = dVar.avk();
        return avk >= ubcFlowEvent.avW() && avk <= ubcFlowEvent2.avW();
    }
}
