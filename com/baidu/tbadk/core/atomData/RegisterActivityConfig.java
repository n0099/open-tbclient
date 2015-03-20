package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class RegisterActivityConfig extends a {
    public static final String FAST_REG_USER_TYPE = "fast_reg_user_type";
    public static final String LOGIN_USER = "login_user";
    public static final String REGIST_USER = "regist_user";

    public RegisterActivityConfig(Context context) {
        super(context);
    }

    public RegisterActivityConfig(Context context, int i) {
        super(context);
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
