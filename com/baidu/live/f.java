package com.baidu.live;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.account.AccountHelper;
import com.baidu.live.tbadk.account.OnSyncAccountCallback;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes11.dex */
public class f {
    public static void init() {
        TbConfig.setLiveEnterFrom("live_sdk");
        com.baidu.h.b.a.bA(TbadkCoreApplication.getInst()).a(new com.baidu.h.b.b.b());
        com.baidu.h.b.a.bA(TbadkCoreApplication.getInst()).a(new com.baidu.live.widget.a());
        xe();
        xf();
    }

    public static void xe() {
        AccountHelper.setOnSyncAccountCallback(new OnSyncAccountCallback() { // from class: com.baidu.live.f.1
            @Override // com.baidu.live.tbadk.account.OnSyncAccountCallback
            public void onSyncAccount(boolean z) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913191, null));
            }
        });
    }

    public static void xf() {
        com.baidu.live.activity.a.d(TbadkCoreApplication.getInst().getApp());
    }
}
