package com.baidu.adp.framework.client.socket;

import com.baidu.adp.lib.util.BdLog;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class g {
    private static g fh = null;
    private int eR = 0;

    public static g aM() {
        if (fh == null) {
            synchronized (g.class) {
                if (fh == null) {
                    fh = new g();
                }
            }
        }
        return fh;
    }

    public synchronized void c(Map<String, String> map) {
        if (map != null) {
            try {
                this.eR = Integer.valueOf(map.get("Seq-Id")).intValue();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                k.a("SequenceManager", 0, 0, "setSequenceId", j.fU, "parser Seq-Id error");
                if (this.eR == 0) {
                    this.eR = new Random().nextInt();
                }
            }
        }
    }

    public synchronized int aH() {
        int i;
        if (this.eR == 0) {
            this.eR++;
        }
        i = this.eR;
        this.eR = i + 1;
        return i;
    }
}
