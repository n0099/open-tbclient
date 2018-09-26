package com.baidu.adp.framework.client.socket;

import com.baidu.adp.lib.util.BdLog;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class f {
    private static f vK = null;
    private int vv = 0;

    public static f gu() {
        if (vK == null) {
            synchronized (f.class) {
                if (vK == null) {
                    vK = new f();
                }
            }
        }
        return vK;
    }

    public synchronized void h(Map<String, String> map) {
        if (map != null) {
            try {
                this.vv = Integer.valueOf(map.get("Seq-Id")).intValue();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                i.a("SequenceManager", 0, 0, "setSequenceId", h.wA, "parser Seq-Id error");
                if (this.vv == 0) {
                    this.vv = new Random().nextInt();
                }
            }
        }
    }

    public synchronized int getSequenceId() {
        int i;
        if (this.vv == 0) {
            this.vv++;
        }
        i = this.vv;
        this.vv = i + 1;
        return i;
    }
}
