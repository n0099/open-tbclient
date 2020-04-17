package com.baidu.live.liveroom.middleware;
/* loaded from: classes3.dex */
public class k {
    private f aPG;

    public static k Dx() {
        return a.aPH;
    }

    private k() {
    }

    public com.baidu.live.liveroom.middleware.a Dy() {
        if (this.aPG == null) {
            throw new RuntimeException("IMasterMiddleWareControllerBuilder must not be null! should invoke MasterMiddleWareControllerManager.init() first~");
        }
        return this.aPG.Du();
    }

    /* loaded from: classes3.dex */
    public static class a {
        private static final k aPH = new k();
    }
}
