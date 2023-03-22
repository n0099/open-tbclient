package com.baidu.swan.apps.runtime.config;

import android.graphics.Color;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.baidu.sapi2.SapiOptions;
import com.baidu.sapi2.dto.IsShowRealNameGuideDTO;
import com.baidu.sapi2.stat.ShareLoginStat;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tieba.a33;
import com.baidu.tieba.ar2;
import com.baidu.tieba.do1;
import com.baidu.tieba.e83;
import com.baidu.tieba.g62;
import com.baidu.tieba.g83;
import com.baidu.tieba.gt2;
import com.baidu.tieba.h83;
import com.baidu.tieba.i83;
import com.baidu.tieba.k52;
import com.baidu.tieba.l83;
import com.baidu.tieba.lb3;
import com.baidu.tieba.ll3;
import com.baidu.tieba.n33;
import com.baidu.tieba.p33;
import com.baidu.tieba.qs2;
import com.baidu.tieba.r33;
import com.baidu.tieba.s33;
import com.baidu.tieba.t73;
import com.baidu.tieba.ug4;
import com.baidu.tieba.vz1;
import com.baidu.tieba.xn4;
import com.baidu.tieba.yq2;
import com.baidu.tieba.zq2;
import com.baidu.webkit.internal.CfgFileUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.yy.hiidostatis.defs.controller.SensorController;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SwanAppConfigData {
    public static final boolean v = do1.a;
    public static final h83<SwanAppConfigData> w = new a();
    public static final g83<SwanAppConfigData> x = new b();
    public static final HashMap<String, Integer> y;
    public boolean a;
    public e b;
    public l c;
    public m d;
    public i83 e;
    public n f;
    public j g;
    public e83.a h;
    public g i;
    public g j;
    public d k;
    public List<ug4> l;
    public String m;
    public String n;
    public i o;
    public f p;
    @NonNull
    public List<String> q;
    public c r;
    public p s;
    public h t;
    public boolean u;

    /* loaded from: classes3.dex */
    public static class f {
        public static final h83<f> b = new a();
        public static final g83<f> c = new b();
        public Map<String, Map<String, String>> a;

        /* loaded from: classes3.dex */
        public static class a extends h83<f> {

            /* renamed from: com.baidu.swan.apps.runtime.config.SwanAppConfigData$f$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class C0189a extends h83<Map<String, String>> {
                public C0189a(a aVar) {
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.h83
                /* renamed from: b */
                public void a(@NonNull Map<String, String> map, @NonNull zq2 zq2Var) throws Exception {
                    zq2Var.h(map);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.h83
            /* renamed from: b */
            public void a(@NonNull f fVar, @NonNull zq2 zq2Var) throws Exception {
                zq2Var.e(fVar.a, new C0189a(this));
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends g83<f> {

            /* loaded from: classes3.dex */
            public class a extends g83<Map<String, String>> {
                public a(b bVar) {
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.g83
                /* renamed from: b */
                public Map<String, String> a(@NonNull yq2 yq2Var) throws Exception {
                    return yq2Var.l();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.g83
            /* renamed from: b */
            public f a(@NonNull yq2 yq2Var) throws Exception {
                Map<String, Map<String, String>> f = yq2Var.f(new a(this));
                if (f == null) {
                    return f.b();
                }
                f fVar = new f();
                fVar.a = f;
                return fVar;
            }
        }

        public static /* synthetic */ f b() {
            return d();
        }

        public static f d() {
            f fVar = new f();
            fVar.a = new HashMap();
            return fVar;
        }

        public static f c(JSONObject jSONObject) {
            f d = d();
            if (jSONObject == null) {
                return d;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(ShareLoginStat.GetShareListStat.KEY_PERMISSION);
            if (optJSONObject == null) {
                return null;
            }
            d.a = new HashMap();
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject optJSONObject2 = optJSONObject.optJSONObject(next);
                HashMap hashMap = new HashMap();
                if (optJSONObject2 != null) {
                    Iterator<String> keys2 = optJSONObject2.keys();
                    while (keys2.hasNext()) {
                        String next2 = keys2.next();
                        hashMap.put(next2, optJSONObject2.optString(next2));
                    }
                }
                d.a.put(next, hashMap);
            }
            return d;
        }
    }

    /* loaded from: classes3.dex */
    public static class e {
        public static final g83<e> b = new a();
        public static final h83<e> c = new b();
        public List<String> a;

        public static e d() {
            if (SwanAppConfigData.v) {
                Log.w("SwanAppConfigData", "PageConfig createNullObject()");
            }
            e eVar = new e();
            eVar.a = new ArrayList();
            return eVar;
        }

        /* loaded from: classes3.dex */
        public static class a extends g83<e> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.g83
            /* renamed from: b */
            public e a(@NonNull yq2 yq2Var) throws Exception {
                e eVar = new e();
                eVar.a = yq2Var.k(Collections.emptyList());
                return eVar;
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends h83<e> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.h83
            /* renamed from: b */
            public void a(@NonNull e eVar, @NonNull zq2 zq2Var) throws Exception {
                zq2Var.g(eVar.a);
            }
        }

        public boolean c(String str) {
            List<String> list = this.a;
            if (list != null && list.contains(str)) {
                return true;
            }
            return false;
        }

        public static e b(JSONObject jSONObject) {
            if (jSONObject == null) {
                return d();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray(NotificationCompat.WearableExtender.KEY_PAGES);
            if (optJSONArray == null) {
                return d();
            }
            e eVar = new e();
            eVar.a = new ArrayList(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                eVar.a.add(optJSONArray.optString(i));
            }
            return eVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class i {
        public static final g83<i> b = new a();
        public static final h83<i> c = new b();
        public Map<String, String> a;

        public static /* synthetic */ i a() {
            return d();
        }

        public static i d() {
            i iVar = new i();
            iVar.a = new HashMap();
            return iVar;
        }

        /* loaded from: classes3.dex */
        public static class a extends g83<i> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.g83
            /* renamed from: b */
            public i a(@NonNull yq2 yq2Var) throws Exception {
                Map<String, String> l = yq2Var.l();
                if (l == null) {
                    return i.a();
                }
                i iVar = new i();
                iVar.a = l;
                return iVar;
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends h83<i> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.h83
            /* renamed from: b */
            public void a(@NonNull i iVar, @NonNull zq2 zq2Var) throws Exception {
                zq2Var.h(iVar.a);
            }
        }

        public static i c(JSONObject jSONObject) {
            int length;
            i d = d();
            if (jSONObject == null) {
                return d;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("routes");
            if (optJSONArray != null && (length = optJSONArray.length()) != 0) {
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("path");
                        String optString2 = optJSONObject.optString("page");
                        if (!d.a.containsKey(optString)) {
                            d.a.put(optString, optString2);
                        }
                    }
                }
            }
            return d;
        }
    }

    /* loaded from: classes3.dex */
    public static class j {
        public static final h83<j> b = new a();
        public static final g83<j> c = new b();
        public boolean a;

        public static j c() {
            if (SwanAppConfigData.v) {
                Log.w("SwanAppConfigData", "SettingConfig createNullObject()");
            }
            j jVar = new j();
            jVar.a = true;
            return jVar;
        }

        /* loaded from: classes3.dex */
        public static class a extends h83<j> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.h83
            /* renamed from: b */
            public void a(@NonNull j jVar, @NonNull zq2 zq2Var) throws Exception {
                zq2Var.writeBoolean(jVar.a);
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends g83<j> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.g83
            /* renamed from: b */
            public j a(@NonNull yq2 yq2Var) throws Exception {
                j jVar = new j();
                jVar.a = yq2Var.readBoolean();
                return jVar;
            }
        }

        public static j b(JSONObject jSONObject) {
            String str;
            if (jSONObject == null) {
                return c();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(IsShowRealNameGuideDTO.TYPE_SETTING);
            if (optJSONObject == null) {
                return c();
            }
            t73 M = t73.M();
            if (M == null) {
                str = "";
            } else {
                str = M.b;
            }
            j jVar = new j();
            jVar.a = optJSONObject.optBoolean(CfgFileUtils.KEY_URL_CHECK, true);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("swan_conf");
            if (optJSONObject2 != null) {
                l83.u(str, "", optJSONObject2.optJSONArray("web_view_domains"));
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("domains");
                if (optJSONObject3 != null) {
                    l83.s(str, optJSONObject3);
                }
            }
            return jVar;
        }

        public static boolean d() {
            SwanAppConfigData s = gt2.U().s();
            if (s == null) {
                return true;
            }
            j jVar = s.g;
            t73 M = t73.M();
            qs2.a aVar = null;
            if (M != null) {
                aVar = M.Y();
            }
            boolean d = vz1.d(aVar);
            boolean d2 = k52.d();
            boolean d3 = g62.d();
            boolean H = s33.H();
            boolean D = s33.D();
            if (SwanAppConfigData.v) {
                Log.d("SwanAppConfigData", "isDevelop: " + d + " isRemoteDebug: " + d2 + " isMobileDebug: " + d3 + " urlCheck: " + jVar.a);
            }
            if ((d || d2 || d3 || H || D) && !jVar.a) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public static class k {
        public static final String d = File.separator;
        public static final g83<k> e = new a();
        public static final h83<k> f = new b();
        public String a;
        public List<String> b;
        public boolean c = false;

        public static k d() {
            k kVar = new k();
            kVar.b = new ArrayList();
            return kVar;
        }

        /* loaded from: classes3.dex */
        public static class a extends g83<k> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.g83
            /* renamed from: b */
            public k a(@NonNull yq2 yq2Var) throws Exception {
                k kVar = new k();
                kVar.a = yq2Var.g();
                kVar.b = yq2Var.k(Collections.emptyList());
                kVar.c = yq2Var.readBoolean();
                return kVar;
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends h83<k> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.h83
            /* renamed from: b */
            public void a(@NonNull k kVar, @NonNull zq2 zq2Var) throws Exception {
                zq2Var.f(kVar.a);
                zq2Var.g(kVar.b);
                zq2Var.writeBoolean(kVar.c);
            }
        }

        public static k c(JSONObject jSONObject, Map<String, String> map, Map<String, String> map2, File file) {
            String str;
            if (jSONObject != null && map != null) {
                k kVar = new k();
                kVar.a = jSONObject.optString("root");
                kVar.c = jSONObject.optBoolean("independent");
                JSONArray optJSONArray = jSONObject.optJSONArray(NotificationCompat.WearableExtender.KEY_PAGES);
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    kVar.b = new ArrayList();
                    for (int i = 0; i < length; i++) {
                        String optString = optJSONArray.optString(i);
                        kVar.b.add(optString);
                        if (!TextUtils.isEmpty(kVar.a) && !TextUtils.isEmpty(optString)) {
                            if (!kVar.a.endsWith(d) && !optString.startsWith(d)) {
                                str = kVar.a + d + optString;
                            } else {
                                str = kVar.a + optString;
                            }
                            map.put(str, kVar.a);
                            if (kVar.c) {
                                map2.put(str, kVar.a);
                            }
                        }
                    }
                }
                return kVar;
            }
            return d();
        }

        public final String e() {
            List<String> list;
            if (!TextUtils.isEmpty(this.a) && (list = this.b) != null && list.size() > 0) {
                String str = this.b.get(0);
                if (this.a.endsWith(d)) {
                    String str2 = this.a;
                    this.a = str2.substring(0, str2.length() - 1);
                }
                if (str.startsWith(d)) {
                    str = str.substring(1);
                }
                return this.a + d + str;
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public static class l {
        public static final g83<l> e = new a();
        public static final h83<l> f = new b();
        public List<k> a;
        public Map<String, Boolean> b;
        public Map<String, String> c;
        public Map<String, String> d;

        public static /* synthetic */ l a() {
            return e();
        }

        public static l e() {
            l lVar = new l();
            lVar.a = new ArrayList();
            lVar.c = new HashMap();
            lVar.b = new HashMap();
            lVar.d = new HashMap();
            return lVar;
        }

        /* loaded from: classes3.dex */
        public static class b extends h83<l> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.h83
            /* renamed from: b */
            public void a(@NonNull l lVar, @NonNull zq2 zq2Var) throws Exception {
                zq2Var.d(lVar.a, k.f);
                zq2Var.a(lVar.b);
                zq2Var.h(lVar.c);
                zq2Var.h(lVar.d);
            }
        }

        public static l d(JSONObject jSONObject, @Nullable File file) {
            if (jSONObject == null) {
                return e();
            }
            return c(jSONObject.optJSONArray("subPackages"), file);
        }

        /* loaded from: classes3.dex */
        public static class a extends g83<l> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.g83
            /* renamed from: b */
            public l a(@NonNull yq2 yq2Var) throws Exception {
                l lVar = new l();
                List<k> e = yq2Var.e(k.e);
                lVar.a = e;
                if (e == null) {
                    lVar.a = new ArrayList();
                }
                Map<String, Boolean> a = yq2Var.a();
                lVar.b = a;
                if (a == null) {
                    lVar.b = new HashMap();
                }
                Map<String, String> l = yq2Var.l();
                lVar.c = l;
                if (l == null) {
                    lVar.c = new HashMap();
                }
                Map<String, String> l2 = yq2Var.l();
                lVar.d = l2;
                if (l2 == null) {
                    lVar.d = new HashMap();
                }
                return lVar;
            }
        }

        public static l c(JSONArray jSONArray, @Nullable File file) {
            if (jSONArray != null && jSONArray.length() > 0) {
                l lVar = new l();
                lVar.a = new ArrayList();
                lVar.c = new HashMap();
                lVar.b = new HashMap();
                lVar.d = new HashMap();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        lVar.a.add(k.c(optJSONObject, lVar.c, lVar.d, file));
                    }
                }
                return lVar;
            }
            return e();
        }
    }

    /* loaded from: classes3.dex */
    public static class m {
        public static final h83<m> b = new a();
        public static final g83<m> c = new b();
        public Map<String, String> a;

        public static /* synthetic */ m a() {
            return d();
        }

        public static m d() {
            m mVar = new m();
            mVar.a = new HashMap();
            return mVar;
        }

        /* loaded from: classes3.dex */
        public static class a extends h83<m> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.h83
            /* renamed from: b */
            public void a(@NonNull m mVar, @NonNull zq2 zq2Var) throws Exception {
                zq2Var.h(mVar.a);
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends g83<m> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.g83
            /* renamed from: b */
            public m a(@NonNull yq2 yq2Var) throws Exception {
                Map<String, String> l = yq2Var.l();
                if (l == null) {
                    return m.a();
                }
                m mVar = new m();
                mVar.a = l;
                return mVar;
            }
        }

        public static m c(JSONObject jSONObject, l lVar) {
            List<k> list;
            if (jSONObject != null && lVar != null && (list = lVar.a) != null && list.size() > 0) {
                JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
                if (optJSONObject == null) {
                    return d();
                }
                m mVar = new m();
                mVar.a = new HashMap();
                for (k kVar : lVar.a) {
                    if (kVar != null && !TextUtils.isEmpty(kVar.a)) {
                        Map<String, String> map = mVar.a;
                        String str = kVar.a;
                        map.put(str, optJSONObject.optString(str));
                    }
                }
                return mVar;
            }
            return d();
        }
    }

    /* loaded from: classes3.dex */
    public static class n {
        public static final h83<n> f = new a();
        public static final g83<n> g = new b();
        public int a;
        public int b;
        public int c;
        public int d;
        public List<o> e;

        public static n c() {
            if (SwanAppConfigData.v) {
                Log.w("SwanAppConfigData", "TabBarConfig createNullObject() ");
            }
            n nVar = new n();
            nVar.e = new ArrayList();
            return nVar;
        }

        public boolean e() {
            List<o> list = this.e;
            if (list != null && list.size() >= 2) {
                return true;
            }
            return false;
        }

        /* loaded from: classes3.dex */
        public static class a extends h83<n> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.h83
            /* renamed from: b */
            public void a(@NonNull n nVar, @NonNull zq2 zq2Var) throws Exception {
                zq2Var.writeInt(nVar.a);
                zq2Var.writeInt(nVar.b);
                zq2Var.writeInt(nVar.c);
                zq2Var.writeInt(nVar.d);
                zq2Var.d(nVar.e, o.e);
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends g83<n> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.g83
            /* renamed from: b */
            public n a(@NonNull yq2 yq2Var) throws Exception {
                n nVar = new n();
                nVar.a = yq2Var.readInt();
                nVar.b = yq2Var.readInt();
                nVar.c = yq2Var.readInt();
                nVar.d = yq2Var.readInt();
                List<o> e = yq2Var.e(o.f);
                nVar.e = e;
                if (e == null) {
                    nVar.e = new ArrayList();
                }
                return nVar;
            }
        }

        public boolean d(String str) {
            if (this.e == null) {
                return false;
            }
            for (int i = 0; i < this.e.size(); i++) {
                if (TextUtils.equals(this.e.get(i).a, str)) {
                    return true;
                }
            }
            return false;
        }

        public static n b(JSONObject jSONObject) {
            int length;
            if (jSONObject == null) {
                return c();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("tabBar");
            if (optJSONObject == null) {
                return c();
            }
            n nVar = new n();
            nVar.a = SwanAppConfigData.t(optJSONObject.optString("color", "#999999"));
            nVar.b = SwanAppConfigData.t(optJSONObject.optString("selectedColor", "black"));
            nVar.c = SwanAppConfigData.t(optJSONObject.optString("borderStyle", "black"));
            nVar.d = SwanAppConfigData.t(optJSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "white"));
            JSONArray optJSONArray = optJSONObject.optJSONArray("list");
            if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                if (length > 5) {
                    length = 5;
                }
                nVar.e = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    nVar.e.add(o.b(optJSONArray.optJSONObject(i)));
                }
            }
            return nVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class o {
        public static final h83<o> e = new a();
        public static final g83<o> f = new b();
        public String a;
        public String b;
        public String c;
        public String d;

        public static o c() {
            if (SwanAppConfigData.v) {
                Log.w("SwanAppConfigData", "TabItem createNullObject() ");
            }
            return new o();
        }

        /* loaded from: classes3.dex */
        public static class a extends h83<o> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.h83
            /* renamed from: b */
            public void a(@NonNull o oVar, @NonNull zq2 zq2Var) throws Exception {
                zq2Var.f(oVar.a);
                zq2Var.f(oVar.b);
                zq2Var.f(oVar.c);
                zq2Var.f(oVar.d);
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends g83<o> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.g83
            /* renamed from: b */
            public o a(@NonNull yq2 yq2Var) throws Exception {
                o oVar = new o();
                oVar.a = yq2Var.g();
                oVar.b = yq2Var.g();
                oVar.c = yq2Var.g();
                oVar.d = yq2Var.g();
                return oVar;
            }
        }

        public static o b(JSONObject jSONObject) {
            if (jSONObject == null) {
                return c();
            }
            o oVar = new o();
            oVar.a = jSONObject.optString("pagePath");
            oVar.b = jSONObject.optString("iconPath");
            oVar.c = jSONObject.optString("selectedIconPath");
            oVar.d = jSONObject.optString("text");
            return oVar;
        }
    }

    static {
        HashMap<String, Integer> hashMap = new HashMap<>();
        y = hashMap;
        hashMap.put(SensorController.KEY_LIGHT, -1);
        y.put("dark", -16777216);
    }

    public SwanAppConfigData() {
        this.q = new ArrayList(1);
    }

    public List<n33> e() {
        ArrayList arrayList = new ArrayList();
        d dVar = this.k;
        if (dVar != null && dVar.a.size() > 0) {
            arrayList.addAll(this.k.a);
        }
        return arrayList;
    }

    public String f() {
        if (l()) {
            return this.b.a.get(0);
        }
        return "";
    }

    public final boolean k() {
        l lVar = this.c;
        if (lVar != null && lVar.a != null && lVar.d != null) {
            return true;
        }
        return false;
    }

    public boolean l() {
        List<String> list;
        e eVar = this.b;
        if (eVar != null && (list = eVar.a) != null && !list.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean m() {
        l lVar = this.c;
        if (lVar != null && lVar.a != null && lVar.c != null) {
            return true;
        }
        return false;
    }

    public boolean n() {
        n nVar = this.f;
        if (nVar != null && nVar.e()) {
            return true;
        }
        return false;
    }

    /* loaded from: classes3.dex */
    public static class c {
        public static final g83<c> b = new a();
        public static final h83<c> c = new b();
        public boolean a;

        /* loaded from: classes3.dex */
        public static class a extends g83<c> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.g83
            /* renamed from: b */
            public c a(@NonNull yq2 yq2Var) throws Exception {
                c cVar = new c();
                cVar.a = yq2Var.readBoolean();
                return cVar;
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends h83<c> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.h83
            /* renamed from: b */
            public void a(@NonNull c cVar, @NonNull zq2 zq2Var) throws Exception {
                zq2Var.writeBoolean(cVar.a);
            }
        }

        public static c b(JSONObject jSONObject) {
            c cVar = new c();
            if (jSONObject == null) {
                return cVar;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("cookie");
            if (optJSONObject == null) {
                return cVar;
            }
            cVar.a = optJSONObject.optBoolean("enableStore");
            return cVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class d {
        public static final h83<d> b = new a();
        public static final g83<d> c = new b();
        public List<n33> a;

        /* loaded from: classes3.dex */
        public static class a extends h83<d> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.h83
            /* renamed from: b */
            public void a(@NonNull d dVar, @NonNull zq2 zq2Var) throws Exception {
                zq2Var.d(dVar.a, n33.l);
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends g83<d> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.g83
            /* renamed from: b */
            public d a(@NonNull yq2 yq2Var) throws Exception {
                List<n33> e = yq2Var.e(n33.k);
                if (e == null) {
                    return null;
                }
                d dVar = new d();
                dVar.a = e;
                return dVar;
            }
        }

        public static d a(JSONObject jSONObject, File file) {
            JSONObject optJSONObject;
            if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("dependencies")) == null) {
                return null;
            }
            Iterator<String> keys = optJSONObject.keys();
            d dVar = new d();
            dVar.a = new ArrayList();
            while (keys.hasNext()) {
                String next = keys.next();
                n33 n33Var = new n33(optJSONObject.optJSONObject(next), next);
                if (file != null && !TextUtils.isEmpty(n33Var.e)) {
                    n33Var.e = new File(file, n33Var.e).getAbsolutePath();
                }
                dVar.a.add(n33Var);
            }
            return dVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class g {
        public static final h83<g> b = new a();
        public static final g83<g> c = new b();
        public List<p33> a;

        /* loaded from: classes3.dex */
        public static class a extends h83<g> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.h83
            /* renamed from: b */
            public void a(@NonNull g gVar, @NonNull zq2 zq2Var) throws Exception {
                zq2Var.d(gVar.a, p33.i);
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends g83<g> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.g83
            /* renamed from: b */
            public g a(@NonNull yq2 yq2Var) throws Exception {
                List<p33> e = yq2Var.e(p33.h);
                if (e == null) {
                    return null;
                }
                g gVar = new g();
                gVar.a = e;
                return gVar;
            }
        }

        public static g c(JSONObject jSONObject, File file) {
            return e(jSONObject, "dynamicLib", 3, file);
        }

        public static g d(JSONObject jSONObject, File file) {
            return e(jSONObject, "plugins", 4, file);
        }

        public static g e(JSONObject jSONObject, String str, int i, File file) {
            g gVar = null;
            if (jSONObject != null && !TextUtils.isEmpty(str)) {
                JSONObject optJSONObject = jSONObject.optJSONObject(str);
                if (optJSONObject == null) {
                    return null;
                }
                Iterator<String> keys = optJSONObject.keys();
                gVar = new g();
                gVar.a = new ArrayList();
                while (keys.hasNext()) {
                    String next = keys.next();
                    p33 p33Var = new p33(optJSONObject.optJSONObject(next), i);
                    p33Var.g = next;
                    if (file != null && !TextUtils.isEmpty(p33Var.e)) {
                        p33Var.e = new File(file, p33Var.e).getAbsolutePath();
                    }
                    gVar.a.add(p33Var);
                }
            }
            return gVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class h {
        public static final g83<h> c = new a();
        public static final h83<h> d = new b();
        public final boolean a;
        public final String b;

        /* loaded from: classes3.dex */
        public static class a extends g83<h> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.g83
            /* renamed from: b */
            public h a(@NonNull yq2 yq2Var) throws Exception {
                return new h(yq2Var.readBoolean(), yq2Var.g());
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends h83<h> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.h83
            /* renamed from: b */
            public void a(@NonNull h hVar, @NonNull zq2 zq2Var) throws Exception {
                zq2Var.writeBoolean(hVar.a);
                zq2Var.f(hVar.b);
            }
        }

        public h(boolean z, @Nullable String str) {
            boolean z2;
            this.a = z;
            if (!TextUtils.equals(str, "click") && !TextUtils.equals(str, "show")) {
                z2 = false;
            } else {
                z2 = true;
            }
            this.b = z2 ? str : "click";
        }

        public static h a(JSONObject jSONObject) {
            if (jSONObject != null && jSONObject.has(PrefetchEvent.MODULE)) {
                JSONObject optJSONObject = jSONObject.optJSONObject(PrefetchEvent.MODULE);
                if (optJSONObject != null && optJSONObject.has(SapiOptions.KEY_CACHE_ENABLED)) {
                    boolean equals = TextUtils.equals("true", optJSONObject.optString(SapiOptions.KEY_CACHE_ENABLED));
                    String optString = optJSONObject.optString("trigger");
                    if (SwanAppConfigData.v) {
                        Log.d("SwanAppConfigData", "prefetch is on from app.json - " + optJSONObject);
                        Log.d("SwanAppConfigData", "prefetch trigger from app.json - " + optString);
                    }
                    return new h(equals, optString);
                }
                return new h(false, null);
            }
            return new h(false, null);
        }
    }

    /* loaded from: classes3.dex */
    public static class p {
        public static final g83<p> b = new a();
        public static final h83<p> c = new b();
        public boolean a;

        /* loaded from: classes3.dex */
        public static class a extends g83<p> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.g83
            /* renamed from: b */
            public p a(@NonNull yq2 yq2Var) throws Exception {
                p pVar = new p();
                pVar.a = yq2Var.readBoolean();
                return pVar;
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends h83<p> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.h83
            /* renamed from: b */
            public void a(@NonNull p pVar, @NonNull zq2 zq2Var) throws Exception {
                zq2Var.writeBoolean(pVar.a);
            }
        }

        public static p b(JSONObject jSONObject) {
            p pVar = new p();
            if (jSONObject == null) {
                return pVar;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("userAgentWritable");
            if (optJSONObject == null) {
                return pVar;
            }
            pVar.a = optJSONObject.optBoolean("request");
            return pVar;
        }
    }

    /* loaded from: classes3.dex */
    public enum RequiredBackgroundModeItem {
        AUDIO("audio");
        
        public String mMode;

        RequiredBackgroundModeItem(String str) {
            this.mMode = str;
        }

        @Nullable
        public static RequiredBackgroundModeItem find(String str) {
            RequiredBackgroundModeItem[] values;
            if (str != null) {
                for (RequiredBackgroundModeItem requiredBackgroundModeItem : values()) {
                    if (str.equals(requiredBackgroundModeItem.mMode)) {
                        return requiredBackgroundModeItem;
                    }
                }
                return null;
            }
            return null;
        }
    }

    public /* synthetic */ SwanAppConfigData(a aVar) {
        this();
    }

    public String g(String str) {
        List<k> list;
        l lVar = this.c;
        if (lVar != null && (list = lVar.a) != null) {
            for (k kVar : list) {
                if (TextUtils.equals(kVar.a, str)) {
                    return kVar.e();
                }
            }
        }
        return null;
    }

    public String h(String str) {
        String b2 = lb3.b(ll3.f(str));
        if (!TextUtils.isEmpty(b2)) {
            if (a33.k(b2)) {
                return "dynamicLib";
            }
            if (q(b2)) {
                if (o(b2)) {
                    return "independent";
                }
                return "subNormal";
            }
        }
        return "main";
    }

    public List<p33> i(int i2) {
        if (i2 == 3) {
            ArrayList arrayList = new ArrayList();
            b(this.j, arrayList);
            return arrayList;
        } else if (i2 == 4) {
            ArrayList arrayList2 = new ArrayList();
            b(this.i, arrayList2);
            return arrayList2;
        } else {
            return null;
        }
    }

    public String j(String str) {
        i iVar = this.o;
        if (iVar != null && iVar.a != null) {
            String f2 = ll3.f(str);
            String str2 = this.o.a.get(f2);
            if (TextUtils.isEmpty(str2)) {
                return str;
            }
            return str.replaceFirst(f2, str2);
        }
        return str;
    }

    public boolean o(String str) {
        if (k() && this.c.d.containsKey(str)) {
            return true;
        }
        return false;
    }

    public boolean p(String str) {
        if ((l() && this.b.c(str)) || (m() && this.c.c.containsKey(str))) {
            return true;
        }
        return false;
    }

    public boolean q(String str) {
        if (m() && this.c.c.containsKey(str)) {
            return true;
        }
        return false;
    }

    public boolean r(String str) {
        n nVar = this.f;
        if (nVar != null && nVar.d(str)) {
            return true;
        }
        return false;
    }

    /* loaded from: classes3.dex */
    public static class a extends h83<SwanAppConfigData> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.h83
        /* renamed from: b */
        public void a(@NonNull SwanAppConfigData swanAppConfigData, @NonNull zq2 zq2Var) throws Exception {
            zq2Var.writeBoolean(swanAppConfigData.a);
            zq2Var.c(swanAppConfigData.b, e.c);
            zq2Var.c(swanAppConfigData.c, l.f);
            zq2Var.c(swanAppConfigData.d, m.b);
            zq2Var.c(swanAppConfigData.e, i83.u);
            zq2Var.c(swanAppConfigData.f, n.f);
            zq2Var.c(swanAppConfigData.g, j.b);
            zq2Var.c(swanAppConfigData.h, e83.a.e);
            zq2Var.c(swanAppConfigData.i, g.b);
            zq2Var.c(swanAppConfigData.j, g.b);
            zq2Var.c(swanAppConfigData.k, d.b);
            zq2Var.f(swanAppConfigData.m);
            zq2Var.c(swanAppConfigData.o, i.c);
            zq2Var.c(swanAppConfigData.p, f.b);
            zq2Var.g(swanAppConfigData.q);
            zq2Var.c(swanAppConfigData.r, c.c);
            zq2Var.c(swanAppConfigData.s, p.c);
            zq2Var.c(swanAppConfigData.t, h.d);
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends g83<SwanAppConfigData> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.g83
        /* renamed from: b */
        public SwanAppConfigData a(@NonNull yq2 yq2Var) throws Exception {
            SwanAppConfigData swanAppConfigData = new SwanAppConfigData(null);
            swanAppConfigData.a = yq2Var.readBoolean();
            swanAppConfigData.b = (e) yq2Var.d(e.b);
            l lVar = (l) yq2Var.d(l.e);
            swanAppConfigData.c = lVar;
            if (lVar == null) {
                swanAppConfigData.c = l.a();
            }
            swanAppConfigData.d = (m) yq2Var.d(m.c);
            swanAppConfigData.e = (i83) yq2Var.d(i83.v);
            swanAppConfigData.f = (n) yq2Var.d(n.g);
            swanAppConfigData.g = (j) yq2Var.d(j.c);
            swanAppConfigData.h = (e83.a) yq2Var.d(e83.a.f);
            swanAppConfigData.i = (g) yq2Var.d(g.c);
            swanAppConfigData.j = (g) yq2Var.d(g.c);
            swanAppConfigData.k = (d) yq2Var.d(d.c);
            String g = yq2Var.g();
            swanAppConfigData.m = g;
            if (!TextUtils.isEmpty(g)) {
                swanAppConfigData.l = r33.k(swanAppConfigData.m, false);
            }
            swanAppConfigData.o = (i) yq2Var.d(i.b);
            swanAppConfigData.p = (f) yq2Var.d(f.c);
            swanAppConfigData.q = yq2Var.k(Collections.emptyList());
            swanAppConfigData.r = (c) yq2Var.d(c.b);
            swanAppConfigData.s = (p) yq2Var.d(p.b);
            swanAppConfigData.t = (h) yq2Var.d(h.c);
            return swanAppConfigData;
        }
    }

    @Nullable
    public static SwanAppConfigData c(String str, File file) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SwanAppConfigData swanAppConfigData = new SwanAppConfigData();
        swanAppConfigData.n = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            swanAppConfigData.j = g.c(jSONObject, file);
            swanAppConfigData.i = g.d(jSONObject, file);
            swanAppConfigData.k = d.a(jSONObject, file);
            swanAppConfigData.m = jSONObject.optString("remote_debug_plugins");
            JSONArray optJSONArray = jSONObject.optJSONArray("remote_debug_plugins");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                swanAppConfigData.l = r33.k(optJSONArray.toString(), false);
            }
            swanAppConfigData.a = jSONObject.optBoolean("debug");
            swanAppConfigData.b = e.b(jSONObject);
            l d2 = l.d(jSONObject, file);
            swanAppConfigData.c = d2;
            swanAppConfigData.d = m.c(jSONObject, d2);
            swanAppConfigData.e = i83.a(jSONObject);
            swanAppConfigData.f = n.b(jSONObject);
            swanAppConfigData.g = j.b(jSONObject);
            swanAppConfigData.h = e83.a.a(jSONObject);
            swanAppConfigData.o = i.c(jSONObject);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("requiredBackgroundModes");
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    String optString = optJSONArray2.optString(i2);
                    if (!TextUtils.isEmpty(optString)) {
                        swanAppConfigData.q.add(optString);
                    }
                }
            }
            swanAppConfigData.p = f.c(jSONObject);
            swanAppConfigData.r = c.b(jSONObject);
            swanAppConfigData.s = p.b(jSONObject);
            swanAppConfigData.t = h.a(jSONObject);
            swanAppConfigData.u = jSONObject.optBoolean("hasNAViewPages");
            s(swanAppConfigData, jSONObject, file);
            return swanAppConfigData;
        } catch (JSONException e2) {
            if (v) {
                Log.e("SwanAppConfigData", "buildConfigData json error: ", e2);
            }
            return null;
        }
    }

    public static String d(String str) {
        if (!TextUtils.isEmpty(str) && str.length() == 4 && str.charAt(0) == '#') {
            StringBuilder sb = new StringBuilder();
            sb.append(str.charAt(0));
            for (int i2 = 1; i2 < 4; i2++) {
                char charAt = str.charAt(i2);
                sb.append(charAt);
                sb.append(charAt);
            }
            return sb.toString();
        }
        return str;
    }

    public static int t(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return Color.parseColor(d(str));
        } catch (Exception unused) {
            if (v) {
                Log.e("SwanAppConfigData", "parseColor failed: Unknown color " + str);
            }
            if (!y.containsKey(str)) {
                return -1;
            }
            return y.get(str).intValue();
        }
    }

    public static void s(@NonNull SwanAppConfigData swanAppConfigData, @NonNull JSONObject jSONObject, @NonNull File file) {
        File file2 = new File(file, ar2.n().a() + "_app.json");
        if (!file2.exists()) {
            return;
        }
        String E = xn4.E(file2);
        if (TextUtils.isEmpty(E)) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(E);
            JSONObject optJSONObject = jSONObject2.optJSONObject("window");
            if (optJSONObject != null && optJSONObject.length() > 0) {
                swanAppConfigData.e = i83.a(jSONObject2);
                jSONObject.put("window", optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject2.optJSONObject("tabBar");
            if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                swanAppConfigData.f = n.b(jSONObject2);
                jSONObject.put("tabBar", optJSONObject2);
            }
            swanAppConfigData.n = jSONObject.toString();
        } catch (JSONException e2) {
            if (v) {
                e2.printStackTrace();
            }
        }
    }

    public final void b(g gVar, List<p33> list) {
        List<p33> list2;
        if (gVar != null && list != null && (list2 = gVar.a) != null && list2.size() > 0) {
            list.addAll(list2);
        }
    }
}
