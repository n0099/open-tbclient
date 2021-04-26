package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class NativeEmotionManagerActivityConfig extends IntentConfig {
    public static final String KEY = "is_bazhu";

    public NativeEmotionManagerActivityConfig(Context context, int i2) {
        super(context);
        getIntent().putExtra(KEY, i2);
    }
}
