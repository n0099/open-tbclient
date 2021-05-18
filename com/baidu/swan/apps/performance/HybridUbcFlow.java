package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.SavedStateHandle;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.a.i0.a.j2.n;
import d.a.i0.a.k;
import d.a.i0.a.v2.q;
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
    public static final boolean r = k.f43025a;
    public static final SubmitStrategy s = SubmitStrategy.HYBRID;

    /* renamed from: a  reason: collision with root package name */
    public String f11074a;
    public final String p;

    /* renamed from: b  reason: collision with root package name */
    public final JSONObject f11075b = new JSONObject();

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, String> f11076c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public final List<String> f11077d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, UbcFlowEvent> f11078e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public final List<UbcFlowEvent> f11079f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public boolean f11080g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f11081h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f11082i = false;
    public boolean j = false;
    public boolean k = false;
    public volatile boolean l = false;
    public SubmitStrategy m = s;
    public final Map<String, List<e>> n = new HashMap();
    public final Map<String, Object> o = new ConcurrentHashMap();
    public String q = "";

    /* loaded from: classes3.dex */
    public enum SubmitStrategy {
        HYBRID { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.1
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            public boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.q() && hybridUbcFlow.p() && hybridUbcFlow.r();
            }
        },
        HYBRID_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.2
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            public boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.q() && hybridUbcFlow.p() && hybridUbcFlow.t();
            }
        },
        RELAUNCH { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.3
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            public boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.q() && hybridUbcFlow.p() && hybridUbcFlow.r();
            }
        },
        RELAUNCH_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.4
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            public boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.q() && hybridUbcFlow.p() && hybridUbcFlow.t();
            }
        },
        NA_ONLY { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.5
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            public boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.q();
            }
        },
        ROUTE { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.6
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            public boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.q() && hybridUbcFlow.p() && hybridUbcFlow.r();
            }
        },
        ROUTE_NA { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.7
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            public boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.q();
            }
        },
        ROUTE_WEB { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.8
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            public boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.q() && hybridUbcFlow.p() && hybridUbcFlow.u();
            }
        },
        VIDEO_NA { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.9
            @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
            public boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                return hybridUbcFlow.q();
            }
        };

        public abstract boolean submitAllowed(HybridUbcFlow hybridUbcFlow);

        /* synthetic */ SubmitStrategy(a aVar) {
            this();
        }
    }

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
            HybridUbcFlow.this.m();
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

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f11084a;

        static {
            int[] iArr = new int[UbcFlowEvent.RecordType.values().length];
            f11084a = iArr;
            try {
                iArr[UbcFlowEvent.RecordType.UPDATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11084a[UbcFlowEvent.RecordType.UPDATE_RECENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11084a[UbcFlowEvent.RecordType.UPDATE_EARLIER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11084a[UbcFlowEvent.RecordType.KEEP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e {

        /* renamed from: a  reason: collision with root package name */
        public final String f11085a;

        /* renamed from: b  reason: collision with root package name */
        public final d.a.i0.a.v2.e1.b<HybridUbcFlow> f11086b;

        public /* synthetic */ e(HybridUbcFlow hybridUbcFlow, String str, d.a.i0.a.v2.e1.b bVar, a aVar) {
            this(hybridUbcFlow, str, bVar);
        }

        public boolean a() {
            return (this.f11086b == null || TextUtils.isEmpty(this.f11085a)) ? false : true;
        }

        public e(HybridUbcFlow hybridUbcFlow, String str, d.a.i0.a.v2.e1.b<HybridUbcFlow> bVar) {
            this.f11085a = str;
            this.f11086b = bVar;
        }
    }

    public HybridUbcFlow(String str) {
        this.p = str;
    }

    public HybridUbcFlow A(String str, String str2) {
        this.f11076c.put(str, str2);
        return this;
    }

    public HybridUbcFlow B(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        try {
            this.f11075b.put(str, obj);
        } catch (JSONException e2) {
            if (r) {
                e2.printStackTrace();
            }
        }
        return this;
    }

    public HybridUbcFlow C(UbcFlowEvent ubcFlowEvent) {
        if (r) {
            Log.i("HybridUbcFlow", "record " + ubcFlowEvent);
        }
        if (s(ubcFlowEvent)) {
            synchronized (this.f11077d) {
                int i2 = d.f11084a[ubcFlowEvent.c().ordinal()];
                if (i2 == 1) {
                    L(ubcFlowEvent);
                } else if (i2 == 2) {
                    O(ubcFlowEvent);
                } else if (i2 != 3) {
                    v(ubcFlowEvent);
                } else {
                    M(ubcFlowEvent);
                }
            }
            return this;
        }
        return this;
    }

    public HybridUbcFlow D(List<UbcFlowEvent> list) {
        if (r) {
            Log.i("HybridUbcFlow", "record events size = " + list.size());
        }
        synchronized (this.f11077d) {
            for (UbcFlowEvent ubcFlowEvent : list) {
                C(ubcFlowEvent);
            }
        }
        return this;
    }

    public HybridUbcFlow E(String str, d.a.i0.a.v2.e1.b<HybridUbcFlow> bVar) {
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

    public HybridUbcFlow F(SubmitStrategy submitStrategy) {
        if (submitStrategy != null) {
            this.m = submitStrategy;
        }
        return this;
    }

    public HybridUbcFlow G(String str) {
        this.f11074a = str;
        return this;
    }

    public final void H() {
        Collections.sort(this.f11079f, new a(this));
    }

    public final synchronized void I() {
        if (this.l) {
            return;
        }
        this.l = true;
        b("callback_on_submit");
        q.i(new b(), "HybridUbcFlow");
        d.a.i0.a.r1.l.c.b();
    }

    public final boolean J() {
        SubmitStrategy submitStrategy = this.m;
        if (submitStrategy == null) {
            submitStrategy = s;
        }
        return submitStrategy.submitAllowed(this);
    }

    public boolean K(String str) {
        boolean z = !TextUtils.isEmpty(str);
        if (!TextUtils.isEmpty(this.q)) {
            return !z || TextUtils.equals(this.q, str);
        }
        if (z) {
            str = this.q;
        }
        this.q = str;
        return true;
    }

    public final void L(UbcFlowEvent ubcFlowEvent) {
        this.f11077d.remove(ubcFlowEvent.f11088a);
        this.f11077d.add(ubcFlowEvent.f11088a);
        this.f11078e.put(ubcFlowEvent.f11088a, ubcFlowEvent);
    }

    public final void M(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.f11078e.get(ubcFlowEvent.f11088a);
        if (!s(ubcFlowEvent2) || ubcFlowEvent.g() < ubcFlowEvent2.g()) {
            L(ubcFlowEvent);
        }
    }

    public void N() {
        UbcFlowEvent ubcFlowEvent;
        synchronized (this.f11077d) {
            this.f11079f.clear();
            for (String str : this.f11077d) {
                if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.f11078e.get(str)) != null && ubcFlowEvent.g() > 0) {
                    this.f11079f.add(ubcFlowEvent);
                }
            }
            H();
        }
    }

    public final void O(UbcFlowEvent ubcFlowEvent) {
        UbcFlowEvent ubcFlowEvent2 = this.f11078e.get(ubcFlowEvent.f11088a);
        if (!s(ubcFlowEvent2) || ubcFlowEvent.g() > ubcFlowEvent2.g()) {
            L(ubcFlowEvent);
        }
    }

    public HybridUbcFlow P() {
        if (r) {
            Log.i("HybridUbcFlow", "webwidgetPaintDone");
        }
        this.j = true;
        c();
        return this;
    }

    public HybridUbcFlow Q() {
        if (r) {
            Log.i("HybridUbcFlow", "webViewWidgetDone");
        }
        this.k = true;
        c();
        return this;
    }

    public final void b(String str) {
        d.a.i0.a.v2.e1.b<HybridUbcFlow> bVar;
        List<e> list = this.n.get(str);
        if (list == null || list.isEmpty()) {
            return;
        }
        for (e eVar : list) {
            if (eVar != null && (bVar = eVar.f11086b) != null) {
                bVar.onCallback(this);
            }
        }
    }

    public final void c() {
        if (J()) {
            I();
        }
    }

    public final synchronized JSONObject d() {
        JSONObject jSONObject;
        UbcFlowEvent ubcFlowEvent;
        jSONObject = new JSONObject();
        try {
            int size = this.f11077d.size();
            String[] strArr = new String[size];
            this.f11077d.toArray(strArr);
            ArrayList<UbcFlowEvent> arrayList = new ArrayList(size);
            for (int i2 = 0; i2 < size; i2++) {
                String str = strArr[i2];
                if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.f11078e.get(str)) != null && ubcFlowEvent.g() > 0) {
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
            for (Map.Entry<String, String> entry : this.f11076c.entrySet()) {
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
            if (this.f11075b != null && this.f11075b.length() > 0) {
                jSONObject.put(SavedStateHandle.VALUES, this.f11075b);
            }
        } catch (Exception unused) {
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
        int i2 = 0;
        UbcFlowEvent ubcFlowEvent2 = null;
        while (true) {
            if (i2 >= length) {
                break;
            }
            UbcFlowEvent ubcFlowEvent3 = this.f11078e.get(strArr[i2]);
            if (ubcFlowEvent2 == null) {
                if (ubcFlowEvent3 == null || ubcFlowEvent3.g() < 1) {
                    break;
                }
                ubcFlowEvent2 = ubcFlowEvent3;
            } else if (ubcFlowEvent3 != null && ubcFlowEvent3.g() > 0) {
                ubcFlowEvent = ubcFlowEvent3;
                break;
            }
            i2++;
        }
        return -1L;
    }

    public UbcFlowEvent f(String str) {
        return this.f11078e.get(str);
    }

    public String g(String str) {
        return this.f11076c.get(str);
    }

    public SubmitStrategy h() {
        return this.m;
    }

    public <T> T i(@NonNull String str) {
        return (T) this.o.get(str);
    }

    public String j() {
        return this.f11074a;
    }

    public JSONObject k() {
        return this.f11075b;
    }

    public HybridUbcFlow l() {
        if (r) {
            Log.i("HybridUbcFlow", "h5FlowDone");
        }
        this.f11081h = true;
        c();
        return this;
    }

    public final void m() {
        if (TextUtils.equals("670", this.f11074a)) {
            d.a.i0.a.e0.d.h("HybridUbcFlow", "getMemoryInfo scene=launch_end_mem");
            this.f11076c.put("sys_total_mem", d.a.i0.a.e0.g.d.b().d());
            this.f11076c.put("launch_end_mem", d.a.i0.a.e0.g.d.b().c(d.a.i0.a.a2.d.g().r().L().j("main_pid", -1)));
        }
        N();
        n.c(this);
        b("component_reporter");
        if (TextUtils.isEmpty(this.f11074a)) {
            return;
        }
        d.a.i0.a.j2.a c2 = d.a.i0.a.j2.k.c(this.f11074a);
        for (UbcFlowEvent ubcFlowEvent : this.f11079f) {
            if (!ubcFlowEvent.b()) {
                d.a.i0.a.j2.b.e(c2, ubcFlowEvent.f11088a, ubcFlowEvent.j(), ubcFlowEvent.g());
            }
        }
        if (o()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, String> entry : this.f11076c.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    String value = entry.getValue();
                    if (value == null) {
                        value = "";
                    }
                    jSONObject.put(key, value);
                }
            }
            B("ext", jSONObject);
        } catch (Exception e2) {
            if (r) {
                e2.printStackTrace();
            }
        }
        d.a.i0.a.j2.b.f(c2, this.f11075b.toString());
        d.a.i0.a.j2.b.c(c2);
        if (TextUtils.equals("670", this.f11074a)) {
            d.a.i0.a.r1.l.a.d(this.f11079f, this.f11075b);
            d.a.i0.a.e0.d.h("HybridUbcFlow", "670: " + d().toString());
        }
    }

    public boolean n(String str) {
        return this.f11078e.get(str) != null;
    }

    public final boolean o() {
        boolean isEmpty;
        synchronized (this.f11077d) {
            isEmpty = this.f11077d.isEmpty();
        }
        return isEmpty;
    }

    public boolean p() {
        return this.f11081h;
    }

    public boolean q() {
        return this.f11080g;
    }

    public boolean r() {
        return this.f11082i;
    }

    public final boolean s(UbcFlowEvent ubcFlowEvent) {
        return (ubcFlowEvent == null || TextUtils.isEmpty(ubcFlowEvent.f11088a)) ? false : true;
    }

    public boolean t() {
        return this.j;
    }

    public boolean u() {
        return this.k;
    }

    public final void v(UbcFlowEvent ubcFlowEvent) {
        if (s(this.f11078e.get(ubcFlowEvent.f11088a))) {
            return;
        }
        L(ubcFlowEvent);
    }

    public HybridUbcFlow w(HybridUbcFlow hybridUbcFlow) {
        if (hybridUbcFlow == null) {
            return this;
        }
        hybridUbcFlow.N();
        D(hybridUbcFlow.f11079f);
        this.f11076c.putAll(hybridUbcFlow.f11076c);
        return this;
    }

    public HybridUbcFlow x() {
        if (r) {
            Log.i("HybridUbcFlow", "naFlowDone");
        }
        this.f11080g = true;
        c();
        return this;
    }

    public HybridUbcFlow y() {
        if (r) {
            Log.i("HybridUbcFlow", "naPaintFlowDone");
        }
        this.f11082i = true;
        b("fmp_callback");
        c();
        return this;
    }

    public HybridUbcFlow z(@Nullable d.a.i0.a.p.e.b bVar) {
        String str;
        if (r) {
            StringBuilder sb = new StringBuilder();
            sb.append("naPaintFlowDone, slave page=");
            if (bVar == null) {
                str = StringUtil.NULL_STRING;
            } else {
                str = bVar.o() + ", routeId=" + bVar.j0();
            }
            sb.append(str);
            Log.i("HybridUbcFlow", sb.toString());
        }
        if (bVar != null) {
            String j0 = bVar.j0();
            if (j0 != null) {
                this.o.put("routeId", j0);
            }
            String b2 = bVar.b();
            if (b2 != null) {
                this.o.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, b2);
            }
            String o = bVar.o();
            if (o != null) {
                this.o.put("pageUrl", o);
            }
        }
        b("fmp_callback");
        this.f11082i = true;
        c();
        return this;
    }
}
