package com.baidu.live.tbadk.core.atomdata;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes10.dex */
public class AlaLiveTagActivityConfig extends IntentConfig {
    public AlaLiveTagActivityConfig(Context context, String str, String str2) {
        super(context);
        getIntent().putExtra("anchor_id", str);
        getIntent().putExtra("live_id", str2);
    }
}
