package com.baidu.tbadk.core;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.kuang.ReLoginFromKuangMessage;
/* loaded from: classes.dex */
class n extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public n(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001325 && customResponsedMessage.getData() != null) {
            if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                TbadkCoreApplication.m9getInst().setIsKuangLogin(true);
                com.baidu.tbadk.kuang.a.bM(true);
                return;
            }
            TbadkCoreApplication.m9getInst().setIsKuangLogin(false);
            MessageManager.getInstance().dispatchResponsedMessage(new ReLoginFromKuangMessage(false));
        }
    }
}
