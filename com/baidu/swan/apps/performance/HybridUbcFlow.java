package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.b.g0.a.i2.p;
import d.b.g0.a.k;
import d.b.g0.a.z1.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class HybridUbcFlow {
    public static final boolean q = k.f45443a;
    public static final SubmitStrategy r = SubmitStrategy.HYBRID;

    /* renamed from: a  reason: collision with root package name */
    public String f12052a;
    public final String o;

    /* renamed from: b  reason: collision with root package name */
    public final JSONObject f12053b = new JSONObject();

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, String> f12054c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public final List<String> f12055d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, UbcFlowEvent> f12056e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public final List<UbcFlowEvent> f12057f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public boolean f12058g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12059h = false;
    public boolean i = false;
    public boolean j = false;
    public boolean k = false;
    public volatile boolean l = false;
    public SubmitStrategy m = r;
    public final Map<String, List<e>> n = new HashMap();
    public String p = "";

    /* loaded from: classes2.dex */
    public enum SubmitStrategy {
        HYBRID { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.1
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            public boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.p() && hybridUbcFlow.o() && hybridUbcFlow.q();
            }
        },
        HYBRID_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.2
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            public boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.p() && hybridUbcFlow.o() && hybridUbcFlow.s();
            }
        },
        RELAUNCH { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.3
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            public boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.p() && hybridUbcFlow.o() && hybridUbcFlow.q();
            }
        },
        RELAUNCH_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.4
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            public boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.p() && hybridUbcFlow.o() && hybridUbcFlow.s();
            }
        },
        NA_ONLY { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.5
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            public boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.p();
            }
        },
        ROUTE { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.6
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            public boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.p() && hybridUbcFlow.o();
            }
        },
        ROUTE_NA { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.7
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            public boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.p();
            }
        },
        ROUTE_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.8
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            public boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.p() && hybridUbcFlow.o() && hybridUbcFlow.t();
            }
        },
        VIDEO_NA { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.9
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            public boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.p();
            }
        };

        public abstract boolean submitAllowed(HybridUbcFlow hybridUbcFlow);

        /* synthetic */ SubmitStrategy(a aVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public class a implements Comparator<UbcFlowEvent> {
        public a(HybridUbcFlow hybridUbcFlow) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(UbcFlowEvent ubcFlowEvent, UbcFlowEvent ubcFlowEvent2) {
            return Long.compare(ubcFlowEvent.g(), ubcFlowEvent2.g());
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HybridUbcFlow.this.l();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Comparator<UbcFlowEvent> {
        public c(HybridUbcFlow hybridUbcFlow) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(UbcFlowEvent ubcFlowEvent, UbcFlowEvent ubcFlowEvent2) {
            return Long.compare(ubcFlowEvent.g(), ubcFlowEvent2.g());
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f12061a;

        static {
            int[] iArr = new int[UbcFlowEvent.RecordType.values().length];
            f12061a = iArr;
            try {
                iArr[UbcFlowEvent.RecordType.UPDATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12061a[UbcFlowEvent.RecordType.UPDATE_RECENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12061a[UbcFlowEvent.RecordType.UPDATE_EARLIER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12061a[UbcFlowEvent.RecordType.KEEP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e {

        /* renamed from: a  reason: collision with root package name */
        public final String f12062a;

        /* renamed from: b  reason: collision with root package name */
        public final d.b.g0.a.i2.u0.b<HybridUbcFlow> f12063b;

        public /* synthetic */ e(HybridUbcFlow hybridUbcFlow, String str, d.b.g0.a.i2.u0.b bVar, a aVar) {
            this(hybridUbcFlow, str, bVar);
        }

        public boolean a() {
            return (this.f12063b == null || TextUtils.isEmpty(this.f12062a)) ? false : true;
        }

        public e(HybridUbcFlow hybridUbcFlow, String str, d.b.g0.a.i2.u0.b<HybridUbcFlow> bVar) {
            this.f12062a = str;
            this.f12063b = bVar;
        }
    }

    public HybridUbcFlow(String str) {
        this.o = str;
    }

    public HybridUbcFlow A(UbcFlowEvent ubcFlowEvent) {
        if (q) {
            Log.i("HybridUbcFlow", "record " + ubcFlowEvent);
        }
        if (r(ubcFlowEvent)) {
            synchronized (this.f12055d) {
                int i = d.f12061a[ubcFlowEvent.c().ordinal()];
                if (i == 1) {
                    J(ubcFlowEvent);
                } else if (i == 2) {
                    M(ubcFlowEvent);
                } else if (i != 3) {
                    u(ubcFlowEvent);
                } else {
                    K(ubcFlowEvent);
                }
            }
            return this;
        }
        return this;
    }

    public HybridUbcFlow B(List<UbcFlowEvent> list) {
        if (q) {
            Log.i("HybridUbcFlow", "record events size = " + list.size());
        }
        synchronized (this.f12055d) {
            for (UbcFlowEvent ubcFlowEvent : list) {
                A(ubcFlowEvent);
            }
        }
        return this;
    }

    public HybridUbcFlow C(String str, d.b.g0.a.i2.u0.b<HybridUbcFlow> bVar) {
        e eVar = new e(this, str, bVar, null);
        if (eVar.a()) {
            synchronized (this.n) {
                List<e> list = this.n.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                    this.n.put(str, list);
                }
                list.add(eVar);
            }
        }
        return this;
    }

    public HybridUbcFlow D(SubmitStrategy submitStrategy) {
        if (submitStrategy != null) {
            this.m = submitStrategy;
        }
        return this;
    }

    public HybridUbcFlow E(String str) {
        this.f12052a = str;
        return this;
    }

    public final void F() {
        Collections.sort(this.f12057f, new a(this));
    }

    public final synchronized void G() {
        if (this.l) {
            return;
        }
        this.l = true;
        b("callback_on_submit");
        p.j(new b(), "HybridUbcFlow");
        d.b.g0.a.j1.m.d.b();
        if (q) {
            Log.d("HybridUbcFlow", "UBC submit " + i() + ", this=" + hashCode(), new Exception());
        }
    }

    public final boolean H() {
        SubmitStrategy submitStrategy = this.m;
        if (submitStrategy == null) {
            submitStrategy = r;
        }
        return submitStrategy.submitAllowed(this);
    }

    public boolean I(String str) {
        boolean z = !TextUtils.isEmpty(str);
        if (!TextUtils.isEmpty(this.p)) {
            return !z || TextUtils.equals(this.p, str);
        }
        if (z) {
            str = this.p;
        }
        this.p = str;
        return true;
    }

    public final void J(UbcFlowEvent ubcFlowEvent) {
        this.f12055d.remove(ubcFlowEvent.f12065a);
        this.f12055d.add(ubcFlowEvent.f12065a);
        this.f12056e.put(ubcFlowEvent.f12065a, ubcFlowEvent);
    }

    public final void K(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.f12056e.get(ubcFlowEvent.f12065a);
        if (!r(ubcFlowEvent2) || ubcFlowEvent.g() < ubcFlowEvent2.g()) {
            J(ubcFlowEvent);
        }
    }

    public void L() {
        UbcFlowEvent ubcFlowEvent;
        synchronized (this.f12055d) {
            this.f12057f.clear();
            for (String str : this.f12055d) {
                if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.f12056e.get(str)) != null && ubcFlowEvent.g() > 0) {
                    this.f12057f.add(ubcFlowEvent);
                }
            }
            F();
        }
    }

    public final void M(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.f12056e.get(ubcFlowEvent.f12065a);
        if (!r(ubcFlowEvent2) || ubcFlowEvent.g() > ubcFlowEvent2.g()) {
            J(ubcFlowEvent);
        }
    }

    public HybridUbcFlow N() {
        if (q) {
            Log.i("HybridUbcFlow", "webwidgetPaintDone");
        }
        this.j = true;
        c();
        return this;
    }

    public HybridUbcFlow O() {
        if (q) {
            Log.i("HybridUbcFlow", "webViewWidgetDone");
        }
        this.k = true;
        c();
        return this;
    }

    public final void b(String str) {
        d.b.g0.a.i2.u0.b<HybridUbcFlow> bVar;
        List<e> list = this.n.get(str);
        if (list == null || list.isEmpty()) {
            return;
        }
        for (e eVar : list) {
            if (eVar != null && (bVar = eVar.f12063b) != null) {
                bVar.onCallback(this);
            }
        }
    }

    public final void c() {
        if (H()) {
            G();
        }
    }

    public synchronized JSONObject d() throws JSONException {
        JSONObject jSONObject;
        UbcFlowEvent ubcFlowEvent;
        jSONObject = new JSONObject();
        try {
            int size = this.f12055d.size();
            String[] strArr = new String[size];
            this.f12055d.toArray(strArr);
            ArrayList<UbcFlowEvent> arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                String str = strArr[i];
                if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.f12056e.get(str)) != null && ubcFlowEvent.g() > 0) {
                    arrayList.add(ubcFlowEvent);
                }
            }
            Collections.sort(arrayList, new c(this));
            JSONArray jSONArray = new JSONArray();
            for (UbcFlowEvent ubcFlowEvent2 : arrayList) {
                jSONArray.put(ubcFlowEvent2.i());
            }
            if (jSONArray.length() != 0) {
                jSONObject.put("events", jSONArray);
            }
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry<String, String> entry : this.f12054c.entrySet()) {
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
            if (this.f12053b != null && this.f12053b.length() > 0) {
                jSONObject.put("values", this.f12053b);
            }
        } catch (Exception e2) {
            jSONObject.put("excp", e2.getMessage());
        }
        return jSONObject;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:
        if (r3 == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0037, code lost:
        if (r1 == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003f, code lost:
        if (r3.g() < 1) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0047, code lost:
        if (r1.g() >= 1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0053, code lost:
        return r3.g() - r1.g();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0054, code lost:
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long e(String... strArr) {
        int length = strArr.length;
        UbcFlowEvent ubcFlowEvent = null;
        int i = 0;
        UbcFlowEvent ubcFlowEvent2 = null;
        while (true) {
            if (i >= length) {
                break;
            }
            UbcFlowEvent ubcFlowEvent3 = this.f12056e.get(strArr[i]);
            if (ubcFlowEvent2 == null) {
                if (ubcFlowEvent3 == null || ubcFlowEvent3.g() < 1) {
                    break;
                }
                ubcFlowEvent2 = ubcFlowEvent3;
            } else if (ubcFlowEvent3 != null && ubcFlowEvent3.g() > 0) {
                ubcFlowEvent = ubcFlowEvent3;
                break;
            }
            i++;
        }
        return -1L;
    }

    public UbcFlowEvent f(String str) {
        return this.f12056e.get(str);
    }

    public String g(String str) {
        return this.f12054c.get(str);
    }

    public SubmitStrategy h() {
        return this.m;
    }

    public String i() {
        return this.f12052a;
    }

    public JSONObject j() {
        return this.f12053b;
    }

    public HybridUbcFlow k() {
        if (q) {
            Log.i("HybridUbcFlow", "h5FlowDone");
        }
        this.f12059h = true;
        c();
        return this;
    }

    public final void l() {
        L();
        b("component_reporter");
        if (TextUtils.isEmpty(this.f12052a)) {
            return;
        }
        d.b.g0.a.z1.a e2 = h.e(this.f12052a);
        for (UbcFlowEvent ubcFlowEvent : this.f12057f) {
            if (!ubcFlowEvent.b()) {
                d.b.g0.a.z1.b.e(e2, ubcFlowEvent.f12065a, ubcFlowEvent.j(), ubcFlowEvent.g());
            }
        }
        d.b.g0.a.j1.m.a.a(this.f12057f);
        if (n()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, String> entry : this.f12054c.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    String value = entry.getValue();
                    if (value == null) {
                        value = "";
                    }
                    jSONObject.put(key, value);
                }
            }
            z("ext", jSONObject);
        } catch (Exception e3) {
            if (q) {
                e3.printStackTrace();
            }
        }
        d.b.g0.a.z1.b.f(e2, this.f12053b.toString());
        d.b.g0.a.z1.b.c(e2);
    }

    public boolean m(String str) {
        return this.f12056e.get(str) != null;
    }

    public final boolean n() {
        boolean isEmpty;
        synchronized (this.f12055d) {
            isEmpty = this.f12055d.isEmpty();
        }
        return isEmpty;
    }

    public boolean o() {
        return this.f12059h;
    }

    public boolean p() {
        return this.f12058g;
    }

    public boolean q() {
        return this.i;
    }

    public final boolean r(UbcFlowEvent ubcFlowEvent) {
        return (ubcFlowEvent == null || TextUtils.isEmpty(ubcFlowEvent.f12065a)) ? false : true;
    }

    public boolean s() {
        return this.j;
    }

    public boolean t() {
        return this.k;
    }

    public final void u(UbcFlowEvent ubcFlowEvent) {
        if (r(this.f12056e.get(ubcFlowEvent.f12065a))) {
            return;
        }
        J(ubcFlowEvent);
    }

    public HybridUbcFlow v(HybridUbcFlow hybridUbcFlow) {
        if (hybridUbcFlow == null) {
            return this;
        }
        hybridUbcFlow.L();
        B(hybridUbcFlow.f12057f);
        this.f12054c.putAll(hybridUbcFlow.f12054c);
        return this;
    }

    public HybridUbcFlow w() {
        if (q) {
            Log.i("HybridUbcFlow", "naFlowDone");
        }
        this.f12058g = true;
        c();
        return this;
    }

    public HybridUbcFlow x() {
        if (q) {
            Log.i("HybridUbcFlow", "naPaintFlowDone");
        }
        this.i = true;
        b("fmp_callback");
        c();
        return this;
    }

    public HybridUbcFlow y(String str, String str2) {
        this.f12054c.put(str, str2);
        return this;
    }

    public HybridUbcFlow z(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        try {
            this.f12053b.put(str, obj);
        } catch (JSONException e2) {
            if (q) {
                e2.printStackTrace();
            }
        }
        return this;
    }
}
