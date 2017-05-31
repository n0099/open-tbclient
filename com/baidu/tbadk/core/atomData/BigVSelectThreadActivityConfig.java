package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class BigVSelectThreadActivityConfig extends IntentConfig {
    public static final String ENTER_PARMAS = "enter_parmas";
    public static final String HAS_ADD_COUNT = "has_add_count";
    public static final String MODULE_ID = "module_id";
    public static final String MODULE_NAME = "module_name";
    public static final String OP_TYPE = "op_type";
    public static final String USERS_NAME = "users_name";
    public static final String USER_ID = "user_id";

    public BigVSelectThreadActivityConfig(Context context, long j, long j2, String str, String str2, int i, int i2) {
        super(context);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i2);
        getIntent().putExtra("op_type", i);
        getIntent().putExtra("user_id", j);
        getIntent().putExtra("users_name", str2);
        getIntent().putExtra("module_id", j2);
        getIntent().putExtra("module_name", str);
    }

    public BigVSelectThreadActivityConfig(Context context, long j, String str, int i, int i2, int i3, long j2, String str2) {
        super(context);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i3);
        getIntent().putExtra("module_id", j);
        getIntent().putExtra("module_name", str);
        getIntent().putExtra("op_type", i);
        getIntent().putExtra(HAS_ADD_COUNT, i2);
        getIntent().putExtra("user_id", j2);
        getIntent().putExtra("users_name", str2);
    }
}
