package com.baidu.live.c;

import android.content.Context;
import com.baidu.ala.atomdata.AlaPersonCenterExpActivityConfig;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes4.dex */
public class c extends IntentConfig {
    public c(Context context, int i, boolean z) {
        super(context);
        getIntent().putExtra("type", i);
        getIntent().putExtra(AlaPersonCenterExpActivityConfig.IS_HOST, z);
    }

    public void b(long j, long j2, long j3) {
        getIntent().putExtra("challengeid", j);
        getIntent().putExtra(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, j2);
        getIntent().putExtra("anchorid", j3);
    }
}
