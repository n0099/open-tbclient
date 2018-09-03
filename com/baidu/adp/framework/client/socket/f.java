package com.baidu.adp.framework.client.socket;

import com.baidu.adp.lib.util.BdLog;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class f {
    private static f tl = null;
    private int sV = 0;

    public static f fl() {
        if (tl == null) {
            synchronized (f.class) {
                if (tl == null) {
                    tl = new f();
                }
            }
        }
        return tl;
    }

    public synchronized void g(Map<String, String> map) {
        if (map != null) {
            try {
                this.sV = Integer.valueOf(map.get("Seq-Id")).intValue();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                i.a("SequenceManager", 0, 0, "setSequenceId", h.uf, "parser Seq-Id error");
                if (this.sV == 0) {
                    this.sV = new Random().nextInt();
                }
            }
        }
    }

    public synchronized int getSequenceId() {
        int i;
        if (this.sV == 0) {
            this.sV++;
        }
        i = this.sV;
        this.sV = i + 1;
        return i;
    }
}
