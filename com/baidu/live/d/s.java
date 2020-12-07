package com.baidu.live.d;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentAction;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
/* loaded from: classes4.dex */
public class s extends IntentConfig {
    public s(Context context, int i, long j, String str, String str2, int i2, boolean z, String str3, String str4, String str5, long j2, String str6) {
        super(context);
        setRequestCode(i2);
        setIntentAction(IntentAction.ActivityForResult);
        getIntent().putExtra(UbcStatConstant.KEY_LIVE_TYPE, i);
        getIntent().putExtra(TbEnum.SystemMessage.KEY_USER_ID, j);
        getIntent().putExtra(TbEnum.SystemMessage.KEY_USER_NAME, str);
        getIntent().putExtra("rank_list_type", str2);
        getIntent().putExtra("rank_list_from", z);
        getIntent().putExtra("portrait", str3);
        getIntent().putExtra(IntentConfig.OTHER_PARAMS, str4);
        getIntent().putExtra("feed_id", str5);
        getIntent().putExtra("cur_hour", str6);
        getIntent().putExtra("cur_live_id", j2);
    }
}
