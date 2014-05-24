package com.baidu.tbadk.core.service;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.tbplugin.PluginsConfig;
import com.baidu.tbadk.tbplugin.m;
/* loaded from: classes.dex */
class a extends c {
    final /* synthetic */ PluginDownloadService a;
    private final /* synthetic */ PluginsConfig.PluginConfig c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PluginDownloadService pluginDownloadService, PluginDownloadService pluginDownloadService2, PluginsConfig.PluginConfig pluginConfig) {
        super(pluginDownloadService, null, null);
        this.a = pluginDownloadService2;
        this.c = pluginConfig;
    }

    @Override // com.baidu.tbadk.core.service.c, com.baidu.tbadk.download.a
    public void a(DownloadData downloadData) {
        super.a(downloadData);
        BdLog.d("install file plugin");
        new com.baidu.tbadk.tbplugin.f(this.a, m.a().a(this.c.name), downloadData.getPath(), this.a).a();
    }
}
