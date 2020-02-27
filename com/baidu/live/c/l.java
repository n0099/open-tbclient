package com.baidu.live.c;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes3.dex */
public class l extends IntentConfig {
    public l(Context context, long j) {
        super(context);
        getIntent().putExtra("live_id", j);
    }
}
