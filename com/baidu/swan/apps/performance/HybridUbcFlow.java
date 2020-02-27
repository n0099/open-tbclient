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
    public static final SubmitStrategy bHC = SubmitStrategy.HYBRID;
    private String bHp;
    public final String name;
    private final JSONObject bHq = new JSONObject();
    private final Map<String, String> bHr = new HashMap();
    public final List<String> bHs = new ArrayList();
    private final Map<String, UbcFlowEvent> bHt = new HashMap();
    public final List<UbcFlowEvent> bHu = new ArrayList();
    private boolean bHv = false;
    private boolean bHw = false;
    private boolean bHx = false;
    private boolean bHy = false;
    private boolean bHz = false;
    private boolean bHA = false;
    private volatile boolean bHB = false;
    private SubmitStrategy bHD = bHC;
    private final Map<String, List<a>> bHE = new HashMap();

    /* loaded from: classes11.dex */
    public enum SubmitStrategy {
        HYBRID { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.1
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.ZE() && hybridUbcFlow.ZG() && hybridUbcFlow.ZF() && hybridUbcFlow.ZH();
            }
        },
        HYBRID_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.2
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.ZE() && hybridUbcFlow.ZG() && hybridUbcFlow.ZF() && hybridUbcFlow.ZI();
            }
        },
        RELAUNCH { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.3
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.ZE() && hybridUbcFlow.ZG() && hybridUbcFlow.ZH();
            }
        },
        RELAUNCH_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.4
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.ZE() && hybridUbcFlow.ZG() && hybridUbcFlow.ZI();
            }
        },
        NA_ONLY { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.5
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.ZE();
            }
        },
        ROUTE { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.6
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.ZE() && hybridUbcFlow.ZG();
            }
        },
        ROUTE_NA { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.7
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.ZE();
            }
        },
        ROUTE_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.8
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.ZE() && hybridUbcFlow.ZG() && hybridUbcFlow.ZJ();
            }
        };

        abstract boolean submitAllowed(HybridUbcFlow hybridUbcFlow);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HybridUbcFlow(String str) {
        this.name = str;
    }

    public HybridUbcFlow jS(String str) {
        this.bHp = str;
        return this;
    }

    public String Zw() {
        return this.bHp;
    }

    private void a(UbcFlowEvent ubcFlowEvent) {
        this.bHs.remove(ubcFlowEvent.id);
        this.bHs.add(ubcFlowEvent.id);
        this.bHt.put(ubcFlowEvent.id, ubcFlowEvent);
    }

    private void b(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.bHt.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.ZU() > ubcFlowEvent2.ZU()) {
            a(ubcFlowEvent);
        }
    }

    private void c(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.bHt.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.ZU() < ubcFlowEvent2.ZU()) {
            a(ubcFlowEvent);
        }
    }

    private void d(UbcFlowEvent ubcFlowEvent) {
        if (!e(this.bHt.get(ubcFlowEvent.id))) {
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
            synchronized (this.bHs) {
                switch (ubcFlowEvent.ZX()) {
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
        synchronized (this.bHs) {
            for (UbcFlowEvent ubcFlowEvent : list) {
                f(ubcFlowEvent);
            }
        }
        return this;
    }

    public HybridUbcFlow bb(String str, String str2) {
        this.bHr.put(str, str2);
        return this;
    }

    public String jT(String str) {
        return this.bHr.get(str);
    }

    public HybridUbcFlow c(HybridUbcFlow hybridUbcFlow) {
        if (hybridUbcFlow != null) {
            hybridUbcFlow.ZK();
            Z(hybridUbcFlow.bHu);
            this.bHr.putAll(hybridUbcFlow.bHr);
        }
        return this;
    }

    public HybridUbcFlow k(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.bHq.put(str, obj);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return this;
    }

    public JSONObject Zx() {
        return this.bHq;
    }

    public HybridUbcFlow Zy() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naFlowDone");
        }
        this.bHv = true;
        ZO();
        return this;
    }

    public HybridUbcFlow Zz() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naAnimFlowDone");
        }
        this.bHw = true;
        ZO();
        return this;
    }

    public HybridUbcFlow ZA() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "h5FlowDone");
        }
        this.bHx = true;
        ZO();
        return this;
    }

    public HybridUbcFlow ZB() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "webViewWidgetDone");
        }
        this.bHA = true;
        ZO();
        return this;
    }

    public HybridUbcFlow ZC() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naPaintFlowDone");
        }
        this.bHy = true;
        ZO();
        return this;
    }

    public HybridUbcFlow ZD() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "webwidgetPaintDone");
        }
        this.bHz = true;
        ZO();
        return this;
    }

    public boolean ZE() {
        return this.bHv;
    }

    public boolean ZF() {
        return this.bHw;
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

    private boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.bHs) {
            isEmpty = this.bHs.isEmpty();
        }
        return isEmpty;
    }

    public void ZK() {
        UbcFlowEvent ubcFlowEvent;
        synchronized (this.bHs) {
            this.bHu.clear();
            for (String str : this.bHs) {
                if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.bHt.get(str)) != null && ubcFlowEvent.ZU() > 0) {
                    this.bHu.add(ubcFlowEvent);
                }
            }
            ZL();
        }
    }

    private void ZL() {
        Collections.sort(this.bHu, new Comparator<UbcFlowEvent>() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(UbcFlowEvent ubcFlowEvent, UbcFlowEvent ubcFlowEvent2) {
                return Long.compare(ubcFlowEvent.ZU(), ubcFlowEvent2.ZU());
            }
        });
    }

    public HybridUbcFlow a(SubmitStrategy submitStrategy) {
        if (submitStrategy != null) {
            this.bHD = submitStrategy;
        }
        return this;
    }

    public SubmitStrategy ZM() {
        return this.bHD;
    }

    private boolean ZN() {
        return (this.bHD == null ? bHC : this.bHD).submitAllowed(this);
    }

    private void ZO() {
        if (ZN()) {
            ZP();
        }
    }

    private synchronized void ZP() {
        if (!this.bHB) {
            this.bHB = true;
            jU("callback_on_submit");
            m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow.this.ZQ();
                }
            }, "HybridUbcFlow");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZQ() {
        ZK();
        jU("component_reporter");
        if (!TextUtils.isEmpty(this.bHp)) {
            Flow rb = s.rb(this.bHp);
            for (UbcFlowEvent ubcFlowEvent : this.bHu) {
                if (!ubcFlowEvent.ZW()) {
                    rb.addEvent(ubcFlowEvent.id, ubcFlowEvent.value(), ubcFlowEvent.ZU());
                }
            }
            if (!isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, String> entry : this.bHr.entrySet()) {
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
                rb.setValueWithDuration(this.bHq.toString());
                rb.end();
            }
        }
    }

    private void jU(String str) {
        List<a> list = this.bHE.get(str);
        if (list != null && !list.isEmpty()) {
            for (a aVar : list) {
                if (aVar != null && aVar.bHH != null) {
                    aVar.bHH.D(this);
                }
            }
        }
    }

    public HybridUbcFlow c(String str, com.baidu.swan.apps.as.d.b<HybridUbcFlow> bVar) {
        a aVar = new a(str, bVar);
        if (aVar.ZR()) {
            synchronized (this.bHE) {
                List<a> list = this.bHE.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                    this.bHE.put(str, list);
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
        if (r1.ZU() < 1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
        if (r0.ZU() >= 1) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:?, code lost:
        return r1.ZU() - r0.ZU();
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
            ubcFlowEvent = this.bHt.get(strArr[i]);
            if (ubcFlowEvent2 == null) {
                if (ubcFlowEvent == null || ubcFlowEvent.ZU() < 1) {
                    break;
                }
            } else if (ubcFlowEvent != null && ubcFlowEvent.ZU() > 0) {
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
        final com.baidu.swan.apps.as.d.b<HybridUbcFlow> bHH;
        final String type;

        private a(String str, com.baidu.swan.apps.as.d.b<HybridUbcFlow> bVar) {
            this.type = str;
            this.bHH = bVar;
        }

        boolean ZR() {
            return (this.bHH == null || TextUtils.isEmpty(this.type)) ? false : true;
        }
    }
}
