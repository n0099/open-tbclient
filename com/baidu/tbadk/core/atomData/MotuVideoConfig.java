package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class MotuVideoConfig extends IntentConfig {
    public MotuVideoConfig(Context context) {
        super(context);
        setRequestCode(13010);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
