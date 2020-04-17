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
    public static final SubmitStrategy cgy = SubmitStrategy.HYBRID;
    private String cgl;
    public final String name;
    private final JSONObject cgm = new JSONObject();
    private final Map<String, String> cgn = new HashMap();
    public final List<String> cgo = new ArrayList();
    private final Map<String, UbcFlowEvent> cgp = new HashMap();
    public final List<UbcFlowEvent> cgq = new ArrayList();
    private boolean cgr = false;
    private boolean cgs = false;
    private boolean cgt = false;
    private boolean cgu = false;
    private boolean cgv = false;
    private boolean cgw = false;
    private volatile boolean cgx = false;
    private SubmitStrategy cgz = cgy;
    private final Map<String, List<a>> cgA = new HashMap();

    /* loaded from: classes11.dex */
    public enum SubmitStrategy {
        HYBRID { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.1
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.ahO() && hybridUbcFlow.ahQ() && hybridUbcFlow.ahP() && hybridUbcFlow.ahR();
            }
        },
        HYBRID_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.2
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.ahO() && hybridUbcFlow.ahQ() && hybridUbcFlow.ahP() && hybridUbcFlow.ahS();
            }
        },
        RELAUNCH { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.3
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.ahO() && hybridUbcFlow.ahQ() && hybridUbcFlow.ahR();
            }
        },
        RELAUNCH_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.4
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.ahO() && hybridUbcFlow.ahQ() && hybridUbcFlow.ahS();
            }
        },
        NA_ONLY { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.5
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.ahO();
            }
        },
        ROUTE { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.6
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.ahO() && hybridUbcFlow.ahQ();
            }
        },
        ROUTE_NA { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.7
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.ahO();
            }
        },
        ROUTE_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.8
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.ahO() && hybridUbcFlow.ahQ() && hybridUbcFlow.ahT();
            }
        };

        abstract boolean submitAllowed(HybridUbcFlow hybridUbcFlow);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HybridUbcFlow(String str) {
        this.name = str;
    }

    public HybridUbcFlow le(String str) {
        this.cgl = str;
        return this;
    }

    public String ahG() {
        return this.cgl;
    }

    private void a(UbcFlowEvent ubcFlowEvent) {
        this.cgo.remove(ubcFlowEvent.id);
        this.cgo.add(ubcFlowEvent.id);
        this.cgp.put(ubcFlowEvent.id, ubcFlowEvent);
    }

    private void b(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.cgp.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.aie() > ubcFlowEvent2.aie()) {
            a(ubcFlowEvent);
        }
    }

    private void c(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.cgp.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.aie() < ubcFlowEvent2.aie()) {
            a(ubcFlowEvent);
        }
    }

    private void d(UbcFlowEvent ubcFlowEvent) {
        if (!e(this.cgp.get(ubcFlowEvent.id))) {
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
            synchronized (this.cgo) {
                switch (ubcFlowEvent.aih()) {
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
        synchronized (this.cgo) {
            for (UbcFlowEvent ubcFlowEvent : list) {
                f(ubcFlowEvent);
            }
        }
        return this;
    }

    public HybridUbcFlow bk(String str, String str2) {
        this.cgn.put(str, str2);
        return this;
    }

    public String lf(String str) {
        return this.cgn.get(str);
    }

    public HybridUbcFlow c(HybridUbcFlow hybridUbcFlow) {
        if (hybridUbcFlow != null) {
            hybridUbcFlow.ahU();
            ah(hybridUbcFlow.cgq);
            this.cgn.putAll(hybridUbcFlow.cgn);
        }
        return this;
    }

    public HybridUbcFlow p(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.cgm.put(str, obj);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return this;
    }

    public JSONObject ahH() {
        return this.cgm;
    }

    public HybridUbcFlow ahI() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naFlowDone");
        }
        this.cgr = true;
        ahY();
        return this;
    }

    public HybridUbcFlow ahJ() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naAnimFlowDone");
        }
        this.cgs = true;
        ahY();
        return this;
    }

    public HybridUbcFlow ahK() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "h5FlowDone");
        }
        this.cgt = true;
        ahY();
        return this;
    }

    public HybridUbcFlow ahL() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "webViewWidgetDone");
        }
        this.cgw = true;
        ahY();
        return this;
    }

    public HybridUbcFlow ahM() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naPaintFlowDone");
        }
        this.cgu = true;
        ahY();
        return this;
    }

    public HybridUbcFlow ahN() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "webwidgetPaintDone");
        }
        this.cgv = true;
        ahY();
        return this;
    }

    public boolean ahO() {
        return this.cgr;
    }

    public boolean ahP() {
        return this.cgs;
    }

    public boolean ahQ() {
        return this.cgt;
    }

    public boolean ahR() {
        return this.cgu;
    }

    public boolean ahS() {
        return this.cgv;
    }

    public boolean ahT() {
        return this.cgw;
    }

    private boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.cgo) {
            isEmpty = this.cgo.isEmpty();
        }
        return isEmpty;
    }

    public void ahU() {
        UbcFlowEvent ubcFlowEvent;
        synchronized (this.cgo) {
            this.cgq.clear();
            for (String str : this.cgo) {
                if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.cgp.get(str)) != null && ubcFlowEvent.aie() > 0) {
                    this.cgq.add(ubcFlowEvent);
                }
            }
            ahV();
        }
    }

    private void ahV() {
        Collections.sort(this.cgq, new Comparator<UbcFlowEvent>() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(UbcFlowEvent ubcFlowEvent, UbcFlowEvent ubcFlowEvent2) {
                return Long.compare(ubcFlowEvent.aie(), ubcFlowEvent2.aie());
            }
        });
    }

    public HybridUbcFlow a(SubmitStrategy submitStrategy) {
        if (submitStrategy != null) {
            this.cgz = submitStrategy;
        }
        return this;
    }

    public SubmitStrategy ahW() {
        return this.cgz;
    }

    private boolean ahX() {
        return (this.cgz == null ? cgy : this.cgz).submitAllowed(this);
    }

    private void ahY() {
        if (ahX()) {
            ahZ();
        }
    }

    private synchronized void ahZ() {
        if (!this.cgx) {
            this.cgx = true;
            lg("callback_on_submit");
            m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow.this.aia();
                }
            }, "HybridUbcFlow");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aia() {
        ahU();
        lg("component_reporter");
        if (!TextUtils.isEmpty(this.cgl)) {
            Flow sn = s.sn(this.cgl);
            for (UbcFlowEvent ubcFlowEvent : this.cgq) {
                if (!ubcFlowEvent.aig()) {
                    sn.addEvent(ubcFlowEvent.id, ubcFlowEvent.value(), ubcFlowEvent.aie());
                }
            }
            if (!isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, String> entry : this.cgn.entrySet()) {
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
                sn.setValueWithDuration(this.cgm.toString());
                sn.end();
            }
        }
    }

    private void lg(String str) {
        List<a> list = this.cgA.get(str);
        if (list != null && !list.isEmpty()) {
            for (a aVar : list) {
                if (aVar != null && aVar.cgD != null) {
                    aVar.cgD.E(this);
                }
            }
        }
    }

    public HybridUbcFlow c(String str, com.baidu.swan.apps.as.d.b<HybridUbcFlow> bVar) {
        a aVar = new a(str, bVar);
        if (aVar.aib()) {
            synchronized (this.cgA) {
                List<a> list = this.cgA.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                    this.cgA.put(str, list);
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
        if (r1.aie() < 1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
        if (r0.aie() >= 1) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:?, code lost:
        return r1.aie() - r0.aie();
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
            ubcFlowEvent = this.cgp.get(strArr[i]);
            if (ubcFlowEvent2 == null) {
                if (ubcFlowEvent == null || ubcFlowEvent.aie() < 1) {
                    break;
                }
            } else if (ubcFlowEvent != null && ubcFlowEvent.aie() > 0) {
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
        final com.baidu.swan.apps.as.d.b<HybridUbcFlow> cgD;
        final String type;

        private a(String str, com.baidu.swan.apps.as.d.b<HybridUbcFlow> bVar) {
            this.type = str;
            this.cgD = bVar;
        }

        boolean aib() {
            return (this.cgD == null || TextUtils.isEmpty(this.type)) ? false : true;
        }
    }
}
