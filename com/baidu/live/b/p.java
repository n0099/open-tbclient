package com.baidu.live.b;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes4.dex */
public class p extends IntentConfig {
    public p(Context context, long j) {
        super(context);
        getIntent().putExtra("live_id", j);
    }
}
