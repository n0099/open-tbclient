package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.c;
/* loaded from: classes.dex */
public class ForbidActivityConfig extends c {
    public static final String MANAGER_USER_ID = "bar_manager_user_id";

    public ForbidActivityConfig(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        super(context);
        getIntent().putExtra("forum_id", str);
        getIntent().putExtra("forum_name", str2);
        getIntent().putExtra("thread_id", str3);
        getIntent().putExtra(MANAGER_USER_ID, str4);
        getIntent().putExtra("user_name", str5);
        getIntent().putExtra("post_id", str6);
    }
}
