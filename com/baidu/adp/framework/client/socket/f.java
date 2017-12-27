package com.baidu.adp.framework.client.socket;

import com.baidu.adp.lib.util.BdLog;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class f {
    private static f acQ = null;
    private int acB = 0;

    public static f ku() {
        if (acQ == null) {
            synchronized (f.class) {
                if (acQ == null) {
                    acQ = new f();
                }
            }
        }
        return acQ;
    }

    public synchronized void c(Map<String, String> map) {
        if (map != null) {
            try {
                this.acB = Integer.valueOf(map.get("Seq-Id")).intValue();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                i.a("SequenceManager", 0, 0, "setSequenceId", h.adG, "parser Seq-Id error");
                if (this.acB == 0) {
                    this.acB = new Random().nextInt();
                }
            }
        }
    }

    public synchronized int getSequenceId() {
        int i;
        if (this.acB == 0) {
            this.acB++;
        }
        i = this.acB;
        this.acB = i + 1;
        return i;
    }
}
