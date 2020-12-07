package com.baidu.live.d;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentAction;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes4.dex */
public class f extends IntentConfig {
    public f(Context context, String str, int i, long j) {
        super(context);
        getIntent().putExtra("wish_id", str);
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
        getIntent().putExtra("index_id", j);
    }
}
