package com.baidu.adp.framework.client.socket;

import com.baidu.adp.lib.util.BdLog;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class f {
    private static f acI = null;
    private int act = 0;

    public static f ku() {
        if (acI == null) {
            synchronized (f.class) {
                if (acI == null) {
                    acI = new f();
                }
            }
        }
        return acI;
    }

    public synchronized void c(Map<String, String> map) {
        if (map != null) {
            try {
                this.act = Integer.valueOf(map.get("Seq-Id")).intValue();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                i.a("SequenceManager", 0, 0, "setSequenceId", h.ady, "parser Seq-Id error");
                if (this.act == 0) {
                    this.act = new Random().nextInt();
                }
            }
        }
    }

    public synchronized int getSequenceId() {
        int i;
        if (this.act == 0) {
            this.act++;
        }
        i = this.act;
        this.act = i + 1;
        return i;
    }
}
