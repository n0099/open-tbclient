package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class PersonalTalkSettingActivityConfig extends a {
    public PersonalTalkSettingActivityConfig(Context context, long j) {
        super(context);
        getIntent().addFlags(268435456);
        getIntent().putExtra("userId", j);
    }
}
