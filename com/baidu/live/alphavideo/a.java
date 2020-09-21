package com.baidu.live.alphavideo;

import android.util.Log;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.data.bj;
/* loaded from: classes4.dex */
public class a {
    private boolean azy;

    public static a AW() {
        return C0167a.azz;
    }

    public boolean AX() {
        bj bjVar = com.baidu.live.x.a.NN().bmW;
        if (bjVar != null && bjVar.aKT != null && !bjVar.aKT.aNe) {
            return false;
        }
        Log.e("entereffect", "云控透明视频开关： " + this.azy);
        return this.azy;
    }

    private a() {
        this.azy = MessageManager.getInstance().findTask(2913180) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.alphavideo.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0167a {
        private static a azz = new a();
    }
}
