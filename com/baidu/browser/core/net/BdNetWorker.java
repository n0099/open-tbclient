package com.baidu.browser.core.net;

import com.baidu.browser.core.util.BdLog;
/* loaded from: classes.dex */
public class BdNetWorker {
    private BdNet mNet;
    private BdNetEngine mNetEngine;
    private BdNetTask mNetTask;

    public BdNetWorker(BdNet bdNet) {
        this.mNet = bdNet;
    }

    public void setTask(BdNetTask bdNetTask) {
        this.mNetTask = bdNetTask;
    }

    public void setNetEngine(BdNetEngine bdNetEngine) {
        this.mNetEngine = bdNetEngine;
        this.mNetEngine.setEventListener(this.mNet);
    }

    public boolean isWorking() {
        return this.mNetTask != null;
    }

    public boolean start(BdNetTask bdNetTask) {
        try {
            this.mNetTask = bdNetTask;
            this.mNetTask.setNet(this.mNet);
            this.mNetTask.setWorker(this);
            this.mNetEngine = BdNetManager.getInstance().obtainNetEngine();
            if (this.mNetEngine != null) {
                this.mNetEngine.setEventListener(this.mNet);
                this.mNetEngine.startDownload(this.mNetTask);
            } else {
                BdNetManager.getInstance().addTask(this.mNetTask, this.mNet.getPriority());
            }
            return true;
        } catch (Exception e) {
            BdLog.w("start Exception", e);
            return false;
        }
    }

    public void stop() {
        if (this.mNetTask != null) {
            this.mNetTask.setWorker(null);
            this.mNetTask.stop();
            this.mNetTask = null;
        }
    }
}
