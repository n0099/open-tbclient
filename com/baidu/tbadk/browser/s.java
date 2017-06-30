package com.baidu.tbadk.browser;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class s extends CustomMessageListener {
    final /* synthetic */ TbWebViewActivity Qm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(TbWebViewActivity tbWebViewActivity, int i) {
        super(i);
        this.Qm = tbWebViewActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921023 && (customResponsedMessage.getData() instanceof String)) {
            String str = (String) customResponsedMessage.getData();
            if (this.Qm.mUrl.contains(str) || str.contains(this.Qm.mUrl)) {
                this.Qm.hideProgressBar();
            }
        }
    }
}
