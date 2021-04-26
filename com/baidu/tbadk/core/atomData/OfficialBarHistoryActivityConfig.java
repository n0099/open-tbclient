package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class OfficialBarHistoryActivityConfig extends IntentConfig {
    public OfficialBarHistoryActivityConfig(Context context, int i2) {
        super(context);
        getIntent().putExtra("forum_id", i2);
    }
}
