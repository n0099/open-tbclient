package com.baidu.live.c;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentAction;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes3.dex */
public class e extends IntentConfig {
    public e(Context context, String str, int i, long j) {
        super(context);
        getIntent().putExtra("wish_id", str);
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
        getIntent().putExtra("index_id", j);
    }
}
