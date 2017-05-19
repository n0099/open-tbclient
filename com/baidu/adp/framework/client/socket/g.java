package com.baidu.adp.framework.client.socket;

import com.baidu.adp.lib.util.BdLog;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class g {
    private static g oM = null;
    private int ow = 0;

    public static g cP() {
        if (oM == null) {
            synchronized (g.class) {
                if (oM == null) {
                    oM = new g();
                }
            }
        }
        return oM;
    }

    public synchronized void c(Map<String, String> map) {
        if (map != null) {
            try {
                this.ow = Integer.valueOf(map.get("Seq-Id")).intValue();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                k.a("SequenceManager", 0, 0, "setSequenceId", j.pH, "parser Seq-Id error");
                if (this.ow == 0) {
                    this.ow = new Random().nextInt();
                }
            }
        }
    }

    public synchronized int cK() {
        int i;
        if (this.ow == 0) {
            this.ow++;
        }
        i = this.ow;
        this.ow = i + 1;
        return i;
    }
}
