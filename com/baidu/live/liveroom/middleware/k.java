package com.baidu.live.liveroom.middleware;
/* loaded from: classes3.dex */
public class k {
    private f aYE;

    public static k FD() {
        return a.aYF;
    }

    private k() {
    }

    public com.baidu.live.liveroom.middleware.a FE() {
        if (this.aYE == null) {
            throw new RuntimeException("IMasterMiddleWareControllerBuilder must not be null! should invoke MasterMiddleWareControllerManager.init() first~");
        }
        return this.aYE.FA();
    }

    /* loaded from: classes3.dex */
    public static class a {
        private static final k aYF = new k();
    }
}
