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
/* loaded from: classes9.dex */
public final class HybridUbcFlow {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final SubmitStrategy bCL = SubmitStrategy.HYBRID;
    private String bCy;
    public final String name;
    private final JSONObject bCz = new JSONObject();
    private final Map<String, String> bCA = new HashMap();
    public final List<String> bCB = new ArrayList();
    private final Map<String, UbcFlowEvent> bCC = new HashMap();
    public final List<UbcFlowEvent> bCD = new ArrayList();
    private boolean bCE = false;
    private boolean bCF = false;
    private boolean bCG = false;
    private boolean bCH = false;
    private boolean bCI = false;
    private boolean bCJ = false;
    private volatile boolean bCK = false;
    private SubmitStrategy bCM = bCL;
    private final Map<String, List<a>> bCN = new HashMap();

    /* loaded from: classes9.dex */
    public enum SubmitStrategy {
        HYBRID { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.1
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.WT() && hybridUbcFlow.WV() && hybridUbcFlow.WU() && hybridUbcFlow.WW();
            }
        },
        HYBRID_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.2
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.WT() && hybridUbcFlow.WV() && hybridUbcFlow.WU() && hybridUbcFlow.WX();
            }
        },
        RELAUNCH { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.3
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.WT() && hybridUbcFlow.WV() && hybridUbcFlow.WW();
            }
        },
        RELAUNCH_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.4
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.WT() && hybridUbcFlow.WV() && hybridUbcFlow.WX();
            }
        },
        NA_ONLY { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.5
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.WT();
            }
        },
        ROUTE { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.6
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.WT() && hybridUbcFlow.WV();
            }
        },
        ROUTE_NA { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.7
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.WT();
            }
        },
        ROUTE_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.8
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.WT() && hybridUbcFlow.WV() && hybridUbcFlow.WY();
            }
        };

        abstract boolean submitAllowed(HybridUbcFlow hybridUbcFlow);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HybridUbcFlow(String str) {
        this.name = str;
    }

    public HybridUbcFlow jA(String str) {
        this.bCy = str;
        return this;
    }

    public String WL() {
        return this.bCy;
    }

    private void a(UbcFlowEvent ubcFlowEvent) {
        this.bCB.remove(ubcFlowEvent.id);
        this.bCB.add(ubcFlowEvent.id);
        this.bCC.put(ubcFlowEvent.id, ubcFlowEvent);
    }

    private void b(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.bCC.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.Xj() > ubcFlowEvent2.Xj()) {
            a(ubcFlowEvent);
        }
    }

    private void c(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.bCC.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.Xj() < ubcFlowEvent2.Xj()) {
            a(ubcFlowEvent);
        }
    }

    private void d(UbcFlowEvent ubcFlowEvent) {
        if (!e(this.bCC.get(ubcFlowEvent.id))) {
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
            synchronized (this.bCB) {
                switch (ubcFlowEvent.Xm()) {
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

    public HybridUbcFlow aa(List<UbcFlowEvent> list) {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "record events size = " + list.size());
        }
        synchronized (this.bCB) {
            for (UbcFlowEvent ubcFlowEvent : list) {
                f(ubcFlowEvent);
            }
        }
        return this;
    }

    public HybridUbcFlow aR(String str, String str2) {
        this.bCA.put(str, str2);
        return this;
    }

    public String jB(String str) {
        return this.bCA.get(str);
    }

    public HybridUbcFlow c(HybridUbcFlow hybridUbcFlow) {
        if (hybridUbcFlow != null) {
            hybridUbcFlow.WZ();
            aa(hybridUbcFlow.bCD);
            this.bCA.putAll(hybridUbcFlow.bCA);
        }
        return this;
    }

    public HybridUbcFlow k(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.bCz.put(str, obj);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return this;
    }

    public JSONObject WM() {
        return this.bCz;
    }

    public HybridUbcFlow WN() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naFlowDone");
        }
        this.bCE = true;
        Xd();
        return this;
    }

    public HybridUbcFlow WO() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naAnimFlowDone");
        }
        this.bCF = true;
        Xd();
        return this;
    }

    public HybridUbcFlow WP() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "h5FlowDone");
        }
        this.bCG = true;
        Xd();
        return this;
    }

    public HybridUbcFlow WQ() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "webViewWidgetDone");
        }
        this.bCJ = true;
        Xd();
        return this;
    }

    public HybridUbcFlow WR() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naPaintFlowDone");
        }
        this.bCH = true;
        Xd();
        return this;
    }

    public HybridUbcFlow WS() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "webwidgetPaintDone");
        }
        this.bCI = true;
        Xd();
        return this;
    }

    public boolean WT() {
        return this.bCE;
    }

    public boolean WU() {
        return this.bCF;
    }

    public boolean WV() {
        return this.bCG;
    }

    public boolean WW() {
        return this.bCH;
    }

    public boolean WX() {
        return this.bCI;
    }

    public boolean WY() {
        return this.bCJ;
    }

    private boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.bCB) {
            isEmpty = this.bCB.isEmpty();
        }
        return isEmpty;
    }

    public void WZ() {
        UbcFlowEvent ubcFlowEvent;
        synchronized (this.bCB) {
            this.bCD.clear();
            for (String str : this.bCB) {
                if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.bCC.get(str)) != null && ubcFlowEvent.Xj() > 0) {
                    this.bCD.add(ubcFlowEvent);
                }
            }
            Xa();
        }
    }

    private void Xa() {
        Collections.sort(this.bCD, new Comparator<UbcFlowEvent>() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(UbcFlowEvent ubcFlowEvent, UbcFlowEvent ubcFlowEvent2) {
                return Long.compare(ubcFlowEvent.Xj(), ubcFlowEvent2.Xj());
            }
        });
    }

    public HybridUbcFlow a(SubmitStrategy submitStrategy) {
        if (submitStrategy != null) {
            this.bCM = submitStrategy;
        }
        return this;
    }

    public SubmitStrategy Xb() {
        return this.bCM;
    }

    private boolean Xc() {
        return (this.bCM == null ? bCL : this.bCM).submitAllowed(this);
    }

    private void Xd() {
        if (Xc()) {
            Xe();
        }
    }

    private synchronized void Xe() {
        if (!this.bCK) {
            this.bCK = true;
            jC("callback_on_submit");
            m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow.this.Xf();
                }
            }, "HybridUbcFlow");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xf() {
        WZ();
        jC("component_reporter");
        if (!TextUtils.isEmpty(this.bCy)) {
            Flow qJ = s.qJ(this.bCy);
            for (UbcFlowEvent ubcFlowEvent : this.bCD) {
                if (!ubcFlowEvent.Xl()) {
                    qJ.addEvent(ubcFlowEvent.id, ubcFlowEvent.value(), ubcFlowEvent.Xj());
                }
            }
            if (!isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, String> entry : this.bCA.entrySet()) {
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
                qJ.setValueWithDuration(this.bCz.toString());
                qJ.end();
            }
        }
    }

    private void jC(String str) {
        List<a> list = this.bCN.get(str);
        if (list != null && !list.isEmpty()) {
            for (a aVar : list) {
                if (aVar != null && aVar.bCQ != null) {
                    aVar.bCQ.B(this);
                }
            }
        }
    }

    public HybridUbcFlow c(String str, com.baidu.swan.apps.as.d.b<HybridUbcFlow> bVar) {
        a aVar = new a(str, bVar);
        if (aVar.Xg()) {
            synchronized (this.bCN) {
                List<a> list = this.bCN.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                    this.bCN.put(str, list);
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
        if (r1.Xj() < 1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
        if (r0.Xj() >= 1) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:?, code lost:
        return r1.Xj() - r0.Xj();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long o(String... strArr) {
        UbcFlowEvent ubcFlowEvent;
        int length = strArr.length;
        int i = 0;
        UbcFlowEvent ubcFlowEvent2 = null;
        while (true) {
            if (i >= length) {
                ubcFlowEvent = null;
                break;
            }
            ubcFlowEvent = this.bCC.get(strArr[i]);
            if (ubcFlowEvent2 == null) {
                if (ubcFlowEvent == null || ubcFlowEvent.Xj() < 1) {
                    break;
                }
            } else if (ubcFlowEvent != null && ubcFlowEvent.Xj() > 0) {
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
    /* loaded from: classes9.dex */
    public class a {
        final com.baidu.swan.apps.as.d.b<HybridUbcFlow> bCQ;
        final String type;

        private a(String str, com.baidu.swan.apps.as.d.b<HybridUbcFlow> bVar) {
            this.type = str;
            this.bCQ = bVar;
        }

        boolean Xg() {
            return (this.bCQ == null || TextUtils.isEmpty(this.type)) ? false : true;
        }
    }
}
