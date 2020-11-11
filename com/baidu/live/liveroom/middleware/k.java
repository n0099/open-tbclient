package com.baidu.live.liveroom.middleware;
/* loaded from: classes4.dex */
public class k {
    private f bnr;

    public static k NF() {
        return a.bns;
    }

    private k() {
    }

    public com.baidu.live.liveroom.middleware.a NG() {
        if (this.bnr == null) {
            throw new RuntimeException("IMasterMiddleWareControllerBuilder must not be null! should invoke MasterMiddleWareControllerManager.init() first~");
        }
        return this.bnr.NC();
    }

    /* loaded from: classes4.dex */
    public static class a {
        private static final k bns = new k();
    }
}
