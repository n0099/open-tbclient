package cn.com.chinatelecom.gateway.lib.c;

import cn.com.chinatelecom.gateway.lib.CtAuth;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1585a = "h";

    public static String a(int i2, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", i2);
            jSONObject.put("msg", str);
            return jSONObject.toString();
        } catch (Throwable th) {
            CtAuth.warn(f1585a, "Json parse error", th);
            return "";
        }
    }
}
