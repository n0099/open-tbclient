package com.baidu.tbadk.core;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class h {
    private static final CustomMessageListener bvx = new CustomMessageListener(0) { // from class: com.baidu.tbadk.core.h.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                switch (customResponsedMessage.getCmd()) {
                    case 2005009:
                        TbadkCoreApplication.getInst().startSyncService();
                        return;
                    case 2005010:
                        TbadkCoreApplication.getInst().stopSyncService();
                        return;
                    case 2005011:
                        TbadkCoreApplication.getInst().startActiveService();
                        return;
                    case 2005012:
                        TbadkCoreApplication.getInst().stopActiveServide();
                        return;
                    case 2005013:
                        TbadkCoreApplication.getInst().startClearTempService();
                        return;
                    case 2005014:
                    default:
                        return;
                    case 2005015:
                        TbadkCoreApplication.getInst().startSyncLoginService();
                        return;
                }
            }
        }
    };

    public static void init() {
        MessageManager.getInstance().registerListener(2005009, bvx);
        MessageManager.getInstance().registerListener(2005010, bvx);
        MessageManager.getInstance().registerListener(2005011, bvx);
        MessageManager.getInstance().registerListener(2005012, bvx);
        MessageManager.getInstance().registerListener(2005013, bvx);
        MessageManager.getInstance().registerListener(2005015, bvx);
    }
}
