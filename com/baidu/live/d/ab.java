package com.baidu.live.d;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes4.dex */
public class ab extends IntentConfig {
    public ab(Context context) {
        super(context);
    }

    public void am(String str, String str2) {
        getIntent().putExtra("live_id", str);
        getIntent().putExtra("room_id", str2);
    }

    public void gu(String str) {
        getIntent().putExtra("user_key", str);
    }
}
