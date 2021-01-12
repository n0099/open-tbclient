package com.baidu.live.d;

import android.content.Context;
import com.baidu.ala.atomdata.AlaAdminListActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes10.dex */
public class g extends IntentConfig {
    public g(Context context) {
        super(context);
    }

    public void a(long j, long j2, long j3, boolean z, boolean z2) {
        getIntent().putExtra(AlaAdminListActivityConfig.ALA_LIVE_CUR_LIVE_ID, j);
        getIntent().putExtra("ala_live_cur_anchor_id", j2);
        getIntent().putExtra("ala_live_cur_user_id", j3);
        getIntent().putExtra("ala_live_cur_is_host", z);
        getIntent().putExtra("ala_live_cur_is_landscape", z2);
    }
}
