package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.c;
/* loaded from: classes.dex */
public class CaptureActivityConfig extends c {
    public CaptureActivityConfig(Context context, int i) {
        super(context);
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
