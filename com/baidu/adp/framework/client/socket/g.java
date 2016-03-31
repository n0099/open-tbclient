package com.baidu.adp.framework.client.socket;

import com.baidu.adp.lib.util.BdLog;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class g {
    private static g oO = null;
    private int oy = 0;

    public static g ex() {
        if (oO == null) {
            synchronized (g.class) {
                if (oO == null) {
                    oO = new g();
                }
            }
        }
        return oO;
    }

    public synchronized void b(Map<String, String> map) {
        if (map != null) {
            try {
                this.oy = Integer.valueOf(map.get("Seq-Id")).intValue();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                k.a("SequenceManager", 0, 0, "setSequenceId", j.pF, "parser Seq-Id error");
                if (this.oy == 0) {
                    this.oy = new Random().nextInt();
                }
            }
        }
    }

    public synchronized int er() {
        int i;
        if (this.oy == 0) {
            this.oy++;
        }
        i = this.oy;
        this.oy = i + 1;
        return i;
    }
}
