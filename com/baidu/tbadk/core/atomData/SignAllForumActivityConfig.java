package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class SignAllForumActivityConfig extends IntentConfig {
    public SignAllForumActivityConfig(Context context) {
        super(context);
    }

    public void setUri(Uri uri) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra(IntentConfig.KEY_URI, uri);
        }
    }

    public SignAllForumActivityConfig(Context context, boolean z) {
        super(context);
        getIntent().putExtra(IntentConfig.MEMBER_BUY_SHOW, z);
    }
}
