package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class QALoginActivityConfig extends IntentConfig {
    public QALoginActivityConfig(Context context, boolean z) {
        super(context);
        getIntent().putExtra("close", z);
    }

    public QALoginActivityConfig(Context context, boolean z, int i) {
        super(context);
        getIntent().putExtra("close", z);
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
