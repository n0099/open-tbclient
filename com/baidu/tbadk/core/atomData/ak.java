package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentAction;
/* loaded from: classes.dex */
public class ak extends com.baidu.tbadk.core.frameworkData.a {
    public static boolean a = true;
    public static boolean b = false;

    public ak(Context context, Intent intent) {
        super(context);
        a = true;
        b = true;
        setIntentAction(IntentAction.Activity);
        if (!(context instanceof Activity)) {
            getIntent().setFlags(268435456);
        }
        if (intent != null) {
            getIntent().putExtra("extra_intent", intent);
        }
        getIntent().addCategory("android.intent.category.LAUNCHER");
        getIntent().setAction("android.intent.action.MAIN");
    }

    public ak(Context context, boolean z) {
        super(context);
        a = true;
        b = z;
        setIntentAction(IntentAction.Activity);
        if (!(context instanceof Activity)) {
            getIntent().setFlags(268435456);
        }
        getIntent().addCategory("android.intent.category.LAUNCHER");
        getIntent().setAction("android.intent.action.MAIN");
    }
}
