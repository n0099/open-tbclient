package com.baidu.live.tbadk.core.atomdata;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes7.dex */
public class AlaLiveCategoryActivityConfig extends IntentConfig {
    public AlaLiveCategoryActivityConfig(Context context, String str, String str2) {
        super(context);
        getIntent().putExtra("cat1_id", str);
        getIntent().putExtra("cat2_id", str2);
    }
}
