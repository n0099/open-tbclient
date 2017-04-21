package com.baidu.adp.framework.client.socket;

import com.baidu.adp.lib.util.BdLog;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class g {
    private static g oL = null;
    private int ov = 0;

    public static g cP() {
        if (oL == null) {
            synchronized (g.class) {
                if (oL == null) {
                    oL = new g();
                }
            }
        }
        return oL;
    }

    public synchronized void c(Map<String, String> map) {
        if (map != null) {
            try {
                this.ov = Integer.valueOf(map.get("Seq-Id")).intValue();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                k.a("SequenceManager", 0, 0, "setSequenceId", j.pG, "parser Seq-Id error");
                if (this.ov == 0) {
                    this.ov = new Random().nextInt();
                }
            }
        }
    }

    public synchronized int cK() {
        int i;
        if (this.ov == 0) {
            this.ov++;
        }
        i = this.ov;
        this.ov = i + 1;
        return i;
    }
}
