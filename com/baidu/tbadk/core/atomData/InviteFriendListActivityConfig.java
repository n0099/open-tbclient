package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class InviteFriendListActivityConfig extends a {
    public static final String IS_FROM_INVITE_CHAT = "isfrominvitechat";
    private boolean isFromInviteChat;

    public InviteFriendListActivityConfig(Context context, boolean z) {
        super(context);
        this.isFromInviteChat = z;
        getIntent().putExtra(IS_FROM_INVITE_CHAT, this.isFromInviteChat);
    }
}
