package com.baidu.adp.framework.client.socket;

import com.baidu.adp.lib.util.BdLog;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class i {
    private static i a = null;
    private int b = 0;

    public static i a() {
        if (a == null) {
            synchronized (i.class) {
                if (a == null) {
                    a = new i();
                }
            }
        }
        return a;
    }

    public synchronized void a(Map<String, String> map) {
        if (map != null) {
            try {
                this.b = Integer.valueOf(map.get("Seq-Id")).intValue();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                m.a("SequenceManager", 0, 0, "setSequenceId", l.B, "parser Seq-Id error");
                if (this.b == 0) {
                    this.b = new Random().nextInt();
                }
            }
        }
    }

    public synchronized int b() {
        int i;
        if (this.b == 0) {
            this.b++;
        }
        i = this.b;
        this.b = i + 1;
        return i;
    }
}
