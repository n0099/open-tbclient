package com.baidu.adp.framework.client.socket;

import com.baidu.adp.lib.util.BdLog;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class f {
    private static f tw = null;
    private int tf = 0;

    public static f fm() {
        if (tw == null) {
            synchronized (f.class) {
                if (tw == null) {
                    tw = new f();
                }
            }
        }
        return tw;
    }

    public synchronized void g(Map<String, String> map) {
        if (map != null) {
            try {
                this.tf = Integer.valueOf(map.get("Seq-Id")).intValue();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                i.a("SequenceManager", 0, 0, "setSequenceId", h.uq, "parser Seq-Id error");
                if (this.tf == 0) {
                    this.tf = new Random().nextInt();
                }
            }
        }
    }

    public synchronized int getSequenceId() {
        int i;
        if (this.tf == 0) {
            this.tf++;
        }
        i = this.tf;
        this.tf = i + 1;
        return i;
    }
}
