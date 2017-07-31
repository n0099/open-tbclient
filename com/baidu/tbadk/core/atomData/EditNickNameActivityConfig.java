package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.os.Build;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class EditNickNameActivityConfig extends IntentConfig {
    public static final String PARAM_NICKNAME = "param_nickname";
    public static final String PARAM_TYPE = "param_type";
    public static final String PARAM_URL = "param_url";
    public static final int TYPE_MODIFY_ACTIVITY = 1;
    public static final int TYPE_MODIFY_NICKNAME = 0;

    public EditNickNameActivityConfig(Context context, int i, int i2, String str) {
        super(context);
        setRequestCode(i);
        getIntent().putExtra(PARAM_TYPE, i2);
        getIntent().putExtra(PARAM_URL, str);
        setIntentAction(IntentAction.ActivityForResult);
    }

    @Override // com.baidu.tbadk.core.frameworkData.IntentConfig
    public boolean isValid() {
        if (Build.VERSION.SDK_INT >= 9) {
            return true;
        }
        UtilHelper.showToast(getContext(), getContext().getString(d.l.live_error_system_not_support));
        return false;
    }
}
