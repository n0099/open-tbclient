package com.baidu.tbadk.core.b;

import android.content.Context;
/* loaded from: classes.dex */
public final class b extends com.baidu.tbadk.core.frameworkData.a {
    public static int a = 0;
    public static int b = 1;

    public b(Context context, String str, int i, int i2) {
        super(context);
        if (context != null) {
            d().putExtra("groupID", str);
            d().putExtra("alreadJoinCount", i);
            d().putExtra("canJoinCount", i2);
        }
    }

    public b(Context context, String str, int i, int i2, long j, String str2) {
        super(context);
        if (context != null) {
            d().putExtra("groupID", str);
            d().putExtra("alreadJoinCount", i);
            d().putExtra("canJoinCount", i2);
            d().putExtra("inviteUserId", j);
            d().putExtra("defaultUserMsg", str2);
            d().putExtra("joinType", b);
        }
    }

    public b(Context context, String str, long j, String str2) {
        super(context);
        if (context != null) {
            d().putExtra("groupID", str);
            d().putExtra("inviteUserId", j);
            d().putExtra("defaultUserMsg", str2);
            d().putExtra("joinType", b);
        }
    }
}
