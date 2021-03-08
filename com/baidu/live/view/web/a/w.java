package com.baidu.live.view.web.a;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import com.baidu.live.tbadk.scheme.SchemeCallbackWithName;
/* loaded from: classes10.dex */
public class w extends com.baidu.live.view.web.a {
    SchemeCallbackWithName bXD = new SchemeCallbackWithName();
    private SchemeCallback schemeCallback;

    public w(SchemeCallback schemeCallback) {
        this.schemeCallback = schemeCallback;
    }

    @Override // com.baidu.live.view.web.a
    public String getName() {
        return "watchDurationBridge";
    }

    @Override // com.baidu.live.view.web.a
    public void iy(String str) {
        if (this.schemeCallback != null) {
            this.bXD.schemeCallback = this.schemeCallback;
            this.bXD.callBackName = str;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913280, this.bXD));
        }
    }
}
