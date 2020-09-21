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
/* loaded from: classes3.dex */
public final class HybridUbcFlow {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final SubmitStrategy cIv = SubmitStrategy.HYBRID;
    private String cIj;
    private final JSONObject cIk = new JSONObject();
    private final Map<String, String> cIl = new HashMap();
    public final List<String> cIm = new ArrayList();
    private final Map<String, UbcFlowEvent> cIn = new HashMap();
    public final List<UbcFlowEvent> cIo = new ArrayList();
    private boolean cIp = false;
    private boolean cIq = false;
    private boolean cIr = false;
    private boolean cIs = false;
    private boolean cIt = false;
    private volatile boolean cIu = false;
    private SubmitStrategy cIw = cIv;
    private final Map<String, List<a>> cIx = new HashMap();
    private String cIy = "";
    public final String name;

    /* loaded from: classes3.dex */
    public enum SubmitStrategy {
        HYBRID { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.1
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.awl() && hybridUbcFlow.awm() && hybridUbcFlow.awn();
            }
        },
        HYBRID_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.2
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.awl() && hybridUbcFlow.awm() && hybridUbcFlow.awo();
            }
        },
        RELAUNCH { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.3
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.awl() && hybridUbcFlow.awm() && hybridUbcFlow.awn();
            }
        },
        RELAUNCH_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.4
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.awl() && hybridUbcFlow.awm() && hybridUbcFlow.awo();
            }
        },
        NA_ONLY { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.5
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.awl();
            }
        },
        ROUTE { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.6
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.awl() && hybridUbcFlow.awm();
            }
        },
        ROUTE_NA { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.7
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.awl();
            }
        },
        ROUTE_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.8
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.awl() && hybridUbcFlow.awm() && hybridUbcFlow.awp();
            }
        },
        VIDEO_NA { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.9
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.awl();
            }
        };

        abstract boolean submitAllowed(HybridUbcFlow hybridUbcFlow);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HybridUbcFlow(String str) {
        this.name = str;
    }

    public boolean pt(String str) {
        boolean z = false;
        boolean z2 = !TextUtils.isEmpty(str);
        if (TextUtils.isEmpty(this.cIy)) {
            if (z2) {
                str = this.cIy;
            }
            this.cIy = str;
            return true;
        }
        if (!z2 || TextUtils.equals(this.cIy, str)) {
            z = true;
        }
        return z;
    }

    public HybridUbcFlow pu(String str) {
        this.cIj = str;
        return this;
    }

    public String awe() {
        return this.cIj;
    }

    private void a(UbcFlowEvent ubcFlowEvent) {
        this.cIm.remove(ubcFlowEvent.id);
        this.cIm.add(ubcFlowEvent.id);
        this.cIn.put(ubcFlowEvent.id, ubcFlowEvent);
    }

    private void b(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.cIn.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.awF() > ubcFlowEvent2.awF()) {
            a(ubcFlowEvent);
        }
    }

    private void c(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.cIn.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.awF() < ubcFlowEvent2.awF()) {
            a(ubcFlowEvent);
        }
    }

    private void d(UbcFlowEvent ubcFlowEvent) {
        if (!e(this.cIn.get(ubcFlowEvent.id))) {
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
            synchronized (this.cIm) {
                switch (ubcFlowEvent.awI()) {
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

    public HybridUbcFlow as(List<UbcFlowEvent> list) {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "record events size = " + list.size());
        }
        synchronized (this.cIm) {
            for (UbcFlowEvent ubcFlowEvent : list) {
                f(ubcFlowEvent);
            }
        }
        return this;
    }

    public HybridUbcFlow bW(String str, String str2) {
        this.cIl.put(str, str2);
        return this;
    }

    public String pv(String str) {
        return this.cIl.get(str);
    }

    public HybridUbcFlow d(HybridUbcFlow hybridUbcFlow) {
        if (hybridUbcFlow != null) {
            hybridUbcFlow.awq();
            as(hybridUbcFlow.cIo);
            this.cIl.putAll(hybridUbcFlow.cIl);
        }
        return this;
    }

    public HybridUbcFlow r(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.cIk.put(str, obj);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return this;
    }

    public JSONObject awf() {
        return this.cIk;
    }

    public HybridUbcFlow awg() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naFlowDone");
        }
        this.cIp = true;
        awt();
        return this;
    }

    public HybridUbcFlow awh() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "h5FlowDone");
        }
        this.cIq = true;
        awt();
        return this;
    }

    public HybridUbcFlow awi() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "webViewWidgetDone");
        }
        this.cIt = true;
        awt();
        return this;
    }

    public HybridUbcFlow awj() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naPaintFlowDone");
        }
        this.cIr = true;
        pw("fmp_callback");
        awt();
        return this;
    }

    public HybridUbcFlow awk() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "webwidgetPaintDone");
        }
        this.cIs = true;
        awt();
        return this;
    }

    public boolean awl() {
        return this.cIp;
    }

    public boolean awm() {
        return this.cIq;
    }

    public boolean awn() {
        return this.cIr;
    }

    public boolean awo() {
        return this.cIs;
    }

    public boolean awp() {
        return this.cIt;
    }

    private boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.cIm) {
            isEmpty = this.cIm.isEmpty();
        }
        return isEmpty;
    }

    public void awq() {
        UbcFlowEvent ubcFlowEvent;
        synchronized (this.cIm) {
            this.cIo.clear();
            for (String str : this.cIm) {
                if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.cIn.get(str)) != null && ubcFlowEvent.awF() > 0) {
                    this.cIo.add(ubcFlowEvent);
                }
            }
            sort();
        }
    }

    private void sort() {
        Collections.sort(this.cIo, new Comparator<UbcFlowEvent>() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(UbcFlowEvent ubcFlowEvent, UbcFlowEvent ubcFlowEvent2) {
                return Long.compare(ubcFlowEvent.awF(), ubcFlowEvent2.awF());
            }
        });
    }

    public HybridUbcFlow a(SubmitStrategy submitStrategy) {
        if (submitStrategy != null) {
            this.cIw = submitStrategy;
        }
        return this;
    }

    public SubmitStrategy awr() {
        return this.cIw;
    }

    private boolean aws() {
        return (this.cIw == null ? cIv : this.cIw).submitAllowed(this);
    }

    private void awt() {
        if (aws()) {
            awu();
        }
    }

    private synchronized void awu() {
        if (!this.cIu) {
            this.cIu = true;
            pw("callback_on_submit");
            p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow.this.awv();
                }
            }, "HybridUbcFlow");
            com.baidu.swan.apps.performance.b.d.axa();
            if (DEBUG) {
                Log.d("HybridUbcFlow", "UBC submit " + awe() + ", this=" + hashCode(), new Exception());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awv() {
        awq();
        pw("component_reporter");
        if (!TextUtils.isEmpty(this.cIj)) {
            com.baidu.swan.apps.statistic.a rH = com.baidu.swan.apps.statistic.h.rH(this.cIj);
            for (UbcFlowEvent ubcFlowEvent : this.cIo) {
                if (!ubcFlowEvent.awH()) {
                    com.baidu.swan.apps.statistic.b.a(rH, ubcFlowEvent.id, ubcFlowEvent.value(), ubcFlowEvent.awF());
                }
            }
            com.baidu.swan.apps.performance.b.a.at(this.cIo);
            if (!isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, String> entry : this.cIl.entrySet()) {
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
                com.baidu.swan.apps.statistic.b.a(rH, this.cIk.toString());
                com.baidu.swan.apps.statistic.b.c(rH);
            }
        }
    }

    private void pw(String str) {
        List<a> list = this.cIx.get(str);
        if (list != null && !list.isEmpty()) {
            for (a aVar : list) {
                if (aVar != null && aVar.cIB != null) {
                    aVar.cIB.J(this);
                }
            }
        }
    }

    public HybridUbcFlow d(String str, com.baidu.swan.apps.ap.e.b<HybridUbcFlow> bVar) {
        a aVar = new a(str, bVar);
        if (aVar.awx()) {
            synchronized (this.cIx) {
                List<a> list = this.cIx.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                    this.cIx.put(str, list);
                }
                list.add(aVar);
            }
        }
        return this;
    }

    public boolean nu(String str) {
        return this.cIn.get(str) != null;
    }

    public UbcFlowEvent px(String str) {
        return this.cIn.get(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002f, code lost:
        if (r1 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
        if (r0 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0039, code lost:
        if (r1.awF() < 1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
        if (r0.awF() >= 1) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:?, code lost:
        return r1.awF() - r0.awF();
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
            ubcFlowEvent = this.cIn.get(strArr[i]);
            if (ubcFlowEvent2 == null) {
                if (ubcFlowEvent == null || ubcFlowEvent.awF() < 1) {
                    break;
                }
            } else if (ubcFlowEvent != null && ubcFlowEvent.awF() > 0) {
                break;
            } else {
                ubcFlowEvent = ubcFlowEvent2;
            }
            i++;
            ubcFlowEvent2 = ubcFlowEvent;
        }
        return -1L;
    }

    public synchronized JSONObject aww() throws JSONException {
        JSONObject jSONObject;
        UbcFlowEvent ubcFlowEvent;
        jSONObject = new JSONObject();
        try {
            String[] strArr = new String[this.cIm.size()];
            this.cIm.toArray(strArr);
            ArrayList<UbcFlowEvent> arrayList = new ArrayList(strArr.length);
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.cIn.get(str)) != null && ubcFlowEvent.awF() > 0) {
                    arrayList.add(ubcFlowEvent);
                }
            }
            Collections.sort(arrayList, new Comparator<UbcFlowEvent>() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(UbcFlowEvent ubcFlowEvent2, UbcFlowEvent ubcFlowEvent3) {
                    return Long.compare(ubcFlowEvent2.awF(), ubcFlowEvent3.awF());
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
            for (Map.Entry<String, String> entry : this.cIl.entrySet()) {
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
            if (this.cIk != null && this.cIk.length() > 0) {
                jSONObject.put("values", this.cIk);
            }
        } catch (Exception e) {
            jSONObject.put("excp", e.getMessage());
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        final com.baidu.swan.apps.ap.e.b<HybridUbcFlow> cIB;
        final String type;

        private a(String str, com.baidu.swan.apps.ap.e.b<HybridUbcFlow> bVar) {
            this.type = str;
            this.cIB = bVar;
        }

        boolean awx() {
            return (this.cIB == null || TextUtils.isEmpty(this.type)) ? false : true;
        }
    }
}
