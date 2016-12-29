package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class PersonalChatActivityConfig extends IntentConfig {
    public static final int IS_FRIEND = 1;
    public static final int IS_NOT_FRIEND = 0;
    public static final String KEY_IS_FRIEND = "key_is_friend";
    public static final String KEY_LEAVE_MSG = "key_leave_msg";
    public static final String KEY_REPLY_CONTENT = "key_reply_content";
    public static final String KEY_SHARE_MSG = "key_share_msg";
    public static final String KEY_USER_ID = "key_user_id";
    public static final String KEY_USER_NAME = "key_user_name";
    public static final String KEY_USER_PORTAIT = "key_user_portait";
    private UserData mUserData;

    public PersonalChatActivityConfig(Context context, long j, String str, String str2, int i) {
        this(context, j, str, str2, i, 1);
    }

    public PersonalChatActivityConfig(Context context, long j, String str, String str2, int i, int i2) {
        super(context);
        this.mUserData = null;
        UserData userData = new UserData(j, str, str2, i);
        this.mUserData = userData;
        Intent intent = getIntent();
        intent.putExtra(IntentConfig.IS_ACCEPT_NOTIFY, true);
        intent.putExtra("chat_mode", 1);
        intent.putExtra("user", userData);
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
        intent.putExtra(KEY_IS_FRIEND, i2);
    }

    public PersonalChatActivityConfig(Context context, long j, String str, String str2, int i, int i2, String str3) {
        super(context);
        this.mUserData = null;
        UserData userData = new UserData(j, str, str2, i);
        this.mUserData = userData;
        Intent intent = getIntent();
        intent.putExtra(IntentConfig.IS_ACCEPT_NOTIFY, true);
        intent.putExtra("chat_mode", 1);
        intent.putExtra("user", userData);
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
        intent.putExtra(KEY_IS_FRIEND, i2);
        intent.putExtra(KEY_REPLY_CONTENT, str3);
    }

    public PersonalChatActivityConfig(Context context, long j, String str, String str2, int i, String str3, String str4) {
        this(context, j, str, str2, i);
        Intent intent = getIntent();
        intent.putExtra(KEY_LEAVE_MSG, str3);
        intent.putExtra(KEY_SHARE_MSG, str4);
    }

    public UserData getUserData() {
        return this.mUserData;
    }
}
