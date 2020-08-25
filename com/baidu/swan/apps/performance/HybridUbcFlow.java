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
/* loaded from: classes8.dex */
public final class HybridUbcFlow {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final SubmitStrategy cGr = SubmitStrategy.HYBRID;
    private String cGf;
    private final JSONObject cGg = new JSONObject();
    private final Map<String, String> cGh = new HashMap();
    public final List<String> cGi = new ArrayList();
    private final Map<String, UbcFlowEvent> cGj = new HashMap();
    public final List<UbcFlowEvent> cGk = new ArrayList();
    private boolean cGl = false;
    private boolean cGm = false;
    private boolean cGn = false;
    private boolean cGo = false;
    private boolean cGp = false;
    private volatile boolean cGq = false;
    private SubmitStrategy cGs = cGr;
    private final Map<String, List<a>> cGt = new HashMap();
    private String cGu = "";
    public final String name;

    /* loaded from: classes8.dex */
    public enum SubmitStrategy {
        HYBRID { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.1
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.avC() && hybridUbcFlow.avD() && hybridUbcFlow.avE();
            }
        },
        HYBRID_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.2
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.avC() && hybridUbcFlow.avD() && hybridUbcFlow.avF();
            }
        },
        RELAUNCH { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.3
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.avC() && hybridUbcFlow.avD() && hybridUbcFlow.avE();
            }
        },
        RELAUNCH_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.4
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.avC() && hybridUbcFlow.avD() && hybridUbcFlow.avF();
            }
        },
        NA_ONLY { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.5
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.avC();
            }
        },
        ROUTE { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.6
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.avC() && hybridUbcFlow.avD();
            }
        },
        ROUTE_NA { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.7
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.avC();
            }
        },
        ROUTE_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.8
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.avC() && hybridUbcFlow.avD() && hybridUbcFlow.avG();
            }
        },
        VIDEO_NA { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.9
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.avC();
            }
        };

        abstract boolean submitAllowed(HybridUbcFlow hybridUbcFlow);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HybridUbcFlow(String str) {
        this.name = str;
    }

    public boolean oZ(String str) {
        boolean z = false;
        boolean z2 = !TextUtils.isEmpty(str);
        if (TextUtils.isEmpty(this.cGu)) {
            if (z2) {
                str = this.cGu;
            }
            this.cGu = str;
            return true;
        }
        if (!z2 || TextUtils.equals(this.cGu, str)) {
            z = true;
        }
        return z;
    }

    public HybridUbcFlow pa(String str) {
        this.cGf = str;
        return this;
    }

    public String avv() {
        return this.cGf;
    }

    private void a(UbcFlowEvent ubcFlowEvent) {
        this.cGi.remove(ubcFlowEvent.id);
        this.cGi.add(ubcFlowEvent.id);
        this.cGj.put(ubcFlowEvent.id, ubcFlowEvent);
    }

    private void b(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.cGj.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.avW() > ubcFlowEvent2.avW()) {
            a(ubcFlowEvent);
        }
    }

    private void c(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.cGj.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.avW() < ubcFlowEvent2.avW()) {
            a(ubcFlowEvent);
        }
    }

    private void d(UbcFlowEvent ubcFlowEvent) {
        if (!e(this.cGj.get(ubcFlowEvent.id))) {
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
            synchronized (this.cGi) {
                switch (ubcFlowEvent.avZ()) {
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

    public HybridUbcFlow ao(List<UbcFlowEvent> list) {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "record events size = " + list.size());
        }
        synchronized (this.cGi) {
            for (UbcFlowEvent ubcFlowEvent : list) {
                f(ubcFlowEvent);
            }
        }
        return this;
    }

    public HybridUbcFlow bW(String str, String str2) {
        this.cGh.put(str, str2);
        return this;
    }

    public String pb(String str) {
        return this.cGh.get(str);
    }

    public HybridUbcFlow d(HybridUbcFlow hybridUbcFlow) {
        if (hybridUbcFlow != null) {
            hybridUbcFlow.avH();
            ao(hybridUbcFlow.cGk);
            this.cGh.putAll(hybridUbcFlow.cGh);
        }
        return this;
    }

    public HybridUbcFlow r(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.cGg.put(str, obj);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return this;
    }

    public JSONObject avw() {
        return this.cGg;
    }

    public HybridUbcFlow avx() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naFlowDone");
        }
        this.cGl = true;
        avK();
        return this;
    }

    public HybridUbcFlow avy() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "h5FlowDone");
        }
        this.cGm = true;
        avK();
        return this;
    }

    public HybridUbcFlow avz() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "webViewWidgetDone");
        }
        this.cGp = true;
        avK();
        return this;
    }

    public HybridUbcFlow avA() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naPaintFlowDone");
        }
        this.cGn = true;
        pc("fmp_callback");
        avK();
        return this;
    }

    public HybridUbcFlow avB() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "webwidgetPaintDone");
        }
        this.cGo = true;
        avK();
        return this;
    }

    public boolean avC() {
        return this.cGl;
    }

    public boolean avD() {
        return this.cGm;
    }

    public boolean avE() {
        return this.cGn;
    }

    public boolean avF() {
        return this.cGo;
    }

    public boolean avG() {
        return this.cGp;
    }

    private boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.cGi) {
            isEmpty = this.cGi.isEmpty();
        }
        return isEmpty;
    }

    public void avH() {
        UbcFlowEvent ubcFlowEvent;
        synchronized (this.cGi) {
            this.cGk.clear();
            for (String str : this.cGi) {
                if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.cGj.get(str)) != null && ubcFlowEvent.avW() > 0) {
                    this.cGk.add(ubcFlowEvent);
                }
            }
            sort();
        }
    }

    private void sort() {
        Collections.sort(this.cGk, new Comparator<UbcFlowEvent>() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(UbcFlowEvent ubcFlowEvent, UbcFlowEvent ubcFlowEvent2) {
                return Long.compare(ubcFlowEvent.avW(), ubcFlowEvent2.avW());
            }
        });
    }

    public HybridUbcFlow a(SubmitStrategy submitStrategy) {
        if (submitStrategy != null) {
            this.cGs = submitStrategy;
        }
        return this;
    }

    public SubmitStrategy avI() {
        return this.cGs;
    }

    private boolean avJ() {
        return (this.cGs == null ? cGr : this.cGs).submitAllowed(this);
    }

    private void avK() {
        if (avJ()) {
            avL();
        }
    }

    private synchronized void avL() {
        if (!this.cGq) {
            this.cGq = true;
            pc("callback_on_submit");
            p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow.this.avM();
                }
            }, "HybridUbcFlow");
            com.baidu.swan.apps.performance.b.d.awr();
            if (DEBUG) {
                Log.d("HybridUbcFlow", "UBC submit " + avv() + ", this=" + hashCode(), new Exception());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avM() {
        avH();
        pc("component_reporter");
        if (!TextUtils.isEmpty(this.cGf)) {
            com.baidu.swan.apps.statistic.a rn = com.baidu.swan.apps.statistic.h.rn(this.cGf);
            for (UbcFlowEvent ubcFlowEvent : this.cGk) {
                if (!ubcFlowEvent.avY()) {
                    com.baidu.swan.apps.statistic.b.a(rn, ubcFlowEvent.id, ubcFlowEvent.value(), ubcFlowEvent.avW());
                }
            }
            com.baidu.swan.apps.performance.b.a.ap(this.cGk);
            if (!isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, String> entry : this.cGh.entrySet()) {
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
                com.baidu.swan.apps.statistic.b.a(rn, this.cGg.toString());
                com.baidu.swan.apps.statistic.b.c(rn);
            }
        }
    }

    private void pc(String str) {
        List<a> list = this.cGt.get(str);
        if (list != null && !list.isEmpty()) {
            for (a aVar : list) {
                if (aVar != null && aVar.cGx != null) {
                    aVar.cGx.I(this);
                }
            }
        }
    }

    public HybridUbcFlow d(String str, com.baidu.swan.apps.ap.e.b<HybridUbcFlow> bVar) {
        a aVar = new a(str, bVar);
        if (aVar.avO()) {
            synchronized (this.cGt) {
                List<a> list = this.cGt.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                    this.cGt.put(str, list);
                }
                list.add(aVar);
            }
        }
        return this;
    }

    public boolean na(String str) {
        return this.cGj.get(str) != null;
    }

    public UbcFlowEvent pd(String str) {
        return this.cGj.get(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002f, code lost:
        if (r1 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
        if (r0 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0039, code lost:
        if (r1.avW() < 1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
        if (r0.avW() >= 1) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:?, code lost:
        return r1.avW() - r0.avW();
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
            ubcFlowEvent = this.cGj.get(strArr[i]);
            if (ubcFlowEvent2 == null) {
                if (ubcFlowEvent == null || ubcFlowEvent.avW() < 1) {
                    break;
                }
            } else if (ubcFlowEvent != null && ubcFlowEvent.avW() > 0) {
                break;
            } else {
                ubcFlowEvent = ubcFlowEvent2;
            }
            i++;
            ubcFlowEvent2 = ubcFlowEvent;
        }
        return -1L;
    }

    public synchronized JSONObject avN() throws JSONException {
        JSONObject jSONObject;
        UbcFlowEvent ubcFlowEvent;
        jSONObject = new JSONObject();
        try {
            String[] strArr = new String[this.cGi.size()];
            this.cGi.toArray(strArr);
            ArrayList<UbcFlowEvent> arrayList = new ArrayList(strArr.length);
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.cGj.get(str)) != null && ubcFlowEvent.avW() > 0) {
                    arrayList.add(ubcFlowEvent);
                }
            }
            Collections.sort(arrayList, new Comparator<UbcFlowEvent>() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(UbcFlowEvent ubcFlowEvent2, UbcFlowEvent ubcFlowEvent3) {
                    return Long.compare(ubcFlowEvent2.avW(), ubcFlowEvent3.avW());
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
            for (Map.Entry<String, String> entry : this.cGh.entrySet()) {
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
            if (this.cGg != null && this.cGg.length() > 0) {
                jSONObject.put("values", this.cGg);
            }
        } catch (Exception e) {
            jSONObject.put("excp", e.getMessage());
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a {
        final com.baidu.swan.apps.ap.e.b<HybridUbcFlow> cGx;
        final String type;

        private a(String str, com.baidu.swan.apps.ap.e.b<HybridUbcFlow> bVar) {
            this.type = str;
            this.cGx = bVar;
        }

        boolean avO() {
            return (this.cGx == null || TextUtils.isEmpty(this.type)) ? false : true;
        }
    }
}
