package com.baidu.adp.plugin.install;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.kwad.sdk.collector.AppStatusRules;
/* loaded from: classes.dex */
public class PluginInstallTask extends OrmObject {
    protected boolean Tj;
    protected long Tk;
    protected String apkFilePath;
    protected String pkgName;

    public long oN() {
        return Math.max(Math.min(this.Tk * 80, 240000L), (long) AppStatusRules.DEFAULT_GRANULARITY);
    }
}
