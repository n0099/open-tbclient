package com.baidu.fsg.face.liveness.livenessrouter;

import android.content.Context;
import com.baidu.fsg.base.InitDelayThread;
import com.baidu.fsg.base.router.BaseApplicationLogic;
import com.baidu.fsg.base.router.RouterManager;
import com.baidu.fsg.face.liveness.SapiLivenessRecogManager;
import java.lang.ref.WeakReference;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class LivenessApplicationLogic extends BaseApplicationLogic {
    public static final String actionName_liveness_recognize = "startLivenessRecognize";
    public static final String providerName = "LivenessProvider";

    @Override // com.baidu.fsg.base.router.BaseApplicationLogic
    public void onCreate(final Context context, HashMap<String, Object> hashMap) {
        super.onCreate(context, hashMap);
        RouterManager.getInstance().registerProvider(providerName, new a());
        new InitDelayThread(new WeakReference(context), new InitDelayThread.InitDelayCallback() { // from class: com.baidu.fsg.face.liveness.livenessrouter.LivenessApplicationLogic.1
            @Override // com.baidu.fsg.base.InitDelayThread.InitDelayCallback
            public void callBack() {
                try {
                    SapiLivenessRecogManager.getInstance().checkSo(context);
                } catch (Error e) {
                    e.printStackTrace();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }).run();
    }
}
