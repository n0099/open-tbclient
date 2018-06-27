package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.ar.paddle.PaddleController;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class FrsGameCommentActivityConfig extends IntentConfig {
    public FrsGameCommentActivityConfig(Context context, int i, int i2) {
        super(context);
        getIntent().putExtra(PaddleController.SDK_TO_LUA_GESTURE_RESULT_SCORE, i);
        getIntent().putExtra("forum_id", i2);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(21002);
    }
}
