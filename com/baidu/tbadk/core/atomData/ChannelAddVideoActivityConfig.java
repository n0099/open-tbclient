package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class ChannelAddVideoActivityConfig extends IntentConfig {
    public static final String CHANNEL_ID = "channel_id";

    public ChannelAddVideoActivityConfig(Context context, long j) {
        super(context);
        getIntent().putExtra("channel_id", j);
    }
}
