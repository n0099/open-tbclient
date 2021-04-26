package com.baidu.ala.atomdata;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class AlaPersonCenterExpActivityConfig extends IntentConfig {
    public static final String CURRENT_EXP = "current_exp";
    public static final String CURRENT_LEVEL = "current_level";
    public static final String CURRENT_MAX_EXP = "current_max_exp";
    public static final String IS_HOST = "isHost";
    public static final String NEXT_LEVEL = "next_level";

    public AlaPersonCenterExpActivityConfig(Context context, long j, int i2, long j2, int i3, boolean z) {
        super(context);
        getIntent().putExtra(CURRENT_EXP, j);
        getIntent().putExtra("current_level", i2);
        getIntent().putExtra(CURRENT_MAX_EXP, j2);
        getIntent().putExtra(NEXT_LEVEL, i3);
        getIntent().putExtra(IS_HOST, z);
    }
}
