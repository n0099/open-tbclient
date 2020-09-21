package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class ForumSquareActivityConfig extends IntentConfig {
    public static final String FORUM_CLASS_NAME = "class_name";
    public static final String SHOW_CREATE_BAR = "show_create_bar";

    public ForumSquareActivityConfig(Context context) {
        super(context);
    }

    public ForumSquareActivityConfig(Context context, String str) {
        super(context);
        getIntent().putExtra(FORUM_CLASS_NAME, str);
    }

    public void setUri(Uri uri) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra(IntentConfig.KEY_URI, uri);
        }
    }

    public void showCreateBar(int i) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra(SHOW_CREATE_BAR, i);
        }
    }
}
