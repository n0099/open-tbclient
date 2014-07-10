package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
public class bc extends com.baidu.tbadk.core.frameworkData.a {
    private UserData a;

    public bc(Context context, long j, String str, String str2, int i) {
        this(context, j, str, str2, i, 1);
    }

    public bc(Context context, long j, String str, String str2, int i, int i2) {
        super(context);
        this.a = null;
        UserData userData = new UserData(j, str, str2, i);
        this.a = userData;
        Intent intent = getIntent();
        intent.putExtra(com.baidu.tbadk.core.frameworkData.a.IS_ACCEPT_NOTIFY, true);
        intent.putExtra("chat_mode", 1);
        intent.putExtra("user", userData);
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
        intent.putExtra("key_is_friend", i2);
    }

    public UserData a() {
        return this.a;
    }
}
