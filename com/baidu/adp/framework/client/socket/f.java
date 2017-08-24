package com.baidu.adp.framework.client.socket;

import com.baidu.adp.lib.util.BdLog;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class f {
    private static f qx = null;
    private int qh = 0;

    public static f da() {
        if (qx == null) {
            synchronized (f.class) {
                if (qx == null) {
                    qx = new f();
                }
            }
        }
        return qx;
    }

    public synchronized void d(Map<String, String> map) {
        if (map != null) {
            try {
                this.qh = Integer.valueOf(map.get("Seq-Id")).intValue();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                i.a("SequenceManager", 0, 0, "setSequenceId", h.rm, "parser Seq-Id error");
                if (this.qh == 0) {
                    this.qh = new Random().nextInt();
                }
            }
        }
    }

    public synchronized int cV() {
        int i;
        if (this.qh == 0) {
            this.qh++;
        }
        i = this.qh;
        this.qh = i + 1;
        return i;
    }
}
