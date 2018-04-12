package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes2.dex */
public class GroupLevelActivityConfig extends IntentConfig {
    public static final String GROUP_ID = "group_id";
    public static final String IS_MEM = "is_mem";

    public GroupLevelActivityConfig(Context context, long j, boolean z) {
        super(context);
        Intent intent = getIntent();
        intent.putExtra("group_id", j);
        intent.putExtra("is_mem", z);
    }
}
