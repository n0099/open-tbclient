package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class PersonPolymericActivityConfig extends IntentConfig {
    public static final String IS_BIGV = "is_bigv";
    public static final String IS_SHOW_THREAD_TOP = "is_show_thread_top";
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

    public PersonPolymericActivityConfig createNormalConfig(long j, boolean z, boolean z2, boolean z3) {
        Intent intent = getIntent();
        intent.putExtra("user_id", j);
        intent.putExtra(IS_USER_SELF, z);
        intent.putExtra(IS_BIGV, z2);
        intent.putExtra(IS_SHOW_THREAD_TOP, z3);
        return this;
    }

    public void setSourceTid(String str) {
        getIntent().putExtra("thread_id", str);
    }

    public void setSourceNid(String str) {
        getIntent().putExtra(IntentConfig.NID, str);
    }

    @Override // com.baidu.tbadk.core.frameworkData.IntentConfig
    public boolean asynStart() {
        return false;
    }

    public void setUri(Uri uri) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra(IntentConfig.KEY_URI, uri);
        }
    }
}
