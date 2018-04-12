package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.sina.weibo.sdk.constant.WBConstants;
/* loaded from: classes.dex */
public class FrsGameCommentActivityConfig extends IntentConfig {
    public FrsGameCommentActivityConfig(Context context, int i, int i2) {
        super(context);
        getIntent().putExtra(WBConstants.GAME_PARAMS_SCORE, i);
        getIntent().putExtra("forum_id", i2);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(21002);
    }
}
