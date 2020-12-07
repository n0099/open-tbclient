package com.baidu.live.liveroom.middleware;
/* loaded from: classes4.dex */
public class k {
    private f bqN;

    public static k Po() {
        return a.bqO;
    }

    private k() {
    }

    public com.baidu.live.liveroom.middleware.a Pp() {
        if (this.bqN == null) {
            throw new RuntimeException("IMasterMiddleWareControllerBuilder must not be null! should invoke MasterMiddleWareControllerManager.init() first~");
        }
        return this.bqN.Pl();
    }

    /* loaded from: classes4.dex */
    public static class a {
        private static final k bqO = new k();
    }
}
