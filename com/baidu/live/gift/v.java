package com.baidu.live.gift;

import android.view.View;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.tbadk.core.data.AlaBroadcastGiftToastData;
/* loaded from: classes4.dex */
public interface v {
    View Gl();

    void a(AlaLiveInfoData alaLiveInfoData, AlaLiveUserInfoData alaLiveUserInfoData);

    void a(AlaBroadcastGiftToastData alaBroadcastGiftToastData);

    void onDestroy();
}
