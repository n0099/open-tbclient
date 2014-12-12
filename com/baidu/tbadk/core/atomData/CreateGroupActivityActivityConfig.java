package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.a;
import com.baidu.tieba.im.data.GroupActivityData;
/* loaded from: classes.dex */
public class CreateGroupActivityActivityConfig extends a {
    public static final String GROUP_ACTIVITY_AREA = "area";
    public static final String GROUP_ACTIVITY_CONTENT = "content";
    public static final String GROUP_ACTIVITY_GID = "gid";
    public static final String GROUP_ACTIVITY_ID = "aid";
    public static final String GROUP_ACTIVITY_ISEDIT = "isedit";
    public static final String GROUP_ACTIVITY_NAME = "name";
    public static final String GROUP_ACTIVITY_TIME = "time";

    public CreateGroupActivityActivityConfig(Context context, int i) {
        super(context);
        getIntent().putExtra("gid", i);
        getIntent().putExtra(GROUP_ACTIVITY_ISEDIT, false);
    }

    public CreateGroupActivityActivityConfig(Activity activity, int i, GroupActivityData groupActivityData, int i2) {
        super(activity);
        getIntent().putExtra("gid", i);
        getIntent().putExtra(GROUP_ACTIVITY_ISEDIT, true);
        getIntent().putExtra(GROUP_ACTIVITY_ID, groupActivityData.getActivityId());
        getIntent().putExtra("name", groupActivityData.getgActivityTitle());
        getIntent().putExtra(GROUP_ACTIVITY_TIME, groupActivityData.getgActivityTime());
        getIntent().putExtra(GROUP_ACTIVITY_AREA, groupActivityData.getgActivityArea());
        getIntent().putExtra(GROUP_ACTIVITY_CONTENT, groupActivityData.getgActivityContent());
        setRequestCode(i2);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
