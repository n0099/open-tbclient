package com.baidu.live.alphavideo;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.data.ax;
/* loaded from: classes3.dex */
public class a {
    private boolean asA;

    public static a uR() {
        return C0156a.asB;
    }

    public boolean uS() {
        ax axVar = com.baidu.live.v.a.Ge().aYP;
        if (axVar == null || axVar.aAL == null || axVar.aAL.aCz) {
            return this.asA;
        }
        return false;
    }

    private a() {
        this.asA = MessageManager.getInstance().findTask(2913180) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.alphavideo.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0156a {
        private static a asB = new a();
    }
}
