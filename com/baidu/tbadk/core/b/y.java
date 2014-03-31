package com.baidu.tbadk.core.b;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
/* loaded from: classes.dex */
public class y extends com.baidu.tbadk.core.frameworkData.a {
    public y(Context context, int i, String str, int i2) {
        super(context);
        d().putExtra("has_exit_dialog", false);
        d().putExtra("locate_type", i);
        d().putExtra("info", str);
        a(11003);
        a(IntentAction.ActivityForResult);
    }

    public y(Context context, String str, boolean z, boolean z2) {
        super(context);
        d().putExtra("account", str);
        d().putExtra("has_exit_dialog", false);
        d().setFlags(268435456);
    }
}
