package com.baidu.sapi2.passhost.framework;

import android.text.TextUtils;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.passhost.pluginsdk.PassPiInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static final int a = 100;
    private static final String b = "version";
    private static final String c = "switch";
    private static final String d = "global";
    private static final String e = "gray";
    private static final String f = "pass-sdk-offline";
    private static final String g = "pass-sdk-version";
    private static final String h = "plugins";
    private static final String i = "pid";
    private static final String j = "name";
    private static final String k = "files";
    private String l;
    private boolean m;
    private List<String> n = new ArrayList();
    private List<c> o = new ArrayList();

    /* loaded from: classes.dex */
    public static class c {
        public String a;
        public List<String> d;
        public boolean b = true;
        public int c = 100;
        public List<String> e = new ArrayList();
        public Map<String, PassPiInfo> f = new HashMap();
    }

    /* loaded from: classes.dex */
    public static class a {
        public static final String a = "local_threshold";
        public String b;
        public int c;

        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("pid", this.b);
                jSONObject.put(a, this.c);
                return jSONObject;
            } catch (JSONException e) {
                return null;
            }
        }

        public static a a(JSONObject jSONObject) {
            a aVar = new a();
            aVar.b = jSONObject.optString("pid");
            aVar.c = jSONObject.optInt(a);
            return aVar;
        }

        public static JSONArray a(List<a> list) {
            if (list == null || list.size() == 0) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            for (a aVar : list) {
                if (aVar.a() != null) {
                    jSONArray.put(aVar.a());
                }
            }
            return jSONArray;
        }

        public static List<a> a(JSONArray jSONArray) {
            if (jSONArray == null || jSONArray.length() == 0) {
                return new ArrayList();
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    arrayList.add(a(jSONArray.getJSONObject(i)));
                } catch (JSONException e) {
                    Log.e(e);
                }
            }
            return arrayList;
        }
    }

    public boolean a() {
        return this.m;
    }

    public List<String> b() {
        return this.n;
    }

    public List<c> c() {
        return this.o;
    }

    /* renamed from: com.baidu.sapi2.passhost.framework.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0088b {
        public boolean a;
        public int b = 100;
        public List<String> c = new ArrayList();

        static C0088b a(JSONObject jSONObject) {
            JSONArray optJSONArray;
            C0088b c0088b = new C0088b();
            c0088b.a = jSONObject.optBoolean(b.d, true);
            c0088b.b = jSONObject.optInt("gray", 100);
            JSONObject optJSONObject = jSONObject.optJSONObject(b.f);
            if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray(b.g)) != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    if (!TextUtils.isEmpty(optJSONArray.optString(i))) {
                        c0088b.c.add(optJSONArray.optString(i));
                    }
                }
            }
            return c0088b;
        }
    }

    public static b a(JSONObject jSONObject) {
        b bVar = new b();
        bVar.l = jSONObject.optString("version");
        C0088b a2 = C0088b.a(jSONObject.optJSONObject(c));
        if (a2 != null) {
            bVar.m = a2.a;
            bVar.n = a2.c;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(h);
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    c cVar = new c();
                    try {
                        cVar.a = optJSONObject.optString("name").split("\\.")[1];
                    } catch (Exception e2) {
                        cVar.a = "-1";
                    }
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject(c);
                    if (optJSONObject2 != null) {
                        C0088b a3 = C0088b.a(optJSONObject2);
                        cVar.b = a3.a;
                        cVar.c = a3.b;
                        cVar.d = a3.c;
                    }
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("files");
                    if (optJSONArray2 != null) {
                        for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                            JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i3);
                            if (optJSONObject3 != null) {
                                PassPiInfo fromJSONObject = PassPiInfo.fromJSONObject(optJSONObject3);
                                cVar.e.add(fromJSONObject.version);
                                cVar.f.put(fromJSONObject.version, fromJSONObject);
                            }
                        }
                    }
                    bVar.o.add(cVar);
                }
            }
        }
        return bVar;
    }
}
