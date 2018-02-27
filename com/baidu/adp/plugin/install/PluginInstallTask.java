package com.baidu.adp.plugin.install;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
/* loaded from: classes.dex */
public class PluginInstallTask extends OrmObject {
    protected String apH;
    protected String apkFilePath;
    protected boolean aqi;
    protected long aqj;

    public long qm() {
        return Math.max(Math.min(this.aqj * 80, 240000L), 60000L);
    }
}
