package com.baidu.live.alphavideo;

import android.util.Log;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.data.bv;
/* loaded from: classes11.dex */
public class a {
    private boolean aBs;

    public static a zo() {
        return C0163a.aBt;
    }

    public boolean zp() {
        bv bvVar = com.baidu.live.ae.a.Qj().bAS;
        if (bvVar != null && bvVar.aPP != null && !bvVar.aPP.aSz) {
            return false;
        }
        Log.e("entereffect", "云控透明视频开关： " + this.aBs);
        return this.aBs;
    }

    private a() {
        this.aBs = MessageManager.getInstance().findTask(2913180) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.alphavideo.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0163a {
        private static a aBt = new a();
    }
}
