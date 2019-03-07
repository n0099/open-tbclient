package cn.jiguang.d.b.a;

import android.text.TextUtils;
import cn.jiguang.d.b.j;
import cn.jiguang.d.c.p;
import com.xiaomi.mipush.sdk.Constants;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public final class a {
    private LinkedHashMap<c, String> lc = new LinkedHashMap<>();

    public static a I(String str) {
        String[] split;
        int i;
        a aVar = new a();
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                if (!TextUtils.isEmpty(str2)) {
                    String[] split2 = str2.split(":");
                    if (split2.length > 2) {
                        try {
                            i = Integer.decode(split2[1]).intValue();
                        } catch (Exception e) {
                            i = 0;
                        }
                        aVar.a(split2[0], i, split2[2]);
                    }
                }
            }
        }
        return aVar;
    }

    public static a a(j jVar) {
        a aVar = new a();
        if (jVar == null) {
            return aVar;
        }
        for (String str : jVar.f()) {
            c a = c.a(str);
            if (a != null) {
                aVar.a(a.a, a.b, "default");
            }
        }
        return aVar;
    }

    public static a b(j jVar) {
        a aVar = new a();
        if (jVar == null) {
            return aVar;
        }
        aVar.a(jVar.a(), jVar.b(), "main");
        List<String> c = jVar.c();
        List<Integer> d = jVar.d();
        if (c == null || d == null) {
            return aVar;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= c.size() || i2 >= d.size()) {
                break;
            }
            aVar.a(c.get(i2), d.get(i2).intValue(), "option" + i2);
            i = i2 + 1;
        }
        return aVar;
    }

    public static a b(List<p> list, boolean z) {
        InetAddress inetAddress;
        a aVar = new a();
        if (list == null || list.isEmpty()) {
            return aVar;
        }
        for (p pVar : list) {
            String jVar = pVar.i().toString();
            if (!TextUtils.isEmpty(jVar) && jVar.endsWith(".")) {
                jVar = jVar.substring(0, jVar.length() - 1);
            }
            if (z) {
                try {
                    inetAddress = cn.jiguang.d.d.g.M(jVar);
                } catch (Exception e) {
                    inetAddress = null;
                }
                if (inetAddress != null) {
                    jVar = inetAddress.getHostAddress();
                }
            }
            aVar.a(jVar, pVar.h(), "srv record");
        }
        return aVar;
    }

    public final void a(String str, int i, String str2) {
        if (c.a(str, i)) {
            this.lc.put(new c(str, i), str2);
        }
    }

    public final boolean a() {
        return this.lc == null || this.lc.isEmpty();
    }

    public final boolean a(c cVar) {
        return this.lc.containsKey(cVar);
    }

    public final Iterator<Map.Entry<c, String>> b() {
        return this.lc.entrySet().iterator();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return this.lc != null ? this.lc.equals(aVar.lc) : aVar.lc == null;
    }

    public final int hashCode() {
        if (this.lc != null) {
            return this.lc.hashCode();
        }
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.lc != null) {
            for (Map.Entry<c, String> entry : this.lc.entrySet()) {
                sb.append(entry.getKey().toString()).append(":").append(entry.getValue()).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            }
            if (!this.lc.isEmpty()) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }
}
