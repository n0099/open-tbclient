package com.baidu.swan.apps.runtime.config;

import android.graphics.Color;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.webkit.internal.CfgFileUtils;
import d.b.h0.a.i2.i0;
import d.b.h0.a.r1.n.b;
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
/* loaded from: classes3.dex */
public class SwanAppConfigData {
    public static final boolean p = d.b.h0.a.k.f45772a;
    public static final HashMap<String, Integer> q;

    /* renamed from: a  reason: collision with root package name */
    public a f12282a;

    /* renamed from: b  reason: collision with root package name */
    public h f12283b;

    /* renamed from: c  reason: collision with root package name */
    public i f12284c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.h0.a.r1.n.c f12285d;

    /* renamed from: e  reason: collision with root package name */
    public j f12286e;

    /* renamed from: f  reason: collision with root package name */
    public f f12287f;

    /* renamed from: g  reason: collision with root package name */
    public b.a f12288g;

    /* renamed from: h  reason: collision with root package name */
    public c f12289h;
    public c i;
    @Nullable
    public d j;
    public List<d.b.h0.l.k.h> k;
    public String l;
    public e m;
    public b n;
    @NonNull
    public Set<RequiredBackgroundModeItem> o = new HashSet(1);

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
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<String> f12290a;

        public static a b(JSONObject jSONObject) {
            if (jSONObject == null) {
                return d();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray(NotificationCompat.WearableExtender.KEY_PAGES);
            if (optJSONArray == null) {
                return d();
            }
            a aVar = new a();
            aVar.f12290a = new ArrayList<>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                aVar.f12290a.add(optJSONArray.optString(i));
            }
            return aVar;
        }

