package com.baidu.live.alphavideo;

import android.util.Log;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.data.bq;
/* loaded from: classes11.dex */
public class a {
    private boolean aEA;

    public static a CC() {
        return C0171a.aEB;
    }

    public boolean CD() {
        bq bqVar = com.baidu.live.af.a.SE().bCb;
        if (bqVar != null && bqVar.aRE != null && !bqVar.aRE.aUk) {
            return false;
        }
        Log.e("entereffect", "云控透明视频开关： " + this.aEA);
        return this.aEA;
    }

    private a() {
        this.aEA = MessageManager.getInstance().findTask(2913180) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.alphavideo.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0171a {
        private static a aEB = new a();
    }
}
