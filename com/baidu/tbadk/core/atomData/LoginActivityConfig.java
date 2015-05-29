package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.c;
/* loaded from: classes.dex */
public class LoginActivityConfig extends c {
    public static final String ACCOUNT = "account";
    public static final String FROM_SHARE_SDK = "from_share_sdk";
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
        getIntent().putExtra(c.CLOSE, z);
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public LoginActivityConfig(Context context, String str, int i) {
        super(context);
        getIntent().putExtra(HAS_EXIT_DIALOG, false);
        getIntent().putExtra("from", str);
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

    public LoginActivityConfig(Context context, boolean z) {
        super(context);
        getIntent().putExtra(HAS_EXIT_DIALOG, false);
        getIntent().putExtra(c.CLOSE, z);
    }

    public LoginActivityConfig(Context context, int i, boolean z) {
        super(context);
        getIntent().putExtra("from", i);
        getIntent().putExtra(HAS_EXIT_DIALOG, false);
        getIntent().putExtra(c.CLOSE, z);
    }

    public LoginActivityConfig(Context context, int i, boolean z, int i2) {
        super(context);
        getIntent().putExtra("from", i);
        getIntent().putExtra(HAS_EXIT_DIALOG, false);
        getIntent().putExtra(c.CLOSE, z);
        setRequestCode(i2);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
