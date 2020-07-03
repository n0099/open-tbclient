package com.baidu.live.c;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes3.dex */
public class t extends IntentConfig {
    public t(Context context, String str, String str2, String str3, boolean z, String str4, String str5) {
        super(context);
        getIntent().putExtra("user_id", str);
        getIntent().putExtra("group_id", str2);
        getIntent().putExtra("live_id", str3);
        getIntent().putExtra("live_owner_flag", z);
        getIntent().putExtra("live_owner_uid", str4);
        getIntent().putExtra(IntentConfig.OTHER_PARAMS, str5);
    }
}
