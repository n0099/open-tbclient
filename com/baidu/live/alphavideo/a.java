package com.baidu.live.alphavideo;

import android.util.Log;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.data.bq;
/* loaded from: classes10.dex */
public class a {
    private boolean azN;

    public static a yH() {
        return C0162a.azO;
    }

    public boolean yI() {
        bq bqVar = com.baidu.live.af.a.OJ().bxp;
        if (bqVar != null && bqVar.aMR != null && !bqVar.aMR.aPx) {
            return false;
        }
        Log.e("entereffect", "云控透明视频开关： " + this.azN);
        return this.azN;
    }

    private a() {
        this.azN = MessageManager.getInstance().findTask(2913180) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.alphavideo.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0162a {
        private static a azO = new a();
    }
}
