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
    private static volatile a Dl = null;
    private HashMap<String, Integer> Dk = new HashMap<>();

    public static synchronized a lh() {
        a aVar;
        synchronized (a.class) {
            if (Dl == null) {
                synchronized (a.class) {
                    if (Dl == null) {
                        Dl = new a();
                    }
                }
            }
            aVar = Dl;
        }
        return aVar;
    }

    public void bd(String str) {
        if (str != null) {
            Integer num = this.Dk.get(str);
            if (num == null) {
                num = 0;
            }
            this.Dk.put(str, Integer.valueOf(num.intValue() + 1));
        }
    }

    public void I(String str, String str2) {
        if (str != null && str2 != null) {
            bd(str);
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
        q hC = hC();
        hC.r("workflow", String.valueOf(str) + "_cost");
        hC.f("cost", Long.valueOf(j));
        if (i != 0) {
            hC.f(ImageViewerConfig.COUNT, Integer.valueOf(i));
        }
        if (str2 != null) {
            hC.r("pname", str2);
        }
        f.hP().a("pluginproxy", hC);
    }

    public void g(String str, String str2, String str3) {
        d(str, str2, str3, null);
    }

    public void d(String str, String str2, String str3, String str4) {
        q hC = hC();
        if (str != null) {
            hC.r("workflow", String.valueOf(str) + "_failure");
        }
        if (str2 != null) {
            hC.r("reason", str2);
        }
        if (str3 != null) {
            hC.r("pname", str3);
        }
        a(hC);
        if (str4 != null) {
            hC.r("comment", str4);
        }
        BdLog.e(hC.toString());
        f.hP().a("pluginproxy", hC);
        f.hP().save();
    }

    public void li() {
        if (this.Dk.size() != 0) {
            q hC = hC();
            a(hC);
            f.hP().a("pluginproxy", hC);
        }
    }

    public void be(String str) {
        f.hP().eventStat(BdBaseApplication.getInst(), str, null, 1, new Object[0]);
    }

    private void a(q qVar) {
        if (qVar != null) {
            for (Map.Entry<String, Integer> entry : this.Dk.entrySet()) {
                qVar.r(String.valueOf(entry.getKey()) + "_count", String.valueOf(entry.getValue()));
            }
            this.Dk.clear();
        }
    }

    private q hC() {
        return f.hP().ar("dbg");
    }
}
