package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.c;
/* loaded from: classes.dex */
public class GroupLevelActivityConfig extends c {
    public static final String GROUP_ID = "group_id";
    public static final String IS_MEM = "is_mem";

    public GroupLevelActivityConfig(Context context, long j, boolean z) {
        super(context);
        Intent intent = getIntent();
        intent.putExtra("group_id", j);
        intent.putExtra(IS_MEM, z);
    }
}
