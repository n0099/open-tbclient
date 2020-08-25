package com.baidu.live.liveroom.middleware;
/* loaded from: classes7.dex */
public class k {
    private f bdT;

    public static k Le() {
        return a.bdU;
    }

    private k() {
    }

    public com.baidu.live.liveroom.middleware.a Lf() {
        if (this.bdT == null) {
            throw new RuntimeException("IMasterMiddleWareControllerBuilder must not be null! should invoke MasterMiddleWareControllerManager.init() first~");
        }
        return this.bdT.Lb();
    }

    /* loaded from: classes7.dex */
    public static class a {
        private static final k bdU = new k();
    }
}
