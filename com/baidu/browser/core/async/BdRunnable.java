package com.baidu.browser.core.async;
/* loaded from: classes6.dex */
public abstract class BdRunnable implements Runnable {

    /* loaded from: classes6.dex */
    public enum STATUS {
        INITED,
        QUEUED,
        RUNNING,
        FAIL,
        COMPLETE
    }
}
