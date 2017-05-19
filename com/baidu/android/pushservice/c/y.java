package com.baidu.android.pushservice.c;

import android.content.Context;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.config.ModeConfig;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class y extends d {

    /* loaded from: classes2.dex */
    private enum a {
        MODEL_O(1),
        MODEL_C(2),
        MODEL_HW(3),
        MODEL_XM(4);
        
        private int e;

        a(int i) {
            this.e = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int a() {
            return this.e;
        }
    }

    public y(l lVar, Context context) {
        super(lVar, context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.c.a
    public void a(HashMap<String, String> hashMap) {
        super.a(hashMap);
        hashMap.put(PushConstants.EXTRA_METHOD, "unbind");
        int a2 = a.MODEL_O.a();
        int currentMode = ModeConfig.getInstance(this.a).getCurrentMode();
        if (ModeConfig.isHuaweiProxyMode(this.a)) {
            a2 = a.MODEL_HW.a();
        } else if (ModeConfig.isXiaomiProxyMode(this.a)) {
            a2 = a.MODEL_XM.a();
        } else if (currentMode == ModeConfig.MODE_C || currentMode == ModeConfig.MODE_C_C || currentMode == ModeConfig.MODE_C_H) {
            a2 = a.MODEL_C.a();
        }
        hashMap.put("model", a2 + "");
        com.baidu.android.pushservice.e.a.c("Unbind", "UNBIND param -- " + b.a(hashMap));
    }
}
