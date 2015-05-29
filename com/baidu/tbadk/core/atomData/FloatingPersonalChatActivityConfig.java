package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.c;
import java.util.List;
/* loaded from: classes.dex */
public class FloatingPersonalChatActivityConfig extends c {
    public static final int IS_FRIEND = 1;
    public static final int IS_NOT_FRIEND = 0;
    public static final String KEY_IS_FRIEND = "key_is_friend";
    public static final String KEY_LEAVE_MSG = "key_leave_msg";
    public static final String KEY_SHARE_MSG = "key_share_msg";
    public static final String KEY_USER_ID = "key_user_id";
    public static final String KEY_USER_NAME = "key_user_name";
    public static final String KEY_USER_PORTAIT = "key_user_portait";
    public static int currIndex;
    private List<UserData> mUserDataList;

    public FloatingPersonalChatActivityConfig(Context context, List<UserData> list) {
        this(context, list, 1);
    }

    public FloatingPersonalChatActivityConfig(Context context, List<UserData> list, int i) {
        super(context);
        this.mUserDataList = null;
        if (list != null && list.size() != 0) {
            this.mUserDataList = list;
            Intent intent = getIntent();
            intent.putExtra(c.IS_ACCEPT_NOTIFY, true);
            intent.putExtra("chat_mode", 1);
            intent.putExtra("user", list.get(list.size() - 1));
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            intent.putExtra("key_is_friend", i);
        }
    }

    public List<UserData> getUserDataList() {
        return this.mUserDataList;
    }

    public UserData getUserData() {
        if (this.mUserDataList == null || this.mUserDataList.size() == 0) {
            return null;
        }
        return this.mUserDataList.get(0);
    }
}
