package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
/* loaded from: classes.dex */
public class bt extends com.baidu.tbadk.core.frameworkData.a {
    public bt(Context context, int i) {
        super(context);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i);
    }
}
