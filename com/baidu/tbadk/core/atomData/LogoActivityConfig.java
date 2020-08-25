package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes2.dex */
public class LogoActivityConfig extends IntentConfig {
    public static final String EXTRAINTENT = "extra_intent";
    public static boolean isFirst = true;
    public static boolean mFromSpacial = false;

    public LogoActivityConfig(Context context, Intent intent) {
        super(context);
        isFirst = true;
        mFromSpacial = true;
        setIntentAction(IntentAction.Activity);
        if (!(context instanceof Activity)) {
            getIntent().setFlags(268435456);
        }
        if (intent != null) {
            getIntent().putExtra(EXTRAINTENT, intent);
        }
        getIntent().addCategory("android.intent.category.LAUNCHER");
        getIntent().setAction("android.intent.action.MAIN");
    }

    public LogoActivityConfig(Context context, boolean z) {
        super(context);
        isFirst = true;
        mFromSpacial = z;
        setIntentAction(IntentAction.Activity);
        if (!(context instanceof Activity)) {
            getIntent().setFlags(268435456);
        }
        getIntent().addCategory("android.intent.category.LAUNCHER");
        getIntent().setAction("android.intent.action.MAIN");
    }
}
