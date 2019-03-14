package cn.jiguang.d.d;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class f {
    private static final Object d = new Object();
    private static volatile f mb;
    private long a;
    private Map<String, Set<String>> b = new HashMap();

    private f() {
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "normal";
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -1245458676:
                if (str.equals("active_launch")) {
                    c = 4;
                    break;
                }
                break;
            case -1177318867:
                if (str.equals("account")) {
                    c = '\t';
                    break;
                }
                break;
            case -1051289244:
                if (str.equals("active_user")) {
                    c = 6;
                    break;
                }
                break;
            case -1039745817:
                if (str.equals("normal")) {
                    c = '\n';
                    break;
                }
                break;
            case -820729752:
                if (str.equals("active_terminate")) {
                    c = 5;
                    break;
                }
                break;
            case -693746763:
                if (str.equals("android_awake")) {
                    c = 0;
                    break;
                }
                break;
            case 93223301:
                if (str.equals("awake")) {
                    c = 3;
                    break;
                }
                break;
            case 907150721:
                if (str.equals("detach_account")) {
                    c = '\b';
                    break;
                }
                break;
            case 1350272347:
                if (str.equals("android_awake_target")) {
                    c = 1;
                    break;
                }
                break;
            case 1825995239:
                if (str.equals("app_awake")) {
                    c = 2;
                    break;
                }
                break;
            case 1973539834:
                if (str.equals("identify_account")) {
                    c = 7;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
            case 3:
                return "awake";
            case 4:
            case 5:
            case 6:
                return "active_user";
            case 7:
            case '\b':
            case '\t':
                return "account";
            case '\n':
                return "normal";
            default:
                return !this.b.containsKey(str) ? "normal" : str;
        }
    }

    private void a(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONArray optJSONArray = jSONObject.optJSONArray(next);
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        linkedHashSet.add(optJSONArray.getString(i));
                    }
                }
                hashMap.put(next, linkedHashSet);
            }
            if (hashMap.isEmpty()) {
                return;
            }
            this.b = hashMap;
        } catch (JSONException e) {
        }
    }

    public static f bU() {
        if (mb == null) {
            synchronized (d) {
                if (mb == null) {
                    mb = new f();
                }
            }
        }
        return mb;
    }

    public final void a(Context context, JSONObject jSONObject) {
        long j = 3600000;
        cn.jiguang.d.a.d.e(context, jSONObject.optJSONArray("sis_ips").toString());
        try {
            long j2 = jSONObject.getLong("ttl");
            if (j2 >= 0) {
                j = j2;
            }
        } catch (JSONException e) {
        }
        cn.jiguang.d.a.d.g(context, j * 1000);
        JSONObject optJSONObject = jSONObject.optJSONObject("ips");
        cn.jiguang.d.a.d.c(context, System.currentTimeMillis());
        cn.jiguang.d.a.d.d(context, optJSONObject != null ? optJSONObject.toString() : "");
        a(optJSONObject);
    }

    public final f ah(Context context) {
        try {
            long ad = cn.jiguang.d.a.d.ad(context);
            if (this.a == 0 || this.a != ad) {
                this.a = ad;
                String o = cn.jiguang.d.a.d.o(context);
                if (!TextUtils.isEmpty(o)) {
                    try {
                        a(new JSONObject(o));
                    } catch (JSONException e) {
                    }
                }
            }
        } catch (Throwable th) {
        }
        return this;
    }

    public final f ai(Context context) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            ah(context);
            long f = cn.jiguang.d.a.d.f(context, 3600000L);
            long j = f >= 0 ? f < 60000 ? 60000L : f : 3600000L;
            long j2 = j <= 604800000 ? j : 604800000L;
            cn.jiguang.d.h.c.a("yyyy-MM-dd HH:mm:ss");
            if (this.a == 0 || j2 + this.a < currentTimeMillis) {
                y.a(context, this.b == null || this.b.isEmpty());
            }
        } catch (Throwable th) {
        }
        return this;
    }

    public final String c(Set<String> set) {
        if (set == null || set.isEmpty()) {
            return "normal";
        }
        String str = null;
        for (String str2 : set) {
            String a = a(str2);
            if (str == null) {
                str = a;
            } else if (!str.equals(a)) {
                return "normal";
            }
        }
        return str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    public final Set<String> d(Set<String> set) {
        if (set == null || set.isEmpty()) {
            return this.b.get("normal");
        }
        Set<String> set2 = 0;
        for (String str : set) {
            Set<String> set3 = this.b.get(a(str));
            if (set3 == null || set3.isEmpty()) {
                return this.b.get("normal");
            }
            if (set2 != null) {
                set2.retainAll(set3);
                set3 = set2;
            }
            if (set3.isEmpty()) {
                return this.b.get("normal");
            }
            set2 = set3;
        }
        return set2;
    }
}
