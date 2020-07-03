package com.baidu.live.tbadk.core.atomdata;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentAction;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
@Deprecated
/* loaded from: classes3.dex */
public class SyncServiceConfig extends IntentConfig {
    public SyncServiceConfig(Context context) {
        super(context);
        setIntentAction(IntentAction.StartService);
    }
}
