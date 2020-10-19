package com.baidu.live.alphavideo;

import android.util.Log;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.data.bj;
/* loaded from: classes4.dex */
public class a {
    private boolean aCD;

    public static a BT() {
        return C0173a.aCE;
    }

    public boolean BU() {
        bj bjVar = com.baidu.live.x.a.OS().bqJ;
        if (bjVar != null && bjVar.aNY != null && !bjVar.aNY.aQj) {
            return false;
        }
        Log.e("entereffect", "云控透明视频开关： " + this.aCD);
        return this.aCD;
    }

    private a() {
        this.aCD = MessageManager.getInstance().findTask(2913180) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.alphavideo.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0173a {
        private static a aCE = new a();
    }
}
