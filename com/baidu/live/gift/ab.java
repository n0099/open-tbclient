package com.baidu.live.gift;

import android.view.View;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.tbadk.core.data.AlaBroadcastGiftToastData;
/* loaded from: classes11.dex */
public interface ab {
    View HQ();

    void a(AlaLiveInfoData alaLiveInfoData, AlaLiveUserInfoData alaLiveUserInfoData);

    void a(AlaBroadcastGiftToastData alaBroadcastGiftToastData);

    void el(int i);

    void onDestroy();
}
