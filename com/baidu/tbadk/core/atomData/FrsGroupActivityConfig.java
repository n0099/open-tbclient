package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class FrsGroupActivityConfig extends IntentConfig {
    public static final String FORUM_ID = "forum_id";
    public static final String FORUM_NAME = "forum_name";
    public static final String SHOW_RECOMMEND_GROUP = "show_recommend_group";

    public FrsGroupActivityConfig(Context context, String str, String str2) {
        super(context);
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra("forum_id", str);
            intent.putExtra("forum_name", str2);
        }
    }

    public void showRecommend() {
        if (getIntent() != null) {
            getIntent().putExtra(SHOW_RECOMMEND_GROUP, true);
        }
    }
}
