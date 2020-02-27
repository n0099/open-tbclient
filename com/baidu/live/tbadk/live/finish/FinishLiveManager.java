package com.baidu.live.tbadk.live.finish;
/* loaded from: classes3.dex */
public class FinishLiveManager {
    private IFinishLiveListener mFinishListener;

    public static FinishLiveManager getInstance() {
        return InstanceHolder.sInst;
    }

    public void init(IFinishLiveListener iFinishLiveListener) {
        this.mFinishListener = iFinishLiveListener;
    }

    public IFinishLiveListener getFinishListener() {
        return this.mFinishListener;
    }

    /* loaded from: classes3.dex */
    public static class InstanceHolder {
        private static final FinishLiveManager sInst = new FinishLiveManager();
    }
}
