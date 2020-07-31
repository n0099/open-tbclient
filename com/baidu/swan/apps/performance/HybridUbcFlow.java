package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.aq.p;
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
    public static final SubmitStrategy cyx = SubmitStrategy.HYBRID;
    private String cyl;
    public final String name;
    private final JSONObject cym = new JSONObject();
    private final Map<String, String> cyn = new HashMap();
    public final List<String> cyo = new ArrayList();
    private final Map<String, UbcFlowEvent> cyp = new HashMap();
    public final List<UbcFlowEvent> cyq = new ArrayList();
    private boolean cyr = false;
    private boolean cys = false;
    private boolean cyt = false;
    private boolean cyu = false;
    private boolean cyv = false;
    private volatile boolean cyw = false;
    private SubmitStrategy cyy = cyx;
    private final Map<String, List<a>> cyz = new HashMap();
    private String cyA = "";

    /* loaded from: classes7.dex */
    public enum SubmitStrategy {
        HYBRID { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.1
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.anH() && hybridUbcFlow.anI() && hybridUbcFlow.anJ();
            }
        },
        HYBRID_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.2
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.anH() && hybridUbcFlow.anI() && hybridUbcFlow.anK();
            }
        },
        RELAUNCH { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.3
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.anH() && hybridUbcFlow.anI() && hybridUbcFlow.anJ();
            }
        },
        RELAUNCH_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.4
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.anH() && hybridUbcFlow.anI() && hybridUbcFlow.anK();
            }
        },
        NA_ONLY { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.5
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.anH();
            }
        },
        ROUTE { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.6
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.anH() && hybridUbcFlow.anI();
            }
        },
        ROUTE_NA { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.7
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.anH();
            }
        },
        ROUTE_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.8
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.anH() && hybridUbcFlow.anI() && hybridUbcFlow.anL();
            }
        };

        abstract boolean submitAllowed(HybridUbcFlow hybridUbcFlow);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HybridUbcFlow(String str) {
        this.name = str;
    }

    public boolean na(String str) {
        boolean z = false;
        boolean z2 = !TextUtils.isEmpty(str);
        if (TextUtils.isEmpty(this.cyA)) {
            if (z2) {
                str = this.cyA;
            }
            this.cyA = str;
            return true;
        }
        if (!z2 || TextUtils.equals(this.cyA, str)) {
            z = true;
        }
        return z;
    }

    public HybridUbcFlow nb(String str) {
        this.cyl = str;
        return this;
    }

    public String anA() {
        return this.cyl;
    }

    private void a(UbcFlowEvent ubcFlowEvent) {
        this.cyo.remove(ubcFlowEvent.id);
        this.cyo.add(ubcFlowEvent.id);
        this.cyp.put(ubcFlowEvent.id, ubcFlowEvent);
    }

    private void b(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.cyp.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.aob() > ubcFlowEvent2.aob()) {
            a(ubcFlowEvent);
        }
    }

    private void c(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.cyp.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.aob() < ubcFlowEvent2.aob()) {
            a(ubcFlowEvent);
        }
    }

    private void d(UbcFlowEvent ubcFlowEvent) {
        if (!e(this.cyp.get(ubcFlowEvent.id))) {
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
            synchronized (this.cyo) {
                switch (ubcFlowEvent.aoe()) {
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

    public HybridUbcFlow an(List<UbcFlowEvent> list) {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "record events size = " + list.size());
        }
        synchronized (this.cyo) {
            for (UbcFlowEvent ubcFlowEvent : list) {
                f(ubcFlowEvent);
            }
        }
        return this;
    }

    public HybridUbcFlow bH(String str, String str2) {
        this.cyn.put(str, str2);
        return this;
    }

    public String nc(String str) {
        return this.cyn.get(str);
    }

    public HybridUbcFlow d(HybridUbcFlow hybridUbcFlow) {
        if (hybridUbcFlow != null) {
            hybridUbcFlow.anM();
            an(hybridUbcFlow.cyq);
            this.cyn.putAll(hybridUbcFlow.cyn);
        }
        return this;
    }

    public HybridUbcFlow r(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.cym.put(str, obj);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return this;
    }

    public JSONObject anB() {
        return this.cym;
    }

    public HybridUbcFlow anC() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naFlowDone");
        }
        this.cyr = true;
        anP();
        return this;
    }

    public HybridUbcFlow anD() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "h5FlowDone");
        }
        this.cys = true;
        anP();
        return this;
    }

    public HybridUbcFlow anE() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "webViewWidgetDone");
        }
        this.cyv = true;
        anP();
        return this;
    }

    public HybridUbcFlow anF() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naPaintFlowDone");
        }
        this.cyt = true;
        anP();
        return this;
    }

    public HybridUbcFlow anG() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "webwidgetPaintDone");
        }
        this.cyu = true;
        anP();
        return this;
    }

    public boolean anH() {
        return this.cyr;
    }

    public boolean anI() {
        return this.cys;
    }

    public boolean anJ() {
        return this.cyt;
    }

    public boolean anK() {
        return this.cyu;
    }

    public boolean anL() {
        return this.cyv;
    }

    private boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.cyo) {
            isEmpty = this.cyo.isEmpty();
        }
        return isEmpty;
    }

    public void anM() {
        UbcFlowEvent ubcFlowEvent;
        synchronized (this.cyo) {
            this.cyq.clear();
            for (String str : this.cyo) {
                if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.cyp.get(str)) != null && ubcFlowEvent.aob() > 0) {
                    this.cyq.add(ubcFlowEvent);
                }
            }
            sort();
        }
    }

    private void sort() {
        Collections.sort(this.cyq, new Comparator<UbcFlowEvent>() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(UbcFlowEvent ubcFlowEvent, UbcFlowEvent ubcFlowEvent2) {
                return Long.compare(ubcFlowEvent.aob(), ubcFlowEvent2.aob());
            }
        });
    }

    public HybridUbcFlow a(SubmitStrategy submitStrategy) {
        if (submitStrategy != null) {
            this.cyy = submitStrategy;
        }
        return this;
    }

    public SubmitStrategy anN() {
        return this.cyy;
    }

    private boolean anO() {
        return (this.cyy == null ? cyx : this.cyy).submitAllowed(this);
    }

    private void anP() {
        if (anO()) {
            anQ();
        }
    }

    private synchronized void anQ() {
        if (!this.cyw) {
            this.cyw = true;
            nd("callback_on_submit");
            p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow.this.anR();
                }
            }, "HybridUbcFlow");
            com.baidu.swan.apps.performance.b.c.aoq();
            if (DEBUG) {
                Log.d("HybridUbcFlow", "UBC submit " + anA() + ", this=" + hashCode(), new Exception());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anR() {
        anM();
        nd("component_reporter");
        if (!TextUtils.isEmpty(this.cyl)) {
            com.baidu.swan.apps.statistic.a pn = com.baidu.swan.apps.statistic.h.pn(this.cyl);
            for (UbcFlowEvent ubcFlowEvent : this.cyq) {
                if (!ubcFlowEvent.aod()) {
                    com.baidu.swan.apps.statistic.b.a(pn, ubcFlowEvent.id, ubcFlowEvent.value(), ubcFlowEvent.aob());
                }
            }
            com.baidu.swan.apps.performance.b.a.ao(this.cyq);
            if (!isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, String> entry : this.cyn.entrySet()) {
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
                com.baidu.swan.apps.statistic.b.a(pn, this.cym.toString());
                com.baidu.swan.apps.statistic.b.c(pn);
            }
        }
    }

    private void nd(String str) {
        List<a> list = this.cyz.get(str);
        if (list != null && !list.isEmpty()) {
            for (a aVar : list) {
                if (aVar != null && aVar.cyD != null) {
                    aVar.cyD.H(this);
                }
            }
        }
    }

    public HybridUbcFlow c(String str, com.baidu.swan.apps.aq.e.b<HybridUbcFlow> bVar) {
        a aVar = new a(str, bVar);
        if (aVar.anT()) {
            synchronized (this.cyz) {
                List<a> list = this.cyz.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                    this.cyz.put(str, list);
                }
                list.add(aVar);
            }
        }
        return this;
    }

    public boolean ne(String str) {
        return this.cyp.get(str) != null;
    }

    public UbcFlowEvent nf(String str) {
        return this.cyp.get(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002f, code lost:
        if (r1 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
        if (r0 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0039, code lost:
        if (r1.aob() < 1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
        if (r0.aob() >= 1) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:?, code lost:
        return r1.aob() - r0.aob();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long r(String... strArr) {
        UbcFlowEvent ubcFlowEvent;
        int length = strArr.length;
        int i = 0;
        UbcFlowEvent ubcFlowEvent2 = null;
        while (true) {
            if (i >= length) {
                ubcFlowEvent = null;
                break;
            }
            ubcFlowEvent = this.cyp.get(strArr[i]);
            if (ubcFlowEvent2 == null) {
                if (ubcFlowEvent == null || ubcFlowEvent.aob() < 1) {
                    break;
                }
            } else if (ubcFlowEvent != null && ubcFlowEvent.aob() > 0) {
                break;
            } else {
                ubcFlowEvent = ubcFlowEvent2;
            }
            i++;
            ubcFlowEvent2 = ubcFlowEvent;
        }
        return -1L;
    }

    public synchronized JSONObject anS() throws JSONException {
        JSONObject jSONObject;
        UbcFlowEvent ubcFlowEvent;
        jSONObject = new JSONObject();
        try {
            String[] strArr = new String[this.cyo.size()];
            this.cyo.toArray(strArr);
            ArrayList<UbcFlowEvent> arrayList = new ArrayList(strArr.length);
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.cyp.get(str)) != null && ubcFlowEvent.aob() > 0) {
                    arrayList.add(ubcFlowEvent);
                }
            }
            Collections.sort(arrayList, new Comparator<UbcFlowEvent>() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(UbcFlowEvent ubcFlowEvent2, UbcFlowEvent ubcFlowEvent3) {
                    return Long.compare(ubcFlowEvent2.aob(), ubcFlowEvent3.aob());
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
            for (Map.Entry<String, String> entry : this.cyn.entrySet()) {
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
            if (this.cym != null && this.cym.length() > 0) {
                jSONObject.put("values", this.cym);
            }
        } catch (Exception e) {
            jSONObject.put("excp", e.getMessage());
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a {
        final com.baidu.swan.apps.aq.e.b<HybridUbcFlow> cyD;
        final String type;

        private a(String str, com.baidu.swan.apps.aq.e.b<HybridUbcFlow> bVar) {
            this.type = str;
            this.cyD = bVar;
        }

        boolean anT() {
            return (this.cyD == null || TextUtils.isEmpty(this.type)) ? false : true;
        }
    }
}
