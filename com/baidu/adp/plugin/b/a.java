package com.baidu.adp.plugin.b;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.f;
import com.baidu.adp.lib.stats.q;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a {
    private static volatile a sA = null;
    private HashMap<String, Integer> sz = new HashMap<>();

    public static synchronized a hU() {
        a aVar;
        synchronized (a.class) {
            if (sA == null) {
                synchronized (a.class) {
                    if (sA == null) {
                        sA = new a();
                    }
                }
            }
            aVar = sA;
        }
        return aVar;
    }

    public void aY(String str) {
        if (str != null) {
            Integer num = this.sz.get(str);
            if (num == null) {
                num = 0;
            }
            this.sz.put(str, Integer.valueOf(num.intValue() + 1));
        }
    }

    public void H(String str, String str2) {
        if (str != null && str2 != null) {
            aY(str);
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
        q ed = ed();
        ed.r("workflow", String.valueOf(str) + "_cost");
        ed.f("cost", Long.valueOf(j));
        if (i != 0) {
            ed.f(ImageViewerConfig.COUNT, Integer.valueOf(i));
        }
        if (str2 != null) {
            ed.r("pname", str2);
        }
        f.eq().a("pluginproxy", ed);
    }

    public void g(String str, String str2, String str3) {
        d(str, str2, str3, null);
    }

    public void d(String str, String str2, String str3, String str4) {
        q ed = ed();
        if (str != null) {
            ed.r("workflow", String.valueOf(str) + "_failure");
        }
        if (str2 != null) {
            ed.r("reason", str2);
        }
        if (str3 != null) {
            ed.r("pname", str3);
        }
        a(ed);
        if (str4 != null) {
            ed.r("comment", str4);
        }
        f.eq().a("pluginproxy", ed);
        f.eq().save();
    }

    public void hV() {
        if (this.sz.size() != 0) {
            q ed = ed();
            a(ed);
            f.eq().a("pluginproxy", ed);
        }
    }

    public void aZ(String str) {
        f.eq().eventStat(BdBaseApplication.getInst(), str, null, 1, new Object[0]);
    }

    private void a(q qVar) {
        if (qVar != null) {
            for (Map.Entry<String, Integer> entry : this.sz.entrySet()) {
                qVar.r(String.valueOf(entry.getKey()) + "_count", String.valueOf(entry.getValue()));
            }
            this.sz.clear();
        }
    }

    private q ed() {
        return f.eq().ak("dbg");
    }
}
