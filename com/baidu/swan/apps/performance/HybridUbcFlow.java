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
    public static final SubmitStrategy aDF = SubmitStrategy.HYBRID;
    private String aDu;
    public final String name;
    private final JSONObject aDv = new JSONObject();
    private final Map<String, String> aDw = new HashMap();
    public final List<String> aDx = new ArrayList();
    private final Map<String, UbcFlowEvent> aDy = new HashMap();
    public final List<UbcFlowEvent> aDz = new ArrayList();
    private boolean aDA = false;
    private boolean aDB = false;
    private boolean aDC = false;
    private boolean aDD = false;
    private boolean aDE = false;
    private SubmitStrategy aDG = aDF;
    private final Map<ExtensionType, List<a>> aDH = new HashMap();

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
                return hybridUbcFlow.Fz() && hybridUbcFlow.FC() && hybridUbcFlow.FB();
            }
        },
        RELAUNCH { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.2
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.Fz() && hybridUbcFlow.FC();
            }
        },
        NA_ONLY { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.3
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.Fz();
            }
        };

        abstract boolean submitAllowed(HybridUbcFlow hybridUbcFlow);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HybridUbcFlow(String str) {
        this.name = str;
    }

    public HybridUbcFlow fB(String str) {
        this.aDu = str;
        return this;
    }

    private void a(UbcFlowEvent ubcFlowEvent) {
        this.aDx.remove(ubcFlowEvent.id);
        this.aDx.add(ubcFlowEvent.id);
        this.aDy.put(ubcFlowEvent.id, ubcFlowEvent);
    }

    private void b(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.aDy.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.FT() > ubcFlowEvent2.FT()) {
            a(ubcFlowEvent);
        }
    }

    private void c(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.aDy.get(ubcFlowEvent.id);
        if (!e(ubcFlowEvent2) || ubcFlowEvent.FT() < ubcFlowEvent2.FT()) {
            a(ubcFlowEvent);
        }
    }

    private void d(UbcFlowEvent ubcFlowEvent) {
        if (!e(this.aDy.get(ubcFlowEvent.id))) {
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
            synchronized (this.aDx) {
                switch (ubcFlowEvent.FW()) {
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
        synchronized (this.aDx) {
            for (UbcFlowEvent ubcFlowEvent : list) {
                f(ubcFlowEvent);
            }
        }
        return this;
    }

    public HybridUbcFlow aq(String str, String str2) {
        this.aDw.put(str, str2);
        return this;
    }

    public String fC(String str) {
        return this.aDw.get(str);
    }

    public HybridUbcFlow b(HybridUbcFlow hybridUbcFlow) {
        if (hybridUbcFlow != null) {
            hybridUbcFlow.FD();
            x(hybridUbcFlow.aDz);
            this.aDw.putAll(hybridUbcFlow.aDw);
        }
        return this;
    }

    public HybridUbcFlow i(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.aDv.put(str, obj);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return this;
    }

    public JSONObject Fu() {
        return this.aDv;
    }

    public HybridUbcFlow Fv() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naFlowDone");
        }
        this.aDA = true;
        FF();
        return this;
    }

    public HybridUbcFlow Fw() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naExtDone");
        }
        this.aDB = true;
        FF();
        return this;
    }

    public HybridUbcFlow Fx() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "naAnimFlowDone");
        }
        this.aDC = true;
        FF();
        return this;
    }

    public HybridUbcFlow Fy() {
        if (DEBUG) {
            Log.i("HybridUbcFlow", "h5FlowDone");
        }
        this.aDD = true;
        FF();
        return this;
    }

    public boolean Fz() {
        return this.aDA;
    }

    public boolean FA() {
        return this.aDB;
    }

    public boolean FB() {
        return this.aDC;
    }

    public boolean FC() {
        return this.aDD;
    }

    private boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.aDx) {
            isEmpty = this.aDx.isEmpty();
        }
        return isEmpty;
    }

    public void FD() {
        UbcFlowEvent ubcFlowEvent;
        synchronized (this.aDx) {
            this.aDz.clear();
            for (String str : this.aDx) {
                if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.aDy.get(str)) != null && ubcFlowEvent.FT() > 0) {
                    this.aDz.add(ubcFlowEvent);
                }
            }
            sort();
        }
    }

    private void sort() {
        Collections.sort(this.aDz, new Comparator<UbcFlowEvent>() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(UbcFlowEvent ubcFlowEvent, UbcFlowEvent ubcFlowEvent2) {
                return Long.compare(ubcFlowEvent.FT(), ubcFlowEvent2.FT());
            }
        });
    }

    public HybridUbcFlow a(SubmitStrategy submitStrategy) {
        if (submitStrategy != null) {
            this.aDG = submitStrategy;
        }
        return this;
    }

    private boolean FE() {
        boolean submitAllowed = (this.aDG == null ? aDF : this.aDG).submitAllowed(this);
        if (f.aEc) {
            return submitAllowed;
        }
        return FA() && submitAllowed;
    }

    private void FF() {
        if (FE()) {
            FG();
        }
    }

    private void FG() {
        if (!this.aDE) {
            this.aDE = true;
            a(ExtensionType.CALLBACK_ON_SUBMIT);
            j.b(new Runnable() { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow.this.FH();
                    HybridUbcFlow.this.aDE = false;
                }
            }, "HybridUbcFlow");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FH() {
        FD();
        a(ExtensionType.COMPONENT_REPORTER);
        if (!TextUtils.isEmpty(this.aDu)) {
            Flow jS = q.jS(this.aDu);
            for (UbcFlowEvent ubcFlowEvent : this.aDz) {
                if (!ubcFlowEvent.FV()) {
                    jS.addEvent(ubcFlowEvent.id, ubcFlowEvent.value(), ubcFlowEvent.FT());
                }
            }
            if (!isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, String> entry : this.aDw.entrySet()) {
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
                jS.setValueWithDuration(this.aDv.toString());
                jS.end();
            }
        }
    }

    private void a(ExtensionType extensionType) {
        List<a> list = this.aDH.get(extensionType);
        if (list != null && !list.isEmpty()) {
            for (a aVar : list) {
                if (aVar != null && aVar.aDL != null) {
                    aVar.aDL.D(this);
                }
            }
        }
    }

    public HybridUbcFlow a(ExtensionType extensionType, com.baidu.swan.apps.an.c.a<HybridUbcFlow> aVar) {
        a aVar2 = new a(extensionType, aVar);
        if (aVar2.FI()) {
            synchronized (this.aDH) {
                List<a> list = this.aDH.get(extensionType);
                if (list == null) {
                    list = new ArrayList<>();
                    this.aDH.put(extensionType, list);
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
        if (r1.FT() < 1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
        if (r0.FT() >= 1) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:?, code lost:
        return r1.FT() - r0.FT();
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
            ubcFlowEvent = this.aDy.get(strArr[i]);
            if (ubcFlowEvent2 == null) {
                if (ubcFlowEvent == null || ubcFlowEvent.FT() < 1) {
                    break;
                }
            } else if (ubcFlowEvent != null && ubcFlowEvent.FT() > 0) {
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
        final ExtensionType aDK;
        final com.baidu.swan.apps.an.c.a<HybridUbcFlow> aDL;

        private a(ExtensionType extensionType, com.baidu.swan.apps.an.c.a<HybridUbcFlow> aVar) {
            this.aDK = extensionType;
            this.aDL = aVar;
        }

        boolean FI() {
            return (this.aDK == null || this.aDL == null) ? false : true;
        }
    }
}
