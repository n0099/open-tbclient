package com.baidu.live.view.web.a;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes10.dex */
public class e extends com.baidu.live.view.web.a {
    @Override // com.baidu.live.view.web.a
    public String getName() {
        return "taskCompleteBridge";
    }

    @Override // com.baidu.live.view.web.a
    public void iy(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913282, str));
    }
}
