package com.baidu.adp.framework.client.socket;

import com.baidu.adp.lib.util.BdLog;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class f {
    private static f acO = null;
    private int acz = 0;

    public static f ku() {
        if (acO == null) {
            synchronized (f.class) {
                if (acO == null) {
                    acO = new f();
                }
            }
        }
        return acO;
    }

    public synchronized void c(Map<String, String> map) {
        if (map != null) {
            try {
                this.acz = Integer.valueOf(map.get("Seq-Id")).intValue();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                i.a("SequenceManager", 0, 0, "setSequenceId", h.adE, "parser Seq-Id error");
                if (this.acz == 0) {
                    this.acz = new Random().nextInt();
                }
            }
        }
    }

    public synchronized int getSequenceId() {
        int i;
        if (this.acz == 0) {
            this.acz++;
        }
        i = this.acz;
        this.acz = i + 1;
        return i;
    }
}
