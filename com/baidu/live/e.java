package com.baidu.live;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.account.AccountHelper;
import com.baidu.live.tbadk.account.OnSyncAccountCallback;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
/* loaded from: classes3.dex */
public class e {
    public static void init() {
        TbConfig.setLiveEnterFrom(AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
        com.baidu.c.b.a.ap(TbadkCoreApplication.getInst()).a(new com.baidu.c.b.b.b());
        com.baidu.c.b.a.ap(TbadkCoreApplication.getInst()).a(new com.baidu.live.widget.a());
        tI();
        tJ();
    }

    public static void tI() {
        AccountHelper.setOnSyncAccountCallback(new OnSyncAccountCallback() { // from class: com.baidu.live.e.1
            @Override // com.baidu.live.tbadk.account.OnSyncAccountCallback
            public void onSyncAccount(boolean z) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913191, null));
            }
        });
    }

    public static void tJ() {
        com.baidu.live.a.a.d(TbadkCoreApplication.getInst().getApp());
    }
}
