package com.baidu.live.d;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes10.dex */
public class aj extends IntentConfig {
    public aj(Context context, String str, String str2, String str3, String str4, long j) {
        super(context);
        getIntent().putExtra("red_packet_id", str);
        getIntent().putExtra("live_id", str2);
        getIntent().putExtra("anchor_uk", str3);
        getIntent().putExtra("room_id", str4);
        getIntent().putExtra("time", j);
    }
}
