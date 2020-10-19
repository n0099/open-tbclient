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
    public static final SubmitStrategy cUy = SubmitStrategy.HYBRID;
    private String cUm;
    public final String name;
    private final JSONObject cUn = new JSONObject();
    private final Map<String, String> cUo = new HashMap();
    public final List<String> cUp = new ArrayList();
    private final Map<String, UbcFlowEvent> cUq = new HashMap();
    public final List<UbcFlowEvent> cUr = new ArrayList();
    private boolean cUs = false;
    private boolean cUt = false;
    private boolean cUu = false;
    private boolean cUv = false;
    private boolean cUw = false;
    private volatile boolean cUx = false;
    private SubmitStrategy cUz = cUy;
    private final Map<String, List<a>> cUA = new HashMap();
    private String cUB = "";

    /* loaded from: classes10.dex */
    public enum SubmitStrategy {
        HYBRID { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.1
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.ayW() && hybridUbcFlow.ayX() && hybridUbcFlow.ayY();
            }
        },
        HYBRID_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.2
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.ayW() && hybridUbcFlow.ayX() && hybridUbcFlow.ayZ();
            }
        },
        RELAUNCH { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.3
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.ayW() && hybridUbcFlow.ayX() && hybridUbcFlow.ayY();
            }
        },
        RELAUNCH_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.4
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.ayW() && hybridUbcFlow.ayX() && hybridUbcFlow.ayZ();
            }
        },
        NA_ONLY { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.5
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.ayW();
            }
        },
        ROUTE { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.6
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.ayW() && hybridUbcFlow.ayX();
            }
        },
        ROUTE_NA { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.7
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.ayW();
            }
        },
        ROUTE_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.8
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.ayW() && hybridUbcFlow.ayX() && hybridUbcFlow.aza();
            }
        },
        VIDEO_NA { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.9
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.ayW();
            }
        };

        abstract boolean submitAllowed(HybridUbcFlow hybridUbcFlow);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HybridUbcFlow(String str) {
        this.name = str;
    }

    public boolean qf(String str) {
        boolean z = false;
        boolean z2 = !TextUtils.isEmpty(str);
        if (TextUtils.isEmpty(this.cUB)) {
            if (z2) {
                str = this.cUB;
            }
            this.cUB = str;
            return true;
        }
        if (!z2 || TextUtils.equals(this.cUB, str)) {
            z = true;
        }
        return z;
    }

    public HybridUbcFlow qg(String str) {
        this.cUm = str;
        return this;
    }

    public String ayP() {
        return this.cUm;
    }

    private void a(UbcFlowEvent ubcFlowEvent) {
        this.cUp.remove(ubcFlowEvent.id);
        this.cUp.add(ubcFlowEvent.id);
        this.cUq.put(ubcFlowEvent.id, ubcFlowEvent);
    }

    private void b(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.cUq.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.azq() > ubcFlowEvent2.azq()) {
            a(ubcFlowEvent);
        }
    }

    private void c(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.cUq.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.azq() < ubcFlowEvent2.azq()) {
            a(ubcFlowEvent);
        }
    }

    private void d(UbcFlowEvent ubcFlowEvent) {
        if (!e(this.cUq.get(ubcFlowEvent.id))) {
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
            synchronized (this.cUp) {
                switch (ubcFlowEvent.azt()) {
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

    public HybridUbcFlow av(List<UbcFlowEvent> list) {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "record events size = " + list.size());
        }
        synchronized (this.cUp) {
            for (UbcFlowEvent ubcFlowEvent : list) {
                f(ubcFlowEvent);
            }
        }
        return this;
    }

    public HybridUbcFlow cb(String str, String str2) {
        this.cUo.put(str, str2);
        return this;
    }

    public String qh(String str) {
        return this.cUo.get(str);
    }

    public HybridUbcFlow d(HybridUbcFlow hybridUbcFlow) {
        if (hybridUbcFlow != null) {
            hybridUbcFlow.azb();
            av(hybridUbcFlow.cUr);
            this.cUo.putAll(hybridUbcFlow.cUo);
        }
        return this;
    }

    public HybridUbcFlow r(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.cUn.put(str, obj);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return this;
    }

    public JSONObject ayQ() {
        return this.cUn;
    }

    public HybridUbcFlow ayR() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naFlowDone");
        }
        this.cUs = true;
        aze();
        return this;
    }

    public HybridUbcFlow ayS() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "h5FlowDone");
        }
        this.cUt = true;
        aze();
        return this;
    }

    public HybridUbcFlow ayT() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "webViewWidgetDone");
        }
        this.cUw = true;
        aze();
        return this;
    }

    public HybridUbcFlow ayU() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naPaintFlowDone");
        }
        this.cUu = true;
        qi("fmp_callback");
        aze();
        return this;
    }

    public HybridUbcFlow ayV() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "webwidgetPaintDone");
        }
        this.cUv = true;
        aze();
        return this;
    }

    public boolean ayW() {
        return this.cUs;
    }

    public boolean ayX() {
        return this.cUt;
    }

    public boolean ayY() {
        return this.cUu;
    }

    public boolean ayZ() {
        return this.cUv;
    }

    public boolean aza() {
        return this.cUw;
    }

    private boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.cUp) {
            isEmpty = this.cUp.isEmpty();
        }
        return isEmpty;
    }

    public void azb() {
        UbcFlowEvent ubcFlowEvent;
        synchronized (this.cUp) {
            this.cUr.clear();
            for (String str : this.cUp) {
                if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.cUq.get(str)) != null && ubcFlowEvent.azq() > 0) {
                    this.cUr.add(ubcFlowEvent);
                }
            }
            sort();
        }
    }

    private void sort() {
        Collections.sort(this.cUr, new Comparator<UbcFlowEvent>() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(UbcFlowEvent ubcFlowEvent, UbcFlowEvent ubcFlowEvent2) {
                return Long.compare(ubcFlowEvent.azq(), ubcFlowEvent2.azq());
            }
        });
    }

    public HybridUbcFlow a(SubmitStrategy submitStrategy) {
        if (submitStrategy != null) {
            this.cUz = submitStrategy;
        }
        return this;
    }

    public SubmitStrategy azc() {
        return this.cUz;
    }

    private boolean azd() {
        return (this.cUz == null ? cUy : this.cUz).submitAllowed(this);
    }

    private void aze() {
        if (azd()) {
            azf();
        }
    }

    private synchronized void azf() {
        if (!this.cUx) {
            this.cUx = true;
            qi("callback_on_submit");
            p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow.this.azg();
                }
            }, "HybridUbcFlow");
            com.baidu.swan.apps.performance.b.d.azL();
            if (DEBUG) {
                Log.d("HybridUbcFlow", "UBC submit " + ayP() + ", this=" + hashCode(), new Exception());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azg() {
        azb();
        qi("component_reporter");
        if (!TextUtils.isEmpty(this.cUm)) {
            com.baidu.swan.apps.statistic.a su = com.baidu.swan.apps.statistic.h.su(this.cUm);
            for (UbcFlowEvent ubcFlowEvent : this.cUr) {
                if (!ubcFlowEvent.azs()) {
                    com.baidu.swan.apps.statistic.b.a(su, ubcFlowEvent.id, ubcFlowEvent.value(), ubcFlowEvent.azq());
                }
            }
            com.baidu.swan.apps.performance.b.a.aw(this.cUr);
            if (!isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, String> entry : this.cUo.entrySet()) {
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
                com.baidu.swan.apps.statistic.b.a(su, this.cUn.toString());
                com.baidu.swan.apps.statistic.b.c(su);
            }
        }
    }

    private void qi(String str) {
        List<a> list = this.cUA.get(str);
        if (list != null && !list.isEmpty()) {
            for (a aVar : list) {
                if (aVar != null && aVar.cUE != null) {
                    aVar.cUE.M(this);
                }
            }
        }
    }

    public HybridUbcFlow d(String str, com.baidu.swan.apps.ap.e.b<HybridUbcFlow> bVar) {
        a aVar = new a(str, bVar);
        if (aVar.azi()) {
            synchronized (this.cUA) {
                List<a> list = this.cUA.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                    this.cUA.put(str, list);
                }
                list.add(aVar);
            }
        }
        return this;
    }

    public boolean oh(String str) {
        return this.cUq.get(str) != null;
    }

    public UbcFlowEvent qj(String str) {
        return this.cUq.get(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002f, code lost:
        if (r1 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
        if (r0 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0039, code lost:
        if (r1.azq() < 1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
        if (r0.azq() >= 1) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:?, code lost:
        return r1.azq() - r0.azq();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long t(String... strArr) {
        UbcFlowEvent ubcFlowEvent;
        int length = strArr.length;
        int i = 0;
        UbcFlowEvent ubcFlowEvent2 = null;
        while (true) {
            if (i >= length) {
                ubcFlowEvent = null;
                break;
            }
            ubcFlowEvent = this.cUq.get(strArr[i]);
            if (ubcFlowEvent2 == null) {
                if (ubcFlowEvent == null || ubcFlowEvent.azq() < 1) {
                    break;
                }
            } else if (ubcFlowEvent != null && ubcFlowEvent.azq() > 0) {
                break;
            } else {
                ubcFlowEvent = ubcFlowEvent2;
            }
            i++;
            ubcFlowEvent2 = ubcFlowEvent;
        }
        return -1L;
    }

    public synchronized JSONObject azh() throws JSONException {
        JSONObject jSONObject;
        UbcFlowEvent ubcFlowEvent;
        jSONObject = new JSONObject();
        try {
            String[] strArr = new String[this.cUp.size()];
            this.cUp.toArray(strArr);
            ArrayList<UbcFlowEvent> arrayList = new ArrayList(strArr.length);
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.cUq.get(str)) != null && ubcFlowEvent.azq() > 0) {
                    arrayList.add(ubcFlowEvent);
                }
            }
            Collections.sort(arrayList, new Comparator<UbcFlowEvent>() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(UbcFlowEvent ubcFlowEvent2, UbcFlowEvent ubcFlowEvent3) {
                    return Long.compare(ubcFlowEvent2.azq(), ubcFlowEvent3.azq());
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
            for (Map.Entry<String, String> entry : this.cUo.entrySet()) {
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
            if (this.cUn != null && this.cUn.length() > 0) {
                jSONObject.put("values", this.cUn);
            }
        } catch (Exception e) {
            jSONObject.put("excp", e.getMessage());
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a {
        final com.baidu.swan.apps.ap.e.b<HybridUbcFlow> cUE;
        final String type;

        private a(String str, com.baidu.swan.apps.ap.e.b<HybridUbcFlow> bVar) {
            this.type = str;
            this.cUE = bVar;
        }

        boolean azi() {
            return (this.cUE == null || TextUtils.isEmpty(this.type)) ? false : true;
        }
    }
}
