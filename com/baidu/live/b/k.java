package com.baidu.live.b;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes4.dex */
public class k extends IntentConfig {
    public k(Context context, String str, String str2) {
        super(context);
        getIntent().putExtra("charm_value", str2);
        getIntent().putExtra("user_id", str);
    }
}
