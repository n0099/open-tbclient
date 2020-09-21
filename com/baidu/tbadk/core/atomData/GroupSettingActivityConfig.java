package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes20.dex */
public class GroupSettingActivityConfig extends IntentConfig {
    public static final String INTENT_DATA_GROUP_FLAG = "intent_data_group_flag";
    public static final String INTENT_DATA_GROUP_ID = "intent_data_group_id";
    public static final String INTENT_DATA_GROUP_NAME = "intent_data_group_name";
    public static final String INTENT_DATA_IS_GROUP_MASTER = "intent_data_is_group_master";

    public GroupSettingActivityConfig(Context context, int i, String str, String str2, boolean z, int i2) {
        super(context);
        getIntent().putExtra(INTENT_DATA_GROUP_NAME, str);
        getIntent().putExtra(INTENT_DATA_GROUP_ID, str2);
        getIntent().putExtra(INTENT_DATA_IS_GROUP_MASTER, z);
        getIntent().putExtra(INTENT_DATA_GROUP_FLAG, i2);
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
