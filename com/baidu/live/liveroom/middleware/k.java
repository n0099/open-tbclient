package com.baidu.live.liveroom.middleware;
/* loaded from: classes4.dex */
public class k {
    private f bkC;

    public static k ML() {
        return a.bkD;
    }

    private k() {
    }

    public com.baidu.live.liveroom.middleware.a MM() {
        if (this.bkC == null) {
            throw new RuntimeException("IMasterMiddleWareControllerBuilder must not be null! should invoke MasterMiddleWareControllerManager.init() first~");
        }
        return this.bkC.MI();
    }

    /* loaded from: classes4.dex */
    public static class a {
        private static final k bkD = new k();
    }
}
