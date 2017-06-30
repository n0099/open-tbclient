package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class PersonPolymericActivityConfig extends IntentConfig {
    public static final String IS_BIGV = "is_bigv";
    public static final String IS_USER_SELF = "is_user_self";
    public static final String RESOURCE_TYPE = "resouce_type";

    public PersonPolymericActivityConfig(Context context) {
        super(context);
    }

    public PersonPolymericActivityConfig createNormalConfig(long j, boolean z, boolean z2) {
        Intent intent = getIntent();
        intent.putExtra("user_id", j);
        intent.putExtra(IS_USER_SELF, z);
        intent.putExtra(IS_BIGV, z2);
        return this;
    }

    @Override // com.baidu.tbadk.core.frameworkData.IntentConfig
    public boolean asynStart() {
        return false;
    }
}
