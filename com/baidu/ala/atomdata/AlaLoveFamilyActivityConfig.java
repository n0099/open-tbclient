package com.baidu.ala.atomdata;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class AlaLoveFamilyActivityConfig extends IntentConfig {
    public static final String AUTHOR_LIVE_USER_ID = "author_live_user_id";

    public AlaLoveFamilyActivityConfig(Context context, String str) {
        super(context);
        getIntent().putExtra("author_live_user_id", str);
    }
}
