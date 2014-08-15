package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
/* loaded from: classes.dex */
public class y extends com.baidu.tbadk.core.frameworkData.a {
    public y(Context context, long j, int i) {
        super(context);
        getIntent().putExtra(com.baidu.tbadk.core.frameworkData.a.GROUP_ID, j);
        getIntent().putExtra("activity_from", i);
        if (!(context instanceof Activity)) {
            getIntent().addFlags(268435456);
        }
    }

    public y(Context context, long j, int i, String str, long j2) {
        super(context);
        getIntent().putExtra(com.baidu.tbadk.core.frameworkData.a.GROUP_ID, j);
        getIntent().putExtra("activity_from", i);
        getIntent().putExtra("default_invite_msg", str);
        getIntent().putExtra("inviter_user_id", j2);
        getIntent().putExtra("join_type", c.b);
        if (!(context instanceof Activity)) {
            getIntent().addFlags(268435456);
        }
    }
}
