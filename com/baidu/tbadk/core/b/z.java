package com.baidu.tbadk.core.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentAction;
/* loaded from: classes.dex */
public class z extends com.baidu.tbadk.core.frameworkData.a {
    public static boolean a = true;
    public static boolean b = false;

    public z(Context context, Intent intent) {
        super(context);
        a = true;
        b = true;
        a(IntentAction.Activity);
        if (!(context instanceof Activity)) {
            d().setFlags(268435456);
        }
        if (intent != null) {
            d().putExtra("extra_intent", intent);
        }
        d().addCategory("android.intent.category.LAUNCHER");
        d().setAction("android.intent.action.MAIN");
    }
}
