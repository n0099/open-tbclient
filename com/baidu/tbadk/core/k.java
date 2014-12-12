package com.baidu.tbadk.core;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class k extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public k(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null) {
            switch (customResponsedMessage.getCmd()) {
                case 2005009:
                    TbadkCoreApplication.m255getInst().startSyncService();
                    return;
                case 2005010:
                    TbadkCoreApplication.m255getInst().stopSyncService();
                    return;
                case 2005011:
                    TbadkCoreApplication.m255getInst().startActiveService();
                    return;
                case 2005012:
                    TbadkCoreApplication.m255getInst().stopActiveServide();
                    return;
                case 2005013:
                    TbadkCoreApplication.m255getInst().startClearTempService();
                    return;
                case 2005014:
                default:
                    return;
                case 2005015:
                    TbadkCoreApplication.m255getInst().startSyncLoginService();
                    return;
            }
        }
    }
}
