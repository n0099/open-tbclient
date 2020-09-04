package com.baidu.live.alphavideo;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.data.be;
/* loaded from: classes7.dex */
public class a {
    private boolean ayS;

    public static a AH() {
        return C0165a.ayT;
    }

    public boolean AI() {
        be beVar = com.baidu.live.w.a.Nk().bkd;
        if (beVar == null || beVar.aJD == null || beVar.aJD.aLw) {
            return this.ayS;
        }
        return false;
    }

    private a() {
        this.ayS = MessageManager.getInstance().findTask(2913180) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.alphavideo.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0165a {
        private static a ayT = new a();
    }
}
