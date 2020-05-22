package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.data.NewUserRedPackageData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class NewUserRedPackageActivityConfig extends IntentConfig {
    public static final String KEY_DATA = "key_data";

    public NewUserRedPackageActivityConfig(Context context, NewUserRedPackageData newUserRedPackageData) {
        super(context);
        getIntent().putExtra(KEY_DATA, newUserRedPackageData);
    }
}
