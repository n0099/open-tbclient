package com.baidu.live.liveroom.middleware;
/* loaded from: classes3.dex */
public class k {
    private f aVV;

    public static k EU() {
        return a.aVW;
    }

    private k() {
    }

    public com.baidu.live.liveroom.middleware.a EV() {
        if (this.aVV == null) {
            throw new RuntimeException("IMasterMiddleWareControllerBuilder must not be null! should invoke MasterMiddleWareControllerManager.init() first~");
        }
        return this.aVV.ER();
    }

    /* loaded from: classes3.dex */
    public static class a {
        private static final k aVW = new k();
    }
}
