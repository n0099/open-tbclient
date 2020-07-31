package com.baidu.live.alphavideo;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.data.bc;
/* loaded from: classes4.dex */
public class a {
    private boolean atO;

    public static a vj() {
        return C0157a.atP;
    }

    public boolean vk() {
        bc bcVar = com.baidu.live.v.a.Hs().beo;
        if (bcVar == null || bcVar.aEr == null || bcVar.aEr.aGk) {
            return this.atO;
        }
        return false;
    }

    private a() {
        this.atO = MessageManager.getInstance().findTask(2913180) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.alphavideo.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0157a {
        private static a atP = new a();
    }
}
