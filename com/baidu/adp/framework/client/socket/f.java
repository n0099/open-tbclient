package com.baidu.adp.framework.client.socket;

import com.baidu.adp.lib.util.BdLog;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class f {
    private static f ug = null;
    private int tQ = 0;

    public static f fK() {
        if (ug == null) {
            synchronized (f.class) {
                if (ug == null) {
                    ug = new f();
                }
            }
        }
        return ug;
    }

    public synchronized void g(Map<String, String> map) {
        if (map != null) {
            try {
                this.tQ = Integer.valueOf(map.get("Seq-Id")).intValue();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                i.a("SequenceManager", 0, 0, "setSequenceId", h.uX, "parser Seq-Id error");
                if (this.tQ == 0) {
                    this.tQ = new Random().nextInt();
                }
            }
        }
    }

    public synchronized int fE() {
        int i;
        if (this.tQ == 0) {
            this.tQ++;
        }
        i = this.tQ;
        this.tQ = i + 1;
        return i;
    }
}
