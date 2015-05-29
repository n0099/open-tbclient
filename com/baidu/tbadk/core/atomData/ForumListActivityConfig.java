package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.c;
/* loaded from: classes.dex */
public class ForumListActivityConfig extends c {
    public static final String KEY_MENU_TYPE = "menu_type";
    public static final String KEY_PARENT_MENU_ID = "parent_menu_id";
    public static final String KEY_PARENT_MENU_NAME = "parent_menu_name";
    public static final String TYPE_FROM_FRS = "2";

    public ForumListActivityConfig(Context context, String str, String str2, String str3) {
        super(context);
        getIntent().putExtra(KEY_PARENT_MENU_NAME, str);
        getIntent().putExtra(KEY_MENU_TYPE, str2);
        getIntent().putExtra(KEY_PARENT_MENU_ID, str3);
    }
}
