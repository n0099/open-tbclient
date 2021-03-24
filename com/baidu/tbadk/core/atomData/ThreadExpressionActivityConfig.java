package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class ThreadExpressionActivityConfig extends IntentConfig {
    public static final String IS_HOST = "is_host";
    public static final String IS_LIKED = "is_liked";

    public ThreadExpressionActivityConfig(Context context, String str, boolean z, int i, boolean z2, String str2, String str3, long j) {
        super(context);
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
        getIntent().putExtra("thread_id", str);
        getIntent().putExtra(IS_HOST, z);
        getIntent().putExtra(IS_LIKED, z2);
        getIntent().putExtra("portrait", str3);
        getIntent().putExtra("user_id", str2);
        getIntent().putExtra("forum_id", j);
    }
}
