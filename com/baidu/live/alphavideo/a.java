package com.baidu.live.alphavideo;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.data.be;
/* loaded from: classes7.dex */
public class a {
    private boolean ayQ;

    public static a AH() {
        return C0165a.ayR;
    }

    public boolean AI() {
        be beVar = com.baidu.live.w.a.Nk().bka;
        if (beVar == null || beVar.aJB == null || beVar.aJB.aLu) {
            return this.ayQ;
        }
        return false;
    }

    private a() {
        this.ayQ = MessageManager.getInstance().findTask(2913180) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.alphavideo.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0165a {
        private static a ayR = new a();
    }
}
