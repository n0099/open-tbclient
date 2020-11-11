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
    public static final SubmitStrategy diU = SubmitStrategy.HYBRID;
    private String diI;
    private final JSONObject diJ = new JSONObject();
    private final Map<String, String> diK = new HashMap();
    public final List<String> diL = new ArrayList();
    private final Map<String, UbcFlowEvent> diM = new HashMap();
    public final List<UbcFlowEvent> diN = new ArrayList();
    private boolean diO = false;
    private boolean diP = false;
    private boolean diQ = false;
    private boolean diR = false;
    private boolean diS = false;
    private volatile boolean diT = false;
    private SubmitStrategy diV = diU;
    private final Map<String, List<a>> diW = new HashMap();
    private String diX = "";
    public final String name;

    /* loaded from: classes10.dex */
    public enum SubmitStrategy {
        HYBRID { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.1
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aDq() && hybridUbcFlow.aDr() && hybridUbcFlow.aDs();
            }
        },
        HYBRID_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.2
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aDq() && hybridUbcFlow.aDr() && hybridUbcFlow.aDt();
            }
        },
        RELAUNCH { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.3
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aDq() && hybridUbcFlow.aDr() && hybridUbcFlow.aDs();
            }
        },
        RELAUNCH_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.4
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aDq() && hybridUbcFlow.aDr() && hybridUbcFlow.aDt();
            }
        },
        NA_ONLY { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.5
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aDq();
            }
        },
        ROUTE { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.6
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aDq() && hybridUbcFlow.aDr();
            }
        },
        ROUTE_NA { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.7
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aDq();
            }
        },
        ROUTE_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.8
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aDq() && hybridUbcFlow.aDr() && hybridUbcFlow.aDu();
            }
        },
        VIDEO_NA { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.9
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.aDq();
            }
        };

        abstract boolean submitAllowed(HybridUbcFlow hybridUbcFlow);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HybridUbcFlow(String str) {
        this.name = str;
    }

    public boolean qM(String str) {
        boolean z = false;
        boolean z2 = !TextUtils.isEmpty(str);
        if (TextUtils.isEmpty(this.diX)) {
            if (z2) {
                str = this.diX;
            }
            this.diX = str;
            return true;
        }
        if (!z2 || TextUtils.equals(this.diX, str)) {
            z = true;
        }
        return z;
    }

    public HybridUbcFlow qN(String str) {
        this.diI = str;
        return this;
    }

    public String aDj() {
        return this.diI;
    }

    private void a(UbcFlowEvent ubcFlowEvent) {
        this.diL.remove(ubcFlowEvent.id);
        this.diL.add(ubcFlowEvent.id);
        this.diM.put(ubcFlowEvent.id, ubcFlowEvent);
    }

    private void b(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.diM.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.aDK() > ubcFlowEvent2.aDK()) {
            a(ubcFlowEvent);
        }
    }

    private void c(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.diM.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.aDK() < ubcFlowEvent2.aDK()) {
            a(ubcFlowEvent);
        }
    }

    private void d(UbcFlowEvent ubcFlowEvent) {
        if (!e(this.diM.get(ubcFlowEvent.id))) {
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
            synchronized (this.diL) {
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

    public HybridUbcFlow aM(List<UbcFlowEvent> list) {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "record events size = " + list.size());
        }
        synchronized (this.diL) {
            for (UbcFlowEvent ubcFlowEvent : list) {
                f(ubcFlowEvent);
            }
        }
        return this;
    }

    public HybridUbcFlow ci(String str, String str2) {
        this.diK.put(str, str2);
        return this;
    }

    public String qO(String str) {
        return this.diK.get(str);
    }

    public HybridUbcFlow d(HybridUbcFlow hybridUbcFlow) {
        if (hybridUbcFlow != null) {
            hybridUbcFlow.aDv();
            aM(hybridUbcFlow.diN);
            this.diK.putAll(hybridUbcFlow.diK);
        }
        return this;
    }

    public HybridUbcFlow r(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.diJ.put(str, obj);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return this;
    }

    public JSONObject aDk() {
        return this.diJ;
    }

    public HybridUbcFlow aDl() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naFlowDone");
        }
        this.diO = true;
        aDy();
        return this;
    }

    public HybridUbcFlow aDm() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "h5FlowDone");
        }
        this.diP = true;
        aDy();
        return this;
    }

    public HybridUbcFlow aDn() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "webViewWidgetDone");
        }
        this.diS = true;
        aDy();
        return this;
    }

    public HybridUbcFlow aDo() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naPaintFlowDone");
        }
        this.diQ = true;
        qP("fmp_callback");
        aDy();
        return this;
    }

    public HybridUbcFlow aDp() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "webwidgetPaintDone");
        }
        this.diR = true;
        aDy();
        return this;
    }

    public boolean aDq() {
        return this.diO;
    }

    public boolean aDr() {
        return this.diP;
    }

    public boolean aDs() {
        return this.diQ;
    }

    public boolean aDt() {
        return this.diR;
    }

    public boolean aDu() {
        return this.diS;
    }

    private boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.diL) {
            isEmpty = this.diL.isEmpty();
        }
        return isEmpty;
    }

    public void aDv() {
        UbcFlowEvent ubcFlowEvent;
        synchronized (this.diL) {
            this.diN.clear();
            for (String str : this.diL) {
                if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.diM.get(str)) != null && ubcFlowEvent.aDK() > 0) {
                    this.diN.add(ubcFlowEvent);
                }
            }
            sort();
        }
    }

    private void sort() {
        Collections.sort(this.diN, new Comparator<UbcFlowEvent>() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.1
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
            this.diV = submitStrategy;
        }
        return this;
    }

    public SubmitStrategy aDw() {
        return this.diV;
    }

    private boolean aDx() {
        return (this.diV == null ? diU : this.diV).submitAllowed(this);
    }

    private void aDy() {
        if (aDx()) {
            aDz();
        }
    }

    private synchronized void aDz() {
        if (!this.diT) {
            this.diT = true;
            qP("callback_on_submit");
            p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow.this.aDA();
                }
            }, "HybridUbcFlow");
            com.baidu.swan.apps.performance.b.d.aEf();
            if (DEBUG) {
                Log.d("HybridUbcFlow", "UBC submit " + aDj() + ", this=" + hashCode(), new Exception());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDA() {
        aDv();
        qP("component_reporter");
        if (!TextUtils.isEmpty(this.diI)) {
            com.baidu.swan.apps.statistic.a tb = com.baidu.swan.apps.statistic.h.tb(this.diI);
            for (UbcFlowEvent ubcFlowEvent : this.diN) {
                if (!ubcFlowEvent.aDM()) {
                    com.baidu.swan.apps.statistic.b.a(tb, ubcFlowEvent.id, ubcFlowEvent.value(), ubcFlowEvent.aDK());
                }
            }
            com.baidu.swan.apps.performance.b.a.aN(this.diN);
            if (!isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, String> entry : this.diK.entrySet()) {
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
                com.baidu.swan.apps.statistic.b.a(tb, this.diJ.toString());
                com.baidu.swan.apps.statistic.b.c(tb);
            }
        }
    }

    private void qP(String str) {
        List<a> list = this.diW.get(str);
        if (list != null && !list.isEmpty()) {
            for (a aVar : list) {
                if (aVar != null && aVar.dja != null) {
                    aVar.dja.M(this);
                }
            }
        }
    }

    public HybridUbcFlow d(String str, com.baidu.swan.apps.ap.e.b<HybridUbcFlow> bVar) {
        a aVar = new a(str, bVar);
        if (aVar.aDC()) {
            synchronized (this.diW) {
                List<a> list = this.diW.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                    this.diW.put(str, list);
                }
                list.add(aVar);
            }
        }
        return this;
    }

    public boolean oP(String str) {
        return this.diM.get(str) != null;
    }

    public UbcFlowEvent qQ(String str) {
        return this.diM.get(str);
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
            ubcFlowEvent = this.diM.get(strArr[i]);
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
            String[] strArr = new String[this.diL.size()];
            this.diL.toArray(strArr);
            ArrayList<UbcFlowEvent> arrayList = new ArrayList(strArr.length);
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.diM.get(str)) != null && ubcFlowEvent.aDK() > 0) {
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
            for (Map.Entry<String, String> entry : this.diK.entrySet()) {
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
            if (this.diJ != null && this.diJ.length() > 0) {
                jSONObject.put("values", this.diJ);
            }
        } catch (Exception e) {
            jSONObject.put("excp", e.getMessage());
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a {
        final com.baidu.swan.apps.ap.e.b<HybridUbcFlow> dja;
        final String type;

        private a(String str, com.baidu.swan.apps.ap.e.b<HybridUbcFlow> bVar) {
            this.type = str;
            this.dja = bVar;
        }

        boolean aDC() {
            return (this.dja == null || TextUtils.isEmpty(this.type)) ? false : true;
        }
    }
}
