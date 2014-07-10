package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.tbplugin.PluginsConfig;
/* loaded from: classes.dex */
public class be extends com.baidu.tbadk.core.frameworkData.a {
    public be(Context context, PluginsConfig.PluginConfig pluginConfig) {
        super(context);
        getIntent().putExtra("plugin_config", pluginConfig);
    }
}
