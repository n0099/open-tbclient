package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class LoginActivityConfig extends IntentConfig {
    public static final String JUMP_AFTER_DESTROY = "jump_after_destroy";
    public static final int JUMP_TO_MAINTAB = 1;
    public static final String USER_INFO_CHANGED = "user_info_changed";
    public static long lastStartActivityTime = 0;

    public LoginActivityConfig(Context context, int i) {
        super(context);
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public LoginActivityConfig(Context context, boolean z, int i) {
        super(context);
        getIntent().putExtra(IntentConfig.CLOSE, z);
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public LoginActivityConfig(Context context) {
        super(context);
    }

    public LoginActivityConfig(Context context, boolean z) {
        super(context);
        getIntent().putExtra(IntentConfig.CLOSE, z);
    }

    public void setJumpToAfterDestroy(int i) {
        getIntent().putExtra(JUMP_AFTER_DESTROY, i);
    }

    public static boolean canStartActivity() {
        CustomResponsedMessage runTask;
        if (System.currentTimeMillis() - lastStartActivityTime < 1000 || (runTask = MessageManager.getInstance().runTask(2921352, (Class) null)) == null) {
            return false;
        }
        return ((Boolean) runTask.getData()).booleanValue();
    }
}
