package com.baidu.adp.plugin.b;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.f;
import com.baidu.adp.lib.stats.q;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a {
    private static volatile a Dc = null;
    private HashMap<String, Integer> Db = new HashMap<>();

    public static synchronized a lB() {
        a aVar;
        synchronized (a.class) {
            if (Dc == null) {
                synchronized (a.class) {
                    if (Dc == null) {
                        Dc = new a();
                    }
                }
            }
            aVar = Dc;
        }
        return aVar;
    }

    public void bn(String str) {
        if (str != null) {
            Integer num = this.Db.get(str);
            if (num == null) {
                num = 0;
            }
            this.Db.put(str, Integer.valueOf(num.intValue() + 1));
        }
    }

    public void K(String str, String str2) {
        if (str != null && str2 != null) {
            bn(str);
        }
    }

    public void e(String str, long j) {
        a(str, j, 0);
    }

    public void a(String str, long j, String str2) {
        a(str, j, 0, str2);
    }

    public void a(String str, long j, int i) {
        a(str, j, i, null);
    }

    public void a(String str, long j, int i, String str2) {
        q hm = hm();
        hm.r("workflow", String.valueOf(str) + "_cost");
        hm.f("cost", Long.valueOf(j));
        if (i != 0) {
            hm.f(ImageViewerConfig.COUNT, Integer.valueOf(i));
        }
        if (str2 != null) {
            hm.r("pname", str2);
        }
        f.hz().a("pluginproxy", hm);
    }

    public void g(String str, String str2, String str3) {
        d(str, str2, str3, null);
    }

    public void d(String str, String str2, String str3, String str4) {
        q hm = hm();
        if (str != null) {
            hm.r("workflow", String.valueOf(str) + "_failure");
        }
        if (str2 != null) {
            hm.r("reason", str2);
        }
        if (str3 != null) {
            hm.r("pname", str3);
        }
        a(hm);
        if (str4 != null) {
            hm.r("comment", str4);
        }
        BdLog.e(hm.toString());
        f.hz().a("pluginproxy", hm);
        f.hz().save();
    }

    public void lC() {
        if (this.Db.size() != 0) {
            q hm = hm();
            a(hm);
            f.hz().a("pluginproxy", hm);
        }
    }

    public void bo(String str) {
        f.hz().eventStat(BdBaseApplication.getInst(), str, null, 1, new Object[0]);
    }

    private void a(q qVar) {
        if (qVar != null) {
            for (Map.Entry<String, Integer> entry : this.Db.entrySet()) {
                qVar.r(String.valueOf(entry.getKey()) + "_count", String.valueOf(entry.getValue()));
            }
            this.Db.clear();
        }
    }

    private q hm() {
        return f.hz().as("dbg");
    }
}
