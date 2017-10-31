package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class ChannelHomeActivityConfig extends IntentConfig {
    public static final String CHANNEL_ID = "channel_id";
    public static final int FROM_FRS = 3;
    public static final int FROM_OTHER = 0;
    public static final int FROM_PB = 2;
    public static final int FROM_PERSON = 4;
    public static final String PARAM_OBJ_SOURCE = "obj_source";

    public ChannelHomeActivityConfig(Context context, long j, int i) {
        super(context);
        getIntent().putExtra("channel_id", j);
        getIntent().putExtra(PARAM_OBJ_SOURCE, i);
    }

    public ChannelHomeActivityConfig(Context context, int i) {
        super(context);
        getIntent().putExtra(PARAM_OBJ_SOURCE, i);
    }
}
