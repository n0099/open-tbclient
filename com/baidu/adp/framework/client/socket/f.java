package com.baidu.adp.framework.client.socket;

import com.baidu.adp.lib.util.BdLog;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class f {
    private static f nT = null;
    private int mSequenceId = 0;

    public static f eW() {
        if (nT == null) {
            synchronized (f.class) {
                if (nT == null) {
                    nT = new f();
                }
            }
        }
        return nT;
    }

    public synchronized void setSequenceId(Map<String, String> map) {
        if (map != null) {
            try {
                this.mSequenceId = Integer.valueOf(map.get("Seq-Id")).intValue();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                i.debug("SequenceManager", 0, 0, "setSequenceId", h.QUEUE_SERVER_INIT_SEQID_ERROR, "parser Seq-Id error");
                if (this.mSequenceId == 0) {
                    this.mSequenceId = new Random().nextInt();
                }
            }
        }
    }

    public synchronized int getSequenceId() {
        int i;
        if (this.mSequenceId == 0) {
            this.mSequenceId++;
        }
        i = this.mSequenceId;
        this.mSequenceId = i + 1;
        return i;
    }
}
