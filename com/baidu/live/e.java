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
        com.baidu.g.b.a.aO(TbadkCoreApplication.getInst()).a(new com.baidu.g.b.b.b());
        com.baidu.g.b.a.aO(TbadkCoreApplication.getInst()).a(new com.baidu.live.widget.a());
        py();
        pz();
    }

    public static void py() {
        AccountHelper.setOnSyncAccountCallback(new OnSyncAccountCallback() { // from class: com.baidu.live.e.1
            @Override // com.baidu.live.tbadk.account.OnSyncAccountCallback
            public void onSyncAccount(boolean z) {
                l.wL().aU(z);
            }
        });
    }

    public static void pz() {
        com.baidu.live.a.a.d(TbadkCoreApplication.getInst().getApp());
    }
}
