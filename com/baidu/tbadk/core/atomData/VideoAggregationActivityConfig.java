package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class VideoAggregationActivityConfig extends IntentConfig {
    public static final String PARAM_FID = "PARAM_FID";

    public VideoAggregationActivityConfig(Context context, String str) {
        super(context);
        getIntent().putExtra(PARAM_FID, str);
    }
}
