package com.baidu.ala.atomdata;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes10.dex */
public class AlaAdminListActivityConfig extends IntentConfig {
    public static final String ALA_LIVE_CUR_LIVE_ID = "ala_live_cur_live_id";

    public AlaAdminListActivityConfig(Context context, String str) {
        super(context);
        getIntent().putExtra(ALA_LIVE_CUR_LIVE_ID, str);
    }
}
