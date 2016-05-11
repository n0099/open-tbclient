package com.baidu.adp.framework.client.socket;

import com.baidu.adp.lib.util.BdLog;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class g {
    private static g eG = null;
    private int ep = 0;

    public static g aN() {
        if (eG == null) {
            synchronized (g.class) {
                if (eG == null) {
                    eG = new g();
                }
            }
        }
        return eG;
    }

    public synchronized void b(Map<String, String> map) {
        if (map != null) {
            try {
                this.ep = Integer.valueOf(map.get("Seq-Id")).intValue();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                k.a("SequenceManager", 0, 0, "setSequenceId", j.ft, "parser Seq-Id error");
                if (this.ep == 0) {
                    this.ep = new Random().nextInt();
                }
            }
        }
    }

    public synchronized int aH() {
        int i;
        if (this.ep == 0) {
            this.ep++;
        }
        i = this.ep;
        this.ep = i + 1;
        return i;
    }
}
