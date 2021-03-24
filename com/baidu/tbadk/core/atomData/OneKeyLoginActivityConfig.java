package com.baidu.tbadk.core.atomData;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class OneKeyLoginActivityConfig extends IntentConfig {
    public OneKeyLoginActivityConfig(Context context, @NonNull String str) {
        super(context);
        getIntent().putExtra(LoginDialogActivityConfig.SHARE_MODEL_JSON_STRING, str);
        setRequestCode(25059);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public OneKeyLoginActivityConfig(Context context, @NonNull String str, @NonNull String str2, @NonNull String str3) {
        super(context);
        getIntent().putExtra(LoginDialogActivityConfig.ONE_KEY_LOGIN_ENCRYPT_PHONE_NUM, str);
        getIntent().putExtra(LoginDialogActivityConfig.ONE_KEY_LOGIN_OPERATOR, str2);
        getIntent().putExtra(LoginDialogActivityConfig.ONE_KEY_LOGIN_SIGN, str3);
        setRequestCode(25059);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
