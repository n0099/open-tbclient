package com.baidu.adp.framework.client.socket;

import com.baidu.adp.lib.util.BdLog;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class i {
    private static i dp = null;
    private int db = 0;

    public static i aT() {
        if (dp == null) {
            synchronized (i.class) {
                if (dp == null) {
                    dp = new i();
                }
            }
        }
        return dp;
    }

    public synchronized void b(Map<String, String> map) {
        if (map != null) {
            try {
                this.db = Integer.valueOf(map.get("Seq-Id")).intValue();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                m.a("SequenceManager", 0, 0, "setSequenceId", l.eb, "parser Seq-Id error");
                if (this.db == 0) {
                    this.db = new Random().nextInt();
                }
            }
        }
    }

    public synchronized int aN() {
        int i;
        if (this.db == 0) {
            this.db++;
        }
        i = this.db;
        this.db = i + 1;
        return i;
    }
}
