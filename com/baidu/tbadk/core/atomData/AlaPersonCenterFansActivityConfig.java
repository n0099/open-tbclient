package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class AlaPersonCenterFansActivityConfig extends IntentConfig {
    public static final String ACTIVITY_TYPE = "activity_type";
    public static final String USER_ID = "user_id";

    public AlaPersonCenterFansActivityConfig(Context context, String str, int i2) {
        super(context);
        getIntent().putExtra("user_id", str);
        getIntent().putExtra(ACTIVITY_TYPE, i2);
    }
}
