package com.baidu.live.tbadk.core.atomdata;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentAction;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
@Deprecated
/* loaded from: classes11.dex */
public class RegisterActivityConfig extends IntentConfig {
    public static final String FAST_REG_USER_TYPE = "fast_reg_user_type";
    public static final String LOGIN_USER = "login_user";
    public static final String REGIST_USER = "regist_user";

    public RegisterActivityConfig(Context context) {
        super(context);
    }

    public RegisterActivityConfig(Context context, int i, int i2) {
        super(context);
        getIntent().putExtra("from", i);
        setRequestCode(i2);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public RegisterActivityConfig(Context context, int i, boolean z) {
        super(context);
        getIntent().putExtra("from", i);
        getIntent().putExtra("close", z);
    }

    public RegisterActivityConfig(Context context, int i, boolean z, int i2) {
        super(context);
        getIntent().putExtra("from", i);
        getIntent().putExtra("close", z);
        setRequestCode(i2);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
