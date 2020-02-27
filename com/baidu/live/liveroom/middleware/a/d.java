package com.baidu.live.liveroom.middleware.a;
/* loaded from: classes3.dex */
public class d {
    private c avU;

    public static d yC() {
        return a.avV;
    }

    private d() {
    }

    public com.baidu.live.liveroom.middleware.a.a yD() {
        if (this.avU == null) {
            throw new RuntimeException("IMasterEndViewControllerBuilder must not be null! should invoke MasterEndViewControllerManager.init() first~");
        }
        return this.avU.yB();
    }

    /* loaded from: classes3.dex */
    public static class a {
        private static final d avV = new d();
    }
}
