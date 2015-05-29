package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.c;
/* loaded from: classes.dex */
public class VoiceSettingActivityConfig extends c {
    public static final String AUTH_SID = "auth_sid";

    public VoiceSettingActivityConfig(Context context, String str, int i) {
        super(context);
        getIntent().putExtra(AUTH_SID, str);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i);
    }
}
