package com.baidu.browser.core.async;
/* loaded from: classes4.dex */
public abstract class BdRunnable implements Runnable {

    /* loaded from: classes4.dex */
    public enum STATUS {
        INITED,
        QUEUED,
        RUNNING,
        FAIL,
        COMPLETE
    }
}
