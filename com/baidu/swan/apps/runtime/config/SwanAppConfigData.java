package com.baidu.swan.apps.runtime.config;

import android.graphics.Color;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.baidu.mobads.production.cpu.CPUWebAdRequestParam;
import com.baidu.webkit.internal.CfgFileUtils;
import d.b.g0.a.i2.i0;
import d.b.g0.a.r1.n.b;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SwanAppConfigData {
    public static final boolean p = d.b.g0.a.k.f45051a;
    public static final HashMap<String, Integer> q;

    /* renamed from: a  reason: collision with root package name */
    public a f12613a;

    /* renamed from: b  reason: collision with root package name */
    public h f12614b;

    /* renamed from: c  reason: collision with root package name */
    public i f12615c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.g0.a.r1.n.c f12616d;

    /* renamed from: e  reason: collision with root package name */
    public j f12617e;

    /* renamed from: f  reason: collision with root package name */
    public f f12618f;

    /* renamed from: g  reason: collision with root package name */
    public b.a f12619g;

    /* renamed from: h  reason: collision with root package name */
    public c f12620h;
    public c i;
    @Nullable
    public d j;
    public List<d.b.g0.l.k.h> k;
    public String l;
    public e m;
    public b n;
    @NonNull
    public Set<RequiredBackgroundModeItem> o = new HashSet(1);

    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<String> f12621a;

        public static a b(JSONObject jSONObject) {
            if (jSONObject == null) {
                return d();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray(NotificationCompat.WearableExtender.KEY_PAGES);
            if (optJSONArray == null) {
                return d();
            }
            a aVar = new a();
            aVar.f12621a = new ArrayList<>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                aVar.f12621a.add(optJSONArray.optString(i));
            }
            return aVar;
        }

        public static a d() {
            if (SwanAppConfigData.p) {
                Log.e("SwanAppConfigData", "PageConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            a aVar = new a();
            aVar.f12621a = new ArrayList<>();
            return aVar;
        }

        public boolean c(String str) {
            ArrayList<String> arrayList = this.f12621a;
            return arrayList != null && arrayList.contains(str);
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Map<String, Map<String, String>> f12622a;

        public static b b(JSONObject jSONObject) {
            b c2 = c();
            if (jSONObject == null) {
                return c2;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("permission");
            if (optJSONObject == null) {
                return null;
            }
            c2.f12622a = new HashMap();
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
                c2.f12622a.put(next, hashMap);
            }
            return c2;
        }

        public static b c() {
            b bVar = new b();
            bVar.f12622a = new HashMap();
            return bVar;
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public List<d.b.g0.a.l1.f.a> f12623a;

        public static c c(JSONObject jSONObject, File file) {
            return e(jSONObject, "dynamicLib", 3, file);
        }

        public static c d(JSONObject jSONObject, File file) {
            return e(jSONObject, "plugins", 4, file);
        }

        public static c e(JSONObject jSONObject, String str, int i, File file) {
            c cVar = null;
            if (jSONObject != null && !TextUtils.isEmpty(str)) {
                JSONObject optJSONObject = jSONObject.optJSONObject(str);
                if (optJSONObject == null) {
                    return null;
                }
                Iterator<String> keys = optJSONObject.keys();
                cVar = new c();
                cVar.f12623a = new ArrayList();
                while (keys.hasNext()) {
                    String next = keys.next();
                    d.b.g0.a.l1.f.a aVar = new d.b.g0.a.l1.f.a(optJSONObject.optJSONObject(next), i);
                    aVar.f45223e = next;
                    if (file != null && !TextUtils.isEmpty(aVar.i)) {
                        aVar.i = new File(file, aVar.i).getAbsolutePath();
                    }
                    cVar.f12623a.add(aVar);
                }
            }
            return cVar;
        }
    }

    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<String> f12624a;

        @Nullable
        public static d b(JSONObject jSONObject) {
            JSONArray optJSONArray;
            if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("prelinks")) == null) {
                return null;
            }
            d dVar = new d();
            dVar.f12624a = new ArrayList<>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                dVar.f12624a.add(optJSONArray.optString(i));
            }
            return dVar;
        }
    }

    /* loaded from: classes2.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public HashMap<String, String> f12625a;

        public static e b(JSONObject jSONObject) {
            JSONArray optJSONArray;
            int length;
            e c2 = c();
            if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("routes")) != null && (length = optJSONArray.length()) != 0) {
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("path");
                        String optString2 = optJSONObject.optString("page");
                        if (!c2.f12625a.containsKey(optString)) {
                            c2.f12625a.put(optString, optString2);
                        }
                    }
                }
            }
            return c2;
        }

        public static e c() {
            e eVar = new e();
            eVar.f12625a = new HashMap<>();
            return eVar;
        }
    }

    /* loaded from: classes2.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public boolean f12626a;

        public static f b(JSONObject jSONObject) {
            if (jSONObject == null) {
                return c();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(com.alipay.sdk.sys.a.j);
            if (optJSONObject == null) {
                return c();
            }
            d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
            String str = y != null ? y.f45740f : "";
            f fVar = new f();
            fVar.f12626a = optJSONObject.optBoolean(CfgFileUtils.KEY_URL_CHECK, true);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("swan_conf");
            if (optJSONObject2 != null) {
                d.b.g0.a.s1.a.c.o(str, "", optJSONObject2.optJSONArray("web_view_domains"));
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("domains");
                if (optJSONObject3 != null) {
                    d.b.g0.a.s1.a.c.m(str, optJSONObject3);
                }
            }
            return fVar;
        }

        public static f c() {
            if (SwanAppConfigData.p) {
                Log.e("SwanAppConfigData", "SettingConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            f fVar = new f();
            fVar.f12626a = true;
            return fVar;
        }

        public static boolean d() {
            SwanAppConfigData I = d.b.g0.a.z0.f.V().I();
            if (I == null) {
                return true;
            }
            f fVar = I.f12618f;
            d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
            boolean d2 = d.b.g0.a.u.a.d(y != null ? y.L() : null);
            boolean d3 = d.b.g0.a.c0.d.d.e.d();
            boolean d4 = d.b.g0.a.e0.e.d();
            boolean C = d.b.g0.a.m1.a.a.C();
            if (SwanAppConfigData.p) {
                Log.d("SwanAppConfigData", "isDevelop: " + d2 + " isRemoteDebug: " + d3 + " isMobileDebug: " + d4 + " urlCheck: " + fVar.f12626a);
            }
            return (d2 || d3 || d4 || C) && !fVar.f12626a;
        }
    }

    /* loaded from: classes2.dex */
    public static class g {

        /* renamed from: f  reason: collision with root package name */
        public static final String f12627f = File.separator;

        /* renamed from: a  reason: collision with root package name */
        public String f12628a;

        /* renamed from: b  reason: collision with root package name */
        public List<String> f12629b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f12630c = false;

        /* renamed from: d  reason: collision with root package name */
        public c f12631d;

        /* renamed from: e  reason: collision with root package name */
        public c f12632e;

        public static g c(JSONObject jSONObject, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, File file) {
            if (jSONObject != null && hashMap != null) {
                g gVar = new g();
                gVar.f12628a = jSONObject.optString("root");
                gVar.f12630c = jSONObject.optBoolean("independent");
                JSONArray optJSONArray = jSONObject.optJSONArray(NotificationCompat.WearableExtender.KEY_PAGES);
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    gVar.f12629b = new ArrayList();
                    for (int i = 0; i < length; i++) {
                        String optString = optJSONArray.optString(i);
                        gVar.f12629b.add(optString);
                        if (!TextUtils.isEmpty(gVar.f12628a) && !TextUtils.isEmpty(optString)) {
                            String str = (!gVar.f12628a.endsWith(f12627f) && !optString.startsWith(f12627f)) ? gVar.f12628a + f12627f + optString : gVar.f12628a + optString;
                            hashMap.put(str, gVar.f12628a);
                            if (gVar.f12630c) {
                                hashMap2.put(str, gVar.f12628a);
                            }
                        }
                    }
                }
                return gVar;
            }
            return d();
        }

        public static g d() {
            g gVar = new g();
            gVar.f12629b = new ArrayList();
            return gVar;
        }

        public final String e() {
            List<String> list;
            if (TextUtils.isEmpty(this.f12628a) || (list = this.f12629b) == null || list.size() <= 0) {
                return null;
            }
            String str = this.f12629b.get(0);
            if (this.f12628a.endsWith(f12627f)) {
                String str2 = this.f12628a;
                this.f12628a = str2.substring(0, str2.length() - 1);
            }
            if (str.startsWith(f12627f)) {
                str = str.substring(1);
            }
            return this.f12628a + f12627f + str;
        }
    }

    /* loaded from: classes2.dex */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public List<g> f12633a;

        /* renamed from: b  reason: collision with root package name */
        public HashMap<String, Boolean> f12634b;

        /* renamed from: c  reason: collision with root package name */
        public HashMap<String, String> f12635c;

        /* renamed from: d  reason: collision with root package name */
        public HashMap<String, String> f12636d;

        public static h b(JSONObject jSONObject, File file) {
            if (jSONObject == null) {
                return c();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subPackages");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                h hVar = new h();
                hVar.f12633a = new ArrayList();
                hVar.f12635c = new HashMap<>();
                hVar.f12634b = new HashMap<>();
                hVar.f12636d = new HashMap<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        hVar.f12633a.add(g.c(optJSONObject, hVar.f12635c, hVar.f12636d, file));
                    }
                }
                return hVar;
            }
            return c();
        }

        public static h c() {
            h hVar = new h();
            hVar.f12633a = new ArrayList();
            hVar.f12635c = new HashMap<>();
            hVar.f12634b = new HashMap<>();
            hVar.f12636d = new HashMap<>();
            return hVar;
        }
    }

    /* loaded from: classes2.dex */
    public static class i {

        /* renamed from: a  reason: collision with root package name */
        public HashMap<String, String> f12637a;

        public static i b(JSONObject jSONObject, h hVar) {
            List<g> list;
            if (jSONObject != null && hVar != null && (list = hVar.f12633a) != null && list.size() > 0) {
                JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
                if (optJSONObject == null) {
                    return c();
                }
                i iVar = new i();
                iVar.f12637a = new HashMap<>();
                for (g gVar : hVar.f12633a) {
                    if (gVar != null && !TextUtils.isEmpty(gVar.f12628a)) {
                        HashMap<String, String> hashMap = iVar.f12637a;
                        String str = gVar.f12628a;
                        hashMap.put(str, optJSONObject.optString(str));
                    }
                }
                return iVar;
            }
            return c();
        }

        public static i c() {
            i iVar = new i();
            iVar.f12637a = new HashMap<>();
            return iVar;
        }
    }

    /* loaded from: classes2.dex */
    public static class j {

        /* renamed from: a  reason: collision with root package name */
        public int f12638a;

        /* renamed from: b  reason: collision with root package name */
        public int f12639b;

        /* renamed from: c  reason: collision with root package name */
        public int f12640c;

        /* renamed from: d  reason: collision with root package name */
        public int f12641d;

        /* renamed from: e  reason: collision with root package name */
        public ArrayList<k> f12642e;

        public static j b(JSONObject jSONObject) {
            int length;
            if (jSONObject == null) {
                return c();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("tabBar");
            if (optJSONObject == null) {
                return c();
            }
            j jVar = new j();
            jVar.f12638a = SwanAppConfigData.s(optJSONObject.optString("color", "#999999"));
            jVar.f12639b = SwanAppConfigData.s(optJSONObject.optString("selectedColor", "black"));
            jVar.f12640c = SwanAppConfigData.s(optJSONObject.optString("borderStyle", "black"));
            jVar.f12641d = SwanAppConfigData.s(optJSONObject.optString("backgroundColor", "white"));
            JSONArray optJSONArray = optJSONObject.optJSONArray("list");
            if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                if (length > 5) {
                    length = 5;
                }
                jVar.f12642e = new ArrayList<>(length);
                for (int i = 0; i < length; i++) {
                    jVar.f12642e.add(k.b(optJSONArray.optJSONObject(i)));
                }
            }
            return jVar;
        }

        public static j c() {
            if (SwanAppConfigData.p) {
                Log.e("SwanAppConfigData", "TabBarConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            j jVar = new j();
            jVar.f12642e = new ArrayList<>();
            return jVar;
        }

        public boolean d(String str) {
            if (this.f12642e == null) {
                return false;
            }
            for (int i = 0; i < this.f12642e.size(); i++) {
                if (TextUtils.equals(this.f12642e.get(i).f12643a, str)) {
                    return true;
                }
            }
            return false;
        }

        public boolean e() {
            ArrayList<k> arrayList = this.f12642e;
            return arrayList != null && arrayList.size() >= 2;
        }
    }

    /* loaded from: classes2.dex */
    public static class k {

        /* renamed from: a  reason: collision with root package name */
        public String f12643a;

        /* renamed from: b  reason: collision with root package name */
        public String f12644b;

        /* renamed from: c  reason: collision with root package name */
        public String f12645c;

        /* renamed from: d  reason: collision with root package name */
        public String f12646d;

        public static k b(JSONObject jSONObject) {
            if (jSONObject == null) {
                return c();
            }
            k kVar = new k();
            kVar.f12643a = jSONObject.optString("pagePath");
            kVar.f12644b = jSONObject.optString("iconPath");
            kVar.f12645c = jSONObject.optString("selectedIconPath");
            kVar.f12646d = jSONObject.optString("text");
            return kVar;
        }

        public static k c() {
            if (SwanAppConfigData.p) {
                Log.e("SwanAppConfigData", "TabItem createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            return new k();
        }
    }

    static {
        HashMap<String, Integer> hashMap = new HashMap<>();
        q = hashMap;
        hashMap.put(CPUWebAdRequestParam.LIGHT_MODE, -1);
        q.put("dark", -16777216);
    }

    @Nullable
    public static SwanAppConfigData c(String str, File file) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SwanAppConfigData swanAppConfigData = new SwanAppConfigData();
        swanAppConfigData.l = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            swanAppConfigData.i = c.c(jSONObject, file);
            swanAppConfigData.f12620h = c.d(jSONObject, file);
            JSONArray optJSONArray = jSONObject.optJSONArray("remote_debug_plugins");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                swanAppConfigData.k = d.b.g0.a.l1.g.b.j(optJSONArray.toString(), false);
            }
            jSONObject.optBoolean("debug");
            swanAppConfigData.f12613a = a.b(jSONObject);
            h b2 = h.b(jSONObject, file);
            swanAppConfigData.f12614b = b2;
            swanAppConfigData.f12615c = i.b(jSONObject, b2);
            swanAppConfigData.f12616d = d.b.g0.a.r1.n.c.a(jSONObject);
            swanAppConfigData.f12617e = j.b(jSONObject);
            swanAppConfigData.f12618f = f.b(jSONObject);
            swanAppConfigData.f12619g = b.a.a(jSONObject);
            swanAppConfigData.m = e.b(jSONObject);
            swanAppConfigData.j = d.b(jSONObject);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("requiredBackgroundModes");
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    RequiredBackgroundModeItem find = RequiredBackgroundModeItem.find(optJSONArray2.optString(i2));
                    if (find != null) {
                        swanAppConfigData.o.add(find);
                    }
                }
            }
            swanAppConfigData.n = b.b(jSONObject);
            r(swanAppConfigData, jSONObject, file);
            return swanAppConfigData;
        } catch (JSONException e2) {
            if (p) {
                Log.e("SwanAppConfigData", "buildConfigData json error: " + Log.getStackTraceString(e2));
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
        File file2 = new File(file, d.b.g0.a.w0.a.k().g() + "_app.json");
        if (file2.exists()) {
            String r = d.b.g0.p.d.r(file2);
            if (TextUtils.isEmpty(r)) {
                return;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(r);
                JSONObject optJSONObject = jSONObject2.optJSONObject("window");
                if (optJSONObject != null && optJSONObject.length() > 0) {
                    swanAppConfigData.f12616d = d.b.g0.a.r1.n.c.a(jSONObject2);
                    jSONObject.put("window", optJSONObject);
                }
                JSONObject optJSONObject2 = jSONObject2.optJSONObject("tabBar");
                if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                    swanAppConfigData.f12617e = j.b(jSONObject2);
                    jSONObject.put("tabBar", optJSONObject2);
                }
                swanAppConfigData.l = jSONObject.toString();
            } catch (JSONException e2) {
                if (p) {
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
        } catch (Exception e2) {
            if (p) {
                Log.d("SwanAppConfigData", "parseColor failed:" + Log.getStackTraceString(e2));
            }
            if (q.containsKey(str)) {
                return q.get(str).intValue();
            }
            return -1;
        }
    }

    public final void b(c cVar, List<d.b.g0.a.l1.f.a> list) {
        List<d.b.g0.a.l1.f.a> list2;
        if (cVar == null || list == null || (list2 = cVar.f12623a) == null || list2.size() <= 0) {
            return;
        }
        list.addAll(list2);
    }

    public String e() {
        return k() ? this.f12613a.f12621a.get(0) : "";
    }

    public String f(String str) {
        List<g> list;
        h hVar = this.f12614b;
        if (hVar != null && (list = hVar.f12633a) != null) {
            for (g gVar : list) {
                if (TextUtils.equals(gVar.f12628a, str)) {
                    return gVar.e();
                }
            }
        }
        return null;
    }

    public String g(String str) {
        String b2 = d.b.g0.a.t1.k.p0.j.b(i0.d(str));
        if (!TextUtils.isEmpty(b2)) {
            if (d.b.g0.a.l1.b.a.d(b2)) {
                return "dynamicLib";
            }
            if (p(b2)) {
                return n(b2) ? "independent" : "subNormal";
            }
        }
        return FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT;
    }

    public List<d.b.g0.a.l1.f.a> h(int i2) {
        h hVar;
        List<g> list;
        h hVar2;
        List<g> list2;
        if (i2 == 3) {
            ArrayList arrayList = new ArrayList();
            b(this.i, arrayList);
            if (!d.b.g0.a.j1.m.c.d() && (hVar2 = this.f12614b) != null && (list2 = hVar2.f12633a) != null) {
                for (g gVar : list2) {
                    if (gVar != null) {
                        b(gVar.f12631d, arrayList);
                    }
                }
            }
            return arrayList;
        } else if (i2 == 4) {
            ArrayList arrayList2 = new ArrayList();
            b(this.f12620h, arrayList2);
            if (!d.b.g0.a.j1.m.c.d() && (hVar = this.f12614b) != null && (list = hVar.f12633a) != null) {
                for (g gVar2 : list) {
                    if (gVar2 != null) {
                        b(gVar2.f12632e, arrayList2);
                    }
                }
            }
            return arrayList2;
        } else {
            return null;
        }
    }

    public String i(String str) {
        e eVar = this.m;
        if (eVar == null || eVar.f12625a == null) {
            return str;
        }
        String d2 = i0.d(str);
        String str2 = this.m.f12625a.get(d2);
        return TextUtils.isEmpty(str2) ? str : str.replaceFirst(d2, str2);
    }

    public final boolean j() {
        h hVar = this.f12614b;
        return (hVar == null || hVar.f12633a == null || hVar.f12636d == null) ? false : true;
    }

    public boolean k() {
        ArrayList<String> arrayList;
        a aVar = this.f12613a;
        return (aVar == null || (arrayList = aVar.f12621a) == null || arrayList.isEmpty()) ? false : true;
    }

    public boolean l() {
        h hVar = this.f12614b;
        return (hVar == null || hVar.f12633a == null || hVar.f12635c == null) ? false : true;
    }

    public boolean m() {
        j jVar = this.f12617e;
        return jVar != null && jVar.e();
    }

    public boolean n(String str) {
        return j() && this.f12614b.f12636d.containsKey(str);
    }

    public boolean o(String str) {
        return (k() && this.f12613a.c(str)) || (l() && this.f12614b.f12635c.containsKey(str));
    }

    public boolean p(String str) {
        return l() && this.f12614b.f12635c.containsKey(str);
    }

    public boolean q(String str) {
        j jVar = this.f12617e;
        return jVar != null && jVar.d(str);
    }
}
