package com.baidu.adp.framework.client.socket;

import com.baidu.adp.lib.util.BdLog;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class i {
    private static i oI = null;
    private int ou = 0;

    public static i et() {
        if (oI == null) {
            synchronized (i.class) {
                if (oI == null) {
                    oI = new i();
                }
            }
        }
        return oI;
    }

    public synchronized void b(Map<String, String> map) {
        if (map != null) {
            try {
                this.ou = Integer.valueOf(map.get("Seq-Id")).intValue();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                m.a("SequenceManager", 0, 0, "setSequenceId", l.pz, "parser Seq-Id error");
                if (this.ou == 0) {
                    this.ou = new Random().nextInt();
                }
            }
        }
    }

    public synchronized int en() {
        int i;
        if (this.ou == 0) {
            this.ou++;
        }
        i = this.ou;
        this.ou = i + 1;
        return i;
    }
}
