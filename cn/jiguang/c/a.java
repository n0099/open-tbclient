package cn.jiguang.c;

import android.text.TextUtils;
import cn.jiguang.api.i;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a implements b {
    private static final LinkedHashMap<String, Integer> ku;
    private static final LinkedHashMap<String, Integer> kv;
    private static final LinkedHashSet<String> kx;

    static {
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        ku = linkedHashMap;
        linkedHashMap.put("s.jpush.cn", 19000);
        ku.put("sis.jpush.io", 19000);
        ku.put("easytomessage.com", 19000);
        LinkedHashMap<String, Integer> linkedHashMap2 = new LinkedHashMap<>();
        kv = linkedHashMap2;
        linkedHashMap2.put("123.196.118.23", 19000);
        kv.put("103.229.215.60", 19000);
        kv.put("117.121.49.100", 19000);
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        kx = linkedHashSet;
        linkedHashSet.add("https://tsis.jpush.cn");
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("srv");
            if (!TextUtils.isEmpty(optString)) {
                i.f(cn.jiguang.d.a.d, "srv", optString);
            }
            String optString2 = jSONObject.optString("conn");
            if (TextUtils.isEmpty(optString2)) {
                return;
            }
            i.f(cn.jiguang.d.a.d, "conn", optString2);
        } catch (Throwable th) {
        }
    }

    @Override // cn.jiguang.c.b
    public final String a() {
        return "CN";
    }

    @Override // cn.jiguang.c.b
    public final LinkedHashMap<String, Integer> bm() {
        return ku;
    }

    @Override // cn.jiguang.c.b
    public final LinkedHashMap<String, Integer> bn() {
        return kv;
    }

    @Override // cn.jiguang.c.b
    public final LinkedHashSet<String> bo() {
        return kx;
    }

    @Override // cn.jiguang.c.b
    public final String d() {
        String string = i.getString(cn.jiguang.d.a.d, "conn", "im64.jpush.cn");
        return TextUtils.isEmpty(string) ? "im64.jpush.cn" : string;
    }

    @Override // cn.jiguang.c.b
    public final String e() {
        String string = i.getString(cn.jiguang.d.a.d, "srv", "_im64._tcp.jpush.cn");
        return TextUtils.isEmpty(string) ? "_im64._tcp.jpush.cn" : string;
    }

    @Override // cn.jiguang.c.b
    public final String f() {
        return "_psis._udp.jpush.cn";
    }

    @Override // cn.jiguang.c.b
    public final String g() {
        return "stats.jpush.cn";
    }
}
