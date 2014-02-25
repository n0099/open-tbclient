package com.baidu.sapi2;

import com.baidu.sapi2.utils.enums.RegistMode;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class b {
    private static final String a = "reg_mode";
    private static final String b = "cache";
    private static final String c = "enabled";
    private static final String d = "modules";
    private static final String e = "id";
    private static final String f = "ref_entry";
    private static final String g = "ref";
    private static final String h = "download_url";
    private static final String i = "version";
    private static final String j = "hash";
    private a k = new a();
    private RegistMode l = RegistMode.getDefault();

    public RegistMode a() {
        return this.l;
    }

    public a b() {
        return this.k;
    }

    public String c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(b, this.k.c());
            jSONObject.put(a, this.l.getStrValue());
            return jSONObject.toString();
        } catch (JSONException e2) {
            return null;
        }
    }

    public static b a(JSONObject jSONObject) {
        b bVar = new b();
        bVar.k = a.a(jSONObject.optJSONObject(b));
        bVar.l = RegistMode.mapStrToValue(jSONObject.optString(a));
        return bVar;
    }

    /* loaded from: classes.dex */
    public class a {
        private static final String a = ".BD_SAPI_CACHE";
        private List<C0010a> c = new ArrayList();
        private boolean b = true;

        public boolean a() {
            return this.b;
        }

        public List<C0010a> b() {
            return this.c;
        }

        /* renamed from: com.baidu.sapi2.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0010a {
            public String a;
            public String b;
            public C0011a c = new C0011a();

            /* renamed from: com.baidu.sapi2.b$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class C0011a {
                public String a;
                public long b = 0;
                public String c;

                JSONObject a() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(b.h, this.a);
                        jSONObject.put(b.i, this.b);
                        jSONObject.put(b.j, this.c);
                        return jSONObject;
                    } catch (JSONException e) {
                        return null;
                    }
                }

                public static C0011a a(JSONObject jSONObject) {
                    C0011a c0011a = new C0011a();
                    if (jSONObject != null) {
                        c0011a.a = jSONObject.optString(b.h);
                        c0011a.b = jSONObject.optLong(b.i);
                        c0011a.c = jSONObject.optString(b.j);
                    }
                    return c0011a;
                }
            }

            JSONObject a() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(b.e, this.a);
                    jSONObject.put(b.g, this.b);
                    jSONObject.put(b.f, this.c.a());
                    return jSONObject;
                } catch (JSONException e) {
                    return null;
                }
            }

            static C0010a a(JSONObject jSONObject) {
                C0010a c0010a = new C0010a();
                c0010a.a = jSONObject.optString(b.e);
                c0010a.b = jSONObject.optString(b.g);
                c0010a.c = C0011a.a(jSONObject.optJSONObject(b.f));
                return c0010a;
            }

            public static String a(String str) {
                return b(str).replace(IOUtils.DIR_SEPARATOR_UNIX, '-');
            }

            public static String b(String str) {
                return str.replace(':', IOUtils.DIR_SEPARATOR_UNIX);
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
                return this.a.equals(((C0010a) obj).a);
            }

            public int hashCode() {
                return this.a.hashCode();
            }
        }

        JSONObject c() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(b.c, this.b);
                JSONArray jSONArray = new JSONArray();
                for (C0010a c0010a : b()) {
                    jSONArray.put(c0010a.a());
                }
                jSONObject.put(b.d, jSONArray);
                return jSONObject;
            } catch (JSONException e) {
                return null;
            }
        }

        static a a(JSONObject jSONObject) {
            a aVar = new a();
            try {
                aVar.b = jSONObject.optBoolean(b.c, true);
                JSONArray optJSONArray = jSONObject.optJSONArray(b.d);
                for (int i = 0; i < optJSONArray.length(); i++) {
                    aVar.b().add(C0010a.a(optJSONArray.getJSONObject(i)));
                }
            } catch (JSONException e) {
            }
            return aVar;
        }
    }
}
