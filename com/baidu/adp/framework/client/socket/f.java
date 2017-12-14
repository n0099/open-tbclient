package com.baidu.adp.framework.client.socket;

import com.baidu.adp.lib.util.BdLog;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class f {
    private static f of = null;
    private int nP = 0;

    public static f cQ() {
        if (of == null) {
            synchronized (f.class) {
                if (of == null) {
                    of = new f();
                }
            }
        }
        return of;
    }

    public synchronized void c(Map<String, String> map) {
        if (map != null) {
            try {
                this.nP = Integer.valueOf(map.get("Seq-Id")).intValue();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                i.a("SequenceManager", 0, 0, "setSequenceId", h.oY, "parser Seq-Id error");
                if (this.nP == 0) {
                    this.nP = new Random().nextInt();
                }
            }
        }
    }

    public synchronized int cK() {
        int i;
        if (this.nP == 0) {
            this.nP++;
        }
        i = this.nP;
        this.nP = i + 1;
        return i;
    }
}
