package com.baidu.live.view.web.a;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import com.baidu.live.tbadk.scheme.SchemeCallbackWithName;
/* loaded from: classes10.dex */
public class j extends com.baidu.live.view.web.a {
    SchemeCallbackWithName bSj = new SchemeCallbackWithName();
    private SchemeCallback schemeCallback;

    public j(SchemeCallback schemeCallback) {
        this.schemeCallback = schemeCallback;
    }

    @Override // com.baidu.live.view.web.a
    public String getName() {
        return "liveRoomInfoBridge";
    }

    @Override // com.baidu.live.view.web.a
    public void hU(String str) {
        if (this.schemeCallback != null) {
            this.bSj.schemeCallback = this.schemeCallback;
            this.bSj.callBackName = str;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913286, this.bSj));
        }
    }
}
