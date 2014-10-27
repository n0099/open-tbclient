package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class SyncServiceConfig extends a {
    public SyncServiceConfig(Context context) {
        super(context);
        setIntentAction(IntentAction.StartService);
    }
}
