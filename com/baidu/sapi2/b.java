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
                        jSONObject.put(b.h, this.a);
                        jSONObject.put(b.i, this.b);
                        jSONObject.put(b.j, this.c);
                        return jSONObject;
                    } catch (JSONException e) {
                        return null;
                    }
                }

                public static C0008a a(JSONObject jSONObject) {
                    C0008a c0008a = new C0008a();
                    if (jSONObject != null) {
                        c0008a.a = jSONObject.optString(b.h);
                        c0008a.b = jSONObject.optLong(b.i);
                        c0008a.c = jSONObject.optString(b.j);
                    }
                    return c0008a;
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

            static C0007a a(JSONObject jSONObject) {
                C0007a c0007a = new C0007a();
                c0007a.a = jSONObject.optString(b.e);
                c0007a.b = jSONObject.optString(b.g);
                c0007a.c = C0008a.a(jSONObject.optJSONObject(b.f));
                return c0007a;
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
                return this.a.equals(((C0007a) obj).a);
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
                for (C0007a c0007a : b()) {
                    jSONArray.put(c0007a.a());
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
                    aVar.b().add(C0007a.a(optJSONArray.getJSONObject(i)));
                }
            } catch (JSONException e) {
            }
            return aVar;
        }
    }
}
