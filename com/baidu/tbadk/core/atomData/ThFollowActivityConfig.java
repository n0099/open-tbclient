package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class ThFollowActivityConfig extends IntentConfig {
    public static final int ACTIVITY_TYPE_PRAISE = 1;
    public static final int ACTIVITY_TYPE_SIGNUP = 2;
    public static final String PARAM_ALBUMID_KEY = "albumId";
    public static final String PARAM_COUNT_KEY = "count";
    public static final String PARAM_HID_KEY = "hid";
    public static final String PARAM_TYPE_KEY = "display_type";

    public ThFollowActivityConfig(Context context) {
        super(context);
        setIntentAction(IntentAction.Activity);
    }

    public void initFollowActivityZanConfig(int i, long j, int i2) {
        getIntent().putExtra(PARAM_TYPE_KEY, i);
        getIntent().putExtra(PARAM_HID_KEY, j);
        getIntent().putExtra("count", i2);
        setIntentAction(IntentAction.Activity);
    }

    public void initFollowActivityConfig(int i, long j, int i2) {
        getIntent().putExtra(PARAM_TYPE_KEY, i);
        getIntent().putExtra(PARAM_ALBUMID_KEY, j);
        getIntent().putExtra("count", i2);
        setIntentAction(IntentAction.Activity);
    }
}
