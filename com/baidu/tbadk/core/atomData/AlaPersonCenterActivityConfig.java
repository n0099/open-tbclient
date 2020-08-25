package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes2.dex */
public class AlaPersonCenterActivityConfig extends IntentConfig {
    public static final String IS_SELF = "is_self";
    public static final String KEY_SEX = "key_sex";
    public static final String KEY_USER_NAME = "user_name";
    public static final String PORTRAIT_URL = "key_protrait";
    public static final String USER_ID = "user_id";

    public AlaPersonCenterActivityConfig(Context context, String str, String str2, String str3, int i, boolean z) {
        super(context);
        getIntent().putExtra("user_id", str);
        getIntent().putExtra("user_name", str2);
        getIntent().putExtra(PORTRAIT_URL, str3);
        getIntent().putExtra(IS_SELF, z);
    }
}
