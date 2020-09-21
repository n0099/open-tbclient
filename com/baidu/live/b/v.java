package com.baidu.live.b;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes4.dex */
public class v extends IntentConfig {
    public v(Context context, boolean z, String str, int i) {
        super(context);
        getIntent().putExtra("follow", z);
        getIntent().putExtra("user_id", str);
        getIntent().putExtra("user_sex", i);
    }
}
