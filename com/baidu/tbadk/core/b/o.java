package com.baidu.tbadk.core.b;

import android.app.Activity;
import android.content.Context;
/* loaded from: classes.dex */
public final class o extends com.baidu.tbadk.core.frameworkData.a {
    public o(Context context, long j, int i) {
        super(context);
        d().putExtra("group_id", j);
        d().putExtra("activity_from", i);
        if (!(context instanceof Activity)) {
            d().addFlags(268435456);
        }
    }

    public o(Context context, long j, int i, String str, long j2) {
        super(context);
        d().putExtra("group_id", j);
        d().putExtra("activity_from", 7);
        d().putExtra("default_invite_msg", str);
        d().putExtra("inviter_user_id", j2);
        d().putExtra("join_type", b.b);
        if (!(context instanceof Activity)) {
            d().addFlags(268435456);
        }
    }
}
