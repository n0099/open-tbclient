package com.baidu.live.d;

import android.content.Context;
import com.baidu.ala.atomdata.AlaPersonCenterExpActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes4.dex */
public class q extends IntentConfig {
    public q(Context context, long j, int i) {
        super(context);
        getIntent().putExtra(AlaPersonCenterExpActivityConfig.CURRENT_EXP, j);
        getIntent().putExtra("current_level", i);
        getIntent().putExtra(AlaPersonCenterExpActivityConfig.IS_HOST, true);
    }
}
