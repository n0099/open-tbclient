package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.an.j;
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
/* loaded from: classes2.dex */
public final class HybridUbcFlow {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final SubmitStrategy aZW = SubmitStrategy.HYBRID;
    private String aZL;
    private final JSONObject aZM = new JSONObject();
    private final Map<String, String> aZN = new HashMap();
    public final List<String> aZO = new ArrayList();
    private final Map<String, UbcFlowEvent> aZP = new HashMap();
    public final List<UbcFlowEvent> aZQ = new ArrayList();
    private boolean aZR = false;
    private boolean aZS = false;
    private boolean aZT = false;
    private boolean aZU = false;
    private boolean aZV = false;
    private SubmitStrategy aZX = aZW;
    private final Map<ExtensionType, List<a>> aZY = new HashMap();
    public final String name;

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
                return hybridUbcFlow.Np() && hybridUbcFlow.Ns() && hybridUbcFlow.Nr();
            }
        },
        RELAUNCH { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.2
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.Np() && hybridUbcFlow.Ns();
            }
        },
        NA_ONLY { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.3
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.Np();
            }
        };

        abstract boolean submitAllowed(HybridUbcFlow hybridUbcFlow);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HybridUbcFlow(String str) {
        this.name = str;
    }

    public HybridUbcFlow gC(String str) {
        this.aZL = str;
        return this;
    }

    private void a(UbcFlowEvent ubcFlowEvent) {
        this.aZO.remove(ubcFlowEvent.id);
        this.aZO.add(ubcFlowEvent.id);
        this.aZP.put(ubcFlowEvent.id, ubcFlowEvent);
    }

    private void b(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.aZP.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.NK() > ubcFlowEvent2.NK()) {
            a(ubcFlowEvent);
        }
    }

    private void c(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.aZP.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.NK() < ubcFlowEvent2.NK()) {
            a(ubcFlowEvent);
        }
    }

    private void d(UbcFlowEvent ubcFlowEvent) {
        if (!e(this.aZP.get(ubcFlowEvent.id))) {
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
            synchronized (this.aZO) {
                switch (ubcFlowEvent.NN()) {
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

    public HybridUbcFlow X(List<UbcFlowEvent> list) {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "record events size = " + list.size());
        }
        synchronized (this.aZO) {
            for (UbcFlowEvent ubcFlowEvent : list) {
                f(ubcFlowEvent);
            }
        }
        return this;
    }

    public HybridUbcFlow az(String str, String str2) {
        this.aZN.put(str, str2);
        return this;
    }

    public String gD(String str) {
        return this.aZN.get(str);
    }

    public HybridUbcFlow b(HybridUbcFlow hybridUbcFlow) {
        if (hybridUbcFlow != null) {
            hybridUbcFlow.Nt();
            X(hybridUbcFlow.aZQ);
            this.aZN.putAll(hybridUbcFlow.aZN);
        }
        return this;
    }

    public HybridUbcFlow g(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.aZM.put(str, obj);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return this;
    }

    public JSONObject Nk() {
        return this.aZM;
    }

    public HybridUbcFlow Nl() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naFlowDone");
        }
        this.aZR = true;
        Nw();
        return this;
    }

    public HybridUbcFlow Nm() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naExtDone");
        }
        this.aZS = true;
        Nw();
        return this;
    }

    public HybridUbcFlow Nn() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naAnimFlowDone");
        }
        this.aZT = true;
        Nw();
        return this;
    }

    public HybridUbcFlow No() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "h5FlowDone");
        }
        this.aZU = true;
        Nw();
        return this;
    }

    public boolean Np() {
        return this.aZR;
    }

    public boolean Nq() {
        return this.aZS;
    }

    public boolean Nr() {
        return this.aZT;
    }

    public boolean Ns() {
        return this.aZU;
    }

    private boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.aZO) {
            isEmpty = this.aZO.isEmpty();
        }
        return isEmpty;
    }

    public void Nt() {
        UbcFlowEvent ubcFlowEvent;
        synchronized (this.aZO) {
            this.aZQ.clear();
            for (String str : this.aZO) {
                if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.aZP.get(str)) != null && ubcFlowEvent.NK() > 0) {
                    this.aZQ.add(ubcFlowEvent);
                }
            }
            Nu();
        }
    }

    private void Nu() {
        Collections.sort(this.aZQ, new Comparator<UbcFlowEvent>() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(UbcFlowEvent ubcFlowEvent, UbcFlowEvent ubcFlowEvent2) {
                return Long.compare(ubcFlowEvent.NK(), ubcFlowEvent2.NK());
            }
        });
    }

    public HybridUbcFlow a(SubmitStrategy submitStrategy) {
        if (submitStrategy != null) {
            this.aZX = submitStrategy;
        }
        return this;
    }

    private boolean Nv() {
        boolean submitAllowed = (this.aZX == null ? aZW : this.aZX).submitAllowed(this);
        if (f.bat) {
            return submitAllowed;
        }
        return Nq() && submitAllowed;
    }

    private void Nw() {
        if (Nv()) {
            Nx();
        }
    }

    private void Nx() {
        if (!this.aZV) {
            this.aZV = true;
            a(ExtensionType.CALLBACK_ON_SUBMIT);
            j.b(new Runnable() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow.this.Ny();
                    HybridUbcFlow.this.aZV = false;
                }
            }, "HybridUbcFlow");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ny() {
        Nt();
        a(ExtensionType.COMPONENT_REPORTER);
        if (!TextUtils.isEmpty(this.aZL)) {
            Flow lD = s.lD(this.aZL);
            for (UbcFlowEvent ubcFlowEvent : this.aZQ) {
                if (!ubcFlowEvent.NM()) {
                    lD.addEvent(ubcFlowEvent.id, ubcFlowEvent.value(), ubcFlowEvent.NK());
                }
            }
            if (!isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, String> entry : this.aZN.entrySet()) {
                        String key = entry.getKey();
                        if (!TextUtils.isEmpty(key)) {
                            String value = entry.getValue();
                            if (value == null) {
                                value = "";
                            }
                            jSONObject.put(key, value);
                        }
                    }
                    g("ext", jSONObject);
                } catch (Exception e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
                lD.setValueWithDuration(this.aZM.toString());
                lD.end();
            }
        }
    }

    private void a(ExtensionType extensionType) {
        List<a> list = this.aZY.get(extensionType);
        if (list != null && !list.isEmpty()) {
            for (a aVar : list) {
                if (aVar != null && aVar.bac != null) {
                    aVar.bac.B(this);
                }
            }
        }
    }

    public HybridUbcFlow a(ExtensionType extensionType, com.baidu.swan.apps.an.d.a<HybridUbcFlow> aVar) {
        a aVar2 = new a(extensionType, aVar);
        if (aVar2.Nz()) {
            synchronized (this.aZY) {
                List<a> list = this.aZY.get(extensionType);
                if (list == null) {
                    list = new ArrayList<>();
                    this.aZY.put(extensionType, list);
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
        if (r1.NK() < 1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
        if (r0.NK() >= 1) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:?, code lost:
        return r1.NK() - r0.NK();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long l(String... strArr) {
        UbcFlowEvent ubcFlowEvent;
        int length = strArr.length;
        int i = 0;
        UbcFlowEvent ubcFlowEvent2 = null;
        while (true) {
            if (i >= length) {
                ubcFlowEvent = null;
                break;
            }
            ubcFlowEvent = this.aZP.get(strArr[i]);
            if (ubcFlowEvent2 == null) {
                if (ubcFlowEvent == null || ubcFlowEvent.NK() < 1) {
                    break;
                }
            } else if (ubcFlowEvent != null && ubcFlowEvent.NK() > 0) {
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
        final ExtensionType bab;
        final com.baidu.swan.apps.an.d.a<HybridUbcFlow> bac;

        private a(ExtensionType extensionType, com.baidu.swan.apps.an.d.a<HybridUbcFlow> aVar) {
            this.bab = extensionType;
            this.bac = aVar;
        }

        boolean Nz() {
            return (this.bab == null || this.bac == null) ? false : true;
        }
    }
}
