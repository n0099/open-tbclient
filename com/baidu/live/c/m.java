package com.baidu.live.c;

import android.content.Context;
import com.baidu.ala.atomdata.AlaPersonCenterExpActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes2.dex */
public class m extends IntentConfig {
    public m(Context context, long j, int i) {
        super(context);
        getIntent().putExtra(AlaPersonCenterExpActivityConfig.CURRENT_EXP, j);
        getIntent().putExtra("current_level", i);
        getIntent().putExtra(AlaPersonCenterExpActivityConfig.IS_HOST, true);
    }
}
