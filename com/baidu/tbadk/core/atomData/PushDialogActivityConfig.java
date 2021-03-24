package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes3.dex */
public class PushDialogActivityConfig extends IntentConfig {
    public static final String KEY_TASK_ID = "task_id";
    public static final String KEY_THREAD_ID = "thread_id";

    public PushDialogActivityConfig(Context context, long j, String str) {
        super(context);
        Intent intent = getIntent();
        intent.putExtra("task_id", j);
        intent.putExtra("thread_id", str);
        intent.setFlags(268435456);
        TiebaStatic.eventStat(context, "push_dialog", "before_start");
    }
}
