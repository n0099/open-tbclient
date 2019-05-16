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
    public static final SubmitStrategy aFB = SubmitStrategy.HYBRID;
    private String aFq;
    public final String name;
    private final JSONObject aFr = new JSONObject();
    private final Map<String, String> aFs = new HashMap();
    public final List<String> aFt = new ArrayList();
    private final Map<String, UbcFlowEvent> aFu = new HashMap();
    public final List<UbcFlowEvent> aFv = new ArrayList();
    private boolean aFw = false;
    private boolean aFx = false;
    private boolean aFy = false;
    private boolean aFz = false;
    private boolean aFA = false;
    private SubmitStrategy aFC = aFB;
    private final Map<ExtensionType, List<a>> aFD = new HashMap();

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
                return hybridUbcFlow.HF() && hybridUbcFlow.HI() && hybridUbcFlow.HH();
            }
        },
        RELAUNCH { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.2
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.HF() && hybridUbcFlow.HI();
            }
        },
        NA_ONLY { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.3
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.HF();
            }
        };

        abstract boolean submitAllowed(HybridUbcFlow hybridUbcFlow);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HybridUbcFlow(String str) {
        this.name = str;
    }

    public HybridUbcFlow fR(String str) {
        this.aFq = str;
        return this;
    }

    private void a(UbcFlowEvent ubcFlowEvent) {
        this.aFt.remove(ubcFlowEvent.id);
        this.aFt.add(ubcFlowEvent.id);
        this.aFu.put(ubcFlowEvent.id, ubcFlowEvent);
    }

    private void b(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.aFu.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.HZ() > ubcFlowEvent2.HZ()) {
            a(ubcFlowEvent);
        }
    }

    private void c(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.aFu.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.HZ() < ubcFlowEvent2.HZ()) {
            a(ubcFlowEvent);
        }
    }

    private void d(UbcFlowEvent ubcFlowEvent) {
        if (!e(this.aFu.get(ubcFlowEvent.id))) {
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
            synchronized (this.aFt) {
                switch (ubcFlowEvent.Ic()) {
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

    public HybridUbcFlow y(List<UbcFlowEvent> list) {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "record events size = " + list.size());
        }
        synchronized (this.aFt) {
            for (UbcFlowEvent ubcFlowEvent : list) {
                f(ubcFlowEvent);
            }
        }
        return this;
    }

    public HybridUbcFlow ar(String str, String str2) {
        this.aFs.put(str, str2);
        return this;
    }

    public String fS(String str) {
        return this.aFs.get(str);
    }

    public HybridUbcFlow b(HybridUbcFlow hybridUbcFlow) {
        if (hybridUbcFlow != null) {
            hybridUbcFlow.HJ();
            y(hybridUbcFlow.aFv);
            this.aFs.putAll(hybridUbcFlow.aFs);
        }
        return this;
    }

    public HybridUbcFlow j(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.aFr.put(str, obj);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return this;
    }

    public JSONObject HA() {
        return this.aFr;
    }

    public HybridUbcFlow HB() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naFlowDone");
        }
        this.aFw = true;
        HL();
        return this;
    }

    public HybridUbcFlow HC() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naExtDone");
        }
        this.aFx = true;
        HL();
        return this;
    }

    public HybridUbcFlow HD() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naAnimFlowDone");
        }
        this.aFy = true;
        HL();
        return this;
    }

    public HybridUbcFlow HE() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "h5FlowDone");
        }
        this.aFz = true;
        HL();
        return this;
    }

    public boolean HF() {
        return this.aFw;
    }

    public boolean HG() {
        return this.aFx;
    }

    public boolean HH() {
        return this.aFy;
    }

    public boolean HI() {
        return this.aFz;
    }

    private boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.aFt) {
            isEmpty = this.aFt.isEmpty();
        }
        return isEmpty;
    }

    public void HJ() {
        UbcFlowEvent ubcFlowEvent;
        synchronized (this.aFt) {
            this.aFv.clear();
            for (String str : this.aFt) {
                if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.aFu.get(str)) != null && ubcFlowEvent.HZ() > 0) {
                    this.aFv.add(ubcFlowEvent);
                }
            }
            sort();
        }
    }

    private void sort() {
        Collections.sort(this.aFv, new Comparator<UbcFlowEvent>() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(UbcFlowEvent ubcFlowEvent, UbcFlowEvent ubcFlowEvent2) {
                return Long.compare(ubcFlowEvent.HZ(), ubcFlowEvent2.HZ());
            }
        });
    }

    public HybridUbcFlow a(SubmitStrategy submitStrategy) {
        if (submitStrategy != null) {
            this.aFC = submitStrategy;
        }
        return this;
    }

    private boolean HK() {
        boolean submitAllowed = (this.aFC == null ? aFB : this.aFC).submitAllowed(this);
        if (f.aFY) {
            return submitAllowed;
        }
        return HG() && submitAllowed;
    }

    private void HL() {
        if (HK()) {
            HM();
        }
    }

    private void HM() {
        if (!this.aFA) {
            this.aFA = true;
            a(ExtensionType.CALLBACK_ON_SUBMIT);
            j.b(new Runnable() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow.this.HN();
                    HybridUbcFlow.this.aFA = false;
                }
            }, "HybridUbcFlow");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HN() {
        HJ();
        a(ExtensionType.COMPONENT_REPORTER);
        if (!TextUtils.isEmpty(this.aFq)) {
            Flow kS = s.kS(this.aFq);
            for (UbcFlowEvent ubcFlowEvent : this.aFv) {
                if (!ubcFlowEvent.Ib()) {
                    kS.addEvent(ubcFlowEvent.id, ubcFlowEvent.value(), ubcFlowEvent.HZ());
                }
            }
            if (!isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, String> entry : this.aFs.entrySet()) {
                        String key = entry.getKey();
                        if (!TextUtils.isEmpty(key)) {
                            String value = entry.getValue();
                            if (value == null) {
                                value = "";
                            }
                            jSONObject.put(key, value);
                        }
                    }
                    j("ext", jSONObject);
                } catch (Exception e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
                kS.setValueWithDuration(this.aFr.toString());
                kS.end();
            }
        }
    }

    private void a(ExtensionType extensionType) {
        List<a> list = this.aFD.get(extensionType);
        if (list != null && !list.isEmpty()) {
            for (a aVar : list) {
                if (aVar != null && aVar.aFH != null) {
                    aVar.aFH.D(this);
                }
            }
        }
    }

    public HybridUbcFlow a(ExtensionType extensionType, com.baidu.swan.apps.an.d.a<HybridUbcFlow> aVar) {
        a aVar2 = new a(extensionType, aVar);
        if (aVar2.HO()) {
            synchronized (this.aFD) {
                List<a> list = this.aFD.get(extensionType);
                if (list == null) {
                    list = new ArrayList<>();
                    this.aFD.put(extensionType, list);
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
        if (r1.HZ() < 1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
        if (r0.HZ() >= 1) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:?, code lost:
        return r1.HZ() - r0.HZ();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long m(String... strArr) {
        UbcFlowEvent ubcFlowEvent;
        int length = strArr.length;
        int i = 0;
        UbcFlowEvent ubcFlowEvent2 = null;
        while (true) {
            if (i >= length) {
                ubcFlowEvent = null;
                break;
            }
            ubcFlowEvent = this.aFu.get(strArr[i]);
            if (ubcFlowEvent2 == null) {
                if (ubcFlowEvent == null || ubcFlowEvent.HZ() < 1) {
                    break;
                }
            } else if (ubcFlowEvent != null && ubcFlowEvent.HZ() > 0) {
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
        final ExtensionType aFG;
        final com.baidu.swan.apps.an.d.a<HybridUbcFlow> aFH;

        private a(ExtensionType extensionType, com.baidu.swan.apps.an.d.a<HybridUbcFlow> aVar) {
            this.aFG = extensionType;
            this.aFH = aVar;
        }

        boolean HO() {
            return (this.aFG == null || this.aFH == null) ? false : true;
        }
    }
}
