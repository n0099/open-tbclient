package com.baidu.adp.framework.client.socket;

import com.baidu.adp.lib.util.BdLog;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class f {
    private static f tk = null;
    private int sU = 0;

    public static f fl() {
        if (tk == null) {
            synchronized (f.class) {
                if (tk == null) {
                    tk = new f();
                }
            }
        }
        return tk;
    }

    public synchronized void g(Map<String, String> map) {
        if (map != null) {
            try {
                this.sU = Integer.valueOf(map.get("Seq-Id")).intValue();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                i.a("SequenceManager", 0, 0, "setSequenceId", h.ue, "parser Seq-Id error");
                if (this.sU == 0) {
                    this.sU = new Random().nextInt();
                }
            }
        }
    }

    public synchronized int getSequenceId() {
        int i;
        if (this.sU == 0) {
            this.sU++;
        }
        i = this.sU;
        this.sU = i + 1;
        return i;
    }
}
