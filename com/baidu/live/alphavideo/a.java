package com.baidu.live.alphavideo;

import android.util.Log;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.data.bo;
/* loaded from: classes4.dex */
public class a {
    private boolean aEj;

    public static a Dl() {
        return C0179a.aEk;
    }

    public boolean Dm() {
        bo boVar = com.baidu.live.ae.a.RB().bxq;
        if (boVar != null && boVar.aQP != null && !boVar.aQP.aTm) {
            return false;
        }
        Log.e("entereffect", "云控透明视频开关： " + this.aEj);
        return this.aEj;
    }

    private a() {
        this.aEj = MessageManager.getInstance().findTask(2913180) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.alphavideo.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0179a {
        private static a aEk = new a();
    }
}
