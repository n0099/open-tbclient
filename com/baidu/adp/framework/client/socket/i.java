package com.baidu.adp.framework.client.socket;

import com.baidu.adp.lib.util.BdLog;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class i {
    private static i dn = null;
    private int da = 0;

    public static i aT() {
        if (dn == null) {
            synchronized (i.class) {
                if (dn == null) {
                    dn = new i();
                }
            }
        }
        return dn;
    }

    public synchronized void b(Map<String, String> map) {
        if (map != null) {
            try {
                this.da = Integer.valueOf(map.get("Seq-Id")).intValue();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                m.a("SequenceManager", 0, 0, "setSequenceId", l.ea, "parser Seq-Id error");
                if (this.da == 0) {
                    this.da = new Random().nextInt();
                }
            }
        }
    }

    public synchronized int aN() {
        int i;
        if (this.da == 0) {
            this.da++;
        }
        i = this.da;
        this.da = i + 1;
        return i;
    }
}
