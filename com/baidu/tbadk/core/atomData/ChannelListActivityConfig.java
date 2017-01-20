package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class ChannelListActivityConfig extends IntentConfig {
    public static final String USER_ID = "user_id";

    public ChannelListActivityConfig(Context context, String str) {
        super(context);
        getIntent().putExtra("user_id", str);
    }
}
