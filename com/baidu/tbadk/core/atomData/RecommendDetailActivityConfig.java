package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes2.dex */
public class RecommendDetailActivityConfig extends IntentConfig {
    public static final String USER_ID = "user_id";
    public static final String USER_NAME = "user_name";

    public RecommendDetailActivityConfig(Context context, String str, long j) {
        super(context);
        getIntent().putExtra("user_name", str);
        getIntent().putExtra("user_id", j);
    }
}
