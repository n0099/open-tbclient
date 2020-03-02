package com.baidu.live.alphavideo;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.data.ap;
/* loaded from: classes3.dex */
public class a {
    private boolean VC;

    public static a pv() {
        return C0080a.VD;
    }

    public boolean pw() {
        ap apVar = com.baidu.live.v.a.zl().axC;
        return this.VC && apVar != null && apVar.acV != null && apVar.acV.aeE;
    }

    private a() {
        this.VC = MessageManager.getInstance().findTask(2913180) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.alphavideo.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0080a {
        private static a VD = new a();
    }
}
