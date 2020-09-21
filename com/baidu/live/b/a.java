package com.baidu.live.b;

import android.content.Context;
import com.baidu.ala.atomdata.AlaAdminListActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes4.dex */
public class a extends IntentConfig {
    public a(Context context, String str) {
        super(context);
        getIntent().putExtra(AlaAdminListActivityConfig.ALA_LIVE_CUR_LIVE_ID, str);
    }
}
