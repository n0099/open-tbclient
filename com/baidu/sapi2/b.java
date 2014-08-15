package com.baidu.sapi2;

import com.baidu.sapi2.utils.e;
import com.baidu.sapi2.utils.enums.RegistMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class b {
    private static final String a = "reg_mode";
    private static final String b = "fast_reg_sms_num";
    private static final String c = "voluntary_share_plist";
    private static final String d = "cache";
    private static final String e = "enabled";
    private static final String f = "modules";
    private static final String g = "id";
    private static final String h = "ref_entry";
    private static final String i = "ref";
    private static final String j = "download_url";
    private static final String k = "version";
    private static final String l = "hash";
    private Map<String, Integer> p = new HashMap();
    private a m = new a();
    private RegistMode n = RegistMode.getDefault();
    private String o = e.n;

    public String a() {
        return this.o;
    }

    public Map<String, Integer> b() {
        return this.p;
    }

    public RegistMode c() {
        return this.n;
    }

    public a d() {
        return this.m;
    }

    public String e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(d, this.m.c());
            jSONObject.put(a, this.n.getStrValue());
            jSONObject.put(b, this.o);
            jSONObject.put(c, new JSONObject(this.p));
            return jSONObject.toString();
        } catch (JSONException e2) {
            return null;
        }
    }

    public static b a(JSONObject jSONObject) {
        b bVar = new b();
        bVar.m = a.a(jSONObject.optJSONObject(d));
        bVar.n = RegistMode.mapStrToValue(jSONObject.optString(a));
        bVar.o = jSONObject.optString(b, e.n);
        JSONObject optJSONObject = jSONObject.optJSONObject(c);
        if (optJSONObject != null) {
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                bVar.p.put(next, Integer.valueOf(optJSONObject.optInt(next, 0)));
            }
        }
        return bVar;
    }

    /* loaded from: classes.dex */
    public class a {
        private static final String a = ".BD_SAPI_CACHE";
        private List<C0007a> c = new ArrayList();
        private boolean b = true;

        public boolean a() {
            return this.b;
        }

        public List<C0007a> b() {
            return this.c;
        }

        /* renamed from: com.baidu.sapi2.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0007a {
            public String a;
            public String b;
            public C0008a c = new C0008a();

            /* renamed from: com.baidu.sapi2.b$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class C0008a {
                public String a;
                public long b = 0;
                public String c;

                JSONObject a() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(b.j, this.a);
                        jSONObject.put(b.k, this.b);
                        jSONObject.put(b.l, this.c);
                        return jSONObject;
                    } catch (JSONException e) {
                        return null;
                    }
                }

                public static C0008a a(JSONObject jSONObject) {
                    C0008a c0008a = new C0008a();
                    if (jSONObject != null) {
                        c0008a.a = jSONObject.optString(b.j);
                        c0008a.b = jSONObject.optLong(b.k);
                        c0008a.c = jSONObject.optString(b.l);
                    }
                    return c0008a;
                }
            }

            JSONObject a() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(b.g, this.a);
                    jSONObject.put(b.i, this.b);
                    jSONObject.put(b.h, this.c.a());
                    return jSONObject;
                } catch (JSONException e) {
                    return null;
                }
            }

            static C0007a a(JSONObject jSONObject) {
                C0007a c0007a = new C0007a();
                c0007a.a = jSONObject.optString(b.g);
                c0007a.b = jSONObject.optString(b.i);
                c0007a.c = C0008a.a(jSONObject.optJSONObject(b.h));
                return c0007a;
            }

            public static String a(String str) {
                return b(str).replace('/', '-');
            }

            public static String b(String str) {
                return str.replace(':', '/');
            }

            public static String c(String str) {
                return ".BD_SAPI_CACHE/" + b(str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                return this.a.equals(((C0007a) obj).a);
            }

            public int hashCode() {
                return this.a.hashCode();
            }
        }

        JSONObject c() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(b.e, this.b);
                JSONArray jSONArray = new JSONArray();
                for (C0007a c0007a : b()) {
                    jSONArray.put(c0007a.a());
                }
                jSONObject.put(b.f, jSONArray);
                return jSONObject;
            } catch (JSONException e) {
                return null;
            }
        }

        static a a(JSONObject jSONObject) {
            a aVar = new a();
            if (jSONObject != null) {
                try {
                    aVar.b = jSONObject.optBoolean(b.e, true);
                    JSONArray optJSONArray = jSONObject.optJSONArray(b.f);
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        aVar.b().add(C0007a.a(optJSONArray.getJSONObject(i)));
                    }
                } catch (JSONException e) {
                }
            }
            return aVar;
        }
    }
}
