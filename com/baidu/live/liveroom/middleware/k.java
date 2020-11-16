package com.baidu.live.liveroom.middleware;
/* loaded from: classes4.dex */
public class k {
    private f blG;

    public static k MW() {
        return a.blH;
    }

    private k() {
    }

    public com.baidu.live.liveroom.middleware.a MX() {
        if (this.blG == null) {
            throw new RuntimeException("IMasterMiddleWareControllerBuilder must not be null! should invoke MasterMiddleWareControllerManager.init() first~");
        }
        return this.blG.MT();
    }

    /* loaded from: classes4.dex */
    public static class a {
        private static final k blH = new k();
    }
}
