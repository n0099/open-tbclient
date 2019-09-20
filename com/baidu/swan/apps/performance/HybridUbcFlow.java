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
    public static final SubmitStrategy aGH = SubmitStrategy.HYBRID;
    private String aGw;
    public final String name;
    private final JSONObject aGx = new JSONObject();
    private final Map<String, String> aGy = new HashMap();
    public final List<String> aGz = new ArrayList();
    private final Map<String, UbcFlowEvent> aGA = new HashMap();
    public final List<UbcFlowEvent> aGB = new ArrayList();
    private boolean aGC = false;
    private boolean aGD = false;
    private boolean aGE = false;
    private boolean aGF = false;
    private boolean aGG = false;
    private SubmitStrategy aGI = aGH;
    private final Map<ExtensionType, List<a>> aGJ = new HashMap();

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
                return hybridUbcFlow.Iv() && hybridUbcFlow.Iy() && hybridUbcFlow.Ix();
            }
        },
        RELAUNCH { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.2
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.Iv() && hybridUbcFlow.Iy();
            }
        },
        NA_ONLY { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.3
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.Iv();
            }
        };

        abstract boolean submitAllowed(HybridUbcFlow hybridUbcFlow);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HybridUbcFlow(String str) {
        this.name = str;
    }

    public HybridUbcFlow fX(String str) {
        this.aGw = str;
        return this;
    }

    private void a(UbcFlowEvent ubcFlowEvent) {
        this.aGz.remove(ubcFlowEvent.id);
        this.aGz.add(ubcFlowEvent.id);
        this.aGA.put(ubcFlowEvent.id, ubcFlowEvent);
    }

    private void b(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.aGA.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.IQ() > ubcFlowEvent2.IQ()) {
            a(ubcFlowEvent);
        }
    }

    private void c(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.aGA.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.IQ() < ubcFlowEvent2.IQ()) {
            a(ubcFlowEvent);
        }
    }

    private void d(UbcFlowEvent ubcFlowEvent) {
        if (!e(this.aGA.get(ubcFlowEvent.id))) {
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
            synchronized (this.aGz) {
                switch (ubcFlowEvent.IT()) {
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
        synchronized (this.aGz) {
            for (UbcFlowEvent ubcFlowEvent : list) {
                f(ubcFlowEvent);
            }
        }
        return this;
    }

    public HybridUbcFlow ar(String str, String str2) {
        this.aGy.put(str, str2);
        return this;
    }

    public String fY(String str) {
        return this.aGy.get(str);
    }

    public HybridUbcFlow b(HybridUbcFlow hybridUbcFlow) {
        if (hybridUbcFlow != null) {
            hybridUbcFlow.Iz();
            y(hybridUbcFlow.aGB);
            this.aGy.putAll(hybridUbcFlow.aGy);
        }
        return this;
    }

    public HybridUbcFlow j(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.aGx.put(str, obj);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return this;
    }

    public JSONObject Iq() {
        return this.aGx;
    }

    public HybridUbcFlow Ir() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naFlowDone");
        }
        this.aGC = true;
        IC();
        return this;
    }

    public HybridUbcFlow Is() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naExtDone");
        }
        this.aGD = true;
        IC();
        return this;
    }

    public HybridUbcFlow It() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naAnimFlowDone");
        }
        this.aGE = true;
        IC();
        return this;
    }

    public HybridUbcFlow Iu() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "h5FlowDone");
        }
        this.aGF = true;
        IC();
        return this;
    }

    public boolean Iv() {
        return this.aGC;
    }

    public boolean Iw() {
        return this.aGD;
    }

    public boolean Ix() {
        return this.aGE;
    }

    public boolean Iy() {
        return this.aGF;
    }

    private boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.aGz) {
            isEmpty = this.aGz.isEmpty();
        }
        return isEmpty;
    }

    public void Iz() {
        UbcFlowEvent ubcFlowEvent;
        synchronized (this.aGz) {
            this.aGB.clear();
            for (String str : this.aGz) {
                if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.aGA.get(str)) != null && ubcFlowEvent.IQ() > 0) {
                    this.aGB.add(ubcFlowEvent);
                }
            }
            IA();
        }
    }

    private void IA() {
        Collections.sort(this.aGB, new Comparator<UbcFlowEvent>() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(UbcFlowEvent ubcFlowEvent, UbcFlowEvent ubcFlowEvent2) {
                return Long.compare(ubcFlowEvent.IQ(), ubcFlowEvent2.IQ());
            }
        });
    }

    public HybridUbcFlow a(SubmitStrategy submitStrategy) {
        if (submitStrategy != null) {
            this.aGI = submitStrategy;
        }
        return this;
    }

    private boolean IB() {
        boolean submitAllowed = (this.aGI == null ? aGH : this.aGI).submitAllowed(this);
        if (f.aHe) {
            return submitAllowed;
        }
        return Iw() && submitAllowed;
    }

    private void IC() {
        if (IB()) {
            ID();
        }
    }

    private void ID() {
        if (!this.aGG) {
            this.aGG = true;
            a(ExtensionType.CALLBACK_ON_SUBMIT);
            j.b(new Runnable() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow.this.IE();
                    HybridUbcFlow.this.aGG = false;
                }
            }, "HybridUbcFlow");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IE() {
        Iz();
        a(ExtensionType.COMPONENT_REPORTER);
        if (!TextUtils.isEmpty(this.aGw)) {
            Flow lb = s.lb(this.aGw);
            for (UbcFlowEvent ubcFlowEvent : this.aGB) {
                if (!ubcFlowEvent.IS()) {
                    lb.addEvent(ubcFlowEvent.id, ubcFlowEvent.value(), ubcFlowEvent.IQ());
                }
            }
            if (!isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, String> entry : this.aGy.entrySet()) {
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
                lb.setValueWithDuration(this.aGx.toString());
                lb.end();
            }
        }
    }

    private void a(ExtensionType extensionType) {
        List<a> list = this.aGJ.get(extensionType);
        if (list != null && !list.isEmpty()) {
            for (a aVar : list) {
                if (aVar != null && aVar.aGN != null) {
                    aVar.aGN.D(this);
                }
            }
        }
    }

    public HybridUbcFlow a(ExtensionType extensionType, com.baidu.swan.apps.an.d.a<HybridUbcFlow> aVar) {
        a aVar2 = new a(extensionType, aVar);
        if (aVar2.IF()) {
            synchronized (this.aGJ) {
                List<a> list = this.aGJ.get(extensionType);
                if (list == null) {
                    list = new ArrayList<>();
                    this.aGJ.put(extensionType, list);
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
        if (r1.IQ() < 1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
        if (r0.IQ() >= 1) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:?, code lost:
        return r1.IQ() - r0.IQ();
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
            ubcFlowEvent = this.aGA.get(strArr[i]);
            if (ubcFlowEvent2 == null) {
                if (ubcFlowEvent == null || ubcFlowEvent.IQ() < 1) {
                    break;
                }
            } else if (ubcFlowEvent != null && ubcFlowEvent.IQ() > 0) {
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
        final ExtensionType aGM;
        final com.baidu.swan.apps.an.d.a<HybridUbcFlow> aGN;

        private a(ExtensionType extensionType, com.baidu.swan.apps.an.d.a<HybridUbcFlow> aVar) {
            this.aGM = extensionType;
            this.aGN = aVar;
        }

        boolean IF() {
            return (this.aGM == null || this.aGN == null) ? false : true;
        }
    }
}
