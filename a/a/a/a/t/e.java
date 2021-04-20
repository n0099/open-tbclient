package a.a.a.a.t;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public String f1334a;

    /* renamed from: b  reason: collision with root package name */
    public final a f1335b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Object> f1336c;

    public e(String str, a aVar) {
        this.f1334a = str;
        this.f1335b = aVar;
    }

    public e(Map<String, Object> map) {
        this.f1335b = a.f1328c;
        HashMap hashMap = new HashMap();
        this.f1336c = hashMap;
        hashMap.putAll(map);
    }

    public e(JSONObject jSONObject) {
        this(jSONObject.toString(), a.f1327b);
    }

    public byte[] a() {
        String str = this.f1334a;
        if (str == null) {
            return null;
        }
        return str.getBytes(Charset.forName("UTF-8"));
    }

    public String b() {
        String str = this.f1334a;
        if (str != null) {
            return str;
        }
        if (this.f1336c != null) {
            StringBuilder sb = new StringBuilder();
            for (String str2 : this.f1336c.keySet()) {
                if (sb.length() > 0) {
                    sb.append("&");
                }
                sb.append(str2);
                Object obj = this.f1336c.get(str2);
                if (obj != null) {
                    sb.append("=");
                    try {
                        sb.append(URLEncoder.encode(obj.toString(), "UTF-8"));
                    } catch (UnsupportedEncodingException unused) {
                    }
                }
            }
            return sb.toString();
        }
        throw new IllegalStateException();
    }

    public String c() {
        return this.f1335b.f1329a;
    }
}
