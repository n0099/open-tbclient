package com.baidu.adp.framework.client.socket;

import com.baidu.adp.lib.util.BdLog;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class f {
    private static f ud = null;
    private int tN = 0;

    public static f fC() {
        if (ud == null) {
            synchronized (f.class) {
                if (ud == null) {
                    ud = new f();
                }
            }
        }
        return ud;
    }

    public synchronized void g(Map<String, String> map) {
        if (map != null) {
            try {
                this.tN = Integer.valueOf(map.get("Seq-Id")).intValue();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                i.a("SequenceManager", 0, 0, "setSequenceId", h.uU, "parser Seq-Id error");
                if (this.tN == 0) {
                    this.tN = new Random().nextInt();
                }
            }
        }
    }

    public synchronized int getSequenceId() {
        int i;
        if (this.tN == 0) {
            this.tN++;
        }
        i = this.tN;
        this.tN = i + 1;
        return i;
    }
}
