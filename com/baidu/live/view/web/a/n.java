package com.baidu.live.view.web.a;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes11.dex */
public class n extends com.baidu.live.view.web.a {
    @Override // com.baidu.live.view.web.a
    public String getName() {
        return "speakBridge";
    }

    @Override // com.baidu.live.view.web.a
    public void is(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913123));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913281, false));
    }
}
