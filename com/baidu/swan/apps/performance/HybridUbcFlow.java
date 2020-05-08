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
    public static final SubmitStrategy cgE = SubmitStrategy.HYBRID;
    private String cgr;
    public final String name;
    private final JSONObject cgs = new JSONObject();
    private final Map<String, String> cgt = new HashMap();
    public final List<String> cgu = new ArrayList();
    private final Map<String, UbcFlowEvent> cgv = new HashMap();
    public final List<UbcFlowEvent> cgw = new ArrayList();
    private boolean cgx = false;
    private boolean cgy = false;
    private boolean cgz = false;
    private boolean cgA = false;
    private boolean cgB = false;
    private boolean cgC = false;
    private volatile boolean cgD = false;
    private SubmitStrategy cgF = cgE;
    private final Map<String, List<a>> cgG = new HashMap();

    /* loaded from: classes11.dex */
    public enum SubmitStrategy {
        HYBRID { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.1
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.ahN() && hybridUbcFlow.ahP() && hybridUbcFlow.ahO() && hybridUbcFlow.ahQ();
            }
        },
        HYBRID_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.2
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.ahN() && hybridUbcFlow.ahP() && hybridUbcFlow.ahO() && hybridUbcFlow.ahR();
            }
        },
        RELAUNCH { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.3
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.ahN() && hybridUbcFlow.ahP() && hybridUbcFlow.ahQ();
            }
        },
        RELAUNCH_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.4
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.ahN() && hybridUbcFlow.ahP() && hybridUbcFlow.ahR();
            }
        },
        NA_ONLY { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.5
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.ahN();
            }
        },
        ROUTE { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.6
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.ahN() && hybridUbcFlow.ahP();
            }
        },
        ROUTE_NA { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.7
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.ahN();
            }
        },
        ROUTE_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.8
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.ahN() && hybridUbcFlow.ahP() && hybridUbcFlow.ahS();
            }
        };

        abstract boolean submitAllowed(HybridUbcFlow hybridUbcFlow);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HybridUbcFlow(String str) {
        this.name = str;
    }

    public HybridUbcFlow le(String str) {
        this.cgr = str;
        return this;
    }

    public String ahF() {
        return this.cgr;
    }

    private void a(UbcFlowEvent ubcFlowEvent) {
        this.cgu.remove(ubcFlowEvent.id);
        this.cgu.add(ubcFlowEvent.id);
        this.cgv.put(ubcFlowEvent.id, ubcFlowEvent);
    }

    private void b(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.cgv.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.aid() > ubcFlowEvent2.aid()) {
            a(ubcFlowEvent);
        }
    }

    private void c(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.cgv.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.aid() < ubcFlowEvent2.aid()) {
            a(ubcFlowEvent);
        }
    }

    private void d(UbcFlowEvent ubcFlowEvent) {
        if (!e(this.cgv.get(ubcFlowEvent.id))) {
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
            synchronized (this.cgu) {
                switch (ubcFlowEvent.aig()) {
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

    public HybridUbcFlow ah(List<UbcFlowEvent> list) {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "record events size = " + list.size());
        }
        synchronized (this.cgu) {
            for (UbcFlowEvent ubcFlowEvent : list) {
                f(ubcFlowEvent);
            }
        }
        return this;
    }

    public HybridUbcFlow bk(String str, String str2) {
        this.cgt.put(str, str2);
        return this;
    }

    public String lf(String str) {
        return this.cgt.get(str);
    }

    public HybridUbcFlow c(HybridUbcFlow hybridUbcFlow) {
        if (hybridUbcFlow != null) {
            hybridUbcFlow.ahT();
            ah(hybridUbcFlow.cgw);
            this.cgt.putAll(hybridUbcFlow.cgt);
        }
        return this;
    }

    public HybridUbcFlow p(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.cgs.put(str, obj);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return this;
    }

    public JSONObject ahG() {
        return this.cgs;
    }

    public HybridUbcFlow ahH() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naFlowDone");
        }
        this.cgx = true;
        ahX();
        return this;
    }

    public HybridUbcFlow ahI() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naAnimFlowDone");
        }
        this.cgy = true;
        ahX();
        return this;
    }

    public HybridUbcFlow ahJ() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "h5FlowDone");
        }
        this.cgz = true;
        ahX();
        return this;
    }

    public HybridUbcFlow ahK() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "webViewWidgetDone");
        }
        this.cgC = true;
        ahX();
        return this;
    }

    public HybridUbcFlow ahL() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naPaintFlowDone");
        }
        this.cgA = true;
        ahX();
        return this;
    }

    public HybridUbcFlow ahM() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "webwidgetPaintDone");
        }
        this.cgB = true;
        ahX();
        return this;
    }

    public boolean ahN() {
        return this.cgx;
    }

    public boolean ahO() {
        return this.cgy;
    }

    public boolean ahP() {
        return this.cgz;
    }

    public boolean ahQ() {
        return this.cgA;
    }

    public boolean ahR() {
        return this.cgB;
    }

    public boolean ahS() {
        return this.cgC;
    }

    private boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.cgu) {
            isEmpty = this.cgu.isEmpty();
        }
        return isEmpty;
    }

    public void ahT() {
        UbcFlowEvent ubcFlowEvent;
        synchronized (this.cgu) {
            this.cgw.clear();
            for (String str : this.cgu) {
                if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.cgv.get(str)) != null && ubcFlowEvent.aid() > 0) {
                    this.cgw.add(ubcFlowEvent);
                }
            }
            ahU();
        }
    }

    private void ahU() {
        Collections.sort(this.cgw, new Comparator<UbcFlowEvent>() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(UbcFlowEvent ubcFlowEvent, UbcFlowEvent ubcFlowEvent2) {
                return Long.compare(ubcFlowEvent.aid(), ubcFlowEvent2.aid());
            }
        });
    }

    public HybridUbcFlow a(SubmitStrategy submitStrategy) {
        if (submitStrategy != null) {
            this.cgF = submitStrategy;
        }
        return this;
    }

    public SubmitStrategy ahV() {
        return this.cgF;
    }

    private boolean ahW() {
        return (this.cgF == null ? cgE : this.cgF).submitAllowed(this);
    }

    private void ahX() {
        if (ahW()) {
            ahY();
        }
    }

    private synchronized void ahY() {
        if (!this.cgD) {
            this.cgD = true;
            lg("callback_on_submit");
            m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow.this.ahZ();
                }
            }, "HybridUbcFlow");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahZ() {
        ahT();
        lg("component_reporter");
        if (!TextUtils.isEmpty(this.cgr)) {
            Flow sn = s.sn(this.cgr);
            for (UbcFlowEvent ubcFlowEvent : this.cgw) {
                if (!ubcFlowEvent.aif()) {
                    sn.addEvent(ubcFlowEvent.id, ubcFlowEvent.value(), ubcFlowEvent.aid());
                }
            }
            if (!isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, String> entry : this.cgt.entrySet()) {
                        String key = entry.getKey();
                        if (!TextUtils.isEmpty(key)) {
                            String value = entry.getValue();
                            if (value == null) {
                                value = "";
                            }
                            jSONObject.put(key, value);
                        }
                    }
                    p("ext", jSONObject);
                } catch (Exception e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
                sn.setValueWithDuration(this.cgs.toString());
                sn.end();
            }
        }
    }

    private void lg(String str) {
        List<a> list = this.cgG.get(str);
        if (list != null && !list.isEmpty()) {
            for (a aVar : list) {
                if (aVar != null && aVar.cgJ != null) {
                    aVar.cgJ.F(this);
                }
            }
        }
    }

    public HybridUbcFlow c(String str, com.baidu.swan.apps.as.d.b<HybridUbcFlow> bVar) {
        a aVar = new a(str, bVar);
        if (aVar.aia()) {
            synchronized (this.cgG) {
                List<a> list = this.cgG.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                    this.cgG.put(str, list);
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
        if (r1.aid() < 1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
        if (r0.aid() >= 1) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:?, code lost:
        return r1.aid() - r0.aid();
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
            ubcFlowEvent = this.cgv.get(strArr[i]);
            if (ubcFlowEvent2 == null) {
                if (ubcFlowEvent == null || ubcFlowEvent.aid() < 1) {
                    break;
                }
            } else if (ubcFlowEvent != null && ubcFlowEvent.aid() > 0) {
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
        final com.baidu.swan.apps.as.d.b<HybridUbcFlow> cgJ;
        final String type;

        private a(String str, com.baidu.swan.apps.as.d.b<HybridUbcFlow> bVar) {
            this.type = str;
            this.cgJ = bVar;
        }

        boolean aia() {
            return (this.cgJ == null || TextUtils.isEmpty(this.type)) ? false : true;
        }
    }
}
