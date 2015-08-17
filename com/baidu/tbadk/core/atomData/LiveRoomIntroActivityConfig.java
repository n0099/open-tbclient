package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class LiveRoomIntroActivityConfig extends IntentConfig {
    public LiveRoomIntroActivityConfig(Context context, int i, long j, String str) {
        super(context);
        getIntent().putExtra("group_id", i);
        getIntent().putExtra(IntentConfig.PUBLISHER_ID, j);
        getIntent().putExtra(IntentConfig.PUBLISHER_NAME, str);
    }
}
