package com.baidu.tbadk.browser;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class d extends CustomMessageListener {
    final /* synthetic */ BaseWebViewActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(BaseWebViewActivity baseWebViewActivity, int i) {
        super(i);
        this.this$0 = baseWebViewActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921024 && (customResponsedMessage.getData() instanceof Boolean)) {
            this.this$0.onWebViewLogin(((Boolean) customResponsedMessage.getData()).booleanValue());
        }
    }
}
