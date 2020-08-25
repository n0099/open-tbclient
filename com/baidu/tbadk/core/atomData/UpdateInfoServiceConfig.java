package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes2.dex */
public class UpdateInfoServiceConfig extends IntentConfig {
    public int type;

    public UpdateInfoServiceConfig(Context context) {
        super(context);
        setIntentAction(IntentAction.StartService);
    }
}
