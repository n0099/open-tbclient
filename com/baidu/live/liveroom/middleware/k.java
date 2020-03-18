package com.baidu.live.liveroom.middleware;
/* loaded from: classes3.dex */
public class k {
    private f awd;

    public static k yD() {
        return a.awe;
    }

    private k() {
    }

    public com.baidu.live.liveroom.middleware.a yE() {
        if (this.awd == null) {
            throw new RuntimeException("IMasterMiddleWareControllerBuilder must not be null! should invoke MasterMiddleWareControllerManager.init() first~");
        }
        return this.awd.yA();
    }

    /* loaded from: classes3.dex */
    public static class a {
        private static final k awe = new k();
    }
}
