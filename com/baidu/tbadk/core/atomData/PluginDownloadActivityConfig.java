package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.a;
import com.baidu.tbadk.pluginArch.bean.ConfigInfos;
/* loaded from: classes.dex */
public class PluginDownloadActivityConfig extends a {
    public static final String PLUGIN_CONFIG = "plugin_config";

    public PluginDownloadActivityConfig(Context context, ConfigInfos.PluginConfig pluginConfig) {
        super(context);
        getIntent().putExtra(PLUGIN_CONFIG, pluginConfig);
    }

    public PluginDownloadActivityConfig(Context context, ConfigInfos.PluginConfig pluginConfig, int i) {
        this(context, pluginConfig);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i);
    }
}
