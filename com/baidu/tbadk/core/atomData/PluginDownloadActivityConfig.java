package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class PluginDownloadActivityConfig extends IntentConfig {
    public static final String PLUGIN_CONFIG = "plugin_config";

    public PluginDownloadActivityConfig(Context context, PluginNetConfigInfos.PluginConfig pluginConfig) {
        super(context);
        getIntent().putExtra(PLUGIN_CONFIG, pluginConfig);
    }

    public PluginDownloadActivityConfig(Context context, PluginNetConfigInfos.PluginConfig pluginConfig, int i) {
        this(context, pluginConfig);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i);
    }
}
