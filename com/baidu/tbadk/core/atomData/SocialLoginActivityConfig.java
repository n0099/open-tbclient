package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class SocialLoginActivityConfig extends IntentConfig {
    public static final String RESULT_CODE = "result_code";
    public static final String RESULT_MSG = "result_msg";
    public static final String SOCIAL_TYPE = "socialType";

    public SocialLoginActivityConfig(Context context, SocialType socialType, int i) {
        super(context);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i);
        getIntent().putExtra(SOCIAL_TYPE, socialType);
    }
}
