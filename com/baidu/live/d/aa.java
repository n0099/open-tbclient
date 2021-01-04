package com.baidu.live.d;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes11.dex */
public class aa extends IntentConfig {
    public aa(Context context) {
        super(context);
    }

    public void al(String str, String str2) {
        getIntent().putExtra("live_id", str);
        getIntent().putExtra("room_id", str2);
    }

    public void gd(String str) {
        getIntent().putExtra("user_key", str);
    }
}
