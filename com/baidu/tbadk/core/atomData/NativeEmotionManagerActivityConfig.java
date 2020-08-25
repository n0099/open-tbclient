package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes2.dex */
public class NativeEmotionManagerActivityConfig extends IntentConfig {
    public static final String KEY = "is_bazhu";

    public NativeEmotionManagerActivityConfig(Context context, int i) {
        super(context);
        getIntent().putExtra(KEY, i);
    }
}
