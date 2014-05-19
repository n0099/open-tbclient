package com.baidu.tbadk.a;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class a {
    private static a a = null;
    private int b = 0;

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
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
                TiebaStatic.imLog(0, 0, "on connected", "SequenceManager: setSequenceId", "Seq-Id = " + map.get("Seq-Id"), 0, (String) null);
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
