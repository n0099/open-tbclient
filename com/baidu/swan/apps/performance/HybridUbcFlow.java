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
/* loaded from: classes25.dex */
public final class HybridUbcFlow {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final SubmitStrategy dol = SubmitStrategy.HYBRID;
    private final JSONObject dnZ = new JSONObject();
    private final Map<String, String> doa = new HashMap();
    public final List<String> dob = new ArrayList();
    private final Map<String, UbcFlowEvent> dod = new HashMap();
    public final List<UbcFlowEvent> doe = new ArrayList();
    private boolean dof = false;
    private boolean dog = false;
    private boolean doh = false;
    private boolean doi = false;
    private boolean doj = false;
    private volatile boolean dok = false;
    private SubmitStrategy dom = dol;
    private final Map<String, List<a>> don = new HashMap();
    private String doo = "";
    private String mUbcId;
    public final String name;

    /* loaded from: classes25.dex */
    public enum SubmitStrategy {
        HYBRID { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.1
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aFQ() && hybridUbcFlow.aFR() && hybridUbcFlow.aFS();
            }
        },
        HYBRID_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.2
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aFQ() && hybridUbcFlow.aFR() && hybridUbcFlow.aFT();
            }
        },
        RELAUNCH { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.3
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aFQ() && hybridUbcFlow.aFR() && hybridUbcFlow.aFS();
            }
        },
        RELAUNCH_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.4
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aFQ() && hybridUbcFlow.aFR() && hybridUbcFlow.aFT();
            }
        },
        NA_ONLY { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.5
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aFQ();
            }
        },
        ROUTE { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.6
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aFQ() && hybridUbcFlow.aFR();
            }
        },
        ROUTE_NA { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.7
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aFQ();
            }
        },
        ROUTE_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.8
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aFQ() && hybridUbcFlow.aFR() && hybridUbcFlow.aFU();
            }
        },
        VIDEO_NA { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.9
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aFQ();
            }
        };

        abstract boolean submitAllowed(HybridUbcFlow hybridUbcFlow);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HybridUbcFlow(String str) {
        this.name = str;
    }

    public boolean rn(String str) {
        boolean z = false;
        boolean z2 = !TextUtils.isEmpty(str);
        if (TextUtils.isEmpty(this.doo)) {
            if (z2) {
                str = this.doo;
            }
            this.doo = str;
            return true;
        }
        if (!z2 || TextUtils.equals(this.doo, str)) {
            z = true;
        }
        return z;
    }

    public HybridUbcFlow ro(String str) {
        this.mUbcId = str;
        return this;
    }

    public String getUbcId() {
        return this.mUbcId;
    }

    private void a(UbcFlowEvent ubcFlowEvent) {
        this.dob.remove(ubcFlowEvent.id);
        this.dob.add(ubcFlowEvent.id);
        this.dod.put(ubcFlowEvent.id, ubcFlowEvent);
    }

    private void b(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.dod.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.aGk() > ubcFlowEvent2.aGk()) {
            a(ubcFlowEvent);
        }
    }

    private void c(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.dod.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.aGk() < ubcFlowEvent2.aGk()) {
            a(ubcFlowEvent);
        }
    }

    private void d(UbcFlowEvent ubcFlowEvent) {
        if (!e(this.dod.get(ubcFlowEvent.id))) {
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
            synchronized (this.dob) {
                switch (ubcFlowEvent.aGn()) {
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

    public HybridUbcFlow aP(List<UbcFlowEvent> list) {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "record events size = " + list.size());
        }
        synchronized (this.dob) {
            for (UbcFlowEvent ubcFlowEvent : list) {
                f(ubcFlowEvent);
            }
        }
        return this;
    }

    public HybridUbcFlow co(String str, String str2) {
        this.doa.put(str, str2);
        return this;
    }

    public String rp(String str) {
        return this.doa.get(str);
    }

    public HybridUbcFlow d(HybridUbcFlow hybridUbcFlow) {
        if (hybridUbcFlow != null) {
            hybridUbcFlow.aFV();
            aP(hybridUbcFlow.doe);
            this.doa.putAll(hybridUbcFlow.doa);
        }
        return this;
    }

    public HybridUbcFlow q(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.dnZ.put(str, obj);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return this;
    }

    public JSONObject aFK() {
        return this.dnZ;
    }

    public HybridUbcFlow aFL() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naFlowDone");
        }
        this.dof = true;
        aFY();
        return this;
    }

    public HybridUbcFlow aFM() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "h5FlowDone");
        }
        this.dog = true;
        aFY();
        return this;
    }

    public HybridUbcFlow aFN() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "webViewWidgetDone");
        }
        this.doj = true;
        aFY();
        return this;
    }

    public HybridUbcFlow aFO() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naPaintFlowDone");
        }
        this.doh = true;
        rq("fmp_callback");
        aFY();
        return this;
    }

    public HybridUbcFlow aFP() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "webwidgetPaintDone");
        }
        this.doi = true;
        aFY();
        return this;
    }

    public boolean aFQ() {
        return this.dof;
    }

    public boolean aFR() {
        return this.dog;
    }

    public boolean aFS() {
        return this.doh;
    }

    public boolean aFT() {
        return this.doi;
    }

    public boolean aFU() {
        return this.doj;
    }

    private boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.dob) {
            isEmpty = this.dob.isEmpty();
        }
        return isEmpty;
    }

    public void aFV() {
        UbcFlowEvent ubcFlowEvent;
        synchronized (this.dob) {
            this.doe.clear();
            for (String str : this.dob) {
                if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.dod.get(str)) != null && ubcFlowEvent.aGk() > 0) {
                    this.doe.add(ubcFlowEvent);
                }
            }
            sort();
        }
    }

    private void sort() {
        Collections.sort(this.doe, new Comparator<UbcFlowEvent>() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(UbcFlowEvent ubcFlowEvent, UbcFlowEvent ubcFlowEvent2) {
                return Long.compare(ubcFlowEvent.aGk(), ubcFlowEvent2.aGk());
            }
        });
    }

    public HybridUbcFlow a(SubmitStrategy submitStrategy) {
        if (submitStrategy != null) {
            this.dom = submitStrategy;
        }
        return this;
    }

    public SubmitStrategy aFW() {
        return this.dom;
    }

    private boolean aFX() {
        return (this.dom == null ? dol : this.dom).submitAllowed(this);
    }

    private void aFY() {
        if (aFX()) {
            aFZ();
        }
    }

    private synchronized void aFZ() {
        if (!this.dok) {
            this.dok = true;
            rq("callback_on_submit");
            p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow.this.aGa();
                }
            }, "HybridUbcFlow");
            com.baidu.swan.apps.performance.b.d.aGF();
            if (DEBUG) {
                Log.d("HybridUbcFlow", "UBC submit " + getUbcId() + ", this=" + hashCode(), new Exception());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGa() {
        aFV();
        rq("component_reporter");
        if (!TextUtils.isEmpty(this.mUbcId)) {
            com.baidu.swan.apps.statistic.a tD = com.baidu.swan.apps.statistic.h.tD(this.mUbcId);
            for (UbcFlowEvent ubcFlowEvent : this.doe) {
                if (!ubcFlowEvent.aGm()) {
                    com.baidu.swan.apps.statistic.b.a(tD, ubcFlowEvent.id, ubcFlowEvent.value(), ubcFlowEvent.aGk());
                }
            }
            com.baidu.swan.apps.performance.b.a.aQ(this.doe);
            if (!isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, String> entry : this.doa.entrySet()) {
                        String key = entry.getKey();
                        if (!TextUtils.isEmpty(key)) {
                            String value = entry.getValue();
                            if (value == null) {
                                value = "";
                            }
                            jSONObject.put(key, value);
                        }
                    }
                    q("ext", jSONObject);
                } catch (Exception e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
                com.baidu.swan.apps.statistic.b.a(tD, this.dnZ.toString());
                com.baidu.swan.apps.statistic.b.c(tD);
            }
        }
    }

    private void rq(String str) {
        List<a> list = this.don.get(str);
        if (list != null && !list.isEmpty()) {
            for (a aVar : list) {
                if (aVar != null && aVar.dor != null) {
                    aVar.dor.M(this);
                }
            }
        }
    }

    public HybridUbcFlow d(String str, com.baidu.swan.apps.ap.e.b<HybridUbcFlow> bVar) {
        a aVar = new a(str, bVar);
        if (aVar.aGc()) {
            synchronized (this.don) {
                List<a> list = this.don.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                    this.don.put(str, list);
                }
                list.add(aVar);
            }
        }
        return this;
    }

    public boolean pq(String str) {
        return this.dod.get(str) != null;
    }

    public UbcFlowEvent rr(String str) {
        return this.dod.get(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002f, code lost:
        if (r1 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
        if (r0 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0039, code lost:
        if (r1.aGk() < 1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
        if (r0.aGk() >= 1) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:?, code lost:
        return r1.aGk() - r0.aGk();
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
            ubcFlowEvent = this.dod.get(strArr[i]);
            if (ubcFlowEvent2 == null) {
                if (ubcFlowEvent == null || ubcFlowEvent.aGk() < 1) {
                    break;
                }
            } else if (ubcFlowEvent != null && ubcFlowEvent.aGk() > 0) {
                break;
            } else {
                ubcFlowEvent = ubcFlowEvent2;
            }
            i++;
            ubcFlowEvent2 = ubcFlowEvent;
        }
        return -1L;
    }

    public synchronized JSONObject aGb() throws JSONException {
        JSONObject jSONObject;
        UbcFlowEvent ubcFlowEvent;
        jSONObject = new JSONObject();
        try {
            String[] strArr = new String[this.dob.size()];
            this.dob.toArray(strArr);
            ArrayList<UbcFlowEvent> arrayList = new ArrayList(strArr.length);
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.dod.get(str)) != null && ubcFlowEvent.aGk() > 0) {
                    arrayList.add(ubcFlowEvent);
                }
            }
            Collections.sort(arrayList, new Comparator<UbcFlowEvent>() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(UbcFlowEvent ubcFlowEvent2, UbcFlowEvent ubcFlowEvent3) {
                    return Long.compare(ubcFlowEvent2.aGk(), ubcFlowEvent3.aGk());
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
            for (Map.Entry<String, String> entry : this.doa.entrySet()) {
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
            if (this.dnZ != null && this.dnZ.length() > 0) {
                jSONObject.put("values", this.dnZ);
            }
        } catch (Exception e) {
            jSONObject.put("excp", e.getMessage());
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public class a {
        final com.baidu.swan.apps.ap.e.b<HybridUbcFlow> dor;
        final String type;

        private a(String str, com.baidu.swan.apps.ap.e.b<HybridUbcFlow> bVar) {
            this.type = str;
            this.dor = bVar;
        }

        boolean aGc() {
            return (this.dor == null || TextUtils.isEmpty(this.type)) ? false : true;
        }
    }
}
