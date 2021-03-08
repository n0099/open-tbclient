package com.baidu.browser.core.async;
/* loaded from: classes14.dex */
public abstract class BdRunnable implements Runnable {

    /* loaded from: classes14.dex */
    public enum STATUS {
        INITED,
        QUEUED,
        RUNNING,
        FAIL,
        COMPLETE
    }
}
