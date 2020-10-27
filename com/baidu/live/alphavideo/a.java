package com.baidu.live.alphavideo;

import android.util.Log;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.data.bm;
/* loaded from: classes4.dex */
public class a {
    private boolean aCH;

    public static a BT() {
        return C0174a.aCI;
    }

    public boolean BU() {
        bm bmVar = com.baidu.live.z.a.Pq().bsy;
        if (bmVar != null && bmVar.aOD != null && !bmVar.aOD.aQT) {
            return false;
        }
        Log.e("entereffect", "云控透明视频开关： " + this.aCH);
        return this.aCH;
    }

    private a() {
        this.aCH = MessageManager.getInstance().findTask(2913180) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.alphavideo.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0174a {
        private static a aCI = new a();
    }
}
