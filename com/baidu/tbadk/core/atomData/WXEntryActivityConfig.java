package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class WXEntryActivityConfig extends IntentConfig {
    public WXEntryActivityConfig(Context context, int i) {
        super(context);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i);
    }
}
