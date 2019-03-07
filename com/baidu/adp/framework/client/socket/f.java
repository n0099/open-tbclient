package com.baidu.adp.framework.client.socket;

import com.baidu.adp.lib.util.BdLog;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class f {
    private static f wx = null;
    private int wh = 0;

    public static f gJ() {
        if (wx == null) {
            synchronized (f.class) {
                if (wx == null) {
                    wx = new f();
                }
            }
        }
        return wx;
    }

    public synchronized void h(Map<String, String> map) {
        if (map != null) {
            try {
                this.wh = Integer.valueOf(map.get("Seq-Id")).intValue();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                i.a("SequenceManager", 0, 0, "setSequenceId", h.xm, "parser Seq-Id error");
                if (this.wh == 0) {
                    this.wh = new Random().nextInt();
                }
            }
        }
    }

    public synchronized int getSequenceId() {
        int i;
        if (this.wh == 0) {
            this.wh++;
        }
        i = this.wh;
        this.wh = i + 1;
        return i;
    }
}
