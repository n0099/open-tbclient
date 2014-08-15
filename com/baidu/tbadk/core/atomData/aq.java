package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
/* loaded from: classes.dex */
public class aq extends com.baidu.tbadk.core.frameworkData.a {
    public aq(Context context, int i, String str, int i2) {
        super(context);
        getIntent().putExtra("has_exit_dialog", false);
        getIntent().putExtra("locate_type", i);
        getIntent().putExtra("info", str);
        setRequestCode(i2);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public aq(Context context, String str, boolean z, boolean z2) {
        super(context);
        getIntent().putExtra("account", str);
        getIntent().putExtra("has_exit_dialog", z);
        if (z2) {
            getIntent().setFlags(268435456);
        }
    }
}
