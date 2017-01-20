package com.baidu.adp.framework.client.socket;

import com.baidu.adp.lib.util.BdLog;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class g {
    private static g hs = null;
    private int hb = 0;

    public static g bH() {
        if (hs == null) {
            synchronized (g.class) {
                if (hs == null) {
                    hs = new g();
                }
            }
        }
        return hs;
    }

    public synchronized void c(Map<String, String> map) {
        if (map != null) {
            try {
                this.hb = Integer.valueOf(map.get("Seq-Id")).intValue();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                k.a("SequenceManager", 0, 0, "setSequenceId", j.ig, "parser Seq-Id error");
                if (this.hb == 0) {
                    this.hb = new Random().nextInt();
                }
            }
        }
    }

    public synchronized int bC() {
        int i;
        if (this.hb == 0) {
            this.hb++;
        }
        i = this.hb;
        this.hb = i + 1;
        return i;
    }
}
