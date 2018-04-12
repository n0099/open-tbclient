package com.baidu.adp.framework.client.socket;

import com.baidu.adp.lib.util.BdLog;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class f {
    private static f nb = null;
    private int mJ = 0;

    public static f cy() {
        if (nb == null) {
            synchronized (f.class) {
                if (nb == null) {
                    nb = new f();
                }
            }
        }
        return nb;
    }

    public synchronized void c(Map<String, String> map) {
        if (map != null) {
            try {
                this.mJ = Integer.valueOf(map.get("Seq-Id")).intValue();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                i.a("SequenceManager", 0, 0, "setSequenceId", h.nR, "parser Seq-Id error");
                if (this.mJ == 0) {
                    this.mJ = new Random().nextInt();
                }
            }
        }
    }

    public synchronized int getSequenceId() {
        int i;
        if (this.mJ == 0) {
            this.mJ++;
        }
        i = this.mJ;
        this.mJ = i + 1;
        return i;
    }
}
