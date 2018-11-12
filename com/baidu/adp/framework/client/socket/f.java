package com.baidu.adp.framework.client.socket;

import com.baidu.adp.lib.util.BdLog;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class f {
    private static f wA = null;
    private int wl = 0;

    public static f gM() {
        if (wA == null) {
            synchronized (f.class) {
                if (wA == null) {
                    wA = new f();
                }
            }
        }
        return wA;
    }

    public synchronized void h(Map<String, String> map) {
        if (map != null) {
            try {
                this.wl = Integer.valueOf(map.get("Seq-Id")).intValue();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                i.a("SequenceManager", 0, 0, "setSequenceId", h.xp, "parser Seq-Id error");
                if (this.wl == 0) {
                    this.wl = new Random().nextInt();
                }
            }
        }
    }

    public synchronized int getSequenceId() {
        int i;
        if (this.wl == 0) {
            this.wl++;
        }
        i = this.wl;
        this.wl = i + 1;
        return i;
    }
}
