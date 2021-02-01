package com.baidu.adp.plugin.install;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.kwad.sdk.collector.AppStatusRules;
/* loaded from: classes.dex */
public class PluginInstallTask extends OrmObject {
    protected boolean Tf;
    protected long Tg;
    protected String apkFilePath;
    protected String pkgName;

    public long oL() {
        return Math.max(Math.min(this.Tg * 80, 240000L), (long) AppStatusRules.DEFAULT_GRANULARITY);
    }
}
