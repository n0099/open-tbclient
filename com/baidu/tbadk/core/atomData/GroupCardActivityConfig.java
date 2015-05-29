package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.c;
/* loaded from: classes.dex */
public class GroupCardActivityConfig extends c {
    public static String GROUP_PORTRAIT = "groupportrait";

    public GroupCardActivityConfig(Context context, long j, String str, String str2) {
        super(context);
        getIntent().putExtra("group_id", j);
        getIntent().putExtra("group_name", str);
        getIntent().putExtra(GROUP_PORTRAIT, str2);
    }
}
