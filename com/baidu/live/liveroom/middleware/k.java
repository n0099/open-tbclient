package com.baidu.live.liveroom.middleware;
/* loaded from: classes3.dex */
public class k {
    private f aPM;

    public static k Dw() {
        return a.aPN;
    }

    private k() {
    }

    public com.baidu.live.liveroom.middleware.a Dx() {
        if (this.aPM == null) {
            throw new RuntimeException("IMasterMiddleWareControllerBuilder must not be null! should invoke MasterMiddleWareControllerManager.init() first~");
        }
        return this.aPM.Dt();
    }

    /* loaded from: classes3.dex */
    public static class a {
        private static final k aPN = new k();
    }
}
