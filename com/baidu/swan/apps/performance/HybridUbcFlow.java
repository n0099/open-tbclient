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
    public static final SubmitStrategy bHE = SubmitStrategy.HYBRID;
    private String bHr;
    public final String name;
    private final JSONObject bHs = new JSONObject();
    private final Map<String, String> bHt = new HashMap();
    public final List<String> bHu = new ArrayList();
    private final Map<String, UbcFlowEvent> bHv = new HashMap();
    public final List<UbcFlowEvent> bHw = new ArrayList();
    private boolean bHx = false;
    private boolean bHy = false;
    private boolean bHz = false;
    private boolean bHA = false;
    private boolean bHB = false;
    private boolean bHC = false;
    private volatile boolean bHD = false;
    private SubmitStrategy bHF = bHE;
    private final Map<String, List<a>> bHG = new HashMap();

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
        this.bHr = str;
        return this;
    }

    public String Zy() {
        return this.bHr;
    }

    private void a(UbcFlowEvent ubcFlowEvent) {
        this.bHu.remove(ubcFlowEvent.id);
        this.bHu.add(ubcFlowEvent.id);
        this.bHv.put(ubcFlowEvent.id, ubcFlowEvent);
    }

    private void b(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.bHv.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.ZW() > ubcFlowEvent2.ZW()) {
            a(ubcFlowEvent);
        }
    }

    private void c(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.bHv.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.ZW() < ubcFlowEvent2.ZW()) {
            a(ubcFlowEvent);
        }
    }

    private void d(UbcFlowEvent ubcFlowEvent) {
        if (!e(this.bHv.get(ubcFlowEvent.id))) {
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
            synchronized (this.bHu) {
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
        synchronized (this.bHu) {
            for (UbcFlowEvent ubcFlowEvent : list) {
                f(ubcFlowEvent);
            }
        }
        return this;
    }

    public HybridUbcFlow bb(String str, String str2) {
        this.bHt.put(str, str2);
        return this;
    }

    public String jT(String str) {
        return this.bHt.get(str);
    }

    public HybridUbcFlow c(HybridUbcFlow hybridUbcFlow) {
        if (hybridUbcFlow != null) {
            hybridUbcFlow.ZM();
            Z(hybridUbcFlow.bHw);
            this.bHt.putAll(hybridUbcFlow.bHt);
        }
        return this;
    }

    public HybridUbcFlow k(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.bHs.put(str, obj);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return this;
    }

    public JSONObject Zz() {
        return this.bHs;
    }

    public HybridUbcFlow ZA() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naFlowDone");
        }
        this.bHx = true;
        ZQ();
        return this;
    }

    public HybridUbcFlow ZB() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naAnimFlowDone");
        }
        this.bHy = true;
        ZQ();
        return this;
    }

    public HybridUbcFlow ZC() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "h5FlowDone");
        }
        this.bHz = true;
        ZQ();
        return this;
    }

    public HybridUbcFlow ZD() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "webViewWidgetDone");
        }
        this.bHC = true;
        ZQ();
        return this;
    }

    public HybridUbcFlow ZE() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naPaintFlowDone");
        }
        this.bHA = true;
        ZQ();
        return this;
    }

    public HybridUbcFlow ZF() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "webwidgetPaintDone");
        }
        this.bHB = true;
        ZQ();
        return this;
    }

    public boolean ZG() {
        return this.bHx;
    }

    public boolean ZH() {
        return this.bHy;
    }

    public boolean ZI() {
        return this.bHz;
    }

    public boolean ZJ() {
        return this.bHA;
    }

    public boolean ZK() {
        return this.bHB;
    }

    public boolean ZL() {
        return this.bHC;
    }

    private boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.bHu) {
            isEmpty = this.bHu.isEmpty();
        }
        return isEmpty;
    }

    public void ZM() {
        UbcFlowEvent ubcFlowEvent;
        synchronized (this.bHu) {
            this.bHw.clear();
            for (String str : this.bHu) {
                if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.bHv.get(str)) != null && ubcFlowEvent.ZW() > 0) {
                    this.bHw.add(ubcFlowEvent);
                }
            }
            ZN();
        }
    }

    private void ZN() {
        Collections.sort(this.bHw, new Comparator<UbcFlowEvent>() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.1
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
            this.bHF = submitStrategy;
        }
        return this;
    }

    public SubmitStrategy ZO() {
        return this.bHF;
    }

    private boolean ZP() {
        return (this.bHF == null ? bHE : this.bHF).submitAllowed(this);
    }

    private void ZQ() {
        if (ZP()) {
            ZR();
        }
    }

    private synchronized void ZR() {
        if (!this.bHD) {
            this.bHD = true;
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
        if (!TextUtils.isEmpty(this.bHr)) {
            Flow rb = s.rb(this.bHr);
            for (UbcFlowEvent ubcFlowEvent : this.bHw) {
                if (!ubcFlowEvent.ZY()) {
                    rb.addEvent(ubcFlowEvent.id, ubcFlowEvent.value(), ubcFlowEvent.ZW());
                }
            }
            if (!isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, String> entry : this.bHt.entrySet()) {
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
                rb.setValueWithDuration(this.bHs.toString());
                rb.end();
            }
        }
    }

    private void jU(String str) {
        List<a> list = this.bHG.get(str);
        if (list != null && !list.isEmpty()) {
            for (a aVar : list) {
                if (aVar != null && aVar.bHJ != null) {
                    aVar.bHJ.D(this);
                }
            }
        }
    }

    public HybridUbcFlow c(String str, com.baidu.swan.apps.as.d.b<HybridUbcFlow> bVar) {
        a aVar = new a(str, bVar);
        if (aVar.ZT()) {
            synchronized (this.bHG) {
                List<a> list = this.bHG.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                    this.bHG.put(str, list);
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
            ubcFlowEvent = this.bHv.get(strArr[i]);
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
        final com.baidu.swan.apps.as.d.b<HybridUbcFlow> bHJ;
        final String type;

        private a(String str, com.baidu.swan.apps.as.d.b<HybridUbcFlow> bVar) {
            this.type = str;
            this.bHJ = bVar;
        }

        boolean ZT() {
            return (this.bHJ == null || TextUtils.isEmpty(this.type)) ? false : true;
        }
    }
}
