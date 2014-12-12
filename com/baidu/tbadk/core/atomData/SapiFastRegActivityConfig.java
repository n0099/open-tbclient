package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class SapiFastRegActivityConfig extends a {
    public SapiFastRegActivityConfig(Context context) {
        super(context);
    }

    public SapiFastRegActivityConfig(Context context, int i) {
        super(context);
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
