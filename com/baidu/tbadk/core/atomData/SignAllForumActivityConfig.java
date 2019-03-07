package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.plugins.c;
/* loaded from: classes.dex */
public class SignAllForumActivityConfig extends IntentConfig {
    public SignAllForumActivityConfig(Context context) {
        super(context);
    }

    public SignAllForumActivityConfig(Context context, boolean z) {
        super(context);
        getIntent().putExtra(IntentConfig.MEMBER_BUY_SHOW, z);
    }

    @Override // com.baidu.tbadk.core.frameworkData.IntentConfig
    public boolean isValid() {
        if (c.ay(getContext(), "com.baidu.tieba.pluginCore")) {
            return super.isValid();
        }
        return false;
    }
}
