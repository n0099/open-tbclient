package com.baidu.live.tbadk.core.atomdata;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
@Deprecated
/* loaded from: classes7.dex */
public class AlaLiveReplayActivityConfig extends IntentConfig {
    public static final String LIVE_ID = "live_id";
    public static final String USER_ID = "user_id";

    public AlaLiveReplayActivityConfig(Context context, String str, String str2) {
        super(context);
        getIntent().putExtra("live_id", str);
        getIntent().putExtra("user_id", str2);
    }
}
