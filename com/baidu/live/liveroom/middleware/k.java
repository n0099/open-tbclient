package com.baidu.live.liveroom.middleware;
/* loaded from: classes10.dex */
public class k {
    private f bsW;

    public static k MI() {
        return a.bsX;
    }

    private k() {
    }

    public com.baidu.live.liveroom.middleware.a MJ() {
        if (this.bsW == null) {
            throw new RuntimeException("IMasterMiddleWareControllerBuilder must not be null! should invoke MasterMiddleWareControllerManager.init() first~");
        }
        return this.bsW.MF();
    }

    /* loaded from: classes10.dex */
    public static class a {
        private static final k bsX = new k();
    }
}
