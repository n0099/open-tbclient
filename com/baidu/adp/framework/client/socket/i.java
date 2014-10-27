package com.baidu.adp.framework.client.socket;

import com.baidu.adp.lib.util.BdLog;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class i {
    private static i bi = null;
    private int aU = 0;

    public static i at() {
        if (bi == null) {
            synchronized (i.class) {
                if (bi == null) {
                    bi = new i();
                }
            }
        }
        return bi;
    }

    public synchronized void a(Map<String, String> map) {
        if (map != null) {
            try {
                this.aU = Integer.valueOf(map.get("Seq-Id")).intValue();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                m.a("SequenceManager", 0, 0, "setSequenceId", l.bU, "parser Seq-Id error");
                if (this.aU == 0) {
                    this.aU = new Random().nextInt();
                }
            }
        }
    }

    public synchronized int an() {
        int i;
        if (this.aU == 0) {
            this.aU++;
        }
        i = this.aU;
        this.aU = i + 1;
        return i;
    }
}
