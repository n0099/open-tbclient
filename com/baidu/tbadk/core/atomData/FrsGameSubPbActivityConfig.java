package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class FrsGameSubPbActivityConfig extends IntentConfig {
    public static final String ARG_FORUM_ID = "arg_forum_id";
    public static final String ARG_MAIN_TOWER_ID = "arg_main_tower_id";
    public static final int START_ACTIVITY_REQUEST_CODE = 1001;

    public FrsGameSubPbActivityConfig(Context context, int i, String str) {
        super(context);
        getIntent().putExtra(ARG_FORUM_ID, i);
        getIntent().putExtra(ARG_MAIN_TOWER_ID, str);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(1001);
    }
}
