package com.baidu.adp.framework.client.socket;

import com.baidu.adp.lib.util.BdLog;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class g {
    private static g pr = null;
    private int oW = 0;

    public static g cQ() {
        if (pr == null) {
            synchronized (g.class) {
                if (pr == null) {
                    pr = new g();
                }
            }
        }
        return pr;
    }

    public synchronized void c(Map<String, String> map) {
        if (map != null) {
            try {
                this.oW = Integer.valueOf(map.get("Seq-Id")).intValue();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                k.a("SequenceManager", 0, 0, "setSequenceId", j.qf, "parser Seq-Id error");
                if (this.oW == 0) {
                    this.oW = new Random().nextInt();
                }
            }
        }
    }

    public synchronized int cL() {
        int i;
        if (this.oW == 0) {
            this.oW++;
        }
        i = this.oW;
        this.oW = i + 1;
        return i;
    }
}
