package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class PluginCenterActivityConfig extends IntentConfig {
    public static final int FROM_SETTING = 0;
    public static final String KEY_FROM_TYPE = "key_from_type";

    public PluginCenterActivityConfig(Context context) {
        this(context, 0);
    }

    public PluginCenterActivityConfig(Context context, int i2) {
        super(context);
        getIntent().putExtra("key_from_type", i2);
    }
}
