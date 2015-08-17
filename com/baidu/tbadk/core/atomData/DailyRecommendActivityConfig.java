package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class DailyRecommendActivityConfig extends IntentConfig {
    public static String ST_TYPE = "st_type";

    public DailyRecommendActivityConfig(Context context, String str) {
        super(context);
        if (!(getContext() instanceof Activity)) {
            getIntent().addFlags(268435456);
        }
        getIntent().putExtra(ST_TYPE, str);
    }
}
