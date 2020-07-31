package com.baidu.live.c;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentAction;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes4.dex */
public class l extends IntentConfig {
    public l(Context context, int i, int i2) {
        super(context);
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
        getIntent().putExtra("item_count", i2);
    }
}
