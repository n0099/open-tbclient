package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes6.dex */
public class CreateGroupStepActivityConfig extends IntentConfig {
    public static final String FORUMID = "forumid";
    public static final String GROUP_TYPE = "group_type";
    public static final int GROUP_TYPE_COMMON = 3;
    public static final int GROUP_TYPE_MSG = 1;
    public static final int GROUP_TYPE_OFFICIAL = 4;
    public static final int GROUP_TYPE_OPERA = 5;
    public static final int GROUP_TYPE_PRIVATE = 2;
    public static final String INTENT_SOURCE_FROM = "Intent_Source_From";
    public static final String NUM_CREATE_GROUP_NORMAL = "num_create_group_normal";
    public static final String NUM_CREATE_GROUP_OFFICAL = "num_create_group_offical";
    public static final String NUM_CREATE_GROUP_PERSONAL = "num_create_group_private";
    public static final int SOURCE_FROM_BAR = 1013;
    public static final int SOURCE_FROM_MY = 1012;
    public static final int SOURCE_FROM_NEAR = 1011;
    public static final int SOURCE_FROM_OTHER = 1014;

    public CreateGroupStepActivityConfig(Context context, int i, int i2, int i3, int i4, int i5, int i6) {
        super(context);
        Intent intent = getIntent();
        intent.putExtra(GROUP_TYPE, i);
        intent.putExtra("forumid", i2);
        intent.putExtra(INTENT_SOURCE_FROM, i3);
        intent.putExtra("num_create_group_normal", i4);
        intent.putExtra("num_create_group_private", i6);
        intent.putExtra("num_create_group_offical", i5);
    }
}
