package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class CommonEmotionManagerActivityConfig extends IntentConfig {
    public static final String PARAM_URL = "url";

    public CommonEmotionManagerActivityConfig(Context context, String str) {
        super(context);
        getIntent().putExtra("url", str);
    }
}
