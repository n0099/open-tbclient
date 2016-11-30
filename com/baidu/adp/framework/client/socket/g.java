package com.baidu.adp.framework.client.socket;

import com.baidu.adp.lib.util.BdLog;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class g {
    private static g hv = null;
    private int hf = 0;

    public static g bH() {
        if (hv == null) {
            synchronized (g.class) {
                if (hv == null) {
                    hv = new g();
                }
            }
        }
        return hv;
    }

    public synchronized void c(Map<String, String> map) {
        if (map != null) {
            try {
                this.hf = Integer.valueOf(map.get("Seq-Id")).intValue();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                k.a("SequenceManager", 0, 0, "setSequenceId", j.ij, "parser Seq-Id error");
                if (this.hf == 0) {
                    this.hf = new Random().nextInt();
                }
            }
        }
    }

    public synchronized int bC() {
        int i;
        if (this.hf == 0) {
            this.hf++;
        }
        i = this.hf;
        this.hf = i + 1;
        return i;
    }
}
