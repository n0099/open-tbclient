package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class PersonListActivityConfig extends IntentConfig {
    public static final String FOLLOW = "follow";
    public static final String TOTLEFOLLOWNUM = "total_follow_num";

    public PersonListActivityConfig(Context context, boolean z, String str, int i2) {
        super(context);
        getIntent().putExtra("follow", z);
        getIntent().putExtra("user_id", str);
        getIntent().putExtra("user_sex", i2);
    }

    public PersonListActivityConfig updateBjhUser(boolean z) {
        if (getIntent() != null) {
            getIntent().putExtra(IntentConfig.IS_BJH_USER, z);
        }
        return this;
    }

    public PersonListActivityConfig updateFollowNum(int i2, String str) {
        if (getIntent() != null) {
            getIntent().putExtra("total_follow_num", i2);
            getIntent().putExtra("portrait", str);
        }
        return this;
    }
}
