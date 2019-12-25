package com.baidu.live.tbadk.coreextra.websocketbase;

import android.os.Handler;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.message.BackgroundSwitchMessage;
/* loaded from: classes2.dex */
public class PingManager extends Handler {
    private static final int MIN_INTERVAL = 180000;
    private static final String MODULE_NAME = "PingManager";
    private static final int PING = 1;
    private static PingManager sInstance = null;
    private long mLastPingTime = 0;
    private int mForegroundInterval = MIN_INTERVAL;
    private int mBackgroundInterval = 900000;
    private int mCurrentInterval = this.mBackgroundInterval;

    public static PingManager getInstance() {
        if (sInstance == null) {
            synchronized (PingManager.class) {
                if (sInstance == null) {
                    sInstance = new PingManager();
                }
            }
        }
        return sInstance;
    }

    public void initial() {
        setInterval();
    }

    private void backGroundSwitch(BackgroundSwitchMessage backgroundSwitchMessage) {
        if (backgroundSwitchMessage != null) {
            if (backgroundSwitchMessage.getData().booleanValue()) {
                this.mCurrentInterval = this.mBackgroundInterval;
            } else {
                this.mCurrentInterval = this.mForegroundInterval;
            }
        }
    }

    public void setInterval() {
        int[] socketHeartBeatStratgy = TbadkCoreApplication.getInst().getSocketHeartBeatStratgy();
        if (socketHeartBeatStratgy.length == 2) {
            this.mForegroundInterval = socketHeartBeatStratgy[0] * 1000;
            this.mBackgroundInterval = socketHeartBeatStratgy[1] * 1000;
            if (this.mForegroundInterval < MIN_INTERVAL) {
                this.mForegroundInterval = MIN_INTERVAL;
            }
            if (this.mBackgroundInterval < MIN_INTERVAL) {
                this.mBackgroundInterval = MIN_INTERVAL;
            }
        }
    }

    public int getForegroundInterval() {
        return this.mForegroundInterval;
    }
}
