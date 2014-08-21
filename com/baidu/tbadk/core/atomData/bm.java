package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.pluginArch.bean.ConfigInfos;
/* loaded from: classes.dex */
public class bm extends com.baidu.tbadk.core.frameworkData.a {
    public bm(Context context, ConfigInfos.PluginConfig pluginConfig) {
        super(context);
        getIntent().putExtra("plugin_config", pluginConfig);
    }

    public bm(Context context, ConfigInfos.PluginConfig pluginConfig, int i) {
        this(context, pluginConfig);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i);
    }
}
