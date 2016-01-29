package com.baidu.tbadk.core;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
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
                case CmdConfigCustom.METHOD_START_SYNC /* 2005009 */:
                    TbadkCoreApplication.m411getInst().startSyncService();
                    return;
                case CmdConfigCustom.METHOD_STOP_SYNC /* 2005010 */:
                    TbadkCoreApplication.m411getInst().stopSyncService();
                    return;
                case CmdConfigCustom.METHOD_START_ACTIVE /* 2005011 */:
                    TbadkCoreApplication.m411getInst().startActiveService();
                    return;
                case CmdConfigCustom.METHOD_STOP_ACTIVE /* 2005012 */:
                    TbadkCoreApplication.m411getInst().stopActiveServide();
                    return;
                case CmdConfigCustom.METHOD_START_CLEARTEMP /* 2005013 */:
                    TbadkCoreApplication.m411getInst().startClearTempService();
                    return;
                case CmdConfigCustom.METHOD_IM_MESSAGE_CACHE_INITED /* 2005014 */:
                default:
                    return;
                case CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED /* 2005015 */:
                    TbadkCoreApplication.m411getInst().startSyncLoginService();
                    return;
            }
        }
    }
}
