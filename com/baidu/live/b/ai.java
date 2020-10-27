package com.baidu.live.b;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes4.dex */
public class ai extends IntentConfig {
    public ai(Context context, String str, String str2, String str3, String str4) {
        super(context);
        getIntent().putExtra("red_packet_id", str);
        getIntent().putExtra("live_id", str2);
        getIntent().putExtra("anchor_uk", str3);
        getIntent().putExtra("room_id", str4);
    }
}
