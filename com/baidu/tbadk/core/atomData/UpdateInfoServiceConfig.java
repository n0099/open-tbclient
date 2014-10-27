package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class UpdateInfoServiceConfig extends a {
    public int type;

    public UpdateInfoServiceConfig(Context context) {
        super(context);
        setIntentAction(IntentAction.StartService);
    }
}
