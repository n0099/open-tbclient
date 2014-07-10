package com.baidu.tbadk;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.message.http.ResponseLocationJsonHttpMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class LocationAccountChangeReceiverStatic {
    private static BroadcastReceiver a = new a();

    static {
        if (TbadkApplication.m252getInst().isMainProcess(false)) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbadkApplication.ACCOUNT_CHANGE_ACTION);
            TbadkApplication.m252getInst().getApp().registerReceiver(a, intentFilter);
            a();
        }
    }

    private static void a() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001507, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_USER_LOCATION);
        tbHttpMessageTask.setResponsedClass(ResponseLocationJsonHttpMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(new b(1001507));
    }
}
