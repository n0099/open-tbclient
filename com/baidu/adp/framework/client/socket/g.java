package com.baidu.adp.framework.client.socket;

import com.baidu.adp.lib.util.BdLog;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class g {
    private static g eF = null;
    private int eo = 0;

    public static g aN() {
        if (eF == null) {
            synchronized (g.class) {
                if (eF == null) {
                    eF = new g();
                }
            }
        }
        return eF;
    }

    public synchronized void c(Map<String, String> map) {
        if (map != null) {
            try {
                this.eo = Integer.valueOf(map.get("Seq-Id")).intValue();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                k.a("SequenceManager", 0, 0, "setSequenceId", j.fs, "parser Seq-Id error");
                if (this.eo == 0) {
                    this.eo = new Random().nextInt();
                }
            }
        }
    }

    public synchronized int aH() {
        int i;
        if (this.eo == 0) {
            this.eo++;
        }
        i = this.eo;
        this.eo = i + 1;
        return i;
    }
}
