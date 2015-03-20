package com.baidu.tbadk.core;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class m extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public m(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null) {
            switch (customResponsedMessage.getCmd()) {
                case 2005009:
                    TbadkCoreApplication.m411getInst().startSyncService();
                    return;
                case 2005010:
                    TbadkCoreApplication.m411getInst().stopSyncService();
                    return;
                case 2005011:
                    TbadkCoreApplication.m411getInst().startActiveService();
                    return;
                case 2005012:
                    TbadkCoreApplication.m411getInst().stopActiveServide();
                    return;
                case 2005013:
                    TbadkCoreApplication.m411getInst().startClearTempService();
                    return;
                case 2005014:
                default:
                    return;
                case 2005015:
                    TbadkCoreApplication.m411getInst().startSyncLoginService();
                    return;
            }
        }
    }
}
