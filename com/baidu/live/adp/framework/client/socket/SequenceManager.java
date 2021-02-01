package com.baidu.live.adp.framework.client.socket;

import com.baidu.live.adp.lib.util.BdLog;
import java.util.Map;
import java.util.Random;
/* loaded from: classes11.dex */
public class SequenceManager {
    private static final String MODULE_NAME = "SequenceManager";
    private static volatile SequenceManager sInstance = null;
    private int mSequenceId = 0;

    public static SequenceManager getInstance() {
        if (sInstance == null) {
            synchronized (SequenceManager.class) {
                if (sInstance == null) {
                    sInstance = new SequenceManager();
                }
            }
        }
        return sInstance;
    }

    public synchronized void setSequenceId(Map<String, String> map) {
        if (map != null) {
            try {
                this.mSequenceId = Integer.valueOf(map.get("Seq-Id")).intValue();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                SocketLog.debug(MODULE_NAME, 0, 0, "setSequenceId", SocketConfig.QUEUE_SERVER_INIT_SEQID_ERROR, "parser Seq-Id error");
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
