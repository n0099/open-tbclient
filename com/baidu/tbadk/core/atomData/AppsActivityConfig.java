package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class AppsActivityConfig extends IntentConfig {
    public AppsActivityConfig(Context context, String str) {
        super(context);
        getIntent().putExtra("url", str);
    }
}
