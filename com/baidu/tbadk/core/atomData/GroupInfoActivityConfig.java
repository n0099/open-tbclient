package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes2.dex */
public class GroupInfoActivityConfig extends IntentConfig {
    public static final String ACTION_FROM = "activity_from";
    public static final String DEFAULT_INVITE_MSG = "default_invite_msg";
    public static final int FROM_FORUM_GROUP_HOT = 5;
    public static final int FROM_FORUM_GROUP_OFFICIAL = 6;
    public static final int FROM_FORUM_GROUP_RECOMMEND = 4;
    public static final int FROM_GROUP_TALK = 3;
    public static final int FROM_INVITE_TALK = 7;
    public static final int FROM_OTHER = 0;
    public static final int FROM_USER_GROUP = 1;
    public static final String GROUP_ID = "group_id";
    public static final String INVITE_USER_ID = "inviter_user_id";
    public static final int JOIN_BUTTON_DISABLE_MAX_DURATION = 60000;
    public static final String JOIN_TYPE = "join_type";
    public static final String REQUEST_CODE = "requestCode";

    public GroupInfoActivityConfig(Context context, long j, int i) {
        super(context);
        getIntent().putExtra("group_id", j);
        getIntent().putExtra("activity_from", i);
        if (!(context instanceof Activity)) {
            getIntent().addFlags(268435456);
        }
    }

    public GroupInfoActivityConfig(Context context, long j, int i, String str, long j2) {
        super(context);
        getIntent().putExtra("group_id", j);
        getIntent().putExtra("activity_from", i);
        getIntent().putExtra("default_invite_msg", str);
        getIntent().putExtra("inviter_user_id", j2);
        getIntent().putExtra("join_type", ApplyJoinGroupActivityConfig.JOINTYPE_INVITE);
        if (!(context instanceof Activity)) {
            getIntent().addFlags(268435456);
        }
    }

    public GroupInfoActivityConfig(int i, Activity activity, long j, int i2) {
        super(activity);
        getIntent().putExtra(REQUEST_CODE, i);
        getIntent().putExtra("group_id", j);
        getIntent().putExtra("activity_from", i2);
        if (!(activity instanceof Activity)) {
            getIntent().addFlags(268435456);
        }
    }
}
