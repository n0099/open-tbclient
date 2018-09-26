package com.baidu.fsg.face.liveness.livenessrouter;

import android.content.Context;
import com.baidu.fsg.base.router.RouterAction;
import com.baidu.fsg.base.router.RouterCallback;
import com.baidu.fsg.face.liveness.utils.LivenessABTestUtil;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b implements RouterAction {
    @Override // com.baidu.fsg.base.router.RouterAction
    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        if (context != null && hashMap != null) {
            LivenessABTestUtil.cleanInstance();
            com.baidu.fsg.face.liveness.a.a().a(context, hashMap, routerCallback);
        }
    }
}
