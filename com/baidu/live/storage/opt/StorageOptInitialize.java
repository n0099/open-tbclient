package com.baidu.live.storage.opt;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.storage.opt.http.StorageOptSwitchHttpResponseMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes10.dex */
public class StorageOptInitialize {
    static {
        Ri();
    }

    private static void Ri() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021236, TbConfig.SERVER_ADDRESS + "ala/sdk/v1/open/discOptimizeUserSwith");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(StorageOptSwitchHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
