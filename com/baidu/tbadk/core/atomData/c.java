package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
/* loaded from: classes.dex */
public class c extends com.baidu.tbadk.core.frameworkData.a {
    public c(Context context, int i, boolean z) {
        super(context);
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
        getIntent().putExtra(com.baidu.tbadk.core.frameworkData.a.IS_NEED_MULTIPLE, z);
        if (i == 12011) {
            getIntent().putExtra(com.baidu.tbadk.core.frameworkData.a.SHOW_KEYBOARD, false);
        }
    }
}
