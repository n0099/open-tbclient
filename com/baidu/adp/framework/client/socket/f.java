package com.baidu.adp.framework.client.socket;

import com.baidu.adp.lib.util.BdLog;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class f {
    private static f ue = null;
    private int tO = 0;

    public static f fC() {
        if (ue == null) {
            synchronized (f.class) {
                if (ue == null) {
                    ue = new f();
                }
            }
        }
        return ue;
    }

    public synchronized void g(Map<String, String> map) {
        if (map != null) {
            try {
                this.tO = Integer.valueOf(map.get("Seq-Id")).intValue();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                i.a("SequenceManager", 0, 0, "setSequenceId", h.uV, "parser Seq-Id error");
                if (this.tO == 0) {
                    this.tO = new Random().nextInt();
                }
            }
        }
    }

    public synchronized int getSequenceId() {
        int i;
        if (this.tO == 0) {
            this.tO++;
        }
        i = this.tO;
        this.tO = i + 1;
        return i;
    }
}
