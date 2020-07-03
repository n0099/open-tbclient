package com.baidu.live.c;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes3.dex */
public class m extends IntentConfig {
    public m(Context context, long j) {
        super(context);
        getIntent().putExtra("live_id", j);
    }
}
