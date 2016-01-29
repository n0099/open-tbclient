package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class ReadPbServiceConfig extends IntentConfig {
    public ReadPbServiceConfig(Context context) {
        super(context);
        setIntentAction(IntentAction.StartService);
    }
}
