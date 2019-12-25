package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes5.dex */
public class GroupCardActivityConfig extends IntentConfig {
    public static String GROUP_PORTRAIT = "groupportrait";

    public GroupCardActivityConfig(Context context, long j, String str, String str2) {
        super(context);
        getIntent().putExtra("group_id", j);
        getIntent().putExtra("group_name", str);
        getIntent().putExtra(GROUP_PORTRAIT, str2);
    }
}
