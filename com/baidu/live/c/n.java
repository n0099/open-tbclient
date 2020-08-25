package com.baidu.live.c;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes7.dex */
public class n extends IntentConfig {
    public n(Context context, long j) {
        super(context);
        getIntent().putExtra("live_id", j);
    }
}
