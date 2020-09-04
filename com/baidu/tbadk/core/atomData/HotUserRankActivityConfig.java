package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class HotUserRankActivityConfig extends IntentConfig {
    public static final String KEY_CATEGORY = "key_category";
    public static final String KEY_FORUM_ID = "key_forum_id";
    public static final String KEY_IS_GOD = "key_is_god";

    public HotUserRankActivityConfig(Context context) {
        super(context);
    }

    public void setCategory(String str) {
        if (getIntent() != null) {
            getIntent().putExtra(KEY_CATEGORY, str);
        }
    }

    public void setForumId(Long l) {
        if (getIntent() != null) {
            getIntent().putExtra(KEY_FORUM_ID, l);
        }
    }

    public void setUri(Uri uri) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra(IntentConfig.KEY_URI, uri);
        }
    }

    public void setIsGod(boolean z) {
        if (getIntent() != null) {
            getIntent().putExtra(KEY_IS_GOD, z);
        }
    }
}
