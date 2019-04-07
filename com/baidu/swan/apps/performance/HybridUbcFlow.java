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
    public static final SubmitStrategy aDI = SubmitStrategy.HYBRID;
    private String aDx;
    public final String name;
    private final JSONObject aDy = new JSONObject();
    private final Map<String, String> aDz = new HashMap();
    public final List<String> aDA = new ArrayList();
    private final Map<String, UbcFlowEvent> aDB = new HashMap();
    public final List<UbcFlowEvent> aDC = new ArrayList();
    private boolean aDD = false;
    private boolean aDE = false;
    private boolean aDF = false;
    private boolean aDG = false;
    private boolean aDH = false;
    private SubmitStrategy aDJ = aDI;
    private final Map<ExtensionType, List<a>> aDK = new HashMap();

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
        this.aDx = str;
        return this;
    }

    private void a(UbcFlowEvent ubcFlowEvent) {
        this.aDA.remove(ubcFlowEvent.id);
        this.aDA.add(ubcFlowEvent.id);
        this.aDB.put(ubcFlowEvent.id, ubcFlowEvent);
    }

    private void b(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.aDB.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.FR() > ubcFlowEvent2.FR()) {
            a(ubcFlowEvent);
        }
    }

    private void c(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.aDB.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.FR() < ubcFlowEvent2.FR()) {
            a(ubcFlowEvent);
        }
    }

    private void d(UbcFlowEvent ubcFlowEvent) {
        if (!e(this.aDB.get(ubcFlowEvent.id))) {
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
            synchronized (this.aDA) {
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
        synchronized (this.aDA) {
            for (UbcFlowEvent ubcFlowEvent : list) {
                f(ubcFlowEvent);
            }
        }
        return this;
    }

    public HybridUbcFlow aq(String str, String str2) {
        this.aDz.put(str, str2);
        return this;
    }

    public String fD(String str) {
        return this.aDz.get(str);
    }

    public HybridUbcFlow b(HybridUbcFlow hybridUbcFlow) {
        if (hybridUbcFlow != null) {
            hybridUbcFlow.FB();
            x(hybridUbcFlow.aDC);
            this.aDz.putAll(hybridUbcFlow.aDz);
        }
        return this;
    }

    public HybridUbcFlow i(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.aDy.put(str, obj);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return this;
    }

    public JSONObject Fs() {
        return this.aDy;
    }

    public HybridUbcFlow Ft() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naFlowDone");
        }
        this.aDD = true;
        FD();
        return this;
    }

    public HybridUbcFlow Fu() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naExtDone");
        }
        this.aDE = true;
        FD();
        return this;
    }

    public HybridUbcFlow Fv() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naAnimFlowDone");
        }
        this.aDF = true;
        FD();
        return this;
    }

    public HybridUbcFlow Fw() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "h5FlowDone");
        }
        this.aDG = true;
        FD();
        return this;
    }

    public boolean Fx() {
        return this.aDD;
    }

    public boolean Fy() {
        return this.aDE;
    }

    public boolean Fz() {
        return this.aDF;
    }

    public boolean FA() {
        return this.aDG;
    }

    private boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.aDA) {
            isEmpty = this.aDA.isEmpty();
        }
        return isEmpty;
    }

    public void FB() {
        UbcFlowEvent ubcFlowEvent;
        synchronized (this.aDA) {
            this.aDC.clear();
            for (String str : this.aDA) {
                if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.aDB.get(str)) != null && ubcFlowEvent.FR() > 0) {
                    this.aDC.add(ubcFlowEvent);
                }
            }
            sort();
        }
    }

    private void sort() {
        Collections.sort(this.aDC, new Comparator<UbcFlowEvent>() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.1
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
            this.aDJ = submitStrategy;
        }
        return this;
    }

    private boolean FC() {
        boolean submitAllowed = (this.aDJ == null ? aDI : this.aDJ).submitAllowed(this);
        if (f.aEf) {
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
        if (!this.aDH) {
            this.aDH = true;
            a(ExtensionType.CALLBACK_ON_SUBMIT);
            j.b(new Runnable() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow.this.FF();
                    HybridUbcFlow.this.aDH = false;
                }
            }, "HybridUbcFlow");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FF() {
        FB();
        a(ExtensionType.COMPONENT_REPORTER);
        if (!TextUtils.isEmpty(this.aDx)) {
            Flow jT = q.jT(this.aDx);
            for (UbcFlowEvent ubcFlowEvent : this.aDC) {
                if (!ubcFlowEvent.FT()) {
                    jT.addEvent(ubcFlowEvent.id, ubcFlowEvent.value(), ubcFlowEvent.FR());
                }
            }
            if (!isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, String> entry : this.aDz.entrySet()) {
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
                jT.setValueWithDuration(this.aDy.toString());
                jT.end();
            }
        }
    }

    private void a(ExtensionType extensionType) {
        List<a> list = this.aDK.get(extensionType);
        if (list != null && !list.isEmpty()) {
            for (a aVar : list) {
                if (aVar != null && aVar.aDO != null) {
                    aVar.aDO.D(this);
                }
            }
        }
    }

    public HybridUbcFlow a(ExtensionType extensionType, com.baidu.swan.apps.an.c.a<HybridUbcFlow> aVar) {
        a aVar2 = new a(extensionType, aVar);
        if (aVar2.FG()) {
            synchronized (this.aDK) {
                List<a> list = this.aDK.get(extensionType);
                if (list == null) {
                    list = new ArrayList<>();
                    this.aDK.put(extensionType, list);
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
            ubcFlowEvent = this.aDB.get(strArr[i]);
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
        final ExtensionType aDN;
        final com.baidu.swan.apps.an.c.a<HybridUbcFlow> aDO;

        private a(ExtensionType extensionType, com.baidu.swan.apps.an.c.a<HybridUbcFlow> aVar) {
            this.aDN = extensionType;
            this.aDO = aVar;
        }

        boolean FG() {
            return (this.aDN == null || this.aDO == null) ? false : true;
        }
    }
}
