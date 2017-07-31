package com.baidu.adp.framework.client.socket;

import com.baidu.adp.lib.util.BdLog;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class f {
    private static f qu = null;
    private int qe = 0;

    public static f da() {
        if (qu == null) {
            synchronized (f.class) {
                if (qu == null) {
                    qu = new f();
                }
            }
        }
        return qu;
    }

    public synchronized void d(Map<String, String> map) {
        if (map != null) {
            try {
                this.qe = Integer.valueOf(map.get("Seq-Id")).intValue();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                i.a("SequenceManager", 0, 0, "setSequenceId", h.rj, "parser Seq-Id error");
                if (this.qe == 0) {
                    this.qe = new Random().nextInt();
                }
            }
        }
    }

    public synchronized int cV() {
        int i;
        if (this.qe == 0) {
            this.qe++;
        }
        i = this.qe;
        this.qe = i + 1;
        return i;
    }
}
