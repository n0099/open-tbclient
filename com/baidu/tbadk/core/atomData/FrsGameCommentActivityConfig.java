package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class FrsGameCommentActivityConfig extends IntentConfig {
    public FrsGameCommentActivityConfig(Context context, int i2, int i3) {
        super(context);
        getIntent().putExtra("score", i2);
        getIntent().putExtra("forum_id", i3);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(21002);
    }
}
