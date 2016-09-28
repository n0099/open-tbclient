package com.baidu.tbadk.core.atomData;

import android.content.Context;
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
}
