package com.baidu.live.c;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentAction;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes3.dex */
public class k extends IntentConfig {
    public k(Context context, int i, int i2) {
        super(context);
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
        getIntent().putExtra("item_count", i2);
    }
}
