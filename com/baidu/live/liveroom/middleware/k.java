package com.baidu.live.liveroom.middleware;
/* loaded from: classes4.dex */
public class k {
    private f bgM;

    public static k LH() {
        return a.bgN;
    }

    private k() {
    }

    public com.baidu.live.liveroom.middleware.a LI() {
        if (this.bgM == null) {
            throw new RuntimeException("IMasterMiddleWareControllerBuilder must not be null! should invoke MasterMiddleWareControllerManager.init() first~");
        }
        return this.bgM.LE();
    }

    /* loaded from: classes4.dex */
    public static class a {
        private static final k bgN = new k();
    }
}
