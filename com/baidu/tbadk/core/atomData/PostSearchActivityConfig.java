package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class PostSearchActivityConfig extends IntentConfig {
    public static final String FORUM_NAME = "forum_name";

    public PostSearchActivityConfig(Context context, String str) {
        super(context);
        getIntent().putExtra("forum_name", str);
    }
}
