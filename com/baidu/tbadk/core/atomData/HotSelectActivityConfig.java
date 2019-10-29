package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class HotSelectActivityConfig extends IntentConfig {
    public static int FROM_PB = 1;
    public static int FROM_POST_THREAD = 2;
    public static String HOT_TOPIC_SING = "#";

    public HotSelectActivityConfig(Context context, int i, int i2) {
        super(context);
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
        getIntent().putExtra("from", i2);
    }

    public void setForumExtra(long j, String str, String str2) {
        Intent intent = getIntent();
        intent.putExtra("forum_id", j);
        intent.putExtra("forum_first_dir", str);
        intent.putExtra("forum_second_dir", str2);
    }
}
