package com.baidu.adp.framework.client.socket;

import com.baidu.adp.lib.util.BdLog;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class f {
    private static f og = null;
    private int nQ = 0;

    public static f cQ() {
        if (og == null) {
            synchronized (f.class) {
                if (og == null) {
                    og = new f();
                }
            }
        }
        return og;
    }

    public synchronized void c(Map<String, String> map) {
        if (map != null) {
            try {
                this.nQ = Integer.valueOf(map.get("Seq-Id")).intValue();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                i.a("SequenceManager", 0, 0, "setSequenceId", h.oZ, "parser Seq-Id error");
                if (this.nQ == 0) {
                    this.nQ = new Random().nextInt();
                }
            }
        }
    }

    public synchronized int cK() {
        int i;
        if (this.nQ == 0) {
            this.nQ++;
        }
        i = this.nQ;
        this.nQ = i + 1;
        return i;
    }
}
