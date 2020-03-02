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
    public static final SubmitStrategy bHD = SubmitStrategy.HYBRID;
    private String bHq;
    public final String name;
    private final JSONObject bHr = new JSONObject();
    private final Map<String, String> bHs = new HashMap();
    public final List<String> bHt = new ArrayList();
    private final Map<String, UbcFlowEvent> bHu = new HashMap();
    public final List<UbcFlowEvent> bHv = new ArrayList();
    private boolean bHw = false;
    private boolean bHx = false;
    private boolean bHy = false;
    private boolean bHz = false;
    private boolean bHA = false;
    private boolean bHB = false;
    private volatile boolean bHC = false;
    private SubmitStrategy bHE = bHD;
    private final Map<String, List<a>> bHF = new HashMap();

    /* loaded from: classes11.dex */
    public enum SubmitStrategy {
        HYBRID { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.1
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.ZG() && hybridUbcFlow.ZI() && hybridUbcFlow.ZH() && hybridUbcFlow.ZJ();
            }
        },
        HYBRID_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.2
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.ZG() && hybridUbcFlow.ZI() && hybridUbcFlow.ZH() && hybridUbcFlow.ZK();
            }
        },
        RELAUNCH { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.3
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.ZG() && hybridUbcFlow.ZI() && hybridUbcFlow.ZJ();
            }
        },
        RELAUNCH_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.4
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.ZG() && hybridUbcFlow.ZI() && hybridUbcFlow.ZK();
            }
        },
        NA_ONLY { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.5
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.ZG();
            }
        },
        ROUTE { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.6
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.ZG() && hybridUbcFlow.ZI();
            }
        },
        ROUTE_NA { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.7
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.ZG();
            }
        },
        ROUTE_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.8
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.ZG() && hybridUbcFlow.ZI() && hybridUbcFlow.ZL();
            }
        };

        abstract boolean submitAllowed(HybridUbcFlow hybridUbcFlow);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HybridUbcFlow(String str) {
        this.name = str;
    }

    public HybridUbcFlow jS(String str) {
        this.bHq = str;
        return this;
    }

    public String Zy() {
        return this.bHq;
    }

    private void a(UbcFlowEvent ubcFlowEvent) {
        this.bHt.remove(ubcFlowEvent.id);
        this.bHt.add(ubcFlowEvent.id);
        this.bHu.put(ubcFlowEvent.id, ubcFlowEvent);
    }

    private void b(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.bHu.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.ZW() > ubcFlowEvent2.ZW()) {
            a(ubcFlowEvent);
        }
    }

    private void c(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.bHu.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.ZW() < ubcFlowEvent2.ZW()) {
            a(ubcFlowEvent);
        }
    }

    private void d(UbcFlowEvent ubcFlowEvent) {
        if (!e(this.bHu.get(ubcFlowEvent.id))) {
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
            synchronized (this.bHt) {
                switch (ubcFlowEvent.ZZ()) {
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
        synchronized (this.bHt) {
            for (UbcFlowEvent ubcFlowEvent : list) {
                f(ubcFlowEvent);
            }
        }
        return this;
    }

    public HybridUbcFlow bb(String str, String str2) {
        this.bHs.put(str, str2);
        return this;
    }

    public String jT(String str) {
        return this.bHs.get(str);
    }

    public HybridUbcFlow c(HybridUbcFlow hybridUbcFlow) {
        if (hybridUbcFlow != null) {
            hybridUbcFlow.ZM();
            Z(hybridUbcFlow.bHv);
            this.bHs.putAll(hybridUbcFlow.bHs);
        }
        return this;
    }

    public HybridUbcFlow k(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.bHr.put(str, obj);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return this;
    }

    public JSONObject Zz() {
        return this.bHr;
    }

    public HybridUbcFlow ZA() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naFlowDone");
        }
        this.bHw = true;
        ZQ();
        return this;
    }

    public HybridUbcFlow ZB() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naAnimFlowDone");
        }
        this.bHx = true;
        ZQ();
        return this;
    }

    public HybridUbcFlow ZC() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "h5FlowDone");
        }
        this.bHy = true;
        ZQ();
        return this;
    }

    public HybridUbcFlow ZD() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "webViewWidgetDone");
        }
        this.bHB = true;
        ZQ();
        return this;
    }

    public HybridUbcFlow ZE() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naPaintFlowDone");
        }
        this.bHz = true;
        ZQ();
        return this;
    }

    public HybridUbcFlow ZF() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "webwidgetPaintDone");
        }
        this.bHA = true;
        ZQ();
        return this;
    }

    public boolean ZG() {
        return this.bHw;
    }

    public boolean ZH() {
        return this.bHx;
    }

    public boolean ZI() {
        return this.bHy;
    }

    public boolean ZJ() {
        return this.bHz;
    }

    public boolean ZK() {
        return this.bHA;
    }

    public boolean ZL() {
        return this.bHB;
    }

    private boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.bHt) {
            isEmpty = this.bHt.isEmpty();
        }
        return isEmpty;
    }

    public void ZM() {
        UbcFlowEvent ubcFlowEvent;
        synchronized (this.bHt) {
            this.bHv.clear();
            for (String str : this.bHt) {
                if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.bHu.get(str)) != null && ubcFlowEvent.ZW() > 0) {
                    this.bHv.add(ubcFlowEvent);
                }
            }
            ZN();
        }
    }

    private void ZN() {
        Collections.sort(this.bHv, new Comparator<UbcFlowEvent>() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(UbcFlowEvent ubcFlowEvent, UbcFlowEvent ubcFlowEvent2) {
                return Long.compare(ubcFlowEvent.ZW(), ubcFlowEvent2.ZW());
            }
        });
    }

    public HybridUbcFlow a(SubmitStrategy submitStrategy) {
        if (submitStrategy != null) {
            this.bHE = submitStrategy;
        }
        return this;
    }

    public SubmitStrategy ZO() {
        return this.bHE;
    }

    private boolean ZP() {
        return (this.bHE == null ? bHD : this.bHE).submitAllowed(this);
    }

    private void ZQ() {
        if (ZP()) {
            ZR();
        }
    }

    private synchronized void ZR() {
        if (!this.bHC) {
            this.bHC = true;
            jU("callback_on_submit");
            m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow.this.ZS();
                }
            }, "HybridUbcFlow");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZS() {
        ZM();
        jU("component_reporter");
        if (!TextUtils.isEmpty(this.bHq)) {
            Flow rb = s.rb(this.bHq);
            for (UbcFlowEvent ubcFlowEvent : this.bHv) {
                if (!ubcFlowEvent.ZY()) {
                    rb.addEvent(ubcFlowEvent.id, ubcFlowEvent.value(), ubcFlowEvent.ZW());
                }
            }
            if (!isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, String> entry : this.bHs.entrySet()) {
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
                rb.setValueWithDuration(this.bHr.toString());
                rb.end();
            }
        }
    }

    private void jU(String str) {
        List<a> list = this.bHF.get(str);
        if (list != null && !list.isEmpty()) {
            for (a aVar : list) {
                if (aVar != null && aVar.bHI != null) {
                    aVar.bHI.D(this);
                }
            }
        }
    }

    public HybridUbcFlow c(String str, com.baidu.swan.apps.as.d.b<HybridUbcFlow> bVar) {
        a aVar = new a(str, bVar);
        if (aVar.ZT()) {
            synchronized (this.bHF) {
                List<a> list = this.bHF.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                    this.bHF.put(str, list);
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
        if (r1.ZW() < 1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
        if (r0.ZW() >= 1) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:?, code lost:
        return r1.ZW() - r0.ZW();
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
            ubcFlowEvent = this.bHu.get(strArr[i]);
            if (ubcFlowEvent2 == null) {
                if (ubcFlowEvent == null || ubcFlowEvent.ZW() < 1) {
                    break;
                }
            } else if (ubcFlowEvent != null && ubcFlowEvent.ZW() > 0) {
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
        final com.baidu.swan.apps.as.d.b<HybridUbcFlow> bHI;
        final String type;

        private a(String str, com.baidu.swan.apps.as.d.b<HybridUbcFlow> bVar) {
            this.type = str;
            this.bHI = bVar;
        }

        boolean ZT() {
            return (this.bHI == null || TextUtils.isEmpty(this.type)) ? false : true;
        }
    }
}
