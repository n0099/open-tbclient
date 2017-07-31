package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class RecordStoryActivityConfig extends IntentConfig {
    public RecordStoryActivityConfig(Context context, int i, long j, String str) {
        super(context);
        getIntent().putExtra(IntentConfig.CALL_FROM, i);
        getIntent().putExtra("forum_id", j);
        getIntent().putExtra("forum_name", str);
    }
}
