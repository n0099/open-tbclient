package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ao.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class HybridUbcFlow {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final SubmitStrategy dtk = SubmitStrategy.HYBRID;
    private final JSONObject dsZ = new JSONObject();
    private final Map<String, String> dta = new HashMap();
    public final List<String> dtb = new ArrayList();
    private final Map<String, UbcFlowEvent> dtc = new HashMap();
    public final List<UbcFlowEvent> dtd = new ArrayList();
    private boolean dte = false;
    private boolean dtf = false;
    private boolean dtg = false;
    private boolean dth = false;
    private boolean dti = false;
    private volatile boolean dtj = false;
    private SubmitStrategy dtl = dtk;
    private final Map<String, List<a>> dtm = new HashMap();
    private String dtn = "";
    private String mUbcId;
    public final String name;

    /* loaded from: classes9.dex */
    public enum SubmitStrategy {
        HYBRID { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.1
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aHk() && hybridUbcFlow.aHl() && hybridUbcFlow.aHm();
            }
        },
        HYBRID_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.2
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aHk() && hybridUbcFlow.aHl() && hybridUbcFlow.aHn();
            }
        },
        RELAUNCH { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.3
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aHk() && hybridUbcFlow.aHl() && hybridUbcFlow.aHm();
            }
        },
        RELAUNCH_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.4
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aHk() && hybridUbcFlow.aHl() && hybridUbcFlow.aHn();
            }
        },
        NA_ONLY { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.5
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aHk();
            }
        },
        ROUTE { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.6
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aHk() && hybridUbcFlow.aHl();
            }
        },
        ROUTE_NA { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.7
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aHk();
            }
        },
        ROUTE_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.8
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aHk() && hybridUbcFlow.aHl() && hybridUbcFlow.aHo();
            }
        },
        VIDEO_NA { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.9
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aHk();
            }
        };

        abstract boolean submitAllowed(HybridUbcFlow hybridUbcFlow);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HybridUbcFlow(String str) {
        this.name = str;
    }

    public boolean rg(String str) {
        boolean z = false;
        boolean z2 = !TextUtils.isEmpty(str);
        if (TextUtils.isEmpty(this.dtn)) {
            if (z2) {
                str = this.dtn;
            }
            this.dtn = str;
            return true;
        }
        if (!z2 || TextUtils.equals(this.dtn, str)) {
            z = true;
        }
        return z;
    }

    public HybridUbcFlow rh(String str) {
        this.mUbcId = str;
        return this;
    }

    public String getUbcId() {
        return this.mUbcId;
    }

    private void a(UbcFlowEvent ubcFlowEvent) {
        this.dtb.remove(ubcFlowEvent.id);
        this.dtb.add(ubcFlowEvent.id);
        this.dtc.put(ubcFlowEvent.id, ubcFlowEvent);
    }

    private void b(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.dtc.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.aHD() > ubcFlowEvent2.aHD()) {
            a(ubcFlowEvent);
        }
    }

    private void c(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.dtc.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.aHD() < ubcFlowEvent2.aHD()) {
            a(ubcFlowEvent);
        }
    }

    private void d(UbcFlowEvent ubcFlowEvent) {
        if (!e(this.dtc.get(ubcFlowEvent.id))) {
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
            synchronized (this.dtb) {
                switch (ubcFlowEvent.aHG()) {
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

    public HybridUbcFlow aS(List<UbcFlowEvent> list) {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "record events size = " + list.size());
        }
        synchronized (this.dtb) {
            for (UbcFlowEvent ubcFlowEvent : list) {
                f(ubcFlowEvent);
            }
        }
        return this;
    }

    public HybridUbcFlow cn(String str, String str2) {
        this.dta.put(str, str2);
        return this;
    }

    public String ri(String str) {
        return this.dta.get(str);
    }

    public HybridUbcFlow d(HybridUbcFlow hybridUbcFlow) {
        if (hybridUbcFlow != null) {
            hybridUbcFlow.aHp();
            aS(hybridUbcFlow.dtd);
            this.dta.putAll(hybridUbcFlow.dta);
        }
        return this;
    }

    public HybridUbcFlow q(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.dsZ.put(str, obj);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return this;
    }

    public JSONObject aHe() {
        return this.dsZ;
    }

    public HybridUbcFlow aHf() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naFlowDone");
        }
        this.dte = true;
        aHs();
        return this;
    }

    public HybridUbcFlow aHg() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "h5FlowDone");
        }
        this.dtf = true;
        aHs();
        return this;
    }

    public HybridUbcFlow aHh() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "webViewWidgetDone");
        }
        this.dti = true;
        aHs();
        return this;
    }

    public HybridUbcFlow aHi() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naPaintFlowDone");
        }
        this.dtg = true;
        rj("fmp_callback");
        aHs();
        return this;
    }

    public HybridUbcFlow aHj() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "webwidgetPaintDone");
        }
        this.dth = true;
        aHs();
        return this;
    }

    public boolean aHk() {
        return this.dte;
    }

    public boolean aHl() {
        return this.dtf;
    }

    public boolean aHm() {
        return this.dtg;
    }

    public boolean aHn() {
        return this.dth;
    }

    public boolean aHo() {
        return this.dti;
    }

    private boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.dtb) {
            isEmpty = this.dtb.isEmpty();
        }
        return isEmpty;
    }

    public void aHp() {
        UbcFlowEvent ubcFlowEvent;
        synchronized (this.dtb) {
            this.dtd.clear();
            for (String str : this.dtb) {
                if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.dtc.get(str)) != null && ubcFlowEvent.aHD() > 0) {
                    this.dtd.add(ubcFlowEvent);
                }
            }
            sort();
        }
    }

    private void sort() {
        Collections.sort(this.dtd, new Comparator<UbcFlowEvent>() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(UbcFlowEvent ubcFlowEvent, UbcFlowEvent ubcFlowEvent2) {
                return Long.compare(ubcFlowEvent.aHD(), ubcFlowEvent2.aHD());
            }
        });
    }

    public HybridUbcFlow a(SubmitStrategy submitStrategy) {
        if (submitStrategy != null) {
            this.dtl = submitStrategy;
        }
        return this;
    }

    public SubmitStrategy aHq() {
        return this.dtl;
    }

    private boolean aHr() {
        return (this.dtl == null ? dtk : this.dtl).submitAllowed(this);
    }

    private void aHs() {
        if (aHr()) {
            submit();
        }
    }

    private synchronized void submit() {
        if (!this.dtj) {
            this.dtj = true;
            rj("callback_on_submit");
            p.b(new Runnable() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow.this.aHt();
                }
            }, "HybridUbcFlow");
            com.baidu.swan.apps.performance.b.d.aHY();
            if (DEBUG) {
                Log.d("HybridUbcFlow", "UBC submit " + getUbcId() + ", this=" + hashCode(), new Exception());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHt() {
        aHp();
        rj("component_reporter");
        if (!TextUtils.isEmpty(this.mUbcId)) {
            com.baidu.swan.apps.statistic.a tA = com.baidu.swan.apps.statistic.h.tA(this.mUbcId);
            for (UbcFlowEvent ubcFlowEvent : this.dtd) {
                if (!ubcFlowEvent.aHF()) {
                    com.baidu.swan.apps.statistic.b.a(tA, ubcFlowEvent.id, ubcFlowEvent.value(), ubcFlowEvent.aHD());
                }
            }
            com.baidu.swan.apps.performance.b.a.aT(this.dtd);
            if (!isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, String> entry : this.dta.entrySet()) {
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
                com.baidu.swan.apps.statistic.b.a(tA, this.dsZ.toString());
                com.baidu.swan.apps.statistic.b.c(tA);
            }
        }
    }

    private void rj(String str) {
        List<a> list = this.dtm.get(str);
        if (list != null && !list.isEmpty()) {
            for (a aVar : list) {
                if (aVar != null && aVar.dtq != null) {
                    aVar.dtq.L(this);
                }
            }
        }
    }

    public HybridUbcFlow d(String str, com.baidu.swan.apps.ao.e.b<HybridUbcFlow> bVar) {
        a aVar = new a(str, bVar);
        if (aVar.aHv()) {
            synchronized (this.dtm) {
                List<a> list = this.dtm.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                    this.dtm.put(str, list);
                }
                list.add(aVar);
            }
        }
        return this;
    }

    public boolean pj(String str) {
        return this.dtc.get(str) != null;
    }

    public UbcFlowEvent rk(String str) {
        return this.dtc.get(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002f, code lost:
        if (r1 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
        if (r0 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0039, code lost:
        if (r1.aHD() < 1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
        if (r0.aHD() >= 1) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:?, code lost:
        return r1.aHD() - r0.aHD();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long B(String... strArr) {
        UbcFlowEvent ubcFlowEvent;
        int length = strArr.length;
        int i = 0;
        UbcFlowEvent ubcFlowEvent2 = null;
        while (true) {
            if (i >= length) {
                ubcFlowEvent = null;
                break;
            }
            ubcFlowEvent = this.dtc.get(strArr[i]);
            if (ubcFlowEvent2 == null) {
                if (ubcFlowEvent == null || ubcFlowEvent.aHD() < 1) {
                    break;
                }
            } else if (ubcFlowEvent != null && ubcFlowEvent.aHD() > 0) {
                break;
            } else {
                ubcFlowEvent = ubcFlowEvent2;
            }
            i++;
            ubcFlowEvent2 = ubcFlowEvent;
        }
        return -1L;
    }

    public synchronized JSONObject aHu() throws JSONException {
        JSONObject jSONObject;
        UbcFlowEvent ubcFlowEvent;
        jSONObject = new JSONObject();
        try {
            String[] strArr = new String[this.dtb.size()];
            this.dtb.toArray(strArr);
            ArrayList<UbcFlowEvent> arrayList = new ArrayList(strArr.length);
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.dtc.get(str)) != null && ubcFlowEvent.aHD() > 0) {
                    arrayList.add(ubcFlowEvent);
                }
            }
            Collections.sort(arrayList, new Comparator<UbcFlowEvent>() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(UbcFlowEvent ubcFlowEvent2, UbcFlowEvent ubcFlowEvent3) {
                    return Long.compare(ubcFlowEvent2.aHD(), ubcFlowEvent3.aHD());
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
            for (Map.Entry<String, String> entry : this.dta.entrySet()) {
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
            if (this.dsZ != null && this.dsZ.length() > 0) {
                jSONObject.put("values", this.dsZ);
            }
        } catch (Exception e) {
            jSONObject.put("excp", e.getMessage());
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a {
        final com.baidu.swan.apps.ao.e.b<HybridUbcFlow> dtq;
        final String type;

        private a(String str, com.baidu.swan.apps.ao.e.b<HybridUbcFlow> bVar) {
            this.type = str;
            this.dtq = bVar;
        }

        boolean aHv() {
            return (this.dtq == null || TextUtils.isEmpty(this.type)) ? false : true;
        }
    }
}
