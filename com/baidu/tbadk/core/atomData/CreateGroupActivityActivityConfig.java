package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.im.data.GroupActivityData;
/* loaded from: classes3.dex */
public class CreateGroupActivityActivityConfig extends IntentConfig {
    public static final String GROUP_ACTIVITY_AREA = "area";
    public static final String GROUP_ACTIVITY_CONTENT = "content";
    public static final String GROUP_ACTIVITY_GID = "gid";
    public static final String GROUP_ACTIVITY_ID = "aid";
    public static final String GROUP_ACTIVITY_ISEDIT = "isedit";
    public static final String GROUP_ACTIVITY_NAME = "name";
    public static final String GROUP_ACTIVITY_TIME = "time";

    public CreateGroupActivityActivityConfig(Context context, long j) {
        super(context);
        getIntent().putExtra("gid", j);
        getIntent().putExtra(GROUP_ACTIVITY_ISEDIT, false);
    }

    public CreateGroupActivityActivityConfig(Activity activity, long j, GroupActivityData groupActivityData, int i2) {
        super(activity);
        getIntent().putExtra("gid", j);
        getIntent().putExtra(GROUP_ACTIVITY_ISEDIT, true);
        getIntent().putExtra("aid", groupActivityData.getActivityId());
        getIntent().putExtra("name", groupActivityData.getgActivityTitle());
        getIntent().putExtra("time", groupActivityData.getgActivityTime());
        getIntent().putExtra(GROUP_ACTIVITY_AREA, groupActivityData.getgActivityArea());
        getIntent().putExtra("content", groupActivityData.getgActivityContent());
        setRequestCode(i2);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
