package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import com.baidu.tbadk.core.frameworkData.c;
/* loaded from: classes.dex */
public class GroupActivityActivityConfig extends c {
    public static final String ACTIVITY_ID = "activity_id";
    public static final String FROM = "from";
    public static final int FROM_GROUP_CHAT = 2;
    public static final int FROM_GROUP_INFO = 0;
    public static final int FROM_GROUP_UPDATE = 1;
    public static final String GROUP_ID = "group_id";

    public GroupActivityActivityConfig(Context context, int i, long j, int i2) {
        super(context);
        getIntent().putExtra(ACTIVITY_ID, i);
        getIntent().putExtra("group_id", j);
        getIntent().putExtra("from", i2);
        if (!(context instanceof Activity)) {
            getIntent().addFlags(268435456);
        }
    }
}
