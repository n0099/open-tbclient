package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class ForumSearchActivityConfig extends IntentConfig {
    public static final String EXTRA_KEY_FROM = "extra_key_from";
    public static final int FROM_SHARE = 1;

    public ForumSearchActivityConfig(Context context) {
        super(context);
    }

    public void setFrom(int i) {
        if (getIntent() != null) {
            getIntent().putExtra("extra_key_from", i);
        }
    }
}
