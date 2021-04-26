package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class GotoLiveGuideActivityConfig extends IntentConfig {
    public final Context mContext;

    public GotoLiveGuideActivityConfig(Context context) {
        super(context);
        this.mContext = context;
    }

    public GotoLiveGuideActivityConfig(Context context, int i2, String str) {
        super(context);
        this.mContext = context;
        setRequestCode(i2);
        setIntentAction(IntentAction.ActivityForResult);
        getIntent().putExtra("from", str);
    }
}
