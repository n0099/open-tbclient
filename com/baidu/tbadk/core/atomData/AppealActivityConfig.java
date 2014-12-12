package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class AppealActivityConfig extends a {
    public static final String FORUM_ID = "forum_id";
    public static final String USER_ID = "user_id";
    public static final String USER_NAME = "user_name";

    public AppealActivityConfig(Context context, String str, String str2, String str3) {
        super(context);
        getIntent().putExtra("forum_id", str);
        getIntent().putExtra("user_id", str2);
        getIntent().putExtra("user_name", str3);
    }
}
