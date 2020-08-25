package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes2.dex */
public class InterviewLiveActivityConfig extends IntentConfig {
    public static final String KEY_ANTI = "interviewlive_anti";
    public static final String KEY_FORUM_ID = "forum_id";
    public static final String KEY_FORUM_NAME = "forum_name";
    public static final String KEY_IS_GOOD = "is_good";
    public static final String KEY_IS_TOP = "is_top";
    public static final String KEY_TASK_ID = "task_id";
    public static final String KEY_THREAD_ID = "thread_id";

    public InterviewLiveActivityConfig(Context context) {
        super(context);
    }

    public InterviewLiveActivityConfig createNormalCfg(String str, String str2, String str3, String str4, int i, int i2) {
        Intent intent = getIntent();
        intent.putExtra("thread_id", str);
        intent.putExtra("task_id", str2);
        intent.putExtra("forum_id", str3);
        intent.putExtra("forum_name", str4);
        intent.putExtra("is_top", i);
        intent.putExtra("is_good", i2);
        return this;
    }
}
