package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes15.dex */
public class CreateGroupMainActivityConfig extends IntentConfig {
    public static final String CANCREATECOMMONGROUP = "canCreateCommonGroup";
    public static final String CANCRRATEOFFICIALGROUP = "canCreateOfficialGroup";
    public static final String CREATECOMMONGROUPTIP = "createCommonGroupTip";
    public static final String CREATEGROUPOFFICIALTIP = "createGroupOfficialTip";
    public static final String FORUMID = "forumid";
    public static final String NUM_CREATE_GROUP_NORMAL = "num_create_group_normal";
    public static final String NUM_CREATE_GROUP_OFFICAL = "num_create_group_offical";
    public static final String NUM_CREATE_GROUP_PERSONAL = "num_create_group_private";

    public CreateGroupMainActivityConfig(Context context, boolean z, boolean z2, String str, String str2, int i, int i2, int i3, int i4) {
        super(context);
        getIntent().putExtra(CANCRRATEOFFICIALGROUP, z);
        getIntent().putExtra(CANCREATECOMMONGROUP, z2);
        getIntent().putExtra(CREATEGROUPOFFICIALTIP, str);
        getIntent().putExtra(CREATECOMMONGROUPTIP, str2);
        getIntent().putExtra("num_create_group_normal", i2);
        getIntent().putExtra("num_create_group_offical", i3);
        getIntent().putExtra("num_create_group_private", i4);
        getIntent().putExtra("forumid", i);
    }
}
