package com.baidu.live.d;

import android.content.Context;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaCharmRankActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.IntentAction;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
/* loaded from: classes10.dex */
public class b extends IntentConfig {
    public b(Context context, int i, String str, String str2, int i2, boolean z, String str3, String str4, String str5, long j, String str6, String str7, String str8, String str9) {
        super(context);
        setRequestCode(i2);
        setIntentAction(IntentAction.ActivityForResult);
        getIntent().putExtra(UbcStatConstant.KEY_LIVE_TYPE, i);
        getIntent().putExtra("uk", str);
        getIntent().putExtra(TbEnum.SystemMessage.KEY_USER_NAME, str2);
        getIntent().putExtra("rank_list_from", z);
        getIntent().putExtra("portrait", str3);
        getIntent().putExtra(IntentConfig.OTHER_PARAMS, str4);
        getIntent().putExtra("feed_id", str5);
        getIntent().putExtra(YuyinAlaCharmRankActivityConfig.C_ROOM_ID, str6);
        getIntent().putExtra("live_id", j);
        getIntent().putExtra("room_id", str7);
        getIntent().putExtra("room_cover", str8);
        getIntent().putExtra(DpStatConstants.KEY_ROOM_NAME, str9);
    }
}
