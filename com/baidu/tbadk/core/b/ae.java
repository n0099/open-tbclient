package com.baidu.tbadk.core.b;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
public final class ae extends com.baidu.tbadk.core.frameworkData.a {
    private UserData a;

    public ae(Context context, long j, String str, String str2, int i) {
        super(context);
        this.a = null;
        UserData userData = new UserData(j, str, str2, 0);
        this.a = userData;
        Intent d = d();
        d.putExtra("is_accept_notify", true);
        d.putExtra("user", userData);
        d.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
    }

    public final UserData b() {
        return this.a;
    }
}
