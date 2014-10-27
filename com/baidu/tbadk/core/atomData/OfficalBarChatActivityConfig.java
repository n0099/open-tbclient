package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class OfficalBarChatActivityConfig extends a {
    private UserData mUserData;

    public OfficalBarChatActivityConfig(Context context, long j, String str, String str2, int i) {
        super(context);
        this.mUserData = null;
        UserData userData = new UserData(j, str, str2, i);
        this.mUserData = userData;
        Intent intent = getIntent();
        intent.putExtra(a.IS_ACCEPT_NOTIFY, true);
        intent.putExtra("user", userData);
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
    }

    public UserData getUserData() {
        return this.mUserData;
    }
}
