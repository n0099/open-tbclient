package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class BigVEditModuleActivityConfig extends IntentConfig {
    public static final int ADD_ENTER = 1;
    public static final int EDIT_RENTER = 2;
    public static final String ENTER_FLAG = "enter_flag";
    public static final String MODULE_ID = "module_id";
    public static final String MODULE_NAME = "module_name";
    public static final String USERS_NAME = "users_name";
    public static final String USER_ID = "user_id";

    public BigVEditModuleActivityConfig(Context context, long j, String str, int i, String str2) {
        super(context);
        getIntent().putExtra(ENTER_FLAG, i);
        getIntent().putExtra("user_id", j);
        getIntent().putExtra("module_name", str);
        getIntent().putExtra("users_name", str2);
    }

    public BigVEditModuleActivityConfig(Context context, long j, long j2, String str, String str2, int i) {
        super(context);
        getIntent().putExtra(ENTER_FLAG, i);
        getIntent().putExtra("user_id", j);
        getIntent().putExtra("module_id", j2);
        getIntent().putExtra("module_name", str);
        getIntent().putExtra("users_name", str2);
    }
}
