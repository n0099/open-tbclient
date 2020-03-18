package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.ubc.Flow;
import com.baidu.swan.ubc.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class HybridUbcFlow {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final SubmitStrategy bHP = SubmitStrategy.HYBRID;
    private String bHC;
    private final JSONObject bHD = new JSONObject();
    private final Map<String, String> bHE = new HashMap();
    public final List<String> bHF = new ArrayList();
    private final Map<String, UbcFlowEvent> bHG = new HashMap();
    public final List<UbcFlowEvent> bHH = new ArrayList();
    private boolean bHI = false;
    private boolean bHJ = false;
    private boolean bHK = false;
    private boolean bHL = false;
    private boolean bHM = false;
    private boolean bHN = false;
    private volatile boolean bHO = false;
    private SubmitStrategy bHQ = bHP;
    private final Map<String, List<a>> bHR = new HashMap();
    public final String name;

    /* loaded from: classes11.dex */
    public enum SubmitStrategy {
        HYBRID { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.1
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.ZJ() && hybridUbcFlow.ZL() && hybridUbcFlow.ZK() && hybridUbcFlow.ZM();
            }
        },
        HYBRID_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.2
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.ZJ() && hybridUbcFlow.ZL() && hybridUbcFlow.ZK() && hybridUbcFlow.ZN();
            }
        },
        RELAUNCH { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.3
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.ZJ() && hybridUbcFlow.ZL() && hybridUbcFlow.ZM();
            }
        },
        RELAUNCH_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.4
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.ZJ() && hybridUbcFlow.ZL() && hybridUbcFlow.ZN();
            }
        },
        NA_ONLY { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.5
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.ZJ();
            }
        },
        ROUTE { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.6
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.ZJ() && hybridUbcFlow.ZL();
            }
        },
        ROUTE_NA { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.7
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.ZJ();
            }
        },
        ROUTE_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.8
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.ZJ() && hybridUbcFlow.ZL() && hybridUbcFlow.ZO();
            }
        };

        abstract boolean submitAllowed(HybridUbcFlow hybridUbcFlow);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HybridUbcFlow(String str) {
        this.name = str;
    }

    public HybridUbcFlow jR(String str) {
        this.bHC = str;
        return this;
    }

    public String ZB() {
        return this.bHC;
    }

    private void a(UbcFlowEvent ubcFlowEvent) {
        this.bHF.remove(ubcFlowEvent.id);
        this.bHF.add(ubcFlowEvent.id);
        this.bHG.put(ubcFlowEvent.id, ubcFlowEvent);
    }

    private void b(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.bHG.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.ZZ() > ubcFlowEvent2.ZZ()) {
            a(ubcFlowEvent);
        }
    }

    private void c(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.bHG.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.ZZ() < ubcFlowEvent2.ZZ()) {
            a(ubcFlowEvent);
        }
    }

    private void d(UbcFlowEvent ubcFlowEvent) {
        if (!e(this.bHG.get(ubcFlowEvent.id))) {
            a(ubcFlowEvent);
        }
    }

    private boolean e(UbcFlowEvent ubcFlowEvent) {
        return (ubcFlowEvent == null || TextUtils.isEmpty(ubcFlowEvent.id)) ? false : true;
    }

    public HybridUbcFlow f(UbcFlowEvent ubcFlowEvent) {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "record " + ubcFlowEvent);
        }
        if (e(ubcFlowEvent)) {
            synchronized (this.bHF) {
                switch (ubcFlowEvent.aac()) {
                    case UPDATE:
                        a(ubcFlowEvent);
                        break;
                    case UPDATE_RECENT:
                        b(ubcFlowEvent);
                        break;
                    case UPDATE_EARLIER:
                        c(ubcFlowEvent);
                        break;
                    default:
                        d(ubcFlowEvent);
                        break;
                }
            }
        }
        return this;
    }

    public HybridUbcFlow Z(List<UbcFlowEvent> list) {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "record events size = " + list.size());
        }
        synchronized (this.bHF) {
            for (UbcFlowEvent ubcFlowEvent : list) {
                f(ubcFlowEvent);
            }
        }
        return this;
    }

    public HybridUbcFlow ba(String str, String str2) {
        this.bHE.put(str, str2);
        return this;
    }

    public String jS(String str) {
        return this.bHE.get(str);
    }

    public HybridUbcFlow c(HybridUbcFlow hybridUbcFlow) {
        if (hybridUbcFlow != null) {
            hybridUbcFlow.ZP();
            Z(hybridUbcFlow.bHH);
            this.bHE.putAll(hybridUbcFlow.bHE);
        }
        return this;
    }

    public HybridUbcFlow k(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.bHD.put(str, obj);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return this;
    }

    public JSONObject ZC() {
        return this.bHD;
    }

    public HybridUbcFlow ZD() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naFlowDone");
        }
        this.bHI = true;
        ZT();
        return this;
    }

    public HybridUbcFlow ZE() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naAnimFlowDone");
        }
        this.bHJ = true;
        ZT();
        return this;
    }

    public HybridUbcFlow ZF() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "h5FlowDone");
        }
        this.bHK = true;
        ZT();
        return this;
    }

    public HybridUbcFlow ZG() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "webViewWidgetDone");
        }
        this.bHN = true;
        ZT();
        return this;
    }

    public HybridUbcFlow ZH() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naPaintFlowDone");
        }
        this.bHL = true;
        ZT();
        return this;
    }

    public HybridUbcFlow ZI() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "webwidgetPaintDone");
        }
        this.bHM = true;
        ZT();
        return this;
    }

    public boolean ZJ() {
        return this.bHI;
    }

    public boolean ZK() {
        return this.bHJ;
    }

    public boolean ZL() {
        return this.bHK;
    }

    public boolean ZM() {
        return this.bHL;
    }

    public boolean ZN() {
        return this.bHM;
    }

    public boolean ZO() {
        return this.bHN;
    }

    private boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.bHF) {
            isEmpty = this.bHF.isEmpty();
        }
        return isEmpty;
    }

    public void ZP() {
        UbcFlowEvent ubcFlowEvent;
        synchronized (this.bHF) {
            this.bHH.clear();
            for (String str : this.bHF) {
                if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.bHG.get(str)) != null && ubcFlowEvent.ZZ() > 0) {
                    this.bHH.add(ubcFlowEvent);
                }
            }
            ZQ();
        }
    }

    private void ZQ() {
        Collections.sort(this.bHH, new Comparator<UbcFlowEvent>() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(UbcFlowEvent ubcFlowEvent, UbcFlowEvent ubcFlowEvent2) {
                return Long.compare(ubcFlowEvent.ZZ(), ubcFlowEvent2.ZZ());
            }
        });
    }

    public HybridUbcFlow a(SubmitStrategy submitStrategy) {
        if (submitStrategy != null) {
            this.bHQ = submitStrategy;
        }
        return this;
    }

    public SubmitStrategy ZR() {
        return this.bHQ;
    }

    private boolean ZS() {
        return (this.bHQ == null ? bHP : this.bHQ).submitAllowed(this);
    }

    private void ZT() {
        if (ZS()) {
            ZU();
        }
    }

    private synchronized void ZU() {
        if (!this.bHO) {
            this.bHO = true;
            jT("callback_on_submit");
            m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow.this.ZV();
                }
            }, "HybridUbcFlow");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZV() {
        ZP();
        jT("component_reporter");
        if (!TextUtils.isEmpty(this.bHC)) {
            Flow ra = s.ra(this.bHC);
            for (UbcFlowEvent ubcFlowEvent : this.bHH) {
                if (!ubcFlowEvent.aab()) {
                    ra.addEvent(ubcFlowEvent.id, ubcFlowEvent.value(), ubcFlowEvent.ZZ());
                }
            }
            if (!isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, String> entry : this.bHE.entrySet()) {
                        String key = entry.getKey();
                        if (!TextUtils.isEmpty(key)) {
                            String value = entry.getValue();
                            if (value == null) {
                                value = "";
                            }
                            jSONObject.put(key, value);
                        }
                    }
                    k("ext", jSONObject);
                } catch (Exception e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
                ra.setValueWithDuration(this.bHD.toString());
                ra.end();
            }
        }
    }

    private void jT(String str) {
        List<a> list = this.bHR.get(str);
        if (list != null && !list.isEmpty()) {
            for (a aVar : list) {
                if (aVar != null && aVar.bHU != null) {
                    aVar.bHU.D(this);
                }
            }
        }
    }

    public HybridUbcFlow c(String str, com.baidu.swan.apps.as.d.b<HybridUbcFlow> bVar) {
        a aVar = new a(str, bVar);
        if (aVar.ZW()) {
            synchronized (this.bHR) {
                List<a> list = this.bHR.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                    this.bHR.put(str, list);
                }
                list.add(aVar);
            }
        }
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002f, code lost:
        if (r1 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
        if (r0 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0039, code lost:
        if (r1.ZZ() < 1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
        if (r0.ZZ() >= 1) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:?, code lost:
        return r1.ZZ() - r0.ZZ();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long s(String... strArr) {
        UbcFlowEvent ubcFlowEvent;
        int length = strArr.length;
        int i = 0;
        UbcFlowEvent ubcFlowEvent2 = null;
        while (true) {
            if (i >= length) {
                ubcFlowEvent = null;
                break;
            }
            ubcFlowEvent = this.bHG.get(strArr[i]);
            if (ubcFlowEvent2 == null) {
                if (ubcFlowEvent == null || ubcFlowEvent.ZZ() < 1) {
                    break;
                }
            } else if (ubcFlowEvent != null && ubcFlowEvent.ZZ() > 0) {
                break;
            } else {
                ubcFlowEvent = ubcFlowEvent2;
            }
            i++;
            ubcFlowEvent2 = ubcFlowEvent;
        }
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a {
        final com.baidu.swan.apps.as.d.b<HybridUbcFlow> bHU;
        final String type;

        private a(String str, com.baidu.swan.apps.as.d.b<HybridUbcFlow> bVar) {
            this.type = str;
            this.bHU = bVar;
        }

        boolean ZW() {
            return (this.bHU == null || TextUtils.isEmpty(this.type)) ? false : true;
        }
    }
}
