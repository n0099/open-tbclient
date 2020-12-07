package com.baidu.tbadk.core;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes.dex */
public class i {
    private static final CustomMessageListener eCA = new CustomMessageListener(0) { // from class: com.baidu.tbadk.core.i.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.METHOD_START_SYNC /* 2005009 */:
                        TbadkCoreApplication.getInst().startSyncService();
                        return;
                    case CmdConfigCustom.METHOD_STOP_SYNC /* 2005010 */:
                        TbadkCoreApplication.getInst().stopSyncService();
                        return;
                    case CmdConfigCustom.METHOD_START_ACTIVE /* 2005011 */:
                        TbadkCoreApplication.getInst().startActiveService();
                        return;
                    case CmdConfigCustom.METHOD_STOP_ACTIVE /* 2005012 */:
                        TbadkCoreApplication.getInst().stopActiveServide();
                        return;
                    case CmdConfigCustom.METHOD_START_CLEARTEMP /* 2005013 */:
                        TbadkCoreApplication.getInst().startClearTempService();
                        return;
                    case 2005014:
                    default:
                        return;
                    case CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED /* 2005015 */:
                        TbadkCoreApplication.getInst().startSyncLoginService();
                        return;
                }
            }
        }
    };

    public static void init() {
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_START_SYNC, eCA);
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_STOP_SYNC, eCA);
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_START_ACTIVE, eCA);
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_STOP_ACTIVE, eCA);
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_START_CLEARTEMP, eCA);
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, eCA);
    }
}
