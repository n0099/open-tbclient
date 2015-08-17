package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class InviteFriendListActivityConfig extends IntentConfig {
    public static final String GROUP_ID = "groupid";
    public static final String IS_FROM_INVITE_CHAT = "isfrominvitechat";
    public static final String KEY_FINISH_ACTIVITY = "key_finish_activity";
    public static final String USER_GID = "gid";
    private boolean isFromInviteChat;

    public InviteFriendListActivityConfig(Context context, boolean z) {
        this(context, z, false);
    }

    public InviteFriendListActivityConfig(Context context, boolean z, boolean z2) {
        super(context);
        this.isFromInviteChat = z;
        Intent intent = getIntent();
        intent.putExtra(IS_FROM_INVITE_CHAT, this.isFromInviteChat);
        intent.putExtra(KEY_FINISH_ACTIVITY, z2);
    }

    public InviteFriendListActivityConfig(Context context, int i, int i2) {
        super(context);
        Intent intent = getIntent();
        intent.putExtra("gid", i);
        intent.putExtra(GROUP_ID, i2);
    }
}
