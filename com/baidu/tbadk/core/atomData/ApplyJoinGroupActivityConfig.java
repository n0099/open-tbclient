package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class ApplyJoinGroupActivityConfig extends IntentConfig {
    public static final String ALREADY_JOIN_COUNT = "alreadJoinCount";
    public static final String CAN_JOIN_COUNT = "canJoinCount";
    public static final String DEFAULT_USER_MSG = "defaultUserMsg";
    public static final String GROUP_ID = "groupID";
    public static final String INVITE_USER_ID = "inviteUserId";
    public static int JOINTYPE_DEFAULT = 0;
    public static int JOINTYPE_INVITE = 1;
    public static final String JOIN_TYPE = "joinType";

    public ApplyJoinGroupActivityConfig(Context context, String str, int i, int i2) {
        super(context);
        if (context == null) {
            return;
        }
        getIntent().putExtra(GROUP_ID, str);
        getIntent().putExtra(ALREADY_JOIN_COUNT, i);
        getIntent().putExtra(CAN_JOIN_COUNT, i2);
    }

    public ApplyJoinGroupActivityConfig(Context context, String str, int i, int i2, long j, String str2) {
        super(context);
        if (context == null) {
            return;
        }
        getIntent().putExtra(GROUP_ID, str);
        getIntent().putExtra(ALREADY_JOIN_COUNT, i);
        getIntent().putExtra(CAN_JOIN_COUNT, i2);
        getIntent().putExtra(INVITE_USER_ID, j);
        getIntent().putExtra(DEFAULT_USER_MSG, str2);
        getIntent().putExtra(JOIN_TYPE, JOINTYPE_INVITE);
    }

    public ApplyJoinGroupActivityConfig(Context context, String str, long j, String str2) {
        super(context);
        if (context == null) {
            return;
        }
        getIntent().putExtra(GROUP_ID, str);
        getIntent().putExtra(INVITE_USER_ID, j);
        getIntent().putExtra(DEFAULT_USER_MSG, str2);
        getIntent().putExtra(JOIN_TYPE, JOINTYPE_INVITE);
    }
}
