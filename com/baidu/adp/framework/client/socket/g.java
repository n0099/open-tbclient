package com.baidu.adp.framework.client.socket;

import com.baidu.adp.lib.util.BdLog;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class g {
    private static g hu = null;
    private int hd = 0;

    public static g bH() {
        if (hu == null) {
            synchronized (g.class) {
                if (hu == null) {
                    hu = new g();
                }
            }
        }
        return hu;
    }

    public synchronized void c(Map<String, String> map) {
        if (map != null) {
            try {
                this.hd = Integer.valueOf(map.get("Seq-Id")).intValue();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                k.a("SequenceManager", 0, 0, "setSequenceId", j.ii, "parser Seq-Id error");
                if (this.hd == 0) {
                    this.hd = new Random().nextInt();
                }
            }
        }
    }

    public synchronized int bC() {
        int i;
        if (this.hd == 0) {
            this.hd++;
        }
        i = this.hd;
        this.hd = i + 1;
        return i;
    }
}
