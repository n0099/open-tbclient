package com.baidu.adp.framework.client.socket;

import com.baidu.adp.lib.util.BdLog;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class g {
    private static g oJ = null;
    private int ov = 0;

    public static g et() {
        if (oJ == null) {
            synchronized (g.class) {
                if (oJ == null) {
                    oJ = new g();
                }
            }
        }
        return oJ;
    }

    public synchronized void a(Map<String, String> map) {
        if (map != null) {
            try {
                this.ov = Integer.valueOf(map.get("Seq-Id")).intValue();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                k.a("SequenceManager", 0, 0, "setSequenceId", j.pA, "parser Seq-Id error");
                if (this.ov == 0) {
                    this.ov = new Random().nextInt();
                }
            }
        }
    }

    public synchronized int en() {
        int i;
        if (this.ov == 0) {
            this.ov++;
        }
        i = this.ov;
        this.ov = i + 1;
        return i;
    }
}
