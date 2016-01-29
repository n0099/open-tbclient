package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class MissonDetailsActivityConfig extends IntentConfig {
    public static final String CURRENT_LEVEL = "current_level";
    public static final String IS_UPGRADE_SUCCESS = "is_upgrade_success";

    public MissonDetailsActivityConfig(Context context, int i, int i2, String str, String str2) {
        super(context);
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
        getIntent().putExtra(CURRENT_LEVEL, i2);
        getIntent().putExtra(IntentConfig.PORTRAIT, str);
        getIntent().putExtra("user_name", str2);
    }
}
