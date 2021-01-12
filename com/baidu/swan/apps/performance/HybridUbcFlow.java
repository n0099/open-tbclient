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
    public static final SubmitStrategy dov = SubmitStrategy.HYBRID;
    private final JSONObject doj = new JSONObject();
    private final Map<String, String> dok = new HashMap();
    public final List<String> dol = new ArrayList();
    private final Map<String, UbcFlowEvent> dom = new HashMap();
    public final List<UbcFlowEvent> don = new ArrayList();
    private boolean doo = false;
    private boolean dop = false;
    private boolean doq = false;
    private boolean dor = false;
    private boolean dos = false;
    private volatile boolean dou = false;
    private SubmitStrategy dow = dov;
    private final Map<String, List<a>> dox = new HashMap();
    private String doy = "";
    private String mUbcId;
    public final String name;

    /* loaded from: classes8.dex */
    public enum SubmitStrategy {
        HYBRID { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.1
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aDr() && hybridUbcFlow.aDs() && hybridUbcFlow.aDt();
            }
        },
        HYBRID_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.2
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aDr() && hybridUbcFlow.aDs() && hybridUbcFlow.aDu();
            }
        },
        RELAUNCH { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.3
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aDr() && hybridUbcFlow.aDs() && hybridUbcFlow.aDt();
            }
        },
        RELAUNCH_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.4
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aDr() && hybridUbcFlow.aDs() && hybridUbcFlow.aDu();
            }
        },
        NA_ONLY { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.5
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aDr();
            }
        },
        ROUTE { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.6
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aDr() && hybridUbcFlow.aDs();
            }
        },
        ROUTE_NA { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.7
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aDr();
            }
        },
        ROUTE_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.8
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aDr() && hybridUbcFlow.aDs() && hybridUbcFlow.aDv();
            }
        },
        VIDEO_NA { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.9
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aDr();
            }
        };

        abstract boolean submitAllowed(HybridUbcFlow hybridUbcFlow);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HybridUbcFlow(String str) {
        this.name = str;
    }

    public boolean pV(String str) {
        boolean z = false;
        boolean z2 = !TextUtils.isEmpty(str);
        if (TextUtils.isEmpty(this.doy)) {
            if (z2) {
                str = this.doy;
            }
            this.doy = str;
            return true;
        }
        if (!z2 || TextUtils.equals(this.doy, str)) {
            z = true;
        }
        return z;
    }

    public HybridUbcFlow pW(String str) {
        this.mUbcId = str;
        return this;
    }

    public String getUbcId() {
        return this.mUbcId;
    }

    private void a(UbcFlowEvent ubcFlowEvent) {
        this.dol.remove(ubcFlowEvent.id);
        this.dol.add(ubcFlowEvent.id);
        this.dom.put(ubcFlowEvent.id, ubcFlowEvent);
    }

    private void b(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.dom.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.aDK() > ubcFlowEvent2.aDK()) {
            a(ubcFlowEvent);
        }
    }

    private void c(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.dom.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.aDK() < ubcFlowEvent2.aDK()) {
            a(ubcFlowEvent);
        }
    }

    private void d(UbcFlowEvent ubcFlowEvent) {
        if (!e(this.dom.get(ubcFlowEvent.id))) {
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
            synchronized (this.dol) {
                switch (ubcFlowEvent.aDN()) {
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
        synchronized (this.dol) {
            for (UbcFlowEvent ubcFlowEvent : list) {
                f(ubcFlowEvent);
            }
        }
        return this;
    }

    public HybridUbcFlow cm(String str, String str2) {
        this.dok.put(str, str2);
        return this;
    }

    public String pX(String str) {
        return this.dok.get(str);
    }

    public HybridUbcFlow d(HybridUbcFlow hybridUbcFlow) {
        if (hybridUbcFlow != null) {
            hybridUbcFlow.aDw();
            aS(hybridUbcFlow.don);
            this.dok.putAll(hybridUbcFlow.dok);
        }
        return this;
    }

    public HybridUbcFlow q(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.doj.put(str, obj);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return this;
    }

    public JSONObject aDl() {
        return this.doj;
    }

    public HybridUbcFlow aDm() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naFlowDone");
        }
        this.doo = true;
        aDz();
        return this;
    }

    public HybridUbcFlow aDn() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "h5FlowDone");
        }
        this.dop = true;
        aDz();
        return this;
    }

    public HybridUbcFlow aDo() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "webViewWidgetDone");
        }
        this.dos = true;
        aDz();
        return this;
    }

    public HybridUbcFlow aDp() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naPaintFlowDone");
        }
        this.doq = true;
        pY("fmp_callback");
        aDz();
        return this;
    }

    public HybridUbcFlow aDq() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "webwidgetPaintDone");
        }
        this.dor = true;
        aDz();
        return this;
    }

    public boolean aDr() {
        return this.doo;
    }

    public boolean aDs() {
        return this.dop;
    }

    public boolean aDt() {
        return this.doq;
    }

    public boolean aDu() {
        return this.dor;
    }

    public boolean aDv() {
        return this.dos;
    }

    private boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.dol) {
            isEmpty = this.dol.isEmpty();
        }
        return isEmpty;
    }

    public void aDw() {
        UbcFlowEvent ubcFlowEvent;
        synchronized (this.dol) {
            this.don.clear();
            for (String str : this.dol) {
                if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.dom.get(str)) != null && ubcFlowEvent.aDK() > 0) {
                    this.don.add(ubcFlowEvent);
                }
            }
            sort();
        }
    }

    private void sort() {
        Collections.sort(this.don, new Comparator<UbcFlowEvent>() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(UbcFlowEvent ubcFlowEvent, UbcFlowEvent ubcFlowEvent2) {
                return Long.compare(ubcFlowEvent.aDK(), ubcFlowEvent2.aDK());
            }
        });
    }

    public HybridUbcFlow a(SubmitStrategy submitStrategy) {
        if (submitStrategy != null) {
            this.dow = submitStrategy;
        }
        return this;
    }

    public SubmitStrategy aDx() {
        return this.dow;
    }

    private boolean aDy() {
        return (this.dow == null ? dov : this.dow).submitAllowed(this);
    }

    private void aDz() {
        if (aDy()) {
            submit();
        }
    }

    private synchronized void submit() {
        if (!this.dou) {
            this.dou = true;
            pY("callback_on_submit");
            p.b(new Runnable() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow.this.aDA();
                }
            }, "HybridUbcFlow");
            com.baidu.swan.apps.performance.b.d.aEf();
            if (DEBUG) {
                Log.d("HybridUbcFlow", "UBC submit " + getUbcId() + ", this=" + hashCode(), new Exception());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDA() {
        aDw();
        pY("component_reporter");
        if (!TextUtils.isEmpty(this.mUbcId)) {
            com.baidu.swan.apps.statistic.a so = com.baidu.swan.apps.statistic.h.so(this.mUbcId);
            for (UbcFlowEvent ubcFlowEvent : this.don) {
                if (!ubcFlowEvent.aDM()) {
                    com.baidu.swan.apps.statistic.b.a(so, ubcFlowEvent.id, ubcFlowEvent.value(), ubcFlowEvent.aDK());
                }
            }
            com.baidu.swan.apps.performance.b.a.aT(this.don);
            if (!isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, String> entry : this.dok.entrySet()) {
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
                com.baidu.swan.apps.statistic.b.a(so, this.doj.toString());
                com.baidu.swan.apps.statistic.b.c(so);
            }
        }
    }

    private void pY(String str) {
        List<a> list = this.dox.get(str);
        if (list != null && !list.isEmpty()) {
            for (a aVar : list) {
                if (aVar != null && aVar.doB != null) {
                    aVar.doB.L(this);
                }
            }
        }
    }

    public HybridUbcFlow d(String str, com.baidu.swan.apps.ao.e.b<HybridUbcFlow> bVar) {
        a aVar = new a(str, bVar);
        if (aVar.aDC()) {
            synchronized (this.dox) {
                List<a> list = this.dox.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                    this.dox.put(str, list);
                }
                list.add(aVar);
            }
        }
        return this;
    }

    public boolean nW(String str) {
        return this.dom.get(str) != null;
    }

    public UbcFlowEvent pZ(String str) {
        return this.dom.get(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002f, code lost:
        if (r1 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
        if (r0 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0039, code lost:
        if (r1.aDK() < 1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
        if (r0.aDK() >= 1) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:?, code lost:
        return r1.aDK() - r0.aDK();
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
            ubcFlowEvent = this.dom.get(strArr[i]);
            if (ubcFlowEvent2 == null) {
                if (ubcFlowEvent == null || ubcFlowEvent.aDK() < 1) {
                    break;
                }
            } else if (ubcFlowEvent != null && ubcFlowEvent.aDK() > 0) {
                break;
            } else {
                ubcFlowEvent = ubcFlowEvent2;
            }
            i++;
            ubcFlowEvent2 = ubcFlowEvent;
        }
        return -1L;
    }

    public synchronized JSONObject aDB() throws JSONException {
        JSONObject jSONObject;
        UbcFlowEvent ubcFlowEvent;
        jSONObject = new JSONObject();
        try {
            String[] strArr = new String[this.dol.size()];
            this.dol.toArray(strArr);
            ArrayList<UbcFlowEvent> arrayList = new ArrayList(strArr.length);
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.dom.get(str)) != null && ubcFlowEvent.aDK() > 0) {
                    arrayList.add(ubcFlowEvent);
                }
            }
            Collections.sort(arrayList, new Comparator<UbcFlowEvent>() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(UbcFlowEvent ubcFlowEvent2, UbcFlowEvent ubcFlowEvent3) {
                    return Long.compare(ubcFlowEvent2.aDK(), ubcFlowEvent3.aDK());
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
            for (Map.Entry<String, String> entry : this.dok.entrySet()) {
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
            if (this.doj != null && this.doj.length() > 0) {
                jSONObject.put("values", this.doj);
            }
        } catch (Exception e) {
            jSONObject.put("excp", e.getMessage());
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a {
        final com.baidu.swan.apps.ao.e.b<HybridUbcFlow> doB;
        final String type;

        private a(String str, com.baidu.swan.apps.ao.e.b<HybridUbcFlow> bVar) {
            this.type = str;
            this.doB = bVar;
        }

        boolean aDC() {
            return (this.doB == null || TextUtils.isEmpty(this.type)) ? false : true;
        }
    }
}
