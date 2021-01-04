package com.baidu.live.d;

import android.content.Context;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes11.dex */
public class ag extends IntentConfig {
    public ag(Context context, String str, String str2) {
        super(context);
        getIntent().putExtra(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, str);
        getIntent().putExtra("groupid", str2);
    }
}
