package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class AddFriendActivityConfig extends a {
    public static final String DEFAULT_MESSAGE = "default_message";
    public static final String FROM = "from";
    public static final String IS_USER_CLIENT_LOWER = "is_user_client_lower";
    public static final String MSG = "msg";
    public static final String TYPE_ADD_FRD = "add_frd";
    public static final String TYPE_AT_ME = "at_me";
    public static final String TYPE_FAVOR_LIST = "favor_list";
    public static final String TYPE_FOCUS = "focus";
    public static final String TYPE_FOCUS_RECOM = "focus_recom";
    public static final String TYPE_FRS_HEAD = "frs_head";
    public static final String TYPE_FRS_RECOM = "frs_recom";
    public static final String TYPE_IM_GROUP = "imgroup";
    public static final String TYPE_NEW_FRD = "new_frd";
    public static final String TYPE_PB_FLOOR = "pb_floor";
    public static final String TYPE_PB_HEAD = "pb_head";
    public static final String TYPE_REPLY_ME = "reply_pg";
    public static final String TYPE_SEARCH = "search";

    public AddFriendActivityConfig(Context context, String str, String str2, String str3, String str4, boolean z, String str5) {
        super(context);
        getIntent().putExtra(a.USER_ID, str);
        getIntent().putExtra(a.NAME_SHOW, str2);
        getIntent().putExtra(a.PORTRAIT, str3);
        getIntent().putExtra("from", str4);
        getIntent().putExtra(IS_USER_CLIENT_LOWER, z);
        getIntent().putExtra("st_type", str5);
    }

    public AddFriendActivityConfig(Context context, String str, String str2, String str3, String str4, boolean z, String str5, String str6) {
        super(context);
        getIntent().putExtra(a.USER_ID, str);
        getIntent().putExtra(a.NAME_SHOW, str2);
        getIntent().putExtra(a.PORTRAIT, str3);
        getIntent().putExtra("from", str4);
        getIntent().putExtra(IS_USER_CLIENT_LOWER, z);
        getIntent().putExtra("st_type", str5);
        getIntent().putExtra(DEFAULT_MESSAGE, str6);
    }
}
