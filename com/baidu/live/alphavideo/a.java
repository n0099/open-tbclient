package com.baidu.live.alphavideo;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.data.ap;
/* loaded from: classes3.dex */
public class a {
    private boolean VM;

    public static a pA() {
        return C0080a.VN;
    }

    public boolean pB() {
        ap apVar = com.baidu.live.v.a.zs().axR;
        return this.VM && apVar != null && apVar.adg != null && apVar.adg.aeO;
    }

    private a() {
        this.VM = MessageManager.getInstance().findTask(2913180) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.alphavideo.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0080a {
        private static a VN = new a();
    }
}
