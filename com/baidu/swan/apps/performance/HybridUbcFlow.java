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
    public static final SubmitStrategy dqG = SubmitStrategy.HYBRID;
    private String mUbcId;
    public final String name;
    private final JSONObject dqv = new JSONObject();
    private final Map<String, String> dqw = new HashMap();
    public final List<String> dqx = new ArrayList();
    private final Map<String, UbcFlowEvent> dqy = new HashMap();
    public final List<UbcFlowEvent> dqz = new ArrayList();
    private boolean dqA = false;
    private boolean dqB = false;
    private boolean dqC = false;
    private boolean dqD = false;
    private boolean dqE = false;
    private volatile boolean dqF = false;
    private SubmitStrategy dqH = dqG;
    private final Map<String, List<a>> dqI = new HashMap();
    private String dqJ = "";

    /* loaded from: classes9.dex */
    public enum SubmitStrategy {
        HYBRID { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.1
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aDN() && hybridUbcFlow.aDO() && hybridUbcFlow.aDP();
            }
        },
        HYBRID_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.2
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aDN() && hybridUbcFlow.aDO() && hybridUbcFlow.aDQ();
            }
        },
        RELAUNCH { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.3
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aDN() && hybridUbcFlow.aDO() && hybridUbcFlow.aDP();
            }
        },
        RELAUNCH_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.4
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aDN() && hybridUbcFlow.aDO() && hybridUbcFlow.aDQ();
            }
        },
        NA_ONLY { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.5
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aDN();
            }
        },
        ROUTE { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.6
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aDN() && hybridUbcFlow.aDO();
            }
        },
        ROUTE_NA { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.7
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aDN();
            }
        },
        ROUTE_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.8
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aDN() && hybridUbcFlow.aDO() && hybridUbcFlow.aDR();
            }
        },
        VIDEO_NA { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.9
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aDN();
            }
        };

        abstract boolean submitAllowed(HybridUbcFlow hybridUbcFlow);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HybridUbcFlow(String str) {
        this.name = str;
    }

    public boolean qn(String str) {
        boolean z = false;
        boolean z2 = !TextUtils.isEmpty(str);
        if (TextUtils.isEmpty(this.dqJ)) {
            if (z2) {
                str = this.dqJ;
            }
            this.dqJ = str;
            return true;
        }
        if (!z2 || TextUtils.equals(this.dqJ, str)) {
            z = true;
        }
        return z;
    }

    public HybridUbcFlow qo(String str) {
        this.mUbcId = str;
        return this;
    }

    public String getUbcId() {
        return this.mUbcId;
    }

    private void a(UbcFlowEvent ubcFlowEvent) {
        this.dqx.remove(ubcFlowEvent.id);
        this.dqx.add(ubcFlowEvent.id);
        this.dqy.put(ubcFlowEvent.id, ubcFlowEvent);
    }

    private void b(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.dqy.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.aEf() > ubcFlowEvent2.aEf()) {
            a(ubcFlowEvent);
        }
    }

    private void c(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.dqy.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.aEf() < ubcFlowEvent2.aEf()) {
            a(ubcFlowEvent);
        }
    }

    private void d(UbcFlowEvent ubcFlowEvent) {
        if (!e(this.dqy.get(ubcFlowEvent.id))) {
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
            synchronized (this.dqx) {
                switch (ubcFlowEvent.aEi()) {
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
        synchronized (this.dqx) {
            for (UbcFlowEvent ubcFlowEvent : list) {
                f(ubcFlowEvent);
            }
        }
        return this;
    }

    public HybridUbcFlow cg(String str, String str2) {
        this.dqw.put(str, str2);
        return this;
    }

    public String qp(String str) {
        return this.dqw.get(str);
    }

    public HybridUbcFlow d(HybridUbcFlow hybridUbcFlow) {
        if (hybridUbcFlow != null) {
            hybridUbcFlow.aDS();
            aN(hybridUbcFlow.dqz);
            this.dqw.putAll(hybridUbcFlow.dqw);
        }
        return this;
    }

    public HybridUbcFlow o(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.dqv.put(str, obj);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return this;
    }

    public JSONObject aDH() {
        return this.dqv;
    }

    public HybridUbcFlow aDI() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naFlowDone");
        }
        this.dqA = true;
        aDV();
        return this;
    }

    public HybridUbcFlow aDJ() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "h5FlowDone");
        }
        this.dqB = true;
        aDV();
        return this;
    }

    public HybridUbcFlow aDK() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "webViewWidgetDone");
        }
        this.dqE = true;
        aDV();
        return this;
    }

    public HybridUbcFlow aDL() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naPaintFlowDone");
        }
        this.dqC = true;
        qq("fmp_callback");
        aDV();
        return this;
    }

    public HybridUbcFlow aDM() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "webwidgetPaintDone");
        }
        this.dqD = true;
        aDV();
        return this;
    }

    public boolean aDN() {
        return this.dqA;
    }

    public boolean aDO() {
        return this.dqB;
    }

    public boolean aDP() {
        return this.dqC;
    }

    public boolean aDQ() {
        return this.dqD;
    }

    public boolean aDR() {
        return this.dqE;
    }

    private boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.dqx) {
            isEmpty = this.dqx.isEmpty();
        }
        return isEmpty;
    }

    public void aDS() {
        UbcFlowEvent ubcFlowEvent;
        synchronized (this.dqx) {
            this.dqz.clear();
            for (String str : this.dqx) {
                if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.dqy.get(str)) != null && ubcFlowEvent.aEf() > 0) {
                    this.dqz.add(ubcFlowEvent);
                }
            }
            sort();
        }
    }

    private void sort() {
        Collections.sort(this.dqz, new Comparator<UbcFlowEvent>() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(UbcFlowEvent ubcFlowEvent, UbcFlowEvent ubcFlowEvent2) {
                return Long.compare(ubcFlowEvent.aEf(), ubcFlowEvent2.aEf());
            }
        });
    }

    public HybridUbcFlow a(SubmitStrategy submitStrategy) {
        if (submitStrategy != null) {
            this.dqH = submitStrategy;
        }
        return this;
    }

    public SubmitStrategy aDT() {
        return this.dqH;
    }

    private boolean aDU() {
        return (this.dqH == null ? dqG : this.dqH).submitAllowed(this);
    }

    private void aDV() {
        if (aDU()) {
            submit();
        }
    }

    private synchronized void submit() {
        if (!this.dqF) {
            this.dqF = true;
            qq("callback_on_submit");
            p.b(new Runnable() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow.this.aDW();
                }
            }, "HybridUbcFlow");
            com.baidu.swan.apps.performance.b.d.aEA();
            if (DEBUG) {
                Log.d("HybridUbcFlow", "UBC submit " + getUbcId() + ", this=" + hashCode(), new Exception());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDW() {
        aDS();
        qq("component_reporter");
        if (!TextUtils.isEmpty(this.mUbcId)) {
            com.baidu.swan.apps.statistic.a sI = com.baidu.swan.apps.statistic.h.sI(this.mUbcId);
            for (UbcFlowEvent ubcFlowEvent : this.dqz) {
                if (!ubcFlowEvent.aEh()) {
                    com.baidu.swan.apps.statistic.b.a(sI, ubcFlowEvent.id, ubcFlowEvent.value(), ubcFlowEvent.aEf());
                }
            }
            com.baidu.swan.apps.performance.b.a.aO(this.dqz);
            if (!isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, String> entry : this.dqw.entrySet()) {
                        String key = entry.getKey();
                        if (!TextUtils.isEmpty(key)) {
                            String value = entry.getValue();
                            if (value == null) {
                                value = "";
                            }
                            jSONObject.put(key, value);
                        }
                    }
                    o("ext", jSONObject);
                } catch (Exception e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
                com.baidu.swan.apps.statistic.b.a(sI, this.dqv.toString());
                com.baidu.swan.apps.statistic.b.c(sI);
            }
        }
    }

    private void qq(String str) {
        List<a> list = this.dqI.get(str);
        if (list != null && !list.isEmpty()) {
            for (a aVar : list) {
                if (aVar != null && aVar.dqM != null) {
                    aVar.dqM.L(this);
                }
            }
        }
    }

    public HybridUbcFlow d(String str, com.baidu.swan.apps.ao.e.b<HybridUbcFlow> bVar) {
        a aVar = new a(str, bVar);
        if (aVar.xM()) {
            synchronized (this.dqI) {
                List<a> list = this.dqI.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                    this.dqI.put(str, list);
                }
                list.add(aVar);
            }
        }
        return this;
    }

    public boolean oq(String str) {
        return this.dqy.get(str) != null;
    }

    public UbcFlowEvent qr(String str) {
        return this.dqy.get(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002f, code lost:
        if (r1 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
        if (r0 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0039, code lost:
        if (r1.aEf() < 1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
        if (r0.aEf() >= 1) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:?, code lost:
        return r1.aEf() - r0.aEf();
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
            ubcFlowEvent = this.dqy.get(strArr[i]);
            if (ubcFlowEvent2 == null) {
                if (ubcFlowEvent == null || ubcFlowEvent.aEf() < 1) {
                    break;
                }
            } else if (ubcFlowEvent != null && ubcFlowEvent.aEf() > 0) {
                break;
            } else {
                ubcFlowEvent = ubcFlowEvent2;
            }
            i++;
            ubcFlowEvent2 = ubcFlowEvent;
        }
        return -1L;
    }

    public synchronized JSONObject aDX() throws JSONException {
        JSONObject jSONObject;
        UbcFlowEvent ubcFlowEvent;
        jSONObject = new JSONObject();
        try {
            String[] strArr = new String[this.dqx.size()];
            this.dqx.toArray(strArr);
            ArrayList<UbcFlowEvent> arrayList = new ArrayList(strArr.length);
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.dqy.get(str)) != null && ubcFlowEvent.aEf() > 0) {
                    arrayList.add(ubcFlowEvent);
                }
            }
            Collections.sort(arrayList, new Comparator<UbcFlowEvent>() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(UbcFlowEvent ubcFlowEvent2, UbcFlowEvent ubcFlowEvent3) {
                    return Long.compare(ubcFlowEvent2.aEf(), ubcFlowEvent3.aEf());
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
            for (Map.Entry<String, String> entry : this.dqw.entrySet()) {
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
            if (this.dqv != null && this.dqv.length() > 0) {
                jSONObject.put("values", this.dqv);
            }
        } catch (Exception e) {
            jSONObject.put("excp", e.getMessage());
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a {
        final com.baidu.swan.apps.ao.e.b<HybridUbcFlow> dqM;
        final String type;

        private a(String str, com.baidu.swan.apps.ao.e.b<HybridUbcFlow> bVar) {
            this.type = str;
            this.dqM = bVar;
        }

        boolean xM() {
            return (this.dqM == null || TextUtils.isEmpty(this.type)) ? false : true;
        }
    }
}
