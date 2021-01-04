package com.baidu.live.view.web.a;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import com.baidu.live.tbadk.scheme.SchemeCallbackWithName;
/* loaded from: classes11.dex */
public class u extends com.baidu.live.view.web.a {
    SchemeCallbackWithName bWV = new SchemeCallbackWithName();
    private SchemeCallback schemeCallback;

    public u(SchemeCallback schemeCallback) {
        this.schemeCallback = schemeCallback;
    }

    @Override // com.baidu.live.view.web.a
    public String getName() {
        return "watchTaskBridge";
    }

    @Override // com.baidu.live.view.web.a
    public void jf(String str) {
        if (this.schemeCallback != null) {
            this.bWV.schemeCallback = this.schemeCallback;
            this.bWV.callBackName = str;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913285, this.bWV));
        }
    }
}
