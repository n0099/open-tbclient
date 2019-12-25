package com.baidu.live.c;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes2.dex */
public class r extends IntentConfig {
    public r(Context context, boolean z, String str, int i) {
        super(context);
        getIntent().putExtra("follow", z);
        getIntent().putExtra("user_id", str);
        getIntent().putExtra("user_sex", i);
    }
}
