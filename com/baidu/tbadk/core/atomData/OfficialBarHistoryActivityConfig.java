package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes2.dex */
public class OfficialBarHistoryActivityConfig extends IntentConfig {
    public OfficialBarHistoryActivityConfig(Context context, int i) {
        super(context);
        getIntent().putExtra("forum_id", i);
    }
}
