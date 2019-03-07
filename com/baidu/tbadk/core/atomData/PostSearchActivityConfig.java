package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.plugins.c;
/* loaded from: classes.dex */
public class PostSearchActivityConfig extends IntentConfig {
    public static final String FORUM_ID = "forum_id";
    public static final String FORUM_NAME = "forum_name";

    public PostSearchActivityConfig(Context context, String str) {
        super(context);
        getIntent().putExtra("forum_name", str);
    }

    public PostSearchActivityConfig(Context context, String str, String str2) {
        super(context);
        getIntent().putExtra("forum_name", str);
        getIntent().putExtra("forum_id", str2);
    }

    @Override // com.baidu.tbadk.core.frameworkData.IntentConfig
    public boolean isValid() {
        if (c.ay(getContext(), "com.baidu.tieba.pluginCore")) {
            return super.isValid();
        }
        return false;
    }
}
