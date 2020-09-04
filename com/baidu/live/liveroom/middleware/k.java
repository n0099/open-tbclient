package com.baidu.live.liveroom.middleware;
/* loaded from: classes7.dex */
public class k {
    private f bdV;

    public static k Le() {
        return a.bdW;
    }

    private k() {
    }

    public com.baidu.live.liveroom.middleware.a Lf() {
        if (this.bdV == null) {
            throw new RuntimeException("IMasterMiddleWareControllerBuilder must not be null! should invoke MasterMiddleWareControllerManager.init() first~");
        }
        return this.bdV.Lb();
    }

    /* loaded from: classes7.dex */
    public static class a {
        private static final k bdW = new k();
    }
}
