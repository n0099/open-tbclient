package com.baidu.live.view.web.a;

import android.util.Log;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes11.dex */
public class q extends com.baidu.live.view.web.a {
    @Override // com.baidu.live.view.web.a
    public String getName() {
        return "reloadDangleBridge";
    }

    @Override // com.baidu.live.view.web.a
    public void jf(String str) {
        Log.d("JsInterface", "@@ JsInterface-impl ReloadDangleBridgeJsInterface params = " + str);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913274, true));
    }
}
