package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class ChatMessageActivityConfig extends IntentConfig {
    public ChatMessageActivityConfig(Context context) {
        super(context);
    }

    public ChatMessageActivityConfig(Context context, int i) {
        super(context);
        getIntent().putExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, i);
    }
}
