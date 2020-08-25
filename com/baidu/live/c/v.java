package com.baidu.live.c;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes7.dex */
public class v extends IntentConfig {
    public v(Context context, boolean z, String str, int i) {
        super(context);
        getIntent().putExtra("follow", z);
        getIntent().putExtra("user_id", str);
        getIntent().putExtra("user_sex", i);
    }
}
