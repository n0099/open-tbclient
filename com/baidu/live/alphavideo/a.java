package com.baidu.live.alphavideo;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.data.as;
/* loaded from: classes3.dex */
public class a {
    private boolean anG;

    public static a tK() {
        return C0125a.anH;
    }

    public boolean tL() {
        as asVar = com.baidu.live.v.a.En().aRB;
        return this.anG && asVar != null && asVar.avD != null && asVar.avD.axk;
    }

    private a() {
        this.anG = MessageManager.getInstance().findTask(2913180) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.alphavideo.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0125a {
        private static a anH = new a();
    }
}
