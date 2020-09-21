package com.baidu.browser.core.async;
/* loaded from: classes10.dex */
public abstract class BdRunnable implements Runnable {

    /* loaded from: classes10.dex */
    public enum STATUS {
        INITED,
        QUEUED,
        RUNNING,
        FAIL,
        COMPLETE
    }
}
