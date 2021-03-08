package com.baidu.live.alphavideo;

import android.util.Log;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.data.bv;
/* loaded from: classes10.dex */
public class a {
    private boolean aCS;

    public static a zr() {
        return C0169a.aCT;
    }

    public boolean zs() {
        bv bvVar = com.baidu.live.ae.a.Qm().bCs;
        if (bvVar != null && bvVar.aRp != null && !bvVar.aRp.aTZ) {
            return false;
        }
        Log.e("entereffect", "云控透明视频开关： " + this.aCS);
        return this.aCS;
    }

    private a() {
        this.aCS = MessageManager.getInstance().findTask(2913180) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.alphavideo.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0169a {
        private static a aCT = new a();
    }
}
