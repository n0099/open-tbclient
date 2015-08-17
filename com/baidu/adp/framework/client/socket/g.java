package com.baidu.adp.framework.client.socket;

import com.baidu.adp.lib.util.BdLog;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class g {
    private static g oI = null;
    private int ou = 0;

    public static g eu() {
        if (oI == null) {
            synchronized (g.class) {
                if (oI == null) {
                    oI = new g();
                }
            }
        }
        return oI;
    }

    public synchronized void a(Map<String, String> map) {
        if (map != null) {
            try {
                this.ou = Integer.valueOf(map.get("Seq-Id")).intValue();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                k.a("SequenceManager", 0, 0, "setSequenceId", j.pz, "parser Seq-Id error");
                if (this.ou == 0) {
                    this.ou = new Random().nextInt();
                }
            }
        }
    }

    public synchronized int eo() {
        int i;
        if (this.ou == 0) {
            this.ou++;
        }
        i = this.ou;
        this.ou = i + 1;
        return i;
    }
}
