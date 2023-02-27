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
import com.baidu.tieba.aa3;
import com.baidu.tieba.ba3;
import com.baidu.tieba.d72;
import com.baidu.tieba.ea3;
import com.baidu.tieba.ed3;
import com.baidu.tieba.en3;
import com.baidu.tieba.g53;
import com.baidu.tieba.i53;
import com.baidu.tieba.ju2;
import com.baidu.tieba.k53;
import com.baidu.tieba.l53;
import com.baidu.tieba.m93;
import com.baidu.tieba.ni4;
import com.baidu.tieba.o12;
import com.baidu.tieba.qp4;
import com.baidu.tieba.rs2;
import com.baidu.tieba.ss2;
import com.baidu.tieba.t43;
import com.baidu.tieba.ts2;
import com.baidu.tieba.wp1;
import com.baidu.tieba.x93;
import com.baidu.tieba.z72;
import com.baidu.tieba.z93;
import com.baidu.tieba.zu2;
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
    public static final boolean v = wp1.a;
    public static final aa3<SwanAppConfigData> w = new a();
    public static final z93<SwanAppConfigData> x = new b();
    public static final HashMap<String, Integer> y;
    public boolean a;
    public e b;
    public l c;
    public m d;
    public ba3 e;
    public n f;
    public j g;
    public x93.a h;
    public g i;
    public g j;
    public d k;
    public List<ni4> l;
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
        public static final aa3<f> b = new a();
        public static final z93<f> c = new b();
        public Map<String, Map<String, String>> a;

        /* loaded from: classes3.dex */
        public static class a extends aa3<f> {

            /* renamed from: com.baidu.swan.apps.runtime.config.SwanAppConfigData$f$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class C0190a extends aa3<Map<String, String>> {
                public C0190a(a aVar) {
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.aa3
                /* renamed from: b */
                public void a(@NonNull Map<String, String> map, @NonNull ss2 ss2Var) throws Exception {
                    ss2Var.h(map);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.aa3
            /* renamed from: b */
            public void a(@NonNull f fVar, @NonNull ss2 ss2Var) throws Exception {
                ss2Var.e(fVar.a, new C0190a(this));
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends z93<f> {

            /* loaded from: classes3.dex */
            public class a extends z93<Map<String, String>> {
                public a(b bVar) {
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.z93
                /* renamed from: b */
                public Map<String, String> a(@NonNull rs2 rs2Var) throws Exception {
                    return rs2Var.l();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.z93
            /* renamed from: b */
            public f a(@NonNull rs2 rs2Var) throws Exception {
                Map<String, Map<String, String>> f = rs2Var.f(new a(this));
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
        public static final z93<e> b = new a();
        public static final aa3<e> c = new b();
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
        public static class a extends z93<e> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.z93
            /* renamed from: b */
            public e a(@NonNull rs2 rs2Var) throws Exception {
                e eVar = new e();
                eVar.a = rs2Var.k(Collections.emptyList());
                return eVar;
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends aa3<e> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.aa3
            /* renamed from: b */
            public void a(@NonNull e eVar, @NonNull ss2 ss2Var) throws Exception {
                ss2Var.g(eVar.a);
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
        public static final z93<i> b = new a();
        public static final aa3<i> c = new b();
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
        public static class a extends z93<i> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.z93
            /* renamed from: b */
            public i a(@NonNull rs2 rs2Var) throws Exception {
                Map<String, String> l = rs2Var.l();
                if (l == null) {
                    return i.a();
                }
                i iVar = new i();
                iVar.a = l;
                return iVar;
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends aa3<i> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.aa3
            /* renamed from: b */
            public void a(@NonNull i iVar, @NonNull ss2 ss2Var) throws Exception {
                ss2Var.h(iVar.a);
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
        public static final aa3<j> b = new a();
        public static final z93<j> c = new b();
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
        public static class a extends aa3<j> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.aa3
            /* renamed from: b */
            public void a(@NonNull j jVar, @NonNull ss2 ss2Var) throws Exception {
                ss2Var.writeBoolean(jVar.a);
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends z93<j> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.z93
            /* renamed from: b */
            public j a(@NonNull rs2 rs2Var) throws Exception {
                j jVar = new j();
                jVar.a = rs2Var.readBoolean();
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
            m93 M = m93.M();
            if (M == null) {
                str = "";
            } else {
                str = M.b;
            }
            j jVar = new j();
            jVar.a = optJSONObject.optBoolean(CfgFileUtils.KEY_URL_CHECK, true);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("swan_conf");
            if (optJSONObject2 != null) {
                ea3.u(str, "", optJSONObject2.optJSONArray("web_view_domains"));
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("domains");
                if (optJSONObject3 != null) {
                    ea3.s(str, optJSONObject3);
                }
            }
            return jVar;
        }

        public static boolean d() {
            SwanAppConfigData s = zu2.U().s();
            if (s == null) {
                return true;
            }
            j jVar = s.g;
            m93 M = m93.M();
            ju2.a aVar = null;
            if (M != null) {
                aVar = M.Y();
            }
            boolean d = o12.d(aVar);
            boolean d2 = d72.d();
            boolean d3 = z72.d();
            boolean H = l53.H();
            boolean D = l53.D();
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
        public static final z93<k> e = new a();
        public static final aa3<k> f = new b();
        public String a;
        public List<String> b;
        public boolean c = false;

        public static k d() {
            k kVar = new k();
            kVar.b = new ArrayList();
            return kVar;
        }

        /* loaded from: classes3.dex */
        public static class a extends z93<k> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.z93
            /* renamed from: b */
            public k a(@NonNull rs2 rs2Var) throws Exception {
                k kVar = new k();
                kVar.a = rs2Var.g();
                kVar.b = rs2Var.k(Collections.emptyList());
                kVar.c = rs2Var.readBoolean();
                return kVar;
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends aa3<k> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.aa3
            /* renamed from: b */
            public void a(@NonNull k kVar, @NonNull ss2 ss2Var) throws Exception {
                ss2Var.f(kVar.a);
                ss2Var.g(kVar.b);
                ss2Var.writeBoolean(kVar.c);
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
        public static final z93<l> e = new a();
        public static final aa3<l> f = new b();
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
        public static class b extends aa3<l> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.aa3
            /* renamed from: b */
            public void a(@NonNull l lVar, @NonNull ss2 ss2Var) throws Exception {
                ss2Var.d(lVar.a, k.f);
                ss2Var.a(lVar.b);
                ss2Var.h(lVar.c);
                ss2Var.h(lVar.d);
            }
        }

        public static l d(JSONObject jSONObject, @Nullable File file) {
            if (jSONObject == null) {
                return e();
            }
            return c(jSONObject.optJSONArray("subPackages"), file);
        }

        /* loaded from: classes3.dex */
        public static class a extends z93<l> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.z93
            /* renamed from: b */
            public l a(@NonNull rs2 rs2Var) throws Exception {
                l lVar = new l();
                List<k> e = rs2Var.e(k.e);
                lVar.a = e;
                if (e == null) {
                    lVar.a = new ArrayList();
                }
                Map<String, Boolean> a = rs2Var.a();
                lVar.b = a;
                if (a == null) {
                    lVar.b = new HashMap();
                }
                Map<String, String> l = rs2Var.l();
                lVar.c = l;
                if (l == null) {
                    lVar.c = new HashMap();
                }
                Map<String, String> l2 = rs2Var.l();
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
        public static final aa3<m> b = new a();
        public static final z93<m> c = new b();
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
        public static class a extends aa3<m> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.aa3
            /* renamed from: b */
            public void a(@NonNull m mVar, @NonNull ss2 ss2Var) throws Exception {
                ss2Var.h(mVar.a);
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends z93<m> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.z93
            /* renamed from: b */
            public m a(@NonNull rs2 rs2Var) throws Exception {
                Map<String, String> l = rs2Var.l();
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
        public static final aa3<n> f = new a();
        public static final z93<n> g = new b();
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
        public static class a extends aa3<n> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.aa3
            /* renamed from: b */
            public void a(@NonNull n nVar, @NonNull ss2 ss2Var) throws Exception {
                ss2Var.writeInt(nVar.a);
                ss2Var.writeInt(nVar.b);
                ss2Var.writeInt(nVar.c);
                ss2Var.writeInt(nVar.d);
                ss2Var.d(nVar.e, o.e);
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends z93<n> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.z93
            /* renamed from: b */
            public n a(@NonNull rs2 rs2Var) throws Exception {
                n nVar = new n();
                nVar.a = rs2Var.readInt();
                nVar.b = rs2Var.readInt();
                nVar.c = rs2Var.readInt();
                nVar.d = rs2Var.readInt();
                List<o> e = rs2Var.e(o.f);
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
        public static final aa3<o> e = new a();
        public static final z93<o> f = new b();
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
        public static class a extends aa3<o> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.aa3
            /* renamed from: b */
            public void a(@NonNull o oVar, @NonNull ss2 ss2Var) throws Exception {
                ss2Var.f(oVar.a);
                ss2Var.f(oVar.b);
                ss2Var.f(oVar.c);
                ss2Var.f(oVar.d);
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends z93<o> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.z93
            /* renamed from: b */
            public o a(@NonNull rs2 rs2Var) throws Exception {
                o oVar = new o();
                oVar.a = rs2Var.g();
                oVar.b = rs2Var.g();
                oVar.c = rs2Var.g();
                oVar.d = rs2Var.g();
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

    public List<g53> e() {
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
        public static final z93<c> b = new a();
        public static final aa3<c> c = new b();
        public boolean a;

        /* loaded from: classes3.dex */
        public static class a extends z93<c> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.z93
            /* renamed from: b */
            public c a(@NonNull rs2 rs2Var) throws Exception {
                c cVar = new c();
                cVar.a = rs2Var.readBoolean();
                return cVar;
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends aa3<c> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.aa3
            /* renamed from: b */
            public void a(@NonNull c cVar, @NonNull ss2 ss2Var) throws Exception {
                ss2Var.writeBoolean(cVar.a);
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
        public static final aa3<d> b = new a();
        public static final z93<d> c = new b();
        public List<g53> a;

        /* loaded from: classes3.dex */
        public static class a extends aa3<d> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.aa3
            /* renamed from: b */
            public void a(@NonNull d dVar, @NonNull ss2 ss2Var) throws Exception {
                ss2Var.d(dVar.a, g53.l);
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends z93<d> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.z93
            /* renamed from: b */
            public d a(@NonNull rs2 rs2Var) throws Exception {
                List<g53> e = rs2Var.e(g53.k);
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
                g53 g53Var = new g53(optJSONObject.optJSONObject(next), next);
                if (file != null && !TextUtils.isEmpty(g53Var.e)) {
                    g53Var.e = new File(file, g53Var.e).getAbsolutePath();
                }
                dVar.a.add(g53Var);
            }
            return dVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class g {
        public static final aa3<g> b = new a();
        public static final z93<g> c = new b();
        public List<i53> a;

        /* loaded from: classes3.dex */
        public static class a extends aa3<g> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.aa3
            /* renamed from: b */
            public void a(@NonNull g gVar, @NonNull ss2 ss2Var) throws Exception {
                ss2Var.d(gVar.a, i53.i);
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends z93<g> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.z93
            /* renamed from: b */
            public g a(@NonNull rs2 rs2Var) throws Exception {
                List<i53> e = rs2Var.e(i53.h);
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
                    i53 i53Var = new i53(optJSONObject.optJSONObject(next), i);
                    i53Var.g = next;
                    if (file != null && !TextUtils.isEmpty(i53Var.e)) {
                        i53Var.e = new File(file, i53Var.e).getAbsolutePath();
                    }
                    gVar.a.add(i53Var);
                }
            }
            return gVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class h {
        public static final z93<h> c = new a();
        public static final aa3<h> d = new b();
        public final boolean a;
        public final String b;

        /* loaded from: classes3.dex */
        public static class a extends z93<h> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.z93
            /* renamed from: b */
            public h a(@NonNull rs2 rs2Var) throws Exception {
                return new h(rs2Var.readBoolean(), rs2Var.g());
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends aa3<h> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.aa3
            /* renamed from: b */
            public void a(@NonNull h hVar, @NonNull ss2 ss2Var) throws Exception {
                ss2Var.writeBoolean(hVar.a);
                ss2Var.f(hVar.b);
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
        public static final z93<p> b = new a();
        public static final aa3<p> c = new b();
        public boolean a;

        /* loaded from: classes3.dex */
        public static class a extends z93<p> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.z93
            /* renamed from: b */
            public p a(@NonNull rs2 rs2Var) throws Exception {
                p pVar = new p();
                pVar.a = rs2Var.readBoolean();
                return pVar;
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends aa3<p> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.aa3
            /* renamed from: b */
            public void a(@NonNull p pVar, @NonNull ss2 ss2Var) throws Exception {
                ss2Var.writeBoolean(pVar.a);
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
        String b2 = ed3.b(en3.f(str));
        if (!TextUtils.isEmpty(b2)) {
            if (t43.k(b2)) {
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

    public List<i53> i(int i2) {
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
            String f2 = en3.f(str);
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
    public static class a extends aa3<SwanAppConfigData> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aa3
        /* renamed from: b */
        public void a(@NonNull SwanAppConfigData swanAppConfigData, @NonNull ss2 ss2Var) throws Exception {
            ss2Var.writeBoolean(swanAppConfigData.a);
            ss2Var.c(swanAppConfigData.b, e.c);
            ss2Var.c(swanAppConfigData.c, l.f);
            ss2Var.c(swanAppConfigData.d, m.b);
            ss2Var.c(swanAppConfigData.e, ba3.u);
            ss2Var.c(swanAppConfigData.f, n.f);
            ss2Var.c(swanAppConfigData.g, j.b);
            ss2Var.c(swanAppConfigData.h, x93.a.e);
            ss2Var.c(swanAppConfigData.i, g.b);
            ss2Var.c(swanAppConfigData.j, g.b);
            ss2Var.c(swanAppConfigData.k, d.b);
            ss2Var.f(swanAppConfigData.m);
            ss2Var.c(swanAppConfigData.o, i.c);
            ss2Var.c(swanAppConfigData.p, f.b);
            ss2Var.g(swanAppConfigData.q);
            ss2Var.c(swanAppConfigData.r, c.c);
            ss2Var.c(swanAppConfigData.s, p.c);
            ss2Var.c(swanAppConfigData.t, h.d);
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends z93<SwanAppConfigData> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.z93
        /* renamed from: b */
        public SwanAppConfigData a(@NonNull rs2 rs2Var) throws Exception {
            SwanAppConfigData swanAppConfigData = new SwanAppConfigData(null);
            swanAppConfigData.a = rs2Var.readBoolean();
            swanAppConfigData.b = (e) rs2Var.d(e.b);
            l lVar = (l) rs2Var.d(l.e);
            swanAppConfigData.c = lVar;
            if (lVar == null) {
                swanAppConfigData.c = l.a();
            }
            swanAppConfigData.d = (m) rs2Var.d(m.c);
            swanAppConfigData.e = (ba3) rs2Var.d(ba3.v);
            swanAppConfigData.f = (n) rs2Var.d(n.g);
            swanAppConfigData.g = (j) rs2Var.d(j.c);
            swanAppConfigData.h = (x93.a) rs2Var.d(x93.a.f);
            swanAppConfigData.i = (g) rs2Var.d(g.c);
            swanAppConfigData.j = (g) rs2Var.d(g.c);
            swanAppConfigData.k = (d) rs2Var.d(d.c);
            String g = rs2Var.g();
            swanAppConfigData.m = g;
            if (!TextUtils.isEmpty(g)) {
                swanAppConfigData.l = k53.k(swanAppConfigData.m, false);
            }
            swanAppConfigData.o = (i) rs2Var.d(i.b);
            swanAppConfigData.p = (f) rs2Var.d(f.c);
            swanAppConfigData.q = rs2Var.k(Collections.emptyList());
            swanAppConfigData.r = (c) rs2Var.d(c.b);
            swanAppConfigData.s = (p) rs2Var.d(p.b);
            swanAppConfigData.t = (h) rs2Var.d(h.c);
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
                swanAppConfigData.l = k53.k(optJSONArray.toString(), false);
            }
            swanAppConfigData.a = jSONObject.optBoolean("debug");
            swanAppConfigData.b = e.b(jSONObject);
            l d2 = l.d(jSONObject, file);
            swanAppConfigData.c = d2;
            swanAppConfigData.d = m.c(jSONObject, d2);
            swanAppConfigData.e = ba3.a(jSONObject);
            swanAppConfigData.f = n.b(jSONObject);
            swanAppConfigData.g = j.b(jSONObject);
            swanAppConfigData.h = x93.a.a(jSONObject);
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
        File file2 = new File(file, ts2.n().a() + "_app.json");
        if (!file2.exists()) {
            return;
        }
        String E = qp4.E(file2);
        if (TextUtils.isEmpty(E)) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(E);
            JSONObject optJSONObject = jSONObject2.optJSONObject("window");
            if (optJSONObject != null && optJSONObject.length() > 0) {
                swanAppConfigData.e = ba3.a(jSONObject2);
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

    public final void b(g gVar, List<i53> list) {
        List<i53> list2;
        if (gVar != null && list != null && (list2 = gVar.a) != null && list2.size() > 0) {
            list.addAll(list2);
        }
    }
}
