package com.baidu.live.alphavideo;

import android.util.Log;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.data.bn;
/* loaded from: classes4.dex */
public class a {
    private boolean aDo;

    public static a Cl() {
        return C0176a.aDp;
    }

    public boolean Cm() {
        bn bnVar = com.baidu.live.aa.a.PQ().btT;
        if (bnVar != null && bnVar.aPA != null && !bnVar.aPA.aRV) {
            return false;
        }
        Log.e("entereffect", "云控透明视频开关： " + this.aDo);
        return this.aDo;
    }

    private a() {
        this.aDo = MessageManager.getInstance().findTask(2913180) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.alphavideo.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0176a {
        private static a aDp = new a();
    }
}
