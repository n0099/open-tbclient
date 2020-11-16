package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ap.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class HybridUbcFlow {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final SubmitStrategy dhk = SubmitStrategy.HYBRID;
    private String dgY;
    private final JSONObject dgZ = new JSONObject();
    private final Map<String, String> dha = new HashMap();
    public final List<String> dhb = new ArrayList();
    private final Map<String, UbcFlowEvent> dhc = new HashMap();
    public final List<UbcFlowEvent> dhd = new ArrayList();
    private boolean dhe = false;
    private boolean dhf = false;
    private boolean dhg = false;
    private boolean dhh = false;
    private boolean dhi = false;
    private volatile boolean dhj = false;
    private SubmitStrategy dhl = dhk;
    private final Map<String, List<a>> dhm = new HashMap();
    private String dhn = "";
    public final String name;

    /* loaded from: classes7.dex */
    public enum SubmitStrategy {
        HYBRID { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.1
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aCI() && hybridUbcFlow.aCJ() && hybridUbcFlow.aCK();
            }
        },
        HYBRID_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.2
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aCI() && hybridUbcFlow.aCJ() && hybridUbcFlow.aCL();
            }
        },
        RELAUNCH { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.3
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aCI() && hybridUbcFlow.aCJ() && hybridUbcFlow.aCK();
            }
        },
        RELAUNCH_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.4
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aCI() && hybridUbcFlow.aCJ() && hybridUbcFlow.aCL();
            }
        },
        NA_ONLY { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.5
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aCI();
            }
        },
        ROUTE { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.6
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aCI() && hybridUbcFlow.aCJ();
            }
        },
        ROUTE_NA { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.7
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aCI();
            }
        },
        ROUTE_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.8
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aCI() && hybridUbcFlow.aCJ() && hybridUbcFlow.aCM();
            }
        },
        VIDEO_NA { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.9
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aCI();
            }
        };

        abstract boolean submitAllowed(HybridUbcFlow hybridUbcFlow);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HybridUbcFlow(String str) {
        this.name = str;
    }

    public boolean qG(String str) {
        boolean z = false;
        boolean z2 = !TextUtils.isEmpty(str);
        if (TextUtils.isEmpty(this.dhn)) {
            if (z2) {
                str = this.dhn;
            }
            this.dhn = str;
            return true;
        }
        if (!z2 || TextUtils.equals(this.dhn, str)) {
            z = true;
        }
        return z;
    }

    public HybridUbcFlow qH(String str) {
        this.dgY = str;
        return this;
    }

    public String aCB() {
        return this.dgY;
    }

    private void a(UbcFlowEvent ubcFlowEvent) {
        this.dhb.remove(ubcFlowEvent.id);
        this.dhb.add(ubcFlowEvent.id);
        this.dhc.put(ubcFlowEvent.id, ubcFlowEvent);
    }

    private void b(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.dhc.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.aDc() > ubcFlowEvent2.aDc()) {
            a(ubcFlowEvent);
        }
    }

    private void c(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.dhc.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.aDc() < ubcFlowEvent2.aDc()) {
            a(ubcFlowEvent);
        }
    }

    private void d(UbcFlowEvent ubcFlowEvent) {
        if (!e(this.dhc.get(ubcFlowEvent.id))) {
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
            synchronized (this.dhb) {
                switch (ubcFlowEvent.aDf()) {
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

    public HybridUbcFlow aM(List<UbcFlowEvent> list) {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "record events size = " + list.size());
        }
        synchronized (this.dhb) {
            for (UbcFlowEvent ubcFlowEvent : list) {
                f(ubcFlowEvent);
            }
        }
        return this;
    }

    public HybridUbcFlow ch(String str, String str2) {
        this.dha.put(str, str2);
        return this;
    }

    public String qI(String str) {
        return this.dha.get(str);
    }

    public HybridUbcFlow d(HybridUbcFlow hybridUbcFlow) {
        if (hybridUbcFlow != null) {
            hybridUbcFlow.aCN();
            aM(hybridUbcFlow.dhd);
            this.dha.putAll(hybridUbcFlow.dha);
        }
        return this;
    }

    public HybridUbcFlow r(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.dgZ.put(str, obj);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return this;
    }

    public JSONObject aCC() {
        return this.dgZ;
    }

    public HybridUbcFlow aCD() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naFlowDone");
        }
        this.dhe = true;
        aCQ();
        return this;
    }

    public HybridUbcFlow aCE() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "h5FlowDone");
        }
        this.dhf = true;
        aCQ();
        return this;
    }

    public HybridUbcFlow aCF() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "webViewWidgetDone");
        }
        this.dhi = true;
        aCQ();
        return this;
    }

    public HybridUbcFlow aCG() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naPaintFlowDone");
        }
        this.dhg = true;
        qJ("fmp_callback");
        aCQ();
        return this;
    }

    public HybridUbcFlow aCH() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "webwidgetPaintDone");
        }
        this.dhh = true;
        aCQ();
        return this;
    }

    public boolean aCI() {
        return this.dhe;
    }

    public boolean aCJ() {
        return this.dhf;
    }

    public boolean aCK() {
        return this.dhg;
    }

    public boolean aCL() {
        return this.dhh;
    }

    public boolean aCM() {
        return this.dhi;
    }

    private boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.dhb) {
            isEmpty = this.dhb.isEmpty();
        }
        return isEmpty;
    }

    public void aCN() {
        UbcFlowEvent ubcFlowEvent;
        synchronized (this.dhb) {
            this.dhd.clear();
            for (String str : this.dhb) {
                if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.dhc.get(str)) != null && ubcFlowEvent.aDc() > 0) {
                    this.dhd.add(ubcFlowEvent);
                }
            }
            sort();
        }
    }

    private void sort() {
        Collections.sort(this.dhd, new Comparator<UbcFlowEvent>() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(UbcFlowEvent ubcFlowEvent, UbcFlowEvent ubcFlowEvent2) {
                return Long.compare(ubcFlowEvent.aDc(), ubcFlowEvent2.aDc());
            }
        });
    }

    public HybridUbcFlow a(SubmitStrategy submitStrategy) {
        if (submitStrategy != null) {
            this.dhl = submitStrategy;
        }
        return this;
    }

    public SubmitStrategy aCO() {
        return this.dhl;
    }

    private boolean aCP() {
        return (this.dhl == null ? dhk : this.dhl).submitAllowed(this);
    }

    private void aCQ() {
        if (aCP()) {
            aCR();
        }
    }

    private synchronized void aCR() {
        if (!this.dhj) {
            this.dhj = true;
            qJ("callback_on_submit");
            p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow.this.aCS();
                }
            }, "HybridUbcFlow");
            com.baidu.swan.apps.performance.b.d.aDx();
            if (DEBUG) {
                Log.d("HybridUbcFlow", "UBC submit " + aCB() + ", this=" + hashCode(), new Exception());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCS() {
        aCN();
        qJ("component_reporter");
        if (!TextUtils.isEmpty(this.dgY)) {
            com.baidu.swan.apps.statistic.a sW = com.baidu.swan.apps.statistic.h.sW(this.dgY);
            for (UbcFlowEvent ubcFlowEvent : this.dhd) {
                if (!ubcFlowEvent.aDe()) {
                    com.baidu.swan.apps.statistic.b.a(sW, ubcFlowEvent.id, ubcFlowEvent.value(), ubcFlowEvent.aDc());
                }
            }
            com.baidu.swan.apps.performance.b.a.aN(this.dhd);
            if (!isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, String> entry : this.dha.entrySet()) {
                        String key = entry.getKey();
                        if (!TextUtils.isEmpty(key)) {
                            String value = entry.getValue();
                            if (value == null) {
                                value = "";
                            }
                            jSONObject.put(key, value);
                        }
                    }
                    r("ext", jSONObject);
                } catch (Exception e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
                com.baidu.swan.apps.statistic.b.a(sW, this.dgZ.toString());
                com.baidu.swan.apps.statistic.b.c(sW);
            }
        }
    }

    private void qJ(String str) {
        List<a> list = this.dhm.get(str);
        if (list != null && !list.isEmpty()) {
            for (a aVar : list) {
                if (aVar != null && aVar.dhq != null) {
                    aVar.dhq.M(this);
                }
            }
        }
    }

    public HybridUbcFlow d(String str, com.baidu.swan.apps.ap.e.b<HybridUbcFlow> bVar) {
        a aVar = new a(str, bVar);
        if (aVar.aCU()) {
            synchronized (this.dhm) {
                List<a> list = this.dhm.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                    this.dhm.put(str, list);
                }
                list.add(aVar);
            }
        }
        return this;
    }

    public boolean oJ(String str) {
        return this.dhc.get(str) != null;
    }

    public UbcFlowEvent qK(String str) {
        return this.dhc.get(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002f, code lost:
        if (r1 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
        if (r0 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0039, code lost:
        if (r1.aDc() < 1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
        if (r0.aDc() >= 1) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:?, code lost:
        return r1.aDc() - r0.aDc();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long u(String... strArr) {
        UbcFlowEvent ubcFlowEvent;
        int length = strArr.length;
        int i = 0;
        UbcFlowEvent ubcFlowEvent2 = null;
        while (true) {
            if (i >= length) {
                ubcFlowEvent = null;
                break;
            }
            ubcFlowEvent = this.dhc.get(strArr[i]);
            if (ubcFlowEvent2 == null) {
                if (ubcFlowEvent == null || ubcFlowEvent.aDc() < 1) {
                    break;
                }
            } else if (ubcFlowEvent != null && ubcFlowEvent.aDc() > 0) {
                break;
            } else {
                ubcFlowEvent = ubcFlowEvent2;
            }
            i++;
            ubcFlowEvent2 = ubcFlowEvent;
        }
        return -1L;
    }

    public synchronized JSONObject aCT() throws JSONException {
        JSONObject jSONObject;
        UbcFlowEvent ubcFlowEvent;
        jSONObject = new JSONObject();
        try {
            String[] strArr = new String[this.dhb.size()];
            this.dhb.toArray(strArr);
            ArrayList<UbcFlowEvent> arrayList = new ArrayList(strArr.length);
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.dhc.get(str)) != null && ubcFlowEvent.aDc() > 0) {
                    arrayList.add(ubcFlowEvent);
                }
            }
            Collections.sort(arrayList, new Comparator<UbcFlowEvent>() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(UbcFlowEvent ubcFlowEvent2, UbcFlowEvent ubcFlowEvent3) {
                    return Long.compare(ubcFlowEvent2.aDc(), ubcFlowEvent3.aDc());
                }
            });
            JSONArray jSONArray = new JSONArray();
            for (UbcFlowEvent ubcFlowEvent2 : arrayList) {
                jSONArray.put(ubcFlowEvent2.toJSON());
            }
            if (jSONArray.length() != 0) {
                jSONObject.put("events", jSONArray);
            }
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry<String, String> entry : this.dha.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    String value = entry.getValue();
                    if (value == null) {
                        value = "";
                    }
                    jSONObject2.put(key, value);
                }
            }
            if (jSONObject2.length() != 0) {
                jSONObject.put("ext", jSONObject2);
            }
            if (this.dgZ != null && this.dgZ.length() > 0) {
                jSONObject.put("values", this.dgZ);
            }
        } catch (Exception e) {
            jSONObject.put("excp", e.getMessage());
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a {
        final com.baidu.swan.apps.ap.e.b<HybridUbcFlow> dhq;
        final String type;

        private a(String str, com.baidu.swan.apps.ap.e.b<HybridUbcFlow> bVar) {
            this.type = str;
            this.dhq = bVar;
        }

        boolean aCU() {
            return (this.dhq == null || TextUtils.isEmpty(this.type)) ? false : true;
        }
    }
}
