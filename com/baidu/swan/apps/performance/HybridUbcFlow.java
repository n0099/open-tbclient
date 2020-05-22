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
    public static final SubmitStrategy crv = SubmitStrategy.HYBRID;
    private String crj;
    private final JSONObject crk = new JSONObject();
    private final Map<String, String> crl = new HashMap();
    public final List<String> crm = new ArrayList();
    private final Map<String, UbcFlowEvent> crn = new HashMap();
    public final List<UbcFlowEvent> cro = new ArrayList();
    private boolean crp = false;
    private boolean crq = false;
    private boolean crr = false;
    private boolean crs = false;
    private boolean crt = false;
    private volatile boolean cru = false;
    private SubmitStrategy crw = crv;
    private final Map<String, List<a>> crx = new HashMap();
    private String cry = "";
    public final String name;

    /* loaded from: classes11.dex */
    public enum SubmitStrategy {
        HYBRID { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.1
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.alh() && hybridUbcFlow.ali() && hybridUbcFlow.alj();
            }
        },
        HYBRID_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.2
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.alh() && hybridUbcFlow.ali() && hybridUbcFlow.alk();
            }
        },
        RELAUNCH { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.3
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.alh() && hybridUbcFlow.ali() && hybridUbcFlow.alj();
            }
        },
        RELAUNCH_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.4
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.alh() && hybridUbcFlow.ali() && hybridUbcFlow.alk();
            }
        },
        NA_ONLY { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.5
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.alh();
            }
        },
        ROUTE { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.6
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.alh() && hybridUbcFlow.ali();
            }
        },
        ROUTE_NA { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.7
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.alh();
            }
        },
        ROUTE_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.8
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.alh() && hybridUbcFlow.ali() && hybridUbcFlow.all();
            }
        };

        abstract boolean submitAllowed(HybridUbcFlow hybridUbcFlow);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HybridUbcFlow(String str) {
        this.name = str;
    }

    public boolean ms(String str) {
        boolean z = false;
        boolean z2 = !TextUtils.isEmpty(str);
        if (TextUtils.isEmpty(this.cry)) {
            if (z2) {
                str = this.cry;
            }
            this.cry = str;
            return true;
        }
        if (!z2 || TextUtils.equals(this.cry, str)) {
            z = true;
        }
        return z;
    }

    public HybridUbcFlow mt(String str) {
        this.crj = str;
        return this;
    }

    public String ala() {
        return this.crj;
    }

    private void a(UbcFlowEvent ubcFlowEvent) {
        this.crm.remove(ubcFlowEvent.id);
        this.crm.add(ubcFlowEvent.id);
        this.crn.put(ubcFlowEvent.id, ubcFlowEvent);
    }

    private void b(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.crn.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.alB() > ubcFlowEvent2.alB()) {
            a(ubcFlowEvent);
        }
    }

    private void c(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.crn.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.alB() < ubcFlowEvent2.alB()) {
            a(ubcFlowEvent);
        }
    }

    private void d(UbcFlowEvent ubcFlowEvent) {
        if (!e(this.crn.get(ubcFlowEvent.id))) {
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
            synchronized (this.crm) {
                switch (ubcFlowEvent.alE()) {
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

    public HybridUbcFlow aj(List<UbcFlowEvent> list) {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "record events size = " + list.size());
        }
        synchronized (this.crm) {
            for (UbcFlowEvent ubcFlowEvent : list) {
                f(ubcFlowEvent);
            }
        }
        return this;
    }

    public HybridUbcFlow bD(String str, String str2) {
        this.crl.put(str, str2);
        return this;
    }

    public String mu(String str) {
        return this.crl.get(str);
    }

    public HybridUbcFlow c(HybridUbcFlow hybridUbcFlow) {
        if (hybridUbcFlow != null) {
            hybridUbcFlow.alm();
            aj(hybridUbcFlow.cro);
            this.crl.putAll(hybridUbcFlow.crl);
        }
        return this;
    }

    public HybridUbcFlow r(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.crk.put(str, obj);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return this;
    }

    public JSONObject alb() {
        return this.crk;
    }

    public HybridUbcFlow alc() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naFlowDone");
        }
        this.crp = true;
        alp();
        return this;
    }

    public HybridUbcFlow ald() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "h5FlowDone");
        }
        this.crq = true;
        alp();
        return this;
    }

    public HybridUbcFlow ale() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "webViewWidgetDone");
        }
        this.crt = true;
        alp();
        return this;
    }

    public HybridUbcFlow alf() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naPaintFlowDone");
        }
        this.crr = true;
        alp();
        return this;
    }

    public HybridUbcFlow alg() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "webwidgetPaintDone");
        }
        this.crs = true;
        alp();
        return this;
    }

    public boolean alh() {
        return this.crp;
    }

    public boolean ali() {
        return this.crq;
    }

    public boolean alj() {
        return this.crr;
    }

    public boolean alk() {
        return this.crs;
    }

    public boolean all() {
        return this.crt;
    }

    private boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.crm) {
            isEmpty = this.crm.isEmpty();
        }
        return isEmpty;
    }

    public void alm() {
        UbcFlowEvent ubcFlowEvent;
        synchronized (this.crm) {
            this.cro.clear();
            for (String str : this.crm) {
                if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.crn.get(str)) != null && ubcFlowEvent.alB() > 0) {
                    this.cro.add(ubcFlowEvent);
                }
            }
            sort();
        }
    }

    private void sort() {
        Collections.sort(this.cro, new Comparator<UbcFlowEvent>() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(UbcFlowEvent ubcFlowEvent, UbcFlowEvent ubcFlowEvent2) {
                return Long.compare(ubcFlowEvent.alB(), ubcFlowEvent2.alB());
            }
        });
    }

    public HybridUbcFlow a(SubmitStrategy submitStrategy) {
        if (submitStrategy != null) {
            this.crw = submitStrategy;
        }
        return this;
    }

    public SubmitStrategy aln() {
        return this.crw;
    }

    private boolean alo() {
        return (this.crw == null ? crv : this.crw).submitAllowed(this);
    }

    private void alp() {
        if (alo()) {
            alq();
        }
    }

    private synchronized void alq() {
        if (!this.cru) {
            this.cru = true;
            mv("callback_on_submit");
            n.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow.this.alr();
                }
            }, "HybridUbcFlow");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alr() {
        alm();
        mv("component_reporter");
        if (!TextUtils.isEmpty(this.crj)) {
            com.baidu.swan.apps.statistic.a ow = com.baidu.swan.apps.statistic.h.ow(this.crj);
            for (UbcFlowEvent ubcFlowEvent : this.cro) {
                if (!ubcFlowEvent.alD()) {
                    com.baidu.swan.apps.statistic.b.a(ow, ubcFlowEvent.id, ubcFlowEvent.value(), ubcFlowEvent.alB());
                }
            }
            com.baidu.swan.apps.performance.b.a.ak(this.cro);
            if (!isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, String> entry : this.crl.entrySet()) {
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
                com.baidu.swan.apps.statistic.b.a(ow, this.crk.toString());
                com.baidu.swan.apps.statistic.b.c(ow);
            }
        }
    }

    private void mv(String str) {
        List<a> list = this.crx.get(str);
        if (list != null && !list.isEmpty()) {
            for (a aVar : list) {
                if (aVar != null && aVar.crB != null) {
                    aVar.crB.H(this);
                }
            }
        }
    }

    public HybridUbcFlow c(String str, com.baidu.swan.apps.aq.e.b<HybridUbcFlow> bVar) {
        a aVar = new a(str, bVar);
        if (aVar.alt()) {
            synchronized (this.crx) {
                List<a> list = this.crx.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                    this.crx.put(str, list);
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
        if (r1.alB() < 1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
        if (r0.alB() >= 1) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:?, code lost:
        return r1.alB() - r0.alB();
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
            ubcFlowEvent = this.crn.get(strArr[i]);
            if (ubcFlowEvent2 == null) {
                if (ubcFlowEvent == null || ubcFlowEvent.alB() < 1) {
                    break;
                }
            } else if (ubcFlowEvent != null && ubcFlowEvent.alB() > 0) {
                break;
            } else {
                ubcFlowEvent = ubcFlowEvent2;
            }
            i++;
            ubcFlowEvent2 = ubcFlowEvent;
        }
        return -1L;
    }

    public synchronized JSONObject als() throws JSONException {
        JSONObject jSONObject;
        UbcFlowEvent ubcFlowEvent;
        jSONObject = new JSONObject();
        try {
            String[] strArr = new String[this.crm.size()];
            this.crm.toArray(strArr);
            ArrayList<UbcFlowEvent> arrayList = new ArrayList(strArr.length);
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.crn.get(str)) != null && ubcFlowEvent.alB() > 0) {
                    arrayList.add(ubcFlowEvent);
                }
            }
            Collections.sort(arrayList, new Comparator<UbcFlowEvent>() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(UbcFlowEvent ubcFlowEvent2, UbcFlowEvent ubcFlowEvent3) {
                    return Long.compare(ubcFlowEvent2.alB(), ubcFlowEvent3.alB());
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
            for (Map.Entry<String, String> entry : this.crl.entrySet()) {
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
            if (this.crk != null && this.crk.length() > 0) {
                jSONObject.put("values", this.crk);
            }
        } catch (Exception e) {
            jSONObject.put("excp", e.getMessage());
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a {
        final com.baidu.swan.apps.aq.e.b<HybridUbcFlow> crB;
        final String type;

        private a(String str, com.baidu.swan.apps.aq.e.b<HybridUbcFlow> bVar) {
            this.type = str;
            this.crB = bVar;
        }

        boolean alt() {
            return (this.crB == null || TextUtils.isEmpty(this.type)) ? false : true;
        }
    }
}
