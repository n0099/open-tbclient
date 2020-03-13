package com.baidu.live.liveroom.middleware;
/* loaded from: classes3.dex */
public class k {
    private f avT;

    public static k yy() {
        return a.avU;
    }

    private k() {
    }

    public com.baidu.live.liveroom.middleware.a yz() {
        if (this.avT == null) {
            throw new RuntimeException("IMasterMiddleWareControllerBuilder must not be null! should invoke MasterMiddleWareControllerManager.init() first~");
        }
        return this.avT.yv();
    }

    /* loaded from: classes3.dex */
    public static class a {
        private static final k avU = new k();
    }
}
