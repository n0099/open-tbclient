package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class FrsGameCommentActivityConfig extends IntentConfig {
    public FrsGameCommentActivityConfig(Context context, int i, int i2) {
        super(context);
        getIntent().putExtra("score", i);
        getIntent().putExtra("forum_id", i2);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(RequestResponseCode.START_GAME_COMMENT_REQUEST_CODE);
    }
}
