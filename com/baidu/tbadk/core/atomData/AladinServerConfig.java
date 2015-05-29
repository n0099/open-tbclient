package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.c;
/* loaded from: classes.dex */
public class AladinServerConfig extends c {
    public AladinServerConfig(Context context) {
        super(context);
        setIntentAction(IntentAction.StartService);
    }
}
