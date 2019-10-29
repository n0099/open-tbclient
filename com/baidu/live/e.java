package com.baidu.live;

import com.baidu.live.im.l;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.account.AccountHelper;
import com.baidu.live.tbadk.account.OnSyncAccountCallback;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
/* loaded from: classes6.dex */
public class e {
    public static void init() {
        TbConfig.setLiveEnterFrom(AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
        com.baidu.c.b.a.aB(TbadkCoreApplication.getInst()).a(new com.baidu.c.b.b.b());
        com.baidu.c.b.a.aB(TbadkCoreApplication.getInst()).a(new com.baidu.live.widget.a());
        nr();
        ns();
    }

    public static void nr() {
        AccountHelper.setOnSyncAccountCallback(new OnSyncAccountCallback() { // from class: com.baidu.live.e.1
            @Override // com.baidu.live.tbadk.account.OnSyncAccountCallback
            public void onSyncAccount(boolean z) {
                l.sR().ay(z);
            }
        });
    }

    public static void ns() {
        com.baidu.live.a.a.b(TbadkCoreApplication.getInst().getApp());
    }
}
