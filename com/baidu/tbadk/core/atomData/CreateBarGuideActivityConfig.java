package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes2.dex */
public class CreateBarGuideActivityConfig extends IntentConfig {
    public static final String EXTRA_KEY_FORUM_NAME = "extra_key_forum_name";

    public CreateBarGuideActivityConfig(Context context, String str) {
        super(context);
        getIntent().putExtra(EXTRA_KEY_FORUM_NAME, str);
    }
}
