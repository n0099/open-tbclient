package com.baidu.live.c;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes4.dex */
public class s extends IntentConfig {
    public s(Context context, String str, String str2, String str3) {
        super(context);
        getIntent().putExtra("red_packet_id", str);
        getIntent().putExtra("live_id", str2);
        getIntent().putExtra("anchor_id", str3);
    }
}
