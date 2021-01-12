package com.baidu.live.gift;

import android.view.View;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.tbadk.core.data.AlaBroadcastGiftToastData;
/* loaded from: classes10.dex */
public interface ab {
    View DV();

    void a(AlaLiveInfoData alaLiveInfoData, AlaLiveUserInfoData alaLiveUserInfoData);

    void a(AlaBroadcastGiftToastData alaBroadcastGiftToastData);

    void cF(int i);

    void onDestroy();
}
