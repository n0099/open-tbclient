package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class VoicePasswordVerifyActivityConfig extends IntentConfig {
    public static final String AUTH_SID = "extra_auth_sid";
    public static final String BDUSS = "extra_bduss";
    public static final String TOKEN = "extra_auth_token";

    public VoicePasswordVerifyActivityConfig(Context context, String str, String str2, int i) {
        super(context);
        getIntent().putExtra(BDUSS, str);
        getIntent().putExtra(TOKEN, str2);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i);
    }
}
