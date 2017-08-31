package com.baidu.adp.framework.client.socket;

import com.baidu.adp.lib.util.BdLog;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class f {
    private static f oe = null;
    private int nO = 0;

    public static f cQ() {
        if (oe == null) {
            synchronized (f.class) {
                if (oe == null) {
                    oe = new f();
                }
            }
        }
        return oe;
    }

    public synchronized void c(Map<String, String> map) {
        if (map != null) {
            try {
                this.nO = Integer.valueOf(map.get("Seq-Id")).intValue();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                i.a("SequenceManager", 0, 0, "setSequenceId", h.oX, "parser Seq-Id error");
                if (this.nO == 0) {
                    this.nO = new Random().nextInt();
                }
            }
        }
    }

    public synchronized int cK() {
        int i;
        if (this.nO == 0) {
            this.nO++;
        }
        i = this.nO;
        this.nO = i + 1;
        return i;
    }
}
