package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class LoginActivityConfig extends a {
    public static final String ACCOUNT = "account";
    public static final String CLOSE = "close";
    public static final String HAS_EXIT_DIALOG = "has_exit_dialog";
    public static final String INFO = "info";
    public static final String LOGIN_TYPE = "login_type";
    public static final String TYPE_LOGIN = "type_login";
    public static final int TYPE_LOGIN_MOBILE = 1;
    public static final int TYPE_LOGIN_NORMAL = 0;

    public LoginActivityConfig(Context context, int i, String str, int i2) {
        super(context);
        getIntent().putExtra(HAS_EXIT_DIALOG, false);
        getIntent().putExtra("locate_type", i);
        getIntent().putExtra(INFO, str);
        setRequestCode(i2);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public LoginActivityConfig(Context context, String str, boolean z, boolean z2) {
        super(context);
        getIntent().putExtra(ACCOUNT, str);
        getIntent().putExtra(HAS_EXIT_DIALOG, z);
        if (z2) {
            getIntent().setFlags(268435456);
        }
    }

    public LoginActivityConfig(Context context, String str, boolean z) {
        super(context);
        getIntent().putExtra(ACCOUNT, str);
        getIntent().putExtra(HAS_EXIT_DIALOG, z);
    }

    public LoginActivityConfig(Context context, String str, boolean z, int i) {
        super(context);
        getIntent().putExtra(HAS_EXIT_DIALOG, false);
        getIntent().putExtra(INFO, str);
        getIntent().putExtra(CLOSE, z);
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public LoginActivityConfig(Context context, String str) {
        super(context);
        getIntent().putExtra(ACCOUNT, str);
        getIntent().putExtra(HAS_EXIT_DIALOG, false);
    }

    public LoginActivityConfig(Context context, int i) {
        super(context);
        getIntent().putExtra(LOGIN_TYPE, i);
        getIntent().putExtra(HAS_EXIT_DIALOG, false);
    }

    public LoginActivityConfig(Context context) {
        super(context);
        getIntent().putExtra(HAS_EXIT_DIALOG, false);
    }
}
