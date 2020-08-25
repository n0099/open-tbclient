package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes2.dex */
public class SyncServiceConfig extends IntentConfig {
    public SyncServiceConfig(Context context) {
        super(context);
        setIntentAction(IntentAction.StartService);
    }
}
