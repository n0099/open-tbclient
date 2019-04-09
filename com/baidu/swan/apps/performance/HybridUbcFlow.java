package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.an.j;
import com.baidu.swan.ubc.Flow;
import com.baidu.swan.ubc.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class HybridUbcFlow {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final SubmitStrategy aDJ = SubmitStrategy.HYBRID;
    private String aDy;
    public final String name;
    private final JSONObject aDz = new JSONObject();
    private final Map<String, String> aDA = new HashMap();
    public final List<String> aDB = new ArrayList();
    private final Map<String, UbcFlowEvent> aDC = new HashMap();
    public final List<UbcFlowEvent> aDD = new ArrayList();
    private boolean aDE = false;
    private boolean aDF = false;
    private boolean aDG = false;
    private boolean aDH = false;
    private boolean aDI = false;
    private SubmitStrategy aDK = aDJ;
    private final Map<ExtensionType, List<a>> aDL = new HashMap();

    /* loaded from: classes2.dex */
    public enum ExtensionType {
        CALLBACK_ON_SUBMIT,
        COMPONENT_REPORTER
    }

    /* loaded from: classes2.dex */
    public enum SubmitStrategy {
        HYBRID { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.1
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.Fx() && hybridUbcFlow.FA() && hybridUbcFlow.Fz();
            }
        },
        RELAUNCH { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.2
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.Fx() && hybridUbcFlow.FA();
            }
        },
        NA_ONLY { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.3
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.Fx();
            }
        };

        abstract boolean submitAllowed(HybridUbcFlow hybridUbcFlow);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HybridUbcFlow(String str) {
        this.name = str;
    }

    public HybridUbcFlow fC(String str) {
        this.aDy = str;
        return this;
    }

    private void a(UbcFlowEvent ubcFlowEvent) {
        this.aDB.remove(ubcFlowEvent.id);
        this.aDB.add(ubcFlowEvent.id);
        this.aDC.put(ubcFlowEvent.id, ubcFlowEvent);
    }

    private void b(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.aDC.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.FR() > ubcFlowEvent2.FR()) {
            a(ubcFlowEvent);
        }
    }

    private void c(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.aDC.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.FR() < ubcFlowEvent2.FR()) {
            a(ubcFlowEvent);
        }
    }

    private void d(UbcFlowEvent ubcFlowEvent) {
        if (!e(this.aDC.get(ubcFlowEvent.id))) {
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
            synchronized (this.aDB) {
                switch (ubcFlowEvent.FU()) {
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

    public HybridUbcFlow x(List<UbcFlowEvent> list) {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "record events size = " + list.size());
        }
        synchronized (this.aDB) {
            for (UbcFlowEvent ubcFlowEvent : list) {
                f(ubcFlowEvent);
            }
        }
        return this;
    }

    public HybridUbcFlow aq(String str, String str2) {
        this.aDA.put(str, str2);
        return this;
    }

    public String fD(String str) {
        return this.aDA.get(str);
    }

    public HybridUbcFlow b(HybridUbcFlow hybridUbcFlow) {
        if (hybridUbcFlow != null) {
            hybridUbcFlow.FB();
            x(hybridUbcFlow.aDD);
            this.aDA.putAll(hybridUbcFlow.aDA);
        }
        return this;
    }

    public HybridUbcFlow i(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.aDz.put(str, obj);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return this;
    }

    public JSONObject Fs() {
        return this.aDz;
    }

    public HybridUbcFlow Ft() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naFlowDone");
        }
        this.aDE = true;
        FD();
        return this;
    }

    public HybridUbcFlow Fu() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naExtDone");
        }
        this.aDF = true;
        FD();
        return this;
    }

    public HybridUbcFlow Fv() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naAnimFlowDone");
        }
        this.aDG = true;
        FD();
        return this;
    }

    public HybridUbcFlow Fw() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "h5FlowDone");
        }
        this.aDH = true;
        FD();
        return this;
    }

    public boolean Fx() {
        return this.aDE;
    }

    public boolean Fy() {
        return this.aDF;
    }

    public boolean Fz() {
        return this.aDG;
    }

    public boolean FA() {
        return this.aDH;
    }

    private boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.aDB) {
            isEmpty = this.aDB.isEmpty();
        }
        return isEmpty;
    }

    public void FB() {
        UbcFlowEvent ubcFlowEvent;
        synchronized (this.aDB) {
            this.aDD.clear();
            for (String str : this.aDB) {
                if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.aDC.get(str)) != null && ubcFlowEvent.FR() > 0) {
                    this.aDD.add(ubcFlowEvent);
                }
            }
            sort();
        }
    }

    private void sort() {
        Collections.sort(this.aDD, new Comparator<UbcFlowEvent>() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(UbcFlowEvent ubcFlowEvent, UbcFlowEvent ubcFlowEvent2) {
                return Long.compare(ubcFlowEvent.FR(), ubcFlowEvent2.FR());
            }
        });
    }

    public HybridUbcFlow a(SubmitStrategy submitStrategy) {
        if (submitStrategy != null) {
            this.aDK = submitStrategy;
        }
        return this;
    }

    private boolean FC() {
        boolean submitAllowed = (this.aDK == null ? aDJ : this.aDK).submitAllowed(this);
        if (f.aEg) {
            return submitAllowed;
        }
        return Fy() && submitAllowed;
    }

    private void FD() {
        if (FC()) {
            FE();
        }
    }

    private void FE() {
        if (!this.aDI) {
            this.aDI = true;
            a(ExtensionType.CALLBACK_ON_SUBMIT);
            j.b(new Runnable() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow.this.FF();
                    HybridUbcFlow.this.aDI = false;
                }
            }, "HybridUbcFlow");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FF() {
        FB();
        a(ExtensionType.COMPONENT_REPORTER);
        if (!TextUtils.isEmpty(this.aDy)) {
            Flow jT = q.jT(this.aDy);
            for (UbcFlowEvent ubcFlowEvent : this.aDD) {
                if (!ubcFlowEvent.FT()) {
                    jT.addEvent(ubcFlowEvent.id, ubcFlowEvent.value(), ubcFlowEvent.FR());
                }
            }
            if (!isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, String> entry : this.aDA.entrySet()) {
                        String key = entry.getKey();
                        if (!TextUtils.isEmpty(key)) {
                            String value = entry.getValue();
                            if (value == null) {
                                value = "";
                            }
                            jSONObject.put(key, value);
                        }
                    }
                    i("ext", jSONObject);
                } catch (Exception e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
                jT.setValueWithDuration(this.aDz.toString());
                jT.end();
            }
        }
    }

    private void a(ExtensionType extensionType) {
        List<a> list = this.aDL.get(extensionType);
        if (list != null && !list.isEmpty()) {
            for (a aVar : list) {
                if (aVar != null && aVar.aDP != null) {
                    aVar.aDP.D(this);
                }
            }
        }
    }

    public HybridUbcFlow a(ExtensionType extensionType, com.baidu.swan.apps.an.c.a<HybridUbcFlow> aVar) {
        a aVar2 = new a(extensionType, aVar);
        if (aVar2.FG()) {
            synchronized (this.aDL) {
                List<a> list = this.aDL.get(extensionType);
                if (list == null) {
                    list = new ArrayList<>();
                    this.aDL.put(extensionType, list);
                }
                list.add(aVar2);
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
        if (r1.FR() < 1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
        if (r0.FR() >= 1) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:?, code lost:
        return r1.FR() - r0.FR();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long n(String... strArr) {
        UbcFlowEvent ubcFlowEvent;
        int length = strArr.length;
        int i = 0;
        UbcFlowEvent ubcFlowEvent2 = null;
        while (true) {
            if (i >= length) {
                ubcFlowEvent = null;
                break;
            }
            ubcFlowEvent = this.aDC.get(strArr[i]);
            if (ubcFlowEvent2 == null) {
                if (ubcFlowEvent == null || ubcFlowEvent.FR() < 1) {
                    break;
                }
            } else if (ubcFlowEvent != null && ubcFlowEvent.FR() > 0) {
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
    /* loaded from: classes2.dex */
    public class a {
        final ExtensionType aDO;
        final com.baidu.swan.apps.an.c.a<HybridUbcFlow> aDP;

        private a(ExtensionType extensionType, com.baidu.swan.apps.an.c.a<HybridUbcFlow> aVar) {
            this.aDO = extensionType;
            this.aDP = aVar;
        }

        boolean FG() {
            return (this.aDO == null || this.aDP == null) ? false : true;
        }
    }
}
