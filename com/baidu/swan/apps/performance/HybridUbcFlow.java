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
/* loaded from: classes8.dex */
public final class HybridUbcFlow {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final SubmitStrategy dsi = SubmitStrategy.HYBRID;
    private final JSONObject drX = new JSONObject();
    private final Map<String, String> drY = new HashMap();
    public final List<String> drZ = new ArrayList();
    private final Map<String, UbcFlowEvent> dsa = new HashMap();
    public final List<UbcFlowEvent> dsb = new ArrayList();
    private boolean dsc = false;
    private boolean dsd = false;
    private boolean dse = false;
    private boolean dsf = false;
    private boolean dsg = false;
    private volatile boolean dsh = false;
    private SubmitStrategy dsj = dsi;
    private final Map<String, List<a>> dsk = new HashMap();
    private String dsl = "";
    private String mUbcId;
    public final String name;

    /* loaded from: classes8.dex */
    public enum SubmitStrategy {
        HYBRID { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.1
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aDQ() && hybridUbcFlow.aDR() && hybridUbcFlow.aDS();
            }
        },
        HYBRID_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.2
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aDQ() && hybridUbcFlow.aDR() && hybridUbcFlow.aDT();
            }
        },
        RELAUNCH { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.3
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aDQ() && hybridUbcFlow.aDR() && hybridUbcFlow.aDS();
            }
        },
        RELAUNCH_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.4
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aDQ() && hybridUbcFlow.aDR() && hybridUbcFlow.aDT();
            }
        },
        NA_ONLY { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.5
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aDQ();
            }
        },
        ROUTE { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.6
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aDQ() && hybridUbcFlow.aDR();
            }
        },
        ROUTE_NA { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.7
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aDQ();
            }
        },
        ROUTE_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.8
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aDQ() && hybridUbcFlow.aDR() && hybridUbcFlow.aDU();
            }
        },
        VIDEO_NA { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.9
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aDQ();
            }
        };

        abstract boolean submitAllowed(HybridUbcFlow hybridUbcFlow);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HybridUbcFlow(String str) {
        this.name = str;
    }

    public boolean qu(String str) {
        boolean z = false;
        boolean z2 = !TextUtils.isEmpty(str);
        if (TextUtils.isEmpty(this.dsl)) {
            if (z2) {
                str = this.dsl;
            }
            this.dsl = str;
            return true;
        }
        if (!z2 || TextUtils.equals(this.dsl, str)) {
            z = true;
        }
        return z;
    }

    public HybridUbcFlow qv(String str) {
        this.mUbcId = str;
        return this;
    }

    public String getUbcId() {
        return this.mUbcId;
    }

    private void a(UbcFlowEvent ubcFlowEvent) {
        this.drZ.remove(ubcFlowEvent.id);
        this.drZ.add(ubcFlowEvent.id);
        this.dsa.put(ubcFlowEvent.id, ubcFlowEvent);
    }

    private void b(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.dsa.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.aEi() > ubcFlowEvent2.aEi()) {
            a(ubcFlowEvent);
        }
    }

    private void c(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.dsa.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.aEi() < ubcFlowEvent2.aEi()) {
            a(ubcFlowEvent);
        }
    }

    private void d(UbcFlowEvent ubcFlowEvent) {
        if (!e(this.dsa.get(ubcFlowEvent.id))) {
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
            synchronized (this.drZ) {
                switch (ubcFlowEvent.aEl()) {
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

    public HybridUbcFlow aN(List<UbcFlowEvent> list) {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "record events size = " + list.size());
        }
        synchronized (this.drZ) {
            for (UbcFlowEvent ubcFlowEvent : list) {
                f(ubcFlowEvent);
            }
        }
        return this;
    }

    public HybridUbcFlow cg(String str, String str2) {
        this.drY.put(str, str2);
        return this;
    }

    public String qw(String str) {
        return this.drY.get(str);
    }

    public HybridUbcFlow d(HybridUbcFlow hybridUbcFlow) {
        if (hybridUbcFlow != null) {
            hybridUbcFlow.aDV();
            aN(hybridUbcFlow.dsb);
            this.drY.putAll(hybridUbcFlow.drY);
        }
        return this;
    }

    public HybridUbcFlow p(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.drX.put(str, obj);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return this;
    }

    public JSONObject aDK() {
        return this.drX;
    }

    public HybridUbcFlow aDL() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naFlowDone");
        }
        this.dsc = true;
        aDY();
        return this;
    }

    public HybridUbcFlow aDM() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "h5FlowDone");
        }
        this.dsd = true;
        aDY();
        return this;
    }

    public HybridUbcFlow aDN() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "webViewWidgetDone");
        }
        this.dsg = true;
        aDY();
        return this;
    }

    public HybridUbcFlow aDO() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naPaintFlowDone");
        }
        this.dse = true;
        qx("fmp_callback");
        aDY();
        return this;
    }

    public HybridUbcFlow aDP() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "webwidgetPaintDone");
        }
        this.dsf = true;
        aDY();
        return this;
    }

    public boolean aDQ() {
        return this.dsc;
    }

    public boolean aDR() {
        return this.dsd;
    }

    public boolean aDS() {
        return this.dse;
    }

    public boolean aDT() {
        return this.dsf;
    }

    public boolean aDU() {
        return this.dsg;
    }

    private boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.drZ) {
            isEmpty = this.drZ.isEmpty();
        }
        return isEmpty;
    }

    public void aDV() {
        UbcFlowEvent ubcFlowEvent;
        synchronized (this.drZ) {
            this.dsb.clear();
            for (String str : this.drZ) {
                if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.dsa.get(str)) != null && ubcFlowEvent.aEi() > 0) {
                    this.dsb.add(ubcFlowEvent);
                }
            }
            sort();
        }
    }

    private void sort() {
        Collections.sort(this.dsb, new Comparator<UbcFlowEvent>() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(UbcFlowEvent ubcFlowEvent, UbcFlowEvent ubcFlowEvent2) {
                return Long.compare(ubcFlowEvent.aEi(), ubcFlowEvent2.aEi());
            }
        });
    }

    public HybridUbcFlow a(SubmitStrategy submitStrategy) {
        if (submitStrategy != null) {
            this.dsj = submitStrategy;
        }
        return this;
    }

    public SubmitStrategy aDW() {
        return this.dsj;
    }

    private boolean aDX() {
        return (this.dsj == null ? dsi : this.dsj).submitAllowed(this);
    }

    private void aDY() {
        if (aDX()) {
            submit();
        }
    }

    private synchronized void submit() {
        if (!this.dsh) {
            this.dsh = true;
            qx("callback_on_submit");
            p.b(new Runnable() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow.this.aDZ();
                }
            }, "HybridUbcFlow");
            com.baidu.swan.apps.performance.b.d.aED();
            if (DEBUG) {
                Log.d("HybridUbcFlow", "UBC submit " + getUbcId() + ", this=" + hashCode(), new Exception());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDZ() {
        aDV();
        qx("component_reporter");
        if (!TextUtils.isEmpty(this.mUbcId)) {
            com.baidu.swan.apps.statistic.a sP = com.baidu.swan.apps.statistic.h.sP(this.mUbcId);
            for (UbcFlowEvent ubcFlowEvent : this.dsb) {
                if (!ubcFlowEvent.aEk()) {
                    com.baidu.swan.apps.statistic.b.a(sP, ubcFlowEvent.id, ubcFlowEvent.value(), ubcFlowEvent.aEi());
                }
            }
            com.baidu.swan.apps.performance.b.a.aO(this.dsb);
            if (!isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, String> entry : this.drY.entrySet()) {
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
                com.baidu.swan.apps.statistic.b.a(sP, this.drX.toString());
                com.baidu.swan.apps.statistic.b.c(sP);
            }
        }
    }

    private void qx(String str) {
        List<a> list = this.dsk.get(str);
        if (list != null && !list.isEmpty()) {
            for (a aVar : list) {
                if (aVar != null && aVar.dso != null) {
                    aVar.dso.N(this);
                }
            }
        }
    }

    public HybridUbcFlow d(String str, com.baidu.swan.apps.ao.e.b<HybridUbcFlow> bVar) {
        a aVar = new a(str, bVar);
        if (aVar.xP()) {
            synchronized (this.dsk) {
                List<a> list = this.dsk.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                    this.dsk.put(str, list);
                }
                list.add(aVar);
            }
        }
        return this;
    }

    public boolean ox(String str) {
        return this.dsa.get(str) != null;
    }

    public UbcFlowEvent qy(String str) {
        return this.dsa.get(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002f, code lost:
        if (r1 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
        if (r0 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0039, code lost:
        if (r1.aEi() < 1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
        if (r0.aEi() >= 1) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:?, code lost:
        return r1.aEi() - r0.aEi();
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
            ubcFlowEvent = this.dsa.get(strArr[i]);
            if (ubcFlowEvent2 == null) {
                if (ubcFlowEvent == null || ubcFlowEvent.aEi() < 1) {
                    break;
                }
            } else if (ubcFlowEvent != null && ubcFlowEvent.aEi() > 0) {
                break;
            } else {
                ubcFlowEvent = ubcFlowEvent2;
            }
            i++;
            ubcFlowEvent2 = ubcFlowEvent;
        }
        return -1L;
    }

    public synchronized JSONObject aEa() throws JSONException {
        JSONObject jSONObject;
        UbcFlowEvent ubcFlowEvent;
        jSONObject = new JSONObject();
        try {
            String[] strArr = new String[this.drZ.size()];
            this.drZ.toArray(strArr);
            ArrayList<UbcFlowEvent> arrayList = new ArrayList(strArr.length);
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.dsa.get(str)) != null && ubcFlowEvent.aEi() > 0) {
                    arrayList.add(ubcFlowEvent);
                }
            }
            Collections.sort(arrayList, new Comparator<UbcFlowEvent>() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(UbcFlowEvent ubcFlowEvent2, UbcFlowEvent ubcFlowEvent3) {
                    return Long.compare(ubcFlowEvent2.aEi(), ubcFlowEvent3.aEi());
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
            for (Map.Entry<String, String> entry : this.drY.entrySet()) {
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
            if (this.drX != null && this.drX.length() > 0) {
                jSONObject.put("values", this.drX);
            }
        } catch (Exception e) {
            jSONObject.put("excp", e.getMessage());
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a {
        final com.baidu.swan.apps.ao.e.b<HybridUbcFlow> dso;
        final String type;

        private a(String str, com.baidu.swan.apps.ao.e.b<HybridUbcFlow> bVar) {
            this.type = str;
            this.dso = bVar;
        }

        boolean xP() {
            return (this.dso == null || TextUtils.isEmpty(this.type)) ? false : true;
        }
    }
}
