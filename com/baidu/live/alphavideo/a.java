package com.baidu.live.alphavideo;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.data.bb;
/* loaded from: classes3.dex */
public class a {
    private boolean atS;

    public static a vj() {
        return C0158a.atT;
    }

    public boolean vk() {
        bb bbVar = com.baidu.live.v.a.Hm().bdV;
        if (bbVar == null || bbVar.aCW == null || bbVar.aCW.aEQ) {
            return this.atS;
        }
        return false;
    }

    private a() {
        this.atS = MessageManager.getInstance().findTask(2913180) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.alphavideo.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0158a {
        private static a atT = new a();
    }
}
