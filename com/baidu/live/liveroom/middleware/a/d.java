package com.baidu.live.liveroom.middleware.a;
/* loaded from: classes3.dex */
public class d {
    private c avV;

    public static d yC() {
        return a.avW;
    }

    private d() {
    }

    public com.baidu.live.liveroom.middleware.a.a yD() {
        if (this.avV == null) {
            throw new RuntimeException("IMasterEndViewControllerBuilder must not be null! should invoke MasterEndViewControllerManager.init() first~");
        }
        return this.avV.yB();
    }

    /* loaded from: classes3.dex */
    public static class a {
        private static final d avW = new d();
    }
}
