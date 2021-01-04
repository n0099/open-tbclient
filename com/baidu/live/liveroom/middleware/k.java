package com.baidu.live.liveroom.middleware;
/* loaded from: classes11.dex */
public class k {
    private f bsH;

    public static k Pc() {
        return a.bsI;
    }

    private k() {
    }

    public com.baidu.live.liveroom.middleware.a Pd() {
        if (this.bsH == null) {
            throw new RuntimeException("IMasterMiddleWareControllerBuilder must not be null! should invoke MasterMiddleWareControllerManager.init() first~");
        }
        return this.bsH.OZ();
    }

    /* loaded from: classes11.dex */
    public static class a {
        private static final k bsI = new k();
    }
}
