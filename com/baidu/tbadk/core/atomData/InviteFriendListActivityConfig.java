package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class InviteFriendListActivityConfig extends a {
    public static final String GROUP_ID = "groupid";
    public static final String IS_FROM_INVITE_CHAT = "isfrominvitechat";
    public static final String USER_GID = "gid";
    private boolean isFromInviteChat;

    public InviteFriendListActivityConfig(Context context, boolean z) {
        super(context);
        this.isFromInviteChat = z;
        getIntent().putExtra(IS_FROM_INVITE_CHAT, this.isFromInviteChat);
    }

    public InviteFriendListActivityConfig(Context context, int i, int i2) {
        super(context);
        Intent intent = getIntent();
        intent.putExtra("gid", i);
        intent.putExtra(GROUP_ID, i2);
    }
}
