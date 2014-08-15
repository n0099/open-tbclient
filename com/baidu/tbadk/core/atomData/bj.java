package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
public class bj extends com.baidu.tbadk.core.frameworkData.a {
    private UserData a;

    public bj(Context context, long j, String str, String str2, int i) {
        this(context, j, str, str2, i, 1);
    }

    public bj(Context context, long j, String str, String str2, int i, int i2) {
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

    public bj(Context context, long j, String str, String str2, int i, String str3, String str4) {
        this(context, j, str, str2, i);
        Intent intent = getIntent();
        intent.putExtra("key_leave_msg", str3);
        intent.putExtra("key_share_msg", str4);
    }

    public UserData a() {
        return this.a;
    }
}
