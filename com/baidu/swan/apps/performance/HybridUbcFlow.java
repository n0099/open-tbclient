package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.SavedStateHandle;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.ae3;
import com.baidu.tieba.ar2;
import com.baidu.tieba.do1;
import com.baidu.tieba.ge2;
import com.baidu.tieba.le3;
import com.baidu.tieba.me3;
import com.baidu.tieba.mm3;
import com.baidu.tieba.nk3;
import com.baidu.tieba.pe3;
import com.baidu.tieba.q13;
import com.baidu.tieba.s13;
import com.baidu.tieba.s73;
import com.baidu.tieba.t42;
import com.baidu.tieba.t52;
import com.baidu.tieba.tk3;
import com.baidu.tieba.v13;
import com.baidu.tieba.xt2;
import com.baidu.tieba.zd3;
import com.baidu.tieba.zt1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class HybridUbcFlow {
    public static final boolean r = do1.a;
    public static final SubmitStrategy s = SubmitStrategy.HYBRID;
    public String a;
    public final String p;
    public final JSONObject b = new JSONObject();
    public final Map<String, String> c = new HashMap();
    public final List<String> d = new ArrayList();
    public final Map<String, UbcFlowEvent> e = new HashMap();
    public final List<UbcFlowEvent> f = new ArrayList();
    public boolean g = false;
    public boolean h = false;
    public boolean i = false;
    public boolean j = false;
    public boolean k = false;
    public volatile boolean l = false;
    public SubmitStrategy m = s;
    public final Map<String, List<e>> n = new HashMap();
    public final Map<String, Object> o = new ConcurrentHashMap();
    public String q = "";

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HybridUbcFlow.this.o();
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public static /* synthetic */ class d {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[UbcFlowEvent.RecordType.values().length];
            a = iArr;
            try {
                iArr[UbcFlowEvent.RecordType.UPDATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[UbcFlowEvent.RecordType.UPDATE_RECENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[UbcFlowEvent.RecordType.UPDATE_EARLIER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[UbcFlowEvent.RecordType.KEEP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e {
        public final String a;
        public final mm3<HybridUbcFlow> b;

        public e(HybridUbcFlow hybridUbcFlow, String str, mm3<HybridUbcFlow> mm3Var) {
            this.a = str;
            this.b = mm3Var;
        }

        public /* synthetic */ e(HybridUbcFlow hybridUbcFlow, String str, mm3 mm3Var, a aVar) {
            this(hybridUbcFlow, str, mm3Var);
        }

        public boolean a() {
            if (this.b != null && !TextUtils.isEmpty(this.a)) {
                return true;
            }
            return false;
        }
    }

    public HybridUbcFlow A() {
        if (r) {
            Log.i("HybridUbcFlow", "naFlowDone");
        }
        this.g = true;
        d();
        return this;
    }

    public HybridUbcFlow B() {
        if (r) {
            Log.i("HybridUbcFlow", "naPaintFlowDone");
        }
        this.i = true;
        c("fmp_callback");
        d();
        return this;
    }

    public final void K() {
        Collections.sort(this.f, new a(this));
    }

    public final synchronized void L() {
        if (this.l) {
            return;
        }
        this.l = true;
        R();
        c("callback_on_submit");
        nk3.j(new b(), "HybridUbcFlow");
        s13.b();
    }

    public final boolean M() {
        SubmitStrategy submitStrategy = this.m;
        if (submitStrategy == null) {
            submitStrategy = s;
        }
        return submitStrategy.submitAllowed(this);
    }

    public HybridUbcFlow S() {
        if (r) {
            Log.i("HybridUbcFlow", "webwidgetPaintDone");
        }
        this.j = true;
        d();
        return this;
    }

    public HybridUbcFlow T() {
        if (r) {
            Log.i("HybridUbcFlow", "webViewWidgetDone");
        }
        this.k = true;
        d();
        return this;
    }

    public final void d() {
        if (M()) {
            L();
        }
    }

    public SubmitStrategy i() {
        return this.m;
    }

    public String l() {
        return this.a;
    }

    public JSONObject m() {
        return this.b;
    }

    public HybridUbcFlow n() {
        if (r) {
            Log.i("HybridUbcFlow", "h5FlowDone");
        }
        this.h = true;
        d();
        return this;
    }

    public final boolean q() {
        boolean isEmpty;
        synchronized (this.d) {
            isEmpty = this.d.isEmpty();
        }
        return isEmpty;
    }

    public boolean r() {
        return this.h;
    }

    public boolean s() {
        return this.g;
    }

    public boolean t() {
        return this.i;
    }

    public boolean u() {
        return !TextUtils.isEmpty(this.q);
    }

    public boolean w() {
        return this.j;
    }

    public boolean x() {
        return this.k;
    }

    public HybridUbcFlow(String str) {
        this.p = str;
    }

    public HybridUbcFlow F(UbcFlowEvent ubcFlowEvent) {
        if (r) {
            Log.i("HybridUbcFlow", "record " + ubcFlowEvent);
        }
        if (!v(ubcFlowEvent)) {
            return this;
        }
        synchronized (this.d) {
            int i = d.a[ubcFlowEvent.c().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        y(ubcFlowEvent);
                    } else {
                        O(ubcFlowEvent);
                    }
                } else {
                    Q(ubcFlowEvent);
                }
            } else {
                update(ubcFlowEvent);
            }
        }
        return this;
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
    public long f(String... strArr) {
        int length = strArr.length;
        UbcFlowEvent ubcFlowEvent = null;
        int i = 0;
        UbcFlowEvent ubcFlowEvent2 = null;
        while (true) {
            if (i >= length) {
                break;
            }
            UbcFlowEvent ubcFlowEvent3 = this.e.get(strArr[i]);
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

    /* loaded from: classes3.dex */
    public enum SubmitStrategy {
        HYBRID { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.1
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            public boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                if (hybridUbcFlow.s() && hybridUbcFlow.r() && hybridUbcFlow.t()) {
                    return true;
                }
                return false;
            }
        },
        HYBRID_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.2
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            public boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                if (hybridUbcFlow.s() && hybridUbcFlow.r() && hybridUbcFlow.w()) {
                    return true;
                }
                return false;
            }
        },
        RELAUNCH { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.3
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            public boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                if (hybridUbcFlow.s() && hybridUbcFlow.r() && hybridUbcFlow.t()) {
                    return true;
                }
                return false;
            }
        },
        RELAUNCH_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.4
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            public boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                if (hybridUbcFlow.s() && hybridUbcFlow.r() && hybridUbcFlow.w()) {
                    return true;
                }
                return false;
            }
        },
        NA_ONLY { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.5
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            public boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.s();
            }
        },
        ROUTE { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.6
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            public boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                if (hybridUbcFlow.s() && hybridUbcFlow.r() && hybridUbcFlow.t()) {
                    return true;
                }
                return false;
            }
        },
        ROUTE_NA { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.7
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            public boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.s();
            }
        },
        ROUTE_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.8
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            public boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                if (hybridUbcFlow.s() && hybridUbcFlow.r() && hybridUbcFlow.x()) {
                    return true;
                }
                return false;
            }
        },
        VIDEO_NA { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.9
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            public boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.s();
            }
        },
        SWAN_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.10
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            public boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.s();
            }
        },
        PREFETCH_NA { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.11
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            public boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.s();
            }
        };

        public abstract boolean submitAllowed(HybridUbcFlow hybridUbcFlow);

        /* synthetic */ SubmitStrategy(a aVar) {
            this();
        }
    }

    private void update(UbcFlowEvent ubcFlowEvent) {
        this.d.remove(ubcFlowEvent.a);
        this.d.add(ubcFlowEvent.a);
        this.e.put(ubcFlowEvent.a, ubcFlowEvent);
    }

    public HybridUbcFlow I(SubmitStrategy submitStrategy) {
        if (submitStrategy != null) {
            this.m = submitStrategy;
        }
        return this;
    }

    public HybridUbcFlow J(String str) {
        this.a = str;
        return this;
    }

    public boolean N(String str) {
        boolean z = !TextUtils.isEmpty(str);
        if (TextUtils.isEmpty(this.q)) {
            this.q = j(z, str);
            return true;
        } else if (!z || TextUtils.equals(this.q, str)) {
            return true;
        } else {
            return false;
        }
    }

    public final void O(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.e.get(ubcFlowEvent.a);
        if (!v(ubcFlowEvent2) || ubcFlowEvent.g() < ubcFlowEvent2.g()) {
            update(ubcFlowEvent);
        }
    }

    public final void Q(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.e.get(ubcFlowEvent.a);
        if (!v(ubcFlowEvent2) || ubcFlowEvent.g() > ubcFlowEvent2.g()) {
            update(ubcFlowEvent);
        }
    }

    public final void c(String str) {
        mm3<HybridUbcFlow> mm3Var;
        List<e> list = this.n.get(str);
        if (list != null && !list.isEmpty()) {
            for (e eVar : list) {
                if (eVar != null && (mm3Var = eVar.b) != null) {
                    mm3Var.a(this);
                }
            }
        }
    }

    public UbcFlowEvent g(String str) {
        return this.e.get(str);
    }

    public String h(String str) {
        return this.c.get(str);
    }

    public synchronized <T> T k(@NonNull String str) {
        return (T) this.o.get(str);
    }

    public boolean p(String str) {
        if (this.e.get(str) != null) {
            return true;
        }
        return false;
    }

    public final boolean v(UbcFlowEvent ubcFlowEvent) {
        if (ubcFlowEvent != null && !TextUtils.isEmpty(ubcFlowEvent.a)) {
            return true;
        }
        return false;
    }

    public final void y(UbcFlowEvent ubcFlowEvent) {
        if (!v(this.e.get(ubcFlowEvent.a))) {
            update(ubcFlowEvent);
        }
    }

    public HybridUbcFlow z(HybridUbcFlow hybridUbcFlow) {
        if (hybridUbcFlow == null) {
            return this;
        }
        hybridUbcFlow.P();
        G(hybridUbcFlow.f);
        this.c.putAll(hybridUbcFlow.c);
        return this;
    }

    public HybridUbcFlow C(@Nullable zt1 zt1Var) {
        String str;
        if (r) {
            StringBuilder sb = new StringBuilder();
            sb.append("naPaintFlowDone, slave page=");
            if (zt1Var == null) {
                str = StringUtil.NULL_STRING;
            } else {
                str = zt1Var.m() + ", routeId=" + zt1Var.j0();
            }
            sb.append(str);
            Log.i("HybridUbcFlow", sb.toString());
        }
        if (zt1Var != null) {
            String j0 = zt1Var.j0();
            if (j0 != null) {
                b("routeId", j0);
            }
            String a2 = zt1Var.a();
            if (a2 != null) {
                b(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, a2);
            }
            String m = zt1Var.m();
            if (m != null) {
                b(PrefetchEvent.EVENT_KEY_PAGE_URL, m);
            }
        }
        c("fmp_callback");
        this.i = true;
        d();
        return this;
    }

    public HybridUbcFlow D(String str, String str2) {
        this.c.put(str, str2);
        return this;
    }

    public HybridUbcFlow E(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        try {
            this.b.put(str, obj);
        } catch (JSONException e2) {
            if (r) {
                e2.printStackTrace();
            }
        }
        return this;
    }

    public HybridUbcFlow H(String str, mm3<HybridUbcFlow> mm3Var) {
        e eVar = new e(this, str, mm3Var, null);
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

    public synchronized <T> void b(@NonNull String str, T t) {
        this.o.put(str, t);
    }

    public final String j(boolean z, String str) {
        if (v13.b()) {
            if (!z) {
                return this.q;
            }
            return str;
        } else if (z) {
            return this.q;
        } else {
            return str;
        }
    }

    public HybridUbcFlow G(List<UbcFlowEvent> list) {
        if (r) {
            Log.i("HybridUbcFlow", "record events size = " + list.size());
        }
        synchronized (this.d) {
            for (UbcFlowEvent ubcFlowEvent : list) {
                F(ubcFlowEvent);
            }
        }
        return this;
    }

    public void P() {
        UbcFlowEvent ubcFlowEvent;
        synchronized (this.d) {
            this.f.clear();
            for (String str : this.d) {
                if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.e.get(str)) != null && ubcFlowEvent.g() > 0) {
                    this.f.add(ubcFlowEvent);
                }
            }
            K();
        }
    }

    public final void R() {
        ge2 ge2Var;
        UbcFlowEvent a2;
        if (TextUtils.equals("670", this.a) && v13.a() && (ge2Var = (ge2) k("fmp_data_record")) != null && ge2Var.c() && (a2 = ge2Var.a()) != null) {
            D("fmp_type", ge2Var.b());
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent(a2.a);
            ubcFlowEvent.h(a2.g());
            ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE);
            F(ubcFlowEvent);
        }
    }

    public final synchronized JSONObject e() {
        JSONObject jSONObject;
        UbcFlowEvent ubcFlowEvent;
        jSONObject = new JSONObject();
        try {
            int size = this.d.size();
            String[] strArr = new String[size];
            this.d.toArray(strArr);
            ArrayList<UbcFlowEvent> arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                String str = strArr[i];
                if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.e.get(str)) != null && ubcFlowEvent.g() > 0) {
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
            for (Map.Entry<String, String> entry : this.c.entrySet()) {
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
            if (this.b != null && this.b.length() > 0) {
                jSONObject.put(SavedStateHandle.VALUES, this.b);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public final void o() {
        if (TextUtils.equals("670", this.a)) {
            t42.k("HybridUbcFlow", "getMemoryInfo scene=launch_end_mem");
            this.c.put("sys_total_mem", t52.c().k());
            this.c.put("launch_end_mem", t52.c().h(s73.K().q().W().j("main_pid", -1)));
            t52.c().l();
        }
        JSONObject jSONObject = new JSONObject();
        tk3.f(jSONObject, "static", Float.valueOf(ar2.m().a()));
        this.c.put("device_score", jSONObject.toString());
        String a2 = ar2.n0().a();
        if (!TextUtils.isEmpty(a2)) {
            this.c.put("dyeId", a2);
        }
        this.c.put("localABTestSids", xt2.b().a());
        this.c.put("hostLaunchType", String.valueOf(s73.K().q().W().i("host_launch_type")));
        P();
        pe3.c(this);
        c("component_reporter");
        if (TextUtils.isEmpty(this.a)) {
            return;
        }
        zd3 c2 = me3.c(this.a);
        for (UbcFlowEvent ubcFlowEvent : this.f) {
            if (!ubcFlowEvent.b()) {
                ae3.e(c2, ubcFlowEvent.a, ubcFlowEvent.j(), ubcFlowEvent.g());
            }
        }
        if (q()) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry<String, String> entry : this.c.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    String value = entry.getValue();
                    if (value == null) {
                        value = "";
                    }
                    jSONObject2.put(key, value);
                }
            }
            le3.a(jSONObject2);
            E("ext", jSONObject2);
        } catch (Exception e2) {
            if (r) {
                e2.printStackTrace();
            }
        }
        ae3.f(c2, this.b.toString());
        ae3.c(c2);
        if (TextUtils.equals("670", this.a)) {
            q13.d(this.f, this.b);
            t42.k("HybridUbcFlow", "670: " + e().toString());
        }
    }
}
