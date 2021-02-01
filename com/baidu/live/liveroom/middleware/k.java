package com.baidu.live.liveroom.middleware;
/* loaded from: classes11.dex */
public class k {
    private f brw;

    public static k MF() {
        return a.brx;
    }

    private k() {
    }

    public com.baidu.live.liveroom.middleware.a MG() {
        if (this.brw == null) {
            throw new RuntimeException("IMasterMiddleWareControllerBuilder must not be null! should invoke MasterMiddleWareControllerManager.init() first~");
        }
        return this.brw.MC();
    }

    /* loaded from: classes11.dex */
    public static class a {
        private static final k brx = new k();
    }
}
