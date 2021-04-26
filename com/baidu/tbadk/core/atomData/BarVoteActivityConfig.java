package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class BarVoteActivityConfig extends IntentConfig {
    public static final String FID = "fid";
    public static final String SOURCE = "source";

    public BarVoteActivityConfig(Context context) {
        super(context);
    }

    public BarVoteActivityConfig createNormalConfig(long j, int i2) {
        Intent intent = getIntent();
        intent.putExtra("fid", j);
        intent.putExtra("source", i2);
        return this;
    }
}
