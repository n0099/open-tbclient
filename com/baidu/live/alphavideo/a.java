package com.baidu.live.alphavideo;

import android.util.Log;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.data.bn;
/* loaded from: classes4.dex */
public class a {
    private boolean aBD;

    public static a BC() {
        return C0174a.aBE;
    }

    public boolean BD() {
        bn bnVar = com.baidu.live.aa.a.Ph().bsh;
        if (bnVar != null && bnVar.aNP != null && !bnVar.aNP.aQk) {
            return false;
        }
        Log.e("entereffect", "云控透明视频开关： " + this.aBD);
        return this.aBD;
    }

    private a() {
        this.aBD = MessageManager.getInstance().findTask(2913180) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.alphavideo.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0174a {
        private static a aBE = new a();
    }
}
