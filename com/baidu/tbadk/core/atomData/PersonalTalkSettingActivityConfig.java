package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class PersonalTalkSettingActivityConfig extends IntentConfig {
    public PersonalTalkSettingActivityConfig(Context context, long j) {
        super(context);
        getIntent().addFlags(268435456);
        getIntent().putExtra("userId", j);
    }
}
