package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.ala.ILoginListener;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.a.m0.r.z.a;
/* loaded from: classes3.dex */
public class LoginActivityConfig extends IntentConfig {
    public static final String ACTIVITY_ID = "activity_id";
    public static final String CUSTOM_LOGIN_CSS_URL = "custom_login_css_url";
    public static final String IS_FROM_AIAPP = "is_from_aiapp";
    public static final String JUMP_AFTER_DESTROY = "jump_after_destroy";
    public static final int JUMP_TO_MAINTAB = 1;
    public static final String LOGIN_DIALOG_LOGIN_LISTENER = "login_dialog_login_listener";
    public static final String SOCIAL_TYPE = "social_type";
    public static final String URL = "url";
    public static final String USER_INFO_CHANGED = "user_info_changed";
    public static long lastStartActivityTime;

    public LoginActivityConfig(Context context, int i2) {
        this(context);
        setRequestCode(i2);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public static boolean canStartActivity() {
        CustomResponsedMessage runTask;
        if (System.currentTimeMillis() - lastStartActivityTime < 1000 || (runTask = MessageManager.getInstance().runTask(2921352, (Class) null)) == null) {
            return false;
        }
        return ((Boolean) runTask.getData()).booleanValue();
    }

    public void setIsFromAiapp(boolean z) {
        getIntent().putExtra(IS_FROM_AIAPP, z);
    }

    public void setJumpToAfterDestroy(int i2) {
        getIntent().putExtra(JUMP_AFTER_DESTROY, i2);
    }

    public void setLoginListener(ILoginListener iLoginListener) {
        if (iLoginListener != null) {
            getIntent().putExtra("login_dialog_login_listener", iLoginListener);
        }
    }

    public void setThirdPartyLoginForResult(int i2, String str) {
        getIntent().putExtra("social_type", i2);
        getIntent().putExtra("activity_id", str);
        setRequestCode(11043);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public void setUrl(String str) {
        getIntent().putExtra("url", str);
    }

    public LoginActivityConfig(Context context, boolean z, int i2) {
        this(context);
        getIntent().putExtra(IntentConfig.CLOSE, z);
        setRequestCode(i2);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public LoginActivityConfig(Context context) {
        super(context);
        a.a("account", -1L, 0, context.getClass().toString(), 0, "", new Object[0]);
    }

    public LoginActivityConfig(Context context, boolean z) {
        this(context);
        getIntent().putExtra(IntentConfig.CLOSE, z);
    }

    public LoginActivityConfig(Context context, boolean z, String str, String str2) {
        this(context);
        getIntent().putExtra(IntentConfig.CLOSE, z);
        getIntent().putExtra("url", str);
        getIntent().putExtra(CUSTOM_LOGIN_CSS_URL, str2);
    }
}
