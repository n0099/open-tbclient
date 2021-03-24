package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class AlaFrsStoryLiveGatherActivityConfig extends IntentConfig {
    public AlaFrsStoryLiveGatherActivityConfig(Context context, String str, String str2) {
        super(context);
        setIntentAction(IntentAction.Activity);
        getIntent().putExtra("forum_id", str);
        getIntent().putExtra("forum_name", str2);
    }
}
