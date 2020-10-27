package com.baidu.live.b;

import android.content.Context;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes4.dex */
public class af extends IntentConfig {
    public af(Context context, String str, String str2) {
        super(context);
        getIntent().putExtra(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, str);
        getIntent().putExtra("groupid", str2);
    }
}
