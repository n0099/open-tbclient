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
/* loaded from: classes10.dex */
public final class HybridUbcFlow {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final SubmitStrategy dcX = SubmitStrategy.HYBRID;
    private String dcL;
    private final JSONObject dcM = new JSONObject();
    private final Map<String, String> dcN = new HashMap();
    public final List<String> dcO = new ArrayList();
    private final Map<String, UbcFlowEvent> dcP = new HashMap();
    public final List<UbcFlowEvent> dcQ = new ArrayList();
    private boolean dcR = false;
    private boolean dcS = false;
    private boolean dcT = false;
    private boolean dcU = false;
    private boolean dcV = false;
    private volatile boolean dcW = false;
    private SubmitStrategy dcY = dcX;
    private final Map<String, List<a>> dcZ = new HashMap();
    private String dda = "";
    public final String name;

    /* loaded from: classes10.dex */
    public enum SubmitStrategy {
        HYBRID { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.1
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aAQ() && hybridUbcFlow.aAR() && hybridUbcFlow.aAS();
            }
        },
        HYBRID_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.2
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aAQ() && hybridUbcFlow.aAR() && hybridUbcFlow.aAT();
            }
        },
        RELAUNCH { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.3
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aAQ() && hybridUbcFlow.aAR() && hybridUbcFlow.aAS();
            }
        },
        RELAUNCH_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.4
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aAQ() && hybridUbcFlow.aAR() && hybridUbcFlow.aAT();
            }
        },
        NA_ONLY { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.5
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aAQ();
            }
        },
        ROUTE { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.6
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aAQ() && hybridUbcFlow.aAR();
            }
        },
        ROUTE_NA { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.7
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aAQ();
            }
        },
        ROUTE_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.8
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aAQ() && hybridUbcFlow.aAR() && hybridUbcFlow.aAU();
            }
        },
        VIDEO_NA { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.9
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aAQ();
            }
        };

        abstract boolean submitAllowed(HybridUbcFlow hybridUbcFlow);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HybridUbcFlow(String str) {
        this.name = str;
    }

    public boolean qy(String str) {
        boolean z = false;
        boolean z2 = !TextUtils.isEmpty(str);
        if (TextUtils.isEmpty(this.dda)) {
            if (z2) {
                str = this.dda;
            }
            this.dda = str;
            return true;
        }
        if (!z2 || TextUtils.equals(this.dda, str)) {
            z = true;
        }
        return z;
    }

    public HybridUbcFlow qz(String str) {
        this.dcL = str;
        return this;
    }

    public String aAJ() {
        return this.dcL;
    }

    private void a(UbcFlowEvent ubcFlowEvent) {
        this.dcO.remove(ubcFlowEvent.id);
        this.dcO.add(ubcFlowEvent.id);
        this.dcP.put(ubcFlowEvent.id, ubcFlowEvent);
    }

    private void b(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.dcP.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.aBk() > ubcFlowEvent2.aBk()) {
            a(ubcFlowEvent);
        }
    }

    private void c(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.dcP.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.aBk() < ubcFlowEvent2.aBk()) {
            a(ubcFlowEvent);
        }
    }

    private void d(UbcFlowEvent ubcFlowEvent) {
        if (!e(this.dcP.get(ubcFlowEvent.id))) {
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
            synchronized (this.dcO) {
                switch (ubcFlowEvent.aBn()) {
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

    public HybridUbcFlow aF(List<UbcFlowEvent> list) {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "record events size = " + list.size());
        }
        synchronized (this.dcO) {
            for (UbcFlowEvent ubcFlowEvent : list) {
                f(ubcFlowEvent);
            }
        }
        return this;
    }

    public HybridUbcFlow ci(String str, String str2) {
        this.dcN.put(str, str2);
        return this;
    }

    public String qA(String str) {
        return this.dcN.get(str);
    }

    public HybridUbcFlow d(HybridUbcFlow hybridUbcFlow) {
        if (hybridUbcFlow != null) {
            hybridUbcFlow.aAV();
            aF(hybridUbcFlow.dcQ);
            this.dcN.putAll(hybridUbcFlow.dcN);
        }
        return this;
    }

    public HybridUbcFlow r(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.dcM.put(str, obj);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return this;
    }

    public JSONObject aAK() {
        return this.dcM;
    }

    public HybridUbcFlow aAL() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naFlowDone");
        }
        this.dcR = true;
        aAY();
        return this;
    }

    public HybridUbcFlow aAM() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "h5FlowDone");
        }
        this.dcS = true;
        aAY();
        return this;
    }

    public HybridUbcFlow aAN() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "webViewWidgetDone");
        }
        this.dcV = true;
        aAY();
        return this;
    }

    public HybridUbcFlow aAO() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naPaintFlowDone");
        }
        this.dcT = true;
        qB("fmp_callback");
        aAY();
        return this;
    }

    public HybridUbcFlow aAP() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "webwidgetPaintDone");
        }
        this.dcU = true;
        aAY();
        return this;
    }

    public boolean aAQ() {
        return this.dcR;
    }

    public boolean aAR() {
        return this.dcS;
    }

    public boolean aAS() {
        return this.dcT;
    }

    public boolean aAT() {
        return this.dcU;
    }

    public boolean aAU() {
        return this.dcV;
    }

    private boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.dcO) {
            isEmpty = this.dcO.isEmpty();
        }
        return isEmpty;
    }

    public void aAV() {
        UbcFlowEvent ubcFlowEvent;
        synchronized (this.dcO) {
            this.dcQ.clear();
            for (String str : this.dcO) {
                if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.dcP.get(str)) != null && ubcFlowEvent.aBk() > 0) {
                    this.dcQ.add(ubcFlowEvent);
                }
            }
            sort();
        }
    }

    private void sort() {
        Collections.sort(this.dcQ, new Comparator<UbcFlowEvent>() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(UbcFlowEvent ubcFlowEvent, UbcFlowEvent ubcFlowEvent2) {
                return Long.compare(ubcFlowEvent.aBk(), ubcFlowEvent2.aBk());
            }
        });
    }

    public HybridUbcFlow a(SubmitStrategy submitStrategy) {
        if (submitStrategy != null) {
            this.dcY = submitStrategy;
        }
        return this;
    }

    public SubmitStrategy aAW() {
        return this.dcY;
    }

    private boolean aAX() {
        return (this.dcY == null ? dcX : this.dcY).submitAllowed(this);
    }

    private void aAY() {
        if (aAX()) {
            aAZ();
        }
    }

    private synchronized void aAZ() {
        if (!this.dcW) {
            this.dcW = true;
            qB("callback_on_submit");
            p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow.this.aBa();
                }
            }, "HybridUbcFlow");
            com.baidu.swan.apps.performance.b.d.aBF();
            if (DEBUG) {
                Log.d("HybridUbcFlow", "UBC submit " + aAJ() + ", this=" + hashCode(), new Exception());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBa() {
        aAV();
        qB("component_reporter");
        if (!TextUtils.isEmpty(this.dcL)) {
            com.baidu.swan.apps.statistic.a sN = com.baidu.swan.apps.statistic.h.sN(this.dcL);
            for (UbcFlowEvent ubcFlowEvent : this.dcQ) {
                if (!ubcFlowEvent.aBm()) {
                    com.baidu.swan.apps.statistic.b.a(sN, ubcFlowEvent.id, ubcFlowEvent.value(), ubcFlowEvent.aBk());
                }
            }
            com.baidu.swan.apps.performance.b.a.aG(this.dcQ);
            if (!isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, String> entry : this.dcN.entrySet()) {
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
                com.baidu.swan.apps.statistic.b.a(sN, this.dcM.toString());
                com.baidu.swan.apps.statistic.b.c(sN);
            }
        }
    }

    private void qB(String str) {
        List<a> list = this.dcZ.get(str);
        if (list != null && !list.isEmpty()) {
            for (a aVar : list) {
                if (aVar != null && aVar.ddd != null) {
                    aVar.ddd.M(this);
                }
            }
        }
    }

    public HybridUbcFlow d(String str, com.baidu.swan.apps.ap.e.b<HybridUbcFlow> bVar) {
        a aVar = new a(str, bVar);
        if (aVar.aBc()) {
            synchronized (this.dcZ) {
                List<a> list = this.dcZ.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                    this.dcZ.put(str, list);
                }
                list.add(aVar);
            }
        }
        return this;
    }

    public boolean oB(String str) {
        return this.dcP.get(str) != null;
    }

    public UbcFlowEvent qC(String str) {
        return this.dcP.get(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002f, code lost:
        if (r1 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
        if (r0 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0039, code lost:
        if (r1.aBk() < 1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
        if (r0.aBk() >= 1) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:?, code lost:
        return r1.aBk() - r0.aBk();
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
            ubcFlowEvent = this.dcP.get(strArr[i]);
            if (ubcFlowEvent2 == null) {
                if (ubcFlowEvent == null || ubcFlowEvent.aBk() < 1) {
                    break;
                }
            } else if (ubcFlowEvent != null && ubcFlowEvent.aBk() > 0) {
                break;
            } else {
                ubcFlowEvent = ubcFlowEvent2;
            }
            i++;
            ubcFlowEvent2 = ubcFlowEvent;
        }
        return -1L;
    }

    public synchronized JSONObject aBb() throws JSONException {
        JSONObject jSONObject;
        UbcFlowEvent ubcFlowEvent;
        jSONObject = new JSONObject();
        try {
            String[] strArr = new String[this.dcO.size()];
            this.dcO.toArray(strArr);
            ArrayList<UbcFlowEvent> arrayList = new ArrayList(strArr.length);
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.dcP.get(str)) != null && ubcFlowEvent.aBk() > 0) {
                    arrayList.add(ubcFlowEvent);
                }
            }
            Collections.sort(arrayList, new Comparator<UbcFlowEvent>() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(UbcFlowEvent ubcFlowEvent2, UbcFlowEvent ubcFlowEvent3) {
                    return Long.compare(ubcFlowEvent2.aBk(), ubcFlowEvent3.aBk());
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
            for (Map.Entry<String, String> entry : this.dcN.entrySet()) {
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
            if (this.dcM != null && this.dcM.length() > 0) {
                jSONObject.put("values", this.dcM);
            }
        } catch (Exception e) {
            jSONObject.put("excp", e.getMessage());
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a {
        final com.baidu.swan.apps.ap.e.b<HybridUbcFlow> ddd;
        final String type;

        private a(String str, com.baidu.swan.apps.ap.e.b<HybridUbcFlow> bVar) {
            this.type = str;
            this.ddd = bVar;
        }

        boolean aBc() {
            return (this.ddd == null || TextUtils.isEmpty(this.type)) ? false : true;
        }
    }
}