        public static a d() {
            if (SwanAppConfigData.p) {
                Log.e("SwanAppConfigData", "PageConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            a aVar = new a();
            aVar.f12290a = new ArrayList<>();
            return aVar;
        }

        public boolean c(String str) {
            ArrayList<String> arrayList = this.f12290a;
            return arrayList != null && arrayList.contains(str);
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Map<String, Map<String, String>> f12291a;

        public static b b(JSONObject jSONObject) {
            b c2 = c();
            if (jSONObject == null) {
                return c2;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("permission");
            if (optJSONObject == null) {
                return null;
            }
            c2.f12291a = new HashMap();
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
                c2.f12291a.put(next, hashMap);
            }
            return c2;
        }

        public static b c() {
            b bVar = new b();
            bVar.f12291a = new HashMap();
            return bVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public List<d.b.h0.a.l1.f.a> f12292a;

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
                cVar.f12292a = new ArrayList();
                while (keys.hasNext()) {
                    String next = keys.next();
                    d.b.h0.a.l1.f.a aVar = new d.b.h0.a.l1.f.a(optJSONObject.optJSONObject(next), i);
                    aVar.f45944e = next;
                    if (file != null && !TextUtils.isEmpty(aVar.i)) {
                        aVar.i = new File(file, aVar.i).getAbsolutePath();
                    }
                    cVar.f12292a.add(aVar);
                }
            }
            return cVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<String> f12293a;

        @Nullable
        public static d b(JSONObject jSONObject) {
            JSONArray optJSONArray;
            if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("prelinks")) == null) {
                return null;
            }
            d dVar = new d();
            dVar.f12293a = new ArrayList<>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                dVar.f12293a.add(optJSONArray.optString(i));
            }
            return dVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public HashMap<String, String> f12294a;

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
                        if (!c2.f12294a.containsKey(optString)) {
                            c2.f12294a.put(optString, optString2);
                        }
                    }
                }
            }
            return c2;
        }

        public static e c() {
            e eVar = new e();
            eVar.f12294a = new HashMap<>();
            return eVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public boolean f12295a;

        public static f b(JSONObject jSONObject) {
            if (jSONObject == null) {
                return c();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(com.alipay.sdk.sys.a.j);
            if (optJSONObject == null) {
                return c();
            }
            d.b.h0.a.r1.e y = d.b.h0.a.r1.e.y();
            String str = y != null ? y.f46461f : "";
            f fVar = new f();
            fVar.f12295a = optJSONObject.optBoolean(CfgFileUtils.KEY_URL_CHECK, true);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("swan_conf");
            if (optJSONObject2 != null) {
                d.b.h0.a.s1.a.c.o(str, "", optJSONObject2.optJSONArray("web_view_domains"));
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("domains");
                if (optJSONObject3 != null) {
                    d.b.h0.a.s1.a.c.m(str, optJSONObject3);
                }
            }
            return fVar;
        }

        public static f c() {
            if (SwanAppConfigData.p) {
                Log.e("SwanAppConfigData", "SettingConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            f fVar = new f();
            fVar.f12295a = true;
            return fVar;
        }

        public static boolean d() {
            SwanAppConfigData I = d.b.h0.a.z0.f.V().I();
            if (I == null) {
                return true;
            }
            f fVar = I.f12287f;
            d.b.h0.a.r1.e y = d.b.h0.a.r1.e.y();
            boolean d2 = d.b.h0.a.u.a.d(y != null ? y.L() : null);
            boolean d3 = d.b.h0.a.c0.d.d.e.d();
            boolean d4 = d.b.h0.a.e0.e.d();
            boolean C = d.b.h0.a.m1.a.a.C();
            if (SwanAppConfigData.p) {
                Log.d("SwanAppConfigData", "isDevelop: " + d2 + " isRemoteDebug: " + d3 + " isMobileDebug: " + d4 + " urlCheck: " + fVar.f12295a);
            }
            return (d2 || d3 || d4 || C) && !fVar.f12295a;
        }
    }

    /* loaded from: classes3.dex */
    public static class g {

        /* renamed from: f  reason: collision with root package name */
        public static final String f12296f = File.separator;

        /* renamed from: a  reason: collision with root package name */
        public String f12297a;

        /* renamed from: b  reason: collision with root package name */
        public List<String> f12298b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f12299c = false;

        /* renamed from: d  reason: collision with root package name */
        public c f12300d;

        /* renamed from: e  reason: collision with root package name */
        public c f12301e;

        public static g c(JSONObject jSONObject, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, File file) {
            if (jSONObject != null && hashMap != null) {
                g gVar = new g();
                gVar.f12297a = jSONObject.optString("root");
                gVar.f12299c = jSONObject.optBoolean("independent");
                JSONArray optJSONArray = jSONObject.optJSONArray(NotificationCompat.WearableExtender.KEY_PAGES);
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    gVar.f12298b = new ArrayList();
                    for (int i = 0; i < length; i++) {
                        String optString = optJSONArray.optString(i);
                        gVar.f12298b.add(optString);
                        if (!TextUtils.isEmpty(gVar.f12297a) && !TextUtils.isEmpty(optString)) {
                            String str = (!gVar.f12297a.endsWith(f12296f) && !optString.startsWith(f12296f)) ? gVar.f12297a + f12296f + optString : gVar.f12297a + optString;
                            hashMap.put(str, gVar.f12297a);
                            if (gVar.f12299c) {
                                hashMap2.put(str, gVar.f12297a);
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
            gVar.f12298b = new ArrayList();
            return gVar;
        }

        public final String e() {
            List<String> list;
            if (TextUtils.isEmpty(this.f12297a) || (list = this.f12298b) == null || list.size() <= 0) {
                return null;
            }
            String str = this.f12298b.get(0);
            if (this.f12297a.endsWith(f12296f)) {
                String str2 = this.f12297a;
                this.f12297a = str2.substring(0, str2.length() - 1);
            }
            if (str.startsWith(f12296f)) {
                str = str.substring(1);
            }
            return this.f12297a + f12296f + str;
        }
    }

    /* loaded from: classes3.dex */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public List<g> f12302a;

        /* renamed from: b  reason: collision with root package name */
        public HashMap<String, Boolean> f12303b;

        /* renamed from: c  reason: collision with root package name */
        public HashMap<String, String> f12304c;

        /* renamed from: d  reason: collision with root package name */
        public HashMap<String, String> f12305d;

        public static h b(JSONObject jSONObject, File file) {
            if (jSONObject == null) {
                return c();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subPackages");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                h hVar = new h();
                hVar.f12302a = new ArrayList();
                hVar.f12304c = new HashMap<>();
                hVar.f12303b = new HashMap<>();
                hVar.f12305d = new HashMap<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        hVar.f12302a.add(g.c(optJSONObject, hVar.f12304c, hVar.f12305d, file));
                    }
                }
                return hVar;
            }
            return c();
        }

        public static h c() {
            h hVar = new h();
            hVar.f12302a = new ArrayList();
            hVar.f12304c = new HashMap<>();
            hVar.f12303b = new HashMap<>();
            hVar.f12305d = new HashMap<>();
            return hVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class i {

        /* renamed from: a  reason: collision with root package name */
        public HashMap<String, String> f12306a;

        public static i b(JSONObject jSONObject, h hVar) {
            List<g> list;
            if (jSONObject != null && hVar != null && (list = hVar.f12302a) != null && list.size() > 0) {
                JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
                if (optJSONObject == null) {
                    return c();
                }
                i iVar = new i();
                iVar.f12306a = new HashMap<>();
                for (g gVar : hVar.f12302a) {
                    if (gVar != null && !TextUtils.isEmpty(gVar.f12297a)) {
                        HashMap<String, String> hashMap = iVar.f12306a;
                        String str = gVar.f12297a;
                        hashMap.put(str, optJSONObject.optString(str));
                    }
                }
                return iVar;
            }
            return c();
        }

        public static i c() {
            i iVar = new i();
            iVar.f12306a = new HashMap<>();
            return iVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class j {

        /* renamed from: a  reason: collision with root package name */
        public int f12307a;

        /* renamed from: b  reason: collision with root package name */
        public int f12308b;

        /* renamed from: c  reason: collision with root package name */
        public int f12309c;

        /* renamed from: d  reason: collision with root package name */
        public int f12310d;

        /* renamed from: e  reason: collision with root package name */
        public ArrayList<k> f12311e;

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
            jVar.f12307a = SwanAppConfigData.s(optJSONObject.optString("color", "#999999"));
            jVar.f12308b = SwanAppConfigData.s(optJSONObject.optString("selectedColor", "black"));
            jVar.f12309c = SwanAppConfigData.s(optJSONObject.optString("borderStyle", "black"));
            jVar.f12310d = SwanAppConfigData.s(optJSONObject.optString("backgroundColor", "white"));
            JSONArray optJSONArray = optJSONObject.optJSONArray("list");
            if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                if (length > 5) {
                    length = 5;
                }
                jVar.f12311e = new ArrayList<>(length);
                for (int i = 0; i < length; i++) {
                    jVar.f12311e.add(k.b(optJSONArray.optJSONObject(i)));
                }
            }
            return jVar;
        }

        public static j c() {
            if (SwanAppConfigData.p) {
                Log.e("SwanAppConfigData", "TabBarConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            j jVar = new j();
            jVar.f12311e = new ArrayList<>();
            return jVar;
        }

        public boolean d(String str) {
            if (this.f12311e == null) {
                return false;
            }
            for (int i = 0; i < this.f12311e.size(); i++) {
                if (TextUtils.equals(this.f12311e.get(i).f12312a, str)) {
                    return true;
                }
            }
            return false;
        }

        public boolean e() {
            ArrayList<k> arrayList = this.f12311e;
            return arrayList != null && arrayList.size() >= 2;
        }
    }

    /* loaded from: classes3.dex */
    public static class k {

        /* renamed from: a  reason: collision with root package name */
        public String f12312a;

        /* renamed from: b  reason: collision with root package name */
        public String f12313b;

        /* renamed from: c  reason: collision with root package name */
        public String f12314c;

        /* renamed from: d  reason: collision with root package name */
        public String f12315d;

        public static k b(JSONObject jSONObject) {
            if (jSONObject == null) {
                return c();
            }
            k kVar = new k();
            kVar.f12312a = jSONObject.optString("pagePath");
            kVar.f12313b = jSONObject.optString("iconPath");
            kVar.f12314c = jSONObject.optString("selectedIconPath");
            kVar.f12315d = jSONObject.optString("text");
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
        hashMap.put("light", -1);
        q.put(SkinManager.SKIN_TYPE_STR_DARK, -16777216);
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
            swanAppConfigData.f12289h = c.d(jSONObject, file);
            JSONArray optJSONArray = jSONObject.optJSONArray("remote_debug_plugins");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                swanAppConfigData.k = d.b.h0.a.l1.g.b.j(optJSONArray.toString(), false);
            }
            jSONObject.optBoolean("debug");
            swanAppConfigData.f12282a = a.b(jSONObject);
            h b2 = h.b(jSONObject, file);
            swanAppConfigData.f12283b = b2;
            swanAppConfigData.f12284c = i.b(jSONObject, b2);
            swanAppConfigData.f12285d = d.b.h0.a.r1.n.c.a(jSONObject);
            swanAppConfigData.f12286e = j.b(jSONObject);
            swanAppConfigData.f12287f = f.b(jSONObject);
            swanAppConfigData.f12288g = b.a.a(jSONObject);
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
        File file2 = new File(file, d.b.h0.a.w0.a.k().g() + "_app.json");
        if (file2.exists()) {
            String r = d.b.h0.p.d.r(file2);
            if (TextUtils.isEmpty(r)) {
                return;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(r);
                JSONObject optJSONObject = jSONObject2.optJSONObject("window");
                if (optJSONObject != null && optJSONObject.length() > 0) {
                    swanAppConfigData.f12285d = d.b.h0.a.r1.n.c.a(jSONObject2);
                    jSONObject.put("window", optJSONObject);
                }
                JSONObject optJSONObject2 = jSONObject2.optJSONObject("tabBar");
                if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                    swanAppConfigData.f12286e = j.b(jSONObject2);
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

    public final void b(c cVar, List<d.b.h0.a.l1.f.a> list) {
        List<d.b.h0.a.l1.f.a> list2;
        if (cVar == null || list == null || (list2 = cVar.f12292a) == null || list2.size() <= 0) {
            return;
        }
        list.addAll(list2);
    }

    public String e() {
        return k() ? this.f12282a.f12290a.get(0) : "";
    }

    public String f(String str) {
        List<g> list;
        h hVar = this.f12283b;
        if (hVar != null && (list = hVar.f12302a) != null) {
            for (g gVar : list) {
                if (TextUtils.equals(gVar.f12297a, str)) {
                    return gVar.e();
                }
            }
        }
        return null;
    }

    public String g(String str) {
        String b2 = d.b.h0.a.t1.k.p0.j.b(i0.d(str));
        if (!TextUtils.isEmpty(b2)) {
            if (d.b.h0.a.l1.b.a.d(b2)) {
                return "dynamicLib";
            }
            if (p(b2)) {
                return n(b2) ? "independent" : "subNormal";
            }
        }
        return FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT;
    }

    public List<d.b.h0.a.l1.f.a> h(int i2) {
        h hVar;
        List<g> list;
        h hVar2;
        List<g> list2;
        if (i2 == 3) {
            ArrayList arrayList = new ArrayList();
            b(this.i, arrayList);
            if (!d.b.h0.a.j1.m.c.d() && (hVar2 = this.f12283b) != null && (list2 = hVar2.f12302a) != null) {
                for (g gVar : list2) {
                    if (gVar != null) {
                        b(gVar.f12300d, arrayList);
                    }
                }
            }
            return arrayList;
        } else if (i2 == 4) {
            ArrayList arrayList2 = new ArrayList();
            b(this.f12289h, arrayList2);
            if (!d.b.h0.a.j1.m.c.d() && (hVar = this.f12283b) != null && (list = hVar.f12302a) != null) {
                for (g gVar2 : list) {
                    if (gVar2 != null) {
                        b(gVar2.f12301e, arrayList2);
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
        if (eVar == null || eVar.f12294a == null) {
            return str;
        }
        String d2 = i0.d(str);
        String str2 = this.m.f12294a.get(d2);
        return TextUtils.isEmpty(str2) ? str : str.replaceFirst(d2, str2);
    }

    public final boolean j() {
        h hVar = this.f12283b;
        return (hVar == null || hVar.f12302a == null || hVar.f12305d == null) ? false : true;
    }

    public boolean k() {
        ArrayList<String> arrayList;
        a aVar = this.f12282a;
        return (aVar == null || (arrayList = aVar.f12290a) == null || arrayList.isEmpty()) ? false : true;
    }

    public boolean l() {
        h hVar = this.f12283b;
        return (hVar == null || hVar.f12302a == null || hVar.f12304c == null) ? false : true;
    }

    public boolean m() {
        j jVar = this.f12286e;
        return jVar != null && jVar.e();
    }

    public boolean n(String str) {
        return j() && this.f12283b.f12305d.containsKey(str);
    }

    public boolean o(String str) {
        return (k() && this.f12282a.c(str)) || (l() && this.f12283b.f12304c.containsKey(str));
    }

    public boolean p(String str) {
        return l() && this.f12283b.f12304c.containsKey(str);
    }

    public boolean q(String str) {
        j jVar = this.f12286e;
        return jVar != null && jVar.d(str);
    }
}
