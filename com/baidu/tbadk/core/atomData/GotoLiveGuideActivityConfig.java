package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes2.dex */
public class GotoLiveGuideActivityConfig extends IntentConfig {
    private final Context mContext;

    public GotoLiveGuideActivityConfig(Context context) {
        super(context);
        this.mContext = context;
    }

    public GotoLiveGuideActivityConfig(Context context, int i, String str) {
        super(context);
        this.mContext = context;
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
        getIntent().putExtra("from", str);
    }
}
