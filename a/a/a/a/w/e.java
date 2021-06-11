package a.a.a.a.w;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public String f1357a;

    /* renamed from: b  reason: collision with root package name */
    public final a f1358b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Object> f1359c;

    public e(String str, a aVar) {
        this.f1357a = str;
        this.f1358b = aVar;
    }

    public e(Map<String, Object> map) {
        this.f1358b = a.f1351c;
        HashMap hashMap = new HashMap();
        this.f1359c = hashMap;
        hashMap.putAll(map);
    }

    public e(JSONObject jSONObject) {
        this(jSONObject.toString(), a.f1350b);
    }

    public byte[] a() {
        String str = this.f1357a;
        if (str == null) {
            return null;
        }
        return str.getBytes(Charset.forName("UTF-8"));
    }

    public String b() {
        String str = this.f1357a;
        if (str != null) {
            return str;
        }
        if (this.f1359c != null) {
            StringBuilder sb = new StringBuilder();
            for (String str2 : this.f1359c.keySet()) {
                if (sb.length() > 0) {
                    sb.append("&");
                }
                sb.append(str2);
                Object obj = this.f1359c.get(str2);
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
        return this.f1358b.f1352a;
    }
}
