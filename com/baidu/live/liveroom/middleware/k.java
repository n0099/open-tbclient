package com.baidu.live.liveroom.middleware;
/* loaded from: classes10.dex */
public class k {
    private f bnV;

    public static k Lh() {
        return a.bnW;
    }

    private k() {
    }

    public com.baidu.live.liveroom.middleware.a Li() {
        if (this.bnV == null) {
            throw new RuntimeException("IMasterMiddleWareControllerBuilder must not be null! should invoke MasterMiddleWareControllerManager.init() first~");
        }
        return this.bnV.Le();
    }

    /* loaded from: classes10.dex */
    public static class a {
        private static final k bnW = new k();
    }
}
