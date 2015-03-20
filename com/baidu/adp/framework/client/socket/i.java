package com.baidu.adp.framework.client.socket;

import com.baidu.adp.lib.util.BdLog;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class i {
    private static i oD = null;
    private int oo = 0;

    public static i eq() {
        if (oD == null) {
            synchronized (i.class) {
                if (oD == null) {
                    oD = new i();
                }
            }
        }
        return oD;
    }

    public synchronized void b(Map<String, String> map) {
        if (map != null) {
            try {
                this.oo = Integer.valueOf(map.get("Seq-Id")).intValue();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                m.a("SequenceManager", 0, 0, "setSequenceId", l.pu, "parser Seq-Id error");
                if (this.oo == 0) {
                    this.oo = new Random().nextInt();
                }
            }
        }
    }

    public synchronized int ek() {
        int i;
        if (this.oo == 0) {
            this.oo++;
        }
        i = this.oo;
        this.oo = i + 1;
        return i;
    }
}
