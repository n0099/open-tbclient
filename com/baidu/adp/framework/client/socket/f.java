package com.baidu.adp.framework.client.socket;

import com.baidu.adp.lib.util.BdLog;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class f {
    private static f tu = null;
    private int td = 0;

    public static f fm() {
        if (tu == null) {
            synchronized (f.class) {
                if (tu == null) {
                    tu = new f();
                }
            }
        }
        return tu;
    }

    public synchronized void g(Map<String, String> map) {
        if (map != null) {
            try {
                this.td = Integer.valueOf(map.get("Seq-Id")).intValue();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                i.a("SequenceManager", 0, 0, "setSequenceId", h.um, "parser Seq-Id error");
                if (this.td == 0) {
                    this.td = new Random().nextInt();
                }
            }
        }
    }

    public synchronized int getSequenceId() {
        int i;
        if (this.td == 0) {
            this.td++;
        }
        i = this.td;
        this.td = i + 1;
        return i;
    }
}
