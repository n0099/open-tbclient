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
    public static final SubmitStrategy aZE = SubmitStrategy.HYBRID;
    private String aZt;
    public final String name;
    private final JSONObject aZu = new JSONObject();
    private final Map<String, String> aZv = new HashMap();
    public final List<String> aZw = new ArrayList();
    private final Map<String, UbcFlowEvent> aZx = new HashMap();
    public final List<UbcFlowEvent> aZy = new ArrayList();
    private boolean aZz = false;
    private boolean aZA = false;
    private boolean aZB = false;
    private boolean aZC = false;
    private boolean aZD = false;
    private SubmitStrategy aZF = aZE;
    private final Map<ExtensionType, List<a>> aZG = new HashMap();

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
                return hybridUbcFlow.Nq() && hybridUbcFlow.Nt() && hybridUbcFlow.Ns();
            }
        },
        RELAUNCH { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.2
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.Nq() && hybridUbcFlow.Nt();
            }
        },
        NA_ONLY { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.3
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.Nq();
            }
        };

        abstract boolean submitAllowed(HybridUbcFlow hybridUbcFlow);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HybridUbcFlow(String str) {
        this.name = str;
    }

    public HybridUbcFlow gC(String str) {
        this.aZt = str;
        return this;
    }

    private void a(UbcFlowEvent ubcFlowEvent) {
        this.aZw.remove(ubcFlowEvent.id);
        this.aZw.add(ubcFlowEvent.id);
        this.aZx.put(ubcFlowEvent.id, ubcFlowEvent);
    }

    private void b(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.aZx.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.NL() > ubcFlowEvent2.NL()) {
            a(ubcFlowEvent);
        }
    }

    private void c(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.aZx.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.NL() < ubcFlowEvent2.NL()) {
            a(ubcFlowEvent);
        }
    }

    private void d(UbcFlowEvent ubcFlowEvent) {
        if (!e(this.aZx.get(ubcFlowEvent.id))) {
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
            synchronized (this.aZw) {
                switch (ubcFlowEvent.NO()) {
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
        synchronized (this.aZw) {
            for (UbcFlowEvent ubcFlowEvent : list) {
                f(ubcFlowEvent);
            }
        }
        return this;
    }

    public HybridUbcFlow az(String str, String str2) {
        this.aZv.put(str, str2);
        return this;
    }

    public String gD(String str) {
        return this.aZv.get(str);
    }

    public HybridUbcFlow b(HybridUbcFlow hybridUbcFlow) {
        if (hybridUbcFlow != null) {
            hybridUbcFlow.Nu();
            X(hybridUbcFlow.aZy);
            this.aZv.putAll(hybridUbcFlow.aZv);
        }
        return this;
    }

    public HybridUbcFlow g(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.aZu.put(str, obj);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return this;
    }

    public JSONObject Nl() {
        return this.aZu;
    }

    public HybridUbcFlow Nm() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naFlowDone");
        }
        this.aZz = true;
        Nx();
        return this;
    }

    public HybridUbcFlow Nn() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naExtDone");
        }
        this.aZA = true;
        Nx();
        return this;
    }

    public HybridUbcFlow No() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naAnimFlowDone");
        }
        this.aZB = true;
        Nx();
        return this;
    }

    public HybridUbcFlow Np() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "h5FlowDone");
        }
        this.aZC = true;
        Nx();
        return this;
    }

    public boolean Nq() {
        return this.aZz;
    }

    public boolean Nr() {
        return this.aZA;
    }

    public boolean Ns() {
        return this.aZB;
    }

    public boolean Nt() {
        return this.aZC;
    }

    private boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.aZw) {
            isEmpty = this.aZw.isEmpty();
        }
        return isEmpty;
    }

    public void Nu() {
        UbcFlowEvent ubcFlowEvent;
        synchronized (this.aZw) {
            this.aZy.clear();
            for (String str : this.aZw) {
                if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.aZx.get(str)) != null && ubcFlowEvent.NL() > 0) {
                    this.aZy.add(ubcFlowEvent);
                }
            }
            Nv();
        }
    }

    private void Nv() {
        Collections.sort(this.aZy, new Comparator<UbcFlowEvent>() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(UbcFlowEvent ubcFlowEvent, UbcFlowEvent ubcFlowEvent2) {
                return Long.compare(ubcFlowEvent.NL(), ubcFlowEvent2.NL());
            }
        });
    }

    public HybridUbcFlow a(SubmitStrategy submitStrategy) {
        if (submitStrategy != null) {
            this.aZF = submitStrategy;
        }
        return this;
    }

    private boolean Nw() {
        boolean submitAllowed = (this.aZF == null ? aZE : this.aZF).submitAllowed(this);
        if (f.bab) {
            return submitAllowed;
        }
        return Nr() && submitAllowed;
    }

    private void Nx() {
        if (Nw()) {
            Ny();
        }
    }

    private void Ny() {
        if (!this.aZD) {
            this.aZD = true;
            a(ExtensionType.CALLBACK_ON_SUBMIT);
            j.b(new Runnable() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow.this.Nz();
                    HybridUbcFlow.this.aZD = false;
                }
            }, "HybridUbcFlow");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nz() {
        Nu();
        a(ExtensionType.COMPONENT_REPORTER);
        if (!TextUtils.isEmpty(this.aZt)) {
            Flow lD = s.lD(this.aZt);
            for (UbcFlowEvent ubcFlowEvent : this.aZy) {
                if (!ubcFlowEvent.NN()) {
                    lD.addEvent(ubcFlowEvent.id, ubcFlowEvent.value(), ubcFlowEvent.NL());
                }
            }
            if (!isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, String> entry : this.aZv.entrySet()) {
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
                lD.setValueWithDuration(this.aZu.toString());
                lD.end();
            }
        }
    }

    private void a(ExtensionType extensionType) {
        List<a> list = this.aZG.get(extensionType);
        if (list != null && !list.isEmpty()) {
            for (a aVar : list) {
                if (aVar != null && aVar.aZK != null) {
                    aVar.aZK.B(this);
                }
            }
        }
    }

    public HybridUbcFlow a(ExtensionType extensionType, com.baidu.swan.apps.an.d.a<HybridUbcFlow> aVar) {
        a aVar2 = new a(extensionType, aVar);
        if (aVar2.NA()) {
            synchronized (this.aZG) {
                List<a> list = this.aZG.get(extensionType);
                if (list == null) {
                    list = new ArrayList<>();
                    this.aZG.put(extensionType, list);
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
        if (r1.NL() < 1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
        if (r0.NL() >= 1) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:?, code lost:
        return r1.NL() - r0.NL();
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
            ubcFlowEvent = this.aZx.get(strArr[i]);
            if (ubcFlowEvent2 == null) {
                if (ubcFlowEvent == null || ubcFlowEvent.NL() < 1) {
                    break;
                }
            } else if (ubcFlowEvent != null && ubcFlowEvent.NL() > 0) {
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
        final ExtensionType aZJ;
        final com.baidu.swan.apps.an.d.a<HybridUbcFlow> aZK;

        private a(ExtensionType extensionType, com.baidu.swan.apps.an.d.a<HybridUbcFlow> aVar) {
            this.aZJ = extensionType;
            this.aZK = aVar;
        }

        boolean NA() {
            return (this.aZJ == null || this.aZK == null) ? false : true;
        }
    }
}
