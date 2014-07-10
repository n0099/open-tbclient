package com.baidu.tbadk.core.atomData;

import android.content.Context;
/* loaded from: classes.dex */
public class c extends com.baidu.tbadk.core.frameworkData.a {
    public static int a = 0;
    public static int b = 1;

    public c(Context context, String str, int i, int i2) {
        super(context);
        if (context != null) {
            getIntent().putExtra("groupID", str);
            getIntent().putExtra("alreadJoinCount", i);
            getIntent().putExtra("canJoinCount", i2);
        }
    }

    public c(Context context, String str, int i, int i2, long j, String str2) {
        super(context);
        if (context != null) {
            getIntent().putExtra("groupID", str);
            getIntent().putExtra("alreadJoinCount", i);
            getIntent().putExtra("canJoinCount", i2);
            getIntent().putExtra("inviteUserId", j);
            getIntent().putExtra("defaultUserMsg", str2);
            getIntent().putExtra("joinType", b);
        }
    }

    public c(Context context, String str, long j, String str2) {
        super(context);
        if (context != null) {
            getIntent().putExtra("groupID", str);
            getIntent().putExtra("inviteUserId", j);
            getIntent().putExtra("defaultUserMsg", str2);
            getIntent().putExtra("joinType", b);
        }
    }
}
