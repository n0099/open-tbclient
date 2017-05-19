package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class AlaCharmCardActivityConfig extends IntentConfig {
    public static final String CHARM_VALUE = "charm_value";
    public static final String GROUP_ID = "group_id";
    public static final String LIVE_ID = "live_id";
    public static final String LIVE_OWNER_FLAG = "live_owner_flag";
    public static final String USER_ID = "user_id";
    public static final String USER_NAME = "user_name";

    public AlaCharmCardActivityConfig(Context context, String str, String str2, String str3, String str4, String str5, boolean z) {
        super(context);
        getIntent().putExtra("user_name", str);
        getIntent().putExtra("user_id", str2);
        getIntent().putExtra(CHARM_VALUE, str3);
        getIntent().putExtra("group_id", str4);
        getIntent().putExtra("live_id", str5);
        getIntent().putExtra(LIVE_OWNER_FLAG, z);
        setRequestCode(25015);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
