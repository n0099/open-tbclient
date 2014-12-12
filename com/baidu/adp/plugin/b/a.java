package com.baidu.adp.plugin.b;

import com.baidu.adp.lib.stats.f;
import com.baidu.adp.lib.stats.q;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a {
    private static volatile a sr = null;
    private HashMap<String, Integer> sq = new HashMap<>();

    public static synchronized a hU() {
        a aVar;
        synchronized (a.class) {
            if (sr == null) {
                synchronized (a.class) {
                    if (sr == null) {
                        sr = new a();
                    }
                }
            }
            aVar = sr;
        }
        return aVar;
    }

    public void aZ(String str) {
        if (str != null) {
            Integer num = this.sq.get(str);
            if (num == null) {
                num = 0;
            }
            this.sq.put(str, Integer.valueOf(num.intValue() + 1));
        }
    }

    public void D(String str, String str2) {
        if (str != null && str2 != null) {
            aZ(str);
        }
    }

    public void b(String str, long j) {
        a(str, j, 0);
    }

    public void a(String str, long j, String str2) {
        a(str, j, 0, str2);
    }

    public void a(String str, long j, int i) {
        a(str, j, i, null);
    }

    public void a(String str, long j, int i, String str2) {
        q ef = ef();
        ef.r("workflow", String.valueOf(str) + "_cost");
        ef.f("cost", Long.valueOf(j));
        if (i != 0) {
            ef.f(ImageViewerConfig.COUNT, Integer.valueOf(i));
        }
        if (str2 != null) {
            ef.r("pname", str2);
        }
        f.es().a("pluginproxy", ef);
    }

    public void g(String str, String str2, String str3) {
        c(str, str2, str3, null);
    }

    public void c(String str, String str2, String str3, String str4) {
        q ef = ef();
        if (str != null) {
            ef.r("workflow", String.valueOf(str) + "_failure");
        }
        if (str2 != null) {
            ef.r("reason", str2);
        }
        if (str3 != null) {
            ef.r("pname", str3);
        }
        a(ef);
        if (str4 != null) {
            ef.r("comment", str4);
        }
        f.es().a("pluginproxy", ef);
    }

    public void hV() {
        if (this.sq.size() != 0) {
            q ef = ef();
            a(ef);
            f.es().a("pluginproxy", ef);
        }
    }

    private void a(q qVar) {
        if (qVar != null) {
            for (Map.Entry<String, Integer> entry : this.sq.entrySet()) {
                qVar.r(String.valueOf(entry.getKey()) + "_count", String.valueOf(entry.getValue()));
            }
            this.sq.clear();
        }
    }

    private q ef() {
        return f.es().ak("dbg");
    }
}
