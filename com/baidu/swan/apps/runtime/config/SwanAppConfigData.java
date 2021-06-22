package com.baidu.swan.apps.runtime.config;

import android.graphics.Color;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.webkit.internal.CfgFileUtils;
import com.yy.hiidostatis.defs.controller.SensorController;
import d.a.m0.a.a2.n.c;
import d.a.m0.a.v2.o0;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
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
    public static final boolean r = d.a.m0.a.k.f46983a;
    public static final d.a.m0.a.a2.n.f<SwanAppConfigData> s = new a();
    public static final d.a.m0.a.a2.n.e<SwanAppConfigData> t = new b();
    public static final HashMap<String, Integer> u;

    /* renamed from: a  reason: collision with root package name */
    public boolean f11389a;

    /* renamed from: b  reason: collision with root package name */
    public d f11390b;

    /* renamed from: c  reason: collision with root package name */
    public j f11391c;

    /* renamed from: d  reason: collision with root package name */
    public k f11392d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.m0.a.a2.n.g f11393e;

    /* renamed from: f  reason: collision with root package name */
    public l f11394f;

    /* renamed from: g  reason: collision with root package name */
    public h f11395g;

    /* renamed from: h  reason: collision with root package name */
    public c.a f11396h;

    /* renamed from: i  reason: collision with root package name */
    public f f11397i;
    public f j;
    public List<d.a.m0.n.h.h> k;
    public String l;
    public String m;
    public g n;
    public e o;
    @NonNull
    public List<String> p;
    public c q;

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

    /* loaded from: classes3.dex */
    public static class a extends d.a.m0.a.a2.n.f<SwanAppConfigData> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.a2.n.f
        /* renamed from: c */
        public void b(@NonNull SwanAppConfigData swanAppConfigData, @NonNull d.a.m0.a.b1.d dVar) throws Exception {
            dVar.writeBoolean(swanAppConfigData.f11389a);
            dVar.e(swanAppConfigData.f11390b, d.f11402c);
            dVar.e(swanAppConfigData.f11391c, j.f11423f);
            dVar.e(swanAppConfigData.f11392d, k.f11428b);
            dVar.e(swanAppConfigData.f11393e, d.a.m0.a.a2.n.g.s);
            dVar.e(swanAppConfigData.f11394f, l.f11431f);
            dVar.e(swanAppConfigData.f11395g, h.f11413b);
            dVar.e(swanAppConfigData.f11396h, c.a.f44567e);
            dVar.e(swanAppConfigData.f11397i, f.f11407b);
            dVar.e(swanAppConfigData.j, f.f11407b);
            dVar.n(swanAppConfigData.l);
            dVar.e(swanAppConfigData.n, g.f11411c);
            dVar.e(swanAppConfigData.o, e.f11404b);
            dVar.o(swanAppConfigData.p);
            dVar.e(swanAppConfigData.q, c.f11399c);
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends d.a.m0.a.a2.n.e<SwanAppConfigData> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.a2.n.e
        /* renamed from: c */
        public SwanAppConfigData b(@NonNull d.a.m0.a.b1.c cVar) throws Exception {
            SwanAppConfigData swanAppConfigData = new SwanAppConfigData(null);
            swanAppConfigData.f11389a = cVar.readBoolean();
            swanAppConfigData.f11390b = (d) cVar.p(d.f11401b);
            j jVar = (j) cVar.p(j.f11422e);
            swanAppConfigData.f11391c = jVar;
            if (jVar == null) {
                swanAppConfigData.f11391c = j.e();
            }
            swanAppConfigData.f11392d = (k) cVar.p(k.f11429c);
            swanAppConfigData.f11393e = (d.a.m0.a.a2.n.g) cVar.p(d.a.m0.a.a2.n.g.t);
            swanAppConfigData.f11394f = (l) cVar.p(l.f11432g);
            swanAppConfigData.f11395g = (h) cVar.p(h.f11414c);
            swanAppConfigData.f11396h = (c.a) cVar.p(c.a.f44568f);
            swanAppConfigData.f11397i = (f) cVar.p(f.f11408c);
            swanAppConfigData.j = (f) cVar.p(f.f11408c);
            String s = cVar.s();
            swanAppConfigData.l = s;
            if (!TextUtils.isEmpty(s)) {
                swanAppConfigData.k = d.a.m0.a.t1.g.b.k(swanAppConfigData.l, false);
            }
            swanAppConfigData.n = (g) cVar.p(g.f11410b);
            swanAppConfigData.o = (e) cVar.p(e.f11405c);
            swanAppConfigData.p = cVar.u(Collections.emptyList());
            swanAppConfigData.q = (c) cVar.p(c.f11398b);
            return swanAppConfigData;
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: b  reason: collision with root package name */
        public static final d.a.m0.a.a2.n.e<c> f11398b = new a();

        /* renamed from: c  reason: collision with root package name */
        public static final d.a.m0.a.a2.n.f<c> f11399c = new b();

        /* renamed from: a  reason: collision with root package name */
        public boolean f11400a;

        /* loaded from: classes3.dex */
        public static class a extends d.a.m0.a.a2.n.e<c> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.m0.a.a2.n.e
            /* renamed from: c */
            public c b(@NonNull d.a.m0.a.b1.c cVar) throws Exception {
                c cVar2 = new c();
                cVar2.f11400a = cVar.readBoolean();
                return cVar2;
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends d.a.m0.a.a2.n.f<c> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.m0.a.a2.n.f
            /* renamed from: c */
            public void b(@NonNull c cVar, @NonNull d.a.m0.a.b1.d dVar) throws Exception {
                dVar.writeBoolean(cVar.f11400a);
            }
        }

        public static c b(JSONObject jSONObject) {
            JSONObject optJSONObject;
            c cVar = new c();
            if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("cookie")) == null) {
                return cVar;
            }
            cVar.f11400a = optJSONObject.optBoolean("enableStore");
            return cVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: b  reason: collision with root package name */
        public static final d.a.m0.a.a2.n.e<d> f11401b = new a();

        /* renamed from: c  reason: collision with root package name */
        public static final d.a.m0.a.a2.n.f<d> f11402c = new b();

        /* renamed from: a  reason: collision with root package name */
        public List<String> f11403a;

        /* loaded from: classes3.dex */
        public static class a extends d.a.m0.a.a2.n.e<d> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.m0.a.a2.n.e
            /* renamed from: c */
            public d b(@NonNull d.a.m0.a.b1.c cVar) throws Exception {
                d dVar = new d();
                dVar.f11403a = cVar.u(Collections.emptyList());
                return dVar;
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends d.a.m0.a.a2.n.f<d> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.m0.a.a2.n.f
            /* renamed from: c */
            public void b(@NonNull d dVar, @NonNull d.a.m0.a.b1.d dVar2) throws Exception {
                dVar2.o(dVar.f11403a);
            }
        }

        public static d b(JSONObject jSONObject) {
            if (jSONObject == null) {
                return d();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray(NotificationCompat.WearableExtender.KEY_PAGES);
            if (optJSONArray == null) {
                return d();
            }
            d dVar = new d();
            dVar.f11403a = new ArrayList(optJSONArray.length());
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                dVar.f11403a.add(optJSONArray.optString(i2));
            }
            return dVar;
        }

        public static d d() {
            if (SwanAppConfigData.r) {
                Log.w("SwanAppConfigData", "PageConfig createNullObject()");
            }
            d dVar = new d();
            dVar.f11403a = new ArrayList();
            return dVar;
        }

        public boolean c(String str) {
            List<String> list = this.f11403a;
            return list != null && list.contains(str);
        }
    }

    /* loaded from: classes3.dex */
    public static class e {

        /* renamed from: b  reason: collision with root package name */
        public static final d.a.m0.a.a2.n.f<e> f11404b = new a();

        /* renamed from: c  reason: collision with root package name */
        public static final d.a.m0.a.a2.n.e<e> f11405c = new b();

        /* renamed from: a  reason: collision with root package name */
        public Map<String, Map<String, String>> f11406a;

        /* loaded from: classes3.dex */
        public static class a extends d.a.m0.a.a2.n.f<e> {

            /* renamed from: com.baidu.swan.apps.runtime.config.SwanAppConfigData$e$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class C0161a extends d.a.m0.a.a2.n.f<Map<String, String>> {
                public C0161a(a aVar) {
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // d.a.m0.a.a2.n.f
                /* renamed from: c */
                public void b(@NonNull Map<String, String> map, @NonNull d.a.m0.a.b1.d dVar) throws Exception {
                    dVar.p(map);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.m0.a.a2.n.f
            /* renamed from: c */
            public void b(@NonNull e eVar, @NonNull d.a.m0.a.b1.d dVar) throws Exception {
                dVar.m(eVar.f11406a, new C0161a(this));
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends d.a.m0.a.a2.n.e<e> {

            /* loaded from: classes3.dex */
            public class a extends d.a.m0.a.a2.n.e<Map<String, String>> {
                public a(b bVar) {
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // d.a.m0.a.a2.n.e
                /* renamed from: c */
                public Map<String, String> b(@NonNull d.a.m0.a.b1.c cVar) throws Exception {
                    return cVar.v();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.m0.a.a2.n.e
            /* renamed from: c */
            public e b(@NonNull d.a.m0.a.b1.c cVar) throws Exception {
                Map<String, Map<String, String>> r = cVar.r(new a(this));
                if (r == null) {
                    return e.d();
                }
                e eVar = new e();
                eVar.f11406a = r;
                return eVar;
            }
        }

        public static e c(JSONObject jSONObject) {
            e d2 = d();
            if (jSONObject == null) {
                return d2;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("permission");
            if (optJSONObject == null) {
                return null;
            }
            d2.f11406a = new HashMap();
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
                d2.f11406a.put(next, hashMap);
            }
            return d2;
        }

        public static e d() {
            e eVar = new e();
            eVar.f11406a = new HashMap();
            return eVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class f {

        /* renamed from: b  reason: collision with root package name */
        public static final d.a.m0.a.a2.n.f<f> f11407b = new a();

        /* renamed from: c  reason: collision with root package name */
        public static final d.a.m0.a.a2.n.e<f> f11408c = new b();

        /* renamed from: a  reason: collision with root package name */
        public List<d.a.m0.a.t1.f.a> f11409a;

        /* loaded from: classes3.dex */
        public static class a extends d.a.m0.a.a2.n.f<f> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.m0.a.a2.n.f
            /* renamed from: c */
            public void b(@NonNull f fVar, @NonNull d.a.m0.a.b1.d dVar) throws Exception {
                dVar.l(fVar.f11409a, d.a.m0.a.t1.f.a.m);
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends d.a.m0.a.a2.n.e<f> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.m0.a.a2.n.e
            /* renamed from: c */
            public f b(@NonNull d.a.m0.a.b1.c cVar) throws Exception {
                List<d.a.m0.a.t1.f.a> q = cVar.q(d.a.m0.a.t1.f.a.l);
                if (q == null) {
                    return null;
                }
                f fVar = new f();
                fVar.f11409a = q;
                return fVar;
            }
        }

        public static f c(JSONObject jSONObject, File file) {
            return e(jSONObject, "dynamicLib", 3, file);
        }

        public static f d(JSONObject jSONObject, File file) {
            return e(jSONObject, "plugins", 4, file);
        }

        public static f e(JSONObject jSONObject, String str, int i2, File file) {
            f fVar = null;
            if (jSONObject != null && !TextUtils.isEmpty(str)) {
                JSONObject optJSONObject = jSONObject.optJSONObject(str);
                if (optJSONObject == null) {
                    return null;
                }
                Iterator<String> keys = optJSONObject.keys();
                fVar = new f();
                fVar.f11409a = new ArrayList();
                while (keys.hasNext()) {
                    String next = keys.next();
                    d.a.m0.a.t1.f.a aVar = new d.a.m0.a.t1.f.a(optJSONObject.optJSONObject(next), i2);
                    aVar.f48573e = next;
                    if (file != null && !TextUtils.isEmpty(aVar.j)) {
                        aVar.j = new File(file, aVar.j).getAbsolutePath();
                    }
                    fVar.f11409a.add(aVar);
                }
            }
            return fVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class g {

        /* renamed from: b  reason: collision with root package name */
        public static final d.a.m0.a.a2.n.e<g> f11410b = new a();

        /* renamed from: c  reason: collision with root package name */
        public static final d.a.m0.a.a2.n.f<g> f11411c = new b();

        /* renamed from: a  reason: collision with root package name */
        public Map<String, String> f11412a;

        /* loaded from: classes3.dex */
        public static class a extends d.a.m0.a.a2.n.e<g> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.m0.a.a2.n.e
            /* renamed from: c */
            public g b(@NonNull d.a.m0.a.b1.c cVar) throws Exception {
                Map<String, String> v = cVar.v();
                if (v == null) {
                    return g.d();
                }
                g gVar = new g();
                gVar.f11412a = v;
                return gVar;
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends d.a.m0.a.a2.n.f<g> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.m0.a.a2.n.f
            /* renamed from: c */
            public void b(@NonNull g gVar, @NonNull d.a.m0.a.b1.d dVar) throws Exception {
                dVar.p(gVar.f11412a);
            }
        }

        public static g c(JSONObject jSONObject) {
            JSONArray optJSONArray;
            int length;
            g d2 = d();
            if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("routes")) != null && (length = optJSONArray.length()) != 0) {
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("path");
                        String optString2 = optJSONObject.optString("page");
                        if (!d2.f11412a.containsKey(optString)) {
                            d2.f11412a.put(optString, optString2);
                        }
                    }
                }
            }
            return d2;
        }

        public static g d() {
            g gVar = new g();
            gVar.f11412a = new HashMap();
            return gVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class h {

        /* renamed from: b  reason: collision with root package name */
        public static final d.a.m0.a.a2.n.f<h> f11413b = new a();

        /* renamed from: c  reason: collision with root package name */
        public static final d.a.m0.a.a2.n.e<h> f11414c = new b();

        /* renamed from: a  reason: collision with root package name */
        public boolean f11415a;

        /* loaded from: classes3.dex */
        public static class a extends d.a.m0.a.a2.n.f<h> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.m0.a.a2.n.f
            /* renamed from: c */
            public void b(@NonNull h hVar, @NonNull d.a.m0.a.b1.d dVar) throws Exception {
                dVar.writeBoolean(hVar.f11415a);
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends d.a.m0.a.a2.n.e<h> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.m0.a.a2.n.e
            /* renamed from: c */
            public h b(@NonNull d.a.m0.a.b1.c cVar) throws Exception {
                h hVar = new h();
                hVar.f11415a = cVar.readBoolean();
                return hVar;
            }
        }

        public static h b(JSONObject jSONObject) {
            if (jSONObject == null) {
                return c();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(com.alipay.sdk.sys.a.j);
            if (optJSONObject == null) {
                return c();
            }
            d.a.m0.a.a2.e i2 = d.a.m0.a.a2.e.i();
            String str = i2 != null ? i2.f44533f : "";
            h hVar = new h();
            hVar.f11415a = optJSONObject.optBoolean(CfgFileUtils.KEY_URL_CHECK, true);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("swan_conf");
            if (optJSONObject2 != null) {
                d.a.m0.a.b2.a.c.u(str, "", optJSONObject2.optJSONArray("web_view_domains"));
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("domains");
                if (optJSONObject3 != null) {
                    d.a.m0.a.b2.a.c.s(str, optJSONObject3);
                }
            }
            return hVar;
        }

        public static h c() {
            if (SwanAppConfigData.r) {
                Log.w("SwanAppConfigData", "SettingConfig createNullObject()");
            }
            h hVar = new h();
            hVar.f11415a = true;
            return hVar;
        }

        public static boolean d() {
            SwanAppConfigData s = d.a.m0.a.g1.f.V().s();
            if (s == null) {
                return true;
            }
            h hVar = s.f11395g;
            d.a.m0.a.a2.e i2 = d.a.m0.a.a2.e.i();
            boolean d2 = d.a.m0.a.v.a.d(i2 != null ? i2.N() : null);
            boolean d3 = d.a.m0.a.e0.f.e.e.d();
            boolean d4 = d.a.m0.a.h0.a.d();
            boolean G = d.a.m0.a.u1.a.a.G();
            boolean C = d.a.m0.a.u1.a.a.C();
            if (SwanAppConfigData.r) {
                Log.d("SwanAppConfigData", "isDevelop: " + d2 + " isRemoteDebug: " + d3 + " isMobileDebug: " + d4 + " urlCheck: " + hVar.f11415a);
            }
            return (d2 || d3 || d4 || G || C) && !hVar.f11415a;
        }
    }

    /* loaded from: classes3.dex */
    public static class i {

        /* renamed from: d  reason: collision with root package name */
        public static final String f11416d = File.separator;

        /* renamed from: e  reason: collision with root package name */
        public static final d.a.m0.a.a2.n.e<i> f11417e = new a();

        /* renamed from: f  reason: collision with root package name */
        public static final d.a.m0.a.a2.n.f<i> f11418f = new b();

        /* renamed from: a  reason: collision with root package name */
        public String f11419a;

        /* renamed from: b  reason: collision with root package name */
        public List<String> f11420b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f11421c = false;

        /* loaded from: classes3.dex */
        public static class a extends d.a.m0.a.a2.n.e<i> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.m0.a.a2.n.e
            /* renamed from: c */
            public i b(@NonNull d.a.m0.a.b1.c cVar) throws Exception {
                i iVar = new i();
                iVar.f11419a = cVar.s();
                iVar.f11420b = cVar.u(Collections.emptyList());
                iVar.f11421c = cVar.readBoolean();
                return iVar;
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends d.a.m0.a.a2.n.f<i> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.m0.a.a2.n.f
            /* renamed from: c */
            public void b(@NonNull i iVar, @NonNull d.a.m0.a.b1.d dVar) throws Exception {
                dVar.n(iVar.f11419a);
                dVar.o(iVar.f11420b);
                dVar.writeBoolean(iVar.f11421c);
            }
        }

        public static i c(JSONObject jSONObject, Map<String, String> map, Map<String, String> map2, File file) {
            if (jSONObject != null && map != null) {
                i iVar = new i();
                iVar.f11419a = jSONObject.optString(PrefetchEvent.EVENT_DATA_ROOT_PATH);
                iVar.f11421c = jSONObject.optBoolean("independent");
                JSONArray optJSONArray = jSONObject.optJSONArray(NotificationCompat.WearableExtender.KEY_PAGES);
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    iVar.f11420b = new ArrayList();
                    for (int i2 = 0; i2 < length; i2++) {
                        String optString = optJSONArray.optString(i2);
                        iVar.f11420b.add(optString);
                        if (!TextUtils.isEmpty(iVar.f11419a) && !TextUtils.isEmpty(optString)) {
                            String str = (!iVar.f11419a.endsWith(f11416d) && !optString.startsWith(f11416d)) ? iVar.f11419a + f11416d + optString : iVar.f11419a + optString;
                            map.put(str, iVar.f11419a);
                            if (iVar.f11421c) {
                                map2.put(str, iVar.f11419a);
                            }
                        }
                    }
                }
                return iVar;
            }
            return d();
        }

        public static i d() {
            i iVar = new i();
            iVar.f11420b = new ArrayList();
            return iVar;
        }

        public final String e() {
            List<String> list;
            if (TextUtils.isEmpty(this.f11419a) || (list = this.f11420b) == null || list.size() <= 0) {
                return null;
            }
            String str = this.f11420b.get(0);
            if (this.f11419a.endsWith(f11416d)) {
                String str2 = this.f11419a;
                this.f11419a = str2.substring(0, str2.length() - 1);
            }
            if (str.startsWith(f11416d)) {
                str = str.substring(1);
            }
            return this.f11419a + f11416d + str;
        }
    }

    /* loaded from: classes3.dex */
    public static class j {

        /* renamed from: e  reason: collision with root package name */
        public static final d.a.m0.a.a2.n.e<j> f11422e = new a();

        /* renamed from: f  reason: collision with root package name */
        public static final d.a.m0.a.a2.n.f<j> f11423f = new b();

        /* renamed from: a  reason: collision with root package name */
        public List<i> f11424a;

        /* renamed from: b  reason: collision with root package name */
        public Map<String, Boolean> f11425b;

        /* renamed from: c  reason: collision with root package name */
        public Map<String, String> f11426c;

        /* renamed from: d  reason: collision with root package name */
        public Map<String, String> f11427d;

        /* loaded from: classes3.dex */
        public static class a extends d.a.m0.a.a2.n.e<j> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.m0.a.a2.n.e
            /* renamed from: c */
            public j b(@NonNull d.a.m0.a.b1.c cVar) throws Exception {
                j jVar = new j();
                List<i> q = cVar.q(i.f11417e);
                jVar.f11424a = q;
                if (q == null) {
                    jVar.f11424a = new ArrayList();
                }
                Map<String, Boolean> n = cVar.n();
                jVar.f11425b = n;
                if (n == null) {
                    jVar.f11425b = new HashMap();
                }
                Map<String, String> v = cVar.v();
                jVar.f11426c = v;
                if (v == null) {
                    jVar.f11426c = new HashMap();
                }
                Map<String, String> v2 = cVar.v();
                jVar.f11427d = v2;
                if (v2 == null) {
                    jVar.f11427d = new HashMap();
                }
                return jVar;
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends d.a.m0.a.a2.n.f<j> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.m0.a.a2.n.f
            /* renamed from: c */
            public void b(@NonNull j jVar, @NonNull d.a.m0.a.b1.d dVar) throws Exception {
                dVar.l(jVar.f11424a, i.f11418f);
                dVar.c(jVar.f11425b);
                dVar.p(jVar.f11426c);
                dVar.p(jVar.f11427d);
            }
        }

        public static j c(JSONArray jSONArray, @Nullable File file) {
            if (jSONArray != null && jSONArray.length() > 0) {
                j jVar = new j();
                jVar.f11424a = new ArrayList();
                jVar.f11426c = new HashMap();
                jVar.f11425b = new HashMap();
                jVar.f11427d = new HashMap();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        jVar.f11424a.add(i.c(optJSONObject, jVar.f11426c, jVar.f11427d, file));
                    }
                }
                return jVar;
            }
            return e();
        }

        public static j d(JSONObject jSONObject, @Nullable File file) {
            if (jSONObject == null) {
                return e();
            }
            return c(jSONObject.optJSONArray("subPackages"), file);
        }

        public static j e() {
            j jVar = new j();
            jVar.f11424a = new ArrayList();
            jVar.f11426c = new HashMap();
            jVar.f11425b = new HashMap();
            jVar.f11427d = new HashMap();
            return jVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class k {

        /* renamed from: b  reason: collision with root package name */
        public static final d.a.m0.a.a2.n.f<k> f11428b = new a();

        /* renamed from: c  reason: collision with root package name */
        public static final d.a.m0.a.a2.n.e<k> f11429c = new b();

        /* renamed from: a  reason: collision with root package name */
        public Map<String, String> f11430a;

        /* loaded from: classes3.dex */
        public static class a extends d.a.m0.a.a2.n.f<k> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.m0.a.a2.n.f
            /* renamed from: c */
            public void b(@NonNull k kVar, @NonNull d.a.m0.a.b1.d dVar) throws Exception {
                dVar.p(kVar.f11430a);
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends d.a.m0.a.a2.n.e<k> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.m0.a.a2.n.e
            /* renamed from: c */
            public k b(@NonNull d.a.m0.a.b1.c cVar) throws Exception {
                Map<String, String> v = cVar.v();
                if (v == null) {
                    return k.d();
                }
                k kVar = new k();
                kVar.f11430a = v;
                return kVar;
            }
        }

        public static k c(JSONObject jSONObject, j jVar) {
            List<i> list;
            if (jSONObject != null && jVar != null && (list = jVar.f11424a) != null && list.size() > 0) {
                JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
                if (optJSONObject == null) {
                    return d();
                }
                k kVar = new k();
                kVar.f11430a = new HashMap();
                for (i iVar : jVar.f11424a) {
                    if (iVar != null && !TextUtils.isEmpty(iVar.f11419a)) {
                        Map<String, String> map = kVar.f11430a;
                        String str = iVar.f11419a;
                        map.put(str, optJSONObject.optString(str));
                    }
                }
                return kVar;
            }
            return d();
        }

        public static k d() {
            k kVar = new k();
            kVar.f11430a = new HashMap();
            return kVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class l {

        /* renamed from: f  reason: collision with root package name */
        public static final d.a.m0.a.a2.n.f<l> f11431f = new a();

        /* renamed from: g  reason: collision with root package name */
        public static final d.a.m0.a.a2.n.e<l> f11432g = new b();

        /* renamed from: a  reason: collision with root package name */
        public int f11433a;

        /* renamed from: b  reason: collision with root package name */
        public int f11434b;

        /* renamed from: c  reason: collision with root package name */
        public int f11435c;

        /* renamed from: d  reason: collision with root package name */
        public int f11436d;

        /* renamed from: e  reason: collision with root package name */
        public List<m> f11437e;

        /* loaded from: classes3.dex */
        public static class a extends d.a.m0.a.a2.n.f<l> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.m0.a.a2.n.f
            /* renamed from: c */
            public void b(@NonNull l lVar, @NonNull d.a.m0.a.b1.d dVar) throws Exception {
                dVar.writeInt(lVar.f11433a);
                dVar.writeInt(lVar.f11434b);
                dVar.writeInt(lVar.f11435c);
                dVar.writeInt(lVar.f11436d);
                dVar.l(lVar.f11437e, m.f11438e);
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends d.a.m0.a.a2.n.e<l> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.m0.a.a2.n.e
            /* renamed from: c */
            public l b(@NonNull d.a.m0.a.b1.c cVar) throws Exception {
                l lVar = new l();
                lVar.f11433a = cVar.readInt();
                lVar.f11434b = cVar.readInt();
                lVar.f11435c = cVar.readInt();
                lVar.f11436d = cVar.readInt();
                List<m> q = cVar.q(m.f11439f);
                lVar.f11437e = q;
                if (q == null) {
                    lVar.f11437e = new ArrayList();
                }
                return lVar;
            }
        }

        public static l b(JSONObject jSONObject) {
            int length;
            if (jSONObject == null) {
                return c();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("tabBar");
            if (optJSONObject == null) {
                return c();
            }
            l lVar = new l();
            lVar.f11433a = SwanAppConfigData.s(optJSONObject.optString("color", "#999999"));
            lVar.f11434b = SwanAppConfigData.s(optJSONObject.optString("selectedColor", "black"));
            lVar.f11435c = SwanAppConfigData.s(optJSONObject.optString("borderStyle", "black"));
            lVar.f11436d = SwanAppConfigData.s(optJSONObject.optString("backgroundColor", "white"));
            JSONArray optJSONArray = optJSONObject.optJSONArray("list");
            if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                if (length > 5) {
                    length = 5;
                }
                lVar.f11437e = new ArrayList(length);
                for (int i2 = 0; i2 < length; i2++) {
                    lVar.f11437e.add(m.b(optJSONArray.optJSONObject(i2)));
                }
            }
            return lVar;
        }

        public static l c() {
            if (SwanAppConfigData.r) {
                Log.w("SwanAppConfigData", "TabBarConfig createNullObject() ");
            }
            l lVar = new l();
            lVar.f11437e = new ArrayList();
            return lVar;
        }

        public boolean d(String str) {
            if (this.f11437e == null) {
                return false;
            }
            for (int i2 = 0; i2 < this.f11437e.size(); i2++) {
                if (TextUtils.equals(this.f11437e.get(i2).f11440a, str)) {
                    return true;
                }
            }
            return false;
        }

        public boolean e() {
            List<m> list = this.f11437e;
            return list != null && list.size() >= 2;
        }
    }

    /* loaded from: classes3.dex */
    public static class m {

        /* renamed from: e  reason: collision with root package name */
        public static final d.a.m0.a.a2.n.f<m> f11438e = new a();

        /* renamed from: f  reason: collision with root package name */
        public static final d.a.m0.a.a2.n.e<m> f11439f = new b();

        /* renamed from: a  reason: collision with root package name */
        public String f11440a;

        /* renamed from: b  reason: collision with root package name */
        public String f11441b;

        /* renamed from: c  reason: collision with root package name */
        public String f11442c;

        /* renamed from: d  reason: collision with root package name */
        public String f11443d;

        /* loaded from: classes3.dex */
        public static class a extends d.a.m0.a.a2.n.f<m> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.m0.a.a2.n.f
            /* renamed from: c */
            public void b(@NonNull m mVar, @NonNull d.a.m0.a.b1.d dVar) throws Exception {
                dVar.n(mVar.f11440a);
                dVar.n(mVar.f11441b);
                dVar.n(mVar.f11442c);
                dVar.n(mVar.f11443d);
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends d.a.m0.a.a2.n.e<m> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.m0.a.a2.n.e
            /* renamed from: c */
            public m b(@NonNull d.a.m0.a.b1.c cVar) throws Exception {
                m mVar = new m();
                mVar.f11440a = cVar.s();
                mVar.f11441b = cVar.s();
                mVar.f11442c = cVar.s();
                mVar.f11443d = cVar.s();
                return mVar;
            }
        }

        public static m b(JSONObject jSONObject) {
            if (jSONObject == null) {
                return c();
            }
            m mVar = new m();
            mVar.f11440a = jSONObject.optString("pagePath");
            mVar.f11441b = jSONObject.optString("iconPath");
            mVar.f11442c = jSONObject.optString("selectedIconPath");
            mVar.f11443d = jSONObject.optString("text");
            return mVar;
        }

        public static m c() {
            if (SwanAppConfigData.r) {
                Log.w("SwanAppConfigData", "TabItem createNullObject() ");
            }
            return new m();
        }
    }

    static {
        HashMap<String, Integer> hashMap = new HashMap<>();
        u = hashMap;
        hashMap.put(SensorController.KEY_LIGHT, -1);
        u.put(SkinManager.SKIN_TYPE_STR_DARK, -16777216);
    }

    public /* synthetic */ SwanAppConfigData(a aVar) {
        this();
    }

    @Nullable
    public static SwanAppConfigData c(String str, File file) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SwanAppConfigData swanAppConfigData = new SwanAppConfigData();
        swanAppConfigData.m = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            swanAppConfigData.j = f.c(jSONObject, file);
            swanAppConfigData.f11397i = f.d(jSONObject, file);
            swanAppConfigData.l = jSONObject.optString("remote_debug_plugins");
            JSONArray optJSONArray = jSONObject.optJSONArray("remote_debug_plugins");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                swanAppConfigData.k = d.a.m0.a.t1.g.b.k(optJSONArray.toString(), false);
            }
            swanAppConfigData.f11389a = jSONObject.optBoolean("debug");
            swanAppConfigData.f11390b = d.b(jSONObject);
            j d2 = j.d(jSONObject, file);
            swanAppConfigData.f11391c = d2;
            swanAppConfigData.f11392d = k.c(jSONObject, d2);
            swanAppConfigData.f11393e = d.a.m0.a.a2.n.g.a(jSONObject);
            swanAppConfigData.f11394f = l.b(jSONObject);
            swanAppConfigData.f11395g = h.b(jSONObject);
            swanAppConfigData.f11396h = c.a.a(jSONObject);
            swanAppConfigData.n = g.c(jSONObject);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("requiredBackgroundModes");
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    String optString = optJSONArray2.optString(i2);
                    if (!TextUtils.isEmpty(optString)) {
                        swanAppConfigData.p.add(optString);
                    }
                }
            }
            swanAppConfigData.o = e.c(jSONObject);
            swanAppConfigData.q = c.b(jSONObject);
            r(swanAppConfigData, jSONObject, file);
            return swanAppConfigData;
        } catch (JSONException e2) {
            if (r) {
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

    public static void r(@NonNull SwanAppConfigData swanAppConfigData, @NonNull JSONObject jSONObject, @NonNull File file) {
        File file2 = new File(file, d.a.m0.a.c1.a.m().a() + "_app.json");
        if (file2.exists()) {
            String D = d.a.m0.t.d.D(file2);
            if (TextUtils.isEmpty(D)) {
                return;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(D);
                JSONObject optJSONObject = jSONObject2.optJSONObject("window");
                if (optJSONObject != null && optJSONObject.length() > 0) {
                    swanAppConfigData.f11393e = d.a.m0.a.a2.n.g.a(jSONObject2);
                    jSONObject.put("window", optJSONObject);
                }
                JSONObject optJSONObject2 = jSONObject2.optJSONObject("tabBar");
                if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                    swanAppConfigData.f11394f = l.b(jSONObject2);
                    jSONObject.put("tabBar", optJSONObject2);
                }
                swanAppConfigData.m = jSONObject.toString();
            } catch (JSONException e2) {
                if (r) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static int s(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return Color.parseColor(d(str));
        } catch (Exception unused) {
            if (r) {
                Log.e("SwanAppConfigData", "parseColor failed: Unknown color " + str);
            }
            if (u.containsKey(str)) {
                return u.get(str).intValue();
            }
            return -1;
        }
    }

    public final void b(f fVar, List<d.a.m0.a.t1.f.a> list) {
        List<d.a.m0.a.t1.f.a> list2;
        if (fVar == null || list == null || (list2 = fVar.f11409a) == null || list2.size() <= 0) {
            return;
        }
        list.addAll(list2);
    }

    public String e() {
        return k() ? this.f11390b.f11403a.get(0) : "";
    }

    public String f(String str) {
        List<i> list;
        j jVar = this.f11391c;
        if (jVar != null && (list = jVar.f11424a) != null) {
            for (i iVar : list) {
                if (TextUtils.equals(iVar.f11419a, str)) {
                    return iVar.e();
                }
            }
        }
        return null;
    }

    public String g(String str) {
        String b2 = d.a.m0.a.c2.f.p0.j.b(o0.f(str));
        if (!TextUtils.isEmpty(b2)) {
            if (d.a.m0.a.t1.b.a.e(b2)) {
                return "dynamicLib";
            }
            if (p(b2)) {
                return n(b2) ? "independent" : "subNormal";
            }
        }
        return FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT;
    }

    public List<d.a.m0.a.t1.f.a> h(int i2) {
        if (i2 == 3) {
            ArrayList arrayList = new ArrayList();
            b(this.j, arrayList);
            return arrayList;
        } else if (i2 == 4) {
            ArrayList arrayList2 = new ArrayList();
            b(this.f11397i, arrayList2);
            return arrayList2;
        } else {
            return null;
        }
    }

    public String i(String str) {
        g gVar = this.n;
        if (gVar == null || gVar.f11412a == null) {
            return str;
        }
        String f2 = o0.f(str);
        String str2 = this.n.f11412a.get(f2);
        return TextUtils.isEmpty(str2) ? str : str.replaceFirst(f2, str2);
    }

    public final boolean j() {
        j jVar = this.f11391c;
        return (jVar == null || jVar.f11424a == null || jVar.f11427d == null) ? false : true;
    }

    public boolean k() {
        List<String> list;
        d dVar = this.f11390b;
        return (dVar == null || (list = dVar.f11403a) == null || list.isEmpty()) ? false : true;
    }

    public boolean l() {
        j jVar = this.f11391c;
        return (jVar == null || jVar.f11424a == null || jVar.f11426c == null) ? false : true;
    }

    public boolean m() {
        l lVar = this.f11394f;
        return lVar != null && lVar.e();
    }

    public boolean n(String str) {
        return j() && this.f11391c.f11427d.containsKey(str);
    }

    public boolean o(String str) {
        return (k() && this.f11390b.c(str)) || (l() && this.f11391c.f11426c.containsKey(str));
    }

    public boolean p(String str) {
        return l() && this.f11391c.f11426c.containsKey(str);
    }

    public boolean q(String str) {
        l lVar = this.f11394f;
        return lVar != null && lVar.d(str);
    }

    public SwanAppConfigData() {
        this.p = new ArrayList(1);
    }
}
