package com.baidu.live.gift;

import android.view.View;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.tbadk.core.data.AlaBroadcastGiftToastData;
/* loaded from: classes3.dex */
public interface u {
    void a(AlaLiveInfoData alaLiveInfoData, AlaLiveUserInfoData alaLiveUserInfoData);

    void a(AlaBroadcastGiftToastData alaBroadcastGiftToastData);

    void onDestroy();

    View yQ();
}
