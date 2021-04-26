package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class EmotionPackageDetailActivityConfig extends IntentConfig {
    public static final String PCK_ID_KEY = "pck_id";

    public EmotionPackageDetailActivityConfig(Context context, int i2, int i3) {
        super(context);
        getIntent().putExtra("pck_id", i2);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i3);
    }
}
