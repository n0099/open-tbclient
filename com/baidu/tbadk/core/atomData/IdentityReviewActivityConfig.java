package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class IdentityReviewActivityConfig extends IntentConfig {
    public static final String FID = "fid";
    public static final String KEY_IS_START_FOR_RESULT = "key_is_start_for_result";

    public IdentityReviewActivityConfig(Context context, long j) {
        super(context);
        getIntent().putExtra("fid", j);
    }

    public IdentityReviewActivityConfig(Context context, long j, int i) {
        super(context);
        Intent intent = getIntent();
        intent.putExtra("fid", j);
        intent.putExtra(KEY_IS_START_FOR_RESULT, true);
        intent.putExtra("request_code", i);
    }
}
