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
    public static final SubmitStrategy aGj = SubmitStrategy.HYBRID;
    private String aFY;
    private final JSONObject aFZ = new JSONObject();
    private final Map<String, String> aGa = new HashMap();
    public final List<String> aGb = new ArrayList();
    private final Map<String, UbcFlowEvent> aGc = new HashMap();
    public final List<UbcFlowEvent> aGd = new ArrayList();
    private boolean aGe = false;
    private boolean aGf = false;
    private boolean aGg = false;
    private boolean aGh = false;
    private boolean aGi = false;
    private SubmitStrategy aGk = aGj;
    private final Map<ExtensionType, List<a>> aGl = new HashMap();
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
                return hybridUbcFlow.Ir() && hybridUbcFlow.Iu() && hybridUbcFlow.It();
            }
        },
        RELAUNCH { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.2
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.Ir() && hybridUbcFlow.Iu();
            }
        },
        NA_ONLY { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.3
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.Ir();
            }
        };

        abstract boolean submitAllowed(HybridUbcFlow hybridUbcFlow);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HybridUbcFlow(String str) {
        this.name = str;
    }

    public HybridUbcFlow fV(String str) {
        this.aFY = str;
        return this;
    }

    private void a(UbcFlowEvent ubcFlowEvent) {
        this.aGb.remove(ubcFlowEvent.id);
        this.aGb.add(ubcFlowEvent.id);
        this.aGc.put(ubcFlowEvent.id, ubcFlowEvent);
    }

    private void b(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.aGc.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.IM() > ubcFlowEvent2.IM()) {
            a(ubcFlowEvent);
        }
    }

    private void c(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.aGc.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.IM() < ubcFlowEvent2.IM()) {
            a(ubcFlowEvent);
        }
    }

    private void d(UbcFlowEvent ubcFlowEvent) {
        if (!e(this.aGc.get(ubcFlowEvent.id))) {
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
            synchronized (this.aGb) {
                switch (ubcFlowEvent.IP()) {
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
        synchronized (this.aGb) {
            for (UbcFlowEvent ubcFlowEvent : list) {
                f(ubcFlowEvent);
            }
        }
        return this;
    }

    public HybridUbcFlow ar(String str, String str2) {
        this.aGa.put(str, str2);
        return this;
    }

    public String fW(String str) {
        return this.aGa.get(str);
    }

    public HybridUbcFlow b(HybridUbcFlow hybridUbcFlow) {
        if (hybridUbcFlow != null) {
            hybridUbcFlow.Iv();
            y(hybridUbcFlow.aGd);
            this.aGa.putAll(hybridUbcFlow.aGa);
        }
        return this;
    }

    public HybridUbcFlow j(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.aFZ.put(str, obj);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return this;
    }

    public JSONObject Im() {
        return this.aFZ;
    }

    public HybridUbcFlow In() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naFlowDone");
        }
        this.aGe = true;
        Iy();
        return this;
    }

    public HybridUbcFlow Io() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naExtDone");
        }
        this.aGf = true;
        Iy();
        return this;
    }

    public HybridUbcFlow Ip() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naAnimFlowDone");
        }
        this.aGg = true;
        Iy();
        return this;
    }

    public HybridUbcFlow Iq() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "h5FlowDone");
        }
        this.aGh = true;
        Iy();
        return this;
    }

    public boolean Ir() {
        return this.aGe;
    }

    public boolean Is() {
        return this.aGf;
    }

    public boolean It() {
        return this.aGg;
    }

    public boolean Iu() {
        return this.aGh;
    }

    private boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.aGb) {
            isEmpty = this.aGb.isEmpty();
        }
        return isEmpty;
    }

    public void Iv() {
        UbcFlowEvent ubcFlowEvent;
        synchronized (this.aGb) {
            this.aGd.clear();
            for (String str : this.aGb) {
                if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.aGc.get(str)) != null && ubcFlowEvent.IM() > 0) {
                    this.aGd.add(ubcFlowEvent);
                }
            }
            Iw();
        }
    }

    private void Iw() {
        Collections.sort(this.aGd, new Comparator<UbcFlowEvent>() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(UbcFlowEvent ubcFlowEvent, UbcFlowEvent ubcFlowEvent2) {
                return Long.compare(ubcFlowEvent.IM(), ubcFlowEvent2.IM());
            }
        });
    }

    public HybridUbcFlow a(SubmitStrategy submitStrategy) {
        if (submitStrategy != null) {
            this.aGk = submitStrategy;
        }
        return this;
    }

    private boolean Ix() {
        boolean submitAllowed = (this.aGk == null ? aGj : this.aGk).submitAllowed(this);
        if (f.aGG) {
            return submitAllowed;
        }
        return Is() && submitAllowed;
    }

    private void Iy() {
        if (Ix()) {
            Iz();
        }
    }

    private void Iz() {
        if (!this.aGi) {
            this.aGi = true;
            a(ExtensionType.CALLBACK_ON_SUBMIT);
            j.b(new Runnable() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow.this.IA();
                    HybridUbcFlow.this.aGi = false;
                }
            }, "HybridUbcFlow");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IA() {
        Iv();
        a(ExtensionType.COMPONENT_REPORTER);
        if (!TextUtils.isEmpty(this.aFY)) {
            Flow kZ = s.kZ(this.aFY);
            for (UbcFlowEvent ubcFlowEvent : this.aGd) {
                if (!ubcFlowEvent.IO()) {
                    kZ.addEvent(ubcFlowEvent.id, ubcFlowEvent.value(), ubcFlowEvent.IM());
                }
            }
            if (!isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, String> entry : this.aGa.entrySet()) {
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
                kZ.setValueWithDuration(this.aFZ.toString());
                kZ.end();
            }
        }
    }

    private void a(ExtensionType extensionType) {
        List<a> list = this.aGl.get(extensionType);
        if (list != null && !list.isEmpty()) {
            for (a aVar : list) {
                if (aVar != null && aVar.aGp != null) {
                    aVar.aGp.D(this);
                }
            }
        }
    }

    public HybridUbcFlow a(ExtensionType extensionType, com.baidu.swan.apps.an.d.a<HybridUbcFlow> aVar) {
        a aVar2 = new a(extensionType, aVar);
        if (aVar2.IB()) {
            synchronized (this.aGl) {
                List<a> list = this.aGl.get(extensionType);
                if (list == null) {
                    list = new ArrayList<>();
                    this.aGl.put(extensionType, list);
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
        if (r1.IM() < 1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
        if (r0.IM() >= 1) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:?, code lost:
        return r1.IM() - r0.IM();
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
            ubcFlowEvent = this.aGc.get(strArr[i]);
            if (ubcFlowEvent2 == null) {
                if (ubcFlowEvent == null || ubcFlowEvent.IM() < 1) {
                    break;
                }
            } else if (ubcFlowEvent != null && ubcFlowEvent.IM() > 0) {
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
        final ExtensionType aGo;
        final com.baidu.swan.apps.an.d.a<HybridUbcFlow> aGp;

        private a(ExtensionType extensionType, com.baidu.swan.apps.an.d.a<HybridUbcFlow> aVar) {
            this.aGo = extensionType;
            this.aGp = aVar;
        }

        boolean IB() {
            return (this.aGo == null || this.aGp == null) ? false : true;
        }
    }
}
