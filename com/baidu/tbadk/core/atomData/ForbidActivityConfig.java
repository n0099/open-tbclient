package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class ForbidActivityConfig extends IntentConfig {
    public static final String MANAGER_USER_ID = "bar_manager_user_id";

    public ForbidActivityConfig(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        super(context);
        getIntent().putExtra("forum_id", str);
        getIntent().putExtra("forum_name", str2);
        getIntent().putExtra("thread_id", str3);
        getIntent().putExtra(MANAGER_USER_ID, str4);
        getIntent().putExtra("user_name", str5);
        getIntent().putExtra("post_id", str7);
        getIntent().putExtra("name_show", str6);
        getIntent().putExtra(IntentConfig.PORTRAIT, str8);
    }
}
