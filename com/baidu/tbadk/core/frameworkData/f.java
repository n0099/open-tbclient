package com.baidu.tbadk.core.frameworkData;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.websocketBase.h;
/* loaded from: classes.dex */
class f extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
            h.yp().dp(((Integer) customResponsedMessage.getData()).intValue());
        }
    }
}
