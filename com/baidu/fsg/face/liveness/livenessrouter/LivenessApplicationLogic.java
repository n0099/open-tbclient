package com.baidu.fsg.face.liveness.livenessrouter;

import android.content.Context;
import com.baidu.fsg.base.router.BaseApplicationLogic;
import com.baidu.fsg.base.router.RouterManager;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class LivenessApplicationLogic extends BaseApplicationLogic {
    public static final String actionName_liveness_recognize = "startLivenessRecognize";
    public static final String providerName = "LivenessProvider";

    @Override // com.baidu.fsg.base.router.BaseApplicationLogic
    public void onCreate(Context context, HashMap<String, Object> hashMap) {
        super.onCreate(context, hashMap);
        RouterManager.getInstance().registerProvider(providerName, new a());
    }
}
