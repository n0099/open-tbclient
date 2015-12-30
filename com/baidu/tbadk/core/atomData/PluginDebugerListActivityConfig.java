package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class PluginDebugerListActivityConfig extends IntentConfig {
    public PluginDebugerListActivityConfig() {
    }

    public PluginDebugerListActivityConfig(Context context) {
        super(context);
    }

    public PluginDebugerListActivityConfig(Context context, String str) {
        super(context);
        getIntent().putExtra(IntentConfig.DATAS, str);
    }
}
