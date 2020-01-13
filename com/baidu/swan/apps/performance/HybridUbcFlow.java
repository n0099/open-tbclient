package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.ubc.Flow;
import com.baidu.swan.ubc.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class HybridUbcFlow {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final SubmitStrategy bDw = SubmitStrategy.HYBRID;
    private String bDj;
    private final JSONObject bDk = new JSONObject();
    private final Map<String, String> bDl = new HashMap();
    public final List<String> bDm = new ArrayList();
    private final Map<String, UbcFlowEvent> bDn = new HashMap();
    public final List<UbcFlowEvent> bDo = new ArrayList();
    private boolean bDp = false;
    private boolean bDq = false;
    private boolean bDr = false;
    private boolean bDs = false;
    private boolean bDt = false;
    private boolean bDu = false;
    private volatile boolean bDv = false;
    private SubmitStrategy bDx = bDw;
    private final Map<String, List<a>> bDy = new HashMap();
    public final String name;

    /* loaded from: classes10.dex */
    public enum SubmitStrategy {
        HYBRID { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.1
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.Xq() && hybridUbcFlow.Xs() && hybridUbcFlow.Xr() && hybridUbcFlow.Xt();
            }
        },
        HYBRID_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.2
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.Xq() && hybridUbcFlow.Xs() && hybridUbcFlow.Xr() && hybridUbcFlow.Xu();
            }
        },
        RELAUNCH { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.3
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.Xq() && hybridUbcFlow.Xs() && hybridUbcFlow.Xt();
            }
        },
        RELAUNCH_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.4
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.Xq() && hybridUbcFlow.Xs() && hybridUbcFlow.Xu();
            }
        },
        NA_ONLY { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.5
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.Xq();
            }
        },
        ROUTE { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.6
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.Xq() && hybridUbcFlow.Xs();
            }
        },
        ROUTE_NA { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.7
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.Xq();
            }
        },
        ROUTE_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.8
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.Xq() && hybridUbcFlow.Xs() && hybridUbcFlow.Xv();
            }
        };

        abstract boolean submitAllowed(HybridUbcFlow hybridUbcFlow);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HybridUbcFlow(String str) {
        this.name = str;
    }

    public HybridUbcFlow jD(String str) {
        this.bDj = str;
        return this;
    }

    public String Xi() {
        return this.bDj;
    }

    private void a(UbcFlowEvent ubcFlowEvent) {
        this.bDm.remove(ubcFlowEvent.id);
        this.bDm.add(ubcFlowEvent.id);
        this.bDn.put(ubcFlowEvent.id, ubcFlowEvent);
    }

    private void b(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.bDn.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.XG() > ubcFlowEvent2.XG()) {
            a(ubcFlowEvent);
        }
    }

    private void c(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.bDn.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.XG() < ubcFlowEvent2.XG()) {
            a(ubcFlowEvent);
        }
    }

    private void d(UbcFlowEvent ubcFlowEvent) {
        if (!e(this.bDn.get(ubcFlowEvent.id))) {
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
            synchronized (this.bDm) {
                switch (ubcFlowEvent.XJ()) {
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

    public HybridUbcFlow Z(List<UbcFlowEvent> list) {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "record events size = " + list.size());
        }
        synchronized (this.bDm) {
            for (UbcFlowEvent ubcFlowEvent : list) {
                f(ubcFlowEvent);
            }
        }
        return this;
    }

    public HybridUbcFlow aS(String str, String str2) {
        this.bDl.put(str, str2);
        return this;
    }

    public String jE(String str) {
        return this.bDl.get(str);
    }

    public HybridUbcFlow c(HybridUbcFlow hybridUbcFlow) {
        if (hybridUbcFlow != null) {
            hybridUbcFlow.Xw();
            Z(hybridUbcFlow.bDo);
            this.bDl.putAll(hybridUbcFlow.bDl);
        }
        return this;
    }

    public HybridUbcFlow k(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.bDk.put(str, obj);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return this;
    }

    public JSONObject Xj() {
        return this.bDk;
    }

    public HybridUbcFlow Xk() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naFlowDone");
        }
        this.bDp = true;
        XA();
        return this;
    }

    public HybridUbcFlow Xl() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naAnimFlowDone");
        }
        this.bDq = true;
        XA();
        return this;
    }

    public HybridUbcFlow Xm() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "h5FlowDone");
        }
        this.bDr = true;
        XA();
        return this;
    }

    public HybridUbcFlow Xn() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "webViewWidgetDone");
        }
        this.bDu = true;
        XA();
        return this;
    }

    public HybridUbcFlow Xo() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naPaintFlowDone");
        }
        this.bDs = true;
        XA();
        return this;
    }

    public HybridUbcFlow Xp() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "webwidgetPaintDone");
        }
        this.bDt = true;
        XA();
        return this;
    }

    public boolean Xq() {
        return this.bDp;
    }

    public boolean Xr() {
        return this.bDq;
    }

    public boolean Xs() {
        return this.bDr;
    }

    public boolean Xt() {
        return this.bDs;
    }

    public boolean Xu() {
        return this.bDt;
    }

    public boolean Xv() {
        return this.bDu;
    }

    private boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.bDm) {
            isEmpty = this.bDm.isEmpty();
        }
        return isEmpty;
    }

    public void Xw() {
        UbcFlowEvent ubcFlowEvent;
        synchronized (this.bDm) {
            this.bDo.clear();
            for (String str : this.bDm) {
                if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.bDn.get(str)) != null && ubcFlowEvent.XG() > 0) {
                    this.bDo.add(ubcFlowEvent);
                }
            }
            Xx();
        }
    }

    private void Xx() {
        Collections.sort(this.bDo, new Comparator<UbcFlowEvent>() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(UbcFlowEvent ubcFlowEvent, UbcFlowEvent ubcFlowEvent2) {
                return Long.compare(ubcFlowEvent.XG(), ubcFlowEvent2.XG());
            }
        });
    }

    public HybridUbcFlow a(SubmitStrategy submitStrategy) {
        if (submitStrategy != null) {
            this.bDx = submitStrategy;
        }
        return this;
    }

    public SubmitStrategy Xy() {
        return this.bDx;
    }

    private boolean Xz() {
        return (this.bDx == null ? bDw : this.bDx).submitAllowed(this);
    }

    private void XA() {
        if (Xz()) {
            XB();
        }
    }

    private synchronized void XB() {
        if (!this.bDv) {
            this.bDv = true;
            jF("callback_on_submit");
            m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow.this.XC();
                }
            }, "HybridUbcFlow");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XC() {
        Xw();
        jF("component_reporter");
        if (!TextUtils.isEmpty(this.bDj)) {
            Flow qM = s.qM(this.bDj);
            for (UbcFlowEvent ubcFlowEvent : this.bDo) {
                if (!ubcFlowEvent.XI()) {
                    qM.addEvent(ubcFlowEvent.id, ubcFlowEvent.value(), ubcFlowEvent.XG());
                }
            }
            if (!isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, String> entry : this.bDl.entrySet()) {
                        String key = entry.getKey();
                        if (!TextUtils.isEmpty(key)) {
                            String value = entry.getValue();
                            if (value == null) {
                                value = "";
                            }
                            jSONObject.put(key, value);
                        }
                    }
                    k("ext", jSONObject);
                } catch (Exception e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
                qM.setValueWithDuration(this.bDk.toString());
                qM.end();
            }
        }
    }

    private void jF(String str) {
        List<a> list = this.bDy.get(str);
        if (list != null && !list.isEmpty()) {
            for (a aVar : list) {
                if (aVar != null && aVar.bDB != null) {
                    aVar.bDB.B(this);
                }
            }
        }
    }

    public HybridUbcFlow c(String str, com.baidu.swan.apps.as.d.b<HybridUbcFlow> bVar) {
        a aVar = new a(str, bVar);
        if (aVar.XD()) {
            synchronized (this.bDy) {
                List<a> list = this.bDy.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                    this.bDy.put(str, list);
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
        if (r1.XG() < 1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
        if (r0.XG() >= 1) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:?, code lost:
        return r1.XG() - r0.XG();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long o(String... strArr) {
        UbcFlowEvent ubcFlowEvent;
        int length = strArr.length;
        int i = 0;
        UbcFlowEvent ubcFlowEvent2 = null;
        while (true) {
            if (i >= length) {
                ubcFlowEvent = null;
                break;
            }
            ubcFlowEvent = this.bDn.get(strArr[i]);
            if (ubcFlowEvent2 == null) {
                if (ubcFlowEvent == null || ubcFlowEvent.XG() < 1) {
                    break;
                }
            } else if (ubcFlowEvent != null && ubcFlowEvent.XG() > 0) {
                break;
            } else {
                ubcFlowEvent = ubcFlowEvent2;
            }
            i++;
            ubcFlowEvent2 = ubcFlowEvent;
        }
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a {
        final com.baidu.swan.apps.as.d.b<HybridUbcFlow> bDB;
        final String type;

        private a(String str, com.baidu.swan.apps.as.d.b<HybridUbcFlow> bVar) {
            this.type = str;
            this.bDB = bVar;
        }

        boolean XD() {
            return (this.bDB == null || TextUtils.isEmpty(this.type)) ? false : true;
        }
    }
}
