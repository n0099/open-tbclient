package com.baidu.live.d;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes11.dex */
public class p extends IntentConfig {
    public p(Context context, long j) {
        super(context);
        getIntent().putExtra("live_id", j);
    }
}
