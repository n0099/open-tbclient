package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.aq.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class HybridUbcFlow {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final SubmitStrategy cwj = SubmitStrategy.HYBRID;
    private String cvX;
    private final JSONObject cvY = new JSONObject();
    private final Map<String, String> cvZ = new HashMap();
    public final List<String> cwa = new ArrayList();
    private final Map<String, UbcFlowEvent> cwb = new HashMap();
    public final List<UbcFlowEvent> cwc = new ArrayList();
    private boolean cwd = false;
    private boolean cwe = false;
    private boolean cwf = false;
    private boolean cwg = false;
    private boolean cwh = false;
    private volatile boolean cwi = false;
    private SubmitStrategy cwk = cwj;
    private final Map<String, List<a>> cwl = new HashMap();
    private String cwm = "";
    public final String name;

    /* loaded from: classes11.dex */
    public enum SubmitStrategy {
        HYBRID { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.1
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.amn() && hybridUbcFlow.amo() && hybridUbcFlow.amp();
            }
        },
        HYBRID_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.2
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.amn() && hybridUbcFlow.amo() && hybridUbcFlow.amq();
            }
        },
        RELAUNCH { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.3
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.amn() && hybridUbcFlow.amo() && hybridUbcFlow.amp();
            }
        },
        RELAUNCH_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.4
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.amn() && hybridUbcFlow.amo() && hybridUbcFlow.amq();
            }
        },
        NA_ONLY { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.5
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.amn();
            }
        },
        ROUTE { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.6
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.amn() && hybridUbcFlow.amo();
            }
        },
        ROUTE_NA { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.7
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.amn();
            }
        },
        ROUTE_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.8
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.amn() && hybridUbcFlow.amo() && hybridUbcFlow.amr();
            }
        };

        abstract boolean submitAllowed(HybridUbcFlow hybridUbcFlow);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HybridUbcFlow(String str) {
        this.name = str;
    }

    public boolean mA(String str) {
        boolean z = false;
        boolean z2 = !TextUtils.isEmpty(str);
        if (TextUtils.isEmpty(this.cwm)) {
            if (z2) {
                str = this.cwm;
            }
            this.cwm = str;
            return true;
        }
        if (!z2 || TextUtils.equals(this.cwm, str)) {
            z = true;
        }
        return z;
    }

    public HybridUbcFlow mB(String str) {
        this.cvX = str;
        return this;
    }

    public String amg() {
        return this.cvX;
    }

    private void a(UbcFlowEvent ubcFlowEvent) {
        this.cwa.remove(ubcFlowEvent.id);
        this.cwa.add(ubcFlowEvent.id);
        this.cwb.put(ubcFlowEvent.id, ubcFlowEvent);
    }

    private void b(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.cwb.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.amH() > ubcFlowEvent2.amH()) {
            a(ubcFlowEvent);
        }
    }

    private void c(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.cwb.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.amH() < ubcFlowEvent2.amH()) {
            a(ubcFlowEvent);
        }
    }

    private void d(UbcFlowEvent ubcFlowEvent) {
        if (!e(this.cwb.get(ubcFlowEvent.id))) {
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
            synchronized (this.cwa) {
                switch (ubcFlowEvent.amK()) {
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
        synchronized (this.cwa) {
            for (UbcFlowEvent ubcFlowEvent : list) {
                f(ubcFlowEvent);
            }
        }
        return this;
    }

    public HybridUbcFlow bF(String str, String str2) {
        this.cvZ.put(str, str2);
        return this;
    }

    public String mC(String str) {
        return this.cvZ.get(str);
    }

    public HybridUbcFlow c(HybridUbcFlow hybridUbcFlow) {
        if (hybridUbcFlow != null) {
            hybridUbcFlow.ams();
            an(hybridUbcFlow.cwc);
            this.cvZ.putAll(hybridUbcFlow.cvZ);
        }
        return this;
    }

    public HybridUbcFlow r(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.cvY.put(str, obj);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return this;
    }

    public JSONObject amh() {
        return this.cvY;
    }

    public HybridUbcFlow ami() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naFlowDone");
        }
        this.cwd = true;
        amv();
        return this;
    }

    public HybridUbcFlow amj() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "h5FlowDone");
        }
        this.cwe = true;
        amv();
        return this;
    }

    public HybridUbcFlow amk() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "webViewWidgetDone");
        }
        this.cwh = true;
        amv();
        return this;
    }

    public HybridUbcFlow aml() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naPaintFlowDone");
        }
        this.cwf = true;
        amv();
        return this;
    }

    public HybridUbcFlow amm() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "webwidgetPaintDone");
        }
        this.cwg = true;
        amv();
        return this;
    }

    public boolean amn() {
        return this.cwd;
    }

    public boolean amo() {
        return this.cwe;
    }

    public boolean amp() {
        return this.cwf;
    }

    public boolean amq() {
        return this.cwg;
    }

    public boolean amr() {
        return this.cwh;
    }

    private boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.cwa) {
            isEmpty = this.cwa.isEmpty();
        }
        return isEmpty;
    }

    public void ams() {
        UbcFlowEvent ubcFlowEvent;
        synchronized (this.cwa) {
            this.cwc.clear();
            for (String str : this.cwa) {
                if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.cwb.get(str)) != null && ubcFlowEvent.amH() > 0) {
                    this.cwc.add(ubcFlowEvent);
                }
            }
            sort();
        }
    }

    private void sort() {
        Collections.sort(this.cwc, new Comparator<UbcFlowEvent>() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(UbcFlowEvent ubcFlowEvent, UbcFlowEvent ubcFlowEvent2) {
                return Long.compare(ubcFlowEvent.amH(), ubcFlowEvent2.amH());
            }
        });
    }

    public HybridUbcFlow a(SubmitStrategy submitStrategy) {
        if (submitStrategy != null) {
            this.cwk = submitStrategy;
        }
        return this;
    }

    public SubmitStrategy amt() {
        return this.cwk;
    }

    private boolean amu() {
        return (this.cwk == null ? cwj : this.cwk).submitAllowed(this);
    }

    private void amv() {
        if (amu()) {
            amw();
        }
    }

    private synchronized void amw() {
        if (!this.cwi) {
            this.cwi = true;
            mD("callback_on_submit");
            n.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow.this.amx();
                }
            }, "HybridUbcFlow");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amx() {
        ams();
        mD("component_reporter");
        if (!TextUtils.isEmpty(this.cvX)) {
            com.baidu.swan.apps.statistic.a oE = com.baidu.swan.apps.statistic.h.oE(this.cvX);
            for (UbcFlowEvent ubcFlowEvent : this.cwc) {
                if (!ubcFlowEvent.amJ()) {
                    com.baidu.swan.apps.statistic.b.a(oE, ubcFlowEvent.id, ubcFlowEvent.value(), ubcFlowEvent.amH());
                }
            }
            com.baidu.swan.apps.performance.b.a.ao(this.cwc);
            if (!isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, String> entry : this.cvZ.entrySet()) {
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
                com.baidu.swan.apps.statistic.b.a(oE, this.cvY.toString());
                com.baidu.swan.apps.statistic.b.c(oE);
            }
        }
    }

    private void mD(String str) {
        List<a> list = this.cwl.get(str);
        if (list != null && !list.isEmpty()) {
            for (a aVar : list) {
                if (aVar != null && aVar.cwp != null) {
                    aVar.cwp.H(this);
                }
            }
        }
    }

    public HybridUbcFlow c(String str, com.baidu.swan.apps.aq.e.b<HybridUbcFlow> bVar) {
        a aVar = new a(str, bVar);
        if (aVar.amz()) {
            synchronized (this.cwl) {
                List<a> list = this.cwl.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                    this.cwl.put(str, list);
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
        if (r1.amH() < 1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
        if (r0.amH() >= 1) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:?, code lost:
        return r1.amH() - r0.amH();
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
            ubcFlowEvent = this.cwb.get(strArr[i]);
            if (ubcFlowEvent2 == null) {
                if (ubcFlowEvent == null || ubcFlowEvent.amH() < 1) {
                    break;
                }
            } else if (ubcFlowEvent != null && ubcFlowEvent.amH() > 0) {
                break;
            } else {
                ubcFlowEvent = ubcFlowEvent2;
            }
            i++;
            ubcFlowEvent2 = ubcFlowEvent;
        }
        return -1L;
    }

    public synchronized JSONObject amy() throws JSONException {
        JSONObject jSONObject;
        UbcFlowEvent ubcFlowEvent;
        jSONObject = new JSONObject();
        try {
            String[] strArr = new String[this.cwa.size()];
            this.cwa.toArray(strArr);
            ArrayList<UbcFlowEvent> arrayList = new ArrayList(strArr.length);
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.cwb.get(str)) != null && ubcFlowEvent.amH() > 0) {
                    arrayList.add(ubcFlowEvent);
                }
            }
            Collections.sort(arrayList, new Comparator<UbcFlowEvent>() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(UbcFlowEvent ubcFlowEvent2, UbcFlowEvent ubcFlowEvent3) {
                    return Long.compare(ubcFlowEvent2.amH(), ubcFlowEvent3.amH());
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
            for (Map.Entry<String, String> entry : this.cvZ.entrySet()) {
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
            if (this.cvY != null && this.cvY.length() > 0) {
                jSONObject.put("values", this.cvY);
            }
        } catch (Exception e) {
            jSONObject.put("excp", e.getMessage());
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a {
        final com.baidu.swan.apps.aq.e.b<HybridUbcFlow> cwp;
        final String type;

        private a(String str, com.baidu.swan.apps.aq.e.b<HybridUbcFlow> bVar) {
            this.type = str;
            this.cwp = bVar;
        }

        boolean amz() {
            return (this.cwp == null || TextUtils.isEmpty(this.type)) ? false : true;
        }
    }
}
