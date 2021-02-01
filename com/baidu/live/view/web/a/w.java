package com.baidu.live.view.web.a;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import com.baidu.live.tbadk.scheme.SchemeCallbackWithName;
/* loaded from: classes11.dex */
public class w extends com.baidu.live.view.web.a {
    SchemeCallbackWithName bWd = new SchemeCallbackWithName();
    private SchemeCallback schemeCallback;

    public w(SchemeCallback schemeCallback) {
        this.schemeCallback = schemeCallback;
    }

    @Override // com.baidu.live.view.web.a
    public String getName() {
        return "watchDurationBridge";
    }

    @Override // com.baidu.live.view.web.a
    public void is(String str) {
        if (this.schemeCallback != null) {
            this.bWd.schemeCallback = this.schemeCallback;
            this.bWd.callBackName = str;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913280, this.bWd));
        }
    }
}
