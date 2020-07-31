package com.baidu.live.liveroom.middleware;
/* loaded from: classes4.dex */
public class k {
    private f aYC;

    public static k Fx() {
        return a.aYD;
    }

    private k() {
    }

    public com.baidu.live.liveroom.middleware.a Fy() {
        if (this.aYC == null) {
            throw new RuntimeException("IMasterMiddleWareControllerBuilder must not be null! should invoke MasterMiddleWareControllerManager.init() first~");
        }
        return this.aYC.Fu();
    }

    /* loaded from: classes4.dex */
    public static class a {
        private static final k aYD = new k();
    }
}
