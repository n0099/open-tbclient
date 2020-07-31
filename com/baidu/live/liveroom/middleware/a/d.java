package com.baidu.live.liveroom.middleware.a;
/* loaded from: classes4.dex */
public class d {
    private c aYE;

    public static d FB() {
        return a.aYF;
    }

    private d() {
    }

    public com.baidu.live.liveroom.middleware.a.a FC() {
        if (this.aYE == null) {
            throw new RuntimeException("IMasterEndViewControllerBuilder must not be null! should invoke MasterEndViewControllerManager.init() first~");
        }
        return this.aYE.FA();
    }

    /* loaded from: classes4.dex */
    public static class a {
        private static final d aYF = new d();
    }
}
