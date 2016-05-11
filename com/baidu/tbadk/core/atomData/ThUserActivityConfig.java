package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class ThUserActivityConfig extends IntentConfig {
    public static final String PARAM_UID_KEY = "uid";
    public static final int TH_HI_USER_ACTIVITY_COLLECTION = 5;
    public static final int TH_HI_USER_ACTIVITY_CREATE = 4;
    public static final int TH_HI_USER_ACTIVITY_JOIN = 3;
    public static final int TH_HI_USER_HOME = 1;
    public static final int TH_HI_USER_MORE = 2;

    public ThUserActivityConfig(Context context) {
        super(context);
        setIntentAction(IntentAction.Activity);
    }

    public void initUserActivityConfig(String str) {
        getIntent().putExtra("uid", str);
        setIntentAction(IntentAction.Activity);
    }
}
