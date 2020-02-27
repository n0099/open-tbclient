package com.baidu.live;

import com.baidu.live.im.l;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.account.AccountHelper;
import com.baidu.live.tbadk.account.OnSyncAccountCallback;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
/* loaded from: classes3.dex */
public class e {
    public static void init() {
        TbConfig.setLiveEnterFrom(AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
        com.baidu.g.b.a.aP(TbadkCoreApplication.getInst()).a(new com.baidu.g.b.b.b());
        com.baidu.g.b.a.aP(TbadkCoreApplication.getInst()).a(new com.baidu.live.widget.a());
        pt();
        pu();
    }

    public static void pt() {
        AccountHelper.setOnSyncAccountCallback(new OnSyncAccountCallback() { // from class: com.baidu.live.e.1
            @Override // com.baidu.live.tbadk.account.OnSyncAccountCallback
            public void onSyncAccount(boolean z) {
                l.wG().aU(z);
            }
        });
    }

    public static void pu() {
        com.baidu.live.a.a.d(TbadkCoreApplication.getInst().getApp());
    }
}
