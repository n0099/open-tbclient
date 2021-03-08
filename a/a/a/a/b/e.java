package a.a.a.a.b;

import com.baidu.webkit.internal.ETAG;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e {
    public final a BJ;

    /* renamed from: a  reason: collision with root package name */
    public String f957a;
    public Map<String, Object> c;

    public e(String str, a aVar) {
        this.f957a = str;
        this.BJ = aVar;
    }

    public e(Map<String, Object> map) {
        this.BJ = a.BK;
        HashMap hashMap = new HashMap();
        this.c = hashMap;
        hashMap.putAll(map);
    }

    public e(JSONObject jSONObject) {
        this(jSONObject.toString(), a.BJ);
    }

    public byte[] a() {
        String str = this.f957a;
        if (str == null) {
            return null;
        }
        return str.getBytes(Charset.forName("UTF-8"));
    }

    public String b() {
        String str = this.f957a;
        if (str != null) {
            return str;
        }
        if (this.c != null) {
            StringBuilder sb = new StringBuilder();
            for (String str2 : this.c.keySet()) {
                if (sb.length() > 0) {
                    sb.append(ETAG.ITEM_SEPARATOR);
                }
                sb.append(str2);
                Object obj = this.c.get(str2);
                if (obj != null) {
                    sb.append("=");
                    try {
                        sb.append(URLEncoder.encode(obj.toString(), "UTF-8"));
                    } catch (UnsupportedEncodingException e) {
                    }
                }
            }
            return sb.toString();
        }
        throw new IllegalStateException();
    }

    public String c() {
        return this.BJ.f955a;
    }
}
