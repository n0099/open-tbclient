package com.baidu.live.liveroom.middleware;
/* loaded from: classes4.dex */
public class k {
    private f blX;

    public static k Nf() {
        return a.blY;
    }

    private k() {
    }

    public com.baidu.live.liveroom.middleware.a Ng() {
        if (this.blX == null) {
            throw new RuntimeException("IMasterMiddleWareControllerBuilder must not be null! should invoke MasterMiddleWareControllerManager.init() first~");
        }
        return this.blX.Nc();
    }

    /* loaded from: classes4.dex */
    public static class a {
        private static final k blY = new k();
    }
}
