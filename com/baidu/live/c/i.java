package com.baidu.live.c;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes2.dex */
public class i extends IntentConfig {
    public i(Context context, String str, String str2) {
        super(context);
        getIntent().putExtra("charm_value", str2);
        getIntent().putExtra("user_id", str);
    }
}
