package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.c;
/* loaded from: classes.dex */
public class AtListActivityConfig extends c {
    public AtListActivityConfig(Context context, int i, boolean z) {
        super(context);
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
        getIntent().putExtra(c.IS_NEED_MULTIPLE, z);
        if (i == 12011) {
            getIntent().putExtra(c.SHOW_KEYBOARD, false);
        }
    }
}
