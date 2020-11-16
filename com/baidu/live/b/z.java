package com.baidu.live.b;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes4.dex */
public class z extends IntentConfig {
    public z(Context context) {
        super(context);
    }

    public void ah(String str, String str2) {
        getIntent().putExtra("live_id", str);
        getIntent().putExtra("room_id", str2);
    }

    public void fY(String str) {
        getIntent().putExtra("user_key", str);
    }
}
