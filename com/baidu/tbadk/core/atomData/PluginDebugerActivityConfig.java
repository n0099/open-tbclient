package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class PluginDebugerActivityConfig extends IntentConfig {
    public PluginDebugerActivityConfig() {
    }

    public PluginDebugerActivityConfig(Context context) {
        super(context);
    }

    public PluginDebugerActivityConfig(Context context, String str) {
        super(context);
        getIntent().putExtra(IntentConfig.DATAS, str);
    }
}
