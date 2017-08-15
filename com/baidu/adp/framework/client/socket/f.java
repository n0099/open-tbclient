package com.baidu.adp.framework.client.socket;

import com.baidu.adp.lib.util.BdLog;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class f {
    private static f qw = null;
    private int qg = 0;

    public static f da() {
        if (qw == null) {
            synchronized (f.class) {
                if (qw == null) {
                    qw = new f();
                }
            }
        }
        return qw;
    }

    public synchronized void d(Map<String, String> map) {
        if (map != null) {
            try {
                this.qg = Integer.valueOf(map.get("Seq-Id")).intValue();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                i.a("SequenceManager", 0, 0, "setSequenceId", h.rl, "parser Seq-Id error");
                if (this.qg == 0) {
                    this.qg = new Random().nextInt();
                }
            }
        }
    }

    public synchronized int cV() {
        int i;
        if (this.qg == 0) {
            this.qg++;
        }
        i = this.qg;
        this.qg = i + 1;
        return i;
    }
}
