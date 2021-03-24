package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class OfficalBarChatActivityConfig extends IntentConfig {
    public static boolean IS_SUPPORT_OFFICIAL_CHAT = false;
    public static final String USER_TYPE = "user_type";
    public UserData mUserData;

    public OfficalBarChatActivityConfig(Context context, long j, String str, String str2, int i) {
        super(context);
        this.mUserData = null;
        UserData userData = new UserData(j, str, str2, i);
        this.mUserData = userData;
        Intent intent = getIntent();
        intent.putExtra(IntentConfig.IS_ACCEPT_NOTIFY, true);
        intent.putExtra("user", userData);
        intent.putExtra("user_type", 1);
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public OfficalBarChatActivityConfig(Context context, long j, String str, String str2, int i, int i2) {
        super(context);
        this.mUserData = null;
        UserData userData = new UserData(j, str, str2, i);
        this.mUserData = userData;
        Intent intent = getIntent();
        intent.putExtra(IntentConfig.IS_ACCEPT_NOTIFY, true);
        intent.putExtra("user", userData);
        intent.putExtra("user_type", i2);
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
    }
}
