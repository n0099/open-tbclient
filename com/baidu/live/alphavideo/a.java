package com.baidu.live.alphavideo;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.data.as;
/* loaded from: classes3.dex */
public class a {
    private boolean anA;

    public static a tL() {
        return C0104a.anB;
    }

    public boolean tM() {
        as asVar = com.baidu.live.v.a.Eo().aRw;
        return this.anA && asVar != null && asVar.avx != null && asVar.avx.axe;
    }

    private a() {
        this.anA = MessageManager.getInstance().findTask(2913180) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.alphavideo.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0104a {
        private static a anB = new a();
    }
}
