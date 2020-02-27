package com.baidu.browser.core.async;
/* loaded from: classes11.dex */
public abstract class BdRunnable implements Runnable {

    /* loaded from: classes11.dex */
    public enum STATUS {
        INITED,
        QUEUED,
        RUNNING,
        FAIL,
        COMPLETE
    }
}
